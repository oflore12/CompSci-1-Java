




public class Function3 extends Function {

	@Override
	//returns the distance from P and Q
	public double fnValue(double x) {
		if (x==0.0) 
			return Double.MAX_VALUE;
		else 
		return Math.sqrt( (Math.pow(x, 4)) - (Math.pow(x,2)) +1 );
	}
	
	public String toString () {
		return "Find the minimum distance between the function f(x)=x^2 and the point (0,1)\n"
				+"This distance is descrives by the function d(x)=sqrt(x^4-x^2+1)";
	}
	
	public String answerString(double optVal, double x, double y, double z) {
		String stg= 
				"The minimum distance is " 
				+String.format("%.2f", optVal)
						+ " at the point ("
				+String.format("%.2f",x) +", "
				+String.format("%.2f",Math.pow(x, 2)) +") and ("
				+String.format("%.2f", (-x))+", " 
				+String.format("%.2f", Math.pow(x, 2)) +")";
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
