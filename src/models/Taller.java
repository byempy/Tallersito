package models;

import java.util.*;

public class Taller {

	private String Nombre;
	private ArrayList<Vehiculo> ListaVehiculosAveriados;
	private ArrayList<Vehiculo> ListaVehiculosReparados;

	public Taller(String nombre) {
		super();
		Nombre = nombre;
		ListaVehiculosAveriados = new ArrayList<Vehiculo>();
		ListaVehiculosReparados = new ArrayList<Vehiculo>();
	}

	public void AniadirVehiculoAveriado(Vehiculo v) {
		if (ListaVehiculosAveriados.contains(v)) {
			System.out.println("ERROR: El vehiculo ya estaba añadido..");
		} else {
			ListaVehiculosAveriados.add(v);
			System.out.println("El vehículo se añadio con exito");
		}
	}

	public void ArreglarVehiculo(Vehiculo v) {
		if (ListaVehiculosAveriados.contains(v)) {
			ListaVehiculosReparados.add(v);
			ListaVehiculosAveriados.remove(v);
			System.out.println("El vehiculo con matricula " + v.getMatricula()
					+ " ha sido arreglado!");
		} else {
			System.out.println("ERROR: El vehiculo no esta en el taller..");
		}
	}

	public Vehiculo ObteneVehiculoAveriado(String matricula) {
		Vehiculo vh = null;

		for (int i = 0; i < ListaVehiculosAveriados.size(); i++) {
			if (matricula.equalsIgnoreCase(ListaVehiculosAveriados.get(i)
					.getMatricula())) {
				vh = ListaVehiculosAveriados.get(i);
				break;
			}
		}

		return vh;
	}

	public void ListarVehiculosAveriados() {
		if (!ListaVehiculosAveriados.isEmpty()) {
			for (int i = 0; i < ListaVehiculosAveriados.size(); i++) {
				System.out.println(ListaVehiculosAveriados.get(i));
				System.out.println();
			}
		} else {
			System.out.println("No hay vehiculos averiados");
		}
	}

	public void ListarVehiculosReparados() {
		if (!ListaVehiculosReparados.isEmpty()) {
			for (int i = 0; i < ListaVehiculosReparados.size(); i++) {
				System.out.println(ListaVehiculosReparados.get(i));
				System.out.println();
			}
		} else {
			System.out.println("No hay vehiculos reparados");
		}
	}

	public void ListarMotocicletasAveriadas() {

		boolean motitos = false;

		if (!ListaVehiculosAveriados.isEmpty()) {
			for (int i = 0; i < ListaVehiculosAveriados.size(); i++) {
				if (ListaVehiculosAveriados.get(i) instanceof Motocicleta) {
					System.out.println(ListaVehiculosAveriados.get(i));
					System.out.println();
					motitos = true;
				}
			}
			if (!motitos) {
				System.out.println("No hay motocicletas averiadas");
			}
		} else {
			System.out.println("No hay vehiculos averiados");
		}
	}

	public void ListarMotocicletasReparadas() {
		boolean motitos = false;

		if (!ListaVehiculosReparados.isEmpty()) {
			for (int i = 0; i < ListaVehiculosReparados.size(); i++) {
				if (ListaVehiculosReparados.get(i) instanceof Motocicleta) {
					System.out.println(ListaVehiculosReparados.get(i));
					System.out.println();
					motitos = true;
				}
			}
			if (!motitos) {
				System.out.println("No hay motocicletas averiadas");
			}
		} else {
			System.out.println("No hay vehiculos reparados");
		}
	}

	public void CambiarEscape(String nuevaMarca) {
		Scanner sc = new Scanner(System.in);
		String respuesta = "";
		ListarMotocicletasAveriadas();

		System.out.println("Indica la matricula de la moto a cambiar");

		respuesta = sc.next();

		for (int i = 0; i < ListaVehiculosReparados.size(); i++) {
			if (ListaVehiculosReparados.get(i) instanceof Motocicleta) {
				Motocicleta moto = (Motocicleta) ListaVehiculosReparados.get(i);
				if (moto.getMatricula() == respuesta) {
					moto.CambiarEscape(nuevaMarca);
				}
			}
		}
	}

	public void ClienteRecogeVehiculoReparado(String matricula) {
		boolean recogido = false;
		for (int i = 0; i < ListaVehiculosReparados.size() && !recogido; i++) {
			if (ListaVehiculosReparados.get(i).getMatricula()
					.equalsIgnoreCase(matricula)) {
				ListaVehiculosReparados.remove(ListaVehiculosReparados.get(i));
				recogido = true;
			}
		}

		if (recogido) {
			System.out.println("El vehiculo con matricula " + matricula
					+ " ha sido recogido!!");
		} else {
			System.out.println("ERROR El vehiculo con matricula " + matricula
					+ " no estaba en el taller o no estaba arreglado aún");
		}
	}
}
