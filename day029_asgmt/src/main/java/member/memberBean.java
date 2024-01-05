package member;

import java.util.ArrayList;

import model.MemberDTO;

public class memberBean {

	private String mPicUrl;
	private String mNickname;
	private String mId;
	private String mPw;
	private String mPhonenumber;
	private String mGrade;
	
	 ArrayList<memberBean> datas=new ArrayList<memberBean>();
	  
	   
	   public void dataAdd(memberBean mMODEL) {
			memberBean data = new memberBean();
			data.setmId(mMODEL.getmId());
			data.setmPw(mMODEL.getmPw());
			data.setmNickname(mMODEL.getmNickname());
			this.datas.add(data);
	   }
	 

	
	
	public String getmPicUrl() {
		return mPicUrl;
	}
	public void setmPicUrl(String mPicUrl) {
		this.mPicUrl = mPicUrl;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmPhonenumber() {
		return mPhonenumber;
	}
	public void setmPhonenumber(String mPhonenumber) {
		this.mPhonenumber = mPhonenumber;
	}
	public String getmGrade() {
		return mGrade;
	}
	public void setmGrade(String mGrade) {
		this.mGrade = mGrade;
	}
	
}
