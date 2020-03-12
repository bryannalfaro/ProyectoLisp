import java.util.Scanner;

public class PrincipalLisp {
	
	public static void main(String[] args) {
		System.out.println("Bienvenido al interprete Lisp");
		System.out.println("1. Buscar archivo");
		System.out.println("2. Salir");
		Scanner ingreso = new Scanner(System.in);
		
		int entrada;
		entrada=ingreso.nextInt();
		boolean flag=true;
		while(flag) {
			if(entrada==1) {
				System.out.println("Ingrese path del programa Lisp a ejecutar: ");
				flag=false;
			}else if(entrada==2) {
				System.out.println("Hasta pronto");
			}else {
				System.out.println("Opcion no valida");
			}
		}
	}

}
