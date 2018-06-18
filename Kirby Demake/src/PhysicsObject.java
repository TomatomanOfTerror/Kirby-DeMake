import javafx.scene.shape.Rectangle;

public class PhysicsObject extends Rectangle
{
    private final double DEFAULTGRAVITY = 0.05;
    
    private double gravity;
    private double xVelocity;
    private double yVelocity;
    
    public PhysicsObject()
    {
        gravity = DEFAULTGRAVITY;
        xVelocity = 0.0;
        yVelocity = 0.0;
    }
    
    public PhysicsObject(double gravity)
    {
        this.gravity = gravity;
        xVelocity = 0.0;
        yVelocity = 0.0;
    }
    
    public double getGravity()
    {
        return gravity;
    }
    
    public double getxVelocity()
    {
        return xVelocity;
    }
    
    public void setxVelocity(double xVelocity)
    {
        this.xVelocity = xVelocity;
    }
    
    public double getyVelocity()
    {
        return yVelocity;
    }
    
    public void setyVelocity(double yVelocity)
    {
        this.yVelocity = yVelocity;
    }
}
