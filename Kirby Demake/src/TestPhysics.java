import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.paint.Color;
public class TestPhysics extends Application
{
    public void start(Stage startStage)
    {
        Group objects = new Group();
        MutablePhysicsObject red = new MutablePhysicsObject(4, 0.05);
        MutablePhysicsObject blue = new MutablePhysicsObject(4, -0.05);
        Scene scene = new Scene(objects);
        objects.getChildren().add(red);
        objects.getChildren().add(blue);
        
        red.setTranslateX(300);
        red.setTranslateY(100);
        red.setWidth(50);
        red.setHeight(50);
        red.setFill(Color.TOMATO);
        
        blue.setTranslateX(300);
        blue.setTranslateY(300);
        blue.setWidth(50);
        blue.setHeight(50);
        blue.setFill(Color.BLUE);
        
        Physics movement = new Physics();
        movement.add(red);
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
