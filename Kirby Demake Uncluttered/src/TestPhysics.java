import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.paint.Color;
public class TestPhysics extends Application
{
    public void start(Stage startStage)
    {
        Group objects = new Group();
        Kirby player = new Kirby(objects);
        
        ImmutablePhysicsObject blue = new ImmutablePhysicsObject(0);
        BadProjectile death = new BadProjectile();
        Scene scene = new Scene(objects);
        player.activateControls(scene);
        
        player.setTranslateX(300);
        player.setTranslateY(100);
        player.setxVelocity(0);
        
        death.setWidth(50);
        death.setHeight(25);
        death.setTranslateX(100);
        death.setTranslateY(250);
        death.setxVelocity(1);
        death.setFill(Color.BLACK);
        death.setOpacity(1.0);
        death.toFront();
        
        
        blue.setTranslateX(300);
        blue.setTranslateY(300);
        blue.setWidth(50);
        blue.setHeight(50);
        blue.setFill(Color.BLUE);
        
        PhysicsObjectSet movement = new PhysicsObjectSet(scene, objects);
        movement.add(player);
        movement.add(blue);
        movement.add(death);
        movement.getEngine().start();
        
        startStage.setScene(scene);
        startStage.setTitle("TEST");
        startStage.setWidth(800);
        startStage.setHeight(600);
        startStage.show();
    }
    
    public static void main(String[] args)
    {
        launch();
    }
}