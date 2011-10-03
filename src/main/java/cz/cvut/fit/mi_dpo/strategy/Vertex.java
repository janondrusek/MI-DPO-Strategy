package cz.cvut.fit.mi_dpo.strategy;

public class Vertex {

	private int row;

	private int column;

	public Vertex(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public boolean equals(Object vertex) {
		Vertex copy = (Vertex) vertex;
		return getRow() == copy.getRow() && getColumn() == copy.getColumn();
	}
}
