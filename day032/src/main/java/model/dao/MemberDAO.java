package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.MemberDTO;
import model.util.JDBCUtil;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private static final String SELECTALL = "SELECT * FROM MEMBER";
	private static final String SELECTONE_LOGIN = "SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	private static final String SELECTONE_USERINFO = "SELECT * FROM MEMBER WHERE MID=? ";

	private static final String INSERT = "INSERT INTO MEMBER VALUES(?,?,?)";
	private static final String UPDATE_NAME = "UPDATE MEMBER SET NAME=? WHERE MID=?";
	private static final String DELETE = "DELETE FROM MEMBER WHERE MID=?";

	public ArrayList<MemberDTO> selectAll(MemberDTO memberDTO) {
		ArrayList<MemberDTO> datas = new ArrayList<MemberDTO>();

		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SELECTALL);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberDTO data = new MemberDTO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
				datas.add(data);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}

	public MemberDTO selectOne(MemberDTO memberDTO) {
		MemberDTO data = null;

		conn = JDBCUtil.connect();
		if (memberDTO.getSearchCondition().equals("login")) {
			try {
				pstmt = conn.prepareStatement(SELECTONE_LOGIN);
				pstmt.setString(1, memberDTO.getMid());
				pstmt.setString(2, memberDTO.getMpw());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					data = new MemberDTO();
					data.setMid(rs.getString("MID"));
					data.setName(rs.getString("NAME"));
					data.setMpw(rs.getString("MPW"));
				}

				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		} else if (memberDTO.getSearchCondition().equals("userinfo")) {
			try {
				pstmt = conn.prepareStatement(SELECTONE_USERINFO);
				pstmt.setString(1, memberDTO.getMid());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					data = new MemberDTO();
					data.setMid(rs.getString("MID"));
					data.setName(rs.getString("NAME"));
					data.setMpw(rs.getString("MPW"));
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
			pstmt.setString(1, memberDTO.getMid());
			pstmt.setString(2, memberDTO.getMpw());
			pstmt.setString(3, memberDTO.getName());
			int rs = pstmt.executeUpdate();
			if (rs <= 0) {
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
		try {
			pstmt = conn.prepareStatement(UPDATE_NAME);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getMid());
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

	public boolean delete(MemberDTO memberDTO) {

		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1, memberDTO.getMid());
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
}
