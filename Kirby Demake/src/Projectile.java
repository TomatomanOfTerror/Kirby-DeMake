public class Projectile extends NonlivingMutablePhysicsObject
{
    private int damage;
    private final int DEFAULTDAMAGE = 1;
    
    /**
     * Arg constructor for projectile
     * @param damage amount of damage this projectile deals
     */
    public Projectile(int damage)
    {
        this.setMass(DEFAULTMASS /2.0);
        this.setGravity(0.0);
        this.damage = damage;
    }
    
    /**
     * default constructor has 1 damage
     */
    public Projectile()
    {
        this(1);
    }
    
    /**
     * Returns damage value
     * @return damage (int)
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * Sets damage value
     * @param damage new damage value
     */
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    
    /**
     * Method for resolving when a projectile runs into anything
     * Dissipates and dissapears on walls, does or doesn't do damage to living objects
     * depending upon the projectile's alignment
     * @param collider object this collided with
     */
    public void collideAction(PhysicsObject collider)
    {
        if (collider instanceof ImmutablePhysicsObject)
            collideWall();
        else if (collider instanceof LivingMutablePhysicsObject)
        {
            if (collider instanceof GoodCreature)
                collideGood((GoodCreature)collider);
            else if (collider instanceof EnemyCreature)
                collideBad((EnemyCreature)collider);
            else if (collider instanceof Projectile)
                collideProjectile((Projectile)collider);
        }
    }
    
    /**
     * Dummy method for resolving a projectile colliding with a good entity
     * @param collider object projectile collided with
     */
    public void collideGood(GoodCreature collider)
    {
    
    }
    
    /**
     * Dummy method for resolving a projectile colliding with a bad entity
     * @param collider object projectile collided with
     */
    public void collideBad(EnemyCreature collider)
    {
    
    }
    
    /**
     *  Method for resolving a projectile colliding with a wall
     *  removes the projectile from its current scene
     */
    public void collideWall()
    {
        getSet().remove(this);
    }
    
    /**
     * Dummy method for resolving a projectile colliding with another projectile
     * @param collider
     */
    public void collideProjectile(Projectile collider)
    {
        //Maybe change later to decide which projectiles beat which
    }
}
