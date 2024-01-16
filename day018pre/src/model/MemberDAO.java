package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> mdatas;

	public MemberDAO() {
		mdatas = new ArrayList<MemberDTO>();
		
		MemberDTO admin = new MemberDTO();
		admin.setMid("admin");
		admin.setMpw("1234");
		admin.setName("관리자");
		admin.setGrade("admin");
		mdatas.add(admin);
	}

	// ※ 사용하지않는 DAO의 CRUD(비즈니스 메서드,핵심 관심,핵심 로직)는
	// private으로 은닉했습니다.

	private ArrayList<MemberDTO> selectAll(MemberDTO memberDTO) {
		return mdatas;
	}

	public MemberDTO selectOne(MemberDTO memberDTO) {
		// 로그인
		// ID 중복 검사
		if (memberDTO.getSearchCondition().equals("중복검사")) {
			boolean flag = false;
			int i;
			for (i = 0; i < mdatas.size(); i++) {
				if (mdatas.get(i).getMid().equals(memberDTO.getMid())) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return null;
			}
			MemberDTO data = new MemberDTO();
			data.setMid(this.mdatas.get(i).getMid());
			data.setMpw(this.mdatas.get(i).getMpw());
			data.setName(this.mdatas.get(i).getName());
			data.setGrade(this.mdatas.get(i).getGrade());
			return data;
		} else if (memberDTO.getSearchCondition().equals("로그인")) {
			boolean flag = false;
			int i;
			for (i = 0; i < mdatas.size(); i++) {
				if (mdatas.get(i).getMid().equals(memberDTO.getMid())) {
					if (mdatas.get(i).getMpw().equals(memberDTO.getMpw())) {
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				return null;
			}
			MemberDTO data = new MemberDTO();
			data.setMid(this.mdatas.get(i).getMid());
			data.setMpw(this.mdatas.get(i).getMpw());
			data.setName(this.mdatas.get(i).getName());
			data.setGrade(this.mdatas.get(i).getGrade());
			return data;
		}
		
		else if (memberDTO.getSearchCondition().equals("관리자체크")) {
			boolean flag = false;
			int i;
			for (i = 0; i < mdatas.size(); i++) {
				if (mdatas.get(i).getMid().equals(memberDTO.getMid())) {
					if (mdatas.get(i).getGrade().equals("admin")) {
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				return null;
			}
			MemberDTO data = new MemberDTO();
			data.setMid(this.mdatas.get(i).getMid());
			data.setMpw(this.mdatas.get(i).getMpw());
			data.setName(this.mdatas.get(i).getName());
			data.setGrade(this.mdatas.get(i).getGrade());
			return data;
		}
		return null;
	}

	public boolean insert(MemberDTO memberDTO) {
		// 회원가입
		this.mdatas.add(memberDTO);
		return false;
	}

	public boolean update(MemberDTO memberDTO) {
		// 비밀번호변경
		boolean flag = false;
		for (int i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getMid().equals(memberDTO.getMid())) {
				mdatas.get(i).setMpw(memberDTO.getMpw());
				flag = true;
				break;
			}

		}
		if (!flag) {
			return false;
		}
		return true;
	}

	public boolean delete(MemberDTO memberDTO) {
		// 회원탈퇴
		boolean flag = false;
		int i;
		for (i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getMid().equals(memberDTO.getMid())) {
				flag = true;
				break;
			}
		}
		mdatas.remove(i);
		if (!flag) {
			return false;
		}
		return true;
	}
}
