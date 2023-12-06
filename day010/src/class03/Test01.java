package class03;

import java.util.Scanner;

class LgTV implements TVimpl{
	  boolean power = false;
	  int sound = 0 ;
	  int chanel;

	@Override
	public void turnOnOff() {
		if(!this.power) {
			System.out.println("powerON");
			this.power = true;
		} else {
			System.out.println("powerOFF");
			this.power = false;
		}
		
	}

	@Override
	public void soundUpDown() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("볼륨 업 1 다운 2");
			int vol = sc.nextInt();
		if (vol == 1) {
			this.sound+=10;
		} else {
			this.sound-=10;
			if(this.sound<0) {
				this.sound =0;
			}
			
		}
		System.out.println("현재볼륨 :" +this.sound);
	}

	@Override
	public void chanelChange() {
		// TODO Auto-generated method stub
		this.chanel +=1;
		System.out.println("현재채널 :" +this.chanel);
	}
	
	
}






public class Test01 {
	public static void main(String[] args) {
	
		LgTV tv = new LgTV();
		while (true) {
		tv.turnOnOff();
		tv.soundUpDown();
		tv.chanelChange();
		}
	}
}
