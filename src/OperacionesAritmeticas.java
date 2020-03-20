import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Clase donde se realizan aritmeticas
 *@author Bryann
 *@author Diego de Jesus
 *@author Javier Hernandez
 *
 */
public class OperacionesAritmeticas {
	
	double resultado=0.0;
	int largo=0;
	
	
	@SuppressWarnings("unchecked")
	public Double calcular(List<Object> Lista){
			Stack<Double> resultadoStack=new Stack<>();
	        
	        String signo = String.valueOf(Lista.get(0));
	        
	        for (int i = 1; i < Lista.size(); i++){
	            if(Lista.get(i).getClass()==Integer.class || Lista.get(i).getClass()==Double.class ){
	                
	                resultadoStack.push(Double.parseDouble(Lista.get(i).toString()));
	                
	            }else if(Lista.get(i).getClass()==ArrayList.class){ 
	                resultadoStack.push(calcular((List)Lista.get(i)));
	            }
	        }
	        
	        operacion(signo,resultadoStack);
	         return resultadoStack.peek();
	    }

	public void operacion(String signo, Stack<Double>resultado) {
		  if(signo.matches("[+]")){
	          resultado.push(OperacionSuma(resultado));
	      }
	      if(signo.matches("[-]")){
	          resultado.push(OperacionResta(resultado));
	      }
	      if(signo.matches("[*]")){
	          resultado.push(OperacionProducto(resultado));
	      }
	      if(signo.matches("[/]")){
	          resultado.push(OperacionDivision(resultado));
	      }
	      
	}
    
    
    public double OperacionSuma(Stack<Double> value){
        resultado=0;
        largo = value.size();
        
        for(int control = 0; control<largo;control++){
            resultado += value.pop();
        }
        return resultado;
    }
    
    
    public double OperacionResta(Stack<Double> value){
        
        Stack<Double> temp_stack = ChangeStack(value);
        
        resultado = temp_stack.pop();
        largo = temp_stack.size();
        
        for(int i = 0; i<largo;i++){
            resultado -= temp_stack.pop();
        }
        return resultado;
    }
    
    public double OperacionProducto(Stack<Double> value){
       
        resultado = value.pop();
        largo = value.size();
        for(int i = 0; i<largo;i++){
            resultado *= value.pop();
        }        
        return resultado;
    }
    
    public double OperacionDivision(Stack<Double> value){
        
        Stack<Double> temp_stack = ChangeStack(value);
        
        resultado = temp_stack.pop();
        largo = temp_stack.size();
        
        for(int control = 0; control<largo;control++){
            resultado /= temp_stack.pop();
        }
        
        return resultado;
    }
    
    public Stack<Double> ChangeStack(Stack<Double> value){
        Stack<Double> temp_stack = new Stack<Double>();
        while(!value.empty()){
            temp_stack.add((double)value.pop());
        }
        
        return temp_stack;
    }
}
