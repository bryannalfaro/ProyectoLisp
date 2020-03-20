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
		System.out.println("Ingrese nombre del programa Lisp a ejecutar seguido de .lisp: ");
		String directorioUsuario = System.getProperty("user.dir");
		Scanner ingresoPath=new Scanner(System.in);
		String ruta=ingresoPath.nextLine();
        
		String datosLisp="";
		if(new File(directorioUsuario + "\\src\\ArchivosPruebas\\"+ruta+".lisp").exists()) {
			try {
		        //Scanner inputScan = new Scanner(new File(ruta));
				Scanner inputScan = new Scanner(new File(directorioUsuario + "\\src\\ArchivosPruebas\\"+ruta+".lisp"));
		        while (inputScan.hasNextLine()) {
		            String line = inputScan.nextLine();
		            datosLisp+=line+"\n";
		              
		        }
		        inputScan.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}
		return datosLisp;
	}

}
