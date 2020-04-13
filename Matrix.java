import java.util.Scanner;

public class Matrix {
  public int row;
  public int col;
  private int[][] matrixArr;

  public Matrix(){
    this(0,0);
  }

  public Matrix(int n){
    this(n,n);
  }

  public Matrix(int m, int n){
    this.row = m;
    this.col = n;
    this.matrixArr = new int[m][n];
    for (int i = 0; i < this.row; i++){
      for (int j = 0; j < this.col; j++){
        this.matrixArr[i][j] = 0;
      }
    }
  }

  public Matrix(int[][] arr){
    //can be broken if someone inputs a 2d array which has a diff number of elements in each row
    this.row = arr.length;
    this.col = arr[0].length;
    this.matrixArr = new int[this.row][this.col];
    for (int i = 0; i < this.row; i++){
      for (int j = 0; j < this.col; j++){
        this.matrixArr[i][j] = arr[i][j];
      }
    }
  }

  public void printMatrix(){
    for (int i = 0; i < this.row; i++){
      for (int j = 0; j < this.col; j++){
        System.out.print(this.matrixArr[i][j] + "  ");
      }
      System.out.println();
    }
    System.out.println();
  }

  //idea override '+' operation
  public Matrix add(Matrix other){
    if ((this.row == other.row) && (this.col == other.col)){
      Matrix finalMatrix = new Matrix(this.row, this.col);
      for (int i = 0; i < this.row; i++){
        for (int j = 0; j < this.col; j++){
          finalMatrix.matrixArr[i][j] = this.matrixArr[i][j] + other.matrixArr[i][j];
        }
      }
      return finalMatrix;
    }
    return null;
  }

  public Matrix scalarMult(int num){
    Matrix resMatrix = new Matrix(this.row, this.col);
    for (int i = 0; i < this.row; i++){
      for (int j = 0; j < this.col; j++){
        resMatrix.matrixArr[i][j] = this.matrixArr[i][j] * num;
      }
    }
    return resMatrix;
  }

  public Matrix sub(Matrix other){
    return add(other.scalarMult(-1));
  }

//matrix function which involves scanner - interaction between user
  public static void main(String[] args) {

    Matrix A = new Matrix(3,3);
    A.printMatrix();

    int[][] randomInts = {{1,2,3},{1,2,3},{4,5,6}};
    Matrix B = new Matrix(randomInts);
    B.printMatrix();

    Matrix C = A.add(B);
    C.printMatrix();

    Matrix D = A.sub(B);
    D.printMatrix();

    Scanner in = new Scanner(System.in);
    int userRows, userCols, userData;
    System.out.println("please enter the number of rows for your Matrix");
    userRows = in.nextInt();
    System.out.println("please enter the number of columns");
    userCols = in.nextInt();
    Matrix E = new Matrix(userRows, userCols);
    for (int i = 0; i < userRows; i++){
      for (int j = 0; j < userCols; j++){
        System.out.println("Enter value for matrix at row "+(i+1)+" and column "+(j+1)+" ");
    		userData = in.nextInt();
    		E.matrixArr[i][j] = userData;
      }
    }
    E.printMatrix();

  }
}
