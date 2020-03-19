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
			     List<Object> list;
			     
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
			                    
			                } else if (instruccion.contains("list")){
			                	
			                    list = new Evaluaciones().list(instruccion.subList(1, instruccion.size()));
			                    System.out.println("Lista Creada: " + list.get(0));
			                    
			                } else if (instruccion.contains("equal")){
			                	
			                    if( (new Evaluaciones()).equals(instruccion.get(1), instruccion.get(2))){
			                        System.out.print("Resultado: Verdadero, " + instruccion.get(1) + " es igual que" + instruccion.get(2));
			                    }
			                    else{
			                        System.out.print("Resultado: Falso, " + instruccion.get(1) + " No es igual que" + instruccion.get(2));
			                    }
			                    
			                } else if (instruccion.contains(">")){
			                	
			                    if( (new Evaluaciones()).greaterThan(instruccion.get(1), instruccion.get(2))){
			                        System.out.print("Resultado: Verdadero, " + instruccion.get(1) + " es mayor que" + instruccion.get(2));
			                    }
			                    else{
			                        System.out.print("Resultado: Falso, " + instruccion.get(1) + " NO es mayor que" + instruccion.get(2));
			                    }
			                    
			                } else if (instruccion.contains("<")){
			                	
			                    if( (new Evaluaciones()).lessThan(instruccion.get(1), instruccion.get(2))){
			                        System.out.print("Resultado: Verdadero, " + instruccion.get(1) + " es menor que" + instruccion.get(2));
			                    }
			                    else{
			                        System.out.print("Resultado: Falso, " + instruccion.get(1) + " NO es menor que" + instruccion.get(2));
			                    }
			                
				            }else if (instruccion.contains("cond")){
				                	new Evaluaciones().cond(instruccion);
				            }else if(instruccion.contains("quote")) {
				            	new Evaluaciones().quoteShow(instruccion);
				            }else if(instruccion.contains("setq")) {
				            	new Evaluaciones().setqEstablished(instruccion);
				            }
				            else if(instruccion.contains("first")) {
				            	list=new Evaluaciones().list(instruccion.subList(1, instruccion.size()).subList(0, instruccion.size()-1));
				            	new Evaluaciones().firstOfList(instruccion,list.get(0).toString().substring(7,8));
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