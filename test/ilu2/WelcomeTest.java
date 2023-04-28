package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void testEX1() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("amy"), "Hello, Amy");
		assertEquals(Welcome.welcome("jerry"), "Hello, Jerry");
	}

	@Test
	void testEX2() {
		assertEquals(Welcome.welcome("   "), "Hello, my friend");
		assertEquals(Welcome.welcome(null), "Hello, my friend");
	}

	@Test
	void testEX3() {
		assertEquals(Welcome.welcome("JERRY"), "HELLO, JERRY !");
		assertEquals(Welcome.welcome("AMY"), "HELLO, AMY !");
		assertEquals(Welcome.welcome("BOB"), "HELLO, BOB !");
	}

	@Test
	void testEX4() {
		assertEquals(Welcome.welcome("amy, bob"), "Hello, Amy and Bob");
		assertEquals(Welcome.welcome("jerry, amy"), "Hello, Jerry and Amy");
	}

	@Test
	void testEX5() {
		assertEquals(Welcome.welcome("Amy, bob, jerry"), "Hello, Amy, Bob and Jerry");
		assertEquals(Welcome.welcome("Amy, bob, jerry, jack, rose"), "Hello, Amy, Bob, Jerry, Jack and Rose");
	}

	@Test
	void testEX6() {
		assertEquals(Welcome.welcome("Amy, BOB, Jerry"), "Hello, Amy and Jerry. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("Amy, BOB"), "Hello, Amy. AND HELLO, BOB !");
	}

	@Test
	void testEX7() {
		assertEquals(Welcome.welcome("bob, amy, jerry"), "Hello, Bob, Amy and Jerry");
		assertEquals(Welcome.welcome("bob, AMY, jerry, JACK"), "Hello, Bob and Jerry. AND HELLO, AMY AND JACK !");
	}
}
