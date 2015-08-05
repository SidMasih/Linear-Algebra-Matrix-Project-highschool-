package qrAlgorithm;

import java.util.ArrayList;

import Main.LinearMatrix;
import Main.TransposeMatrix;

public class ProjectionTester {

	

	public static void main(String[] args) {
		
		// two matrices that are 3d!
		LinearMatrix A = new LinearMatrix(3,1);
		LinearMatrix B = new LinearMatrix(3,1);

		B.fillMatrixWithValue(3);
		
		A.set(0, 0, 9);
		A.set(1, 0, 5);
		A.set(2, 0, 8);
		
		//find proj of A onto B
		
		GetProjectionAndMag projector = new GetProjectionAndMag();
		//System.out.print(projector.getDotProduct(A, B));
		
		
		
		
		System.out.println("Vect A: "); 
		TransposeMatrix.getTransposeMatrix(A).printMatrix();
		
		System.out.println("\nVect B: "); 
		TransposeMatrix.getTransposeMatrix(B).printMatrix();
		
		LinearMatrix C = projector.getProjection(A, B);
		System.out.println("\nProjection of A onto B:");
		
		TransposeMatrix.getTransposeMatrix(C).printMatrix();
		
		System.out.println(); 
		System.out.println(); 
		System.out.println(); 
		
		LinearMatrix Alpha = new LinearMatrix(2,1);
		LinearMatrix Beta = new LinearMatrix(2,1);
		
		
		Alpha.set(0, 0, 1);
		Alpha.set(1,0,3);
		//Alpha.set(2, 0, 5);
		Beta.set(0, 0, 3);
		Beta.set(1,0,1);
	//	Beta.set(2, 0, 4);
		
		
		ArrayList<LinearMatrix> AList = new ArrayList<LinearMatrix>();
		
		AList.add(Alpha);
		AList.add(Beta); 
		
		
		GenerateEMatrixes EMaker= new GenerateEMatrixes();
		ArrayList<LinearMatrix> EList = new ArrayList<LinearMatrix>();
		
		EList = EMaker.GenerateEMatrices(AList);
		System.out.println("\n\nreturned stuff ");
		
		EigenValueGenerator Test= new EigenValueGenerator(A);
		
		LinearMatrix BigDoolee = Test.findR(AList, EList);
		
		BigDoolee.printMatrix();
		/*for( int i = 0; i < MatList.size();i++){
			
			MatList.get(i).printMatrix();
			System.out.println(); 
			*/
		} 
		
	}


