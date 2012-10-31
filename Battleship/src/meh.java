import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;


public class meh {

	private JFrame frame;
	private JTextField BoardWidth;
	private JTextField BoardHeight;
	private JLabel label;
	private JTextField xShip;
	private JTextField yShip;
	private JLabel ResultLabel;
	private JLabel ResultValue;
	private JButton btnQuit;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					meh window = new meh();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public meh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		// PLAY BUTTON
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(428, 142, 117, 29);
		frame.getContentPane().add(btnPlay);
		btnPlay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent play) 
			{
				ResultValue.setText("You sunk the boat!");
			 }
		});
		
		
		ResultLabel = new JLabel("Result:");
		ResultLabel.setBounds(56, 214, 61, 16);
		frame.getContentPane().add(ResultLabel);
		
		ResultValue = new JLabel("");
		ResultValue.setBounds(151, 214, 335, 16);
		frame.getContentPane().add(ResultValue);
		
		// QUIT BUTTON
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(428, 398, 117, 29);
		frame.getContentPane().add(btnQuit);
		
		JLabel NumShotsLabel = new JLabel("# of shots:");
		NumShotsLabel.setBounds(56, 255, 81, 16);
		frame.getContentPane().add(NumShotsLabel);
		
		JLabel ShotsNumber = new JLabel("");
		ShotsNumber.setBounds(151, 255, 201, 16);
		frame.getContentPane().add(ShotsNumber);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(306, 398, 117, 29);
		frame.getContentPane().add(btnPlayAgain);
		btnQuit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent quit) 
			{
				System.out.println("QUIT THE GAME");
			 }
		});
	}
}
