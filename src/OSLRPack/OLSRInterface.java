package OSLRPack;

import java.util.ArrayList;
import java.util.Scanner;

import Main.LinearMatrix;

public class OLSRInterface {

	public static void runOLSRInterface(){
		
	
		
		ArrayList<OSLRValueGenHolder> ValGen = new ArrayList<OSLRValueGenHolder>();
		
		System.out.println("Welcome to OLSR! This interface will prompt you to create your best fit equation for any polonomial or trig function\n");
		System.out.println("Please note that your values MUST ALL BE IN THE DOMAIN OF THE FUNCTIONS YOU CHOOSE TO ADD!!!!! ");
		System.out.println("this interface will automatically quit once best fit line is generated");
		
		Scanner in = new Scanner(System.in);
		
		int UserChoice=-3;
		System.out.println("\n\n\nA constant is automatically generated, choose 1 to add a polonomial element or choose 2 to add a trig element\nRemember to take domain into account!");
		do{
			
			System.out.println("choose 1 for polynomial choose 2 for trig or choose 99 to go to next step:");
			UserChoice= in.nextInt();
			
			if(UserChoice ==1){
				System.out.println();
				System.out.println("what degree? (minimum of 1) ");
				int degree= in.nextInt();
				OSLRValueGenHolder Func = new PolonomialForOSLR(degree);
				ValGen.add(Func);
				System.out.println();
			}
			else if(UserChoice ==2 ){
				System.out.println();
				System.out.println("type 0 for cos, 1 for sin, 2 for tan, 3 for sec\nPlease take domain into account ");
				int choice= in.nextInt();
				OSLRValueGenHolder Func = new TrigSinForOSLR(choice);
				ValGen.add(Func);
				System.out.println();
			}
			else if(UserChoice!=99){
				
			}
			else{
				System.out.println("\nnot valid choice please try again\n");
			}
			
		}while(UserChoice!=99);
		
		System.out.println("\nHow many data points? \n");
		
		int NumDataPoints = in.nextInt();
		
		LinearMatrix X = new LinearMatrix(NumDataPoints,1);
		X.fillMatrixWithValue(1);
		LinearMatrix Y = new LinearMatrix(NumDataPoints,1);
		Y.fillMatrixWithValue(1);
		

		
		System.out.println("\nplease follow instructions to see how to input data\n");
		int i = 0;
		int counter = 1;
		while(i<NumDataPoints){
			System.out.println("\npoint: " + counter);
			System.out.print("x value?: ");
			double xval = in.nextDouble();
			System.out.print("y value?: ");
			double yval = in.nextDouble();
			
			X.set(i,0,xval);
			Y.set(i,0,yval);
			i++;
			counter++;
		}
		
		System.out.println("Calculating... :)");
		OSLR myOSLR = new OSLR();
		LinearMatrix Final = myOSLR.findOSLR(ValGen, X, Y);
		
		//debug only do not uncomment
		//Final.printMatrix();
		int sizeOfResult = Final.getNumRows();
		System.out.println("Your Polonomial: \n");
		int getInt= 1;
		System.out.println("constant= " + roundNum(Final.get(0, 0)));
		for (int j = 0; j< sizeOfResult-1; j++){
			 
			System.out.println(ValGen.get(j).getInfo()+ " with coef of: " + roundNum(Final.get(getInt, 0)));
			getInt++;
		}
		
		System.out.println("type an integer to quit");
		in.nextInt();
	}
	public static double roundNum(double num){
		num = (double)Math.round(num * 1000) / 1000;
		return num; 
	}
	
	
}
