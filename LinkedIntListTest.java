package hw4;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LinkedIntListTest {
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(4);

	@Test
	public void testRemoveLastOccurrenceEmpty05() {
		LinkedIntList l1 = new LinkedIntList();
		assertFalse(l1.removeLastOccurrence(0));
		assertFalse(l1.removeLastOccurrence(1));
		assertFalse(l1.removeLastOccurrence(-1));
		assertFalse(l1.removeLastOccurrence(42));
		assertFalse(l1.removeLastOccurrence(3));
		assertEquals("[]", l1.toString());
	}
	
	@Test
	public void testRemoveLastOccurrenceNotPresent05() {
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 5);
		l1.add(1, 0);
		l1.add(2, -1);
		l1.add(3, 42);
		l1.add(4, 9);
		l1.add(5, -5);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 6);
		l2.add(1, 0);
		l2.add(2, 1);
		l2.add(3, 42);
		l2.add(4, 99);
		l2.add(5, 4);
		// l1 = [5, 0, -1, 42, 9, -5]
		// l2 = [6, 0, 1, 42, 99, 4]
		
		assertFalse(l1.removeLastOccurrence(1));
		assertFalse(l1.removeLastOccurrence(2));
		assertFalse(l1.removeLastOccurrence(-3));
		assertFalse(l1.removeLastOccurrence(40));
		assertFalse(l1.removeLastOccurrence(100));
		assertEquals("[5, 0, -1, 42, 9, -5]", l1.toString());
		assertEquals("[6, 0, 1, 42, 99, 4]", l2.toString());
	}
	
	@Test
	public void testRemoveLastOccurrenceSingleOccurrence05() {
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 0);
		l1.add(1, 1);
		l1.add(2, -1);
		l1.add(3, 92);
		l1.add(4, 19);
		l1.add(5, -15);
		l1.add(6, 22);
		l1.add(7, 400);
		l1.add(8, -7);
		l1.add(9, 2);
		
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 1);
		l2.add(1, 2);
		l2.add(2, 0);
		l2.add(3, 93);
		l2.add(4, 20);
		l2.add(5, -15);
		l2.add(6, 23);
		l2.add(7, 401);
		l2.add(8, -6);
		l2.add(9, 3);
		
		//l1 = [0, 1, -1, 92, 19, -15, 22, 400, -7, 2]
		//l2 = [1, 2, 0, 93, 20, -15, 23, 401, -6, 3]
		assertTrue(l1.removeLastOccurrence(0));
		assertEquals("[1, -1, 92, 19, -15, 22, 400, -7, 2]", l1.toString());
		assertEquals("[1, 2, 0, 93, 20, -15, 23, 401, -6, 3]", l2.toString());
		assertTrue(l2.removeLastOccurrence(3));
		assertEquals("[1, -1, 92, 19, -15, 22, 400, -7, 2]", l1.toString());
		assertEquals("[1, 2, 0, 93, 20, -15, 23, 401, -6]", l2.toString());
		assertTrue(l1.removeLastOccurrence(-15));
		assertEquals("[1, -1, 92, 19, 22, 400, -7, 2]", l1.toString());
		assertEquals("[1, 2, 0, 93, 20, -15, 23, 401, -6]", l2.toString());
		assertTrue(l2.removeLastOccurrence(23));
		assertEquals("[1, -1, 92, 19, 22, 400, -7, 2]", l1.toString());
		assertEquals("[1, 2, 0, 93, 20, -15, 401, -6]", l2.toString());
		assertTrue(l1.removeLastOccurrence(1));
		assertEquals("[-1, 92, 19, 22, 400, -7, 2]", l1.toString());
		assertEquals("[1, 2, 0, 93, 20, -15, 401, -6]", l2.toString());
		assertTrue(l2.removeLastOccurrence(1));
		assertEquals("[-1, 92, 19, 22, 400, -7, 2]", l1.toString());
		assertEquals("[2, 0, 93, 20, -15, 401, -6]", l2.toString());
	}
	
	@Test
	public void testRemoveLastOccurrenceMultipleOccurrence05() {
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 5);
		l1.add(1, 7);
		l1.add(2, 3);
		l1.add(3, 5);
		l1.add(4, 5);
		l1.add(5, -1);
		l1.add(6, 2);
		l1.add(7, 0);
		l1.add(8, 5);
		l1.add(9, 9);
		l1.add(10, 7);
		l1.add(11, 5);
		l1.add(12, 5);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 3);
		l2.add(1, 7);
		l2.add(2, 3);
		l2.add(3, 3);
		l2.add(4, 5);
		l2.add(5, -1);
		l2.add(6, 2);
		l2.add(7, 0);
		l2.add(8, 3);
		l2.add(9, 9);
		l2.add(10, 7);
		l2.add(11, 3);
		l2.add(12, 5);
		
		//l1 = [5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7, 5, 5]
		//l2 = [3, 7, 3, 3, 5, -1, 2, 0, 3, 9, 7, 3, 5]
		assertTrue(l1.removeLastOccurrence(5));
		assertEquals("[5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7, 5]", l1.toString());
		assertEquals("[3, 7, 3, 3, 5, -1, 2, 0, 3, 9, 7, 3, 5]", l2.toString());
		assertTrue(l1.removeLastOccurrence(5));
		assertEquals("[5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7]", l1.toString());
		assertEquals("[3, 7, 3, 3, 5, -1, 2, 0, 3, 9, 7, 3, 5]", l2.toString());
		assertTrue(l2.removeLastOccurrence(7));
		assertEquals("[5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7]", l1.toString());
		assertEquals("[3, 7, 3, 3, 5, -1, 2, 0, 3, 9, 3, 5]", l2.toString());
		assertTrue(l2.removeLastOccurrence(7));
		assertEquals("[5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7]", l1.toString());
		assertEquals("[3, 3, 3, 5, -1, 2, 0, 3, 9, 3, 5]", l2.toString());
		assertFalse(l2.removeLastOccurrence(7));
		assertEquals("[5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7]", l1.toString());
		assertEquals("[3, 3, 3, 5, -1, 2, 0, 3, 9, 3, 5]", l2.toString());
		assertTrue(l1.removeLastOccurrence(5));
		assertEquals("[5, 7, 3, 5, 5, -1, 2, 0, 9, 7]", l1.toString());
		assertEquals("[3, 3, 3, 5, -1, 2, 0, 3, 9, 3, 5]", l2.toString());
		assertTrue(l1.removeLastOccurrence(5));
		assertEquals("[5, 7, 3, 5, -1, 2, 0, 9, 7]", l1.toString());
		assertEquals("[3, 3, 3, 5, -1, 2, 0, 3, 9, 3, 5]", l2.toString());
		assertTrue(l1.removeLastOccurrence(5));
		assertEquals("[5, 7, 3, -1, 2, 0, 9, 7]", l1.toString());
		assertEquals("[3, 3, 3, 5, -1, 2, 0, 3, 9, 3, 5]", l2.toString());
		assertTrue(l2.removeLastOccurrence(5));
		assertEquals("[5, 7, 3, -1, 2, 0, 9, 7]", l1.toString());
		assertEquals("[3, 3, 3, 5, -1, 2, 0, 3, 9, 3]", l2.toString());
		assertTrue(l2.removeLastOccurrence(5));
		assertEquals("[5, 7, 3, -1, 2, 0, 9, 7]", l1.toString());
		assertEquals("[3, 3, 3, -1, 2, 0, 3, 9, 3]", l2.toString());
		assertTrue(l1.removeLastOccurrence(5));
		assertEquals("[7, 3, -1, 2, 0, 9, 7]", l1.toString());
		assertEquals("[3, 3, 3, -1, 2, 0, 3, 9, 3]", l2.toString());
	}
	
	@Test
	public void testRemoveLastOccurrenceTIMING() {
		long start, finish, diff1, diff2;
		final int SMALL = 20000;
		final int LARGE = 2 * SMALL;
		LinkedIntList l1 = new LinkedIntList();
		LinkedIntList l2 = new LinkedIntList();
		for(int i = SMALL; i > 0; i--) {
			l1.addFirst(i);
		}
		for(int i = LARGE; i > 0; i--) {
			l2.addFirst(i);
		}
		start = System.currentTimeMillis();
		l1.removeLastOccurrence(1);
		finish = System.currentTimeMillis();
		diff1 = finish - start;
		start = System.currentTimeMillis();
		l2.removeLastOccurrence(1);
		finish = System.currentTimeMillis();
		diff2 = finish - start;
		assertFalse("RemoveLastOccurrence: " + diff1 + " --> " + diff2, diff2 > diff1 * 3 && diff2 - diff1 > 100);
		
		start = System.currentTimeMillis();
		l1.removeLastOccurrence(SMALL);
		finish = System.currentTimeMillis();
		diff1 = finish - start;
		start = System.currentTimeMillis();
		l2.removeLastOccurrence(LARGE);
		finish = System.currentTimeMillis();
		diff2 = finish - start;
		assertFalse("RemoveLastOccurrence: " + diff1 + " --> " + diff2, diff2 > diff1 * 3 && diff2 - diff1 > 100);
	}
	
	@Test
	public void testIndexOfEmpty05() {
		LinkedIntList l1 = new LinkedIntList();
		assertEquals(-1, l1.indexOf(0));
		assertEquals(-1, l1.indexOf(1));
		assertEquals(-1, l1.indexOf(-1));
		assertEquals(-1, l1.indexOf(42));
		assertEquals(-1, l1.indexOf(3));
		assertEquals("[]", l1.toString());
	}
	
	@Test
	public void testIndexOfNotPresent05() {
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 5);
		l1.add(1, 0);
		l1.add(2, -1);
		l1.add(3, 42);
		l1.add(4, 9);
		l1.add(5, -5);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 6);
		l2.add(1, 0);
		l2.add(2, 1);
		l2.add(3, 42);
		l2.add(4, 99);
		l2.add(5, 4);
		
		// l1 = [5, 0, -1, 42, 9, -5]
		// l2 = [6, 0, 1, 42, 99, 4]
		
		assertEquals(-1, l1.indexOf(1));
		assertEquals(-1, l1.indexOf(2));
		assertEquals(-1, l1.indexOf(-3));
		assertEquals(-1, l1.indexOf(40));
		assertEquals(-1, l1.indexOf(99));
		assertEquals(-1, l2.indexOf(-1));
		assertEquals(-1, l2.indexOf(9));
		assertEquals("[5, 0, -1, 42, 9, -5]", l1.toString());
		assertEquals("[6, 0, 1, 42, 99, 4]", l2.toString());
	}
	
	@Test
	public void testIndexOfSingleOccurrence05() {
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 0);
		l1.add(1, 1);
		l1.add(2, -1);
		l1.add(3, 92);
		l1.add(4, 19);
		l1.add(5, -15);
		l1.add(6, 22);
		l1.add(7, 400);
		l1.add(8, -7);
		l1.add(9, 2);
		
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 1);
		l2.add(1, 2);
		l2.add(2, 0);
		l2.add(3, 93);
		l2.add(4, 20);
		l2.add(5, -15);
		l2.add(6, 23);
		l2.add(7, 401);
		l2.add(8, -6);
		l2.add(9, 3);
		
		//l1 = [0, 1, -1, 92, 19, -15, 22, 400, -7, 2]
		//l2 = [1, 2, 0, 93, 20, -15, 23, 401, -6, 3]
		
		assertEquals(0, l1.indexOf(0));
		assertEquals(9, l2.indexOf(3));
		assertEquals(1, l1.indexOf(1));
		assertEquals(8, l2.indexOf(-6));
		assertEquals(2, l1.indexOf(-1));
		assertEquals(7, l2.indexOf(401));
		assertEquals(3, l1.indexOf(92));
		assertEquals(6, l2.indexOf(23));
		assertEquals(4, l1.indexOf(19));
		assertEquals(5, l2.indexOf(-15));
		assertEquals(9, l1.indexOf(2));
		assertEquals(0, l2.indexOf(1));
		assertEquals("[0, 1, -1, 92, 19, -15, 22, 400, -7, 2]", l1.toString());
		assertEquals("[1, 2, 0, 93, 20, -15, 23, 401, -6, 3]", l2.toString());
	}
	
	@Test
	public void testIndexOfMultipleOccurrence05() {
//		int[] data1 = {5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7, 5, -1};
//		int[] data2 = {3, 7, 3, 3, 6, -1, 2, 0, 3, 5, 7, 3, 5};
//		LinkedIntList l1 = new LinkedIntList(data1);
//		LinkedIntList l2 = new LinkedIntList(data2);
		
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 5);
		l1.add(1, 7);
		l1.add(2, 3);
		l1.add(3, 5);
		l1.add(4, 5);
		l1.add(5, -1);
		l1.add(6, 2);
		l1.add(7, 0);
		l1.add(8, 5);
		l1.add(9, 9);
		l1.add(10, 7);
		l1.add(11, 5);
		l1.add(12, -1);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 3);
		l2.add(1, 7);
		l2.add(2, 3);
		l2.add(3, 3);
		l2.add(4, 6);
		l2.add(5, -1);
		l2.add(6, 2);
		l2.add(7, 0);
		l2.add(8, 3);
		l2.add(9, 5);
		l2.add(10, 7);
		l2.add(11, 3);
		l2.add(12, 5);
		
		//l1 = [5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7, 5, -1]
		//l2 = [3, 7, 3, 3, 6, -1, 2, 0, 3, 5, 7, 3, 5]
		assertEquals(0, l1.indexOf(5));
		assertEquals(9, l2.indexOf(5));
		assertEquals(1, l1.indexOf(7));
		assertEquals(0, l2.indexOf(3));
		assertEquals(5, l1.indexOf(-1));
		assertEquals(1, l2.indexOf(7));
		assertEquals("[5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7, 5, -1]", l1.toString());
		assertEquals("[3, 7, 3, 3, 6, -1, 2, 0, 3, 5, 7, 3, 5]", l2.toString());
	}
	
	@Test
	public void testIndexOfTIMING() {
		long start, finish, diff1, diff2;
		final int SMALL = 20000;
		final int LARGE = 2 * SMALL;
		LinkedIntList l1 = new LinkedIntList();
		LinkedIntList l2 = new LinkedIntList();
		for(int i = SMALL; i > 0; i--) {
			l1.addFirst(i);
		}
		for(int i = LARGE; i > 0; i--) {
			l2.addFirst(i);
		}
		start = System.currentTimeMillis();
		assertEquals(0, l1.indexOf(1));
		finish = System.currentTimeMillis();
		diff1 = finish - start;
		start = System.currentTimeMillis();
		assertEquals(0, l2.indexOf(1));
		finish = System.currentTimeMillis();
		diff2 = finish - start;
		assertFalse("IndexOf: " + diff1 + " --> " + diff2, diff2 > diff1 * 3 && diff2 - diff1 > 100);
		
		start = System.currentTimeMillis();
		assertEquals(SMALL-1, l1.indexOf(SMALL));
		finish = System.currentTimeMillis();
		diff1 = finish - start;
		start = System.currentTimeMillis();
		assertEquals(LARGE-1, l2.indexOf(LARGE));
		finish = System.currentTimeMillis();
		diff2 = finish - start;
		assertFalse("IndexOf: " + diff1 + " --> " + diff2, diff2 > diff1 * 3 && diff2 - diff1 > 100);
	}
	
	@Test
	public void testSumEmpty05() {
		LinkedIntList l1 = new LinkedIntList();
		assertEquals(0, l1.sum());
		assertEquals("[]", l1.toString());
	}
	
	@Test
	public void testSumSingle05() {
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, -1);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 0);
		
		// l1 = [-1]
		// l2 = [0]
		
		assertEquals(-1, l1.sum());
		assertEquals("[-1]", l1.toString());
		assertEquals("[0]", l2.toString());
		assertEquals(0, l2.sum());
		assertEquals("[-1]", l1.toString());
		assertEquals("[0]", l2.toString());
		assertEquals(-1, l1.sum());
		assertEquals("[-1]", l1.toString());
		assertEquals("[0]", l2.toString());
	}
	
	@Test
	public void testSumSmall05() {
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 5);
		l1.add(1, 0);
		l1.add(2, -1);
		l1.add(3, 42);
		l1.add(4, 9);
		l1.add(5, -5);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 6);
		l2.add(1, 0);
		l2.add(2, 1);
		l2.add(3, 42);
		l2.add(4, 99);
		l2.add(5, 4);
		
		// l1 = [5, 0, -1, 42, 9, -5]
		// l2 = [6, 0, 1, 42, 99, 4]
		
		assertEquals(50, l1.sum());
		assertEquals("[5, 0, -1, 42, 9, -5]", l1.toString());
		assertEquals("[6, 0, 1, 42, 99, 4]", l2.toString());
		assertEquals(152, l2.sum());
		assertEquals("[5, 0, -1, 42, 9, -5]", l1.toString());
		assertEquals("[6, 0, 1, 42, 99, 4]", l2.toString());
		assertEquals(50, l1.sum());
		assertEquals("[5, 0, -1, 42, 9, -5]", l1.toString());
		assertEquals("[6, 0, 1, 42, 99, 4]", l2.toString());
	}
	
	@Test
	public void testSumLarge05() {
//		int[] data1 = {0, 1, -9, 2, -8, 3, -7, 4, -6, 5, -5, 6, -4, 7, -3, 8, -2, 9, -1};
//		int[] data2 = {100, -1, 200, -2, 300, -3, 400, -4, 500, -5, 600, 700, 800, -8, -7, -6};
//		LinkedIntList l1 = new LinkedIntList(data1);
//		LinkedIntList l2 = new LinkedIntList(data2);
		
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 0);
		l1.add(1, 1);
		l1.add(2, -9);
		l1.add(3, 2);
		l1.add(4, -8);
		l1.add(5, 3);
		l1.add(6, -7);
		l1.add(7, 4);
		l1.add(8, -6);
		l1.add(9, 5);
		l1.add(10, -5);
		l1.add(11, 6);
		l1.add(12, -4);
		l1.add(13, 7);
		l1.add(14, -3);
		l1.add(15, 8);
		l1.add(16, -2);
		l1.add(17, 9);
		l1.add(18, -1);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 100);
		l2.add(1, -1);
		l2.add(2, 200);
		l2.add(3, -2);
		l2.add(4, 300);
		l2.add(5, -3);
		l2.add(6, 400);
		l2.add(7, -4);
		l2.add(8, 500);
		l2.add(9, -5);
		l2.add(10, 600);
		l2.add(11, 700);
		l2.add(12, 800);
		l2.add(13, -8);
		l2.add(14, -7);
		l2.add(15, -6);
		
		// l1 = [0, 1, -9, 2, -8, 3, -7, 4, -6, 5, -5, 6, -4, 7, -3, 8, -2, 9, -1];
		// l2 = [100, -1, 200, -2, 300, -3, 400, -4, 500, -5, 600, 700, 800, -8, -7, -6];
		
		assertEquals(0, l1.sum());
		assertEquals("[0, 1, -9, 2, -8, 3, -7, 4, -6, 5, -5, 6, -4, 7, -3, 8, -2, 9, -1]", l1.toString());
		assertEquals("[100, -1, 200, -2, 300, -3, 400, -4, 500, -5, 600, 700, 800, -8, -7, -6]", l2.toString());
		assertEquals(3564, l2.sum());
		assertEquals("[0, 1, -9, 2, -8, 3, -7, 4, -6, 5, -5, 6, -4, 7, -3, 8, -2, 9, -1]", l1.toString());
		assertEquals("[100, -1, 200, -2, 300, -3, 400, -4, 500, -5, 600, 700, 800, -8, -7, -6]", l2.toString());
		assertEquals(0, l1.sum());
		assertEquals("[0, 1, -9, 2, -8, 3, -7, 4, -6, 5, -5, 6, -4, 7, -3, 8, -2, 9, -1]", l1.toString());
		assertEquals("[100, -1, 200, -2, 300, -3, 400, -4, 500, -5, 600, 700, 800, -8, -7, -6]", l2.toString());
	}
	
	@Test
	public void testSumTIMING() {
		long start, finish, diff1, diff2;
		final int SMALL = 20000;
		final int LARGE = 2 * SMALL;
		LinkedIntList l1 = new LinkedIntList();
		LinkedIntList l2 = new LinkedIntList();
		for(int i = SMALL; i > 0; i--) {
			l1.addFirst(i);
		}
		for(int i = LARGE; i > 0; i--) {
			l2.addFirst(i);
		}
		start = System.currentTimeMillis();
		assertEquals(SMALL*(SMALL+1)/2, l1.sum());
		finish = System.currentTimeMillis();
		diff1 = finish - start;
		start = System.currentTimeMillis();
		assertEquals(LARGE*(LARGE+1)/2, l2.sum());
		finish = System.currentTimeMillis();
		diff2 = finish - start;
		assertFalse("Sum: " + diff1 + " --> " + diff2, diff2 > diff1 * 3 && diff2 - diff1 > 100);
	}
	
	
	@Test
	public void testIncreasingEvensNone05() {
//		int[] a1 = {};
//		int[] a2 = {7};
//		int[] a3 = {21, 25, 5};
//		LinkedIntList l;
		LinkedIntList l1 = new LinkedIntList();
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 7);
		
		LinkedIntList l3 = new LinkedIntList();
		l3.add(0, 21);
		l3.add(1, 25);
		l3.add(2, 5);
		
		// l1 = []
		// l2 = [7]
		// l3 = [21, 25, 5]
		
		assertTrue(l1.increasingEvens());
		assertTrue(l2.increasingEvens());
		assertTrue(l3.increasingEvens());
	}
	
	@Test
	public void testIncreasingEvensSingle05() {
//		int[] a1 = {4};
//		int[] a2 = {47, 22};
//		int[] a3 = {22, 11};
//		int[] a4 = {97, 56, 41};
		
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0,  4);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 47);
		l2.add(0, 22);
		
		LinkedIntList l3 = new LinkedIntList();
		l3.add(0, 22);
		l3.add(1, 11);
		
		LinkedIntList l4 = new LinkedIntList();
		l4.add(0, 97);
		l4.add(1, 56);
		l4.add(2, 41);
		
		// l1 = [4]
		// l2 = [47, 22]
		// l3 = [22, 11]
		// l4 = [97, 56, 41]
		
		
		assertTrue(l1.increasingEvens());
		assertTrue(l2.increasingEvens());
		assertTrue(l3.increasingEvens());
		assertTrue(l4.increasingEvens());
	}
		
	
	@Test
	public void testIncreasingEvensSmall05() {
//		int[] a1 = {11, 44, 33, 22, 55};
//		int[] a2 = {33, 22, 11, 44, 55};
//		int[] a3 = {11, 33, 55, 22, 44};
//		int[] a4 = {22, 11, 33, 55, 44};
//		int[] a5 = {44, 55, 77, 88, 22};
		
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 11);
		l1.add(1, 44);
		l1.add(2, 33);
		l1.add(3, 22);
		l1.add(4, 55);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 33);
		l2.add(1, 22);
		l2.add(2, 11);
		l2.add(3, 44);
		l2.add(4, 55);
		
		LinkedIntList l3 = new LinkedIntList();
		l3.add(0, 11);
		l3.add(1, 33);
		l3.add(2, 55);
		l3.add(3, 22);
		l3.add(4, 44);
		
		LinkedIntList l4 = new LinkedIntList();
		l4.add(0, 22);
		l4.add(1, 11);
		l4.add(2, 33);
		l4.add(3, 55);
		l4.add(4, 44);
		
		LinkedIntList l5 = new LinkedIntList();
		l5.add(0, 44);
		l5.add(1, 55);
		l5.add(2, 77);
		l5.add(3, 88);
		l5.add(4, 22);
		
		// l1 = {11, 44, 33, 22, 55};
		// l2 = {33, 22, 11, 44, 55};
		// l3 = {11, 33, 55, 22, 44};
		// l4 = {22, 11, 33, 55, 44};
		// l5 = {44, 55, 77, 88, 22};
		
		
		assertFalse(l1.increasingEvens());
		assertTrue(l2.increasingEvens());
		assertTrue(l3.increasingEvens());
		assertTrue(l4.increasingEvens());
		assertFalse(l5.increasingEvens());
	}
	
	@Test
	public void testIncreasingEvensLarge05() {
		LinkedIntList l1 = new LinkedIntList();
		l1.add(0, 7);
		l1.add(1, 8);
		l1.add(2, 12);
		l1.add(3, 15);
		l1.add(4, 18);
		l1.add(5, 21);
		l1.add(6, 23);
		l1.add(7, 28);
		l1.add(8, 32);
		l1.add(9, 50);
		l1.add(10, 61);
		l1.add(11, 79);
		l1.add(12, 82);
		l1.add(13, 89);
		l1.add(14, 100);
		l1.add(15, 105);
		
		LinkedIntList l2 = new LinkedIntList();
		l2.add(0, 7);
		l2.add(1, 8);
		l2.add(2, 12);
		l2.add(3, 18);
		l2.add(4, 21);
		l2.add(5, 23);
		l2.add(6, 28);
		l2.add(7, 32);
		l2.add(8, 50);
		l2.add(9, 61);
		l2.add(10, 79);
		l2.add(11, 15);
		l2.add(12, 82);
		l2.add(13, 89);
		l2.add(14, 100);
		l2.add(15, 105);
		
		LinkedIntList l3 = new LinkedIntList();
		l3.add(0, 7);
		l3.add(1, 8);
		l3.add(2, 12);
		l3.add(3, 18);
		l3.add(4, 21);
		l3.add(5, 23);
		l3.add(6, 32);
		l3.add(7, 50);
		l3.add(8, 61);
		l3.add(9, 79);
		l3.add(10, 15);
		l3.add(11, 82);
		l3.add(12, 89);
		l3.add(13, 28);
		l3.add(14, 100);
		l3.add(15, 105);
		
		LinkedIntList l4 = new LinkedIntList();
		l4.add(0, 8);
		l4.add(1, 12);
		l4.add(2, 18);
		l4.add(3, 28);
		l4.add(4, 32);
		l4.add(5, 50);
		l4.add(6, 82);
		l4.add(7, 100);
		l4.add(8, 105);
		l4.add(9, 89);
		l4.add(10, 79);
		l4.add(11, 61);
		l4.add(12, 23);
		l4.add(13, 21);
		l4.add(14, 15);
		l4.add(15, 7);
		
		LinkedIntList l5 = new LinkedIntList();
		l5.add(0, 105);
		l5.add(1, 89);
		l5.add(2, 79);
		l5.add(3, 61);
		l5.add(4, 23);
		l5.add(5, 21);
		l5.add(6, 15);
		l5.add(7, 7);
		l5.add(8, 8);
		l5.add(9, 12);
		l5.add(10, 18);
		l5.add(11, 28);
		l5.add(12, 32);
		l5.add(13, 50);
		l5.add(14, 82);
		l5.add(15, 100);
		
		LinkedIntList l6 = new LinkedIntList();
		l6.add(0, 8);
		l6.add(1, 12);
		l6.add(2, 18);
		l6.add(3, 28);
		l6.add(4, 32);
		l6.add(5, 50);
		l6.add(6, 105);
		l6.add(7, 89);
		l6.add(8, 79);
		l6.add(9, 61);
		l6.add(10, 23);
		l6.add(11, 82);
		l6.add(12, 100);
		l6.add(13, 21);
		l6.add(14, 15);
		l6.add(15, 7);
		
		LinkedIntList l7 = new LinkedIntList();
		l7.add(0, 8);
		l7.add(1, 12);
		l7.add(2, 18);
		l7.add(3, 28);
		l7.add(4, 32);
		l7.add(5, 50);
		l7.add(6, 105);
		l7.add(7, 89);
		l7.add(8, 79);
		l7.add(9, 100);
		l7.add(10, 61);
		l7.add(11, 23);
		l7.add(12, 82);
		l7.add(13, 21);
		l7.add(14, 15);
		l7.add(15, 7);

		
		// l1 = {7, 8, 12, 15, 18, 21, 23, 28, 32, 50, 61, 79, 82, 89, 100, 105};
		// l2 = {7, 8, 12, 18, 21, 23, 28, 32, 50, 61, 79, 15, 82, 89, 100, 105};
		// l3 = {7, 8, 12, 18, 21, 23, 32, 50, 61, 79, 15, 82, 89, 28, 100, 105};
		// l4 = {8, 12, 18, 28, 32, 50, 82, 100, 105, 89, 79, 61, 23, 21, 15, 7};
		// l5 = {105, 89, 79, 61, 23, 21, 15, 7, 8, 12, 18, 28, 32, 50, 82, 100};
		// l6 = {8, 12, 18, 28, 32, 50, 105, 89, 79, 61, 23, 82, 100, 21, 15, 7};
		// l7 = {8, 12, 18, 28, 32, 50, 105, 89, 79, 100, 61, 23, 82, 21, 15, 7};
		assertTrue(l1.increasingEvens());
		assertTrue(l2.increasingEvens());
		assertFalse(l3.increasingEvens());
		assertTrue(l4.increasingEvens());
		assertTrue(l5.increasingEvens());
		assertTrue(l6.increasingEvens());
		assertFalse(l7.increasingEvens());
	}
	
	@Test
	public void testIncreasingEvensTIMING() {
		long start, finish, diff1, diff2;
		final int SMALL = 20000;
		final int LARGE = 2 * SMALL;
		LinkedIntList l1 = new LinkedIntList();
		LinkedIntList l2 = new LinkedIntList();
		for(int i = SMALL; i > 0; i--) {
			l1.addFirst(i);
		}
		for(int i = LARGE; i > 0; i--) {
			l2.addFirst(i);
		}
		start = System.currentTimeMillis();
		l1.increasingEvens();
		finish = System.currentTimeMillis();
		diff1 = finish - start;
		start = System.currentTimeMillis();
		l2.increasingEvens();
		finish = System.currentTimeMillis();
		diff2 = finish - start;
		assertFalse("Sum: " + diff1 + " --> " + diff2, diff2 > diff1 * 3 && diff2 - diff1 > 100);
	}
	
	@Test
	public void testListAdditionEmpty05() {
		LinkedIntList l1 = new LinkedIntList();
		LinkedIntList l2 = new LinkedIntList();
		LinkedIntList s = l1.listAddition(l2);
		assertEquals("[]", l1.toString());
		assertEquals("[]", l2.toString());
		assertEquals("[]", s.toString());
		s = l2.listAddition(l1);
		assertEquals("[]", l1.toString());
		assertEquals("[]", l2.toString());
		assertEquals("[]", s.toString());
	}
	
	@Test
	public void testListAdditionSmall05() {
		LinkedIntList l1_a = new LinkedIntList();
		l1_a.add(0, 43);
		LinkedIntList l1_b = new LinkedIntList();
		l1_b.add(0, -3);
		
		LinkedIntList l2_a = new LinkedIntList();
		l2_a.add(0, 2);
		l2_a.add(1, -34);
		LinkedIntList l2_b = new LinkedIntList();
		l2_b.add(0, -5);
		l2_b.add(1, 10);
		
		// l1_a = [43]
		// l1_b = [-3]
		// l2_a = [2, -34]
		// l2_b = [-5, 10]
		
		LinkedIntList s1_a = l1_a.listAddition(l1_b);
		LinkedIntList s1_b = l1_b.listAddition(l1_a);
		LinkedIntList s2_a = l2_a.listAddition(l2_b);
		LinkedIntList s2_b = l2_b.listAddition(l2_a);
		
		assertEquals("[43]", l1_a.toString());
		assertEquals("[-3]", l1_b.toString());
		assertEquals("[40]", s1_a.toString());
		assertEquals("[40]", s1_b.toString());
		assertFalse(s1_a == s1_b);
		
		assertEquals("[2, -34]", l2_a.toString());
		assertEquals("[-5, 10]", l2_b.toString());
		assertEquals("[-3, -24]", s2_a.toString());
		assertEquals("[-3, -24]", s2_b.toString());
		assertFalse(s2_a == s2_b);
	}
	
	@Test
	public void testListAdditionLarge05() {
		LinkedIntList l1_a = new LinkedIntList();
		l1_a.add(0, 1);
		l1_a.add(1, 3);
		l1_a.add(2, 5);
		l1_a.add(3, 7);
		l1_a.add(4, 9);
		l1_a.add(5, 11);
		l1_a.add(6, 13);
		l1_a.add(7, 15);
		l1_a.add(8, 17);
		l1_a.add(9, 19);
		l1_a.add(10, 21);
		l1_a.add(11, 23);
		
		LinkedIntList l1_b = new LinkedIntList();
		l1_b.add(0, 2);
		l1_b.add(1, 4);
		l1_b.add(2, 6);
		l1_b.add(3, 8);
		l1_b.add(4, 10);
		l1_b.add(5, 12);
		l1_b.add(6, 14);
		l1_b.add(7, 16);
		l1_b.add(8, 18);
		l1_b.add(9, 20);
		l1_b.add(10, 22);
		l1_b.add(11, 24);
		
		
		// l1_a = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23]
		// l1_b = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24]	
		LinkedIntList s1_a = l1_a.listAddition(l1_b);
		LinkedIntList s1_b = l1_b.listAddition(l1_a);
	
		assertEquals("[1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23]", l1_a.toString());
		assertEquals("[2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24]", l1_b.toString());
		assertEquals("[3, 7, 11, 15, 19, 23, 27, 31, 35, 39, 43, 47]", s1_a.toString());
		assertEquals("[3, 7, 11, 15, 19, 23, 27, 31, 35, 39, 43, 47]", s1_b.toString());
		assertFalse(s1_a == s1_b);
	}
	
	@Test
	public void testListAdditionException05() {
		LinkedIntList l1 = new LinkedIntList();
		LinkedIntList l2 = new LinkedIntList();
		LinkedIntList s;
		l1.addFirst(43);
		try {
			l1.listAddition(l2);
			fail("Should have thrown IllegalArgumentException");
		} catch(IllegalArgumentException e) {}
		try {
			l2.listAddition(l1);
			fail("Should have thrown IllegalArgumentException");
		} catch(IllegalArgumentException e) {}
		l2.addFirst(-3);
		s = l1.listAddition(l2);
		assertEquals("[40]", s.toString());
		l2.addFirst(10);
		try {
			l1.listAddition(l2);
			fail("Should have thrown IllegalArgumentException");
		} catch(IllegalArgumentException e) {}
		try {
			l2.listAddition(l1);
			fail("Should have thrown IllegalArgumentException");
		} catch(IllegalArgumentException e) {}
		l1.addFirst(40);
		s = l1.listAddition(l2);
		assertEquals("[50, 40]", s.toString());
		l1.addFirst(100);
		try {
			l1.listAddition(l2);
			fail("Should have thrown IllegalArgumentException");
		} catch(IllegalArgumentException e) {}
		try {
			l2.listAddition(l1);
			fail("Should have thrown IllegalArgumentException");
		} catch(IllegalArgumentException e) {}
		l2.addFirst(200);
		s = l1.listAddition(l2);
		assertEquals("[300, 50, 40]", s.toString());
	}
	
	@Test
	public void testListAdditionTIMING() {
		long start, finish, diff1, diff2;
		final int SMALL = 20000;
		final int LARGE = 2 * SMALL;
		LinkedIntList l1 = new LinkedIntList();
		LinkedIntList l2 = new LinkedIntList();
		for(int i = SMALL; i > 0; i--) {
			l1.addFirst(i);
		}
		for(int i = LARGE; i > 0; i--) {
			l2.addFirst(i);
		}
		start = System.currentTimeMillis();
		l1.listAddition(l1);
		finish = System.currentTimeMillis();
		diff1 = finish - start;
		start = System.currentTimeMillis();
		l2.listAddition(l2);
		finish = System.currentTimeMillis();
		diff2 = finish - start;
		assertFalse("Sum: " + diff1 + " --> " + diff2, diff2 > diff1 * 3 && diff2 - diff1 > 100);
	}
}
