import java.awt.*;


public class Mike extends Animator {

    private Ball ball1 = new Ball( Color.red, 10 );
    private Ball ball2 = new Ball( Color.blue, 10 );
    private Ball ball3 = new Ball( Color.yellow, 20 );
    private Ball ball4 = new Ball( Color.green, 40 );
    private Brick brick = new Brick( Color.pink, 125, 75 );

    public void draw( int t, int x, int y, Graphics g ) {

	brick.show( 100, 100, g );

	ball1.draw( 10, 10, g );
	ball2.draw( 20, 20, g );
	if( x >= 80 && x <= 80+40 && y >= 80 && y <= 80+40 )
	{
	    ball4.setColor( Color.red );
	    Color temp = ball4.getColor();
	    brick.setColor( temp );
	}
	else {
	    ball4.setColor( Color.green );
	    brick.setColor( Color.pink );
	}

	ball3.draw( x, y, g );
	ball4.draw( 80, 80, g );
    }
}

class Ball {

    private Color myColor;
    private int diameter;

    public Ball( Color c, int d ) {
	myColor = c;
	diameter = d;
    }

    public void setColor( Color c ) {
	myColor = c;
    }

    public Color getColor() {
	return myColor;
    }

    public void draw( int x, int y, Graphics g){
	g.setColor( myColor );
	g.fillOval( x, y, diameter, diameter );
    } // end draw method
} // end Ball class

class Brick {

    private Color myColor;
    private int width;
    private int height;

    public Brick( Color c, int w, int h ) {
	myColor = c;
	width = w;
	height = h;
    }

    public void setColor( Color c ) {
	myColor = c;
    }

    public void show( int x, int y, Graphics g ) {
	g.setColor( myColor );
	g.fillRect( x, y, width, height );
    }
}
