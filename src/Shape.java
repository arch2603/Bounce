import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 * 
 * @author Ian Warren
 * 
 * modified by Archie Su'a
 *
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	
	protected static final Color DEFAULT_COLOR = Color.BLACK;
	// ===

	// === Instance variables, accessible by subclasses.
	
	
	protected int fX;

	protected int fY;

	protected int fDeltaX;

	protected int fDeltaY;

	protected int fWidth;

	protected int fHeight;
	
	protected Color fColor = DEFAULT_COLOR;

	protected NestingShape fParent;
	
	NestingShape topShape;
	NestingShape middleLevel;
	NestingShape bottomLevel;
	
	
	public int getX() {
		return this.fX;
	}
	
	// ===

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {

		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		fX = x;
		fY = y;
		fDeltaX = deltaX;
		fDeltaY = deltaY;
		fWidth = width;
		fHeight = height;
	}
	
	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width width of two-dimensional world.
	 * @param height height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = fX + fDeltaX;
		int nextY = fY + fDeltaY;
		
	
		if (nextX <= 0) {
			nextX = 0;
			fDeltaX = -fDeltaX;
		} else if (nextX + fWidth >= width) {
			nextX = width - fWidth;
			fDeltaX = -fDeltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			fDeltaY = -fDeltaY;
		} else if (nextY + fHeight >= height) {
			nextY = height - fHeight;
			fDeltaY = -fDeltaY;
		}

		fX = nextX;
		fY = nextY;
	}
	
	public void setColor(Color c){
		this.fColor = c;
		
	}

	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */
	protected abstract void doPaint(Painter painter);
	
	public final void paint(Painter painter){
		
		Color oldColor = painter.getColor();
		
		
		painter.setColor(fColor);
		doPaint(painter);
		painter.setColor(oldColor);
	}

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return fX;
	}
	
	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return fY;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return fDeltaX;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return fDeltaY;
	}
	
	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return fWidth;
	}
	
	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return fHeight;
	}
	
	public NestingShape parent(){
		//Instance Variable to remember the instance of Nesting Shape
		 return fParent;
		
	}
	
	public List<Shape> path(){
		
		List<Shape>	fullPath = null;
	
		if (fParent != null){
		
		fullPath = fParent.path();
		fullPath.add(this);
		
		}else{
		
		fullPath = new ArrayList<Shape>();
		fullPath.add(this);
	
		}
	
		return fullPath;
		
		
	}
	
	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a RectangleShape instance, this method 
	 * will return "bounce.RectangleShape".
	 */
	public String toString() {
		
		return getClass().getName();
	}
}
