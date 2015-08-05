package Main;
/**
 * multiplies matrix
 * A*B format
 * @author Sid
 *
 */
public class MultiplyMatrix {
	
	public static LinearMatrix getMultipliedMatrix(LinearMatrix A, LinearMatrix B){
		
		LinearMatrix C = new LinearMatrix(A.getNumRows(),B.getNumCols());
		
		if(A.getNumCols() == B.getNumRows()){
			
			for(int r = 0; r<A.getNumRows();r++){
				for( int c = 0; c<B.getNumCols(); c++){
					
					// mult
					for(int k=0; k<A.getNumCols(); k++){
						C.set(r, c, (C.get(r, c)+(A.get(r, k)*B.get(k, c))));
					}
					
				}
			}//end D-Floop
			
			return C;
			
		}
		
		else{
			System.out.println("Dimensions do not match, try again, a matrix of 0s will be returned instead");
			return C;
		}
		
	}

}
