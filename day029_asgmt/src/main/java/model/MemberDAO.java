package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	private Connection conn; // DB와의 연결을 담당
	private PreparedStatement pstmt; // CRUD 수행을 담당

	private static final String SELECTALL = "";
	// 로그인성공시 닉네임을 세션에 저장하기 위해 닉네임만 가져온다!
	private static final String SELECTONE_LOGIN = "SELECT NICKNAME FROM MEMBER WHERE ID=? AND PW=?";
	private static final String SELECTONE_USERCHECK = "SELECT ID, PW, NAME, NICKNAME, BIRTHDAY, PH, PROFILE, GRADE FROM MEMBER WHERE NICKNAME=?";

	private static final String INSERT = "INSERT INTO MEMBER (MEMBERNUM,ID, PW, NAME, NICKNAME, BIRTH, PH, PROFILE, GRADE) VALUES((SELECT NVL(MAX(MEMBERNUM),0)+1 FROM MEMBER),?,?,?,?,?,?,?,'신입')";
	private static final String UPDATE_WITHDRAW = "UPDATE MEMBER SET GRADE='탈퇴' WHERE NICKNAME=? AND PW=?";
	private static final String UPDATE_PW = "UPDATE MEMBER SET PW=? WHERE NICKNAME=?";
	private static final String UPDATE_NICKNAME = "UPDATE MEMBER SET NICKNAME=? WHERE NICKNAME=?";
	private static final String UPDATE_PH = "UPDATE MEMBER SET PH=? WHERE ID=?";
	private static final String DELETE = "DELETE FROM MEMBER WHERE NICKNAME=? PW=?";

	public ArrayList<MemberDTO> selectAll(MemberDTO memberDTO) {
		ArrayList<MemberDTO> datas = new ArrayList<MemberDTO>();

		return datas;
	}

	public MemberDTO selectOne(MemberDTO memberDTO) {
		MemberDTO data = null;
		conn = JDBCUtil.connect();
		if (memberDTO.getSearchCondition().equals("login")) {

			try {
				pstmt = conn.prepareStatement(SELECTONE_LOGIN);
				pstmt.setString(1, memberDTO.getId());
				pstmt.setString(2, memberDTO.getPw());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					data = new MemberDTO();
					data.setNickname(rs.getString("NICKNAME"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}

		else if (memberDTO.getSearchCondition().equals("userCheck")) {
			try {
				pstmt = conn.prepareStatement(SELECTONE_USERCHECK);
				pstmt.setString(1, memberDTO.getNickname());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					data = new MemberDTO();
					data.setId(rs.getString("ID"));
					data.setPw(rs.getString("PW"));
					data.setName(rs.getString("NAME"));
					data.setNickname(rs.getString("NICKNAME"));
					data.setPh(rs.getInt("PH"));
					data.setProfile(rs.getString("PROFILE"));
					
					data.setGrade(rs.getString("GRADE"));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}

		return data;

	}

	public boolean insert(MemberDTO memberDTO) {
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPw());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getNickname());
			pstmt.setDate(5, memberDTO.getBirthday());
			System.out.println(memberDTO.getBirthday());
			pstmt.setInt(6, memberDTO.getPh());
			pstmt.setString(7, memberDTO.getProfile());

			int result = pstmt.executeUpdate();
			if (result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

	public boolean update(MemberDTO memberDTO) {
		conn = JDBCUtil.connect();
		if (memberDTO.getSearchCondition().equals("withdraw")) {
			try {
				pstmt = conn.prepareStatement(UPDATE_WITHDRAW);
				pstmt.setString(1, memberDTO.getPw());
				pstmt.setString(2, memberDTO.getNickname());
				int result = pstmt.executeUpdate();
				if (result <= 0) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		} else if (memberDTO.getSearchCondition().equals("updatePw")) {
			try {
				pstmt = conn.prepareStatement(UPDATE_PW);
				pstmt.setString(1, memberDTO.getPw());
				pstmt.setString(2, memberDTO.getNickname());
				int result = pstmt.executeUpdate();
				if (result <= 0) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		} else if (memberDTO.getSearchCondition().equals("updateNickname")) {
			try {
				pstmt = conn.prepareStatement(UPDATE_NICKNAME);
				pstmt.setString(1, memberDTO.getUpdateNickname());
				pstmt.setString(2, memberDTO.getNickname());
				int result = pstmt.executeUpdate();
				if (result <= 0) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		return true;
	}

	private boolean delete(MemberDTO memberDTO) {
		return false;
	}

}
