package Entities;

public class GameUser {
	private int id;
	private String nationaltyIdentity;
	private String firstName;
	private String lastName;
	private String datetime;
	
	public GameUser() {
		super();
	}

	public GameUser(int id, String nationaltyIdentity, String firstName, String lastName, String datetime) {
		super();
		this.id = id;
		this.nationaltyIdentity = nationaltyIdentity;
		this.firstName = firstName;
		this.lastName = lastName;
		this.datetime = datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNationaltyIdentity() {
		return nationaltyIdentity;
	}

	public void setNationaltyIdentity(String nationaltyIdentity) {
		this.nationaltyIdentity = nationaltyIdentity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
}
