package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import Public.Key;

public class KeyTest {

	Key<String> key = new Key<>("TPE");

	@Test
	public void testGetKey() {
		String expected = "TPE";
		assertTrue(expected == key.getKey());
	}

}
