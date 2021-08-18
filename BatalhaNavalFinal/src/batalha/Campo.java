package batalha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Campo extends JFrame implements MouseListener, KeyListener, Interface{
	
	   JPanel amigo,inimigo;
	   Container c;
	   Inimigo b;
	   Amigo a;
	   Placar pl;
	   BarcosAliado MeusBarcos;
	   BarcosInimigo InimigoIA;

	   int x, y;
	   int CalculoScoreJ = 0, CalculoScoreIA = 0;
	   String ScoreJogadorS, ScoreIAS;
	   double id = 0;
	   boolean[][] TestaTirosRep = new boolean[7][7];
	   Color corFundo = new Color(105, 150, 183);

		
	   Random gerador = new Random();
	   
	   
	   int mx, my;
	   int espacamento = 5;
	   JPanel QuadradosCampoAliado[][] = new JPanel[7][7];
	   JPanel QuadradosCampoInimigo[][] = new JPanel[7][7];
	   JPanel ElementoPlacar[][] = new JPanel[2][2];

	   boolean DebugMode = false;
	   boolean Turno = true;
	   boolean FimDeJogo = false;
   
	   
	   
   public Campo() {
	   
	   addKeyListener(this);
	   instanciarComp();
	   atribuirValor();
	   inserirBlocos();
	   montarTela();
	
	
   }
   
   public void instanciarComp() {
	   
	   // As Classes Amigo e Inimigo são dependentes da Classa Campo composicao
	   // As Classes BarcosAliados e BarcosInimigo são dependentes da Classe Barcos
	   
		   amigo  = new JPanel();
		   inimigo = new JPanel();
		   MeusBarcos = new BarcosAliado();
		   InimigoIA = new BarcosInimigo();
		   pl = new Placar();
	   }
   
   public void atribuirValor() {
	   
		getContentPane().setBackground(corFundo);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(1366,768);
	    setTitle("Batalha Naval - Feito por Aluisio e Daniel");
	    c=getContentPane();
	    c.setLayout(null);
	    
	    InimigoIA.GerarBarcosInimigos();
	    SetarFalso();
   }
   

   
   public void inserirBlocos() {
	   
	  int i,j;
	  
	  for(i = 0; i < 7; i++) {
		  for(j = 0; j < 7; j++) {
			  
			  a =new Amigo();
			  JPanel novo=a.criar();
			  novo.addMouseListener(this);
			  novo.addKeyListener(this);
			  QuadradosCampoAliado[i][j] = novo;
		  }
	  }
	  
	  for(i = 0; i < 7; i++) {
		  for(j = 0; j < 7; j++) {
			  
			  b =new Inimigo();
			  JPanel novo=b.criar();
			  novo.addMouseListener(this);
			  novo.addKeyListener(this);
			  QuadradosCampoInimigo[i][j] = novo;
			  
		  }
	  }
	  
   }
   
   public void montarTela() {
	   
		  for(int i = 0; i < 7; i++) {
			  for (int j = 0; j < 7; j++) {
				  
				  QuadradosCampoAliado[i][j].setLocation((85*i), (85*j)+90);
				  c.add(QuadradosCampoAliado[i][j]);
			  }
		  }
		  
		  for(int i = 0; i < 7; i++) {
			  for (int j = 0; j < 7; j++) {
				  
				  QuadradosCampoInimigo[i][j].setLocation((85*i)+756, (85*j)+90);
				  c.add(QuadradosCampoInimigo[i][j]);
			  }
		  }
		  
		  JPanel placar = pl.criar(MeusBarcos.BarcosDestruidos, InimigoIA.BarcosDestruidos);
		  
		  c.add(placar);
		  
		 setContentPane(c);
	     setVisible(true);
	}

	
   public static void main(String[] args) {
	   new Campo();
   }
   
   
	@Override
	public void mouseClicked(MouseEvent e) {

         if(e.getSource() instanceof JPanel && FimDeJogo == false){
        	 if(e.getSource() instanceof Amigo) {
        			 if(MeusBarcos.BarcosColocados < 18) {
        		
			             JPanel panelPressed = (JPanel) e.getSource();
			             
			             for(int i = 0; i < 7; i++) {
			            	 for(int j = 0; j < 7;j++) {
			            		 
			            		 if(e.getSource() == QuadradosCampoAliado[i][j]) {
	 
			            			 	            				 
			            				 if(e.getSource() == QuadradosCampoAliado[0][j]) {
			            					 
			            					 if(MeusBarcos.LocalBarcos[i+2][j] == false) {
			            						 
			            						 panelPressed.setBackground(Color.cyan);
						            			 //System.out.println(i +" " +j);
						            			 MeusBarcos.LocalBarcos[i][j] = true;
			            						 
			            						 MeusBarcos.LocalBarcos[i+1][j] = true;
					            				 MeusBarcos.LocalBarcos[i+2][j] = true;
					            				 
					            				 QuadradosCampoAliado[i+1][j].setBackground(Color.cyan);
					            				 QuadradosCampoAliado[i+2][j].setBackground(Color.cyan);
					            				 
						            			 MeusBarcos.BarcosColocados +=3;
			            					 }
			            					 
			            					 else {
			            						 
					            				 JOptionPane.showMessageDialog(null, "Posição inválida");

			            					 }
			            					 
			            				 }
			            				 
			            				 else if(e.getSource() == QuadradosCampoAliado[6][j]) {
			            					 
			            					 if(MeusBarcos.LocalBarcos[i-2][j] == false) {
			            						 
			            						 panelPressed.setBackground(Color.cyan);
						            			 //System.out.println(i +" " +j);
						            			 MeusBarcos.LocalBarcos[i][j] = true;
			            						 
			            						 MeusBarcos.LocalBarcos[i-1][j] = true;
					            				 MeusBarcos.LocalBarcos[i-2][j] = true;
					            				 
					            				 QuadradosCampoAliado[i-1][j].setBackground(Color.cyan);
					            				 QuadradosCampoAliado[i-2][j].setBackground(Color.cyan);
					            				 
						            			 MeusBarcos.BarcosColocados +=3;
			            					 }
			            					 
			            					 else {
			            						 
					            				 JOptionPane.showMessageDialog(null, "Posição inválida");

			            					 }
			            				 }
			            				 			            			 

			            				 else if(MeusBarcos.LocalBarcos[i-1][j] == false && MeusBarcos.LocalBarcos[i+1][j] == false) {
			            			 
					            			 panelPressed.setBackground(Color.cyan);
					            			 //System.out.println(i +" " +j);
					            			 MeusBarcos.LocalBarcos[i][j] = true;
					            			         				 
					            			 MeusBarcos.LocalBarcos[i-1][j] = true;
					            			 MeusBarcos.LocalBarcos[i+1][j] = true;
					            			 
					            			 QuadradosCampoAliado[i-1][j].setBackground(Color.cyan);
					            			 QuadradosCampoAliado[i+1][j].setBackground(Color.cyan);
					            			 
					            			 MeusBarcos.BarcosColocados +=3;
		       				
				            			 
			            			 	}
			            			 
				            			 else {
				            				 
				            				 JOptionPane.showMessageDialog(null, "Posição inválida");
				            				 
				            			 }
	
				            		 }
	        
				            	 }
				            	 
				             } 
				             
	        			 }  
	        			 
		         	}
        	 
        	 else if(e.getSource() instanceof Inimigo) {
        		 if(Turno == true) {
        			 if(MeusBarcos.BarcosColocados == 18) {
        				 
		        		 JPanel panelPressed = (JPanel) e.getSource();
		        		 
		                 for(int i = 0; i < 7; i++) {
		                	 for(int j = 0; j < 7;j++) {
		                		 
		                		 if(e.getSource() == QuadradosCampoInimigo[i][j] && InimigoIA.LocalBarcos[i][j] == true && InimigoIA.atirado[i][j] == false) {
		                			 panelPressed.setBackground(Color.magenta);
		                			 //System.out.println(i +" " +j);
		                			 InimigoIA.atirado[i][j] = true;
		                			 InimigoIA.BarcosDestruidos += 1;
		                			 //System.out.println(InimigoIA.BarcosDestruidos);
		                			 TrocaTurno();

		                		 }
		                		 
		                		 else if(e.getSource() == QuadradosCampoInimigo[i][j] && InimigoIA.LocalBarcos[i][j] == false && InimigoIA.atirado[i][j] == false) {
		                			 panelPressed.setBackground(Color.DARK_GRAY);
		                			 InimigoIA.atirado[i][j] = true;
		                			 TrocaTurno();
		                		 }
		                	 }
		                 }
		                 
            			 
            			 if(Turno == false) TiroIA();
            			 CriarScore();
        			 }  
        		 }
        	 }
         } 
         
			VerificaVencedor();

	 }
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {


		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		switch(arg0.getKeyCode())
		{	
		case(KeyEvent.VK_F1):
			if (DebugMode == false) {
				CorDebug();
				DebugMode = true;

			}
		
		}
	}
	
	public void CorDebug() {
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				
				if(InimigoIA.LocalBarcos[i][j] == true) {
					QuadradosCampoInimigo[i][j].setBackground(Color.white);

				}
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void SetarFalso() {
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				
				MeusBarcos.atirado[i][j] = false;
				InimigoIA.atirado[i][j] = false;
			}
		}
		
	}
	
	public void TrocaTurno() {
		
		if(Turno == true) Turno = false;
		else if (Turno == false) Turno = true;
	}
	
	@Override
	public int NumeroAleatorio(int x) {
		
		int n = 0;
		n = gerador.nextInt(x);
		
		return n;
	}
	
	public void VerificaVencedor() {
		
		
		if(MeusBarcos.BarcosDestruidos == 18) {
			
			JOptionPane.showMessageDialog(null, "A IA ganho de você...iiiiiii Perdeu pro BOT");
			FimDeJogo = true;
		}
		
		else if(InimigoIA.BarcosDestruidos == 18){
			
			JOptionPane.showMessageDialog(null, "Parabens meu jovem, você ganhou de um BOT");
			FimDeJogo = true;
		}
	}
	
	public void CriarScore() {
		   
		   	FazerCalculo();
		   	
		   	pl.ScoreJogador.setText(ScoreJogadorS);
		   	pl.ScoreIA.setText(ScoreIAS);
			   
	   }
	   

	public void FazerCalculo() {
		   
		   if(MeusBarcos.BarcosDestruidos % 3 == 0) {
			   
			   CalculoScoreIA = MeusBarcos.BarcosDestruidos / 3;
		   }
		   
		   if(InimigoIA.BarcosDestruidos % 3 == 0) {
			   
			   CalculoScoreJ = InimigoIA.BarcosDestruidos / 3;
		   }
		   
		   ScoreIAS = String.valueOf(CalculoScoreIA);
		   ScoreJogadorS = String.valueOf(CalculoScoreJ);
		   
	   }
	
	public void TiroIA() {

			if(Turno == false) {
				
					if(id == 0) {
				
						x = NumeroAleatorio(7);
						y = NumeroAleatorio(7);
						
						while(MeusBarcos.atirado[x][y] == true) {
							
							x = NumeroAleatorio(7);
							y = NumeroAleatorio(7);
						}
						
						MeusBarcos.atirado[x][y] = true;
						
						QuadradosCampoAliado[x][y].setBackground(Color.DARK_GRAY);
						
						if(MeusBarcos.atirado[x][y] == true && MeusBarcos.LocalBarcos[x][y] == true) {
							
							QuadradosCampoAliado[x][y].setBackground(Color.magenta);
							id++;
						}
				
					}
					
					else if(id == 1) {
						
						if(x == 0) {
							
							MeusBarcos.atirado[x+1][y] = true;
							QuadradosCampoAliado[x+1][y].setBackground(Color.magenta);

							id = 0.1;
						}
						
						else if(x == 6) {
							
							MeusBarcos.atirado[x-1][y] = true;
							
							QuadradosCampoAliado[x-1][y].setBackground(Color.magenta);

							id = 6.1;
						}
						
						
						else if(x == 1) {
							
									
							if(MeusBarcos.atirado[x-1][y] == true) {
											
									MeusBarcos.atirado[x+1][y] = true;
									QuadradosCampoAliado[x+1][y].setBackground(Color.magenta);

									id = 1.22;			
							}
							
							else if(MeusBarcos.atirado[x-1][y] == false){
								
								if(MeusBarcos.LocalBarcos[x-1][y] == true) {
									
									MeusBarcos.atirado[x-1][y] = true;
									QuadradosCampoAliado[x-1][y].setBackground(Color.magenta);
									id = 1.1;
								}
								
								else {
									
									MeusBarcos.atirado[x+1][y] = true;
									QuadradosCampoAliado[x+1][y].setBackground(Color.magenta);

									id = 1.22;
									
								}
								
								
							}

						}
						
						
						else if(x == 5) {
							
							
							if(MeusBarcos.atirado[x+1][y] == true) {
														
									MeusBarcos.atirado[x-1][y] = true;		
									
									QuadradosCampoAliado[x-1][y].setBackground(Color.magenta);
									
									id = 5.22;													
							}
							
							else if(MeusBarcos.atirado[x+1][y] == false) {
								
								if(MeusBarcos.LocalBarcos[x+1][y] == true) {
									
									MeusBarcos.atirado[x+1][y] = true;
									QuadradosCampoAliado[x+1][y].setBackground(Color.magenta);
									
									id = 5.1;
								
									
								}
								
								else {
									
									MeusBarcos.atirado[x-1][y] = true;		
									
									QuadradosCampoAliado[x-1][y].setBackground(Color.magenta);
									
									id = 5.22;	
									
									}		
								}															
							}
							
						
						else {
							
							if(MeusBarcos.atirado[x+1][y] == true) {
															
									MeusBarcos.atirado[x-1][y] = true;
									QuadradosCampoAliado[x-1][y].setBackground(Color.magenta);
									
									id = 10.22;
								
							}
							
							else if(MeusBarcos.atirado[x+1][y] == false) {
								
								if(MeusBarcos.LocalBarcos[x+1][y] == true) {
													
									MeusBarcos.atirado[x+1][y] = true;
									
									QuadradosCampoAliado[x+1][y].setBackground(Color.magenta);
									
									id = 10.1;
									
								}
								else {
									
									MeusBarcos.atirado[x-1][y] = true;
									QuadradosCampoAliado[x-1][y].setBackground(Color.magenta);
									
									id = 10.22;
								}


								
							}
							
						}
					}
					
					else if(id == 0.1) {
						
						MeusBarcos.atirado[x+2][y] = true;
						MeusBarcos.BarcosDestruidos += 3;
						
						QuadradosCampoAliado[x+2][y].setBackground(Color.magenta);
						
						id = 0;
					}
					
					else if(id == 1.1) {
						
						MeusBarcos.atirado[x+1][y] = true;
						MeusBarcos.BarcosDestruidos += 3;
						
						QuadradosCampoAliado[x+1][y].setBackground(Color.magenta);
						
						id = 0;
					}
					
					
					else if(id == 1.22) {
						
						MeusBarcos.atirado[x+2][y] = true;
						MeusBarcos.BarcosDestruidos += 3;
						
						QuadradosCampoAliado[x+2][y].setBackground(Color.magenta);
						
						id = 0;
					}
					
					else if(id == 5.1) {
						
						MeusBarcos.atirado[x-1][y] = true;
						MeusBarcos.BarcosDestruidos += 3;
						
						QuadradosCampoAliado[x-1][y].setBackground(Color.magenta);
						
						id = 0;
						
					}

					
					else if(id == 5.22) {
						
						MeusBarcos.atirado[x-2][y] = true;
						MeusBarcos.BarcosDestruidos += 3;
						
						QuadradosCampoAliado[x-2][y].setBackground(Color.magenta);
						
						id = 0;
					}
						
					else if(id == 6.1) {
						
						MeusBarcos.atirado[x-2][y] = true;
						MeusBarcos.BarcosDestruidos += 3;
						
						QuadradosCampoAliado[x-2][y].setBackground(Color.magenta);

						id = 0;
					}
					
					else if(id == 10.1) {
						
						MeusBarcos.atirado[x+2][y] = true;
						
						if(MeusBarcos.atirado[x+2][y] == true && MeusBarcos.LocalBarcos[x+2][y] == true) {
							
							MeusBarcos.atirado[x+2][y] = true;
							MeusBarcos.BarcosDestruidos += 3;
							
							QuadradosCampoAliado[x+2][y].setBackground(Color.magenta);
							
							id = 0;
						}
						
						else {
							
							QuadradosCampoAliado[x+2][y].setBackground(Color.DARK_GRAY);
							

							id = 10.12;
						}
					}

					else if(id == 10.12) {
						
						MeusBarcos.atirado[x-1][y] = true;
						MeusBarcos.BarcosDestruidos += 3;
						
						QuadradosCampoAliado[x-1][y].setBackground(Color.magenta);
						
						id = 0;
					}

					
					else if(id == 10.22) {
						
						MeusBarcos.atirado[x-2][y] = true;
						MeusBarcos.BarcosDestruidos += 3;
						
						QuadradosCampoAliado[x-2][y].setBackground(Color.magenta);

						id = 0;
					}
					
					TrocaTurno();
					
				}
										
	}
	
}
	
