package models;

public class Motocicleta extends Vehiculo{

	private String MarcaEscape;
	
	public Motocicleta(String color, String matricula, String marca,
			String modelo, double velocidadMax,
			int telefono, String MarcaEscape){
		super(color, matricula, marca, modelo, velocidadMax, telefono);
		this.MarcaEscape = MarcaEscape;
	}
	
	public void CambiarEscape(String nuevo){
		MarcaEscape =  nuevo;
	}

	public String getMarcaEscape() {
		return MarcaEscape;
	}

}
