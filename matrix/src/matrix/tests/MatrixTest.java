package matrix.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import matrix.Matrix;

class MatrixTest {

	@Test
	void test() {
		Matrix myMatrix = new Matrix(2, 3, new double[] {1, 0, 0, 0, 1, 0});
		assertEquals(2, myMatrix.getNbRows());
		assertEquals(3, myMatrix.getNbColumns());
		assertArrayEquals(new double[] {1, 0, 0, 0, 1, 0}, myMatrix.getElementsRowMajor());
		assertArrayEquals(new double[] {1, 0, 0, 1, 0, 0}, myMatrix.getElementsColumnMajor());
		
		double[][] rows = {
				{1, 0, 0},
				{0, 1, 0}
		};
		assertTrue(Arrays.deepEquals(rows, myMatrix.getElementsRowArrays()));
		
		assertArrayEquals(new double[] {.5, 0, 0, 0, .5, 0}, myMatrix.scaled(0.5).getElementsRowMajor());
		assertArrayEquals(new double[] {1, 0, 2, 0, 1, 2}, myMatrix.plus(new Matrix(2, 3, new double[] {0, 0, 2, 0, 0, 2})).getElementsRowMajor());
	}

}
