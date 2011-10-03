package cz.cvut.fit.mi_dpo.strategy.traversal;

import java.util.LinkedList;
import java.util.Queue;

import cz.cvut.fit.mi_dpo.strategy.Matrix;

public class BFSTraversal extends Traversal {

	public BFSTraversal(Matrix matrix) {
		super(matrix);
	}

	@Override
	protected void traverse() {
		Queue<Integer> queue = new LinkedList<>();

		Integer root = 0;
		queue.add(root);
		getNodesOrder().add(root);

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
