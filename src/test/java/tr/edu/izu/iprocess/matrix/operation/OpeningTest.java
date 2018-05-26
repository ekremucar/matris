package tr.edu.izu.iprocess.matrix.operation;

import java.io.File;

import org.junit.Assert;

import junit.framework.TestCase;
import tr.edu.izu.iprocess.matris.io.impl.MatrixIO;
import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class OpeningTest extends TestCase {

	public void test_dilation_3x3_window() throws Exception{
		MatrixIO io = new MatrixIO();
		IntegerMatrix integerMatrixFromCsv = io.integerMatrixFromCsv(new File("src/test/resources/sample3.csv"));
		Integer [][] windowData = {{1,1,1},{1,1,1},{1,1,1}};

		Opening opening = new Opening(integerMatrixFromCsv, new Window(3, 3, windowData));
		
		IntegerMatrix result = opening.execute();
		
		IntegerMatrix resultExpected = io.integerMatrixFromCsv(new File("src/test/resources/sample3_open.csv"));

		Assert.assertArrayEquals(resultExpected.getDatas(), result.getDatas());
	}
}
