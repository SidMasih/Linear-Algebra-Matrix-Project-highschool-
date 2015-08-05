package Main;

public class RREF {
	
	public static LinearMatrix makeRREF(LinearMatrix matrix ){
		
		Boolean ErrorCheck = false;
		int numRows = matrix.getNumRows();
		int numCols = matrix.getNumCols();
		int rowChange = 0;
		
		
		
		
		//swap if deviding by 0
		if(RREFHelperClass.isZero(matrix.get(0, 0))){
			int rowTo = RREFHelperClass.returnRowWithHighestNumber(matrix, 0, 0);
			RREFHelperClass.swapRows(matrix, 0, rowTo);
		}
		else{}
		double firstOne = matrix.get(0, 0);
		firstOne = 1.0/firstOne;
		//matrix.printMatrix();
		//System.out.println();
		
		RREFHelperClass.multiplyRowByValue(matrix, rowChange, firstOne);
		do{
			for(int c= 0; c<numCols; c++){
				//matrix.printMatrix();
				System.out.println();
				
					for(int i = rowChange+1; i<numRows; i++){
				
						
						double delta = -1*matrix.get(i, c);
						if(delta == -0.0){
							continue;
						}
						double deltaBack = 1/delta;
					//	System.out.println("delta 1: " + delta);
						RREFHelperClass.multiplyRowByValue(matrix, rowChange, delta);
						RREFHelperClass.addRowToOtherRow(matrix, rowChange, i);
						RREFHelperClass.multiplyRowByValue(matrix, rowChange, deltaBack);
				
					}
				
					if(rowChange>=numRows){
						break;
					}
					else{
					double rev = matrix.get(rowChange, c);
					
					rev = 1.0/rev;
				
				RREFHelperClass.multiplyRowByValue(matrix, rowChange, rev);
				
					for(int i = rowChange-1; i>=0; i--){
					
						double delta = -1*matrix.get(i, c);
						if(delta == -0.0){
							continue;
						}
						double deltaBack = 1/delta;
					//	System.out.println("delta 2: " + delta);
						RREFHelperClass.multiplyRowByValue(matrix, rowChange, delta);
						RREFHelperClass.addRowToOtherRow(matrix, rowChange, i);
						RREFHelperClass.multiplyRowByValue(matrix, rowChange, deltaBack);
						
				
					}
				//next row
				rowChange++;
				int colChange = c;
				colChange++;
				
				if(rowChange < numRows && colChange <numCols && matrix.get(rowChange, colChange)==0){
					int rowTo = RREFHelperClass.returnRowWithHighestNumber(matrix, rowChange, colChange);
					
					if(rowTo !=-1){
						RREFHelperClass.swapRows(matrix, rowChange, rowTo);
					}
					else{}
				}
				else{}
				
				//make next row simple
				if(colChange <numCols && rowChange < numRows){
					//System.out.println(rowChange + " " + colChange);
					double nextOne = matrix.get(rowChange, colChange);
					nextOne = 1/nextOne;
					RREFHelperClass.multiplyRowByValue(matrix, rowChange, nextOne);
				}
			}
			}
			
			
			
			
		}
		while(ErrorCheck);
		
		return matrix;
		
	}

}


