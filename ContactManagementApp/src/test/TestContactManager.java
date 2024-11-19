package test;

import app.InvalidContactNoException;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Contact;
import app.ContactManager;

class TestContactManager {

	ContactManager manage = new ContactManager();
	Contact c = new Contact("Mereena", "Joseph", "1234567890");
	Contact c2 = new Contact("Lincy", "Joseph", "1111000010");
	boolean b = manage.addContact(c);
	boolean b2 = manage.addContact(c2);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		c.firstName = "Mereena";
		c.lastName = "Joseph";
		c.phoneNo = "1234567890";

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddContactValid() {
		
		c.phoneNo = "1029384756";
		
		assertTrue(manage.addContact(c));

	}

	@Test
	void testAddContactFirstNull() {
		c.firstName = null;

		assertFalse(manage.addContact(c));

	}

	@Test
	void testAddContactLastNull() {
		c.lastName = null;
		assertFalse(manage.addContact(c));

	}

	@Test
	void testAddContactPhoneNull() {
		c.phoneNo = null;
		assertFalse(manage.addContact(c));

	}

	@Test
	void testAddContactInvalidFirst() {
		c.firstName = "1Joseph";
		assertFalse(manage.addContact(c));

	}

	@Test
	void testAddContactInvalidLast() {
		c.lastName = "2George";
		assertFalse(manage.addContact(c));

	}

	@Test
	void testAddContactDuplicate() {
		assertFalse(manage.addContact(c));

	}

	@Test
	void testViewContactAdded() {
		try {
			assertTrue(manage.viewContact("1234567890"));
		} catch (InvalidContactNoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testViewContactNotAdded() {
		assertThrows(InvalidContactNoException.class, () -> manage.viewContact("1100110010"),
				"InvalidContactException is thrown");
	}

	@Test
	void testEditContactAdded() {
		assertTrue(manage.editContact(c.phoneNo, "New", "Second"));
	}

	@Test
	void testEditContactNotAdded() {
		assertFalse(manage.editContact("1100110010", "NewFirst", "NewLast"));
	}

	@Test
	void testDeleteContactAdded() {
		assertTrue(manage.deleteContact(c.phoneNo));
	}

	@Test
	void testDeleteContactNotAdded() {
		assertFalse(manage.deleteContact("1100110010"));
	}

}
