package batalha;

import java.util.Random;

public class BarcosInimigo extends Barcos implements Interface {
	Random gerador = new Random();


	public int NumeroAleatorio(int x) {
		int n = 0;
		n = gerador.nextInt(x);
		return n;
	}
	
	
	
	public void GerarBarcosInimigos() {
		int escolha = 0;
		escolha = NumeroAleatorio(7);
		
		if(escolha == 0) {
			LocalBarcos[0][0] = true;
			LocalBarcos[0][1] = true;
			LocalBarcos[0][2] = true;
			
			LocalBarcos[0][5] = true;
			LocalBarcos[1][5] = true;
			LocalBarcos[2][5] = true;
			
			LocalBarcos[6][4] = true;
			LocalBarcos[6][5] = true;
			LocalBarcos[6][6] = true;
			
			LocalBarcos[3][4] = true;
			LocalBarcos[3][3] = true;
			LocalBarcos[3][2] = true;
			
			LocalBarcos[4][1] = true;
			LocalBarcos[5][1] = true;
			LocalBarcos[6][1] = true;
			
			LocalBarcos[5][4] = true;
			LocalBarcos[5][5] = true;
			LocalBarcos[5][6] = true;
			
			this.BarcosColocados = 18;
		}
		if(escolha == 1) {
			
			LocalBarcos[0][0] = true;
			LocalBarcos[1][0] = true;
			LocalBarcos[2][0] = true;
			
			LocalBarcos[1][3] = true;
			LocalBarcos[1][4] = true;
			LocalBarcos[1][5] = true;
			
			LocalBarcos[3][2] = true;
			LocalBarcos[4][2] = true;
			LocalBarcos[5][2] = true;
			
			LocalBarcos[3][4] = true;
			LocalBarcos[4][4] = true;
			LocalBarcos[5][4] = true;
			
			LocalBarcos[1][6] = true;
			LocalBarcos[2][6] = true;
			LocalBarcos[3][6] = true;
			
			LocalBarcos[6][4] = true;
			LocalBarcos[6][5] = true;
			LocalBarcos[6][6] = true;
			this.BarcosColocados = 18;
		}
		if(escolha == 2) {
			
			LocalBarcos[0][1] = true;
			LocalBarcos[1][1] = true;
			LocalBarcos[2][1] = true;
			
			LocalBarcos[0][3] = true;
			LocalBarcos[1][3] = true;
			LocalBarcos[2][3] = true;
			
			LocalBarcos[4][0] = true;
			LocalBarcos[4][1] = true;
			LocalBarcos[4][2] = true;
			
			LocalBarcos[6][2] = true;
			LocalBarcos[6][3] = true;
			LocalBarcos[6][4] = true;
			
			LocalBarcos[3][5] = true;
			LocalBarcos[4][5] = true;
			LocalBarcos[5][5] = true;
			
			LocalBarcos[2][4] = true;
			LocalBarcos[2][5] = true;
			LocalBarcos[2][6] = true;
			this.BarcosColocados = 18;
		}
		if(escolha == 3) {
			
			LocalBarcos[0][0] = true;
			LocalBarcos[0][1] = true;
			LocalBarcos[0][2] = true;
			
			LocalBarcos[2][1] = true;
			LocalBarcos[2][2] = true;
			LocalBarcos[2][3] = true;
			
			LocalBarcos[0][5] = true;
			LocalBarcos[1][5] = true;
			LocalBarcos[2][5] = true;
			
			LocalBarcos[4][5] = true;
			LocalBarcos[5][5] = true;
			LocalBarcos[6][5] = true;
			
			LocalBarcos[6][1] = true;
			LocalBarcos[6][2] = true;
			LocalBarcos[6][3] = true;
			
			LocalBarcos[4][2] = true;
			LocalBarcos[4][3] = true;
			LocalBarcos[4][4] = true;
			this.BarcosColocados = 18;
		}
		if(escolha == 4) {
			
			LocalBarcos[0][1] = true;
			LocalBarcos[1][1] = true;
			LocalBarcos[2][1] = true;
			
			LocalBarcos[4][1] = true;
			LocalBarcos[4][2] = true;
			LocalBarcos[4][3] = true;
			
			LocalBarcos[6][3] = true;
			LocalBarcos[6][4] = true;
			LocalBarcos[6][5] = true;
			
			LocalBarcos[1][6] = true;
			LocalBarcos[2][6] = true;
			LocalBarcos[3][6] = true;
			
			LocalBarcos[3][5] = true;
			LocalBarcos[4][5] = true;
			LocalBarcos[5][5] = true;
			
			LocalBarcos[0][2] = true;
			LocalBarcos[1][2] = true;
			LocalBarcos[2][2] = true;
			this.BarcosColocados = 18;
		}
		if(escolha == 5) {
			
			LocalBarcos[4][4] = true;
			LocalBarcos[4][3] = true;
			LocalBarcos[4][2] = true;
			
			LocalBarcos[5][2] = true;
			LocalBarcos[5][3] = true;
			LocalBarcos[5][4] = true;
			
			LocalBarcos[1][6] = true;
			LocalBarcos[2][6] = true;
			LocalBarcos[3][6] = true;
			
			LocalBarcos[0][1] = true;
			LocalBarcos[1][1] = true;
			LocalBarcos[2][1] = true;
			
			LocalBarcos[4][5] = true;
			LocalBarcos[5][5] = true;
			LocalBarcos[6][5] = true;
			
			LocalBarcos[0][2] = true;
			LocalBarcos[1][2] = true;
			LocalBarcos[2][2] = true;
			this.BarcosColocados = 18;
		}
		if(escolha == 6) {
			
			LocalBarcos[0][0] = true;
			LocalBarcos[1][0] = true;
			LocalBarcos[2][0] = true;
			
			LocalBarcos[1][2] = true;
			LocalBarcos[2][2] = true;
			LocalBarcos[3][2] = true;
			
			LocalBarcos[4][1] = true;
			LocalBarcos[5][1] = true;
			LocalBarcos[6][1] = true;
			
			LocalBarcos[0][4] = true;
			LocalBarcos[1][4] = true;
			LocalBarcos[2][4] = true;
			
			LocalBarcos[1][6] = true;
			LocalBarcos[2][6] = true;
			LocalBarcos[3][6] = true;
			
			LocalBarcos[4][5] = true;
			LocalBarcos[5][5] = true;
			LocalBarcos[6][5] = true;
			this.BarcosColocados = 18;
		}
		
	}

}
