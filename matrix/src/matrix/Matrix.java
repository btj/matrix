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
	 * @invar | 0 <= nbRows
	 * @invar | 0 <= nbColumns
	 * @invar | elements != null
	 * @invar | elements.length == nbRows * nbColumns
	 */
	private int nbRows;
	private int nbColumns;
	/** @representationObject */
	private double[] elements;
	
	/**
	 * @post | result == getElementsRowArrays().length
	 */
	public int getNbRows() { return nbRows; }

	/**
	 * @basic
	 */
	public int getNbColumns() { return nbColumns; }
	
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
	public double[] getElementsRowMajor() { return elements.clone(); }
	
	/**
	 * @post | result != null
	 * @post | result.length == getNbRows() * getNbColumns()
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex ->
	 *       |     IntStream.range(0, getNbColumns()).allMatch(columnIndex ->
	 *       |         result[columnIndex * getNbRows() + rowIndex] == getElementsRowArrays()[rowIndex][columnIndex]))
	 */
	public double[] getElementsColumnMajor() { 
		double[][] rowArrays = getElementsRowArrays();
		double[] result = new double[getNbRows() * getNbColumns()];
		for (int rowIndex = 0; rowIndex < getNbRows(); rowIndex++)
			for (int columnIndex = 0; columnIndex < getNbColumns(); columnIndex++)
				result[columnIndex * getNbRows() + rowIndex] = rowArrays[rowIndex][columnIndex];
		return result;
	}
	
	/**
	 * @basic
	 * 
	 * @post | result != null
	 * @post | Arrays.stream(result).allMatch(row -> row != null && row.length == getNbColumns())
	 */
	public double[][] getElementsRowArrays() {
		double[][] result = new double[nbRows][nbColumns];
		for (int rowIndex = 0; rowIndex < nbRows; rowIndex++)
			for (int columnIndex = 0; columnIndex < nbColumns; columnIndex++)
				result[rowIndex][columnIndex] = elements[rowIndex * nbColumns + columnIndex];
		return result;
	}
	
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
		
		this.nbRows = nbRows;
		this.nbColumns = nbColumns;
		this.elements = elementsRowMajor.clone();
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
	public Matrix scaled(double scaleFactor) {
		double[] newElements = new double[elements.length];
		for (int i = 0; i < newElements.length; i++)
			newElements[i] = elements[i] * scaleFactor;
		return new Matrix(nbRows, nbColumns, newElements);
	}
	
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
	public Matrix plus(Matrix other) {
		double[] newElements = new double[elements.length];
		for (int i = 0; i < newElements.length; i++)
			newElements[i] = elements[i] + other.elements[i];
		return new Matrix(nbRows, nbColumns, newElements);
	}
	
}
