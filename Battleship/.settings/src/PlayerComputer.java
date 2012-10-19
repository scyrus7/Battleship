/**
 * 
 */

/**
 * @author Sam
 *
 */
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
	      
	      if ( shipSize > boardHeight || shipSize > boardWidth ) 
	    	  return false;
	      
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