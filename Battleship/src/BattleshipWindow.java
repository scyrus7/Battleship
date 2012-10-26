
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;


public class BattleshipWindow
{
    
   public static void main(String[] args)
   {
	   
	   Guindo window = new Guindo();
	   window.frame.setVisible(true);
	   BattleshipMain theGame = new BattleshipMain();    
       //theGame.playGame();
   }

}

class Guindo
{
	public JFrame frame;
	public Guindo()
	{
		initialize("El balserito");
	}

	public void initialize(String mitio) {
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
		
		JLabel lblNewLabel = new JLabel(mitio);
		lblNewLabel.setBounds(269, 76, 61, 16);
		frame.getContentPane().add(lblNewLabel);
	} 
	
}



