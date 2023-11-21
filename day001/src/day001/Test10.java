package day001;

public class Test10 {
	public static void main(String[] args) {
		int num = 50;
		
		if(num%2==0) {
				System.out.println(num + "은 (는)짝수입니다.");
		} else {
					System.out.println(num + "은 (는)홀수입니다.");
		}
	// ===============================================
		
		int h=12;
		int m=12;
		
		if (m<20 && h<1) {
			System.out.println(h+ "시" + m + "분의 1시간 20분전 시간은" + (10-h)+"시" + (60-m)+"분 입니다." );	
		}
		else if (m<20) {
		System.out.println(h+ "시" + m + "분의 1시간 20분전 시간은" + (h-2)+"시" + (60-m)+"분 입니다." );
		}
		else if (h<1) {
		System.out.println(h+ "시" + m + "분의 1시간 20분전 시간은" + (11-h)+"시" + (m-20)+"분 입니다." );
		}
		else {
		System.out.println(h+ "시" + m + "분의 1시간 20분전 시간은" + (h-1)+"시" + (m-20)+"분 입니다." );
		}
	
	
	}
}

	
	

