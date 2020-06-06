public class DynamicRectangle extends Shape {
	
	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	private boolean fill = true;
	
	
	
	public DynamicRectangle(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	/**
	 * Paints this RectangleShape object using the supplied Painter object.
	 */
	public DynamicRectangle(int x, int y, int deltaX, int deltaY, int width, int height) {
	
		super(x,y,deltaX,deltaY,width,height);
		
	}
	
	public void doPaint(Painter painter) {
		
		if(this.fill == true){
			
			painter.fillRect(fX, fY, fWidth, fHeight);
		} else {
			
			painter.drawRect(fX, fY, fWidth, fHeight);
		}	
	}
	
	
	@Override
	public void move(int width, int height) {
		int oldMoveX = this.fDeltaX;
		int oldMoveY = this.fDeltaY;
		// DO something first
		
		super.move(width, height);
		
		//Do something else
		
		if (oldMoveY != this.fDeltaY) {
			fill = false;
		}
		if (oldMoveX != this.fDeltaX) {
			fill = true;
		} 
	}
	
}



