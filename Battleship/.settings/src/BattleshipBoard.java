/**
 * 
 */

/**
 * @author Sam
 *
 */
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
	      if ( width  < 0 || width  > 40 ) 
	    	  width  = 40;
	      if ( height < 0 || height > 40 ) 
	    	  height = 40;
	      
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
	      
	      if ( direction == SHIP_DIR_HORZ )
	      {
	    	  if ( x + size > m_width )  
	    		  return false; 
	      }
	      else                             
	      {
	    	  if ( y + size > m_height ) 
	    		  return false; 
	      }
	   
	      m_shipSize = size;
	      
	      for ( int i = 0; i < size; i++ )
	      {
	         m_board[y][x] = COORD_STATE_SHIP;
	         
	         System.out.println("Marking Coord: x = " + x + ", y = " + y); // Debugging only.
	         
	         if ( direction == SHIP_DIR_HORZ )
	        	 x++;
		         else                             
		         y++;
	      }
	      
	      return true; 
	   }
	   //
	   // shootAtShip: Called to take a shot at the ship on the board. The board will return
	   // a status indicating how the shot went.
	   //
	   public int shootAtShip(int x, int y)
	   {
	      if ( x >= m_width || y >= m_height ) 
	    	  return -1;
	      
	      if ( m_board[y][x] == COORD_STATE_HIT || m_board[y][x] == COORD_STATE_MISS )
	    	  return -2;
	      
		      if ( m_board[y][x] == COORD_STATE_SHIP )
		      {
		    	  m_board[y][x] = COORD_STATE_HIT; 
		    	  m_numHits++;  
		      }
			      else                                    
			      {
			    	  m_board[y][x] = COORD_STATE_MISS;               
			      }   

	      return m_board[y][x];
	   }
	   
	   public boolean hasShipBeenSunk()
	   {
	      return (boolean)(m_numHits == m_shipSize);
	   }
	   
	   public int getWidth() 
	   {
		   return m_width;  
	   }
	   public int getHeight() 
	   { 
		   return m_height; 
	}
	}
