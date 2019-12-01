package t;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;

public class IntHolderTest {

    @Test
	public void getReturnsValue() {
		IntHolder a = new IntHolder();
		a.setI(8);
		assertEquals(8, a.getI());
	}
	
	@Test
	@Ignore
	public void breakingtest() {
		IntHolder a = new IntHolder();
		a.setI(8);
		assertEquals(7, a.getI());
	}

}