package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DogfoodDAO {

	private Connection conn; // DB와의 연결을 담당
	private PreparedStatement pstmt; // CRUD 수행을 담당

	private static final String SELECTALL = "SELECT * FROM DOGFOOD ORDER BY BID ASC";
	private static final String SELECTONE = "SELECT * FROM DOGFOOD WHERE PRICE=?";

	private static final String INSERT = "INSERT INTO DOGFOOD (BID, TITLE, PRICE) 0.VALUES ((SELECT NVL(MAX(BID), 10) + 1 FROM DOGFOOD), ?, ?)";
	private static final String UPDATE = "";
	private static final String DELETE = "";

	public ArrayList<DogfoodDTO> selectAll(DogfoodDTO bDTO) {

		ArrayList<DogfoodDTO> datas = new ArrayList<DogfoodDTO>();

		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				DogfoodDTO data = new DogfoodDTO();
				data.setBid(rs.getInt("BID"));
				data.setTitle(rs.getString("TITLE"));
				data.setPrice(rs.getString("PRICE"));
				datas.add(data);
			}
			rs.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;

	}

	public DogfoodDTO selectOne(DogfoodDTO bDTO) {
		return null;
	}

	public boolean insert(DogfoodDTO bDTO) {

		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, bDTO.getTitle());
			pstmt.setString(2, bDTO.getPrice());
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

	public boolean update(DogfoodDTO bDTO) {
		return false;
	}

	public boolean delete(DogfoodDTO bDTO) {
		return false;
	}

}
