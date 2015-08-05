/**
 * 
 */
package OSLRPack;

import java.util.ArrayList;

import Main.LinearMatrix;

/**
 * @author Sid
 * Tester Class only to test various parts of OSLR
 */
public class OSLRPartTesterDONOTUSE {


	//private static ArrayList<OSLRValueGenHolder> valgen;

	/**
	 * @param args RUN THIS TOWN
	 */
	public static void main(String[] args) {
		
		OSLRValueGenHolder Test2 = new PolonomialForOSLR(2); 
		OSLRValueGenHolder Test = new PolonomialForOSLR(1);
		System.out.println("begin parametrized tests...\n");
		ArrayList<OSLRValueGenHolder> valgen = new ArrayList<OSLRValueGenHolder>();
		valgen.add(Test);
		valgen.add(Test2);
		
		System.out.println(valgen.get(0).getInfo());
		
		OSLRValueGenerator GenCom = new OSLRValueGenerator(valgen);
		double [] MyArray = GenCom.getRowOfM(-3.0);
		
		for(int i = 0; i< MyArray.length; i++){
			System.out.print(MyArray[i] + " ");
			
			
		}
		
		
		System.out.println("\n\n\n full test now...\n\n\n X values");
		
		LinearMatrix X = new LinearMatrix(4,1);
		
		X.fillMatrixWithValue(0);
		X.printMatrix();
		X.set(0, 0, 1);
		X.set(1, 0, 2);
		X.set(2, 0, 3);
		X.set(3, 0, 4);
		X.printMatrix();
	
		System.out.println("\n Y values \n");
LinearMatrix Y = new LinearMatrix(4,1);
		
		Y.set(0, 0, 2);
		Y.set(1, 0, 8);
		Y.set(2, 0, 18);
		Y.set(3, 0, 32);
		Y.printMatrix();
		OSLR myOSLR = new OSLR();
		LinearMatrix Khos = myOSLR.findOSLR(valgen, X, Y);
		Khos.printMatrix();
	}

}
