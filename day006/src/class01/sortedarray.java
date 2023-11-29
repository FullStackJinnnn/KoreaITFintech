package class01;

public class sortedarray {
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 100;
		arr[1] = 5;
		arr[2] = 60;
		arr[3] = 1000;
		arr[4] = 30;

		for (int i = 1; i < arr.length; i++) {
			int pivot = arr[i]; // 기준값
			System.out.println(arr[i]);
			System.out.println();
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					//System.out.println("pivot값 확인 : " + pivot);
					arr[j + 1] = arr[j];
					arr[j] = pivot;
					System.out.println(arr[i]);
				}
			}
		}
		for (int datas : arr) {
			System.out.print(datas + " ");
		}
	//크기를 알고있으니 for문이 더좋다.
//			for(int i = 1; i < arr.length; i++) {
//			
//				int pivot = arr[i];
//		 
//				int j = i - 1;
//		 
//				// 타겟이 이전 원소보다 크기 전 까지 반복
//				while(j >= 0 && pivot < arr[j]) {
//					arr[j + 1] = arr[j];	// 이전 원소를 한 칸씩 뒤로 미룬다.
//					j--;
//				}
//		 
//			    arr[j + 1] = pivot;	
//			}
//			
//			for (int datas : arr) {
//			System.out.print(datas + " ");
//			}
		
	}
}
