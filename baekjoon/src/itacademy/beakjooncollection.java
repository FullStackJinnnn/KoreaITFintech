package itacademy;

public class beakjooncollection {

	
//	package itacademy;
//
//	import java.io.BufferedReader;
//	import java.io.InputStreamReader;
//	import java.util.ArrayList;
//	import java.util.Arrays;
//	import java.util.HashSet;
//	import java.util.Iterator;
//	import java.util.List;
//	import java.util.Set;
//
//	public class Main {
//		public static void main(String[] args) throws Exception {
//			long beforeTime = System.currentTimeMillis();
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			StringBuilder sb = new StringBuilder();
//
//			String a = br.readLine();
//			String[] strs = br.readLine().split(" ");
//			Set<String> set = new HashSet<String>(Arrays.asList(strs));
//			a = br.readLine();
//			strs = br.readLine().split(" ");
//			List<String> list = new ArrayList<String>(Arrays.asList(strs));
//			Iterator<String> iter = set.iterator(); // Iterator 사용
//			for (int i = 0; i < list.size(); i++) {x
//				int cnt = 0;
//				while (iter.hasNext()) {
//					String b = iter.next();
//					if (list.get(i).equals(b)) {
//						sb.append("1").append(" ");
//						break;
//					}
//					cnt++;
//				}
//				iter = set.iterator();
//				if (cnt == set.size()) {
//					sb.append("0").append(" ");
//				}
//			}
//
//			System.out.println(sb);
//			long afterTime = System.currentTimeMillis(); 
//			long secDiffTime = (afterTime - beforeTime)/1000;
//			System.out.println("시간차이(m) : "+secDiffTime);
//		}
//
//1010

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		
//
//		int[][] arr = new int[30][30];
//		for (int i = 0; i < 30; i++) {
//			arr[0][i] = i + 1;
//		}
//		for (int i = 1; i < 30; i++) {
//			for (int j = 0; j < 30; j++) {
//				if (j <= i) {
//					arr[i][j] = 1;
//				} else {
//					arr[i][j] = arr[i][j - 1] + arr[i - 1][j - 1];
//				}
//			}
//		}
//		
//		
//		int T = Integer.parseInt(br.readLine());
//		int[] ans = new int[2];
//		for (int a = 0; a < T; a++) {
//			String[] temp = br.readLine().split(" ");
//
//		for (int i = 0; i < 2; i++) {
//			ans[i] = Integer.parseInt(temp[i]);
//		}
//
//			System.out.println(arr[ans[0] - 1][ans[1] - 1] + " ");
//
//		}
	}
}


	}


