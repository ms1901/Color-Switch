package application;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class DataTable implements Serializable {

	private static final long serialVersionUID = 42L;
	private static int id = 0;
	private int gameid;
	private int no_of_stars;
	// prrivate int no_of_colorswitcher;
	// ArrayList<Obstacle> List_of_obstacles;
	ArrayList<Integer> List_of_obstacles;
	ArrayList<Double> Positions;
	private String ball_color;
//	ArrayList<Integer> Position_of_ball;
//	ArrayList<Integer> Position_of_colorswitcher;

	public DataTable() {
		id = id + 1;
		this.gameid = id;
		no_of_stars = 0;
		// List_of_obstacles=(ArrayList<Obstacle>) Collections.synchronizedList(new
		// ArrayList<Obstacle>());
		List_of_obstacles = new ArrayList<>();
		Positions = new ArrayList<>();
//		Position_of_ball=new ArrayList<>();
//		Position_of_colorswitcher=new ArrayList<>();
	}

	public void update(int star_count, ArrayList<Integer> obs, ArrayList<Double> arr, String color)

	{
		this.no_of_stars = star_count;
		this.List_of_obstacles = obs;
		this.Positions = arr;
		ball_color = color;
//		this.Position_of_obstacle=obspos;
//		this.Position_of_star=starpos;
//		this.Position_of_colorswitcher=colorpos;

	}

	public void saveGame() {
		Main.getDatabase().getDatabaseFiles().add(this);
		try {
			Main.serialize();
		} catch (IOException e) {
			System.out.println("Can't close stream");
		}
	}

	public int getgameid() {
		return gameid;
	}

	public int getnoofstars() {
		return no_of_stars;
	}

	public ArrayList<Integer> getobstacle() {
		return this.List_of_obstacles;
	}

	public ArrayList<Double> getobspos() {
		return this.Positions;
	}
//	public ArrayList<Integer> getballpos() { return this.Position_of_ball;}
//	public ArrayList<Integer> getcolorpos() { return this.Position_of_colorswitcher;}

	public String getBall_color() {
		return ball_color;
	}

	public void setBall_color(String ball_color) {
		this.ball_color = ball_color;
	}

}
