package harshwinds.noisemaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import harshwinds.noisemaker.Sound;

public class SoundTest {
	
	@Test
	public void testGetters() {
		int interval = 3;
		String name = "fizz";
		
		Sound sound = new Sound(interval, name);
		assertEquals(interval, sound.getInterval());
		assertEquals(name, sound.getName());
	}
	
	@Test
	public void testEquals() {
		Sound fizzbuzz3 = new Sound(3, "fizzbuzz");
		Sound anotherFizzbuzz3 = new Sound(3, "fizzbuzz");
		assertTrue(anotherFizzbuzz3.equals(fizzbuzz3));
		
		Sound fizzbuzz5 = new Sound(5, "fizzbuzz");
		assertFalse(fizzbuzz5.equals(fizzbuzz3));
	}
	
	@Test
	public void testHashCode() {
		Sound fizzbuzz3 = new Sound(3, "fizzbuzz");
		Sound anotherFizzbuzz3 = new Sound(3, "fizzbuzz");
		assertEquals(anotherFizzbuzz3.hashCode(), fizzbuzz3.hashCode());
		
		Sound fizzbuzz5 = new Sound(5, "fizzbuzz");
		assertNotEquals(fizzbuzz5.hashCode(), fizzbuzz3.hashCode());
	}
	
	@Test 
	public void testToString() {
		int interval = 3;
		String name = "fizz";
		
		Sound sound = new Sound(interval, name);
		assertEquals(name, sound.toString());
	}
}
