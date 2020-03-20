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
	
	public List token(String separador, String valor){
        String temp = valor.replaceAll("\\,", " ").replaceAll("\\[", "(").replaceAll("\\]", ")");
        List temp2 = Collections.list(new StringTokenizer(temp.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").trim(), separador)).stream().map(token -> (String) token).collect(Collectors.toList());
        return temp2;
        
    }
	
	public Object procesarInstruccion(List inst) throws Exception {
	        
	    if (inst.isEmpty()) {
	            throw new IllegalArgumentException("INVALIDO");
		}
	    
	    String tkn = inst.remove(0).toString();
	       
		if (tkn.equals("(")) {
	           
			List<Object> temp = new ArrayList<Object>(inst.size() - 1);
            try{
                while (!inst.get(0).equals(")")){
                	temp.add(procesarInstruccion(inst));
                }
                
                inst.remove(0);

                if(inst.get(0).equals("(") && inst.size() > 1){
                	temp.add(procesarInstruccion(inst));
                }
                
                return temp;
                
            } catch(Exception e){
                return temp;
            }
	            
		} else if (tkn.equals(")")) {
	            throw new Exception("ERROR DE TOKEN");
		} else {
        	try {
    	        return Integer.parseInt(tkn);
        	} 
    	    catch (NumberFormatException error) {
    	        try {
    	            
    	            return Float.parseFloat(tkn);
    	        } catch (NumberFormatException error_2) {
    	            try {
    	                
    	                return Double.parseDouble(tkn);
    	            } catch (NumberFormatException error_3) {
    	               
    	                return tkn;
    	            }
	    	    }
	    	}
		}     
	}   
}
