package interviews.paint.drawable;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {

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
		Rectangle rec = new Rectangle(2, 2, 5, 4);
		char[][] updatedCanvas = rec.draw(width, height, canvas);
		
		//top
		char[] expectedLine = updatedCanvas[1];
		for (int i = 1; i < 5; i++) {
			assertEquals('x', expectedLine[i]);
		}
		
		//middle
		expectedLine = updatedCanvas[2];
		assertEquals('x', expectedLine[1]);

		//bottom
		expectedLine = updatedCanvas[3];
		for (int i = 1; i < 5; i++) {
			assertEquals('x', expectedLine[i]);
		}
	}
	
	
	@Test(expected = InvalidShapeException.class)
	public void testInvalidLine() {
		new Rectangle(10,2,5,5);
	}

}
