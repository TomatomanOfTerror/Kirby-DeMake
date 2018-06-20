public class ImmutablePhysicsObject extends PhysicsObject
{
    //Immutables do not have mass
	
	/**
	 * constructor for Immutable physicsObject, setting gravity
	 * @param gravity gravity for Immutable
	 */
    public ImmutablePhysicsObject(double gravity)
    {
        super(gravity);
    }
    
    /**
     * default constructor for ImmutablePhysicsObject
     */
    public ImmutablePhysicsObject()
    {}
}
