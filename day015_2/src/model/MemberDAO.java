package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> datas;

	public MemberDAO() {
		datas = new ArrayList<MemberDTO>();

		MemberDTO admin = new MemberDTO();
		admin.setMid("admin");
		admin.setMpw("1234");
		admin.setName("관리자");
		datas.add(admin);
	}

	public ArrayList<MemberDTO> selectAll(MemberDTO memberDTO) {
		return datas;
	}

	public MemberDTO selectOne(MemberDTO memberDTO) {
		boolean flag = false;
		int i;
		for (int i = 0; i < datas.size(); i++) {
			if (!datas.get(i).getMid().equals(memberDTO.getMid())) {
				flag = true;
				break;
			}
			if (flag) {
				return null;
			}
		}
		return this.datas.get(i);
	}
	// 만약, null이 반환되면 ID가 중복되지않음!
	// null이 아닌것이 반환되면 회원이 있는것이므로 회원가입 불가능...

	public boolean insert(MemberDTO memberDTO) {
		try {
			MemberDTO data = new MemberDTO();
			data.setMid(memberDTO.getMid());
			data.setMpw(memberDTO.getMpw());
			data.setName(memberDTO.getName());
			this.datas.add(data);
		} catch (Exception e) {
			System.out.println("[로그] 알수없는 이슈발생!");
			return false;
		}
		return true;
	}

	public boolean update(MemberDTO memberDTO) {
		MemberDTO data = new MemberDTO();

		return false;
	}

	public boolean delete(MemberDTO memberDTO) {
		try {
			int i;
			for (i = 0; i < this.datas.size(); i++) {
				if (this.datas.get(i).getMid().equals(memberDTO.getMid())) {
					break;
				}
			}
			this.datas.remove(i);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
