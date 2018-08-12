package eng.opp.services;

import org.springframework.stereotype.Service;

import eng.opp.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class UserService {

  @Autowired
  JdbcTemplate jdbc;

  /**
  * Adds a new user to the database
  */
  public ResponseEntity<User> add(User user) {
    String sql = "INSERT INTO users(username, first_name, last_name, role, password, email, enabled) values(?,?,?,?,?,?, TRUE)";
    jdbc.update(sql, user.getUsername(), user.getFirstName(), user.getLastName(), user.getRole(), user.getPassword(), user.getEmail());
	  return new ResponseEntity<>(user, HttpStatus.OK);
  }

  /**
  * Updates a user in the database
  */
  public ResponseEntity<User> update(User user) {
    String sql = "UPDATE users SET first_name=?, last_name=?, role=?, password=?, email=? WHERE username=?";
    jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getRole(), user.getPassword(), user.getEmail(), user.getUsername());
	  return new ResponseEntity<>(user, HttpStatus.OK);
  }

  /**
  * Removes a user from the database
  */
  public ResponseEntity<Void> delete(String username) {
    String sql = "DELETE FROM users WHERE username=?";
    jdbc.update(sql, username);
	return new ResponseEntity<>(HttpStatus.OK);
  }
}
