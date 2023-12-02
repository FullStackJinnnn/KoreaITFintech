package class02;

class Pokemon {
	int lv =13;
	int exp =15;
	String name = "개굴";
	Pokemon(String n) {
		name = n;
	}
		void hello() {
		System.out.println(name+" Lv."+lv+"["+exp+"/100]");
		}
}

public class Test03 {
	public static void main(String[] args) {
		Pokemon picachu = new Pokemon("피카츄");
//		picachu.lv = 50;
		
//		picachu.exp = 99;
//		picachu.name = "피카츄";
		picachu.hello();
		
		Pokemon ggobugi = new Pokemon("파이리");
		ggobugi.lv = 158;
		ggobugi.exp = 0;
		ggobugi.name = "꼬부기";
		ggobugi.hello();
	}
}
//		defualt 값 --->>> 꼬부기, 0
//	Pokemon p = new Pokemon("피카츄",18); -> 피카츄 18
//	p.printInfo(); -> 피카츄 18
//    Pokemon p1 = new Pokemon("파이리");    -> 파이리 0
// 	p.printInfo(); -> 파이리 0
//    Pokemon p2 = new Pokemon()			  -> 꼬부기 0
//	p.printInfo(); -> 꼬부기 0