public class MutablePhysicsObject extends PhysicsObject
{
    private final double DEFAULTMASS = 10.0;
    
    private double mass;
    
    public MutablePhysicsObject(double mass)
    {
        this.mass = mass;
    }
    
    public MutablePhysicsObject(double mass, double gravity)
    {
        super(gravity);
        this.mass = mass;
    }
    
    public MutablePhysicsObject()
    {
        this.mass = DEFAULTMASS;
    }
    
    public double getMass()
    {
        return mass;
    }
    
    public void setMass(double mass)
    {
        this.mass = mass;
    }
}
