
public class TennisPlayer {
	
	
	private String name;
	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public TennisPlayer(String playerName) {
		this.name = playerName;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public void incrementScore() {
		score++;
	}
	
	

}
