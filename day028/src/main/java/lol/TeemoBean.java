package lol;

public class TeemoBean {

	private String mid;
	private String db;
	private String msg;

	public TeemoBean() {

		// TODO Auto-generated constructor stub
	}

	public boolean checkID(String mid) {
		if (mid == null) {
			this.msg = "입력안함";
			return false;
		} else if (mid.equals("teemo")) {
			this.msg = "중복아이디";
			return false;
		} 
		else {
			this.msg = "아이디 사용 가능~";
			this.db = this.mid;
			return true;
		}
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = "teemo";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}