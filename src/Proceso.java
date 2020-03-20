import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Proceso {
	
	public void procesar(List instruccion, List tempIns) {
		List<Object> list;
		for (int i=0; i<tempIns.size(); i++) {
            instruccion = null;
            if(tempIns.get(i).getClass()==(ArrayList.class)){
                instruccion = (List) tempIns.get(i);
            }
            else if(tempIns.getClass() == ArrayList.class){
            	instruccion = tempIns;
               
            }
            else if(tempIns.get(i).getClass()==String.class){
                instruccion = Arrays.asList(tempIns.toString().split(" "));
               
            }
            else{
                 instruccion = tempIns;
            }
            
            System.out.println("Instruccion " + instruccion);
            
            if (instruccion.contains("+") || instruccion.contains("-") || instruccion.contains("*") || instruccion.contains("/")){
            	
                OperacionesAritmeticas calculator = new OperacionesAritmeticas();
                System.out.println("Resultado: " + calculator.calcular(instruccion));
                break;
                
            } else if (instruccion.contains("list")){
            	System.out.println("Entro list");
                list = new Evaluaciones().list(instruccion.subList(1, instruccion.size()));
                System.out.println("Lista Creada: " +list);
                
            } else if (instruccion.contains("equal")){
            	
                if( (new Evaluaciones()).equals(instruccion.get(1), instruccion.get(2))){
                    System.out.print("Resultado: Verdadero, " + instruccion.get(1) + " es igual que " + instruccion.get(2));
                }
                else{
                    System.out.print("Resultado: Falso, " + instruccion.get(1) + " No es igual que " + instruccion.get(2));
                }
                
            } else if (instruccion.contains(">")){
            	
                if( (new Evaluaciones()).greaterThan(instruccion.get(1), instruccion.get(2))){
                    System.out.print("Resultado: Verdadero, " + instruccion.get(1) + " es mayor que " + instruccion.get(2));
                }
                else{
                    System.out.print("Resultado: Falso, " + instruccion.get(1) + " NO es mayor que " + instruccion.get(2));
                }
                
            } else if (instruccion.contains("<")){
            	
                if( (new Evaluaciones()).lessThan(instruccion.get(1), instruccion.get(2))){
                    System.out.print("Resultado: Verdadero, " + instruccion.get(1) + " es menor que " + instruccion.get(2));
                }
                else{
                    System.out.print("Resultado: Falso, " + instruccion.get(1) + " NO es menor que " + instruccion.get(2));
                }
            
            }else if (instruccion.contains("cond")){
                tempIns = (ArrayList)new Evaluaciones().cond(instruccion);
                if (tempIns == null) {
					tempIns = (List)instruccion.get(1);
					i=-1;
				}
                
                
            }else if(instruccion.contains("quote")) {
            	new Evaluaciones().quoteShow(instruccion);
            }else if(instruccion.contains("setq")) {
            	new Evaluaciones().setqEstablished(instruccion);
            }
            else if(instruccion.contains("first")) {
            	System.out.println("Entro first");
            	list=new Evaluaciones().list(instruccion.subList(1, instruccion.size()).subList(0, instruccion.size()-1));
            	new Evaluaciones().firstOfList(instruccion,list.get(0).toString().substring(8,9));
            }
            
		}
	}

}