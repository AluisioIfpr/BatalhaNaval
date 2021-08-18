package batalha;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;


public class Placar extends JPanel{
	
	  final Color COR=Color.white;
	  final int ALTURA=85;
	  final int LARGURA=300;
	  
	  
	  JLabel Jogador = new JLabel("Jogador ");
	  JLabel IA = new JLabel("IA");
	  JLabel ScoreJogador = new JLabel("0");
	  JLabel ScoreIA = new JLabel("0");

	  Placar pl;
	  

	  
	public Placar criar(int x, int y) {
				
		Jogador.setForeground(Color.black);
		Jogador.setFont(new Font("MV Boli", Font.BOLD, 25));
			
		IA.setForeground(Color.black);
		IA.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		ScoreJogador.setForeground(Color.black);
		ScoreJogador.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		ScoreIA.setForeground(Color.black);
		ScoreIA.setFont(new Font("MV Boli", Font.BOLD, 25));

		
		pl = new Placar();
				
		pl.setBounds(585,0, LARGURA, ALTURA);
		pl.setBackground(new Color(105, 150, 183));
		pl.setLayout(new GridLayout(2,2));

		
		pl.add(Jogador);
		pl.add(IA);
		pl.add(ScoreJogador);
		pl.add(ScoreIA);

		return pl;
	}

}

