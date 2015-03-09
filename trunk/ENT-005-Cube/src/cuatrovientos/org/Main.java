package cuatrovientos.org;

import java.util.Scanner;

/**
 * Cube Project
 * @author Toni
 *
 */
public class Main {

	private static java.util.Scanner reader;
	public static ClassPrison Cube;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		reader = new java.util.Scanner(System.in);
			
		System.out.println();
		System.out.println("CUBE PRISION");

		checkSize();
		
		Cube.showPrison();
		
		do{
			checkMovement();
		} while (!Cube.isDie() & !Cube.isEscape());
		
	}

	private static void checkSize() {
		
		int size;
		
		do{
			System.out.println();
			System.out.println("Introduce el tamaño de la prisión: ");
			
			reader = new Scanner(System.in);
			
			if (!reader.hasNextInt()) {
				System.out.println("(Debes introducir un numero)");
			}
	
		} while(!reader.hasNextInt());
		
		size = reader.nextInt();
		
		if (size < 4) {
			size = 4;
		}
		
		Cube = new ClassPrison(size);
	}
	
	private static void checkMovement() {
		
		String movement = "";
		
		do{
			System.out.println();
			System.out.println("Introduce un movimiento para escapar: ");
			System.out.println("<W-Arriba> <X-Abajo> <A-Izquierda> <D-Derecha> ");
			
			reader = new Scanner(System.in);
			movement = reader.next();
			
			if (!(movement.equals("W") || movement.equals("X") || movement.equals("A") || movement.equals("D"))) {
				System.out.println("(Debes introducir un movimiento válido)");
			}
	
		} while(!movement.equals("W") && !movement.equals("X") && !movement.equals("A") && !movement.equals("D"));
		
		Cube.movePlayer(movement);
	}
	
}
