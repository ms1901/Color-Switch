package application;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

//import com.sun.javafx.geom.Shape;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SpinWheelcontroller implements Initializable {



@FXML
   private Label WheelResultLabel;

@FXML
   private ImageView SpinWheelImage;

   @FXML
   private Pane wheel;

   @FXML
   private Circle yellow;

   @FXML
   private Circle light_green;

   @FXML
   private Circle red;

   @FXML
   private Circle dark_green;

   @FXML
   private Circle blue;

   @FXML
   private Circle dark_pink;

   @FXML
   private Circle pink;

   @FXML
   private Circle orange;

   @FXML
   private Circle blue_shade;

   @FXML
   private Circle purple;

   @FXML
   private Circle darkpurple;

   @FXML
   private Circle dark_blue;

   @FXML
   private Line stick;
   
    private RotateTransition rt ;
   
    Random rand ;
   
    @FXML
    void StopRotation(MouseEvent event) throws ClassNotFoundException, FileNotFoundException, IOException {
   
    rt.stop();
    Collision();

    }
    @FXML
    private ImageView home;

  

    @FXML
    void backhome(MouseEvent event) throws IOException {
    	System.out.println("back to main menu clicked");
		Parent newgame = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene newgamewindow = new Scene(newgame, 700, 800);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(newgamewindow);
		window.show();


    }
public void Collision() throws ClassNotFoundException, FileNotFoundException, IOException {



Shape intersect1 = Shape.intersect(stick, yellow);
Shape intersect2 = Shape.intersect(stick, light_green);
Shape intersect3 = Shape.intersect(stick, red);
Shape intersect4 = Shape.intersect(stick, dark_green);
Shape intersect5 = Shape.intersect(stick, blue);
Shape intersect6 = Shape.intersect(stick, dark_pink);
Shape intersect7 = Shape.intersect(stick, pink);
Shape intersect8 = Shape.intersect(stick, orange);
Shape intersect9 = Shape.intersect(stick, blue_shade);
Shape intersect10 = Shape.intersect(stick, purple);
Shape intersect11 = Shape.intersect(stick, darkpurple);
Shape intersect12 = Shape.intersect(stick,dark_blue);
if (intersect1.getBoundsInParent().getWidth() > 0)

{
System.out.println("Yellow is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+10);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+10);

}
if (intersect2.getBoundsInParent().getWidth() > 0)

{
System.out.println("light green is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+9);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+9);

}
if (intersect3.getBoundsInParent().getWidth() > 0)

{
System.out.println("red is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+8);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+8);

}
if (intersect4.getBoundsInParent().getWidth() > 0)

{
System.out.println("dark green  is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+7);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations!You have won "+7);

}
if (intersect5.getBoundsInParent().getWidth() > 0)

{
System.out.println("blue is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+6);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations! You have won "+6);

}
if (intersect6.getBoundsInParent().getWidth() > 0)

{
System.out.println("dark pink is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+5);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations !You have won "+5);

}
if (intersect7.getBoundsInParent().getWidth() > 0)

{
System.out.println("pink is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+4);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+4);

}
if (intersect8.getBoundsInParent().getWidth() > 0)

{
System.out.println("orange is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+3);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+3);

}
if (intersect9.getBoundsInParent().getWidth() > 0)

{
System.out.println("blue shade  is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+1);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+1);

}
if (intersect10.getBoundsInParent().getWidth() > 0)

{
System.out.println("purple is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+2);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+2);

}
if (intersect11.getBoundsInParent().getWidth() > 0)

{
System.out.println("dark purple is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+8);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+8);

}
if (intersect12.getBoundsInParent().getWidth() > 0)

{
System.out.println("dark_blue is coosen");
Main.deserialize();

Main.getDatabase().getSavedscore().setTotalscore(Main.getDatabase().getSavedscore().getTotalscore()+1);
 Main.serialize();
 
 WheelResultLabel.setText("Congratulations ! You have won "+1);

}






}

private void setRotate(Pane r, boolean reverse, int angle, int duration)

{
System.out.println("Wheel is rotating");
rt = new RotateTransition(Duration.seconds(duration), r);
rt.setFromAngle(0);
rt.setToAngle(angle);
rt.setCycleCount(100);

rt.play();

}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
setRotate(wheel, true, 360, 3);
rand = new Random();
int num=rand.nextInt(7);
if(num<=0 || num==1 )
{
num=rand.nextInt(7);
}
System.out.println("num: "+num);
//Collision(num);
//setRotate(PointerPane, true, -360, 3);
}

}