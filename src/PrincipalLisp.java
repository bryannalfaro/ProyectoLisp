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
		
		System.out.println("Bienvenido al interprete Lisp");
		System.out.println("1. Buscar archivo");
		System.out.println("2. Salir");
		
		entrada=ingreso.nextInt();
		
		while(flag) {
			if(entrada==1) {
				
				System.out.println("Ingrese path del programa Lisp a ejecutar: ");
				Scanner ingresoPath=new Scanner(System.in);
				String ruta=ingresoPath.nextLine();
				String datosLisp="";
				if(new File(ruta).exists()) {
					try {
				        Scanner inputScan = new Scanner(new File(ruta));
				        
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
			     
			     try{
			            List instruccions = (List)listas;            
			            List tempIns = new ArrayList();
			            ControladorInstrucciones archivo = new ControladorInstrucciones();
			            
			            for(int control=0;control<instruccions.size();control++){
			                tempIns.add(archivo.getTarea(archivo.getToken(" \n", instruccions.get(control).toString() )));
			                
			            }
			            for (int i=0;i<tempIns.size();i++) {

			                List instruccion = null;
			                
			                if(tempIns.get(i).getClass()==(ArrayList.class)){
			                    instruccion = (List) tempIns.get(i);
			                }
			                else if(tempIns.get(i).getClass()==String.class){
			                    instruccion = Arrays.asList(tempIns.toString().split(" "));
			                   
			                }
			                else{
			                     instruccion = tempIns;
			                }
			                System.out.println("Instruccion"+instruccion);
			                if (instruccion.contains("+") || instruccion.contains("-") || instruccion.contains("*") || instruccion.contains("/")){
			                    OperacionesAritmeticas calculator = new OperacionesAritmeticas();
			                    System.out.println("Resultado: " + calculator.calcular(instruccion));
			                    break;
			                    
			                }
			                }}catch(Exception e){
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