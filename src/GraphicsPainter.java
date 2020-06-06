import java.awt.*;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Ian Warren
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics g;
	int translationX;
	int translationY;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this.g = g;
	}

	/**
	 * @see bounce.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		g.drawRect(x + translationX, y + translationY, width, height);
	}

	/**
	 * @see bounce.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		g.drawOval(x + translationX, y + translationY, width, height);
	}

	/**
	 * @see bounce.Painter.drawLine
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		g.drawLine(x1 + translationX, y1 + translationY, x2 + translationX, y2 + translationY);
	}
	public void fillRect(int x1, int y1, int width, int height) {
		g.fillRect(x1 + translationX, y1 + translationY, width, height);
		
		
	}

	@Override
	public void centredText(int fX, int fY, String text) {
		Font textFont = g.getFont();
		
		int lengthAscent;
		int lengthDescent;
		int middleYPoint = fY;
		FontMetrics myFont = g.getFontMetrics(textFont);
		
		lengthDescent = myFont.getDescent();
		lengthAscent = myFont.getAscent();
		
		
		int stringWidth = myFont.stringWidth(text);
		int stringMiddleXPoint = fX - stringWidth/2;
		
		middleYPoint = middleYPoint + ((lengthAscent - lengthDescent)/2);
		g.drawString(text,stringMiddleXPoint,middleYPoint);
		


	}

	@Override
	public Color getColor() {
		
		return g.getColor();
	}

	@Override
	public void setColor(Color c) {

		g.setColor(c);
		
	}

	@Override
	public void translate(int x, int y) {
		g.translate(x,y);
		
	}


}
