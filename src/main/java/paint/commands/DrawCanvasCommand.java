package paint.commands;

import paint.drawable.Drawable;

public class DrawCanvasCommand implements Command {

	private final int width;
	private final int height;
	private char[][] canvas;

	public DrawCanvasCommand(int width, int height) {
		super();
		this.height = height;
		this.width = width;
		this.canvas = new char[this.height][this.width];
		prepareEmptyCanvas();
	}

	@Override
	public void execute() {
		draw();
	}

	/**
	 * @param drawable - a shape that knows how to draw itself on a canvas
	 * 
	 * It is important we only depend on an Drawable interface. 
	 * That way we satisfy Open Closed principle - we never need to modify
	 * this code when a new drawable shape is added etc.
	 */
	public void add(Drawable drawable) {
		canvas = drawable.draw(width, height, canvas);
	}
	
	private void prepareEmptyCanvas() {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				canvas[i][j] = ' ';
			}
		}
	}

	private void draw() {

		String horizontalLine = createHorizonalLine();

		StringBuilder builder = new StringBuilder();

		builder.append(horizontalLine).append("\n");

		for (int i = 0; i < this.height; i++) {

			// left frame
			builder.append('|');

			// canvas body
			for (int j = 0; j < this.width; j++) {
				builder.append(canvas[i][j]);
			}

			// right frame
			builder.append('|').append("\n");
		}

		builder.append(horizontalLine);

		System.out.println(builder.toString());
	}

	private String createHorizonalLine() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < width + 2 /* canvas + vertical lines */; i++) {
			builder.append('-');
		}
		return builder.toString();
	}

	public boolean isOutside(int x1, int y1, int x2, int y2) {
		return x1 < 1 || x1 > width || y1 < 1 || y1 > height || x2 < 1 || x2 > width || y2 < 1 || y2 > height;
	}



}
