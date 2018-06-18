import javafx.scene.shape.*;
import javafx.scene.paint.*;
public class PlayerRectangle extends Rectangle
{
    private double xVelocity;
    private double yVelocity;
    private boolean isJumping;
    
    public PlayerRectangle(Color color)
    {
        super(50,50, color);
        super.setTranslateX(400);
        super.setTranslateY(75);
        xVelocity = 0.0;
        yVelocity = 0.0;
        isJumping = true;
    }
    
    public double getXVelocity()
    {
        return xVelocity;
    }
    
    public void setXVelocity(double newVelocity)
    {
        xVelocity = newVelocity;
    }
    
    public double getYVelocity()
    {
        return yVelocity;
    }
    
    public void setYVelocity(double newVelocity)
    {
        this.yVelocity = newVelocity;
    }
    
    public boolean getIsJumping()
    {
        return isJumping;
    }
    
    public void setIsJumping(boolean set)
    {
        isJumping = set;
    }
}
