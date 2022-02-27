package contact;

public class Contact {

	private String id;
	private String number;
	private String firstName;
	private String lastName;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String number, String address) {
		
		idCheck(id);

		lastNameCheck(lastName);
		
		firstNameCheck(firstName);
		
		numCheck(number);
		
		addressCheck(address);
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}

	/**
	 * Getters and setters
	 */
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		numCheck(number);
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		firstNameCheck(firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastNameCheck(lastName);
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		addressCheck(address);
		this.address = address;
	}

	public String getId() {
		return id;
	}
	
	/**
	 * These methods are responsible for checking that params meet requirements.
	 * Called for every respective "set"
	 */
	
	private void numCheck(String number) {
		if (number == null || number.length() > 10 || number.length() < 10) 
			throw new IllegalArgumentException("Invalid Number.");
	}
	
	private void idCheck(String id) {
		if (id == null || id.length() > 10) 
			throw new IllegalArgumentException("Invalid Id.");
	}
	
	private void firstNameCheck(String firstName) {
		if (firstName == null || firstName.length() > 10) 
			throw new IllegalArgumentException("Invalid First Name.");
	}
	
	private void lastNameCheck(String lastName) {
		if (lastName == null || lastName.length() > 10) 
			throw new IllegalArgumentException("Invalid Last Name.");
	}
	
	private void addressCheck(String address) {
		if (address == null || address.length() > 30) 
			throw new IllegalArgumentException("Invalid Address.");
	}
}
