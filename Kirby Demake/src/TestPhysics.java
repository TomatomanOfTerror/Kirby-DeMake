import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.paint.Color;
public class TestPhysics extends Application
{
    public void start(Stage startStage)
    {
        Group objects = new Group();
        Kirby player = new Kirby();
        ImmutablePhysicsObject blue = new ImmutablePhysicsObject(0);
        Scene scene = new Scene(objects);
        objects.getChildren().add(player);
        player.activateControls(scene);
        objects.getChildren().add(blue);
        
        player.setTranslateX(300);
        player.setTranslateY(100);
        player.setWidth(50);
        player.setHeight(50);
        player.setxVelocity(0);
        
        blue.setTranslateX(300);
        blue.setTranslateY(300);
        blue.setWidth(50);
        blue.setHeight(50);
        blue.setFill(Color.BLUE);
        
        Physics movement = new Physics();
        movement.add(player);
        movement.add(blue);
        movement.start();
        
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
