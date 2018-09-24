import java.util.Scanner;

public class InsertionSort {
	static void insertionSort(int[] a, int n) {
		for(int i = 1; i < n; i++) {
			int temp = a[i];
			int j;
			
			for(j = i; j > 0 && a[j-1] > temp; j--) {
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("단순 삽입 정렬");
		System.out.print("요소 수 : ");
		int n  = stdIn.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		insertionSort(x, n);
		
		for(int i = 0; i < n; i++) {
			System.out.print(x[i] + " ");
		}
	}
}
