package paint.drawable;

/**
 * Is Line a Shape? 
 * 
 * Yes. It's no different to, say, a polygon with the shape of
 * a D with 5 points viewed edge-on. A polygon is just a closed shape which has
 * 3 or more vertices and edges. A shape with only two vertices is just a line
 * 
 * https://gamedev.stackexchange.com/questions/34225/can-a-straight-line-be-called-a-polygon
 *
 */
public class Line extends Shape {

	public Line(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
		if (x1!=x2 && y1!=y2) {
			throw new InvalidShapeException("Only straight lines are supported at the moment.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agisoft.paint.drawable.Drawable#draw()
	 */
	@Override
	public char[][] draw(int width, int height, char[][] canvas) {
		for (int row = y1 - 1; row <= y2 - 1 && row < height; row++) {
			for (int col = x1 - 1; col <= x2 - 1 && col < width; col++) {
				canvas[row][col] = 'x';
			}
		}
		return canvas;
	}

}
