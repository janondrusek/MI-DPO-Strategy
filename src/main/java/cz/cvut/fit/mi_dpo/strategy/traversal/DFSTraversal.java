package cz.cvut.fit.mi_dpo.strategy.traversal;

import java.util.ArrayDeque;
import java.util.Deque;

import cz.cvut.fit.mi_dpo.strategy.Matrix;

public class DFSTraversal extends Traversal {

	public DFSTraversal(Matrix matrix) {
		super(matrix);
	}

	@Override
	protected Deque<Integer> newDeque() {
		return new ArrayDeque<>();
	}

	@Override
	protected void doTraverse(Deque<Integer> queue) {
		while (!queue.isEmpty()) {
			Integer peeked = queue.peek();
			Integer child = getUnvisitedChildNode(peeked);
			if (child != null) {
				getNodesOrder().add(child);
				queue.push(child);
			} else {
				queue.pop();
			}
		}
	}

}
