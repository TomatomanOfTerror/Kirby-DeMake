import javafx.scene.shape.Rectangle;

public class PhysicsObject extends Rectangle
{
    private final double DEFAULTGRAVITY = 0.05;
    
    private double gravity;
    private double xVelocity;
    private double yVelocity;
    
    /**
     * Basic physics object, spawned at (0, 0).
     */
    public PhysicsObject()
    {
        gravity = DEFAULTGRAVITY;
        xVelocity = 0.0;
        yVelocity = 0.0;
    }
    /**
     *  base physics object with gravity set
     * @param gravity value for gravity
     */
    public PhysicsObject(double gravity)
    {
        this.gravity = gravity;
        xVelocity = 0.0;
        yVelocity = 0.0;
    }
    /**
     * get value of gravity
     * @return Object's gravity value
     */
    public double getGravity()
    {
        return gravity;
    }
    /**
     * get horizontal velocity of object
     * @return horizontal velocity
     */
    public double getxVelocity()
    {
        return xVelocity;
    }
    
    /**
     * Set the horizontal velocity of PhysicsObject
     * @param xVelocity new horizontal velocity
     */
    public void setxVelocity(double xVelocity)
    {
        this.xVelocity = xVelocity;
    }
    
    /**
     * get vertical velocity of object
     * @return vertical velocity (positive if going down screen)
     */
    public double getyVelocity()
    {
        return yVelocity;
    }
    
    /**
     * Set the vertical velocity of PhysicsObject
     * @param yVelocity new vertical velocity
     */
    public void setyVelocity(double yVelocity)
    {
        this.yVelocity = yVelocity;
    }
}
