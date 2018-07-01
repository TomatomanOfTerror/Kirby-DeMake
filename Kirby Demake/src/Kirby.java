import javafx.scene.paint.Color;
import javafx.scene.*;

public class Kirby extends GoodCreature
{
    private final int NORMALHEALTH = 5;
    private final int EASYHEALTH = 10;
    private final int HARDHEALTH = 1;
    private final int JUMPLIMIT = 15;
    
    private int health;
    private boolean isJumping;
    private int numJumps;
    
    /**
     * Default Kirby constructor. Starts with <code>NORMALHEALTH</code> and
     * <code> isJumping</code> as true, with 50 pxl height and width
     */
    public Kirby()
    {
        health = NORMALHEALTH;
        isJumping = true;
        numJumps = 0;
        
        setHeight(50);
        setWidth(50);
        setFill(Color.PINK);
    }
    
    /**
     * returns isJumping
     * @return isJumping
     */
    public boolean isJumping()
    {
        return isJumping;
    }
    
    /**
     * toggles isJumping
     * @param jumping boolean to set isJumping to
     */
    public void setJumping(boolean jumping)
    {
        isJumping = jumping;
    }
    
    /**
     * gets the number of jumps Kirby has made
     * @return current number of jumps in a row
     */
    public int getNumJumps()
    {
        return numJumps;
    }
    /**
     * sets number of jumps Kirby has made in a row
     * @param numJumps number of jumps to set
     */
    public void setNumJumps(int numJumps)
    {
        this.numJumps = numJumps;
    }
    /**
     *handles player jumps, keeping jumps under the jumpLimit
     */
    public void jump()
    {
        if (numJumps <= JUMPLIMIT)
        {
            this.setyVelocity(-2.5);
            numJumps++;
        }
    }
    /**
     * moves kirby left
     */
    public void moveLeft()
    {
        this.setxVelocity(-2.5);
    }
    
    /**
     * moves kirby right
     */
    public void moveRight()
    {
        this.setxVelocity(2.5);
    }
    
    /**
     * primes the scene to allow the player to control kirby
     * @param scene Scene that game is on
     */
    public void activateControls(Scene scene)
    {
        scene.setOnKeyPressed(e ->
        {
            switch (e.getCode())
            {
                case W:
                case UP: jump(); break;
                case LEFT:
                case A: moveLeft(); break;
                case RIGHT:
                case D: moveRight(); break;
            }
        });
        scene.setOnKeyReleased(e ->
        {
            switch(e.getCode())
            {
                case LEFT:
                case A:
                case RIGHT:
                case D: this.setxVelocity(0); break;
            }
        });
        
    }
    
    /**
     * Paramaterless way to activate controls. Now as long as the player has been added to a
     * PhysicsObjectSet, calling the activateControls method can find the scene this
     * is in and do it, without requiring the user reference the scene themselves
     */
    public void activateControls()
    {
        activateControls(getSet().getScene());
    }
    
    @Override
    //Stuff will happen when Kirby dies
    //TODO create scene of game over screen to overlay when kirby dies
    public void die()
    {
        System.out.println("Ya got oof'd");
    }
}
