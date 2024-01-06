package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ReportDAO {

	private Connection conn; // DB와의 연결을 담당
	private PreparedStatement pstmt; // CRUD 수행을 담당

	private static final String SELECTALL = "";
	private static final String SELECTONE = "";
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";

	public ArrayList<ReportDTO> selectAll(ReportDTO rDTO) {
		ArrayList<ReportDTO> datas = new ArrayList<ReportDTO>();

		return datas;
	}

	public ReportDTO selectOne(ReportDTO rDTO) {
		ReportDTO data = null;

		return data;
	}

	public boolean update(ReportDTO rDTO) {

		return false;
	}
	

	private boolean delete(ReportDTO rDTO) {
		
		return false;
	}

	private boolean insert(ReportDTO rDTO) {
		
		return false;
	}

}
