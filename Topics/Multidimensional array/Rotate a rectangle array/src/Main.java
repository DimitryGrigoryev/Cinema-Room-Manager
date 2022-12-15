import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arrayInvert = new int[m][n];
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
            }                        
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0, k = n - 1; j < n; j++, k--) {
                arrayInvert[i][j] = array[k][i];
                System.out.print(arrayInvert[i][j] + " ");
            }
            System.out.println();
        }
    }
}