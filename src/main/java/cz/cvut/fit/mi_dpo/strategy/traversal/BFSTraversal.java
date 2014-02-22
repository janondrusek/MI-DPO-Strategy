package cz.cvut.fit.mi_dpo.strategy.traversal;

import java.util.Deque;
import java.util.LinkedList;

import cz.cvut.fit.mi_dpo.strategy.Matrix;

public class BFSTraversal extends Traversal {

	public BFSTraversal(Matrix matrix) {
		super(matrix);
	}

	@Override
	protected Deque<Integer> newDeque() {
		return new LinkedList<>();
	}

	@Override
	protected void doTraverse(Deque<Integer> queue) {
		while (!queue.isEmpty()) {
			Integer queued = queue.remove();
			Integer child = null;
			while ((child = getUnvisitedChildNode(queued)) != null) {
				getNodesOrder().add(child);
				queue.add(child);
			}
		}
	}

}
