package eng.opp.controllers;

@RestController
@RequestMapping(path="/login")
public class APIUserController {

  @PostMapping(path="/addUser")
  public ResponseEntity<User> createUser() {

  }

  @PatchMapping(path="/updateEmail")
  public ResponseEntity<User> updateUserEmail() {

  }

  @PatchMapping(path="/updatePassword")
  public ResponseEntity<User> updateUserPassword() {

  }

  @PutMapping(path="/updateUser")
  public ResponseEntity<User> updateUser() {

  }

  @DeleteMapping(path="/deleteUser")
  public ResponseEntity<User> deleteUser() {
    
  }
}
