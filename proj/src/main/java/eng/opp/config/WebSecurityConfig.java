package eng.opp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:db.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private Environment env;

  @Bean
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getProperty("mysql.driver"));
    dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
    dataSource.setUsername(env.getProperty("mysql.username"));
    dataSource.setPassword(env.getProperty("mysql.password"));
    return dataSource;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled"
            + " from users where username=?")
        .passwordEncoder(new BCryptPasswordEncoder());
  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().authenticated()
    .and()
    .httpBasic();
	}

}
