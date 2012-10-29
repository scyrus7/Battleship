
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.EventQueue;
import java.io.*;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;



class BattleshipWindow
{
	public JFrame frame;
	public JTextField BoardWidth;
	public JTextField BoardHeight;
	public JLabel label;
	public JTextField xShip;
	public JTextField yShip;
	public JLabel ResultLabel;
	public JLabel ResultValue;
	public JButton btnQuit;

	public BattleshipWindow()
	{
		initialize("BATTLESHIP GAME");
	}

	public void initialize(String boardsizevalue) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBattleshipMidterm = new JLabel("BATTLESHIP MIDTERM");
		lblBattleshipMidterm.setBounds(0, 0, 600, 20);
		lblBattleshipMidterm.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblBattleshipMidterm.setForeground(Color.RED);
		lblBattleshipMidterm.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblBattleshipMidterm);
		
		JLabel XYcoordLabel = new JLabel("Please enter the X/Ycoordinate:");
		XYcoordLabel.setBounds(56, 112, 198, 16);
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
		xShip.setBounds(275, 106, 55, 28);
		frame.getContentPane().add(xShip);
		
		yShip = new JTextField();
		yShip.setColumns(10);
		yShip.setBounds(342, 106, 55, 28);
		frame.getContentPane().add(yShip);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(428, 107, 117, 29);
		frame.getContentPane().add(btnPlay);
		
		ResultLabel = new JLabel("Result:");
		ResultLabel.setBounds(56, 179, 61, 16);
		frame.getContentPane().add(ResultLabel);
		
		ResultValue = new JLabel("");
		ResultValue.setBounds(129, 179, 61, 16);
		frame.getContentPane().add(ResultValue);
		
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(428, 398, 117, 29);
		frame.getContentPane().add(btnQuit);

	} 
	
}



