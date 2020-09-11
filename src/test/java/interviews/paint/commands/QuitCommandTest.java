package interviews.paint.commands;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

public class QuitCommandTest {

	private QuitCommand q = new QuitCommand();
	
	@Test
	public void test() {
		assertThat(q, instanceOf(Command.class));
	}

}
