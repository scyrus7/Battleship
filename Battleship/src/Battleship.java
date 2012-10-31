


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

	public class Battleship
	{
	   static BattleshipBoard theBoard;
	   PlayerComputer  theComputer;

	   // GUI
		private static JFrame frame;
		private static JTextField BoardWidth;
		private static JTextField BoardHeight;
		private static JLabel label;
		private static JTextField xShip;
		private static JTextField yShip;
		private static JLabel ResultLabel;
		private static JLabel ResultValue;
		private static JButton btnQuit;
	    public static final int SHOT_RESULT_HIT      = 1;
	    public static final int SHOT_RESULT_MISS     = 2;
	    public static final int SHOT_RESULT_INVALID  = 3;
	    public static final int SHOT_RESULT_USED     = 4;
	    public static final int SHOT_RESULT_QUIT     = 5;
	    static int numShots = 0;
 
	   
	   public static void main(String[] args)
	   {
	       final ImageIcon icon = new ImageIcon("icon.png");
	       JOptionPane.showMessageDialog(null, "BATTLESHIP MIDTERM!", "Welcome", JOptionPane.INFORMATION_MESSAGE, icon);
		   initializeGUI();	
		   startGame();
	   }
	   
	@SuppressWarnings("static-access")
	public static void startGame()
	   {
		   Battleship theGame = new Battleship();    
		   theGame.frame.setVisible(true);
		   theGame.playGame();
	   }
	   
	   public static int takeShot(BattleshipBoard board, int xCoord, int yCoord)
	   {
	      // Ask the user to enter the x coordinate.
	      switch ( board.shootAtShip(xCoord, yCoord) )
	      {
	         case BattleshipBoard.COORD_STATE_MISS: 
	        	 return SHOT_RESULT_MISS;
	         case BattleshipBoard.COORD_STATE_HIT: 
	        	 return SHOT_RESULT_HIT;
	         case -2:                              
	        	 return SHOT_RESULT_USED;
	      }
	      
	      return SHOT_RESULT_INVALID;
	   }

	   
	   public Battleship()
	   {
		  theBoard    = new BattleshipBoard(10, 10);
	      theComputer = new PlayerComputer();
	   }

	   public void playGame()
	   {
	      int shipSize = 4;
	      theComputer.placeShip(theBoard, shipSize);
	   }

		public static void initializeGUI() {

			frame = new JFrame();
			frame.setBounds(100, 100, 600, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			// HEADER TITLE
			JLabel lblBattleshipMidterm = new JLabel("BATTLESHIP MIDTERM");
			lblBattleshipMidterm.setBounds(0, 0, 600, 20);
			lblBattleshipMidterm.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblBattleshipMidterm.setForeground(Color.BLUE);
			lblBattleshipMidterm.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(lblBattleshipMidterm);
			
			JLabel XYcoordLabel = new JLabel("Please enter the X/Ycoordinate:");
			XYcoordLabel.setBounds(56, 147, 198, 16);
			frame.getContentPane().add(XYcoordLabel);
			
			BoardWidth = new JTextField();
			BoardWidth.setBounds(163, 58, 55, 28);
			frame.getContentPane().add(BoardWidth);
			BoardWidth.setColumns(10);
			
			BoardHeight = new JTextField();
			BoardHeight.setColumns(10);
			BoardHeight.setBounds(249, 58, 55, 28);
			frame.getContentPane().add(BoardHeight);
			
			label = new JLabel("Board Size:");
			label.setBounds(56, 64, 81, 16);
			frame.getContentPane().add(label);
			
			xShip = new JTextField();
			xShip.setColumns(10);
			xShip.setBounds(275, 141, 55, 28);
			frame.getContentPane().add(xShip);
			
			
			yShip = new JTextField();
			yShip.setColumns(10);
			yShip.setBounds(342, 141, 55, 28);
			frame.getContentPane().add(yShip);
			
			// NUMBER OF SHOTS
			JLabel NumShotsLabel = new JLabel("# of shots:");
			NumShotsLabel.setBounds(56, 255, 81, 16);
			frame.getContentPane().add(NumShotsLabel);
			final JLabel ShotsNumber = new JLabel("");
			ShotsNumber.setBounds(151, 255, 201, 16);
			frame.getContentPane().add(ShotsNumber);
						
			
			// PLAY BUTTON
			final JButton btnPlay = new JButton("Play");
			btnPlay.setBounds(428, 142, 117, 29);
			frame.getContentPane().add(btnPlay);

			// PLAY AGAIN BUTTON
			final JButton btnPlayAgain = new JButton("Play Again");
			btnPlayAgain.setBounds(306, 398, 117, 29);
			frame.getContentPane().add(btnPlayAgain);
            btnPlayAgain.setVisible(false);
			btnPlayAgain.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent playagain) 
				{
					numShots = 0;
					xShip.setText(null);
					yShip.setText(null);
					ResultValue.setText(null);
					ShotsNumber.setText(null);
					startGame();					
					btnPlay.setEnabled(true);
				 }
			});
			
			
			btnPlay.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent play) 
				{
					int xCoord = Integer.parseInt(xShip.getText());
					int yCoord = Integer.parseInt(yShip.getText());
				    
					switch ( takeShot(theBoard, xCoord, yCoord) )
			         {
			            case SHOT_RESULT_HIT:         
			                 numShots++;
			                 ResultValue.setText("HIT!!");
			                 if ( theBoard.hasShipBeenSunk() )
			                 {
				                 ResultValue.setText("YOU'VE SUNK THE BATTLESHIP!");
			                     String mitio;
			                     mitio = Integer.toString(numShots);
				                 ShotsNumber.setText(mitio);
				                 btnPlay.setEnabled(false);
				                 btnPlayAgain.setVisible(true);               
			                 }
			                 break;
			            case SHOT_RESULT_MISS:         
			                 ResultValue.setText("MISS!!");
			                 numShots++;
			                 break;
			            case SHOT_RESULT_INVALID:
			                 ResultValue.setText("You have specified an invalid coordinate.");
			                 break;
			            case SHOT_RESULT_USED:         
			                 ResultValue.setText("That coordinate has already been used.");
			                 break;
			         }
					xShip.setText(null);
					yShip.setText(null);
					xShip.requestFocus();
				}
			});
			
			// PLAY RESULT
			ResultLabel = new JLabel("Result:");
			ResultLabel.setBounds(56, 214, 61, 16);
			frame.getContentPane().add(ResultLabel);			
			ResultValue = new JLabel("");
			ResultValue.setBounds(129, 214, 370, 16);
			frame.getContentPane().add(ResultValue);
			
			
			// QUIT BUTTON
			btnQuit = new JButton("Quit");
			btnQuit.setBounds(428, 398, 117, 29);
			frame.getContentPane().add(btnQuit);
			btnQuit.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent quit) 
				{
					System.exit(0);    
				 }
			});
		}
	   
	   
	} // Battleship