package cz.cvut.fit.mi_dpo.strategy.traversal;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.mi_dpo.strategy.Matrix;

public abstract class Traversal {

	private Matrix matrix;

	private List<Integer> nodes;

	public Traversal(Matrix matrix) {
		this.matrix = matrix;
		nodes = new ArrayList<>(matrix.getSize() + 2);
		traverse();
	}

	abstract protected void traverse();

	protected Matrix getMatrix() {
		return matrix;
	}

	protected List<Integer> getNodesOrder() {
		return nodes;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Integer node : getNodesOrder()) {
			sb.append(node);
			sb.append(" ");
		}

		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

}
