package test;

import models.*;
import java.util.*;

public class prueba_taller {

	public static Taller taller = new Taller("Centro Auto");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int respuesta = 0;
		String aux = "";
		boolean error = true;

		do {
			System.out.println("1-Añadir coche");
			System.out.println("2-Añadir motocicleta");
			System.out.println("3-Arreglar vehiculo");
			System.out.println("4-Recoger vehiculo");
			System.out.println("5-Listar vehiculos");
			System.out.println("6-Listar motocicletas");
			System.out.println("7-Salir");

			do {
				System.out.print("Elige lo que quieres hacer: ");
				aux = sc.next();

				error = true;
				if (numValidado(aux, 1)) {
					respuesta = Integer.parseInt(aux);
					if (respuesta >= 1 && respuesta <= 7) {
						error = false;
					} else {
						System.out
								.println("ERROR: La respuesta introducida no es una opción válida");
					}
				} else {
					System.out
							.println("ERROR: La respuesta no es un número entero");
				}
			} while (error);

			switch (respuesta) {
			case 1:
				AnadirVehiculo(true);
				break;
			case 2:
				AnadirVehiculo(false);
				break;
			case 3:
				System.out
						.println("Introduce la matricula del vehiculo averiado: ");
				aux = sc.next();
				ArreglarVehiculo(aux);
				break;
			case 4:
				System.out
						.println("Introduce la matricula del vehiculo a recoger: ");
				aux = sc.next();
				taller.ClienteRecogeVehiculoReparado(aux);
				break;
			case 5:
				System.out.println("------------Vehiculos averiados: ");
				taller.ListarVehiculosAveriados();
				System.out.println("------------Vehiculos reparados: ");
				taller.ListarVehiculosReparados();
				break;
			case 6:
				System.out.println("------------Motocicletas averiadas: ");
				taller.ListarMotocicletasAveriadas();
				System.out.println("------------Motocicletas reparadas: ");
				taller.ListarMotocicletasReparadas();
				break;
			case 7:
				System.out.println("Adios! :)");
				break;
			}
		} while (respuesta != 7);
	}

	public static void AnadirVehiculo(boolean tipo) {
		Scanner sc = new Scanner(System.in);
		Vehiculo vh = null;
		String color, matricula, marca, modelo, escape, aux;
		int telefono = 0;
		double velocidad = 0;

		System.out.println("Introduce los datos del vehiculo: ");

		System.out.print("Matricula: ");
		matricula = sc.next();
		System.out.print("Marca: ");
		marca = sc.next();
		System.out.print("Modelo: ");
		modelo = sc.next();
		System.out.print("Color: ");
		color = sc.next();
		System.out.print("Escape: ");
		escape = sc.next();
		do {
			System.out.print("Velocidad máxima: ");
			aux = sc.next();

			if (numValidado(aux, 2)) {
				velocidad = Double.parseDouble(aux);
			} else {
				System.out
						.println("ERROR: no has introducido un número entero.");
			}
		} while (!numValidado(aux, 2));

		do {
			System.out.print("Número telf: ");
			aux = sc.next();
			if (numValidado(aux, 1)) {
				telefono = Integer.parseInt(aux);
			} else {
				System.out
						.println("ERROR: no has introducido un número entero.");
			}
		} while (!numValidado(aux, 1));

		if (tipo) {
			vh = new Coche(color, matricula, marca, modelo, velocidad, telefono);
		} else {
			vh = new Motocicleta(color, matricula, marca, modelo, velocidad,
					telefono, escape);
		}

		taller.AniadirVehiculoAveriado(vh);

	}

	public static void ArreglarVehiculo(String matricula) {
		if (taller.ObteneVehiculoAveriado(matricula) != null) {
			taller.ArreglarVehiculo(taller.ObteneVehiculoAveriado(matricula));
		} else {
			System.out
					.println("ERROR: no se encontro el coche con esa matricula por lo tanto no se arregló");
		}
	}

	public static boolean numValidado(String respuesta, int num) {
		boolean error = true;

		try {
			if (num == 1) {
				Integer.parseInt(respuesta);
			} else {
				Double.parseDouble(respuesta);
			}
		} catch (Exception e) {
			error = false;
		}

		return error;
	}

}
