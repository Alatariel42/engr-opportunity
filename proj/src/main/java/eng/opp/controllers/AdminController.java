

@Controller
@RequestMapping(path="/admin")
public class AdminController {

  @Autowired
  JdbcTemplate jdbc;

  @GetMapping(path="/generate-tables")
  public ResponseEntity<String> generateTables() {
    String sql = "CREATE TABLE IF NOT EXISTS users(
    id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    role VARCHAR(50),
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    PRIMARY KEY(id)
    )";
    jdbc.execute(sql);
  }
}
