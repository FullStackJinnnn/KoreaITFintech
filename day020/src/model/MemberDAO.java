package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	private Connection conn; // DB와의 연결을 담당
	private PreparedStatement pstmt; // CRUD 수행을 담당

	private static final String SELECTALL="";
	private static final String SELECTONE="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";

	private static final String INSERT="";
	private static final String UPDATE="";
	private static final String DELETE="";
	
	private ArrayList<MemberDTO> selectAll(MemberDTO memberDTO){
		return null;
	}
	public MemberDTO selectOne(MemberDTO memberDTO){
		MemberDTO data=null;
		
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTONE);
			pstmt.setString(1, memberDTO.getMid());
			pstmt.setString(2, memberDTO.getMpw());
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				data=new MemberDTO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return data;
	}
	private boolean insert(MemberDTO memberDTO) {
		return false;
	}
	private boolean update(MemberDTO memberDTO) {
		return false;
	}
	private boolean delete(MemberDTO memberDTO) {
		return false;
	}

}




