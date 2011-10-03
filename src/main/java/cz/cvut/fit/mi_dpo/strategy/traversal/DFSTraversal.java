package cz.cvut.fit.mi_dpo.strategy.traversal;

import java.util.Stack;

import cz.cvut.fit.mi_dpo.strategy.Matrix;

public class DFSTraversal extends Traversal {

	public DFSTraversal(Matrix matrix) {
		super(matrix);
	}

	@Override
	protected void traverse() {
		Stack<Integer> stack = new Stack<>();

		Integer root = 0;
		stack.push(root);

		getNodesOrder().add(root);
		while (!stack.isEmpty()) {
			Integer peeked = stack.peek();
			Integer child = getUnvisitedChildNode(peeked);
			if (child != null) {
				getNodesOrder().add(child);
				stack.push(child);
			} else {
				stack.pop();
			}
		}
	}

}
