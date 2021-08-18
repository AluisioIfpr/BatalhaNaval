package batalha;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Inimigo extends JPanel{
	
	Color corInimigo = new Color(249, 57, 90);
	final int ALTURA=85;
	final int LARGURA=85;
	
	public  Inimigo criar() {
		
		Inimigo p = new Inimigo();
		p.setBounds(0,0, LARGURA, ALTURA);
		p.setBackground(corInimigo);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		p.setBorder(blackline);
		return p;

	}   

   
}
