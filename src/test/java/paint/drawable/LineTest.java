package paint.drawable;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LineTest {

	private final int width = 10;
	private final int height = 10;
	private char[][] canvas = new char[height][width];
	
	@Before
	public void setup() {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				canvas[i][j] = ' ';
			}
		}
	}
	
	@Test
	public void test() {
		Line line = new Line(2,2,5,2);
		char[][] updatedCanvas = line.draw(width, height, canvas);
		char[] expectedLine = updatedCanvas[1];
		for (int i = 1; i < 4; i++) {
			assertEquals('x', expectedLine[i]);
		}
	}

	
	@Test(expected = InvalidShapeException.class)
	public void testInvalidLine() {
		new Line(1,1,5,5);
	}
}
