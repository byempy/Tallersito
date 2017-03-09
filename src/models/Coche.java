package models;

public class Coche extends Vehiculo{
	
	private boolean EstadoVentanillas;
	
	public Coche(String color, String matricula, String marca,
			String modelo, double velocidadMax,
			int telefono){
		super(color, matricula, marca, modelo, velocidadMax, telefono);
		SubirVentanillas();
	}
	public void SubirVentanillas(){
		EstadoVentanillas = true;
		System.out.println("Las ventanillas estan subidas");
	}
	
	public void BajarVentanillas(){
		EstadoVentanillas = false;
		System.out.println("Las ventanillas estan cerradas");
	}

	public boolean isEstadoVentanillas() {
		return EstadoVentanillas;
	}
}
