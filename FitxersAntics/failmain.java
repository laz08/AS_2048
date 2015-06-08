package DomainLayer;
import DomainLayer.*;


import java.util.Scanner;

public class failmain {

	static Scanner arg = new Scanner(System.in);
	static private Partida p;
	private static String username = "";
	private static int idPartida = 0;

	public static void main(String[] args) {
		int cas = 0;
		boolean sortir = false;
		escriuMenuPrincipal();

		while (!sortir && arg.hasNext()){
			cas = lecturaTeclat();
			
			switch(cas){
			case 1: casCanviaNomJugador(); break;
			case 2: casConsultaUsername(); break;
			case 3: casCreaPartida(); break;
			case 4: casConsultaPartidaActual(); break;
			case 5: casFerMoviment(); break;
			
			case 0: sortir = true; break;
			default:
				System.out.println("El numero ha d'estar entre 0 i 5.");
				break;
			}

			if (cas != 0) escriuMenuPrincipal();
		}
	}

	private static void escriuMenuPrincipal(){
		System.out.print("\n");
		System.out.println("----------JOC 2048----------");
		System.out.println("1.- Escollir username");
		System.out.println("2.- Consulta username");
		System.out.println("3.- Crear partida");
		System.out.println("4.- Consulta taulell partida");
		System.out.println("5.- Fer moviment");
		System.out.println("0.- Sortir");
		System.out.println("----------------------------");
		System.out.print(">> ");
	}

	private static int lecturaTeclat(){
		int menu = 0;
		try {
			menu = arg.nextInt();
		} catch (Exception e){
			System.out.println("S'esperava la introducció d'un número.");
			System.out.print(">> ");
			arg.next();
		}
		return menu;
	}
	
	// ### --- CASOS D'ÚS --- ###
	
	private static void casCanviaNomJugador(){
		username = arg.next();
	}
	private static void casConsultaUsername(){
		if(!username.equals(""))
			System.out.println(username);
		else
			System.out.println("Primer has d'escollir un nom de jugador.");
	}
	private static void casCreaPartida(){
		p = new Partida(idPartida++, username);
	}
	private static void casConsultaPartidaActual(){
		if(!(p == null)){
			for (int i = 1; i <= 16; ++i){
				System.out.print(p.consultaPuntuacioCasella(i-1));
				if(i%4 == 0){
					System.out.print("\n");
				}else{
					System.out.print(" ");
				}
			}
		}
		else{
			System.out.println("Primer has de crear una partida.");
		}
	}
	
	private static void casFerMoviment(){
		System.out.println("Amunt, Avall, Esquerra o Dreta?");
		String mov = arg.next();
		if(!(mov.equals("Amunt") || mov.equals("Avall") || mov.equals("Esquerra") || mov.equals("Dreta"))){
			System.out.println("Els moviments possibles són Amunt, Avall, Esquerra o Dreta.");
		}
		else{
			p.ferMoviment(mov);
		}
	}
	
	
	

}
