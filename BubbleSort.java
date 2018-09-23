package chap06;

import java.util.Scanner;

public class BubbleSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort(int[] a, int n) { // ���� ���� ����
		for(int i = 0; i < n; i++) {
			int exchange = 0;
			for(int j = n-1; j > i; j--) {
				if(a[j-1] > a[j]) {
					swap(a, j-1, j);
					exchange++;
				}
			}
			if(exchange == 0) break;	 // �н��� ��ȯ�� �̷������ �ʾ����� ����
		}
	}
	
	static void bubbleSort2(int[] a, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(a[j] > a[j+1]) 
					swap(a, j, j+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("���� ���� 1");
		System.out.print("��� �� �Է� : ");
		
		int n = stdIn.nextInt();
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}
		
		bubbleSort2(a, n);
		
		for(int i = 0; i < n; i++) {
			System.err.print(a[i] + " ");
		}
	}
}
