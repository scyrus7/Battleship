


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

	class BattleshipBoard
	{
	   public static final int  COORD_STATE_BLANK = 0;
	   public static final int  COORD_STATE_SHIP  = 1;
	   public static final int  COORD_STATE_MISS  = 2;
	   public static final int  COORD_STATE_HIT   = 3;
	   
	   public static final int  SHIP_DIR_HORZ     = 0;
	   public static final int  SHIP_DIR_VERT     = 1;

	   private int m_width;
	   private int m_height;
	   
	   private int[][] m_board;
	   
	   private int m_shipSize;
	   private int m_numHits;
	   
	   //
	   // CONSTRUCTOR: Creates the board and sets all coordinates to 'BLANK'.
	   //
	   public BattleshipBoard(int width, int height)
	   {
	      if ( width  < 0 || width  > 40 ) width  = 40;
	      if ( height < 0 || height > 40 ) height = 40;
	      
	      m_width  = width;
	      m_height = height;

	      m_board = new int[m_height][m_width];
	      
	      for ( int i = 0; i < m_height; i++ )
	      {
	         for ( int j = 0; j < m_width; j++ )
	         {
	            m_board[i][j] = COORD_STATE_BLANK;        
	         }
	      }
	      m_shipSize = 0;
	      m_numHits  = 0;

	      System.out.println("Board size (HxW): " + height + ", " + width);
	   }
	   //
	   // PlaceShip: Places the ship at specified coordinate.
	   //
	   public boolean placeShip(int x, int y, int direction, int size)
	   {
	      System.out.println("Specified location: x = " + x + ", y = " + y);                   // Debugging only.
	      System.out.println("Direction: " + (direction == SHIP_DIR_HORZ ? "Horz" : "Vert") ); // Debugging only.

	      if ( x >= m_width || y >= m_height ) return false;
	      
	      if ( direction == SHIP_DIR_HORZ ) { if ( x + size > m_width )  return false; }
	      else                              { if ( y + size > m_height ) return false; }
	   
	      m_shipSize = size;
	      
	      for ( int i = 0; i < size; i++ )
	      {
	         m_board[y][x] = COORD_STATE_SHIP;
	         
	         System.out.println("Marking Coord: x = " + x + ", y = " + y); // Debugging only.
	         
	         if ( direction == SHIP_DIR_HORZ ) x++;
	         else                              y++;
	      }
	      
	      return true; 
	   }
	   //
	   // shootAtShip: Called to take a shot at the ship on the board. The board will return
	   // a status indicating how the shot went.
	   //
	   public int shootAtShip(int x, int y)
	   {
	      if ( x >= m_width || y >= m_height ) return -1;
	      
	      if ( m_board[y][x] == COORD_STATE_HIT || m_board[y][x] == COORD_STATE_MISS ) return -2;
	      
	      if ( m_board[y][x] == COORD_STATE_SHIP ) { m_board[y][x] = COORD_STATE_HIT;  m_numHits++;  }
	      else                                     { m_board[y][x] = COORD_STATE_MISS;               }   

	      return m_board[y][x];
	   }
	   
	   public boolean hasShipBeenSunk()
	   {
	      return (boolean)(m_numHits == m_shipSize);
	   }
	   
	   public int getWidth()  { return m_width;  }
	   public int getHeight() { return m_height; }
	}

	class PlayerComputer
	{
	   PlayerComputer()
	   {
	      //
	      // Add construction code here if required.
	      //
	   }

	   boolean placeShip(BattleshipBoard board, int shipSize)
	   {
	      int boardHeight = board.getHeight();
	      int boardWidth  = board.getWidth();
	      
	      if ( shipSize > boardHeight || shipSize > boardWidth ) return false;
	      
	      int direction = ( Math.random() > 0.5 )? BattleshipBoard.SHIP_DIR_HORZ : BattleshipBoard.SHIP_DIR_VERT;
	      
	      int x, y;
	      
	      if ( direction == BattleshipBoard.SHIP_DIR_HORZ )
	      {
	         x = (int)(Math.random() * (boardWidth-shipSize+1));
	         y = (int)(Math.random() * boardHeight);
	      }
	      else
	      {
	         x = (int)(Math.random() * boardWidth);
	         y = (int)(Math.random() * (boardHeight-shipSize+1));
	      }
	     
	      //
	      // Place on the board.
	      return board.placeShip(x, y, direction, shipSize);
	   }
	}

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




