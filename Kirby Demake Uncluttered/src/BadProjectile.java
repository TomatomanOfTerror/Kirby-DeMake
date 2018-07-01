public class BadProjectile extends Projectile
{
    public BadProjectile()
    {}
    
    public BadProjectile(int damage)
    {
        setDamage(damage);
    }
    
    @Override
    /**
     * Method detailing what happens when this projectile collides with a good creature
     * deals the creature the projectile's damage, then eliminates it with collideWall
     * @param collider creature the projectile collides with
     */
    public void collideGood(GoodCreature collider)
    {
        collider.hurt(getDamage());
        
        collideWall();
    }
}
