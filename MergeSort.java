import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {	
	static void mergeSort(int[] a, int[] buff, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			int bidx = 0;
			int bp = 0;
			int aidx = left;
			int idx;
			
			mergeSort(a, buff, left, mid);
			mergeSort(a, buff, mid+1, right);
			
			for(idx = left; idx <= mid; idx++) {
				buff[bidx++] = a[idx];
			}

			while(bp < bidx && idx <= right) {
				a[aidx++] = (buff[bp] > a[idx]) ? a[idx++] : buff[bp++];
			}
			
			while(bp < bidx) {
				a[aidx++] = buff[bp++];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int buff[] = new int[n];
		mergeSort(a, buff, 0, n-1);
		
		
		StringBuilder ans = new StringBuilder();
		
		for(int x : a)
			ans.append(x+"\n");
		
		System.out.println(ans);
	}
}
