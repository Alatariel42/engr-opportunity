package eng.opp.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import eng.opp.domain.User;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private Environment env;

  @Bean
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getProperty("mysql.driver"));
    dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
    dataSource.setUsername(env.getProperty("mysql.username"));
    dataSource.setPassword(env.getProperty("mysql.password"));
    initData(dataSource);
    return dataSource;
  }
  
  /**
   * DB has not been fully initialized yet
   * Therefore, we must use native JDBC to execute any initialization code, rather than jdbcTemplate & services like the UserService
   * @param dataSource
   */
  private void initData(DataSource dataSource) {
	User defaultUser = new User();
	defaultUser.setUsername(env.getProperty("admin.defaultUser"));
	defaultUser.setEmail(env.getProperty("admin.defaultEmail"));
	defaultUser.setPassword(env.getProperty("admin.defaultPassword"));
	defaultUser.setRole("admin");
	try (Connection conn = dataSource.getConnection()) {
		PreparedStatement ps = conn.prepareStatement("INSERT IGNORE INTO users(username, first_name, last_name, role, password, email, enabled) values(?,?,?,?,?,?, TRUE)");
		ps.setString(1, defaultUser.getUsername());
		ps.setString(2, defaultUser.getFirstName());
		ps.setString(3, defaultUser.getLastName());
		ps.setString(4, defaultUser.getRole());
		ps.setString(5, defaultUser.getPassword());
		ps.setString(6, defaultUser.getEmail());
		ps.execute();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.jdbcAuthentication().dataSource(getDataSource())
        .usersByUsernameQuery("select username, password, enabled"
            + " from users where username=?")
        .authoritiesByUsernameQuery("select username, role as authority "
            + "from users where username=?")
        .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().and()
      .authorizeRequests()
	      .antMatchers("/web/**", "/*.js","/*.html","/*.js", "/", "/index.html").permitAll()
	      .anyRequest().authenticated()
      .and().httpBasic();
  }

}
  