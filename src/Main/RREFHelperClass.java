package Main;
/**
 * 
 */

/**
 * @author Sid
 *
 */
public class RREFHelperClass {
	
	final static double EPSILON = .00000000001;
	
	public static LinearMatrix swapRows(LinearMatrix x, int rowSelect, int rowDestination){
		
		double row1[] = new double [x.getNumCols()];
		double row2[] = new double[x.getNumCols()];
		
		for(int i = 0; i<x.getNumCols(); i++){
			row1[i]= x.get(rowSelect, i);
		}
		
		for(int i = 0; i<x.getNumCols(); i++){
			row2[i] = x.get(rowDestination, i);
		}
		
		//swap dem rows!
		for(int i = 0; i<x.getNumCols(); i++){
			x.set(rowDestination, i, row1[i]);
		}
		
		for(int i = 0; i<x.getNumCols(); i++){
			x.set(rowSelect, i, row2[i]);
		}
		
		
		
		
		
		
		return x;
		
		
		
	}
	
	public static int returnRowWithHighestNumber(LinearMatrix x, int col, int rowAt){
		
		rowAt++;
		double row1[] = new double [x.getNumCols()];
		
		for(int i = rowAt; i<x.getNumRows(); i++){
			row1[i]= x.get(i, col);
		}
		
		int maxRow = -1;
		double maxVal = -1;
		
		//find max
		for(int i =rowAt; i<row1.length;i++){
			
			if(row1[i]>maxVal){
				maxRow = i;
				maxVal= row1[i];
			}
			else{
				
			}
			
		}
		
		return maxRow;
		
	}

	public static LinearMatrix multiplyRowByValue(LinearMatrix x, int rowSelect, double valueMult){
		
		double row1[] = new double [x.getNumCols()];
		
		for(int i = 0; i<x.getNumCols(); i++){
			row1[i]= valueMult*x.get(rowSelect, i);
		}
		for(int i = 0; i<x.getNumCols(); i++){
			x.set(rowSelect, i, row1[i]);
		}
		
		return x;
		
	}
	
	
	public static LinearMatrix addRowToOtherRow(LinearMatrix x, int rowChose, int rowToAddToo){
		
		

		double row1[] = new double [x.getNumCols()];
		//double row2[] = new double[x.getNumCols()];
		
		for(int i = 0; i<x.getNumCols(); i++){
			row1[i]= x.get(rowChose, i);
		}
		
		for(int i = 0; i<x.getNumCols(); i++){
			x.set(rowToAddToo, i, x.get(rowToAddToo, i)+row1[i]);
		}
		
		
		
		return x;
	}
	
	public static boolean isZero(double value){
		
		if( EPSILON>=(value)){
			return true;
		}
		
		else{
			return false;
		}
	}
	
}
