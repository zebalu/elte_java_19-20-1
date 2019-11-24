package lista.pelda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	public void testList() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> new List<Integer>());
	}
	
	@Test
	public void listCanBeIterated() throws Exception {
		List<Integer> list = new List<>(1,2,3,4);
		Iterator<Integer> iterator = list.iterator();
		for(int i=0; i<4; ++i) {
			assertTrue(iterator.hasNext());
			assertEquals(i+1, iterator.next());
		}
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void listCanBeIteratedWithForEach() throws Exception {
		List<Integer> list = new List<>(1,2,3,4);
		int expectedValue = 1;
		int stepsCount = 0;
		for(Integer i: list) {
			assertEquals(expectedValue, i);
			++expectedValue;
			++stepsCount;
		}
		assertEquals(4, stepsCount);
	}

}
