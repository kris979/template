package com.agisoft.paint.drawable;

/**
 * Most probably Shape would become an interface in the future when more shapes are added. 
 * It would be more intuitive as well.
 * For now though, since we only have Line and Rectangle, two shapes that have the same attributes abstract class is fine. 
 */
public abstract class Shape implements Drawable {
	
	protected final int x1;
	protected final int x2;
	protected final int y1;
	protected final int y2;

	protected Shape(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
}
