package cz.cvut.fit.mi_dpo.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import cz.cvut.fit.mi_dpo.strategy.traversal.BFSTraversal;
import cz.cvut.fit.mi_dpo.strategy.traversal.DFSTraversal;
import cz.cvut.fit.mi_dpo.strategy.traversal.Traversal;

public class StrategyRunner {
	public static void main(String[] args) {
		long startCpu = getCpuTime();
		long startTimestamp = System.currentTimeMillis();
		try {
			MatrixReader mr = getMatrixReader(args[0]);

			System.out.print(mr.getMatrix().toString());

			traverse(mr.getMatrix(), args[1]);
		} catch (Exception e) {
			help(e.getMessage());
			e.printStackTrace();
		} finally {
			printTimeInfo("Total operation", startCpu, startTimestamp);
		}
	}

	private static void traverse(Matrix matrix, String strategy) throws UnsupportedOperationException {
		Traversal result = null;
		if (strategy.equals("dfs")) {
			result = new DFSTraversal(matrix);
		} else if (strategy.equals("bfs")) {
			result = new BFSTraversal(matrix);
		} else {
			throw new UnsupportedOperationException(String.format(
					"Strategy [%s] is not supported. Supported is [bfs|dfs]", strategy));
		}
		System.out.printf("Strategy [%s] result is [%s]%n", strategy, result);
	}

	private static MatrixReader getMatrixReader(String path) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		return new MatrixReader(br);
	}

	private static long getCpuTime() {
		return ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean())
				.getProcessCpuTime();
	}

	private static void printTimeInfo(String operationName, long startCpu, long startTimestamp) {
		System.out.printf("%s took %.2f CPU s, real: %.2f s%n", operationName, (getCpuTime() - startCpu) / 1000000000D,
				(System.currentTimeMillis() - startTimestamp) / 1000D);
	}

	private static void help(String message) {
		System.out.println(message);
		System.out.println("Usage: java -jar "
				+ StrategyRunner.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				+ " datafile.txt bfs|dfs");
	}
}
