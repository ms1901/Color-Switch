package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import com.sun.javafx.geom.Shape;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoadDisplayController implements Initializable {
	boolean start = false;
	static int incrdiff = 3;
	static int score_before = 0;
	Timeline timeline;
	ArrayList<Integer> ObstacleList;
	ArrayList<Integer> obspos;
	KeyEvent e;
	String ball_color;
	SoundController sound;
	int MAXPOINT=20, counter = 0, incr = 0;
	boolean startrainbow = false;
	private Pane tempObstacle;// will contain the outer frame of the obstacle which would go inside the
	
	private Pane temp2;

	@FXML
	private AnchorPane Base;

	@FXML
	private Pane RainbowPane;

	@FXML
	private ImageView hand;

	@FXML
	private ImageView logocs;

	@FXML
	private Circle player;

	@FXML
	private ImageView pause;

	@FXML
	private Label score;

	@FXML
	private Pane CurrentObstaclepane;

	Player currentplayer;
	Obstacle currentObstacle, next;
	double posx, posy;
	float velocity = 1f;
	float acceleration = 1f;
	boolean once = false;
	boolean coll = false;
	boolean obstaclec = true;
	boolean inframe = true;

	@FXML
	void down(MouseEvent event) {
		System.out.println("mouse realeased");

	}

	@FXML
	void Balldown(KeyEvent event) {

	}

	@FXML
	void up(MouseEvent event) {
		System.out.println("mouse pressed");
		// System.out.println(player.);

	}

	@FXML

	void pausegamemenu(KeyEvent event) throws IOException {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		RainbowPane.setVisible(false);
		sound = SoundController.getInstance();
		currentplayer = new Player(player, player.getFill().toString());
		tempObstacle = new Pane();
		temp2 = new Pane();
		tempObstacle.setPrefWidth(700);
		tempObstacle.setPrefHeight(300);

		posx = 0; // pos x
		posy = 0; // pos y
		ObstacleList = new ArrayList<>();
		obspos = new ArrayList<>();
		

		KeyFrame kf = new KeyFrame(Duration.millis(40), e -> {
			try {
				update();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		timeline = new Timeline(kf);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

	}

	@FXML
	void Ballup(KeyEvent event) throws IOException {
		if (!event.getCode().equals(KeyCode.ENTER)) {
			e = event;
			once = true;

			sound.addjump();
			currentplayer.setAcceleration(-1f);
			start = true;
		} else {
			timeline.pause();
			System.out.println("trying to pause game");

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ingamepause.fxml"));
			Parent newgame = fxmlLoader.load();
			Scene newgamewindow = new Scene(newgame, 700, 800);
			ArrayList<Double> arr = new ArrayList<>();
			arr.add(player.getLayoutX());
			arr.add(player.getLayoutY());
			arr.add(tempObstacle.getLayoutX());
			arr.add(tempObstacle.getLayoutY());
			arr.add(temp2.getLayoutX());
			arr.add(temp2.getLayoutY());
			Ingamepausecontroller controller;
			controller = fxmlLoader.<Ingamepausecontroller>getController();
			controller.GameStates(Integer.valueOf(score.getText()), ObstacleList, arr, player.getFill().toString());
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(newgamewindow);

			window.show();
		}

	}

	public void startgame(ArrayList<Integer> arr, int star_count, ArrayList<Double> arr1, String color)
			throws IOException {
		ObstacleList = arr;// you have to change obstacle list in the update function also
		player.setLayoutX(arr1.get(0));
		player.setLayoutY(arr1.get(1));
		tempObstacle.setLayoutX(arr1.get(2));
		tempObstacle.setLayoutY(arr1.get(3));
		temp2.setLayoutX(arr1.get(4));
		temp2.setLayoutY(arr1.get(5));
		ball_color = color;
		Color cc = Color.web(color);
		player.setFill(cc);
		score.setText(Integer.toString(star_count));
		try {

			currentObstacle = Main.obstaclelist(arr.get(0));
			 AnchorPane pp=currentObstacle.getobspane();
//			    pp.setLayoutX(arr1.get(2));
//			    pp.setLayoutY(arr1.get(3));
			    tempObstacle.getChildren().add(pp);
			    CurrentObstaclepane.getChildren().add(tempObstacle);
			    next=Main.obstaclelist(arr.get(1));
			    AnchorPane pn=next.getobspane();
//			    pn.setLayoutX(arr1.get(4));
//			    pn.setLayoutY(arr1.get(5));
			  //temp2.setLayoutX(posx);  temp2.setLayoutY(posy-300);
			    temp2.getChildren().add(pn);
			    CurrentObstaclepane.getChildren().add(temp2);

			if (currentObstacle == null) {
				System.out.println("obstacle loading problem");
			}
		} catch (NullPointerException e) {
			System.out.println("obstacle loading problem");
		}

	}

	private void update() throws IOException, NumberFormatException, ClassNotFoundException {

		if (start ) 
		{
			//System.out.println("this is the score"+score.getText());
			
			counter = 0;

			if (velocity < 5) {
				velocity += currentplayer.getAcceleration();
			}
			if (once && velocity > -10) {
				velocity += currentplayer.getAcceleration();
			} else {
				once = false;
				currentplayer.setAcceleration(1f);
				// acceleration=1f;
			}

			player.setLayoutY(player.getLayoutY() + velocity);
			if (currentObstacle.getcontrol().Collision(player, player.getFill().toString()) == 1
					|| next.getcontrol().Collision(player, player.getFill().toString()) == 1) {
				sound.addstar();
				score.setText(String.valueOf((Integer.valueOf(score.getText()) + 1)));
			}
			if (currentObstacle.getcontrol().Collision(player, player.getFill().toString()) == 0
					|| player.getLayoutY() > 730
					|| next.getcontrol().Collision(player, player.getFill().toString()) == 0) {
				
				timeline.pause();
				System.out.println("Game OVER");
				if (Integer.valueOf(score.getText()) >= 5) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Continuetoplay.fxml"));
					Parent newgame = fxmlLoader.load();
					Scene newgamewindow = new Scene(newgame, 700, 800);
					ArrayList<Double> arr = new ArrayList<>();
					if(currentObstacle.getcontrol().Collision(player, player.getFill().toString()) == 0
							|| next.getcontrol().Collision(player, player.getFill().toString()) == 0)
					{
						arr.add(player.getLayoutX());
						arr.add(player.getLayoutY());
						arr.add(tempObstacle.getLayoutX());
						arr.add(tempObstacle.getLayoutY());
						arr.add(temp2.getLayoutX());
						arr.add(temp2.getLayoutY());
						ContinueController controller;
						controller = fxmlLoader.<ContinueController>getController();
						controller.intializevariables(Integer.valueOf(score.getText())-5, ObstacleList, arr,
								player.getFill().toString());
						Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
						window.setScene(newgamewindow);

						window.show();
					}
					else
					{
						arr.add(367.0);
						arr.add(579.0);
						arr.add(tempObstacle.getLayoutX());
						arr.add(tempObstacle.getLayoutY());
						arr.add(temp2.getLayoutX());
						arr.add(temp2.getLayoutY());
						 try
					        { 
					            // Throw an object of user defined exception 
					            throw new BallHitBottom(Integer.valueOf(score.getText())-5, ObstacleList, arr,player.getFill().toString(),e); 
					        } 
					        catch (BallHitBottom ex) 
					        { 
					            System.out.println("Caught"); 
					  
					           
					        } 
					}
					
					
					

					

				} 
				else {
					try
			        { 
			            // Throw an object of user defined exception 
			            throw new GameLoseException(Integer.valueOf(score.getText()), e); 
			        } 
			        catch (GameLoseException ex) 
			        { 
			            System.out.println("Caught game loss"); 
			  
			           
			        } 
				}

			}

			if (currentplayer.getshape().getLayoutY() < 300)
			{
				currentplayer.getshape().setLayoutY(player.getLayoutY() + 5);
				tempObstacle.setLayoutY(tempObstacle.getLayoutY() + 5);
				temp2.setLayoutY(temp2.getLayoutY() + 5);
			

				if (tempObstacle.getLayoutY() > 510) {
					System.out.println("obstacle is  out");
					inframe = false;

					CurrentObstaclepane.getChildren().remove(tempObstacle);
					tempObstacle.getChildren().remove(currentObstacle.getobspane());
					int b =0;
					if((Integer.valueOf(score.getText()) > 5))
					{
						b= (int) (Math.random() * (8));
					}
					else
					{
						b = (int) (Math.random() * (4));
					}
					
					
					if( Integer.valueOf(score.getText())>=MAXPOINT)
					{
						System.out.println(MAXPOINT);
						System.out.println("************RAINBOW MODE*************");
						currentObstacle=new StarObstacle();
						
						RainbowPane.setVisible(true);
						startrainbow=true;
						MAXPOINT=MAXPOINT+25;
						
					}
					else
					{
						currentObstacle = Main.obstaclelist(b);
						RainbowPane.setVisible(false);
					}
					
			
					

					ObstacleList.set(0, currentObstacle.getid());
					// score_before=Integer.valueOf(score.getText());
					if ((Integer.valueOf(score.getText()) > 6)) {

						System.out.println("*************Score is greater than 2");
						currentObstacle.getcontrol().increasedifficulty(incrdiff);

					}
					tempObstacle.getChildren().add(currentObstacle.getobspane());
					tempObstacle.setLayoutX(posx);
					tempObstacle.setLayoutY(posy - 550);
					CurrentObstaclepane.getChildren().add(tempObstacle);

				}
				if (temp2.getLayoutY() > 500) {
					System.out.println("obstacle is so out");

					CurrentObstaclepane.getChildren().remove(temp2);
					temp2.getChildren().remove(next.getobspane());
					int b =0;
					if((Integer.valueOf(score.getText()) > 5))
					{
						b= (int) (Math.random() * (8));
					}
					else
					{
						b = (int) (Math.random() * (4));
					}
					
					next = Main.obstaclelist(b);
				/*	if(startrainbow1)
					{
						RainbowPane.setVisible(false);
					}
					if( Integer.valueOf(score.getText())>=MAXPOINT)
					{
						next=new StarObstacle();
						MAXPOINT=MAXPOINT+5;
						RainbowPane.setVisible(true);
						startrainbow1=true;
					}*/
					


					if ((Integer.valueOf(score.getText()) > 6)) {

						System.out.println("**************Score is greater than 2");
						next.getcontrol().increasedifficulty(incrdiff);

					}
					ObstacleList.set(1, next.getid());
					temp2.getChildren().add(next.getobspane());
					temp2.setLayoutX(posx);
					temp2.setLayoutY(posy - 550);
					CurrentObstaclepane.getChildren().add(temp2);


				}

			}

		}


		  
		  }
		 	  
		  
}
