import javafx.scene.Group;
import javafx.scene.Scene;

//Helper class to streamline creating objects in actual execution and
//give all objects a way to reference the group they are in and delete themselves
public class PhysicsObjectSet
{
    private Scene scene;
    private Group group;
    private Physics engine;
    
    public PhysicsObjectSet(Scene scene, Group group)
    {
        this.scene = scene;
        this.group = group;
        engine = new Physics();
    }
    
    /**
     * Adds the given PhysicsObject to the Physics and the group
     * @param toAdd object to be added to the group and physics
     */
    public void add(PhysicsObject toAdd)
    {
        engine.add(toAdd);
        group.getChildren().add(toAdd);
        toAdd.setSet(this);
    }
    
    /**
     * removes the given object from the physics and the group, and hides it
     * @param toRemove object to be removed
     */
    public void remove(PhysicsObject toRemove)
    {
        engine.remove(toRemove);
        toRemove.setDisable(true);
        toRemove.setOpacity(0.0);
        group.getChildren().remove(toRemove);
    }
    
    public Scene getScene()
    {
        return scene;
    }
    
    public void setScene(Scene scene)
    {
        this.scene = scene;
    }
    
    public Group getGroup()
    {
        return group;
    }
    
    public void setGroup(Group group)
    {
        this.group = group;
    }
    
    public Physics getEngine()
    {
        return engine;
    }
}