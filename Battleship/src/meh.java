import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;


public class meh {

	private JFrame frame;
	private JTextField xShip;
	private JLabel ResultLabel;
	private JLabel ResultValue;
	private JButton btnQuit;
	private JTextField textField;

	
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
		lblBattleshipMidterm.setBounds(6, 19, 600, 20);
		lblBattleshipMidterm.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblBattleshipMidterm.setForeground(Color.BLUE);
		lblBattleshipMidterm.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblBattleshipMidterm);
	
		
		JLabel XYcoordLabel = new JLabel("Latitude:");
		XYcoordLabel.setFont(new Font("Arial", Font.BOLD, 20));
		XYcoordLabel.setBounds(275, 112, 103, 20);
		frame.getContentPane().add(XYcoordLabel);
		
		xShip = new JTextField();
		xShip.setHorizontalAlignment(SwingConstants.CENTER);
		xShip.setFont(new Font("Arial Black", Font.BOLD, 20));
		xShip.setColumns(10);
		xShip.setBounds(126, 140, 103, 61);
		frame.getContentPane().add(xShip);
		
		// PLAY BUTTON
		JButton btnPlay = new JButton("Attack!");
		btnPlay.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlay.setBounds(428, 142, 117, 59);
		frame.getContentPane().add(btnPlay);
		btnPlay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent play) 
			{
				ResultValue.setText("You sunk the boat!");
			 }
		});
		
		
		ResultLabel = new JLabel("Result:");
		ResultLabel.setFont(new Font("Arial", Font.BOLD, 24));
		ResultLabel.setBounds(56, 214, 97, 46);
		frame.getContentPane().add(ResultLabel);
		
		ResultValue = new JLabel("");
		ResultValue.setBounds(151, 214, 201, 16);
		frame.getContentPane().add(ResultValue);
		
		// QUIT BUTTON
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(428, 398, 117, 29);
		frame.getContentPane().add(btnQuit);
		
		JLabel NumShotsLabel = new JLabel("IT TOOK");
		NumShotsLabel.setBounds(115, 366, 138, 16);
		frame.getContentPane().add(NumShotsLabel);
		
		JLabel ShotsNumber = new JLabel("");
		ShotsNumber.setBounds(166, 255, 201, 16);
		frame.getContentPane().add(ShotsNumber);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(306, 398, 117, 29);
		frame.getContentPane().add(btnPlayAgain);
		
		//ImageIcon image = new ImageIcon("icon.png");
		JLabel imageLabel = new JLabel(new ImageIcon("/Users/wonitta/projects/Battleship/Battleship/miss.png"));
		imageLabel.setVerticalAlignment(SwingConstants.TOP);
		imageLabel.setLocation(232, 255);
		imageLabel.setSize(81, 37);
		frame.getContentPane().add(imageLabel);
		
		JLabel label = new JLabel("Longitude:");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(126, 112, 103, 20);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(275, 140, 103, 61);
		frame.getContentPane().add(textField);
		
		
		btnQuit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent quit) 
			{
				System.out.println("QUIT THE GAME");
			 }
		});
	}
}
