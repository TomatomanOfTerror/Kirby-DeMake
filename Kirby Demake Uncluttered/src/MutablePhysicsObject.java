public class MutablePhysicsObject extends PhysicsObject
{
    final double DEFAULTMASS = 10.0;
    
    private double mass;
    
    /**
     * Creates MutablePhysicsObject with specified mass
     * @param mass mass for object
     */
    public MutablePhysicsObject(double mass)
    {
        this.mass = mass;
    }
    /**
     * Creates MutablePhysicsObject with specified mass and gravity
     * @param mass mass for object
     * @param gravity gravity for object
     */
    public MutablePhysicsObject(double mass, double gravity)
    {
        super(gravity);
        this.mass = mass;
    }
    
    /**
     * default Mutable, using default mass for mass
     */
    public MutablePhysicsObject()
    {
        this.mass = DEFAULTMASS;
    }
    
    /**
     * gets this Mutable's mass
     * @return mass of this object
     */
    public double getMass()
    {
        return mass;
    }
    
    /**
     * sets mass of this object
     * @param mass mass to assign
     */
    public void setMass(double mass)
    {
        this.mass = mass;
    }
}