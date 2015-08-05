package qrAlgorithm;

import java.util.ArrayList;

import Main.LinearMatrix;

public class MatrixSplitterAndSealer {

	public static ArrayList<LinearMatrix> splitMatrix(LinearMatrix X){
		
		ArrayList<LinearMatrix> ColList = new ArrayList<LinearMatrix>();
		
		for(int i = 0; i<X.getNumCols();i++){
			
			LinearMatrix newCol = new LinearMatrix(X.getNumRows(),1);
			
			for(int j = 0; j< X.getNumRows(); j++){
				newCol.set(j, 0, X.get(j, i));
			}
			
			ColList.add(newCol);
			
		}
		
		return ColList;
		
	}
	
	public static LinearMatrix WeaveMatrix(ArrayList<LinearMatrix> List){
		
		LinearMatrix A = new LinearMatrix(List.get(0).getNumRows(), List.size());
		
		for(int i = 0; i<List.size();i++){
			
			
			
			for(int j = 0; j< List.get(0).getNumRows(); j++){
				A.set(j, i, List.get(i).get(j, 0));
			}
			
			
			
		}
		
		return A;
	}

}
