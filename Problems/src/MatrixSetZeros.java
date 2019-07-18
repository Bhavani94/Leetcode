import java.util.HashSet;
import java.util.Set;

public class MatrixSetZeros {
    // O(m+n) space
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rowIndex = new HashSet<>();
        Set<Integer> colIndex = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowIndex.add(i);
                    colIndex.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(rowIndex.contains(i) || colIndex.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void setZeroes1(int[][] matrix) {
        // O(1) space
        int intersectionElement = 1;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) intersectionElement = 0;
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1 ; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(intersectionElement == 0)
                matrix[i][0] = 0;
        }


        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
//        setZeroes(matrix);
        setZeroes1(matrix);
    }
}
