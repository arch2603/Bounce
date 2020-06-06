import junit.framework.TestCase;

/**
 * Test cases to test classes Shape/RectangleShape, Gem Shape, Oval and Dynamic Rectangle.
 * 
 * @author Archie 
 */
public class TestShape extends TestCase {
	private MockPainter painter;

	public void setUp() {
		painter = new MockPainter();
	}

	public void testSimpleMove() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		
		shape.doPaint(painter);
		shape.move(500, 500);
		shape.doPaint(painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", 
				painter.toString());
	}
	
	public void testSimpleOvalMove() {
		OvalShape shapeoval = new OvalShape(100, 20, 12, 15);
		
		shapeoval.doPaint(painter);
		shapeoval.move(500, 500);
		shapeoval.doPaint(painter);
		shapeoval.move(500, 500);
		assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)", 
				painter.toString());
	}
	public void testSimpleGemMove() {
		
		GemShape shapegem = new GemShape(0, 0, 2, 2);
		shapegem.doPaint(painter);
		shapegem.move(500, 500);
		shapegem.doPaint(painter);
		shapegem.move(500, 500);
		
		assertEquals("(line 0,0,2,2)(line 2,2,2,2)(line 10,2,2,2)(line 12,7,2,2)(line 10,12,2,2)(line 4,10,2,2)(line 2,7,2,2)",
				painter.toString());
		//System.out.println(painter.toString());
	}
	public void testShapeMoveWithBounceOffRight() {
		
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.doPaint(painter);
		shape.move(135, 10000);
		shape.doPaint(painter);
		shape.move(135, 10000);
		shape.doPaint(painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)", painter.toString());
	}
	
	public void testShapeOvalMoveWithBounceRight(){
		
		OvalShape shapeoval = new OvalShape(100, 20, 12, 15);
	
		shapeoval.doPaint(painter);
		shapeoval.move(135, 10000);
		shapeoval.doPaint(painter);
		shapeoval.move(135, 10000);
		shapeoval.doPaint(painter);
		
		assertEquals("(oval 100,20,25,35)(oval 10,35,25,35)"
				+ "(oval 98,50,25,35)", painter.toString());
	}
		

	public void testShapeGemMoveWithBounceRight(){
		
		GemShape shapegem = new GemShape(100, 20, 12, 15);
		shapegem.doPaint(painter);
		shapegem.move(135, 10000);
		shapegem.doPaint(painter);
		shapegem.move(135, 10000);
		shapegem.doPaint(painter);
		
		assertEquals("(gem 100,20,25,35)(gem 10,35,25,35)"
				+ "(gem 98,50,25,35)", painter.toString());
	}

	public void testShapeMoveWithBounceOffLeft() {
		
		RectangleShape shape = new RectangleShape(10, 20, -12, 15);
		shape.doPaint(painter);
		shape.move(10000, 10000);
		shape.doPaint(painter);
		shape.move(10000, 10000);
		shape.doPaint(painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)", painter.toString());
	}
	
	public void testShapeOvalMoveWithBouceOffLeft(){
		
		OvalShape shapeoval = new OvalShape(100, 20, -12, 15);
		shapeoval.doPaint(painter);
		shapeoval.move(10000, 10000);
		shapeoval.doPaint(painter);
		shapeoval.move(10000, 10000);
		shapeoval.doPaint(painter);
		assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)"
				+ "(oval 12,50,25,35)", painter.toString());
	}
	
	public void testShapeGemMoveWithBounceOffLeft(){
		GemShape shapegem = new GemShape(100, 20, -12, 15);
		
		shapegem.doPaint(painter);
		shapegem.move(10000, 10000);
		shapegem.doPaint(painter);
		shapegem.move(10000, 10000);
		shapegem.doPaint(painter);
		assertEquals("(gem 10,20,25,35)(gem 0,35,25,35)"
				+ "(gem 12,50,25,35)", painter.toString());
	}

	public void testShapeMoveWithBounceOffBottomAndRight() {
		RectangleShape shape = new RectangleShape(10, 90, -12, 15);
		
		shape.doPaint(painter);
		shape.move(125, 135);
		shape.doPaint(painter);
		shape.move(125, 135);
		shape.doPaint(painter);
		assertEquals("(rectangle 10,90,25,35)(rectangle 0,100,25,35)"
				+ "(rectangle 12,85,25,35)", painter.toString());
		
	}
	public void testShapeOvalMoveWithBounceOffBottomAndRight() {
		
		OvalShape shapeoval = new OvalShape(10, 90, -12, 15);
		shapeoval.doPaint(painter);
		shapeoval.move(125, 135);
		shapeoval.doPaint(painter);
		shapeoval.move(125, 135);
		shapeoval.doPaint(painter);
		assertEquals("(oval 10,90,25,35)(oval 0,100,25,35)"
				+ "(oval 12,85,25,35)", painter.toString());
	}
	
	public void testShapeGemMoveWithBounceOffBottomAndRight(){
		
		GemShape shapegem = new GemShape(10, 90, -12, 15);
		shapegem.doPaint(painter);
		shapegem.move(125, 135);
		shapegem.doPaint(painter);
		shapegem.move(125, 135);
		shapegem.doPaint(painter);
		assertEquals("(gem 10,90,25,35)(gem 0,100,25,35)"
				+ "(gem 12,85,25,35)", painter.toString());
	}
}
