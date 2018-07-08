import javafx.animation.AnimationTimer;
import java.util.ArrayList;
public class Physics extends AnimationTimer
{
    //Puts all objects with physics into an arraylist to loop through them all in one go
    private ArrayList<PhysicsObject> objects = new ArrayList<>();
    
    /**
     * the player of the objects Physics is working with. Used for reference for allowing scrolling
     */
    private Kirby player;
    
    /**
     * Where in the scene relative to the whole scene's size it will start scrolling when Kirby moves off of it.
     * So, with a value of 0.25 for lowerScrollBound, the game will start scrolling to the left when Kirby
     * is moving left and heading into the leftmost 1/4th of the scene
     */
    private double lowerScrollBound = 0.25;
    private double upperScrollBound = 0.75;
    
    
    @Override
    public void handle(long now)
    {
        //Iterates through all objects to deal with their physics
        for (int i = 0; i < objects.size(); i++)
        {
            PhysicsObject object = objects.get(i);
            boolean doesObjectCollide = false;
            
            //TODO Check for collisions, deal with collisions
            //Iterates through all objects
            for (int j = 0; j < objects.size(); j++)
            {
                //excludes themselves
                if (j != i)
                {
                    if (checkCollide(object, objects.get(j)))
                    {
                        doesObjectCollide = true;
                        Collisions.collisionResult(object, objects.get(j));
                    }
                }
            }
            
            //TODO check if object is on ground
            //If not colliding, increases downward velocity by gravity
            if (!doesObjectCollide)
            {
                object.setyVelocity(object.getyVelocity() + object.getGravity());
            }
            
            //Moves objects based on velocities
                //Scrolling moves every object, including Kirby, the opposite direction of where he's headed at the speed of Kirby
            if (shouldScroll())
                object.setTranslateX(object.translateXProperty().get() + (object.getxVelocity() - getPlayer().getxVelocity()));
            else
                object.setTranslateX(object.translateXProperty().get() + object.getxVelocity());
            object.setTranslateY(object.translateYProperty().get() + object.getyVelocity());
        }
    }
    
    /**
     * Include PhysicsObject to be rendered by Physics
     * @param object PhysicsObject to add to array
     */
    public void add(PhysicsObject object)
    {
        objects.add(object);
    }
    
    /**
     * Remove PhysicsObject being rendered by Physics
     * @param object PhysicsObject to remove from array
     */
    public void remove(PhysicsObject object)
    {
        objects.remove(object);
    }
    
    /**
     * check collision of two PhysicsObjects
     * @param a first PhysicsObject
     * @param b second PhysicsObject
     * @return true if collide, false otherwise
     */
    public static boolean checkCollide(PhysicsObject a, PhysicsObject b)
    {
        if (a.getBoundsInParent().intersects(b.getBoundsInParent()))
            return true;
        
        else
            return false;
    }
    
    /**
     * get list of objects Physics is moving
     * @return arraylist of objects physics is moving
     */
    public ArrayList<PhysicsObject> getObjects()
    {
        return objects;
    }
    
    /**
     * getter & setter for the player the Physics engine is using
     * @return Kirby physicsobject of the engine
     */
    public Kirby getPlayer()
    {
        return player;
    }
    public void setPlayer(Kirby player)
    {
        this.player = player;
    }
    
    //Returns true if the player is moving left and is at or past the lower bound or
    //moving right and at or past the upper bound
    private boolean shouldScroll()
    {
        boolean shouldScroll = false;
        if (getPlayer() != null)
        {
            double lowerBound = getPlayer().getScene().getWidth() * lowerScrollBound;
            double upperBound = getPlayer().getScene().getWidth() * upperScrollBound;
            if ((getPlayer().getxVelocity() < 0.0 && getPlayer().getTranslateX() <= lowerBound))
                shouldScroll = true;
            else if (getPlayer().getxVelocity() > 0.0 && getPlayer().getTranslateX() >= upperBound)
                shouldScroll = true;
        }
        return shouldScroll;
    }
}