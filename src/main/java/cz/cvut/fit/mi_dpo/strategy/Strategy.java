package cz.cvut.fit.mi_dpo.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class Strategy {
	public static void main(String[] args) {
		long startCpu = getCpuTime();
		long startTimestamp = System.currentTimeMillis();
		try {
			MatrixReader mr = getMatrixReader(args[0]);
			traverse(mr, args[1]);
		} catch (Exception e) {
			help(e.getMessage());
			e.printStackTrace();
		} finally {
			printTimeInfo("Total operation", startCpu, startTimestamp);
		}
	}

	private static void traverse(MatrixReader mr, String strategy) {
		System.out.print(mr.getMatrix().toString());
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
				+ Strategy.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				+ " datafile.txt bfs|dfs");
	}
}
