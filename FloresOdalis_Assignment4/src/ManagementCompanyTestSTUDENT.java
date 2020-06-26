

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property prop1, prop2, prop3, prop4, prop5,prop6;
	ManagementCompany mgmtCo; 
	@Before
	public void setUp() throws Exception {
		//student create a management company
		
		//student add three properties, with plots, to mgmt co
		prop1 = new Property ("Great Properties", "Wheaton", 2500.00, "Melissa Guerrero",2,1,2,2);
		prop2 = new Property ("Hidden Creek", "Gaithersburg", 5000, "Jocelyn Flores",4,1,2,2);
		prop3 = new Property ("Rothsbury", "Germantown", 1600.00, "Valentin Flores",6,1,2,2);
		
		mgmtCo= new ManagementCompany("Odalis", "14934565", 5);
	 
		mgmtCo.addProperty(prop1);
		mgmtCo.addProperty(prop2);
		mgmtCo.addProperty(prop3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		mgmtCo=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//fail("STUDENT test not implemented yet");
		//student should add property with 4 args & default plot (0,0,1,1)
		prop4= new Property("4ArgProp", "Rockville", 3000.00, "Banessa Flores");
		//student should add property with 8 args
		prop5= new Property("8ArgProp", "Olney", 4250.00, "Haley & Kevin", 2,4,5,6);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		prop6 = new Property("too Many Props", "Silver Spring", 1500, "Shouldn't Exist", 6,5,4,3);
		
		assertEquals(mgmtCo.addProperty(prop4),3,0);
		assertEquals(mgmtCo.addProperty(prop5),4,0);
		assertEquals(mgmtCo.addProperty(prop6),-1,0);  //exceeds the size of the array and can not be 
	}
 
	@Test
	public void testMaxRentProp() {
		//fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		String maxRentString = mgmtCo.maxRentProp().split("\n")[3];
		assertTrue(maxRentString.contains("5000.0"));
	}

	@Test
	public void testTotalRent() {
		//fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(mgmtCo.totalRent(),9100.0,0);
	}

 }
