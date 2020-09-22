//	Desarrollar un sistema que permita el ingreso de totales recaudados de lunes a viernes, 
//	donde ademas se pueda modificar uno de los valores ingresados seleccionando el numero de dia.
//	Tambien se deberan poder listar los valores ingresados.(opcional ordenado de mayor a menor)
//	Todas las funciones se codificaran en un menu con valores enteros hasta que el usuario ingrese 
// cero para salir. (1. agregar  2. listar 3. modificar 4. salir)

package ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class Recaudacion {

	private static final int CANT_DIAS = 5;
	int opciones = 0;
	int recaudacion = 0;
	static boolean salir = false;
	static int dias[] = new int[5];

	public static void main(String[] args) throws IOException {
		darBienvenida("Bienvenida al sistema");
		desplegarMenu();

	}

	private static void darBienvenida(String mensajeBienvenida) {
		dibujarDivisor(mensajeBienvenida.length(), "=");
		System.out.println(mensajeBienvenida.toUpperCase());
		dibujarDivisor(mensajeBienvenida.length(), "=");
		System.out.println();
	}

	private static void dibujarDivisor(int longitud, String simbolo) {
		for (int i = 0; i < longitud; i++) {
			System.out.print(simbolo);
		}
		System.out.println();

	}

	private static void desplegarMenu() throws IOException {
		do {
			System.out.println("");
			System.out.println("    OPCIONES    ");
			System.out.println("----------------");
			System.out.println("(1) Agregar");
			System.out.println("(2) Listar");
			System.out.println("(3) Modificar");
			System.out.println("(0) Salir");
			System.out.print("Elija una opción del 1 al 3 (0 para salir): ");
			Scanner sc = new Scanner(System.in);
			int seleccion = sc.nextInt();

			switch (seleccion) {
			case 1:
				agregarRecaudaciones();
				break;
			case 2:
				listarRecaudacion();
				break;

			case 3:
				modificarDatosIngresados();
				break;

			case 4:
				salir();
				break;
			}

		} while (salir = true);

	}

	private static void listarRecaudacion() throws IOException {
		for (int i = 0; i < CANT_DIAS; i++) {
			System.out.println("El día " + (i + 1) + " tuvo una ganancia de $" + dias[i]);
		}

		System.out.print("¿Desea ver la recaudación ordenda de mayor a menor? (S/N): ");
		Scanner sc = new Scanner(System.in);
		String verLista = sc.nextLine();
		if (verLista.equalsIgnoreCase("s")) {
			for (int j = 0; j < dias.length - 2; j++) {
				int posMenor = j;
				for (int k = j + 1; k < dias.length - 1; k++) {
					if (dias[j] < dias[posMenor]) {
						posMenor = j;

					}

					sc.close();

				}

				int aux = dias[posMenor];
				dias[j] = dias[posMenor];
				dias[posMenor] = aux;

			}

			System.out.println("La lista ordenada es: ");
			for (int j = CANT_DIAS - 1; j < 0; j++) {
				System.out.println("" + dias[j]);

			}

		} else {
			System.out.println("Ok, volverá al Menú principal");
		}

		volver();

	}

	private static boolean salir() {
		return true;

	}

	private static void modificarDatosIngresados() {
		System.out.print("Ingrese el día a modificar: Lun: 1; Mar: 2, Miér: 3; Jues: 4, Vier: 5: ");
		Scanner sc = new Scanner(System.in);
		int dia = sc.nextInt();
		System.out.println("El día " + dia + " tuvo una recaudación de $" + dias[dia - 1]);
		System.out.print("¿Está seguro que desea modificar el monto? (S/N) ");
		String quieroModificar = sc.next();
		if (quieroModificar.equalsIgnoreCase("s")) {
			System.out.println("Ingrese el nuevo monto: ");
			int monto = sc.nextInt();
			dias[dia - 1] = monto;
			System.out.println("Ahora el día " + dia + " tiene cargada la recaudación de $" + monto);
		} else {
			System.out.println("Ok, de acuerdo!");
		}
		volver();

	}

	private static void agregarRecaudaciones() throws IOException {
		System.out.print("Ingrese el día: Lun: 1; Mar: 2, Miér: 3; Jues: 4, Vier: 5 (0 terminar): ");
		Scanner sc = new Scanner(System.in);
		int dia = sc.nextInt();
		while (dia != 0 && dia < 6) {
			System.out.println("Ingrese el monto del día " + dia);
			int monto = sc.nextInt();
			dias[dia - 1] = monto;
			System.out.print("Ingrese el día: Lun: 1; Mar: 2, Miér: 3; Jues: 4, Vier: 5 (0 terminar): ");
			dia = sc.nextInt();

		}
		volver();

	}

	private static void volver() {
		esperarTecla();
		borrarPantalla();

	}

	private static void borrarPantalla() {
		try {
			System.out.print("\033[H\033[2J");
		} catch (final Exception e) {

		}
	}

	private static void esperarTecla() {
		Scanner esperarTecla = new Scanner(System.in);
		System.out.print("Presiona la tecla Enter para continuar");
		esperarTecla.nextLine();

	}

}
