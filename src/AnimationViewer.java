import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Simple GUI program to show an animation of shapes. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimised, and maximised. The state of a
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subcribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Shapes requesting that each Shape paints and moves itself.
 * 
 * @author Ian Warren
 */
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds to generate ActionEvents.
	private final int DELAY = 20;

	// Collection of Shapes to animate.
	private Collection<Shape> shapes;

	private Timer timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Shape objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		shapes = new ArrayList<Shape>();
	
		//Populate the list of Shapes.
		//shapes.add(new RectangleShape(0, 0, 2, 2));
		shapes.add(new RectangleShape(10, 10, 5, 7));
		//shapes.add(new OvalShape(4, 4, 5, 6));
		//shapes.add(new OvalShape(14, 14, 8, 9));
		//shapes.add(new GemShape(16, 30, 13, 9));
		//shapes.add(new GemShape(20,40,4,4,70,123));
		//shapes.add(new GemShape(20,40,0,0,20,20));
		//shapes.add(new DynamicRectangle(400, 300, 5, 7));
		//shapes.add(new TextShape(new OvalShape(4, 4, 5, 6),"Hello Archie"));
		//shapes.add(new TextShape(new DynamicRectangle(400, 300, 5, 7),"Hello World"));
		
		/*Shape colorDyRect = new DynamicRectangle(4,5,3, 3, 20,40);
		colorDyRect.setColor(Color.yellow);
		Shape redText = new TextShape(colorDyRect, "Can you read this text?") ;
		redText.setColor(Color.blue);
		shapes.add(redText);
		
		Shape colorDyOval = new OvalShape(20,20,4, 5, 20,40);
		colorDyRect.setColor(Color.yellow);
		Shape greenText = new TextShape(colorDyOval, "Can you read this text?") ;
		greenText.setColor(Color.green);
		shapes.add(greenText);*/
		
		NestingShape s1 = new NestingShape (100,100,3,3,100,100);
		NestingShape s2 = new NestingShape (80,80,4,4 ,100,100);
		NestingShape s3 = new NestingShape (60,60,2,2);
		
		//s1.add(s2);
		s1.add(s3);
		s3.add(new OvalShape());
		
		shapes.add(s2);
		shapes.add(s1);
		//shapes.add(s3);
		
		// Start the animation.
		timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been exposed after being hidden by another window. 
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
	
		
		// Create a GraphicsPainter that Shape objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		

		// Progress the animation.
		for(Shape s : shapes) {
			s.paint(painter);
			s.move(width , height);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() to be
		// called.
		repaint();
	}
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Animation viewer");
		frame.add(new AnimationViewer());
		
		// Set window properties.
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}	
}
