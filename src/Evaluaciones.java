 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que recibe la peticion y envia el resultado requerido
 * @author Bryann
 * @author Diego de Jesus
 * @author Javier Hernandez
 *
 */
// Clase para evaluaciones
 
public class Evaluaciones {


    public List<Object> list(List<Object> valores){
        return valores;
    }

    public boolean equals(Object obj1, Object obj2){
        return obj1.equals(obj2);
    }

    /**
     * Metodo para evaluar la instruccion cond
     * @param instructiones
     * @return Object
     */
    public Object cond(List<?> instructiones){
        List<?> listTemp = instructiones.subList(1, instructiones.size());
        List<?> listTemp2 = (List<?>) listTemp.get(0);
        int i = 0;
        
        for(int u=0;u<listTemp2.size();u++) {
        	Object inst=listTemp2.get(u);
        	List<?> instruccion = (List<?>)inst;
        	
            if (instruccion.contains("equal")){
                if (equals(instruccion.get(1), instruccion.get(2))){
                    return instruccion;
                }
            } else if (instruccion.contains("<")){
                if (Menor(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (instruccion.contains(">")){
                if (Mayor(instruccion.get(1), instruccion.get(2))){
                	return instruccion.get(3);
                }
            } else if (i == listTemp2.size()){
                return listTemp2.get(i);
            }
            i++;
        }
        
        return null;
    }
    
    //Funciones de mayor y menor
    public boolean Mayor(Object obj1, Object obj2){
        return (Double.parseDouble(obj1.toString()) > Double.parseDouble(obj2.toString()));
    }

    public boolean Menor(Object obj1, Object obj2){
        return (Double.parseDouble(obj1.toString()) < Double.parseDouble(obj2.toString()));
    }
    
    /**
     * Metodo para evaluar el quote 
     * @param instrucciones
     */
    public void quoteShow(List<?> instrucciones) {
    	String texto="";
    	for(int i=1;i<instrucciones.size();i++) {
    		
    		texto+=instrucciones.get(i)+" ";
    		System.out.println(texto);
    	}
    }
    /**
     * Metodo para evaluar el setq
     * @param instrucciones
     */
    public void setqEstablished(List<?> instrucciones) {
    	Map<String, String> map = new HashMap<String, String>();
    	//Si es una lista a almacenar
    	if(instrucciones.get(2).toString().charAt(0)=='['){
    		
    		Map<String, String> map2 = new HashMap<String, String>();
    		String[] var=instrucciones.get(2).toString().split(",");
    		String contenido="";
    		for(int i=1;i<var.length;i++) {
    			//System.out.println(var[i]);
    			contenido+=var[i];
    		}
    		map.put(instrucciones.get(1).toString(), contenido);
    		System.out.println("La variable es: "+instrucciones.get(1).toString());
    		System.out.println("valor "+"["+map.get(instrucciones.get(1).toString()));
    		
    	//Si solo es un dato	
    	}else {
    		
    		map.put(instrucciones.get(1).toString(), instrucciones.get(2).toString());
    		
    		System.out.println("La variable es: "+instrucciones.get(1).toString());
    		System.out.println("valor "+map.get(instrucciones.get(1).toString()));//Probar que si lo jala
    	}
    	
    }
    /**
     * Metodo para evaluar el primer elemento de list
     * @param instrucicones
     * @param n
     */
    public void firstOfList(List<?> instrucicones, Object n) {
    	String m="";
    	m=instrucicones.get(1).toString();
    	//System.out.println(m);
    	System.out.println(n);
    }
    
}
