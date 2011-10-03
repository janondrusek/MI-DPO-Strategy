package cz.cvut.fit.mi_dpo.strategy.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
			Integer child = getUnvisitedChildVertex(peeked);
			if (child != null) {
				getNodesOrder().add(child);
				stack.push(child);
			} else {
				stack.pop();
			}
		}
	}

	private Integer getUnvisitedChildVertex(Integer peeked) {
		List<Integer> children = new ArrayList<>();

		for (int child = peeked; child < getMatrix().getSize(); child++) {
			if (isClosestChild(peeked, child)) {
				children.add(child);
			}
		}

		for (int child = peeked; child >= 0; child--) {
			if (isClosestChild(peeked, child)) {
				children.add(child);
			}
		}
		Collections.sort(children);
		return children.size() > 0 ? children.get(0) : null;
	}

	private boolean isClosestChild(Integer peeked, Integer child) {
		return getMatrix().hasEdge(peeked, child) && !getNodesOrder().contains(child);
	}
}
