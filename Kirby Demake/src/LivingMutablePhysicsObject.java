//Anything that has health that it can lose and will die/enter a new state upon losing all of it.
public abstract class LivingMutablePhysicsObject extends MutablePhysicsObject
{
    private int health;
    private int maxHealth;
    
    /**
     * Returns creature's remaining health
     * @return health (int)
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Sets creature's remaining health to given parameter
     * Health will not go outside normal range
     * @param health new amount of health
     */
    public void setHealth(int health)
    {
        this.health = health;
        if (this.health >= maxHealth)
            this.health = maxHealth;
        if (this.health <= 0)
            die();
    }
    
    /**
     * Reduces the creatures health by the given parameter.
     * @param damage amount to reduce health (int)
     */
    public void hurt(int damage)
    {
        health -= damage;
        if (health <= 0)
            die();
    }
    
    /**
     * Increases the creature's health by the given parameter
     * @param amount amount to increase health (int)
     */
    public void heal(int amount)
    {
        health += amount;
        if (health >= maxHealth)
            health = maxHealth;
    }
    
    /**
     * Dummy method for subclasses to override to handle the creature's death
     */
    public void die()
    {}
}
