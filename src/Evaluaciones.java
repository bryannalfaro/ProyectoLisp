 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Clase para evaluaciones
 
public class Evaluaciones {


    public List<Object> list(List<Object> valores){
        return valores;
    }

    public boolean equals(Object obj1, Object obj2){
        return obj1.equals(obj2);
    }

    public boolean greaterThan(Object obj1, Object obj2){
        return (Double.parseDouble(obj1.toString()) > Double.parseDouble(obj2.toString()));
    }

    public boolean lessThan(Object obj1, Object obj2){
        return (Double.parseDouble(obj1.toString()) < Double.parseDouble(obj2.toString()));
    }

    public Object cond(List instructiones){
        List listTemp = instructiones.subList(1, instructiones.size());
        List listTemp2 = (List) listTemp.get(0);
        int i = 0;
        for (Object inst: listTemp2) {
            List instruccion = (List)inst;
            if (instruccion.contains("equal")){
                if (equals(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (instruccion.contains("<")){
                if (lessThan(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (instruccion.contains(">")){
                if (greaterThan(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (i == listTemp2.size()){
                return listTemp2.get(i);
            }
            i++;
        }
        return null;
    }
    
    public void quoteShow(List instrucciones) {
    	String texto="";
    	for(int i=1;i<instrucciones.size();i++) {
    		
    		texto+=instrucciones.get(i)+" ";
    		System.out.println(texto);
    	}
    }
    
    public void setqEstablished(List instrucciones) {
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
    
    public void firstOfList(List instrucicones, Object n) {
    	String m="";
    	m=instrucicones.get(1).toString();
    	//System.out.println(m);
    	System.out.println(n);
    }
    
}
