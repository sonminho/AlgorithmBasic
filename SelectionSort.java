import java.util.Scanner;

public class SelectionSort {
	static void selectionSort(int[] a, int n) {
		for(int i = 1; i < n; i++) {
			int temp = a[i];
			int j;
			
			for(j = 0; j < i && temp > a[j]; j++) 
			
			a[i] = a[j];
			a[j] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("선택 정렬");
		System.out.print("요소 수 : ");
		
		int n = stdIn.nextInt();
		int x[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		selectionSort(x, n);
		
		for(int i = 0; i < n; i++) {
			System.out.print(x[i] + " ");
		}
	}
}
