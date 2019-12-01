package range;

import org.junit.*;
import static org.junit.Assert.*;

public class RangeTest {
	
	private Range r;
	
	@Before
	public void initR() {
		r = new Range(0,5);
	}
	
	@Test
	public void minFromConstructorCanBeGotBack() {
		assertEquals(0, r.getMin());
	}
	
	@Test
	public void maxFromConstructorCanBeGotBack() {
		assertEquals(5, r.getMax());
	}
	
	@Test
	public void sizeHaveElementCount() {
		assertEquals("Size should be 6 because range is inclusive", 6, r.getSize());
	}
	
}