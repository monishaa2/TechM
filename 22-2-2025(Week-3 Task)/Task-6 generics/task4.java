class Task4 {
    static int[][] A = { {1, 2}, {3, 4} };
    static int[][] B = { {5, 6}, {7, 8} };
    static int[][] result = new int[2][2];

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> multiply(0));
        Thread t2 = new Thread(() -> multiply(1));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void multiply(int row) {
        for (int j = 0; j < 2; j++) {
            result[row][j] = A[row][0] * B[0][j] + A[row][1] * B[1][j];
        }
    }
}
