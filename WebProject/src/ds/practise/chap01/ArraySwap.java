package ds.practise.chap01;

public class ArraySwap {
	public static final int N = 5;

	public static void main(String args[]) {
		int ar[][] = new int[][] { 
				{ 1, 2, 3, 4, 5 }, 
				{ 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		System.out.println("Double dimensional array before rotate:");
		printArray(ar);

		int temp1, temp2;
		for (int i = 0; i < N / 2; i++) {
			int topLeftIndex = (N + 1) * i;  //0
			int topRightIndex = (N - 1) * (i + 1); //4
			int bottomLeftIndex = (N * N) - 1 - ((N - 1) * (i + 1)); //20
			int bottomRightIndex = N * N - 1 - i * (N + 1);
			int k = topLeftIndex; //0
			temp1 = ar[k / N][k % N]; //ar[0][0]
			
			do {
				if (i % 2 == 0) { 
					if (k < topRightIndex) { // 0<4, 1<4, 2<4, 3<4, 4<4 - false
						k++; //k=1, k=2, k=3, k=4
					} else if (k > bottomLeftIndex) { // 4>20
						k--;
					} else if (k % N == i) { //4 == 0
						k -= N;
					} else if (k % N == (N - i - 1)) { //4 == 4
						k += N; // k = 9
					}
				} else {
					if (k > topLeftIndex && k <= topRightIndex) {
						k--;
					} else if (k < bottomRightIndex && k >= bottomLeftIndex) {
						k++;
					} else if (k % N == i) {
						k += N;
					} else if (k % N == (N - i - 1)) {
						k -= N;
					}
				}
				temp2 = ar[k / N][k % N];  // temp2 = ar[0][1] {temp2 = 2}, temp2 = ar[1][4] 
				ar[k / N][k % N] = temp1; // a[0][1] = temp1 {a[0][1] = 1}
				temp1 = temp2;  // temp1 = temp2; {temp1 = 2}
			} while (k != topLeftIndex); // 1 != 0
		}
		System.out.println("Double dimensional array after rotate:");
		printArray(ar);
	}

	public static void printArray(int ar[][]) {
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				System.out.printf(" %2d ", ar[a][b]);
			}
			System.out.println();
		}
	}
}
