package interviews.paint.commands;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InvalidCommandTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	
	private String expected = "Please, use one of the following commands:\n" + 
			"C w h\n" + 
			"L x1 y1 x2 y2\n" + 
			"R x1 y1 x2 y2\n" + 
			"Q - quit\n";
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void testDefault() {
		InvalidCommand invalidCmd = new InvalidCommand();
		invalidCmd.execute();
		assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void test() {
		String exp = "test\n" + expected;
		InvalidCommand invalidCmd = new InvalidCommand("test");
		invalidCmd.execute();
		assertEquals(exp, outContent.toString());
	}

}
