package class01;

public class Test03 {

	public static void main(String[] args) {
		
		int[] array = new int[5];
		array[0] = 7;
		array[1] = 5;
		array[2] = 9;
		array[3] = 2;
		array[4] = 1;
		
		
		
		for (int a=0; a<array.length-1; a++) {
			int minIdx = a;
			for (int i=a+1; i<array.length; i++) {
				if(array[minIdx]>array[i]) {
					minIdx =i;
				}			
			}
		int temp = array[a];
		array[a] = array[minIdx];
		array[minIdx]=temp;
		
		
		}
		
		for (int datas : array) {
			System.out.print(datas + " ");
		}
		
		
		
	}
	
}
