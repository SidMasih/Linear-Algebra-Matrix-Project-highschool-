package OSLRPack;

public class PolonomialForOSLR extends OSLRValueGenHolder{
	
	private int degree;
	
	/**
	 * 
	 * @param degree>=1
	 */
	public PolonomialForOSLR(int degree){
		this.degree = degree;
	}
	
	public double getValue(double value){
		
		double newVal = value;
		
		for( int i =1; i< this.degree; i++){
			newVal = newVal*value;
		}
		
		return newVal;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Function for polonomial with degree: " + this.degree;
	}

}
