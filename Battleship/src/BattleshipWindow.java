
import javax.swing.JFrame;
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
		
		JLabel BoardSizeLabel = new JLabel("Board Size:");
		BoardSizeLabel.setBounds(70, 64, 81, 16);
		frame.getContentPane().add(BoardSizeLabel);
		
		JLabel boardsize = new JLabel(boardsizevalue);
		boardsize.setBounds(163, 64, 81, 16);
		frame.getContentPane().add(boardsize);
	} 
	
}



