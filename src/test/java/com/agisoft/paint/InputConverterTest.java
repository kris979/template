package com.agisoft.paint;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.agisoft.paint.commands.Command;
import com.agisoft.paint.commands.DrawCanvasCommand;
import com.agisoft.paint.commands.InvalidCommand;
import com.agisoft.paint.commands.QuitCommand;


public class InputConverterTest {
	
	private InputConverter cs = new InputConverter();
	private final String DEFAULT_HELP = "Please, use one of the following commands:\n" + 
			"C w h\n" + 
			"L x1 y1 x2 y2\n" + 
			"R x1 y1 x2 y2\n" + 
			"Q - quit\n";
	/**
	 * Q - quit 
	 */
	@Test
	public void testQuitCmdCreation() {
		Command command = cs.convert("Q");
		assertThat(command, instanceOf(QuitCommand.class));
	}
	
	/**
	 * C w h 
	 */
	@Test
	public void testCanvasCreation() {
		Command canvas = cs.convert("C 20 5");
		assertThat(canvas, instanceOf(DrawCanvasCommand.class));
	}
	
	/**
	 * L x1 y1 x2 y2
	 */
	@Test
	public void testThatLineCreationReturnsCanvasWithLine() {
		cs.convert("C 20 5");
		Command canvas = cs.convert("L 1 3 7 3");
		assertThat(canvas, instanceOf(DrawCanvasCommand.class));
	}
	
	
	@Test
	public void thatAddingInvalidLineReturnsInvalidCmd() {
		cs.convert("C 20 5");
		Command cmd = cs.convert("L 1 2 3 4");
		assertThat(cmd, instanceOf(InvalidCommand.class));
	}
	
	/**
	 * R x1 y1 x2 y2
	 */
	@Test
	public void testThatRectangleCreationReturnsCanvasWithRectangle() {
		cs.convert("C 20 5");
		Command canvas = cs.convert("R 15 2 20 5");
		assertThat(canvas, instanceOf(DrawCanvasCommand.class));
	}
	
	@Test
	public void thatAddingInvalidRectangleReturnsInvalidCmd() {
		cs.convert("C 20 5");
		Command cmd = cs.convert("R 10 2 3 4");
		assertThat(cmd, instanceOf(InvalidCommand.class));
	}
	
	@Test
	public void testThatInvalidCmdReturnsInvalidCmd() {
		Command command = cs.convert("sfwefe");
		assertThat(command, instanceOf(InvalidCommand.class));
	}
	
	/**
	 * certain commands require canvas to be present
	 */
	@Test
	public void testThatCanvasIsPresent() {
		Command command = cs.convert("R 15 2 20 5");
		assertThat(command, instanceOf(InvalidCommand.class));
		InvalidCommand cmd = (InvalidCommand)command;
		assertThat(cmd.getMsg(), is("You need to create a canvas first.\n" + DEFAULT_HELP));
		
		command = cs.convert("L 1 3 7 3");
		assertThat(command, instanceOf(InvalidCommand.class));
		cmd = (InvalidCommand)command;
		assertThat(cmd.getMsg(), is("You need to create a canvas first.\n" + DEFAULT_HELP));
	}
}
