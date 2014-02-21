package cz.cvut.fit.mi_dpo.strategy;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.io.PrintStream;

import org.easymock.Capture;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cz.cvut.fit.mi_dpo.strategy.traversal.Traversal;

@RunWith(EasyMockRunner.class)
public class IntegrationTest {

	private PrintStream stream;

	@Before
	public void setUp() {
		stream = createMock(PrintStream.class);
		StrategyRunner.out = stream;
	}

	@Test
	public void testBFS() throws Exception {
		Capture<Traversal> tr = expectPrintStream(StrategyRunner.BFS);

		replay(stream);
		StrategyRunner.main(args(StrategyRunner.BFS));
		assertEquals("0 1 3 6 4 5 2 7", tr.getValue().toString());
	}

	@Test
	public void testDFS() throws Exception {
		Capture<Traversal> tr = expectPrintStream(StrategyRunner.DFS);

		replay(stream);
		StrategyRunner.main(args(StrategyRunner.DFS));
		assertEquals("0 1 4 6 5 2 7 3", tr.getValue().toString());
	}

	private String[] args(String strategy) {
		return new String[] { "src/test/resources/youtube.txt", strategy };
	}

	private Capture<Traversal> expectPrintStream(String strategy) {
		Capture<Traversal> tr = new Capture<>();
		expect(stream.printf(anyString(), anyObject(), anyObject(), anyObject())).andReturn(stream);
		stream.print(anyString());
		expect(stream.printf(anyString(), eq(strategy), capture(tr))).andReturn(stream);

		return tr;
	}
}
