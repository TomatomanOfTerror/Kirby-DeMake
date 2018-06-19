import javafx.scene.paint.Color;
import javafx.scene.*;

public class Kirby extends MutablePhysicsObject
{
    private final int NORMALHEALTH = 5;
    private final int EASYHEALTH = 10;
    private final int HARDHEALTH = 1;
    private final int JUMPLIMIT = 5;
    
    private int health;
    private boolean isJumping;
    private int numJumps;
    
    public Kirby()
    {
        health = NORMALHEALTH;
        isJumping = true;
        numJumps = 0;
        
        setHeight(50);
        setWidth(50);
        setFill(Color.PINK);
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    public boolean isJumping()
    {
        return isJumping;
    }
    
    public void setJumping(boolean jumping)
    {
        isJumping = jumping;
    }
    
    public int getNumJumps()
    {
        return numJumps;
    }
    
    public void setNumJumps(int numJumps)
    {
        this.numJumps = numJumps;
    }
    
    public void jump()
    {
        if (numJumps <= JUMPLIMIT)
        {
            this.setyVelocity(-2.5);
            numJumps++;
        }
    }
    
    public void moveLeft()
    {
        this.setxVelocity(-2.5);
    }
    
    public void moveRight()
    {
        this.setxVelocity(2.5);
    }
    
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
}
