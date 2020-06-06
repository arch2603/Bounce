public class GemShape extends Shape {



	public GemShape(int x, int y, int deltaX, int deltaY){
		super(x, y,deltaX,deltaY);
	}

	public GemShape(int x, int y, int deltaX, int deltaY, int fWidth, int fHeight){

		super(x, y, deltaX, deltaY,fWidth, fHeight);
	}

	@Override
	public void doPaint(Painter painter) {

		int middleXcoordinate = fX + fWidth/2;

		if(fX + 20 > middleXcoordinate){

			painter.drawLine(fX + fWidth/2,fY, fX + fWidth, fY + fHeight/2);
			painter.drawLine(fX + fWidth,fY + fHeight/2,fX + fWidth/2, fY + fHeight);
			painter.drawLine(fX + fWidth/2 ,fY + fHeight, fX, fY + fHeight/2);
			painter.drawLine(fX, fY + fHeight/2,fX + fWidth/2,fY);


		}else{
			painter.drawLine(fX + 20,fY,fX + fWidth -20,fY);
			painter.drawLine(fX + fWidth - 20, fY,fX + fWidth,fY + fHeight/2);
			painter.drawLine(fX + fWidth,fY + fHeight/2, fX + fWidth -20, fY + fHeight);
			painter.drawLine( fX + fWidth -20,fY + fHeight,fX + 20, fY + fHeight);
			painter.drawLine(fX + 20,fY + fHeight, fX, fY + fHeight/2);
			painter.drawLine(fX, fY + fHeight/2,fX + 20,fY);
		}
	}

}
