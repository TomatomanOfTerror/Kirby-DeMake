public class Collisions
{
    public static String collideType(PhysicsObject a, PhysicsObject b) throws IllegalArgumentException, Exception
    {
        //Checks for collisions with objects that aren't mutable or immutable, refuses them
        if ((!(a instanceof MutablePhysicsObject) && !(a instanceof  ImmutablePhysicsObject)))
            throw new IllegalArgumentException("First input is neither Mutable or Immutable");
        if ((!(b instanceof MutablePhysicsObject) && !(b instanceof  ImmutablePhysicsObject)))
            throw new IllegalArgumentException("Second input is neither Mutable or Immutable");
        
        if (a instanceof  MutablePhysicsObject && b instanceof MutablePhysicsObject)
            return "MM";
        if (a instanceof  ImmutablePhysicsObject && b instanceof ImmutablePhysicsObject)
            return "II";
        if (a instanceof ImmutablePhysicsObject && b instanceof  MutablePhysicsObject)
            return "IM";
        if (a instanceof  MutablePhysicsObject && b instanceof ImmutablePhysicsObject)
            return "MI";
        
        else
            throw new Exception("Something in collideType is wrong");
    }
    
    public static void collisionResult(PhysicsObject a, PhysicsObject b)
    {
        try
        {
            String type = collideType(a, b);
            
            if (type.contains("MM"))
            {
                MutablePhysicsObject m1 = (MutablePhysicsObject)a;
                MutablePhysicsObject m2 = (MutablePhysicsObject)b;
                MMCollision(m1, m2);
            }
            
            if (type.contains("II"))
            {
                ImmutablePhysicsObject i1 = (ImmutablePhysicsObject)a;
                ImmutablePhysicsObject i2 = (ImmutablePhysicsObject)b;
                IICollision(i1, i2);
            }
            
            if (type.contains("IM"))
            {
                ImmutablePhysicsObject i = (ImmutablePhysicsObject)a;
                MutablePhysicsObject m = (MutablePhysicsObject)b;
                IMCollision(i, m);
            }
            
            if (type.contains("MI"))
            {
                MutablePhysicsObject m = (MutablePhysicsObject)a;
                ImmutablePhysicsObject i = (ImmutablePhysicsObject)b;
                IMCollision(i, m);
            }
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    
    /*Collision resolution for two objects with mass
    uses perfectly inelastic collision to determine the outcome.
    that is, vi1*m1 + vi2*m2 = v*m1*m2
    does that for both x and y directions
     */
    public static void MMCollision(MutablePhysicsObject a, MutablePhysicsObject b)
    {
        double xVelocityFinal = (a.getMass() * a.getxVelocity() + b.getMass() * b.getxVelocity()) / (a.getMass() + b.getMass());
        double yVelocityFinal = (a.getMass() * a.getyVelocity() + b.getMass() * b.getyVelocity()) / (a.getMass() + b.getMass());
        a.setxVelocity(xVelocityFinal);
        b.setxVelocity(xVelocityFinal);
        a.setyVelocity(yVelocityFinal);
        b.setyVelocity(yVelocityFinal);
    }
    
    public static void IMCollision(ImmutablePhysicsObject a, MutablePhysicsObject b)
    {
        //If mutable is not falling onto immutable, changes Yvelocity according to its gravity
        //Physics doesn't change velocity based on gravity if there's a collision
        if (!((b.getBoundsInParent().getMaxY() >= a.getBoundsInParent().getMinY()) && (b.getBoundsInParent().getMaxY() < a.getBoundsInParent().getMaxY())))
        {
            b.setyVelocity(b.getyVelocity() + b.getGravity());
        }
        //If mutable is falling onto immutable, sets Yvelocity to that of the immutable
        else
        {
            b.setyVelocity(a.getyVelocity());
        }
        
        //If mutable is going up into the Immutable, sets the yVelocity to that of the mutable
        if (a.getBoundsInParent().intersects(b.getBoundsInParent().getMinX(),b.getBoundsInParent().getMinY(), b.getBoundsInParent().getWidth(), 5))
        {
            b.setyVelocity(a.getyVelocity());
        }
        
        //If the mutable is crashing into the immutable from the side
        if(a.getBoundsInParent().intersects(b.getBoundsInParent().getMaxX(), b.getBoundsInParent().getMaxY() - 2, 2, b.getBoundsInParent().getHeight() - 4))
        {
            b.setxVelocity(a.getxVelocity());
        }
        if (a.getBoundsInParent().intersects(b.getBoundsInParent().getMinX(), b.getBoundsInParent().getMaxY() - 2, 2, b.getBoundsInParent().getHeight() - 4))
        {
            b.setxVelocity(a.getxVelocity());
        }
        
        
        
    }
    
    public static void IICollision(ImmutablePhysicsObject a, ImmutablePhysicsObject b)
    {
    
    }
    
}
