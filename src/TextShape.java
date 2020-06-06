public class TextShape extends Shape {
	
	private Shape textShape;
	private String text;

	/**
	 * Creates a Text within a Shape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public TextShape(Shape anotherShape, String text) {
		//super(textShape.fX, textShape.fY, textShape.fWidth, textShape.fHeight, textShape.fDeltaY, textShape.fDeltaX)
		this.textShape = anotherShape;
		this.text = text;
		
		
	}
	
	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */


	@Override
	public void doPaint(Painter painter) {
		int middleTextXPosition = textShape.fX + textShape.fWidth/2;
		int middleTextYPosition = textShape.fY + textShape.fHeight/2;
		
		textShape.paint(painter);
		painter.centredText(middleTextXPosition,middleTextYPosition, text);
		//System.out.print(fWidth);
		
	}
	public void move(int width, int height) {
		this.textShape.move(width, height);
	}
	

}
