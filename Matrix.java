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
  public Matrix addMatrix(Matrix other){
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

//matrix function which involves scanner - interaction between user
  public static void main(String[] args) {
    Matrix A = new Matrix(3,3);
    A.printMatrix();
    int[][] randomInts = {{1,2,3},{1,2,3},{4,5,6}};
    Matrix B = new Matrix(randomInts);
    B.printMatrix();
    Matrix C = A.addMatrix(B);
    C.printMatrix();
  }
}
