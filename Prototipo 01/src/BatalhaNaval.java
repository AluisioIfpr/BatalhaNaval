import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class BatalhaNaval extends JFrame {
	JFrame tela;
	JPanel painel;
	Container c;
	
	public BatalhaNaval() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		tela = new JFrame();
		painel = new JPanel();

		PropriedadesTela();
		PropriedadesPainel();
		tela.setVisible(true);

	}
	
	public void PropriedadesTela() {
		tela.setLayout(new GridLayout(7, 7));
		tela.setSize(1024, 768);
		
		for(int i = 0; i < 49; i++) {
			tela.add(new JLabel(new ImageIcon("C:\\Users\\Aluisio\\Desktop\\Batalha/Quadrado.png")));
		}
	
	
	}
	public void PropriedadesPainel() {
		painel.setSize(300, 400);
	}
	
	
}
