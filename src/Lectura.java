import java.io.File;
import java.util.Scanner;

/**
 * Clase encargada de la lectura del archivo
 * @author Bryann
 * @author Diego de Jesus
 * @author Javier Hernandez
 *
 */
public class Lectura {
	
	public String lectura() {
		System.out.println("Ingrese nombre del programa Lisp a ejecutar (sin el .lisp): ");
		String directorioUsuario = System.getProperty("user.dir");
		
		Scanner ingresoPath=new Scanner(System.in);
		String ruta=ingresoPath.nextLine();
		
        
		String datosLisp="";
		
			
			Scanner inputScan;
			try {
		        //Scanner inputScan = new Scanner(new File(ruta));
				if(directorioUsuario.contains("src")) {
					inputScan = new Scanner(new File(directorioUsuario+"\\"+"ArchivosPruebas\\"+ruta+".lisp"));
				}else {
					inputScan = new Scanner(new File(directorioUsuario+"\\src\\"+"ArchivosPruebas\\"+ruta+".lisp"));
				}
				
		        while (inputScan.hasNextLine()) {
		            String line = inputScan.nextLine();
		            datosLisp+=line+"\n";
		              
		        }
		        inputScan.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		
		return datosLisp;
	}

}
