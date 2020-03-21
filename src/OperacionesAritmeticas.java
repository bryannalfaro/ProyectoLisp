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
	/**
	 * Declaracion de variables necesarias
	 */
	private double resultadoNumerico=0.0;
	private int largo=0;
	
	
	@SuppressWarnings("unchecked")
	/**
	 * Metodo para obtener el numero de respuesta
	 * @param Lista
	 * @return Double
	 */
	public Double calcular(List<Object> Lista){
			Stack<Double> resultadoStack=new Stack<>();
	        
	        String signo = Lista.get(0).toString();
	        
	        for (int i = 1; i < Lista.size(); i++){
	            if(Lista.get(i).getClass()==Integer.class || Lista.get(i).getClass()==Double.class ){
	                String resultadoPush=Lista.get(i).toString();
	                resultadoStack.push(Double.parseDouble(resultadoPush));
	                
	            }else if(Lista.get(i).getClass()==ArrayList.class){ 
	                resultadoStack.push(calcular((List<Object>)Lista.get(i)));
	            }
	        }
	        
	        operacion(signo,resultadoStack);
	         return resultadoStack.peek();
	    }

	/**
	 * Se decide que operacion usar de acuerdo al signo
	 * @param signo
	 * @param resultado
	 */
	public void operacion(String signo, Stack<Double>resultado) {
		  if(signo.matches("[+]")){
			  resultadoNumerico=0;
		        largo = resultado.size();
		        
		        for(int control = 0; control<largo;control++){
		            resultadoNumerico += resultado.pop();
		        }
	          resultado.push(resultadoNumerico);
	      }
	      if(signo.matches("[-]")){
	    	  Stack<Double> temp_stack = ChangeStack(resultado);
	          
	          resultadoNumerico = temp_stack.pop();
	          largo = temp_stack.size();
	          
	          for(int i = 0; i<largo;i++){
	              resultadoNumerico -= temp_stack.pop();
	          }
	          resultado.push(resultadoNumerico);
	      }
	      if(signo.matches("[*]")){
	    	  resultadoNumerico = resultado.pop();
	          largo = resultado.size();
	          for(int i = 0; i<largo;i++){
	              resultadoNumerico *= resultado.pop();
	          } 
	          resultado.push(resultadoNumerico);
	      }
	      if(signo.matches("[/]")){
	    	  Stack<Double> temp_stack = ChangeStack(resultado);
	          
	          resultadoNumerico = temp_stack.pop();
	          largo = temp_stack.size();
	          
	          for(int control = 0; control<largo;control++){
	              resultadoNumerico /= temp_stack.pop();
	          }
	          resultado.push(resultadoNumerico);
	      }
	      
	}
   
	/**
	 * Cambia el stack para mejorar la lectura
	 * @param value
	 * @return Stack
	 */
    public Stack<Double> ChangeStack(Stack<Double> value){
        Stack<Double> temp_stack = new Stack<Double>();
        while(!value.empty()){
            temp_stack.add(value.pop());
        }
        
        return temp_stack;
    }
}
