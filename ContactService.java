package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	
	private int currentContactId = 0;
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public ContactService() {
	}

	public boolean addContact(String firstName, String lastName, String number, String address) {
		
		try {
			
			String id = generateId();
			Contact newContact = new Contact(id, firstName, lastName, number, address);
			
			contacts.add(newContact);
			currentContactId += 1;
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage()); 
			return false;
		}
		
		return true;
	}
	
	public boolean updateContactFirstName(String id, String firstName) {
		try {
			Contact contact = contacts.get(findContactIndex(id));
			
			contact.setFirstName(firstName);
			
		} catch (IndexOutOfBoundsException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean updateContactLastName(String id, String lastName) {
		try {
			Contact contact = contacts.get(findContactIndex(id));
			
			contact.setLastName(lastName);
			
		} catch (IndexOutOfBoundsException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean updateContactNumber(String id, String number) {
		try {
			Contact contact = contacts.get(findContactIndex(id));
			
			contact.setNumber(number);
			
		} catch (IndexOutOfBoundsException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean updateContactAddress(String id, String address) {
		try {
			Contact contact = contacts.get(findContactIndex(id));
			
			contact.setAddress(address);
			
		} catch (IndexOutOfBoundsException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean removeContact(String id) {
		
		int contactIndex = findContactIndex(id);
		
		if (contactIndex == -1) 
			return false;
		else {
			Contact contactToRemove = contacts.get(contactIndex);
			return contacts.remove(contactToRemove);
		}
		
	}
	
	private int findContactIndex(String id) {
		
		int contactIndex = -1;
		
		for (int i = 0; i < contacts.size(); i++) 
			if (id.equals(contacts.get(i).getId()))
				return i;
		
		//contact doesnt exist
		return contactIndex;
	}

	
	private String generateId() {
		
		//next contact will have id of current + 1
		//dont set currentContactId += 1 yet because contact creation could fail
		//update current contact id after success
		String nextId = String.format("%010d", currentContactId + 1);
		return nextId;
	}
}
