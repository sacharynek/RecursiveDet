package tomaszlach;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj wymiar macierzy ");
        int n = input.nextInt();
        double a[][] = new double[n][n];
        System.out.println("Podaj Elementy Macierzy: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = input.nextDouble();
            }
        }

        double output = calculateDeterminantRecursively(a);

        System.out.format("Wyznacznik macierzy: %f ", output);
    }

    public static double calculateDeterminantRecursively(double[][] sourceMatrix) {

        double det = 0;

        if (sourceMatrix.length == 1) {
            return sourceMatrix[0][0];
        }

        for (int i = 0; i < sourceMatrix.length; i++) {

            det += sourceMatrix[0][i] * Math.pow(-1, (i + 2)) * calculateDeterminantRecursively(getSupplementalMatrix(sourceMatrix, 0, i));

        }

        return det;
    }

    public static double[][] getSupplementalMatrix(double[][] sourceMatrix, int row, int column) {
        double[][] supplementalMatrix = new double[sourceMatrix.length - 1][sourceMatrix.length - 1];

        int currentRow = 0;
        int currentColumn = 0;

        for (int i = 0; i < sourceMatrix.length; i++) {
            for (int j = 0; j < sourceMatrix.length; j++) {

                if (i != row && j != column) {
                    supplementalMatrix[currentRow][currentColumn++] = sourceMatrix[i][j];
                    if (currentColumn == sourceMatrix.length - 1) {
                        currentColumn = 0;
                        currentRow++;
                    }
                }

            }
        }

        return supplementalMatrix;
    }

}
