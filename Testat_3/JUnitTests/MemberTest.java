package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import MemberPack.Member;

public class MemberTest {
	
	Member eins = new Member(2, "Mustermann", "Hans", 16);
	
	@Test
	public void testGetNachname() {
		assertTrue(	eins.getNachname().equals("Mustermann"));
	}

	@Test
	public void testSetNachname() {
		eins.setNachname("TPE");
		assertTrue(	eins.getNachname().equals("TPE"));
	}

	@Test
	public void testGetVorname() {
		assertTrue(	eins.getVorname().equals("Hans"));
	}

	@Test
	public void testSetVorname() {
		eins.setVorname("Dieter");
		assertTrue(	eins.getVorname().equals("Dieter"));
	}

	@Test
	public void testGetMitgliedsjahre() {
		assertTrue(	eins.getMitgliedsjahre()==16);
	}

	@Test
	public void testSetMitgliedsjahre() {
		eins.setMitgliedsjahre(18);
		assertTrue(	eins.getMitgliedsjahre()==18);
	}

	@Test
	public void testGetMitglieder_ID() {
		assertTrue(	eins.getMitglieder_ID()==2);
	}

}
