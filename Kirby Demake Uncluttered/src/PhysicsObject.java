import javafx.scene.shape.Rectangle;

public class PhysicsObject extends Rectangle
{
    private final double DEFAULTGRAVITY = 0.05;
    
    private double gravity;
    private double xVelocity;
    private double yVelocity;
    private PhysicsObjectSet set;
    
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
     * Set gravity value to given value
     * @param gravity new gravity value
     */
    public void setGravity(double gravity) {this.gravity = gravity;}
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
    
    /**
     * Sets the set the object is in. Oh boy that sounds gross
     * @param set the set this object is in
     */
    public void setSet(PhysicsObjectSet set)
    {
        this.set = set;
    }
    
    /**
     * returns the object set this object is in
     * @return the object set this object is in
     */
    public PhysicsObjectSet getSet()
    {
        return set;
    }
}