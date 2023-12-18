package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> mdatas;
	public MemberDAO() {
		mdatas=new ArrayList<MemberDTO>();

		MemberDTO sample01=new MemberDTO();
		sample01.setMid("admin");
		sample01.setMpw("1234");
		sample01.setName("관리자");
		sample01.setGrade("ADMIN");
		mdatas.add(sample01);

		MemberDTO sample02=new MemberDTO();
		sample02.setMid("teemo");
		sample02.setMpw("1234");
		sample02.setName("작은티모");
		sample02.setGrade("USER");
		mdatas.add(sample02);
	}

	// ※ 사용하지않는 DAO의 CRUD(비즈니스 메서드,핵심 관심,핵심 로직)는
	//    private으로 은닉했습니다.

	private ArrayList<MemberDTO> selectAll(MemberDTO mDTO) {
		return null;
	}
	public MemberDTO selectOne(MemberDTO mDTO) {
		if(mDTO.getSearchCondition().equals("로그인")) {
			boolean flag=false;
			int i;
			for(i=0;i<mdatas.size();i++) {
				if(mdatas.get(i).getMid().equals(mDTO.getMid())) {
					System.out.println("[로그] ID 일치");
					if(mdatas.get(i).getMpw().equals(mDTO.getMpw())) {
						System.out.println("[로그] PW 일치");
						flag=true;
						break;
					}
				}
			}
			if(!flag) {
				return null;
			}
			return mdatas.get(i);
		}
		else { // ID중복검사
			boolean flag=false;
			int i;
			for(i=0;i<mdatas.size();i++) {
				if(mdatas.get(i).getMid().equals(mDTO.getMid())) {
					System.out.println("[로그] ID 일치");
					flag=true;
					break;
				}
			}
			if(!flag) {
				return null;
			}
			return mdatas.get(i);
		}
	}
	public boolean insert(MemberDTO mDTO) {
		try {
			MemberDTO data=new MemberDTO();
			data.setMid(mDTO.getMid());
			data.setMpw(mDTO.getMpw());
			data.setName(mDTO.getName());
			data.setGrade(mDTO.getGrade());
			mdatas.add(data);
		}catch(Exception e) {
			System.out.println("[로그] memberDAO.insert()에서 예외발생!");
			return false;
		}
		return true;
	}
	public boolean update(MemberDTO mDTO) {
		boolean flag=false;
		int i;
		for(i=0;i<mdatas.size();i++) {
			if(mdatas.get(i).getMid().equals(mDTO.getMid())) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return false;
		}
		mdatas.get(i).setMpw(mDTO.getMpw());
		return true;
	}
	public boolean delete(MemberDTO mDTO) {
		boolean flag=false;
		int i;
		for(i=0;i<mdatas.size();i++) {
			if(mdatas.get(i).getMid().equals(mDTO.getMid())) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			return false;
		}
		mdatas.remove(i);
		return true;
	}
}
