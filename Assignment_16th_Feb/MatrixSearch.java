public class MatrixSearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Handle null or empty matrix
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (target < midValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 4, 7, 11},
                {5, 8, 12, 19},
                {10, 13, 17, 22},
                {15, 20, 25, 30}
        };
        int target1 = 12;
        boolean found1 = searchMatrix(matrix1, target1);
        System.out.println("Target " + target1 + " found in matrix1: " + found1); // Output: true

        int target2 = 20;
        boolean found2 = searchMatrix(matrix1, target2);
        System.out.println("Target " + target2 + " found in matrix1: " + found2); // Output: true

        int target3 = 3;
        boolean found3 = searchMatrix(matrix1, target3);
        System.out.println("Target " + target3 + " found in matrix1: " + found3); // Output: false

        int[][] matrix2 = {{1,2,3},{4,5,6}};
        int target4 = 4;
        boolean found4 = searchMatrix(matrix2, target4);
        System.out.println("Target " + target4 + " found in matrix2: " + found4); // Output: true

        int[][] matrix3 = {{1}};
        int target5 = 1;
        boolean found5 = searchMatrix(matrix3, target5);
        System.out.println("Target " + target5 + " found in matrix3: " + found5); // Output: true

        int[][] matrix4 = {{1}};
        int target6 = 2;
        boolean found6 = searchMatrix(matrix4, target6);
        System.out.println("Target " + target6 + " found in matrix4: " + found6); // Output: false

        int[][] matrix5 = {}; // Empty matrix
        int target7 = 1;
        boolean found7 = searchMatrix(matrix5, target7);
        System.out.println("Target " + target7 + " found in matrix5: " + found7); // Output: false

        int[][] matrix6 = null; // Null matrix
        int target8 = 1;
        boolean found8 = searchMatrix(matrix6, target8);
        System.out.println("Target " + target8 + " found in matrix6: " + found8); // Output: false


    }
}
