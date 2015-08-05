package qrAlgorithm;
import java.util.ArrayList;

import Main.*;

public class EigenValueGenerator {

	
	LinearMatrix UserInput;
	ArrayList<LinearMatrix> ElementryMatrixes;
	ArrayList<LinearMatrix> AMatrixes;
	
	
	public EigenValueGenerator(LinearMatrix UC) {
		this.UserInput = UC;
	}
	
	public void FindEigen(){
		
		LinearMatrix Q;
		LinearMatrix R; 
		LinearMatrix RQ; 
		
		ArrayList<LinearMatrix> EList;
		ArrayList<LinearMatrix> AList;
		
		GenerateEMatrixes EMatGen = new GenerateEMatrixes();
		
		//here begins the QR
		
		AList = MatrixSplitterAndSealer.splitMatrix(this.UserInput);
		EList = EMatGen.GenerateEMatrices(AList);
		
		Q = MatrixSplitterAndSealer.WeaveMatrix(EList);
		R= findR(AList, EList);
		
		RQ = MultiplyMatrix.getMultipliedMatrix(R, Q);
		
		for(int i = 0; i<20; i++){
			
			AList = MatrixSplitterAndSealer.splitMatrix(RQ);
			EList = EMatGen.GenerateEMatrices(AList);
			
			Q = MatrixSplitterAndSealer.WeaveMatrix(EList);
			R= findR(AList, EList);
			
			RQ = MultiplyMatrix.getMultipliedMatrix(R, Q);
			
		}
		
		System.out.println("\n\n your EigenVals are:\n");
		int j = 0; 
		for(int i = 0; i< RQ.getNumRows();i++){
			double num = RQ.get(i, j);
			num = (double)Math.round(num * 10000) / 10000;
			System.out.println(num);
			j++;
		}
		System.out.println();
		
	}
	
	public LinearMatrix findQ(ArrayList<LinearMatrix> E){
		return MatrixSplitterAndSealer.WeaveMatrix(E);
	}

	
	public LinearMatrix findR(ArrayList<LinearMatrix> A, ArrayList<LinearMatrix> E){
		GetProjectionAndMag dotProd = new  GetProjectionAndMag(); 
		LinearMatrix R = new LinearMatrix(A.size(),A.size());
		

		int Limitter = A.size();
		int ACounter = 0;

		
		while(Limitter>0){
			
			for(int i = ACounter; i< A.size(); i++){
				
				double val = dotProd.getDotProduct(A.get(i), E.get(ACounter));
				
				R.set(ACounter, i ,val );
			}
			Limitter--;
			ACounter++;
		}
		
		return R;
		
	}
}
