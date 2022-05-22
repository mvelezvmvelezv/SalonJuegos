package SalonJuegos;

import java.util.Scanner;

public class MainSalonJuegos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		
		while(continuar) {
			System.out.println("Bienvenido al salon de juegos");
			System.out.println("-------------------------------");
			System.out.println("¿A que desea jugar?" + "\n" +
								"1.- Hundir la Flota" + "\n" +
								"2.- Blackjack" + "\n" + 
								"3.- Ruleta Rusa" + "\n" + 
								"4.- Salir");
			int elec = sc.nextInt();
			
			switch(elec) {
			
			case 1:
				carga();
				//Metodo Hundir la Flota
				break;
			case 2:
				carga();
				Blackjack.main();
				break;
			case 3:
				carga();
				RuletaRusa.Ruleta();
				break;
			case 4: 
				System.out.println("¡Adios!");
				continuar = false;
				break;
			default:
				System.out.println("Seleccion incorrecta");
			}
		}
	}
	
	public static void carga() {
		String cargando = "Cargando juego";
		for(int i = 0; i < 13; i++) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException ex) {
				System.out.println("Error: Proceso interrumpido");
			}
			//Saltos de linea para limpiar consola y que quede la animación de cargando bien
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); 
			System.out.println(cargando);
			cargando += ".";
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); 
		
	}

}
