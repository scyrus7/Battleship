


	/**
	 * @param args
	 */
	import java.io.*;

	public class Battleship
	{
	   BattleshipBoard theBoard;

	   PlayerComputer  theComputer;
	   PlayerUser      theUser;
	   
	   public Battleship()
	   {
	      theBoard    = new BattleshipBoard(10, 10);
	      theComputer = new PlayerComputer();
	      theUser     = new PlayerUser();
	      
	      System.out.println("Ready to play!!");
	   }

	   public void playGame()
	   {
	      boolean gameOn = true;
	      
	      int numShots = 0;
	      
	      int shipSize = 4;

	      if ( !theComputer.placeShip(theBoard, shipSize) )
	      {
	         System.out.println("Error placing ship!"); return;
	      }
	      
	      while ( gameOn )
	      {
	         switch ( theUser.takeShot(theBoard) )
	         {
	            case PlayerUser.SHOT_RESULT_HIT:         
	                 numShots++;
	                 System.out.println("Hit!!");
	                 if ( theBoard.hasShipBeenSunk() )
	                 {
	                    System.out.println("You've sunk my battleship!!");
	                    System.out.println("You took " + numShots + " turns.");
	                    gameOn = false;
	                 }
	                 break;
	            case PlayerUser.SHOT_RESULT_MISS:         
	                 System.out.println("Miss!!");
	                 numShots++;
	                 break;
	            case PlayerUser.SHOT_RESULT_INVALID:
	                 System.out.println("You have specified an invalid coordinate.");
	                 break;
	            case PlayerUser.SHOT_RESULT_USED:         
	                 System.out.println("That coordinate has already been used.");
	                 break;
	            case PlayerUser.SHOT_RESULT_QUIT:         
	                 System.out.println("Quittng game.");
	                 gameOn = false;     
	                 break;
	         }
	      }
	   }
	   
	   public static void main(String[] args)
	   {
	      Battleship theGame = new Battleship();
	      
	      theGame.playGame();
	   }
	}