package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {
	
	private String id = "0000000001";
	private String first = "first";
	private String last = "last";
	private String number = "0123456789";
	private String address = "123 St";

	@Test
	void firstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, "asdfasdfaasdf", last, number, address);
		});
	}
	
	@Test
	void lastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, "lastlastlast", number, address);
		});
	}
	
	@Test
	void numberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, "0123456789101112", address);
		});
	}
	
	@Test
	void addressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, number, "123 St and a bunch of other characters that are too long");
		});
	}
	
	@Test
	void idTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00000000001", first, last, number, address);
		});
	}
	
	@Test
	void nullChecks() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, first, last, number, address);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, null, last, number, address);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, null, number, address);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, null, address);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, number, null);
		});
	}
	
	@Test
	void goodContact() {
		String id = this.id;
		Contact contact = new Contact(id, first, last, number, address); 
		Assertions.assertTrue(contact.getAddress().equals(address));
		Assertions.assertTrue(contact.getFirstName().equals(first));
		Assertions.assertTrue(contact.getLastName().equals(last));
		Assertions.assertTrue(contact.getNumber().equals(number));
		return;
	}

}
