/*
 * Find minimum speed with which a dog can run and swim to fetch the ball 
 * in the problem below, along with the distance the dog should run along 
 * the beach (AB) before jumping in the water.
*/

public class Function2 extends Function {

	@Override
	public double fnValue(double x) {
		if (x==0.0) 
			return Double.MAX_VALUE;
		else 
			return (x/3) + (2 * (Math.sqrt( (Math.pow(x,2)) - (8*x) + 25)));
	}
	
	public String toString() {
		return "Find the minimum speed with which a dog can run and swim to fetch the ball";
	}
	//, answerString, getXVal, getYVal, and getZVal
	public String answerString(double optVal, double x, double y, double z) {
		String stg = "Minimum time for the dog to reach his destination is "
				+ String.format("%.2f",optVal) +" seconds, and it occurs at "
				+String.format("%.2f",x )+" meters.";
		return stg;
	}
	
	public double getXVal(double x) {
		return x;
	}
	
	public double getYVal(double x) {
		return x;
	}
	
	public double getZVal(double x) {
		return -1.0;
	}
}
