package Main;
/**
 * adds matrix
 * dimensions must match!
 * @author Sid
 *
 */
public class AddMatrix {
	
	public static LinearMatrix getAddedMatrix(LinearMatrix A, LinearMatrix B){
		
		LinearMatrix C = new LinearMatrix();
		
		if(A.getNumRows() == B.getNumRows() && A.getNumCols() == B.getNumCols()){
			
			C.setMatrix(A.getNumRows(), B.getNumCols());
			
			for(int r = 0; r<A.getNumRows();r++){
				for( int c = 0; c<A.getNumCols(); c++){
					C.set(r, c, (A.get(r, c)+ B.get(r,c)));
				}
			}//end D-Floop
			
			return C;
		}
		else{
			System.out.println("Dimension Error, try again, blank matrix returning");
			return C;
		}
		
	}
	
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return A-B
	 */
	public static LinearMatrix getSubtractedMatrix(LinearMatrix A, LinearMatrix B){
		
		
		LinearMatrix C = new LinearMatrix();
		
		if(A.getNumRows() == B.getNumRows() && A.getNumCols() == B.getNumCols()){
			
			C.setMatrix(A.getNumRows(), B.getNumCols());
			
			for(int r = 0; r<A.getNumRows();r++){
				for( int c = 0; c<A.getNumCols(); c++){
					C.set(r, c, (A.get(r, c)- B.get(r,c)));
				}
			}//end D-Floop
			
			return C;
		}
		else{
			System.out.println("Dimension Error, try again, blank matrix returning");
			return C;
		}
		
	}

}
