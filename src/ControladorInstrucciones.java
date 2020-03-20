import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
/**
 * 
 * Clase donde se maneja el archivo
 * @author Bryann
 * @author Diego de Jesus
 * @author Javier Hernandez
 *
 */
public class ControladorInstrucciones {
	
	public List getToken(String delimitador,String value){
        String tempValue = value.replaceAll("\\,", " ").replaceAll("\\[", "(").replaceAll("\\]", ")");
        
        List tempList = Collections.list(new StringTokenizer(tempValue.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").trim(), delimitador)).stream()
            .map(token -> (String) token)
            .collect(Collectors.toList());
        return tempList;
        
    }
	
	public Object getTarea(List instruccion) throws Exception {
	        
	        if (instruccion.isEmpty()) {
	            throw new IllegalArgumentException("INVALIDO");
		}
	        String token = instruccion.remove(0).toString();
	       
		if (token.equals("(")) {
	           
	            List<Object> tempList = new ArrayList<Object>(instruccion.size() - 1);
	            try{
	                while (!instruccion.get(0).equals(")")){
	                    
	                    tempList.add(getTarea(instruccion));
	                }
	
	                
	                instruccion.remove(0);
	
	
	                if(instruccion.get(0).equals("(") && instruccion.size() > 1){
	                    tempList.add(getTarea(instruccion));
	                }
	                
	                return tempList;
	            }
	            catch(Exception e){
	                return tempList;
	            }
	            
		} 
	        else if (token.equals(")")) {
	            throw new Exception("ERROR");
		} 
	        else {
	        	try {
	    	        return Integer.parseInt(token);
	    	} 
	    	    catch (NumberFormatException e) {
	    	        try {
	    	            
	    	            return Float.parseFloat(token);
	    	        } 
	    	        catch (NumberFormatException e2) {
	    	            try {
	    	                
	    	                return Double.parseDouble(token);
	    		} 
	    	            catch (NumberFormatException e3) {
	    	               
	    	                return token;
	    		}
	    	        }
	    	}
		}
	        
	    }


	   

}
