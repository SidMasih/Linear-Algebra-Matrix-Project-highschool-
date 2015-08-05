package Main;

public class MatrixInverse {
	
	
	public static LinearMatrix augMat(LinearMatrix x){
		 int numCols = x.getNumCols();
		
		int newNumCols = numCols*2;
		x.resizeMatrix(x.getNumRows(), newNumCols);
		
		int c = numCols;
		
		for (int r = 0; r<x.getNumRows(); r++){
			x.set(r, c, 1);
			c++;
		}
		
		return x;
		
	}
	public static LinearMatrix deAugMat(LinearMatrix x){
		
		int numCols = x.getNumCols()/2;
		
		LinearMatrix fin = new LinearMatrix(x.getNumRows(), numCols);
		
		
		for (int r = 0; r<x.getNumRows(); r++){
			for (int c = 0; c< numCols; c++){
				fin.set(r, c, x.get(r, c+numCols));
			}
		}
		
		return fin;
		
	}
	public static LinearMatrix makeInverse( LinearMatrix x) {
		
		 x = augMat(x);
		 
		 
		x =  RREF.makeRREF(x);
		return deAugMat(x);
		
	}
	
	
}
