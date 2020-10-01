package ejercicios;

import java.util.Scanner;

public class TaTeTi {

	static Scanner ingreso = new Scanner(System.in);

	public static void main(String[] args) {

		darBienvenida("JUGUEMOS AL TA-TE-TI");
		jugar();
		seguirjugando();
		darDespedida("¡TE ESPERAMOS PRONTO!");

	}

	private static void darDespedida(String mensajeDespedida) {
		dibujarDivisor(mensajeDespedida.length(), "*");
		System.out.println(mensajeDespedida.toUpperCase());
		dibujarDivisor(mensajeDespedida.length(), "*");
		System.out.println();
	}

	private static void seguirjugando() {
		System.out.println("¿Seguimos jugando? S/N");
		String eleccion = ingreso.next();
		while (eleccion.equalsIgnoreCase("s")) {
			jugar();
			System.out.println("¿Seguimos jugando? S/N");
			eleccion = ingreso.next();

		}

	}

	private static void darBienvenida(String mensajeBienvenida) {
		dibujarDivisor(mensajeBienvenida.length(), "*");
		System.out.println(mensajeBienvenida.toUpperCase());
		dibujarDivisor(mensajeBienvenida.length(), "*");
		System.out.println();
	}


	private static void dibujarDivisor(int longitud, String simbolo) {
		for (int i = 0; i < longitud; i++) {
			System.out.print(simbolo);
		}
		System.out.println();

	}

	private static void jugar() {

		char jugador1 = 'X';
		char jugador2 = 'O';
		char vacio = '-';

		boolean turno = true;
		char tablero[][] = new char[3][3];
		completarTablero(tablero, vacio);
		int fila, columna;
		boolean posValida, correcto;

		while (!finJuego(tablero, vacio)) {

			do {

				mostrarTurno(turno);
				mostrarTablero(tablero);

				correcto = false;
				fila = pedirIngresar("Ingrese la fila: ");
				columna = pedirIngresar("Ingrese la columna: ");
				posValida = validarCasillero(tablero, fila, columna);

				if (posValida) {

					if (!casilleroOcupado(tablero, fila, columna, vacio)) {
						correcto = true;

					} else {
						System.out.println("Casillero ya jugado");
					}
				} else {
					System.out.println("La posición no es válida");
				}

			} while (!correcto);

			if (turno) {
				ponerJugada(tablero, fila, columna, jugador1);

			} else {
				ponerJugada(tablero, fila, columna, jugador2);
			}

			turno = !turno;

		}

		mostrarTablero(tablero);
		mostrarGanador(tablero, jugador1, jugador2, vacio);
	}

	private static void mostrarGanador(char[][] matriz, char jugador1, char jugador2, char sinDef) {
		char simbolo = coincideLinea(matriz, sinDef);
		if (simbolo != sinDef) {
			if (simbolo == jugador1) {
				System.out.println("GANÓ EL JUGADOR UNO!");

			} else {
				System.out.println("GANÓ EL JUGADOR DOS!");

			}
			return;

		}

		simbolo = coincideColumna(matriz, sinDef);
		if (simbolo != sinDef) {
			if (simbolo == jugador1) {
				System.out.println("GANÓ EL JUGADOR UNO!");

			} else {
				System.out.println("GANÓ EL JUGADOR DOS!");

			}
			return;

		}

		simbolo = coincideDiagonal(matriz, sinDef);
		if (simbolo != sinDef) {
			if (simbolo == jugador1) {
				System.out.println("GANÓ EL JUGADOR UNO!");

			} else {
				System.out.println("GANÓ EL JUGADOR DOS!");
			}

			return;
		}

		System.out.println("Empataron! :-|");

	}

	private static void ponerJugada(char[][] matriz, int fila, int columna, char simbolo) {
		matriz[fila][columna] = simbolo;
	}

	private static boolean casilleroOcupado(char[][] matriz, int fila, int columna, char ocupado) {
		if (matriz[fila][columna] != ocupado) {
			return true;
		}

		return false;

	}

	private static boolean validarCasillero(char[][] tablero, int fila, int columna) {
		if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length) {
			return true;
		}
		return false;
	}

	private static int pedirIngresar(String mensaje) {
		System.out.println(mensaje);
		int numero = ingreso.nextInt();

		return numero;

	}

	private static void mostrarTurno(boolean turno) {
		if (turno) {
			System.out.println("Le toca al jugador 1");

		} else {
			System.out.println("Le toca al jugador 2");

		}

	}

	private static void mostrarTablero(char[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + "  ");

			}
			System.out.println("");

		}

	}

	private static boolean tableroCompleto(char[][] matriz, char simboloDef) {
		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == simboloDef) {
					return false;

				}

			}
		}

		return true;

	}

	private static boolean finJuego(char[][] matriz, char simboloDef) {
		if (tableroCompleto(matriz, simboloDef) || coincideLinea(matriz, simboloDef) != simboloDef
				|| coincideColumna(matriz, simboloDef) != simboloDef
				|| coincideDiagonal(matriz, simboloDef) != simboloDef) {

			return true;

		}
		return false;

	}

	private static char coincideLinea(char[][] matriz, char simboloDef) {
		char simbolo;
		boolean coincidencia;

		for (int i = 0; i < matriz.length; i++) {
			coincidencia = true;
			simbolo = matriz[i][0];

			if (simbolo != simboloDef) {
				for (int j = 0; j < matriz.length; j++) {
					if (simbolo != matriz[i][j]) {
						coincidencia = false;

					}

				}

				if (coincidencia) {
					return simbolo;
				}
			}
		}

		return simboloDef;

	}

	private static char coincideColumna(char[][] matriz, char simboloDef) {
		char simbolo;
		boolean coincidencia;

		for (int j = 0; j < matriz.length; j++) {
			coincidencia = true;
			simbolo = matriz[0][j];
			if (simbolo != simboloDef) {
				for (int i = 0; i < matriz.length; i++) {
					if (simbolo != matriz[i][j]) {
						coincidencia = false;

					}

				}

				if (coincidencia) {
					return simbolo;
				}
			}
		}
		return simboloDef;

	}

	private static char coincideDiagonal(char[][] matriz, char simboloDef) {
		char simbolo;
		boolean coincidencia = true;

		// Diagonal principal
		simbolo = matriz[0][0];
		if (simbolo != simboloDef) {
			for (int i = 0; i < matriz.length; i++) {
				if (simbolo != matriz[i][i]) {
					coincidencia = false;

				}

			}

			if (coincidencia) {
				return simbolo;

			}

		}

		// Diagonal inversa
		simbolo = matriz[0][2];
		if (simbolo != simboloDef) {
			for (int i = 1, j = 1; i < matriz.length; i++, j--) {
				if (simbolo != matriz[i][j]) {
					coincidencia = false;

				}
			}
			if (coincidencia) {
				return simbolo;

			}
		}

		return simboloDef;

	}

	private static void completarTablero(char[][] matriz, char simbolo) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = simbolo;

			}
		}

	}

}

