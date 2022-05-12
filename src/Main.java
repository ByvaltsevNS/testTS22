import java.util.Scanner;

public class Main {
    public static void task1(Scanner scanner) {
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();

        int maxCountA = A;
        int minCountB = B / N;

        if (maxCountA > minCountB) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void task2(Scanner scanner) {
        String ab = scanner.next();
        String ac = scanner.next();
        String bc = scanner.next();

        if (ab.equals(">")) {
            if (ac.equals(">")) {
                if (bc.equals(">")) {
                    System.out.println("cba");
                } else if (bc.equals("<")) {
                    System.out.println("bca");
                } else if (bc.equals("=")) {
                    System.out.println("bca");
                    System.out.println("cba");
                }
            } else if (ac.equals("=")) {
                if (bc.equals("<")) {
                    System.out.println("bac");
                    System.out.println("bca");
                }
            } else if (ac.equals("<")) {
                if (bc.equals("<")) {
                    System.out.println("bac");
                }
            }
        } else if (ab.equals("=")) {
            if (ac.equals(">")) {
                if (bc.equals(">")) {
                    System.out.println("cab");
                    System.out.println("cba");
                }
            } else if (ac.equals("=")) {
                if (bc.equals("=")) {
                    System.out.println("abc");
                    System.out.println("acb");
                    System.out.println("bac");
                    System.out.println("bca");
                    System.out.println("cab");
                    System.out.println("cba");
                }
            } else if (ac.equals("<")) {
                if (bc.equals("<")) {
                    System.out.println("abc");
                    System.out.println("bac");
                }
            }
        } else if (ab.equals("<")) {
            if (ac.equals(">")) {
                if (bc.equals(">")) {
                    System.out.println("cab");
                }
            } else if (ac.equals("=")) {
                if (bc.equals(">")) {
                    System.out.println("acb");
                    System.out.println("cab");
                }
            } else if (ac.equals("<")) {
                if (bc.equals(">")) {
                    System.out.println("acb");
                } else if (bc.equals("=")) {
                    System.out.println("acb");
                    System.out.println("cab");
                } else if (bc.equals("<")) {
                    System.out.println("abc");
                }
            }
        }
    }

    public static void task3(Scanner scanner) {
        long N = scanner.nextLong();
        int zeroCount = 0;
        while (N % 10 == 0) {
            N /= 10;
        }

        while (N / 10 > 0) {
            if (N % 10 == 0) {
                zeroCount++;
            }
            N /= 10;
        }
        System.out.println(zeroCount);
    }

    public static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void task4(Scanner scanner) {
        int n = scanner.nextInt();
        char[][] matrix = new char[n][n];

        char N = (char) (n - 1);
        for (char i = 0; i <= N / 2; i++) {
            for (char j = i; j <= N / 2; j++) {
                if (i == j) {
                    matrix[i][j] = matrix[N-i][j] = matrix[N-i][N-j] = matrix[i][N-j] = 'a';
                } else {
                    matrix[i][j] = matrix[N-i][j] = matrix[N-i][N-j] = matrix[i][N-j] = (char) ('a' + ((j - i) % 26));
                    matrix[j][i] = matrix[N-j][i] = matrix[N-j][N-i] = matrix[j][N-i] = (char) ('a' + ((j - i) % 26));
                }
            }
        }
        printArray(matrix);
    }

    private static class Permutation {
        private int n;
        private int k;
        private int beautyCount;
        private int[] arr;

        public Permutation(int n, int k) {
            this.n = n;
            this.k = k;
            beautyCount = 0;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
        }

        public int getCurrentBeauty() {
            int beauty = 0;
            for (int i = 0; i < n; i++) {
                beauty += arr[i] * i;
            }
            return beauty;
        }

        private void swap(int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        public void generatePermutations(int m) {
            if (m == 1) {
                if (getCurrentBeauty() % k == 0) {
                    beautyCount++;
                }
            } else {
                for (int i = 0; i < m-1; i++) {
                    generatePermutations(m - 1);
                    if(m % 2 == 0) {
                        swap(i, m-1);
                    } else {
                        swap(0, m-1);
                    }
                }
                generatePermutations(m - 1);
            }
        }
    }

    public static void task5(Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Permutation permutation = new Permutation(n, k);
        permutation.generatePermutations(n);
        System.out.println(permutation.beautyCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        task5(scanner);
    }
}
