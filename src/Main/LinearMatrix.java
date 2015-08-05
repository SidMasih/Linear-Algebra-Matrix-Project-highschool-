package Main;



/**
 * This class is designed to simulate a mathematical matrix. --
 * Class is thread safe; more advanced users should feel free to multithread. --
 * It is highly recommended to program with this class in Eclipse --
 *  To use class, simply drag and drop this class into the project icon in the Eclipse side bar --
 *  Please remember to use a machine epsilon to compare two values. Do not compare to double values directly! Wikipedia has a good article on the subject.
 * 
 * @version 1.0
 * @author Sid Masih -- 
 *  Copyright 2015, licensed to La Jolla Country Day School
 *
 */
public class LinearMatrix {

	// functions as master matrix, user should not access this variable
	private double[][] myPrimMatrix; 
	private int Rows = -1;
	private int Cols = -1;
	final private double DEFAULT_VALUE = 0;
	
	
	/**
	 * creates an empty matrix with dimensions of 0 X 0
	 * 
	 * 
	 */
	public LinearMatrix() {
		this.myPrimMatrix = new double[0][0];
		this.Rows = 0;
		this.Cols = 0;
	}
	
	/**
	 * create matrix with dimensions of rows X cols
	 * @param rows  integer value of rows in matrix
	 * @param cols  integer value of cols in matrix
	 */
	public LinearMatrix(int rows, int cols){
		this.myPrimMatrix = new double[rows][cols];
		this.Rows = rows;
		this.Cols = cols;
		fillMatrixWithValue(DEFAULT_VALUE);
	}

	/**
	 * @return the cols
	 */
	public int getNumCols() {
		return Cols;
	}

	/**
	 * @return the rows
	 */
	public int getNumRows() {
		return Rows;
	}

	/**
	 * destroys old matrix and creates new one with dimensions of rows X cols
	 * old matrix WILL be destroyed
	 * @param rows  integer value of rows in matrix
	 * @param cols  integer value of cols in matrix
	 */
	public void setMatrix(int rows, int cols){
		this.myPrimMatrix = new double[rows][cols];
		this.Rows = rows;
		this.Cols = cols;
		fillMatrixWithValue(DEFAULT_VALUE);
	}

	/**
	 * simply returns value at a location in the matrix
	 * @param rows  row value
	 * @param cols  col value
	 * @return double value from matrix from position rows X cols
	 */
	public double get(int rows, int cols){
		return myPrimMatrix[rows][cols];
	}

	/**
	 * set a position in the matrix to a certain double value
	 * @param rows  row value
	 * @param cols  col value
	 * @param value  value to be set at the location rows X cols
	 */
	public void set(int rows, int cols, double value){
		this.myPrimMatrix[rows][cols] = value;
	}
	
	
	/**
	 * helper method used to only print a matrix for test purposes -- check with instructor before using
	 */
	public void printMatrix(){
		for(int r= 0; r< this.Rows; r++){
			
			for( int c= 0; c< this.Cols; c++){
				
				double num = myPrimMatrix[r][c];
				num = (double)Math.round(num * 100) / 100;
				
				System.out.print(" " + num + " ");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * fills matrix with specified value
	 * @param value value that all positions in matrix will be set to
	 */
	public void fillMatrixWithValue(double value){
		for(int r= 0; r< this.Rows; r++){
			
			for( int c= 0; c< this.Cols; c++){
				this.myPrimMatrix[r][c] = value;
			}
			
			
		}
	}
	
	/**
	 * resizes matrix without destroying values
	 * @param rows  total number of new rows
	 * @param cols  total number of new cols
	 */
	public void resizeMatrix(int rows, int cols){
		int oldRows = this.Rows;
		int oldCols = this.Cols;
		double [][] primMatTemp = this.myPrimMatrix;
		
		//create new matrix
		setMatrix(rows,cols);
		
		//fill in with old values
		for(int r= 0; r< oldRows; r++){
			
			for(int c= 0; c< oldCols; c++){
				this.myPrimMatrix[r][c] = primMatTemp[r][c];
			}
			
		}//end for loop
		
		primMatTemp = null;
		
	}

	
	
}// end class
