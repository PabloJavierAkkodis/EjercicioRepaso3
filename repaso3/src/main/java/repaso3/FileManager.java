package repaso3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;



public class FileManager {

	private static FileManager instance;

	private FileManager() {
		super();
	}
	
	public static FileManager getFM(){
		if(instance == null) {
			return new FileManager();
		} else {
			return instance;
		}
	}
	
	public ArrayList<Empleado> readfile(){
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		 try
		 		{
		 		File documento = new File(".\\info_salarial_plantilla_" + LocalDate.now().toString() + ".txt");
		 		BufferedReader leer_fichero = new BufferedReader(new FileReader(documento));
		 		String caracteres = "";
		 		
		 		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 		while((caracteres = leer_fichero.readLine()) != null)
		 		{
		 			
		 			String[] arrOfStr = caracteres.split("\\s+");
		 			
		 			
		 				
		 			empleados.add(new Empleado(arrOfStr[0],
		 					arrOfStr[1],
		 					arrOfStr[2],
		 					arrOfStr[3],
		 					LocalDate.parse(arrOfStr[4], fmt),
		 					LocalDate.parse(arrOfStr[5], fmt),
		 					Integer.valueOf(arrOfStr[6]),
		 					Double.valueOf(arrOfStr[7]),
		 					arrOfStr[8]
		 					));
		 				
		 			 
					

		 		}
		 	}
		 	catch (IOException e)
		 	{
//		 		e.printStackTrace();
		 	}
		
		
		return empleados;
	}
	
	public void writeFile(ArrayList<Empleado> empleados){
		
		try {
			
			File archivo = new File(".\\info_salarial_plantilla_" + LocalDate.now().toString() + ".txt");
			if(! archivo.exists())
			{
			archivo.createNewFile();
			System.out.println("Se ha generado el archivo.");
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Empleado empleado : empleados) {
				bw.write(empleado.toString());
			}
			
			
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
		
	}

	
	
	
}
