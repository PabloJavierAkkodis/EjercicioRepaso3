package repaso3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Empleado {
	

	String nombre;
	String apellido;
	String dni;
	String localidadNac;
	LocalDate fechaNac;
	LocalDate fechaIngreso;
	int edad;
	Double salario;
	String puesto;
	
	
//	Agregados:
//	- Salario Final: Salario * 0.8
//	- Antiguedad laboral: Fecha actual - Fecha de ingreso
//	
	
	public Double getSalarioNeto() {
		return salario * 0.8;
	}
	 
	//podriamos devolver el objeto de tipo Period si quieremos ver la fecha con más exactitud
	public int getAntiguedad() {
		return Period.between(fechaIngreso , LocalDate.now()).getYears();
	}
	
	
	
	
	
	
	
	public Empleado() {
		super();
	}

	public Empleado(String nombre, String apellido, String dni, String localidadNac, LocalDate fechaNac,
			LocalDate fechaIngreso, int edad, Double salario, String puesto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.localidadNac = localidadNac;
		this.fechaNac = fechaNac;
		this.fechaIngreso = fechaIngreso;
		this.edad = edad;
		this.salario = salario;
		this.puesto = puesto;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getLocalidadNac() {
		return localidadNac;
	}
	public void setLocalidadNac(String localidadNac) {
		this.localidadNac = localidadNac;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return nombre + "\t \t" + apellido + "\t \t" + dni + "\t \t"
				+ localidadNac + "\t \t" + fechaNac.format(fmt) + "\t \t" + fechaIngreso.format(fmt) + "\t \t" + edad
				+ "\t \t" + salario + "\t \t" + puesto  + "\t \t" + getSalarioNeto() + "\t \t" + 
				getAntiguedad() + "\n";
	}
	

}
