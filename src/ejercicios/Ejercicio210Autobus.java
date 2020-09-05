package ejercicios;

import java.util.Scanner;

public class Ejercicio210Autobus {

	private static final int MINIMO_PERSONAS = 20;
	private static final float COSTO_A = 2;
	private static final float COSTO_B = 2.5f;
	private static final float COSTO_C = 3;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int personas = sc.nextInt();

		System.out.println("Ingreso: " + personas);

		int km = sc.nextInt();
		System.out.println("Ingrese kilometros: " + km);

		String tipo = sc.next();
		System.out.println("Ingrese tipo de autobus (A, B, C");

		int totalPersonas = MINIMO_PERSONAS;
		if (personas > MINIMO_PERSONAS) {
			totalPersonas = personas;
		}

		int costoTotal = totalPersonas * km;

		float totalGrupal = 0;

		switch (tipo.toUpperCase()) {
		case "A":
			totalGrupal = costoTotal * COSTO_A;
			break;

		case "B":
			totalGrupal = costoTotal * COSTO_B;
			break;

		case "C":
			totalGrupal = costoTotal * COSTO_C;
			break;

		}
		System.out.println("El total grupal es: " + totalGrupal);

		sc.close();
	}

}
