import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class PrincipalLisp {
	
	public static void main(String[] args) {
		Scanner ingreso = new Scanner(System.in);
		int entrada;
		boolean flag=true;
		Proceso proceso= new Proceso();
		
		System.out.println("Bienvenido al interprete Lisp");
		System.out.println("1. Buscar archivo");
		System.out.println("2. Salir");
		
		entrada=ingreso.nextInt();
		
		while(flag) {
			if(entrada==1) {
				
				System.out.println("Ingrese nombre del programa Lisp a ejecutar seguido de .lisp: ");
				String directorioNuevoDiccionario = System.getProperty("user.dir");
				Scanner ingresoPath=new Scanner(System.in);
				String ruta=ingresoPath.nextLine();
		        
				String datosLisp="";
				if(new File(directorioNuevoDiccionario + "\\src\\ArchivosPruebas\\"+ruta).exists()) {
					try {
				        //Scanner inputScan = new Scanner(new File(ruta));
						Scanner inputScan = new Scanner(new File(directorioNuevoDiccionario + "\\src\\ArchivosPruebas\\"+ruta));
				        while (inputScan.hasNextLine()) {
				            String line = inputScan.nextLine();
				            datosLisp+=line+"\n";
				              
				        }
				        inputScan.close();
				    } catch (Exception ex) {
				        ex.printStackTrace();
				    }
				}
				System.out.println(datosLisp);
				 String tempInstruction = "";
			        char[] caracteres = (datosLisp).toCharArray();
			        
			        List<Object> listas = new ArrayList<Object>();
			        
			        for(int i = 0; i < caracteres.length;i++){
			        	
			            if(caracteres[i] == ')'){
			                tempInstruction += caracteres[i];
			                
			                if(i < (caracteres.length - 2)){
			                   if(caracteres[i + 1] == '('){
			                       listas.add(tempInstruction);
			                        tempInstruction = "";
			                   }
			                }
			            }
			            else if(caracteres[i] == '\n'){
			                listas.add(tempInstruction);
			                tempInstruction = "";
			            }
			            else{
			                tempInstruction += caracteres[i];
			            } 
			        }
			        
			     System.out.println("LISTAS:"+listas);
			     List<Object> list;
			     
			     try{
			            List instruccions = (List)listas;            
			            List tempIns = new ArrayList();
			            ControladorInstrucciones archivo = new ControladorInstrucciones();
			            
			            for(int control=0;control<instruccions.size();control++){
			                tempIns.add(archivo.getTarea(archivo.getToken(" \n", instruccions.get(control).toString() )));
			                
			            }
			            proceso.procesar(instruccions, tempIns);
			            }catch(Exception e){
			                	System.out.println("No");
			                }flag=false;
			}else if(entrada==2) {
				System.out.println("Hasta pronto");
				flag=false;
			}else {
				System.out.println("Opcion no valida");
			}
	}
			
  }
			     
}