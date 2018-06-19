public class ImmutablePhysicsObject extends PhysicsObject
{
    //Immutables do not have mass
    public ImmutablePhysicsObject(double gravity)
    {
        super(gravity);
    }
    
    public ImmutablePhysicsObject()
    {}
}
