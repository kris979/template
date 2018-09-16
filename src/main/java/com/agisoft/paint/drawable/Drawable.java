package com.agisoft.paint.drawable;

/**
 * This interface should be implemented by shapes that know how to draw themselves on a canvas
 */
public interface Drawable {
	
	char[][] draw(int width, int height, char[][] canvas);

}
