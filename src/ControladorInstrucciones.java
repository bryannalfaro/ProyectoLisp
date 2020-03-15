import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ControladorInstrucciones {
	
	public List getToken(String delimitador,String value){
        String tempValue = value.replaceAll("\\,", " ").replaceAll("\\[", "(").replaceAll("\\]", ")");
        System.out.println("TEMP"+tempValue);
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
	            return getAtom(token);
		}
	        
	    }

	private Object getAtom(String token) {
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
