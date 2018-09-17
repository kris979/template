package paint.drawable;

public class Rectangle extends Shape {
	
	private final Line top;
	private final Line left;
	private final Line right;
	private final Line bottom;

	public Rectangle(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
		
		//I am trying to get it done asap hence simplifying 
		if (x1>=x2 || y1>=y2) {
			throw new InvalidShapeException("We only support rectacngles where x1 < x2 and y1 < y2 at the moment.");
		}
		
		top = new Line(x1, y1, x2, y1);
        left = new Line(x1, y1, x1, y2);
        right = new Line(x2, y1, x2, y2);
        bottom = new Line(x1, y2, x2, y2);
	}

	@Override
	public char[][] draw(int width, int height, char[][] canvas) {
		canvas = top.draw(width, height, canvas);
		canvas = left.draw(width, height, canvas);
		canvas = right.draw(width, height, canvas);
		canvas = bottom.draw(width, height, canvas);
		return canvas;
	}

}
