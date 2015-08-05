package OSLRPack;
import java.util.ArrayList;

import Main.LinearMatrix;
import Main.MatrixInverse;
import Main.MultiplyMatrix;
import Main.TransposeMatrix;

public class OSLR {

	// 1 array  of crap the user wants
	//1 array  of oslrValueGenerators
	//array of x and y values 
	// value generator for array
	// create M and T and do the magic 
	
	//return string of the equation 
	
	private LinearMatrix M;
	private LinearMatrix Mtransposed;
	private LinearMatrix MTranM;
	private LinearMatrix MTranMInverse;
	private LinearMatrix Y; 
	//(MT*M)^-1*MT*Y= A- col as long as numb terms in fitted function 
	
	
	/**
	 * 
	 * @param ValGen - ArrayList of desired functions
	 * @param X- X coordinates in LinearMatrix Form  
	 * @param Y - Y cordinates in LinearMatrix Form
	 * @return "A" LinearMatrix decending in order chosen by user  
	 */
	public LinearMatrix findOSLR(ArrayList<OSLRValueGenHolder> ValGen, LinearMatrix X, LinearMatrix Y){
		this.Y=Y;
		int Ydem= ValGen.size()+1;
		this.M = new LinearMatrix(X.getNumRows(),Ydem);
		
		OSLRValueGenerator YGenerator = new OSLRValueGenerator(ValGen);
		
		for(int i =0; i<this.M.getNumRows();i++){
			
			double[] x = YGenerator.getRowOfM(X.get(i, 0));
			
			for(int k=0; k<this.M.getNumCols();k++){
				
				this.M.set(i, k, x[k]);
				
			}
			
		}//end outer for loop
		
		this.Mtransposed = this.M;
		
		this.Mtransposed = TransposeMatrix.getTransposeMatrix(this.Mtransposed);
		
		this.MTranM=MultiplyMatrix.getMultipliedMatrix(this.Mtransposed, this.M);
		
		this.MTranMInverse = MatrixInverse.makeInverse(this.MTranM);
		
		LinearMatrix Holder = MultiplyMatrix.getMultipliedMatrix(MTranMInverse, Mtransposed);
		
		LinearMatrix CoeffFinalized = MultiplyMatrix.getMultipliedMatrix(Holder, this.Y);
		
		return CoeffFinalized;
		
	}
	
	
}
