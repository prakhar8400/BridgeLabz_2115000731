import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) {
        int rows1 = 3;
        int cols1 = 3;
        int rows2 = 3;
        int cols2 = 3;

        // Create two random matrices
        int[][] matrix1 = createRandomMatrix(rows1, cols1);
        int[][] matrix2 = createRandomMatrix(rows2, cols2);

        System.out.println("Matrix 1:");
        displayMatrix(matrix1);

        System.out.println("\nMatrix 2:");
        displayMatrix(matrix2);

        // Perform matrix operations
        if (rows1 == rows2 && cols1 == cols2) {
            int[][] sumMatrix = addMatrices(matrix1, matrix2);
            System.out.println("\nSum of Matrices:");
            displayMatrix(sumMatrix);

            int[][] differenceMatrix = subtractMatrices(matrix1, matrix2);
            System.out.println("\nDifference of Matrices:");
            displayMatrix(differenceMatrix);
        }

        if (cols1 == rows2) { // Check for valid dimensions for multiplication
            int[][] productMatrix = multiplyMatrices(matrix1, matrix2);
            System.out.println("\nProduct of Matrices:");
            displayMatrix(productMatrix);
        }

        // Transpose of matrices
        int[][] transposeMatrix1 = transposeMatrix(matrix1);
        System.out.println("\nTranspose of Matrix 1:");
        displayMatrix(transposeMatrix1);

        int[][] transposeMatrix2 = transposeMatrix(matrix2);
        System.out.println("\nTranspose of Matrix 2:");
        displayMatrix(transposeMatrix2);

        // Determinant and Inverse (for 2x2 and 3x3 matrices only)
        if (rows1 == cols1 && rows1 <= 3) {
            int determinant1 = (rows1 == 2) ? determinant2x2(matrix1) : determinant3x3(matrix1);
            System.out.println("\nDeterminant of Matrix 1: " + determinant1);

            if (determinant1 != 0) {
                int[][] inverseMatrix1 = (rows1 == 2) ? inverse2x2(matrix1) : inverse3x3(matrix1);
                System.out.println("\nInverse of Matrix 1:");
                displayMatrix(inverseMatrix1);
            } else {
                System.out.println("Matrix 1 is singular (no inverse).");
            }
        }

        if (rows2 == cols2 && rows2 <= 3) {
            int determinant2 = (rows2 == 2) ? determinant2x2(matrix2) : determinant3x3(matrix2);
            System.out.println("\nDeterminant of Matrix 2: " + determinant2);

            if (determinant2 != 0) {
                int[][] inverseMatrix2 = (rows2 == 2) ? inverse2x2(matrix2) : inverse3x3(matrix2);
                System.out.println("\nInverse of Matrix 2:");
                displayMatrix(inverseMatrix2);
            } else {
                System.out.println("Matrix 2 is singular (no inverse).");
            }
        }
    }

    /**
     * Creates a random matrix with the specified number of rows and columns.
     *
     * @param rows the number of rows
     * @param cols the number of columns
     * @return the randomly generated matrix
     */
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Generate random numbers between 0 and 9
            }
        }
        return matrix;
    }

    /**
     * Adds two matrices.
     *
     * @param matrix1 the first matrix
     * @param matrix2 the second matrix
     * @return the sum of the two matrices
     */
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] sumMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sumMatrix;
    }

    /**
     * Subtracts two matrices.
     *
     * @param matrix1 the first matrix
     * @param matrix2 the second matrix
     * @return the difference of the two matrices
     */
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] differenceMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                differenceMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return differenceMatrix;
    }

    /**
     * Multiplies two matrices.
     *
     * @param matrix1 the first matrix
     * @param matrix2 the second matrix
     * @return the product of the two matrices
     */
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] productMatrix = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return productMatrix;
    }

    /**
     * Finds the transpose of a matrix.
     *
     * @param matrix the matrix to transpose
     * @return the transpose of the matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    /**
     * Finds the determinant of a 2x2 matrix.
     *
     * @param matrix the 2x2 matrix
     * @return the determinant of the matrix
     */
    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    /**
     * Finds the determinant of a 3x3 matrix.
     *
     * @param matrix the 3x3 matrix
     * @return the determinant of the matrix
     */
    public static int determinant3x3(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
                matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
                matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }
 /**
     * Finds the inverse of a 2x2 matrix.
     *
     * @param matrix the 2x2 matrix
     * @return the inverse of the matrix
     */
    public static int[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) {
            return null; // Matrix is singular (no inverse)
        }
        int[][] inverse = new int[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0]
