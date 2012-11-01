


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
		private static JTextField xShip;
		private static JTextField yShip;
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
		  String myX = JOptionPane.showInputDialog("Enter the width of the board: ");		
		  String myY = JOptionPane.showInputDialog("Enter the height of the board: ");
		  int x = Integer.parseInt(myX);
		  int y = Integer.parseInt(myY);

		  theBoard    = new BattleshipBoard(x, y);
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
			lblBattleshipMidterm.setBounds(0, 20, 600, 30);
			lblBattleshipMidterm.setFont(new Font("Arial", Font.BOLD, 30));
			lblBattleshipMidterm.setForeground(Color.BLUE);
			lblBattleshipMidterm.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(lblBattleshipMidterm);
			
			JLabel XcoordLabel = new JLabel("Longitude:");
			XcoordLabel.setFont(new Font("Arial", Font.BOLD, 20));
			XcoordLabel.setBounds(126, 112, 103, 20);
			frame.getContentPane().add(XcoordLabel);
			
			xShip = new JTextField();
			xShip.setColumns(10);
			xShip.setHorizontalAlignment(SwingConstants.CENTER);
			xShip.setFont(new Font("Arial Black", Font.BOLD, 26));			
			xShip.setBounds(126, 140, 103, 61);
			frame.getContentPane().add(xShip);
			
			
			JLabel YcoordLabel = new JLabel("Latitude:");
			YcoordLabel.setFont(new Font("Arial", Font.BOLD, 20));
			YcoordLabel.setBounds(275, 112, 103, 20);
			frame.getContentPane().add(YcoordLabel);

			yShip = new JTextField();
			yShip.setColumns(10);
			yShip.setHorizontalAlignment(SwingConstants.CENTER);
			yShip.setFont(new Font("Arial Black", Font.BOLD, 26));
			yShip.setBounds(275, 140, 103, 61);
			frame.getContentPane().add(yShip);
			
    		// MISS IMAGE
			final JLabel missImage = new JLabel(new ImageIcon("/Users/wonitta/projects/Battleship/Battleship/miss.png"));
    		missImage.setVerticalAlignment(SwingConstants.TOP);
    		missImage.setLocation(275, 206);
    		missImage.setSize(100, 37);
    		frame.getContentPane().add(missImage);
    		missImage.setVisible(false);
			
    		// HIT IMAGE
			final JLabel hitImage = new JLabel(new ImageIcon("/Users/wonitta/projects/Battleship/Battleship/hit.png"));
    		hitImage.setVerticalAlignment(SwingConstants.TOP);
    		hitImage.setLocation(275, 206);
    		hitImage.setSize(100, 96);
    		frame.getContentPane().add(hitImage);
    		hitImage.setVisible(false);

    		
			// NUMBER OF SHOTS
			final JLabel NumShotsLabel = new JLabel("Number of shots:");
			NumShotsLabel.setBounds(56, 255, 120, 16);
			frame.getContentPane().add(NumShotsLabel);
			final JLabel ShotsNumber = new JLabel("");
			ShotsNumber.setBounds(190, 255, 201, 16);
			frame.getContentPane().add(ShotsNumber);
            NumShotsLabel.setVisible(false);
            ShotsNumber.setVisible(false);
			
			// PLAY BUTTON
    		final JButton btnPlay = new JButton("Attack!");
    		btnPlay.setFont(new Font("Arial", Font.BOLD, 20));
    		btnPlay.setBounds(428, 142, 117, 59);
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
			                 missImage.setVisible(false);
			                 hitImage.setVisible(true);			                 
			                 if ( theBoard.hasShipBeenSunk() )
			                 {
				                 ResultValue.setText("YOU'VE SUNK THE BATTLESHIP!");
				                 missImage.setVisible(false);
				                 hitImage.setVisible(false);			            				            	
				                 NumShotsLabel.setVisible(true);
				                 ShotsNumber.setVisible(true);			                     
				                 String mitio;
			                     mitio = Integer.toString(numShots);
				                 ShotsNumber.setText(mitio);
				                 btnPlay.setEnabled(false);
				                 btnPlayAgain.setVisible(true);               
			                 }
			                 break;
			            case SHOT_RESULT_MISS: 	
			                hitImage.setVisible(false);			        		
			            	missImage.setVisible(true);
			            	ResultValue.setText("MISS!!");
			                 numShots++;			                 
			                 break;
			            case SHOT_RESULT_INVALID:
			                 missImage.setVisible(false);
			                 hitImage.setVisible(false);			            				            	
			                 ResultValue.setText("You have specified an invalid coordinate.");
			                 break;
			            case SHOT_RESULT_USED: 
			                 missImage.setVisible(false);
			                 hitImage.setVisible(false);			            				            			            	
			                 ResultValue.setText("You already took that shot");
			                 break;
			         }
					xShip.setText(null);
					yShip.setText(null);
					xShip.requestFocus();
				}
			});
			
			// PLAY RESULT
			ResultValue = new JLabel("");
			ResultValue.setBounds(190, 214, 400, 30);
			ResultValue.setFont(new Font("Arial", Font.BOLD, 24));
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