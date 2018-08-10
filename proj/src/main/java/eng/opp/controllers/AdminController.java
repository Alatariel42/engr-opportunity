package eng.opp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

  @Autowired
  JdbcTemplate jdbc;

  @GetMapping(path="/generate-tables")
  public ResponseEntity<String> generateTables() {
    String sql = "CREATE TABLE IF NOT EXISTS users("
    + "id INT(11) NOT NULL AUTO_INCREMENT,"
    + "username VARCHAR(255) NOT NULL UNIQUE,"
    + "first_name VARCHAR(255),"
    + "last_name VARCHAR(255),"
    + "role VARCHAR(50),"
    + "password VARCHAR(255) NOT NULL,"
    + "email VARCHAR(255) UNIQUE,"
    + "PRIMARY KEY(id)"
    + ")";
    jdbc.execute(sql);
    return new ResponseEntity<>("", HttpStatus.OK);
  }
}
