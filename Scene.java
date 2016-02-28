//-----------------------------------------------------
//
// Michael Benson
// CS1121
// Spring 2005
// date
// Recitation Section ?
// Lab Section 10
//
// Homework Program 2
//
//-----------------------------------------------------

import java.awt.*;

public class Scene extends Animator {

    private Tanker whiteRect = new Tanker();
    private Tank grayRect = new Tank();
    private Drain redBox = new Drain();

    public void startup() {
	Animator.addClickListener(whiteRect);
    }

    public void draw(Graphics g) {

	whiteRect.draw(g);
	grayRect.draw(g);
	redBox.draw(g);
	
	} // end draw method
	
    } // end of Scene class

    class Tanker implements ClickListener{

	private final int tankerW = 100;
	private final int tankerH = 40;
	private int xPos = 0;
	private int xVel = 0;
	private int tankerPosition = 0;
	private int cpTanker;
	public int waterTanker = 0;
	public int waterTank = 100;
	public int getwaterTanker() {
	    return waterTanker;
	    }
	
	public void click(int x,int y) {

	int sceneS = Animator.getSurface();
	int sceneW = Animator.getSceneWidth();
	int cpTanker = sceneW/2 - tankerW/2 + tankerPosition + 20; 
		if (x > cpTanker) {
			xVel++;
		}
		else  {
			xVel--;
		}
	} // end click listener		

	public void draw(Graphics g) {
	
	    int sceneS = Animator.getSurface();
	    int sceneW = Animator.getSceneWidth();
	    int cpTanker = sceneW/2 - tankerW/2 + tankerPosition + 20;
	    int towerX = 20;
	    int towerW = 100;
	    int towerLegsH = 45;
	    int towerH = 101;
	    tankerPosition = tankerPosition + xVel;
		
	    g.setColor(Color.white);
	    g.fillRect((sceneW/2)-(tankerW/2)+tankerPosition,sceneS-tankerH,tankerW,tankerH);

	    if (cpTanker < (towerX + towerW) & cpTanker > towerX & waterTank > 0 & waterTanker < 41) {
		    waterTanker++;
		    waterTank--;
	    }

	    g.setColor(Color.blue);
	    g.fillRect(sceneW/2 - tankerW/2 + tankerPosition,sceneS - tankerH,tankerW,waterTanker);
	   
	    g.setColor(Color.blue);
	    g.fillRect(towerX,sceneS+146,towerW,waterTank);
	    
	} // end draw method

    } // end tanker class$

    class Tank {
	{
	private Tanker white;
	public Tank (white w) {
	    white = w;
	    }
	
	private final int towerLegsW = 3;
	private final int towerLegsH = 45;
	private final int towerH = 101;
	public int towerW = 100;
	public int towerX = 20;

	
	public void draw(Graphics g) {

	    int sceneS = Animator.getSurface();
	    int sceneW = Animator.getSceneWidth();
	    int water = Tanker.getwaterTanker();
	    
	    g.setColor(Color.gray);
	    g.fillRect(towerX,sceneS-towerLegsH-towerH,towerW,towerH);
	    g.fillRect(towerX,sceneS-towerLegsH,towerLegsW,towerLegsH);
	    g.fillRect(towerX+towerW-towerLegsW,sceneS-towerLegsH,towerLegsW,towerLegsH);

	    
	} // end draw method

    } // end watertower class

    class Drain {

	private int drainW = 10;
	private int drainH = 10;
	private int drainX = -30;
	
	public void draw(Graphics g) {
	    
	    int sceneS = Animator.getSurface();
	    int sceneW = Animator.getSceneWidth();
	    
	    g.setColor(Color.red);
	    g.fillRect(sceneW+drainX,sceneS,drainW,drainH);

	} // end draw method

    } // end drain class
