package itacademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int a;
	static int b;

	public static void main(String[] args) throws IOException {

		a = Integer.parseInt(br.readLine());
		int[] arr = new int[a];
		StringTokenizer stringtoken = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			arr[i] = Integer.parseInt(stringtoken.nextToken());
		}

		Arrays.sort(arr);

		b = Integer.parseInt(br.readLine());
		stringtoken = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int num = Integer.parseInt(stringtoken.nextToken());
			int lowIdx = 0;
			int highIdx = a -1;
			int midIdx = 0;
			boolean keynotfound = true;
			while (lowIdx <= highIdx) {

				midIdx = (lowIdx + highIdx) / 2;
//				if (i == arr[midIdx]) {
//					bw.write("1 ");
//					keynotfound = false;
//					break;
				if (num > arr[midIdx]) {
					lowIdx = midIdx + 1;
				} else if (num < arr[midIdx]) {
					highIdx = midIdx - 1;
				} else {
					bw.write("1 ");
					keynotfound = false;
					break;
				}
			}
			if (keynotfound) {
				bw.write("0 ");
			}
		}
		bw.close();
		br.close();

	}
}