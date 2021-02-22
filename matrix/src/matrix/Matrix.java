package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a matrix (from algebra).
 * 
 * @invar | 0 <= getNbColumns()
 * 
 * @immutable
 */
public class Matrix {
	
	/**
	 * @post | result == getElementsRowArrays().length
	 */
	public int getNbRows() { throw new RuntimeException("Not yet implemented"); }

	/**
	 * @basic
	 */
	public int getNbColumns() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @post | result != null
	 * @post | result.length == getNbRows() * getNbColumns()
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex ->
	 *       |     IntStream.range(0, getNbColumns()).allMatch(columnIndex ->
	 *       |         result[rowIndex * getNbColumns() + columnIndex] == getElementsRowArrays()[rowIndex][columnIndex]))
	 *       
	 *       IntStream.range(a, b).allMatch(i -> P(i))
	 *       forall i. a <= i < b ==> P(i)
	 */
	public double[] getElementsRowMajor() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @post | result != null
	 * @post | result.length == getNbRows() * getNbColumns()
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex ->
	 *       |     IntStream.range(0, getNbColumns()).allMatch(columnIndex ->
	 *       |         result[columnIndex * getNbRows() + rowIndex] == getElementsRowArrays()[rowIndex][columnIndex]))
	 */
	public double[] getElementsColumnMajor() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @basic
	 * 
	 * @post | result != null
	 * @post | result.length == getNbRows()
	 * @post | Arrays.stream(result).allMatch(row -> row != null && row.length == getNbColumns())
	 */
	public double[][] getElementsRowArrays() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * Initializes this object so that it represents a matrix with the given number of rows and columns and the given elements.
	 * 
	 * @param elementsRowMajor The elements for the array, in row major order. (I.e., the elements of the first row come first.)
	 * 
	 * @throws IllegalArgumentException if the given number of rows is negative
	 *       | nbRows < 0
	 * @throws IllegalArgumentException if the given number of columns is negative
	 *       | nbColumns < 0
	 * 
	 * @throws IllegalArgumentException | elementsRowMajor == null
	 * @throws IllegalArgumentException | elementsRowMajor.length != nbRows * nbColumns
	 * @post | getNbRows() == nbRows
	 * @post | getNbColumns() == nbColumns
	 * @post | Arrays.equals(getElementsRowMajor(), elementsRowMajor)
	 */
	public Matrix(int nbRows, int nbColumns, double[] elementsRowMajor) {
		if (nbRows < 0)
			throw new IllegalArgumentException("Negative number of rows");
		if (nbColumns < 0)
			throw new IllegalArgumentException("Negative number of columns");
		if (elementsRowMajor == null)
			throw new IllegalArgumentException("elementsRowMajor is null");
		if (elementsRowMajor.length != nbRows * nbColumns)
			throw new IllegalArgumentException("elementsRowMajor has wrong length");
		
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * Returns a copy of this matrix where each element has been multiplied by the given scale factor.
	 * 
	 * @post | result != null
	 * @post | result.getNbRows() == getNbRows()
	 * @post | result.getNbColumns() == getNbColumns()
	 * @post | IntStream.range(0, getNbRows() * getNbColumns()).allMatch(i ->
	 *       |     result.getElementsRowMajor()[i] == getElementsRowMajor()[i] * scaleFactor)
	 */
	public Matrix scaled(double scaleFactor) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * Returns the matrix obtained by adding this matrix and the given matrix.
	 * 
	 * @pre | other != null
	 * @pre | other.getNbRows() == getNbRows()
	 * @pre | other.getNbColumns() == getNbColumns()
	 * 
	 * @post | result != null
	 * @post | result.getNbRows() == getNbRows()
	 * @post | result.getNbColumns() == getNbColumns()
	 * @post | IntStream.range(0, getNbRows() * getNbColumns()).allMatch(i ->
	 *       |     result.getElementsRowMajor()[i] == getElementsRowMajor()[i] + other.getElementsRowMajor()[i])
	 */
	public Matrix plus(Matrix other) { throw new RuntimeException("Not yet implemented"); }
	
}
