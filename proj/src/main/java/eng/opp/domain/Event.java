package eng.opp.domain;

public class Event {
	private long id;
	private String location;
	private String title;
	private long start; // MS since epoch
	private long end; // MS since epoch
	// private long partnerId;
	// private Partner partner;
	private User lead;
	private long leadId;
	private User[] registeredUsers;
	private boolean archived;

	public long getId() {
		return id;
	}

	/**
	 * @return the archived
	 */
	public boolean isArchived() {
		return archived;
	}

	/**
	 * @param archived the archived to set
	 */
	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	/**
	 * @return the registeredUsers
	 */
	public User[] getRegisteredUsers() {
		return registeredUsers;
	}

	/**
	 * @param registeredUsers the registeredUsers to set
	 */
	public void setRegisteredUsers(User[] registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	/**
	 * @return the leadId
	 */
	public long getLeadId() {
		return leadId;
	}

	/**
	 * @param leadId the leadId to set
	 */
	public void setLeadId(long leadId) {
		this.leadId = leadId;
	}

	/**
	 * @return the lead
	 */
	public User getLead() {
		return lead;
	}

	/**
	 * @param lead the lead to set
	 */
	public void setLead(User lead) {
		this.lead = lead;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}
}
