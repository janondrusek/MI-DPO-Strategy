package cz.cvut.fit.mi_dpo.strategy;

import java.io.BufferedReader;
import java.io.IOException;

public class MatrixReader {

	private Matrix matrix;

	public MatrixReader(BufferedReader br) throws NumberFormatException, IOException {
		initMatrix(br);
	}

	private void initMatrix(BufferedReader br) throws NumberFormatException, IOException {
		int size = Integer.parseInt(br.readLine().trim());
		matrix = new Matrix(size);
		for (int i = 0; i < size; i++) {
			String line = br.readLine().trim();
			for (int j = 0; j < size; j++) {
				matrix.setEdge(i, j, line.charAt(j));
			}
		}
	}

	public Matrix getMatrix() {
		return matrix;
	}
}
