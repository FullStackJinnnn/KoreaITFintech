package class01;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
    	// 10개의 난수를 저장 받을 변수를 생성
		int[] arr = new int[10];
      
		// 1 ~ 5 까지의 난수 10개를 0 부터 9 인덱스에 저장 받고
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		
        	// 값이 잘 들어갔나 확인
		System.out.println(Arrays.toString(arr));
		
        	// 중복이 배제된 값을 저장받을 배열
		int[] temp = new int[5];
      	
            // 중복이 배제된 회수
		int count = 0;
		
        	// 중복을 걸러주는 부분
		for(int i = 0; i < arr.length; i++){
			boolean flag = false;
			for(int j = 0; j < temp.length; j++){
				if(arr[i] == temp[j]){
					flag= true;
					System.out.println(Arrays.toString(temp));
				}
			}
            	// 중복이 배제된 값이 저장.
			if(!flag){
				temp[count++] = arr[i];
			}
		}

		// 0을 배제 해주기 위한 부분
		int[] result = new int[count];
		for(int i = 0; i < result.length; i++){
			result[i] = temp[i];
		}
		System.out.println(Arrays.toString(result));
	}
}
