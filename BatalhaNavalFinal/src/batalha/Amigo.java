package batalha;

import java.awt.Color;


import javax.swing.BorderFactory;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class Amigo extends JPanel{
	
	  final int ALTURA=85;
	  final int LARGURA=85;
	  Color corAmigo = new Color(0, 95, 212);

	  
	public Amigo criar() {
		Amigo p = new Amigo();
		p.setBounds(0,0, LARGURA, ALTURA);
		p.setBackground(corAmigo);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		p.setBorder(blackline);
		return p;
	}

	
}
