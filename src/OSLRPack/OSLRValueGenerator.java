package OSLRPack;

import java.util.ArrayList;

public class OSLRValueGenerator {
	private ArrayList<OSLRValueGenHolder> valuegens;
	
	public OSLRValueGenerator(ArrayList<OSLRValueGenHolder> Valgen){
		this.valuegens=Valgen;
	}
	
	/**
	 * 
	 * @param x coordinate
	 * @return full row of MValues in array form-- must manually fill in M Matrix in OSLR
	 */
	public double[] getRowOfM (double x){
		double[] retVals = new double [valuegens.size()+1];
		retVals[0] = 1;
		
		for(int i=1; i<=valuegens.size();i++){
			int tempI = i-1;
			retVals[i]=valuegens.get(tempI).getValue(x);
		}
		
		return retVals;
	}

}
