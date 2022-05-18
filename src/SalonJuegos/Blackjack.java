package SalonJuegos;

import java.util.Scanner;

public class Blackjack {
	public static void main() {
		Scanner entrada = new Scanner(System.in);
		int cartaJugador=  0;
		int cartaJugador2= 0;
		int totalJ=0;
		int totalBanca=0;
		int cartaBanca1=0;
		int cartaBanca=0;
		int as=0;
		boolean victoria=false;
		boolean blackjackJ=false;
		boolean blackjackB=false;
		String seguir1="";
		String continuar = "Si";
		cartaBanca1 =   (int) (Math.random() * 13) + 1;
		cartaBanca =  (int) (Math.random() * 13) + 1;
		
		
		System.out.println( "La banca saca un " +cartaBanca1);
		cartaJugador = (int) (Math.random() * 13) + 1;
		cartaJugador2= (int) (Math.random() * 13) + 1;
		
		
		
		if ((cartaJugador >=10 && cartaJugador <14 )|( cartaJugador2 >=10 && cartaJugador2 <14 )) {
			if (cartaJugador ==1 | cartaJugador2 ==1) {
				totalJ=21;
				System.out.println("Sacas un " + cartaJugador + " y un " + cartaJugador2);
				System.out.println("BlackJack");
				blackjackJ=true;
				}
		}if (cartaJugador >=11 && cartaJugador <=13 && blackjackJ==false) {
			cartaJugador=10; }
		if (cartaJugador2 >=11 && cartaJugador2 <=13 && blackjackJ==false) {
			cartaJugador2=10;}
		if (blackjackJ==false) {
			
			System.out.println("Sacas un " + cartaJugador + " y un " + cartaJugador2);
			if (cartaJugador==1) {
			System.out.println("Tu primera carta es un As, quieres que tenga valor 1 o 11");
			as=entrada.nextInt();
			if (as==11) {
				cartaJugador=11;}
			}
			if (cartaJugador2==1) {
				System.out.println("Tu segunda carta es un As, quieres que tenga valor 1 o 11");
				as=entrada.nextInt();
				if (as==11) {
					cartaJugador2=11;}
				}
			totalJ += cartaJugador;
			totalJ+= cartaJugador2;
			}
		System.out.println("Quieres seguir? Si/No");
		
		seguir1 = entrada.next();
		
		while (seguir1.equalsIgnoreCase(continuar) && totalJ<21) {
			cartaJugador = (int) (Math.random() * 10) + 1;
			if (cartaJugador==1) {
				System.out.println("Has sacado un As, quieres que tenga valor 1 o 11");
				as=entrada.nextInt();
				if (as==11) {
					cartaJugador=11;}
				}
			totalJ += cartaJugador;
			System.out.println("Sacas un " +cartaJugador + ". Llevas " + totalJ);
			if (totalJ<=21) {
				System.out.println("¿Quieres otra carta? Si/No");
				seguir1 = entrada.next();
			}
		}
		
		if (totalJ>21) {
			System.out.println("Sacas un " + cartaJugador);
			System.out.println("Te has pasado de 21, has perdido");
			
		}else {
			
			if (cartaBanca >=10 && cartaBanca <14 | cartaBanca1 >=10 && cartaBanca1 <14 ) {
				if (cartaBanca ==1 | cartaBanca1 ==1) {
					totalBanca=21;
					System.out.println(cartaBanca1);
					System.out.println("BlackJack de la banca");
					blackjackB=true;
				}
				}
			if (cartaBanca >=11 && cartaBanca <=13 && blackjackB==false) {
					cartaBanca=10; }
			if (cartaBanca1 >=11 && cartaBanca1 <=13 && blackjackB==false) {
					cartaBanca1=10;}
			if(blackjackB==false) {
				totalBanca += cartaBanca1;
				if (cartaBanca==1 && totalBanca + cartaBanca+10 > totalJ && totalBanca + cartaBanca+10 <=21) {
					cartaBanca=10;
				}
				totalBanca+= cartaBanca;
				if (cartaBanca1==1 && totalBanca +10 > totalJ && totalBanca + 10 <=21) {
					totalBanca+=10;
				}
				System.out.println("La banca saca un " + cartaBanca + ".Lleva " + totalBanca);
			if ( totalBanca<=15) {
				do {
					cartaBanca =  (int) (Math.random() * 10) + 1;
					totalBanca += cartaBanca;
						if(cartaBanca==1 && totalBanca+10>totalJ && totalBanca+10<=21) {
							totalBanca +=10;
						}
			
			System.out.println("La banca saca un " + cartaBanca + ".Lleva " + totalBanca);
			
			if(totalBanca>21) {
				System.out.println("La banca se ha pasado");
				System.out.println("Has ganado");
				victoria=true;
				break;
			}
		
			if (totalBanca>=16) {
				break;
			}
		
		
		}while (totalBanca<21);
				}
		
		}
			if (victoria==false) {
		if (totalJ>totalBanca | totalBanca>21) {
			System.out.println("Tu total es " + totalJ);
			System.out.println("El total de la banca es " + totalBanca);
			System.out.println("Has ganado");
	
		}else if (totalBanca==totalJ) {
			System.out.println("Tu total es " + totalJ);
			System.out.println("El total de la banca es " + totalBanca);
			System.out.println("Empate");
		}else if (totalJ<totalBanca) {
			System.out.println("Tu total es " + totalJ);
			System.out.println("El total de la banca es " + totalBanca);
			System.out.println("Has Perdido");
}
		
	}
			}	
			
		}
	}