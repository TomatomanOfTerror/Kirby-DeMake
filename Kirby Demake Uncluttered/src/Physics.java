import javafx.animation.AnimationTimer;
import java.util.ArrayList;
public class Physics extends AnimationTimer
{
    //Puts all objects with physics into an arraylist to loop through them all in one go
    private ArrayList<PhysicsObject> objects = new ArrayList<>();
    
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
}