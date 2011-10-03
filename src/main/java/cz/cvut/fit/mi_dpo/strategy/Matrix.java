package cz.cvut.fit.mi_dpo.strategy;

public class Matrix {
	private int size;

	private boolean[][] matrix;

	public Matrix(int size) {
		this.size = size;
		matrix = new boolean[size][size];
	}

	public int getSize() {
		return size;
	}

	public boolean hasEdge(int row, int column) throws ArrayIndexOutOfBoundsException {
		return matrix[row][column];
	}

	public boolean[][] getMatrix() {
		return matrix;
	}

	public void setEdge(int row, int column, char value) {
		boolean edge = value == '0' ? false : true;
		matrix[row][column] = matrix[column][row] = edge;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(getSize() * getSize() + getSize());
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				sb.append(hasEdge(i, j) ? "1" : "0");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
