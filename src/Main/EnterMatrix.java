package Main;

/**
 * @author Sid
 * creates new matrix object with user entered values
 */

import java.util.Scanner;

public class EnterMatrix {
	
	public static LinearMatrix createMatrix(){
		Scanner input = new Scanner(System.in);
		
		System.out.println(" please enter in the row size of the matrix you want");
		
		int matRowSize = 0;
		
		matRowSize = input.nextInt();
		
		System.out.println(" please enter in the col size of the matrix you want");
		
		int matColSize = 0;
		matColSize = input.nextInt();
		
		LinearMatrix returnMatrix = new LinearMatrix(matRowSize, matColSize);
		
		System.out.println("prepare to enter in matrix values \n");
		
		for(int r = 0; r<returnMatrix.getNumRows();r++){
			for( int c = 0; c<returnMatrix.getNumCols(); c++){
				System.out.println("next num for (" + (1+r) + "," + (1+c)+ "): ");
				int choice = input.nextInt();
				
				returnMatrix.set(r,c, choice);
				
				
				
			}
		}//end D-Floop
		
		
		return returnMatrix;
		
	}

}
