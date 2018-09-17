package paint.commands;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import paint.drawable.Line;
import paint.drawable.Rectangle;

public class DrawCanvasCommandTest {

	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	
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
	public void testIfEmptyCanvasIsDrawnCorrect() {
		DrawCanvasCommand c = new DrawCanvasCommand(5,2);
		String expected = "-------\n" + 
				"|     |\n" + 
				"|     |\n" + 
				"-------\r\n";
		c.execute();
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testIfValidLineRendersCorrectly() {
		DrawCanvasCommand c = new DrawCanvasCommand(10,3);
		c.add(new Line(5,2,7,2));
		c.execute();
		String expected = "------------\n" + 
				"|          |\n" + 
				"|    xxx   |\n" + 
				"|          |\n" + 
				"------------\r\n";
		assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void testIfValidRectangleRendersCorrectly() {
		DrawCanvasCommand c = new DrawCanvasCommand(10,5);
		c.add(new Rectangle(2,2,5,5));
		c.execute();
		String expected = "------------\n" + 
				"|          |\n" + 
				"| xxxx     |\n" + 
				"| x  x     |\n" + 
				"| x  x     |\n" + 
				"| xxxx     |\n" + 
				"------------\r\n";
		assertEquals(expected, outContent.toString());
	}
}


