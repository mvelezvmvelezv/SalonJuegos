package SalonJuegos;

public class RuletaRusa {

	public static void Ruleta() {
		
		String[] jugadores = {"Jugador1", "Jugador2", "Jugador3", "Jugador4", "Jugador5", "Tu"};
		
		int posicion = (int) (Math.random()*5);
		String temporal = "";
		
		boolean continuar = true;
		while(continuar) {
			if(posicion != 5) {
				temporal = jugadores[posicion];
				jugadores[posicion] = "tu";
				jugadores[5] = temporal;
				continuar = false;
			}else {
				posicion = (int) (Math.random()*5);
				continuar = true;
			}
		}
		
		String posiciones = "";
		for (int i = 0; i < jugadores.length; i++) {
			posiciones += jugadores[i] + " ";
		}
		
		System.out.println("Posición de los jugadores");
		System.out.println(posiciones);
		
		int bala = (int) (Math.random()*5);
		
		try {
			
			for (int i = 0; i < jugadores.length; i++) {
				System.out.println("-------------------------------");
				Thread.sleep(2000);
				if(!jugadores[i].equalsIgnoreCase("tu")) {
					System.out.println(jugadores[i] + " va a efectuar su disparo");
					Thread.sleep(2000);
					if(bala == i) {
						System.out.println(jugadores[i] + " ha muerto");
						break;
					}else {
						System.out.println(jugadores[i] + " ha sobrevivido");
					}
					
				}else{
					System.out.println("Vas a efectuar tu disparo");
					Thread.sleep(2000);
					if(bala == i) {
						System.out.println("Has muerto");
						break;
					}else {
						System.out.println("Has sobrevivido");
					}
				}
			}
			Thread.sleep(2500);
			System.out.println("-------------------------------");
			System.out.println("El juego ha terminado");
		}catch(InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
