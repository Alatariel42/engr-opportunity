package eng.opp.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import eng.opp.domain.Event;

@Service
public class EventService {
	@Autowired
	JdbcTemplate jdbc;

	/**
	 * Adds a new event to the database
	 */
	public ResponseEntity<Event> add(Event event) {
		String sql = "INSERT INTO events(title, location, start, end) values(?,?,?,?)";
		jdbc.update(sql, event.getTitle(), event.getLocation(), event.getStart(), event.getEnd());
		return new ResponseEntity<>(event, HttpStatus.OK);
	}

	/**
	 * Updates a event in the database
	 */
	public ResponseEntity<Event> update(Event event) {
		String sql = "UPDATE events SET title=?, location=?, start=?, end=? WHERE id=?";
		jdbc.update(sql, event.getTitle(), event.getLocation(), event.getStart(), event.getEnd(), event.getId());
		return new ResponseEntity<>(event, HttpStatus.OK);
	}

	/**
	 * Removes a event from the database
	 */
	public ResponseEntity<Void> delete(long id) {
		String sql = "DELETE FROM events WHERE id=?";
		jdbc.update(sql, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<Event> getById(long id) {
		String sql = "SELECT id, title, location, start, end FROM events WHERE id=?";
		Event event = jdbc.queryForObject(sql, new Object[] { id }, this::eventMapper);
		return new ResponseEntity<>(event, HttpStatus.OK);
	}

	public ResponseEntity<List<Event>> getAll() {
		String sql = "SELECT id, title, location, start, end FROM events;";
		List<Event> events = jdbc.query(sql, this::eventMapper);
		return new ResponseEntity<>(events, HttpStatus.OK);
	}

	private Event eventMapper(ResultSet row, int num) throws SQLException {
		Event ev = new Event();
		ev.setId(row.getLong("id"));
		ev.setTitle(row.getString("title"));
		ev.setLocation(row.getString("location"));
		ev.setStart(row.getLong("start"));
		ev.setEnd(row.getLong("end"));
		return ev;
	}

}
