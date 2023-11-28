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
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > pivot) {
					arr[j + 1] = arr[j];
					arr[j] = pivot;
				}
			}
		}
		for (int datas : arr) {
			System.out.print(datas + " ");
		}
	}
}
