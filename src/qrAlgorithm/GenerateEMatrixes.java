package qrAlgorithm;
import java.util.ArrayList;

import Main.*;

/**
 * GramSchmidt a matrix; each E matrix is a col of the orthangonailzed matrix
 * @author Sid
 *
 */
public class GenerateEMatrixes {

	private ArrayList<LinearMatrix> AMatrixList;
	private ArrayList<LinearMatrix> EMatrixList;
	private ArrayList<LinearMatrix> UMatrixList;
	
		
	public ArrayList<LinearMatrix> GenerateEMatrices(ArrayList<LinearMatrix> AMatrixList){
		
		this.AMatrixList = AMatrixList;
		
		EMatrixList = new ArrayList<LinearMatrix>();
		UMatrixList = new ArrayList<LinearMatrix>();
		GetProjectionAndMag ProjMagHelper = new GetProjectionAndMag();
		
		//first arbitrary U
		LinearMatrix firstone = this.AMatrixList.get(0);
		UMatrixList.add(firstone);
		
		
		
		//cycles all A Vects
		for(int a = 1; a<this.AMatrixList.size();a++){
			
			LinearMatrix newUMat = this.AMatrixList.get(a);
			LinearMatrix newUMatConstant = newUMat;
			
			
			//gram schmidt 
			for(int u =0 ; u< UMatrixList.size(); u++ ){
				
				
				LinearMatrix tempU = UMatrixList.get(u);
				
				
				
				newUMat = AddMatrix.getSubtractedMatrix(newUMat, ProjMagHelper.getProjection(newUMatConstant, tempU));
				
				
				
				
			}
			
			UMatrixList.add(newUMat);
		
		}// end Gram Schmidt
		
		//normalize all vectors
		for(int i = 0; i< UMatrixList.size(); i++){
			
			LinearMatrix A = UMatrixList.get(i);
			
			EMatrixList.add(A);
			
			EMatrixList.set(i, ProjMagHelper.NormalizeMat(EMatrixList.get(i)));
			
		}
		
		
		
		return EMatrixList;
		
	}
	


}
