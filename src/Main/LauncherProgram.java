package Main;
import java.util.ArrayList;
import java.util.Scanner;

import qrAlgorithm.EigenValueGenerator;
import OSLRPack.OLSRInterface;
public class LauncherProgram {


	public static void main(String[] args) {
	
		
		ArrayList<LinearMatrix> MatrixList = new ArrayList();
		Scanner input = new Scanner(System.in);
		
		//add blank LinMats to the "lazy susan"
		for( int count = 0; count<6; count ++){
			MatrixList.add(new LinearMatrix());
		}

		int userWantsToDo = 1000;
		
		while(userWantsToDo != 99){
			
			//take user input
			System.out.println("Type 1 to enter in a matrix, 2 to see the entered matrix, 3 to add two matrices, 4 to multiply matrices, 5 to transpose a matrix, 6 to put matrix in RREF,7 to take inverse 8 to open the Best Fit Interface, 9 for the QR-Eigenvalue function, 10 to see the Matrix Reloaded, or 99 to quit");
			userWantsToDo = input.nextInt();	
			
			
			switch(userWantsToDo){
				case 1:{
					int whichMat = 1000;
					
					while(whichMat != 99){
					
						System.out.println("\n please enter which matrix you would like to enter 1-6 or 99 to quit");
					
						whichMat = input.nextInt();
					
						switch(whichMat){
							case 1: {
								//add matrix here
								MatrixList.set(0, EnterMatrix.createMatrix());
								continue;
							}
						
							case 2:{
								MatrixList.set(1, EnterMatrix.createMatrix());
								continue;
							}
						
							case 3:{
								MatrixList.set(2, EnterMatrix.createMatrix());
								continue;
							}
						
							case 4: {
								MatrixList.set(3, EnterMatrix.createMatrix());
								continue;
							}
							case 5:{
								MatrixList.set(4, EnterMatrix.createMatrix());
								continue;
							}
							case 6:{
								MatrixList.set(5, EnterMatrix.createMatrix());
								continue;
							}
							case 99:{
								System.out.println("exiting sub-menu\n");
							}
							default: {
								System.out.println("looks like you put in an invalid response! try again please\n");
							}
						}//end MatAddSwitch
					
					}//end loop
					continue;
				}//end case 1
				case 2:{
					int UC= 1;
					System.out.println("what matrix would you like to see (1-6)");
					UC = input.nextInt();
					MatrixList.get(UC-1).printMatrix();
					System.out.println();
					continue;
					
				}
				case 3:{
					
					System.out.println("first matrix to add?");
					int UC = input.nextInt();
					System.out.println("next matrix to add?");
					int UC2 = input.nextInt();
					AddMatrix.getAddedMatrix(MatrixList.get(UC-1), MatrixList.get(UC2-1)).printMatrix();
					continue;
					
				}
				case 4:{

					System.out.println("first matrix to multiply? (first*seccond form)");
					int UC = input.nextInt();
					System.out.println("next matrix to multiply?(first*seccond form)");
					int UC2 = input.nextInt();
					MultiplyMatrix.getMultipliedMatrix(MatrixList.get(UC-1), MatrixList.get(UC2-1)).printMatrix();
					continue;
				}
				case 5:{
					System.out.println("which matrix would you liked transposed?");
					int UC = input.nextInt();
					TransposeMatrix.getTransposeMatrix(MatrixList.get(UC-1)).printMatrix();
					continue;
				}
				case 6:{
					System.out.println("which matrix would you liked RREFed?");
					int UC = input.nextInt();
					RREF.makeRREF(MatrixList.get(UC-1)).printMatrix();
					//MatrixList.get(0).printMatrix();
					continue;
					
					
				}
				case 7:{
					System.out.println("which matrix would you liked inversed?");
					int UC = input.nextInt();
					MatrixList.set(0, MatrixInverse.makeInverse(MatrixList.get(UC-1))).printMatrix();
					//MatrixList.get(0).printMatrix();
					continue;
				}
				case 8:{
					System.out.println("\n\n\n\n\n\n");
					OLSRInterface.runOLSRInterface();
					System.out.println("\n\n\n\n\nOSLR has been quit\n\n\n\n\n");
					continue; 
				}
				
				case 9:{
					System.out.println("which matrix would you liked QRed?");
					int UC = input.nextInt();
					EigenValueGenerator EGen = new EigenValueGenerator(MatrixList.get(UC-1));
					EGen.FindEigen();
					
					//MatrixList.get(0).printMatrix();
					continue;
				}
			}
			
		}
		System.out.println("\n\n\n bye!");
	}

}
