
public class TennisGame1 implements TennisGame {
    
    private TennisPlayer player1;
    private TennisPlayer player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new TennisPlayer(player1Name);
        this.player2 = new TennisPlayer(player2Name);
    }

	public void wonPoint(String playerName) {
		if (playerName.equals(player1.getName()))
			player1.incrementScore();
		else
			player2.incrementScore();
	}

    public String getScore() {
        String score = "";
        if (player1.getScore() == player2.getScore())
        {
            score = evaluateWhenBalanced(player1.getScore());
        }
        else if (player1.getScore() >=4 || player2.getScore() >=4)
        {
            score = evaluateAdvantage(player1.getScore(), player2.getScore());
        }
        else
        {
        	int tempScore=0;
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1.getScore();
                else { score+="-"; tempScore = player2.getScore();}
                score = translate2TennisSlang(score, tempScore);
            }
        }
        return score;
    }

	protected String translate2TennisSlang(String score, int tempScore) {
		switch(tempScore)
		{
		    case 0:
		        score+="Love";
		        break;
		    case 1:
		        score+="Fifteen";
		        break;
		    case 2:
		        score+="Thirty";
		        break;
		    case 3:
		        score+="Forty";
		        break;
		}
		return score;
	}

	protected String evaluateWhenBalanced(int score) {
		switch (score) {
		case 0:
			return "Love-All";
		case 1:
			return "Fifteen-All";
		case 2:
			return "Thirty-All";
		default:
			return "Deuce";
		}
	}

	protected String evaluateAdvantage(int scorePlayer1, int scorePlayer2) {
		String score;
		int minusResult = scorePlayer1 - scorePlayer2;
		if (minusResult == 1)
			score = "Advantage " + player1.getName();
		else if (minusResult == -1)
			score = "Advantage " + player2.getName();
		else if (minusResult >= 2)
			score = "Win for " + player1.getName();
		else
			score = "Win for " + player2.getName();
		return score;
	}
}
