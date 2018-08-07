package eng.opp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.opp.domain.User;

@RestController
@RequestMapping(path="/login")
public class APIUserController {

  @PostMapping(path="/addUser")
  public ResponseEntity<User> createUser() {
	  return null;
  }

  @PatchMapping(path="/updateEmail")
  public ResponseEntity<User> updateUserEmail() {
	  return null;
  }

  @PatchMapping(path="/updatePassword")
  public ResponseEntity<User> updateUserPassword() {
	  return null;
  }

  @PutMapping(path="/updateUser")
  public ResponseEntity<User> updateUser() {
	  return null;
  }

  @DeleteMapping(path="/deleteUser")
  public ResponseEntity<User> deleteUser() {
	  return null;
  }
}
