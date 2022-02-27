package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import contact.Contact;
import contact.ContactService;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	private String id = "0000000001";
	private String first = "first";
	private String last = "last";
	private String number = "0123456789";
	private String address = "123 St";
	
	@Test
	void addContact() {
		ContactService cs = new ContactService();
		Assertions.assertTrue(cs.addContact(first, last, number, address));
	}
	
	@Test
	void updateContact() {
		ContactService cs = new ContactService();
		Assertions.assertTrue(cs.addContact(first, last, number, address));
		String newAddress = "1234 St";
		Assertions.assertTrue(cs.updateContactAddress(id, address));
		String newFirst = "tsrif";
		Assertions.assertTrue(cs.updateContactFirstName(id, newFirst));
		String newLast = "tsal";
		Assertions.assertTrue(cs.updateContactLastName(id, newLast));
		String newNumber = "9876543210";
		Assertions.assertTrue(cs.updateContactNumber(id, newNumber));
	}
	
	@Test
	void deleteContact() {
		ContactService cs = new ContactService();
		Assertions.assertTrue(cs.addContact(first, last, number, address));
		Assertions.assertTrue(cs.removeContact(id));
	}

}
