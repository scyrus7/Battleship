	class Setup
	{

	   boolean placeShip(BattleshipBoard board, int shipSize)
	   {
	      int boardHeight = board.getHeight();
	      int boardWidth  = board.getWidth();
	      	      
	      // RANDOM 50-50 TO CHOOSE HORIZONTAL/VERTICAL ORIENTATION
	      int direction = ( Math.random() > 0.5 )? BattleshipBoard.SHIP_DIR_HORZ : BattleshipBoard.SHIP_DIR_VERT;
	      
	      int x, y;
	      
	      // PLACES SHIP RANDOMELY USING SIZE BASED ON DIRECTION
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
	      // SETUP THE BOARD
	      return board.placeShip(x, y, direction, shipSize);
	   }
	}