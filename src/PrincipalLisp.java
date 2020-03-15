import java.io.File;
import java.util.Scanner;

public class PrincipalLisp {
	
	public static void main(String[] args) {
		System.out.println("Bienvenido al interprete Lisp");
		System.out.println("1. Buscar archivo");
		System.out.println("2. Salir");
		Scanner ingreso = new Scanner(System.in);
		
		int entrada;
		entrada=ingreso.nextInt();
		boolean flag=true;
		while(flag) {
			if(entrada==1) {
				System.out.println("Ingrese path del programa Lisp a ejecutar: ");
				Scanner ingresoPath=new Scanner(System.in);
				String ruta=ingresoPath.nextLine();
				String datos="";
				if(new File(ruta).exists()) {
					try {
				        Scanner inputScan = new Scanner(new File(ruta));
				        
				        while (inputScan.hasNextLine()) {
				            String line = inputScan.nextLine();
				            datos+=line+"\n";
				              
				        }
				        inputScan.close();
				    } catch (Exception ex) {
				        ex.printStackTrace();
				    }
				}
				System.out.println(datos);
				flag=false;
			}else if(entrada==2) {
				System.out.println("Hasta pronto");
				flag=false;
			}else {
				System.out.println("Opcion no valida");
			}
		}
	}

}
