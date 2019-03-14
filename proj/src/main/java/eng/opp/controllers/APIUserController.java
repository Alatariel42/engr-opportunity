package eng.opp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.opp.domain.User;
import eng.opp.services.UserService;

@RestController
@RequestMapping(path="/users")
public class APIUserController {

  @Autowired
  private UserService userService;

  @PostMapping(path="/")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    if (user != null) {
      return userService.add(user);
    }
	return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @PutMapping(path="/")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    if (user != null) {
      return userService.update(user);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping(path="/{username}")
  public ResponseEntity<Void> deleteUser(@PathVariable String username ) {
    if (username != null) {
      return userService.delete(username);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }
}
