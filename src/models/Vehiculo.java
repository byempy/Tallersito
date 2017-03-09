package models;

public abstract class Vehiculo implements Arrancable, Movible{
	private String color;
	private String matricula;
	private String marca;
	private String modelo;
	private double VelocidadMax;
	private double VelocidadAct;
	private int telefono;
	
	public Vehiculo(String color, String matricula, String marca,
			String modelo, double velocidadMax,
			int telefono) {
		super();
		this.color = color;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		VelocidadMax = velocidadMax;
		VelocidadAct = 0;
		this.telefono = telefono;
	}
	
	public String getColor() {
		return color;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public double getVelocidadMax() {
		return VelocidadMax;
	}
	public double getVelocidadAct() {
		return VelocidadAct;
	}
	public int getTelefono() {
		return telefono;
	}
	@Override
	public void Acelerar(double a) {
		// TODO Auto-generated method stub
		double aux = a + VelocidadAct;
		
		if(aux <= VelocidadMax){
			VelocidadAct += a;
		}else{
			System.out.println("Ya vas a fondo loco!, no doy para mas");
		}
	}
	@Override
	public void Frenar(double a) {
		// TODO Auto-generated method stub
		double aux = VelocidadAct - a;
		
		if(aux >= 0){
			VelocidadAct -= a;
		}else{
			VelocidadAct = 0;
		}
	}

	public void arrancar() {
		// TODO Auto-generated method stub
		System.out.println("He arrancado!");
	}
	@Override
	public void parar() {
		// TODO Auto-generated method stub
		System.out.println("He parado!");
	}
	
	@Override
	public String toString(){
		return "Matricula: " + matricula + "\n"
				+ "Marca: " + marca + "\n" +
				"Modelo: " + modelo + "\n" +
				"Teléfono: " + telefono;	
	}
}
