package reference;
/* A simple video game style kernel, revision 4.
   by Mark Graybill, August 2010
   Has a ball bouncing off a brick.
   Because the ball moves at a fixed speed,
   slow enough we won't miss a collision,
   we can use simple colliision detection.

   Uses the Brick class from the article
   "Multiple Constructor Methods"
*/

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;

public class TestCollide extends JPanel{

public Rectangle screen, bounds; // The screen area and boundary.
public JFrame frame; // A JFrame to put the graphics into.
public VGTimerTask vgTask; // The TimerTask that runs the game.
public VGBall ball; // The game ball, a subclass of Rectangle.
private Brick brick; // A brick for the ball to interact with.

/* This sets up the screen area, and creates instances of
 the JFrame, VGBall, VGTimerTask, etc that we'll need. */
  public TestCollide(){
    super();
    screen = new Rectangle(0, 0, 600, 400);
    bounds = new Rectangle(0, 0, 600, 400); // Give some temporary values.
    ball = new VGBall();
    frame = new JFrame("VidBrick");
    vgTask = new VGTimerTask();
    brick = new Brick();
}
 class Brick extends Rectangle{
	 Color color;
	 public Brick(){
		 super();
		 this.color = Color.red;
	 }
	 
	 public Color getColor() {
		return this.color;
		 
	 }
 }
  class VGTimerTask extends TimerTask{
    public void run(){
      ball.move();
      frame.repaint();
    }
  }

  class VGBall extends Rectangle{
    int xVel, yVel; // The ball's velocity.
    Color ballColor; // The color of the ball.

/* Create a VGBall with default location of upper left
  corner, size of 20x20 pixels, moving at one quarter
  its height and width per turn--plus it's blue. */
    public VGBall(){
      super(0, 0, 20, 20);
      xVel = width/4;
      yVel = height/4;
      ballColor=new Color(0, 0, 128);
    }

/* Move the Ball. */
    public void move(){
      // Move the ball according to the game rules.
      x+=xVel; // Move horizontally.
      y+=yVel; // Move vertically.

      // Detect edges and bounce if necessary.
      if (x > (bounds.width - width)){
        xVel = -xVel; // reverse movement.
        x = bounds.width -  width; // Set location to screen edge.
      }
      if (y > (bounds.height - height)){
        yVel = -yVel; // reverse movement.
        y = bounds.height - height;
      }
      if (x <= 0) { xVel = -xVel; x = 0; }
      if (y <= 0) { yVel = -yVel; y = 0; }

     // Detect Brick and bounce if necessary.
      if (intersects(brick)) {
        // Get the intersection rectangle to find out which way to bounce.
        Rectangle iRect = intersection(brick);
        // If we hit on the left side, go left (negative x velocity).
        if ((x+(width/2))<(iRect.x+(iRect.width/2))){xVel=(0-Math.abs(xVel));}
        // If we hit on the right side, go right (positive x velocity).
        if ((x+(width/2))>(iRect.x+(iRect.width/2))){xVel=Math.abs(xVel);}
        // If we hit on the top, go up.
        if ((y+(height/2))<(iRect.y+(iRect.height/2))){yVel=(0-Math.abs(yVel));}
        // If we hit on the bottom, go down.
        if ((y+(height/2))>(iRect.y+(iRect.height/2))){yVel=Math.abs(yVel);}
      } // if intersects
    }

/* Draw the ball into the provided graphics context. Preserves
   the context's drawing color setting. */

    public void draw(Graphics g){
    // the ball draws itself in the graphics context given.
      Color gcColor = g.getColor(); // Preserve the present color.
      g.setColor(ballColor); // Use the ball's color for the ball.
      g.fillRect(x, y, width, height); // Draw the ball.
      g.setColor(gcColor); // Restore prior color.
    } // end draw()
  } // end of class VGBall

  public void paintComponent(Graphics g){
    // Get the drawing area bounds for game logic.
    bounds = g.getClipBounds();
    // Clear the drawing area.
    g.clearRect(screen.x, screen.y, screen.width, screen.height);
    // Draw the brick.
    g.setColor(brick.getColor());
    g.fillRect(brick.x, brick.y, brick.width, brick.height);
    // Draw the ball.
    ball.draw(g);
  }

/* Main program loop. */
  public static void main(String arg[]){

    java.util.Timer vgTimer = new java.util.Timer();  // Create a Timer object
    TestCollide panel = new TestCollide(); 
    
    panel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.frame.setSize(panel.screen.width, panel.screen.height);

    panel.frame.setContentPane(panel); 
    panel.frame.setVisible(true);

    // Set up the brick.
    panel.brick.x = panel.screen.width/3;
    panel.brick.y = panel.screen.height/3;
    panel.brick.width = panel.screen.width/3;
    panel.brick.height = panel.screen.height/3;

    // Set up a timer to do the vgTask regularly.
    vgTimer.schedule(panel.vgTask, 0, 33);
  }
}