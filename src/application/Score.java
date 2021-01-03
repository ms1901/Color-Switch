package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Score implements Serializable {

	private static final long serialVersionUID = 42L;
	private int highscore;
	private int totalscore;
	private int[] TopScores;
	private int starspent;
	// protected static Score ss;

//	static
//	{
//		ss=new Score();
//		setHighscore(0);
//		setTotalscore(0);
//		setTopScores(new int[5]);
//		
//	}

	public Score(int hs, int ts, int[] arr) {
		setHighscore(hs);
		setTotalscore(ts);
		setTopScores(arr);
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public int getTotalscore() {
		return totalscore;
	}

	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}

	public int[] getTopScores() {
		return TopScores;
	}

	public void setTopScores(int[] topScores) {
		TopScores = topScores;
	}

	public void updateTopScores(int cc) {
		System.out.println("current score recieved by the updateTopScore function in score class " + cc);
		int index = -1;
		for (int i = 0; i < 5; i++) {
			if (cc > TopScores[i]) {
				index = i;
				break;
			}
		}

		if (index != -1) {
			for (int i = index + 1; i < 5; i++) {
				TopScores[i] = TopScores[i - 1];
			}

			TopScores[index] = cc;
		}

	}

	public void reducetotalscore(int val) {
		System.out.println("Before updation: " + totalscore);
		totalscore = totalscore - val;
		System.out.println("After updation: " + totalscore);
	}

	public void increaseearnedscore(int val) {
		System.out.println("Before updation: " + starspent);
		starspent = starspent + val;
		System.out.println("After updation: " + starspent);
	}

	public int getStarspent() {
		return starspent;
	}

	public void setStarspent(int starspent) {
		this.starspent = starspent;
	}

}
