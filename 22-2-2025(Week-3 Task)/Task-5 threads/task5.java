class Task5 {
    static int limit = 50, sum = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> addPrimes(1, limit / 2));
        Thread t2 = new Thread(() -> addPrimes(limit / 2 + 1, limit));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        System.out.println("Sum of primes: " + sum);
    }

    static synchronized void addPrimes(int start, int end) {
        for (int i = start; i <= end; i++) if (isPrime(i)) sum += i;
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;
        return true;
    }
}
