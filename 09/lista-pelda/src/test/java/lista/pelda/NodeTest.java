package lista.pelda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NodeTest {

	@Test
	public void nodeCanBeCreatedWithoutExtraNodes() {
		Node<Integer> nodeI = Node.createFromValue(1);
		assertEquals(1, nodeI.getValue());
	}
	
	@Test
	public void byDefaultNothingIsBefore() {
		Node<Integer> nodeI = Node.createFromValue(1);
		assertFalse(nodeI.hasAnythingBefore());
	}
	
	@Test
	public void byDefaultNothingIsAfter() {
		Node<Integer> nodeI = Node.createFromValue(1);
		assertFalse(nodeI.hasAnythingAfter());
	}
	
	@Test
	public void nodeCanBeCreatedAfterOtherNode() {
		Node<Integer> before = Node.createFromValue(1);
		Node<Integer> node = Node.createAfter(2, before);
		assertTrue(before.hasAnythingAfter());
		assertTrue(node.hasAnythingBefore());
	}
	
	@Test
	public void nodeCanBeCreatedBeforeOtherNode() {
		Node<Integer> after = Node.createFromValue(1);
		Node<Integer> node = Node.createBefore(2, after);
		assertTrue(after.hasAnythingBefore());
		assertTrue(node.hasAnythingAfter());
	}
	
	@Test
	public void nodeCanBeCreatedBetweenOtherNodes() {
		Node<Integer> before = Node.createFromValue(1);
		Node<Integer> after = Node.createFromValue(3);
		Node<Integer> node = Node.createBetween(2, before, after);
		assertTrue(before.hasAnythingAfter());
		assertTrue(after.hasAnythingBefore());
		assertTrue(node.hasAnythingAfter());
		assertTrue(node.hasAnythingBefore());
	}
	
	@Test
	public void createAfterRejectNullNode() {
		assertThrows(IllegalArgumentException.class, ()->Node.createAfter(1, null));
	}
	
	@Test
	public void createBeforeRejectNullNode() {
		assertThrows(IllegalArgumentException.class, ()->Node.createBefore(1, null));
	}
	
	@Test
	public void createBetweenRejectsNullBefore() {
		assertThrows(IllegalArgumentException.class, ()->Node.createBetween(1, null, Node.createFromValue(2)));
	}
	
	@Test
	public void createBetweenRejectsNullAfter() {
		assertThrows(IllegalArgumentException.class, ()->Node.createBetween(1, Node.createFromValue(2), null));
	}
	
	@Test
	public void previousReturnsBefore() {
		Node<Integer> after = Node.createFromValue(1);
		Node<Integer> node = Node.createBefore(2, after);
		assertSame(node, after.previous());
	}

	@Test
	public void nextReturnsAfter() {
		Node<Integer> before = Node.createFromValue(1);
		Node<Integer> node = Node.createAfter(2, before);
		assertSame(node, before.next());
	}
	
}
