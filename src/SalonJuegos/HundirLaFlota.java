package SalonJuegos;

import java.util.Arrays;
import java.util.Scanner;

public class HundirLaFlota {
	
	//Declaracion de los barcos, el tablero y la vida de los barcos.
		public static char[][] board=new char[10][10];
		public static int[][] barco1=new int[2][3];
		public static int[][] barco2=new int[2][3];
		public static int[][] barco3=new int[2][4];
		public static int b1=3,b2=3,b3=4,nB=3;
		
		public static void main() {
			
			boolean bucle=true;
			
			//llamada al metodo para rellenar el tablero
			fillin(board);
			
			//llamada a al metodo rellenar los barcos con sus coordenadas la fila 0 es el 'eje y' y la fila 1 'eje x'.
			place(barco1);
			place(barco2);
			place(barco3);
			
			//comprobacion de que los barcos no se pongan uno encima de otro. Se comprueba cada coordenada de los barcos con todas de los demas barcos.
			do {
				for(int j=0;j<barco1[0].length;j++) {//primero se comprueba el barco 1 y el barco 2.
					for(int w=0;w<barco2[0].length;w++) {
						if(barco1[0][j]==barco2[0][w] && barco1[1][j]==barco2[1][w] ) {
							place(barco2);	
						}
						for(int r=0;r<barco3[0].length;r++) {//se comprueba despues barco 1 con 3 y barco 2 con 3.
							if(barco1[0][j]==barco3[0][r] && barco1[1][j]==barco3[1][r] || barco2[0][w]==barco3[0][r] && barco2[1][w]==barco3[1][r]) {
								place(barco3);
							}else {
								bucle=false;
							}
							
						}
							
					}
				
				}
			}while(bucle==true);
			System.out.println("                                            .\r\n"
					+ "                           .                 |\r\n"
					+ "                           +                 |\r\n"
					+ "                  .        |                *+W+-*\r\n"
					+ "     .           +y        +W+              . H                 .\r\n"
					+ "  .  +y            |I.   y  |               ! H= .           .  ^\r\n"
					+ "  !   \\     .     |H '. /   |  ___.        .! H  !   +--.--y !  V\r\n"
					+ "  !    \\     \\  +=|H|=='.=+ | |====\\   _  '_H_H__H_. H_/=  J !  !\r\n"
					+ ". !     \\'    VVV_HHH_/__'._H |  E  \\_|=|_|========|_|==|____H. ! _______.\r\n"
					+ "I-H_I=I=HH_==_|I_IIIII_I_I_=HH|======.I-I-I-=======-I=I=I=I_=H|=H'===I=I/\r\n"
					+ "\\                                                                      ,\r\n"
					+ " |                                                                    /\r\n"
					+ " .___________________________________________________________________'");
			System.out.println("Bienvenido, esta jugando a Battleship2.0\nNormas:\n");
			System.out.println("1.-A la hora de disparar primero introduces las coordenadas en el eje x.\n2.-Las coordendas van del 0 al 9 no te debes pasar de estos valores.");
			System.out.println("3.-No se te restará el disparo cuando repitas las coordenadas.\n4.-Ganas cuando destruyas todos los barcos.\n5.-Hay 3 barcos, 2 de 3 celdas y 1 de 4 celdas.");
			System.out.println("5.-Tienes 15 disparos.\n6.-Cualquier problema o fallo encontrado en el juego debe ponerse en contacto con el servicio tecnico.\n");
			
			//Llamada al metodo para imprimir el mapa.
			show(board);
			
			//Llamada al metodo para disparar con el bucle que son los disparos.
			for(int i=1;i<=30;i++) {
				i=shoot(i);
			}
			
		}
		
		//metodo comprueba si cada disparo ha dado a un barco
		public static int check(int x,int y, int matriz[][],int b) {
		
			for(int j=0;j<matriz[0].length;j++) {
				if(matriz[0][j]==y && matriz[1][j]==x && b!=0) {//se comprueba si has dado al barco y se le resta 1 de vida y se pone una t en el mapa.
					b--;
					System.out.print("\nBARCO TOCADO");
					board[y][x]='T';
					
					if(b==0) {//si la vida es 0 esta hundido y las t se cambian por h
						System.out.println(" Y HUNDIDO");
						for(int i=0;i<matriz[1].length;i++) {
							board[matriz[0][i]][matriz[1][i]]='H';
						}
						nB--;
						System.out.println("Te quedan "+nB+" barcos por destruir");
					}
					
				}
				
			}
			
			return b;
		}
		
		//metodo disparar y este te pide las coordenadas a las que disparar.
		public static int shoot(int i) {
			
			Scanner input=new Scanner(System.in);
			int x,y;
			
			System.out.print("Introduce las coordenadas a las que quieras disparar.\n\nCoordenada x:");
			x=input.nextInt();
			System.out.print("Coordenada y:");
			y=input.nextInt();
				
			if(x>=0 && x<=9 && y>=0 && y<=9) {//comprobacion de que las coordenadas estan dentro del tablero

				if(board[y][x]=='*') {//si no has dado al barco habra un * en el mapa asi que se cambiara por una a.
					b1=check(x,y,barco1,b1);//chekeo de si has dado al barco.
					b2=check(x,y,barco2,b2);
					b3=check(x,y,barco3,b3);
					if(board[y][x]=='*') {
						board[y][x]='A';
						System.out.println("\n--AGUA--");
					}
				}else{//si las coordenadas se repiten se restara 1 al contador para que no cuente el disparo.
					System.out.println("\nYa disparaste a estas coordenadas");
					i--;
				}
				
				//comprobacion de que si ha terminado el juego sea por todos los barcos destruidos o te hayas que quedado sin disparos 
				if(b1==0 && b2==0 && b3==0) {
					System.out.println("--ENHORABUENA HAS GANADO CRACK--");
					i=16;
				}else if(i==30) {//imprimir la posicion de los barcos cuando te quedas sin disparos
					System.out.println("\nTe has quedado sin disparos el juego a terminado\n");
					fillin(board);
					showShips(barco1);
					showShips(barco2);
					showShips(barco3);
					System.out.println("Los barcos estaban en estas posiciones");
					
				}else if(i<30) {
					System.out.println("\nTe quedan "+(30-i)+" disparos ");
					
				}
				
				//mapa actualizado con los disparos
				show(board);
			}else {
				i--;
				System.out.println("!Has introducido mal las coordenadas!\nRECUERDA las coordenadas son del 0 al 9");
			}
			
			return i;
		}
		
		//metodo que coloca los barcos.
		public static void place(int matriz[][]) {
			
			int x,y,num,des;
			boolean bucle=true;
			
			do{
				//generar coordenadas 
				y=aleatorio(0,9);
				x=aleatorio(0,9);
				num=aleatorio(0,1);//elige si lo que varia es la x o la y.
				
				switch(num) {//con el switch decidimos si lo que va a variar la coordenada x e y
						
					case 0:
						des=aleatorio(0,1);
						
						if(des==0 && (y<=((board.length-1)-matriz[0].length))) {//si es 0 suma a la coordenada y si es 1 resta
							for(int j=0;j<matriz[0].length;j++) {
								matriz[0][j]=y;
								y+=1;
								matriz [1][j]=x;
							}
							bucle=false;
							
						}else if(des==1 && y>=(matriz[0].length-1)) {
							for(int j=0;j<matriz[0].length;j++) {
								matriz[0][j]=y;
								y-=1;
								matriz [1][j]=x;
							}
							bucle=false;
						}
						break;
						
					case 1:
						des=aleatorio(0,1);
						
						if(des==0 && (x<=((board.length-1)-matriz[1].length))) {//si es 0 suma a la coordenada x si es 1 resta
							for(int j=0;j<matriz[1].length;j++) {
								matriz[1][j]=x;
								x+=1;
								matriz[0][j]=y;
							}
							bucle=false;
							
						}else if(des==1 && x>=(matriz[1].length-1)) {
							for(int j=0;j<matriz[1].length;j++) {
								matriz[1][j]=x;
								x-=1;
								matriz[0][j]=y;
							}
							bucle=false;
						}
						break;
				}	
			}while(bucle==true);
		}
		//metodo para imprimir la matriz
			public static void show(char[][] matriz) {
				System.out.print("  ");
				for(int a=0;a<10;a++) {
					System.out.print(" "+a+" ");
				}
				System.out.println("\n");
				for(int i=0;i<matriz.length;i++) {
					System.out.print(i+" ");
					for(int j=0;j<matriz.length;j++) {
						System.out.print(" "+matriz[i][j]+" ");
					}
				System.out.println("\n");
				}
			}
			
			//metodo aleatorio
			public static int aleatorio(int num1, int num2) {
				
				return (int)(Math.random()*(num2+1-num1))+num1;
			}
			
			//rellenar la matriz con *
			public static void fillin(char[][] matriz) {
				
				for(int i=0;i<matriz.length;i++) {
					Arrays.fill(matriz[i],'*');
				}
			}
			public static void showShips(int[][] matriz) {
				
				for(int i=0;i<matriz[1].length;i++) {
					board[matriz[0][i]][matriz[1][i]]='H';
				}
			}
}
