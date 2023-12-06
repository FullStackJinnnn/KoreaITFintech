package class02;

class LgTV implements TVimp1 {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		
	}
	
}

//인터페이스!! 클래스아님
public interface TVimp1 {
	void turnOn(); //메서드 바디가 없다
	void turnOff(); //추상 메서드
	abstract void soundUp();  //메서드 오버라이딩 강제
	public abstract void soundDown(); // public abstract 가 숨어있다.
	// 안써도 자동추가
	
	
}
