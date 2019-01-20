package eng.opp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/admin")
public class AdminController {

  @Autowired
  JdbcTemplate jdbc;

  @GetMapping(path="/generate-tables")
  public ResponseEntity<String> generateTables() {
    String sql = "CREATE TABLE IF NOT EXISTS users ("
    + "id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
    + "username VARCHAR(191) NOT NULL UNIQUE,"
    + "enabled BOOLEAN NOT NULL DEFAULT TRUE,"
    + "first_name VARCHAR(191),"
    + "last_name VARCHAR(191),"
    + "role VARCHAR(50),"
    + "password VARCHAR(191) NOT NULL,"
    + "email VARCHAR(191) UNIQUE"
    + ")";
    jdbc.execute(sql);
    return new ResponseEntity<>("", HttpStatus.OK);
  }
  
  /**
   * Validates the user is authenticated as an admin
   * If request gets this far, they are an admin
   * Otherwise, Spring Security will reject
   * @return
   */
  @GetMapping(path="/auth")
  public ResponseEntity<String> auth() {
	  return new ResponseEntity<>("", HttpStatus.OK);
  }
}
