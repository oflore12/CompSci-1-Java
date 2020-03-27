import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {
	private GradeBook gradebook1;
	private GradeBook gradebook2;

	@Before
	public void setUp() throws Exception {
		//create 2 objects of Gradebook of size 5
		gradebook1= new GradeBook(5);
		gradebook2= new GradeBook(5);
		
		//call for addScore method for each of the GradeBook Objects
		gradebook1.addScore(40.0);
		gradebook1.addScore(50.0);
		gradebook1.addScore(99.0);
		gradebook1.addScore(75.0);
		
		gradebook2.addScore(50.0);
		gradebook2.addScore(60.0);
		gradebook2.addScore(80.0);
		gradebook2.addScore(85.0);
		gradebook2.addScore(20.0);
		
	}

	@After
	public void tearDown() throws Exception {
		//set two objects of GradeBook to null
		gradebook1 = null;
		gradebook2 = null; 
	}

	@Test
	public void addScoreTest() {
		assertTrue((gradebook1.toString()).equals("40.0 50.0 99.0 75.0 "));
		assertTrue((gradebook2.toString()).equals("50.0 60.0 80.0 85.0 20.0 "));
		
		assertEquals(4,gradebook1.getScoreSize(),0.001);
		assertEquals(5,gradebook2.getScoreSize(),0.001);
	}
	
	@Test
	public void SumTest() {
		assertEquals(264.0, gradebook1.sum(),0.0001);
		assertEquals(295.0, gradebook2.sum(),0.0001);
	}
	
	@Test 
	public void MinimumTest() {
		assertEquals(40.0, gradebook1.minimum(),0.001);
		assertEquals(20.0, gradebook2.minimum(),0.001);
	}
	
	@Test
	public void FinalScoreTest() {
		assertEquals(224.0, gradebook1.finalScore(),0.001);
		assertEquals(275.0, gradebook2.finalScore(),0.001);
		
	}
}