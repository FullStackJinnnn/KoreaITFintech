package class01;

public class Test01 {
	public static void main(String[] args) {
		//우상단직각삼각형은 결국 5X5로 찍은것이다.
		
		for(int a=0; a<5;a++) {
			for(int i=0;i<5;i++) {
				if(i<a) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
			
		}
	}
}

//상위코드에 대한 디버깅표

//a    a<5    i    i<5     공백?
//0     T     0     T		F
//		   	  1	    T       F
//            2     T       F
//            3     T       F
//            4     T       F
//            5     F       F
//               
//1     T     0     T       T
//            1     T       F
//            2     T       F
//            3     T       F
//            4     F       F
//          
//2     T     0     T       T
//            1     T       T
//            2     T       F
//            3     F       F
     
//==> a와i관계를 살펴봤을때 공백이 T가 되는 조건은 일단 i==a 면 공백은 false이다
//==> a가 1일때 i는 0이면 공백은 True
//==> a가 2일때 i는 0,1이면 공백은 True
//==> 즉 i<a !
            
            
            
            
            
            