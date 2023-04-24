package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void testEX1() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
	}

	@Test
	void testEX2() {
		assertEquals(Welcome.welcome("   "), "Hello, my friend");
		assertEquals(Welcome.welcome(null), "Hello, my friend");
	}

	@Test
	void testEX3() {
		assertEquals(Welcome.welcome("JERRY"), "HELLO, JERRY !");
	}
	
	@Test
	void testEX4() {
		assertEquals(Welcome.welcome("amy,bob"), "Hello, Amy, Bob");
	}
	
	@Test
	void testEX5() {
		assertEquals(Welcome.welcome("Amy,bob,jerry"), "Hello, Amy, Bob, Jerry");
	}
}
