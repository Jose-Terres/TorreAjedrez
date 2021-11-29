package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	// Atributos de la clase Main

	// La torre que usaremos
	private static Torre torre;
	// La variable que controla el fin del programa
	private static boolean fin = false;
	
// sting
	public static void main(String[] args) {

		do {
			// Mostramos el menu de eleccion
			mostrarMenu();
			// creamos y asignamos la variable para la opcion a elegir
			int opcion = elegirOpcion();
			// encerramos el codigo en un try-catch ya que ahora si pueden saltar
			// excepciones
			try {
				// ejecutamos la opcion
				ejecutarOpcion(opcion);
			} catch (Exception e) {
				// con e.getMessage mostramos el error de la excepcion
				System.out.println(e.getMessage());
			}
			System.out.println("\n");
		} while (!fin);

		System.out.println("¡ADIOS!");
	}
// creamos el metodo mostrar Torre
	private static void mostrarTorre() {
		System.out.println(torre);
	}
	// creamos el metodo mostrar Menu
	private static void mostrarMenu() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("============================================================");
		System.out.println("1 - CREAR TORRE POR DEFECTO");
		System.out.println("2 - CREAR TORRE CON COLOR");
		System.out.println("3 - CREAR TORRE CON COLOR Y COLUMNA");
		System.out.println("4 - MOVER TORRE");
		System.out.println("5 - ENROQUE CORTO");
		System.out.println("6 - ENROQUE LARGO");
		System.out.println("7 - SALIR");
		System.out.println("============================================================");
	}

	// creamos el metodoElegir opcion
	private static int elegirOpcion() {
		int opcion = 0;
		do {
			System.out.print("\nINTRODUZCA LA OPCIÓN: ");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 7);
		System.out.println();

		return opcion;
	}
	// creamos el metodo ElegirColor
	private static Color elegirColor() {
		int opcion = 0;

		do {
			System.out.print("ELIJA EL COLOR (1 - BLANCO | 2 - NEGRO): ");
			opcion = Entrada.entero();
		} while (opcion != 1 && opcion != 2);
		System.out.println();

		if (opcion == 1) {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}
	}
// creamos elegirColumnaInicial
	private static char elegirColumnaInicial() {
		char columna;

		do {
			System.out.print("ELIJA COLUMNA ('A' o 'H'): ");
			columna = Entrada.caracter();
		} while (columna != 'a' && columna != 'A' && columna != 'h' && columna != 'H');
		System.out.println();

		return Character.toLowerCase(columna);
	}
	
	// creamos mostrarMenuDirecciones
	private static void mostrarMenuDirecciones() {
		System.out.println("DIRECCIONES");
		System.out.println("=============");
		System.out.println("1 - ARRIBA");
		System.out.println("2 - ABAJO");
		System.out.println("3 - IZQUIERDA");
		System.out.println("4 - DERECHA");
		System.out.println("=============");
		System.out.println();
	}
	// creamos elegirDireccion
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int opcion = 0;
		mostrarMenuDirecciones();

		do {
			System.out.print("INTRODUZCA DIRECCION (1-4): ");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 4);
		System.out.println();

		switch (opcion) {
		case 1:
			direccion = Direccion.ARRIBA;
			break;
		case 2:
			direccion = Direccion.ABAJO;
			break;
		case 3:
			direccion = Direccion.IZQUIERDA;
			break;
		case 4:
			direccion = Direccion.DERECHA;
			break;
		}

		return direccion;
	}

	// creamos crearTorreDefecto
	private static void crearTorreDefecto() {
		torre = new Torre();
	}

	// creamos crearTorreColor
	private static void crearTorreColor() {
		Color color = elegirColor();
		torre = new Torre(color);
	}

	
	// creamos crearTorreColor
	private static void crearTorreColorColumna() {
		Color color = elegirColor();
		char columna = elegirColumnaInicial();
		torre = new Torre(color, columna);
	}
	// mover void
	private static void mover() throws OperationNotSupportedException {
		Direccion direccion;
		int pasos;

		if (torre == null) {
			System.out.println("ERROR: NO HA CREADO LA TORRE");
		}

		do {
			System.out.print("NUMERO DE PASOS: ");
			pasos = Entrada.entero();
		} while (pasos < 1);
		System.out.println();

		direccion = elegirDireccion();
		torre.mover(direccion, pasos);

	}

	// mover ejecutarOpcion
	private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
		switch (opcion) {
		case 1:
			crearTorreDefecto();
			mostrarTorre();
			break;
		case 2:
			crearTorreColor();
			mostrarTorre();
			break;
		case 3:
			crearTorreColorColumna();
			mostrarTorre();
			break;
		case 4:
			mover();
			mostrarTorre();
			break;
		case 5:
			torre.enrocar(Direccion.ENROQUE_CORTO);
			mostrarTorre();
			break;
		case 6:
			torre.enrocar(Direccion.ENROQUE_LARGO);
			mostrarTorre();
			break;
		case 7:
			fin = true;
			break;
		}
	}
}
