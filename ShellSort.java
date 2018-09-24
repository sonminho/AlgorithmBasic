import java.util.Scanner;

public class ShellSort {
	static void shellSort(int[] a, int n) {
		for(int h = n/2; h > 0; h /= 2) {
			for(int i = h; i < n; i++) {
				int j;
				int temp = a[i];
				for(j = i - h; j >= 0 && a[j] > temp; j -= h) {
					a[j + h] = a[j];
				}
				a[j + h] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("셸 정렬 1");
		System.out.print("요소 수 : ");
		
		int n = stdIn.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		shellSort(x, n);
		
		for(int i = 0; i < n; i++) {
			System.out.print(x[i] + " ");
		}
	}
}
