package repaso3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


/*
 *	 ACTIVIDAD DE REPASO N° 3
		Nos contrataron del Ministerio de Empleo para poder solucionarles un problema que tienen con su información. Manejan la información de los empleados
		a traves de archivos en Excel y por este motivo necesitan que desarrollemos un sistema con una solución integral.
		
		El mismo debe poder almacenar la siguiente información de los empleados:
		- Nombre
		- Apellido
		- DNI
		- Localidad de nacimiento
		- Fecha de Nacimiento
		- Fecha de Ingreso 
		- EDAD
		- Salario 
		- Puesto
		Agregados:
		- Salario Final: Salario * 0.8
		- Antiguedad laboral: Fecha actual - Fecha de ingreso
		
		ESTRUCTURA DEL PROGRAMA:
		- Se debe informar todo a traves de un txt de salida con el siguiente formato "info_salarial_plantilla_fechaDeHoy"
		
		CONSIDERACIONES:
		- Hacerlo al menos para 4 empleados.
 * 
 * 
 * */


public class Main {
	
	static ArrayList<Empleado> empleados = new ArrayList<>();
	static FileManager fm = FileManager.getFM();
	
	public static void main (String[] args) {
		
		
		
		init();
		
	}
	
	
private static void init() {
		
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Leyendo base de datos...");
		
		empleados = fm.readfile();
		
		while(true) {
			int select;
			System.out.println("Registros obtenidos de la base de datos:");
			System.out.println("   ---------------------------------------------------  ");
			
			listar();
			
			System.out.println("   ---------------------------------------------------  ");
			System.out.println("¿Desea editar algun registro? ");
			System.out.println("1	 - Añadir");
			System.out.println("2	 - Editar");
			System.out.println("3	 - Borrar");
			System.out.println("4	 - Guardar y salir");

			System.out.println("Otro - Cancelar");
			
			
			
			try {				
				select = sc.nextInt();
			}catch (Exception e){
				fm.writeFile(empleados);
		 		break;
		 	}
			
			switch (select) {
						
				case 1:
					System.out.println("Ingrese parámetros");
					System.out.println("   ---------------------------------------------------  ");
					
					System.out.println("Ingrese nombre: ");
					String nom= sc.next();
					
					System.out.println("Ingrese apellido: ");
					String ape= sc.next();
					

					System.out.println("Ingrese dni: ");
					String dni = sc.next();

					System.out.println("Ingrese localidad de nacimiento : ");
					String locN = sc.next();
					
					System.out.println("Ingrese edad: ");
					int edad= sc.nextInt();
					
					System.out.println("Ingrese fecha de nacimiento (dd/mm/yyyy): ");
					String fNac = sc.next();
					
					System.out.println("Ingrese fecha de ingreso (dd/mm/yyyy): ");
					String fIng = sc.next();
					
					System.out.println("Ingrese salario de empleado: ");
					Double salario = sc.nextDouble();
					
					System.out.println("Ingrese puesto de empleado: ");
					String puesto = sc.next();
					
					empleados.add(new Empleado(nom, ape, dni, locN, LocalDate.parse(fNac, fmt),LocalDate.parse(fIng, fmt), edad, salario, puesto ));
					
					
					break;
						
				case 2:
					System.out.println("Ingrese id de empleado: ");
					select = sc.nextInt() - 1;
					
					System.out.println("Ingrese parámetros");
					System.out.println("   ---------------------------------------------------  ");
					
					System.out.println("Ingrese nombre: ");
					empleados.get(select).setNombre(sc.next());
					
					System.out.println("Ingrese apellido: ");
					empleados.get(select).setApellido(sc.next());

					System.out.println("Ingrese dni: ");
					empleados.get(select).setDni(sc.next());
					
					System.out.println("Ingrese localidad de nacimiento : ");
					empleados.get(select).setLocalidadNac(sc.next());
					
					System.out.println("Ingrese edad: ");
					empleados.get(select).setEdad(sc.nextInt());
					
					System.out.println("Ingrese fecha de nacimiento (dd/mm/yyyy): ");
					String fNacAux = sc.next();
					empleados.get(select).setFechaNac(LocalDate.parse(fNacAux, fmt ));

					
					System.out.println("Ingrese fecha de ingreso (dd/mm/yyyy): ");
					String fIngAux = sc.next();
					empleados.get(select).setFechaIngreso(LocalDate.parse(fNacAux, fmt ));
					
					System.out.println("Ingrese salario de empleado: ");
					empleados.get(select).setSalario(sc.nextDouble());
					
					System.out.println("Ingrese puesto de empleado: ");
					empleados.get(select).setPuesto(sc.next());

					System.out.println("Listo, editado");
					
					break;
					
				case 3:
					System.out.println("Ingrese id de empleado: ");
					select = sc.nextInt() - 1;
					empleados.remove(select);					
					System.out.println("Listo, borrado");
					
					break;	
						
				case 4:
					fm.writeFile(empleados);
					break;
			}
		}
	
	
	}


		private static void listar() {
			
			System.out.println("NOMBRE \t \t APELLIDO \t DNI \t \t LOCALIDAD \t \t F_NACIMIENTO \t \t F_INGRESO \t \t"
					+ "EDAD \t \t SALARIO \t PUESTO \t SALARIO_NETO \t ANTIGUEDAD \n");
		
			for(Empleado e : empleados) {

				System.out.println(e.toString());
			
			}
		}

}
