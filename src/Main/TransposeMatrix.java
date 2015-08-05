package Main;
/**
 * transpose matrix
 * @author Sid
 *
 */
public class TransposeMatrix {
	
	public static LinearMatrix getTransposeMatrix(LinearMatrix A){
		
		LinearMatrix Tran = new LinearMatrix(A.getNumCols(),A.getNumRows());
		
		for(int r = 0; r<A.getNumRows();r++){
			for( int c = 0; c<A.getNumCols(); c++){
				Tran.set(c, r, A.get(r, c));
			}
		}//end D-Floop
		
		
		return Tran;
		
		
	}

}
