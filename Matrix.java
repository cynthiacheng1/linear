import java.util.Scanner;

public class Matrix {
	public int row;
	public int col;
	private int[][] arr;

	public Matrix() {
		this(0, 0);
	}

	public Matrix(int n) {
		this(n, n);
	}

	public Matrix(int m, int n) {
		this.row = m;
		this.col = n;
		this.arr = new int[m][n];
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				this.arr[i][j] = 0;
			}
		}
	}

	public Matrix(int[][] arr) {
		// can be broken if someone inputs a 2d array which has a diff number of
		// elements in each row
		this.row = arr.length;
		this.col = arr[0].length;
		this.arr = new int[this.row][this.col];
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				this.arr[i][j] = arr[i][j];
			}
		}
	}

	public void printMatrix() {
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				System.out.print(this.arr[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int getElement(int row, int col) {
		return arr[row][col];
	}

	// idea override '+' operation
	public Matrix add(Matrix other) {
		if ((this.row == other.row) && (this.col == other.col)) {
			Matrix finalMatrix = new Matrix(this.row, this.col);
			for (int i = 0; i < this.row; i++) {
				for (int j = 0; j < this.col; j++) {
					finalMatrix.arr[i][j] = this.arr[i][j] + other.arr[i][j];
				}
			}
			return finalMatrix;
		}
		return null;
	}

	public Matrix scalarMult(int num) {
		Matrix resMatrix = new Matrix(this.row, this.col);
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				resMatrix.arr[i][j] = this.arr[i][j] * num;
			}
		}
		return resMatrix;
	}

	public Matrix sub(Matrix other) {
		return add(other.scalarMult(-1));
	}

	public Matrix mult(Matrix other) {
		if (this.col == other.row) {
			Matrix resMatrix = new Matrix(this.row, other.col);
			for (int i = 0; i < this.row; i++) {
				for (int j = 0; j < this.col; j++) {
					resMatrix.arr[i][j] = multCell(this, other, i, j);
				}
			}
			return resMatrix;
		}
		return null;
	}

	private int multCell(Matrix first, Matrix second, int row, int col) {
		int cell = 0;
		for (int i = 0; i < second.arr.length; i++) {
			cell += first.arr[row][i] * second.arr[i][col];
		}
		return cell;
	}
}
