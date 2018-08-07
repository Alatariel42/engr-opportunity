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
  JdbcTemplate jdbcTemplate;

  public ResponseEntity<User> add(User user) {
	  return null;
  }

  public ResponseEntity<User> update(User user) {
	  return null;
  }

  public ResponseEntity<User> delete(User user) {
	  return null;
  }
}
