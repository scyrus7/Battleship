import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Sam
 *
 */
class PlayerUser
	{
	   public static final int SHOT_RESULT_HIT      = 1;
	   public static final int SHOT_RESULT_MISS     = 2;
	   public static final int SHOT_RESULT_INVALID  = 3;
	   public static final int SHOT_RESULT_USED     = 4;
	   public static final int SHOT_RESULT_QUIT     = 5;

	   public PlayerUser()
	   {
	      //
	      // Add construction code here if required.
	      //
	   }
	   
	   public int takeShot(BattleshipBoard board)
	   {
	      //
	      // Ask the user to enter the x coordinate.
	      int xCoord = getCoordinate("x");  if ( xCoord == -1 ) return SHOT_RESULT_QUIT;
	      int yCoord = getCoordinate("y");  if ( yCoord == -1 ) return SHOT_RESULT_QUIT;
	      
	      switch ( board.shootAtShip(xCoord, yCoord) )
	      {
	         case BattleshipBoard.COORD_STATE_MISS: return SHOT_RESULT_MISS;
	         case BattleshipBoard.COORD_STATE_HIT:  return SHOT_RESULT_HIT;
	         case -2:                               return SHOT_RESULT_USED;
	      }
	      
	      return SHOT_RESULT_INVALID;
	   }
	   
	   private int getCoordinate(String coordType)
	   {
	      BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

	      System.out.print("Please enter the " + coordType + " coordinate ('Q' to quit):");
	      
	      do
	      {
	         try 
	         {
	            String line = keyboard.readLine();
	         
	            if ( line.length() > 0 )
	            {
	               if ( Character.toUpperCase(line.charAt(0)) == 'Q' ) return -1; 
	         
	               int coord = Integer.parseInt(line);
	            
	               return coord;
	            }
		      }
		      catch ( IOException e1 )
		      {
		         System.out.println("IOException occurred. Aborting.");
		         
		         System.exit(1);
		      }
		      catch ( NumberFormatException e2 )
		      {
	            System.out.print("Please enter a number or 'Q' to quit:");
		      }
	      }  while ( true ) ;
	   }      
	}