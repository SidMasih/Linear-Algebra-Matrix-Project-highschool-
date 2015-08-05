package qrAlgorithm;

import Main.LinearMatrix;

//ignore the above

// Sid, Jerod, Kyle, Venus, Rubia (built by Sid)

/* this class/function finds the dot product 
 * for demonstrations please contact me (I will be happy to show this to you!)
 * part of the QR algorithm
 * very similar to c++ syntax
 * separate driver class (which demos the function/class but is not shown)
 * thanks for a great year! Linear Algebra has made clear my path in CS :)
 * Will find projections to the nth degree vector
 */

//ignore the headers for declaring the method! they are not essential to logic of the function
public class GetProjectionAndMag {

	
	// returns dot product
	public double getDotProduct(LinearMatrix A, LinearMatrix B){
		
		//default dot product value
		double dotproduct = 0;
		
		//multiply each vector component of A and B
		for( int i = 0; i<A.getNumRows();i++){
		dotproduct = dotproduct + A.get(i, 0)*B.get(i, 0);
		}
		
		//return dot product 
		return dotproduct;
	}
	
	/**
	 * Generate projection of A onto B (the blue is all comments!) 
	 * @param A (LinearMatrix)
	 * @param B (LinearMatrix)
	 * @return projection of A onto B
	 */
	public LinearMatrix getProjection(LinearMatrix A, LinearMatrix B){
		
		LinearMatrix C = new LinearMatrix(B.getNumRows(), B.getNumCols());
		
		//DotProduct in method above (pulled out to make method cleaner)
		double multiplicationFactor = (getDotProduct(A,B))/(getDotProduct(B,B));
		
		
		//multiply each component of the vector by the scalar generated above 
		for(int i = 0; i<A.getNumRows(); i++){
			C.set(i, 0, multiplicationFactor*B.get(i, 0));
		}
		
		//return matrix
		return C;
		
	}
	
	public double getMagnitude(LinearMatrix A){
		double mag= 0;
		
		for( int i = 0; i<A.getNumRows();i++){
			mag = mag + A.get(i, 0)*A.get(i, 0);
			}
		
		mag = Math.sqrt(mag);
		
		return mag;
		
	}
	
	public LinearMatrix NormalizeMat(LinearMatrix A){
		
		LinearMatrix C = new LinearMatrix(A.getNumRows(), A.getNumCols());
		
		for(int i = 0; i<A.getNumRows(); i++){
			
			double mag = getMagnitude(A);
			double multiplicationFactor = 1/ mag;
			
			
			C.set(i, 0, multiplicationFactor*A.get(i, 0));
		}
		
		return C;
	}
}
