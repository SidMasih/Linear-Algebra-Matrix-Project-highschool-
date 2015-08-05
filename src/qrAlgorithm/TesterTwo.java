package qrAlgorithm;

import java.util.ArrayList;

import Main.LinearMatrix;
import Main.TransposeMatrix;

public class TesterTwo {

	

	public static void main(String[] args) {
		
		
		
		LinearMatrix Alpha = new LinearMatrix(3,1);
		LinearMatrix Beta = new LinearMatrix(3,1);
		LinearMatrix Gamma = new LinearMatrix(3,1);
		
		Alpha.set(0, 0, 1);
		Alpha.set(1,0,3);
		Alpha.set(2, 0, 5);
		Beta.set(0, 0, 3);
		Beta.set(1,0,1);
		Beta.set(2, 0, 4);
		Gamma.set(0, 0, 2);
		Gamma.set(1,0,3);
		Gamma.set(2, 0, 1);
		
		
		ArrayList<LinearMatrix> MatList = new ArrayList<LinearMatrix>();
		ArrayList<LinearMatrix> MatListDos = new ArrayList<LinearMatrix>();
		
		MatList.add(Alpha);
		MatList.add(Beta); 
		MatList.add(Gamma);
		
		LinearMatrix Doolee = MatrixSplitterAndSealer.WeaveMatrix(MatList);
		System.out.println("Coskesh Matrix: ");
		Doolee.printMatrix();
		
		
		System.out.println("\n\nreturned stuff\n\n\n ");
		
		MatListDos = MatrixSplitterAndSealer.splitMatrix(Doolee);
		
		for( int i = 0; i < MatListDos.size();i++){
			
			MatListDos.get(i).printMatrix();
			System.out.println(); 
			
		} 
		
	}

}
