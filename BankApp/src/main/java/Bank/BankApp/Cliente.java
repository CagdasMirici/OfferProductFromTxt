package Bank.BankApp;

import java.time.LocalDate;

public class Cliente {
	
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String codigoPais;
	
	
	
	
	
	public Cliente(String dni, String nombre, LocalDate fechaNacimiento, String codigoPais) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoPais = codigoPais;
	}
	public String getDni() {
		
		//if ((dni.length()) != 8 & dni.charAt(2) )
		
		
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	
	
	
	
}
