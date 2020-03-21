import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	
	List<String> dato = new ArrayList();

	@Test
	public void testMayor() {
		Evaluaciones test = new Evaluaciones();
		boolean result = test.Mayor(3, 1);
		assertEquals(true, result);
	}
	
	@Test
	public void testMenor() {
		Evaluaciones test = new Evaluaciones();
		boolean result = test.Menor(3, 1);
		assertEquals(false, result);
	}
	
	@Test
	public void testEquals() {
		Evaluaciones test = new Evaluaciones();
		boolean result = test.equals(4, 4);
		assertEquals(true, result);
	}
	
	@Test
	public void testQuote() {
		Evaluaciones test = new Evaluaciones();
		dato.add("e");
		dato.add("3fd");
		test.quoteShow(dato);
	}
	
	@Test
	public void testSetq() {
		Evaluaciones test = new Evaluaciones();
		dato.add("setq");
		dato.add("x");
		dato.add("4");
		test.setqEstablished(dato);
	}
	
	
}
