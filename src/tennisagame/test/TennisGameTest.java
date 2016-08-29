package tennisgame;
import junit.framework.TestCase;
import tennisgame.test.TennisGame;

public class TennisGameTest extends TestCase {
	
	TennisGame game = new TennisGame("Bj�rn Borg" , "John McEnroe");
	public void testNewGameShouldReturnLoveAll()
	{
		String score = game.getScore();
		
		assertEquals("Love all", score);
	}
	
	public void testPlayerOneWinsFirstBall()
	{
		game.playerOneScores();

		String score = game.getScore();
		assertEquals("Fifteen,Love", score);		
	}
	
	public void testFifteenAll(){
		game.playerOneScores();
		game.playerTwoScores();
		
		String score = game.getScore();
		assertEquals("Fifteen all", score);
	}
	
	public void testPlayerTwoWinsFirstTwoBalls() {
		createScore(0, 2);
		
		String score = game.getScore();
		assertEquals("Love,Thirty", score);
	}
	
	
	public void testPlayerOneWinsFirstThreeBalls(){
		createScore(3, 0);
		String score = game.getScore();
		assertEquals("Forty,Love", score);
	}
	
	public void testPlayersAreDeuce() {
		createScore(3, 3);
		
		String score = game.getScore();
		assertEquals("Deuce", score);		
	}
	
	public void testPlayerOneWinsGame()
	{
		createScore(4, 0);
		
		String score = game.getScore();
		assertEquals("Bj�rn Borg wins", score);
	}
	
	public void testPlayerTwoWinsGame(){
		createScore(1,4);
		
		String score = game.getScore();
		assertEquals("John McEnroe wins", score);
	}
	
	public void testPlayersAreDuce4() {
		createScore(4, 4);
		String score = game.getScore();
		assertEquals("Deuce", score);		
	}

	public void testPlayerTwoAdvantage(){
		createScore(4, 5);
		
		String score = game.getScore();
		assertEquals("Advantage John McEnroe", score);
	}

	public void testPlayerOneAdvantage(){
		createScore(5, 4);
		
		String score = game.getScore();
		assertEquals("Advantage Bj�rn Borg", score);
	}
	
	public void testPlayerTwoWins(){
		createScore(2, 4);
		String score = game.getScore();
		assertEquals("John McEnroe wins", score);
	}
	
	
	public void testPlayerTwoWinsAfterAdvantage() {
		createScore(6, 8);
		String score = game.getScore();
		assertEquals("John McEnroe wins", score);
	}
	
	
	
	public void testPlayerOneWinsAfterAdvantage() {
		createScore(8, 6);
		String score = game.getScore();
		assertEquals("Bj�rn Borg wins", score);
	}
	
	private void createScore(int playerOneBalls, int playerTwoBalls ) {
		for (int i = 0; i < playerOneBalls; i++) {
			game.playerOneScores();
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			game.playerTwoScores();
		}
	}
	
 
}