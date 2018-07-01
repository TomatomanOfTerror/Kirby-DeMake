public class GoodProjectile extends Projectile
{
    //Default constructor (damage 1, mass 5, gravity 0)
    public GoodProjectile()
    {}
    
    //Arged constructor (@param damage, mass 5, gravity 0)
    public GoodProjectile(int damage)
    {
        super(damage);
    }
    
    /**
     * Deals the enemy creature the projectile's damage, then eliminates the projectile
     * with collideWall()
     * @param collider object projectile collided with
     */
    @Override
    public void collideBad(EnemyCreature collider)
    {
        collider.hurt(getDamage());
        //Probably also some stuff to make the projectile disappear
        collideWall();
    }
}
