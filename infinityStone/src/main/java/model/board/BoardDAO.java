package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	// 게시글 목록 전체 출력
	private static final String SELECTALL = "SELECT BOARD.BOARDNUM, MEMBER.MEMBERNUM, BOARD.CATEGORY, BOARD.TITLE, "
			+ "TO_CHAR(BOARD.BOARDDATE, 'YYYY-MM-DD') AS BOARDDATE, BOARD.STATE, BOARD.VIEWCOUNT, COMMEND.COMMENDNUM, MEMBER.NICKNAME, MEMBER.ID, "
			+ "COUNT(BOARD.BOARDNUM) AS CNT FROM BOARD "
			+ "JOIN MEMBER ON BOARD.MEMBERNUM = MEMBER.MEMBERNUM "
			+ "JOIN COMMEND ON BOARD.BOARDNUM = COMMEND.BOARDNUM WHERE CATEGORY = ? "
			+ "GROUP BY BOARD.BOARDNUM, MEMBER.MEMBERNUM, BOARD.CATEGORY, BOARD.TITLE, BOARD.BOARDDATE, "
			+ "BOARD.STATE, BOARD.VIEWCOUNT, COMMEND.COMMENDNUM, MEMBER.NICKNAME, MEMBER.ID "
			+ "ORDER BY BOARD.BOARDNUM DESC";
	// 조인한 게시판 테이블
	// 추천 테이블, 회원 테이블
	// 사용한 컬럼(보여줄 목록) : 게시글번호, 작성자번호(회원 테이블), 게시글 카테고리, 글제목, 게시글작성일, 게시글 상태, 조회수, 
	// 추천번호(추천테이블), 추천수(추천테이블), 회원 닉네임(회원테이블), 회원ID(회원 테이블), 카운트 함수 사용(추천수) - (추천 테이블)
	// 조건 게시글의 카테고리를 확인하여 전체 출력 ※ CATEGORY 별로 출력(CATEGORY에 값이 없으면 오류 발생 주의)
	
	// 게시글 검색 기능 - 제목으로 검색 
	private static final String SELECTALL_SEARCHTITLE = "SELECT BOARD.BOARDNUM, MEMBER.MEMBERNUM, BOARD.CATEGORY, "
			+ "BOARD.TITLE, TO_CHAR(BOARD.BOARDDATE, 'YYYY-MM-DD') AS BOARDDATE, BOARD.STATE, BOARD.VIEWCOUNT, COMMEND.COMMENDNUM, MEMBER.NICKNAME, "
			+ "MEMBER.ID, COUNT(BOARD.BOARDNUM) AS CNT FROM BOARD "
			+ "JOIN MEMBER ON BOARD.MEMBERNUM = MEMBER.MEMBERNUM "
			+ "JOIN COMMEND ON BOARD.BOARDNUM = COMMEND.BOARDNUM WHERE CATEGORY = ?  AND BOARD.TITLE LIKE '%'||?||'%'"
			+ "GROUP BY BOARD.BOARDNUM, MEMBER.MEMBERNUM, BOARD.CATEGORY, BOARD.TITLE, BOARD.BOARDDATE, "
			+ "BOARD.STATE, BOARD.VIEWCOUNT, COMMEND.COMMENDNUM, MEMBER.NICKNAME, MEMBER.ID "
			+ "ORDER BY BOARD.BOARDNUM DESC";	
	
	// 게시글 검색 기능 - 작성자(NICKNAME)로 검색
	private static final String SELECTALL_SEARCHWRITER = "SELECT BOARD.BOARDNUM, MEMBER.MEMBERNUM, BOARD.CATEGORY, "
			+ "BOARD.TITLE, TO_CHAR(BOARD.BOARDDATE, 'YYYY-MM-DD') AS BOARDDATE, BOARD.STATE, BOARD.VIEWCOUNT, COMMEND.COMMENDNUM, MEMBER.NICKNAME, "
			+ "MEMBER.ID, COUNT(BOARD.BOARDNUM) AS CNT FROM BOARD "
			+ "JOIN MEMBER ON BOARD.MEMBERNUM = MEMBER.MEMBERNUM "
			+ "JOIN COMMEND ON BOARD.BOARDNUM = COMMEND.BOARDNUM WHERE CATEGORY = ? "
			+ "AND MEMBER.NICKNAME LIKE '%'||?||'%'"
			+ "GROUP BY BOARD.BOARDNUM, MEMBER.MEMBERNUM, BOARD.CATEGORY, BOARD.TITLE, BOARD.BOARDDATE, "
			+ "BOARD.STATE, BOARD.VIEWCOUNT, COMMEND.COMMENDNUM, MEMBER.NICKNAME, MEMBER.ID "
			+ "ORDER BY BOARD.BOARDNUM DESC";	

	// 게시글 상세보기_ 리뷰, 판매글
	private static final String SELECTONE = "SELECT BOARD.BOARDNUM, MEMBER.MEMBERNUM, MEMBER.NICNAME, "
			+ "MEMBER.ID, BOARD.CATEGORY, BOARD.TITLE, BOARD.CONTENTS, TO_CHAR(BOARD.BOARDDATE, 'YYYY-MM-DD') AS BOARDDATE, BOARD.PRICE, "
			+ "BOARD.IMAGE, BOARD.PRODUCTCATEGORY, BOARD.COMPANY, BOARD.STATE, BOARD.VIEWCOUNT, "
			+ "COMMEND.COMMENDNUM, COUNT(BOARD.BOARDNUM) AS CNT FROM BOARD "
			+ "JOIN MEMBER ON BOARD.MEMBERNUM = MEMBER.MEMBERNUM "
			+ "JOIN COMMEND ON BOARD.BOARDNUM = COMMEND.BOARDNUM "
			+ "WHERE BOARD.BOARDNUM = ? GROUP BY BOARD.BOARDNUM, MEMBER.MEMBERNUM, MEMBER.NICNAME, "
			+ "MEMBER.ID, BOARD.CATEGORY, BOARD.TITLE, BOARD.CONTENTS, BOARD.BOARDDATE, "
			+ "BOARD.PRICE, BOARD.IMAGE, BOARD.PRODUCTCATEGORY,  "
			+ "BOARD.COMPANY, BOARD.STATE, BOARD.VIEWCOUNT";
	// 조인한 게시판 테이블
	// 추천 테이블, 회원 테이블
	// 사용한 컬럼(보여줄 목록) : 게시글번호, 작성자번호(회원 테이블), 회원 닉네임(회원테이블), 회원ID(회원 테이블), 게시글 카테고리, 글제목,
	// 게시글 내용, 게시글 작성일, 상품 가격, 게시글 이미지, 상품 종류, 상품제조사, 게시글 상태, 조회수, 
	// 추천번호(추천테이블), 추천수(추천테이블), 카운트 함수 사용(추천수) - (추천 테이블)

	
	// 게시글 상세보기_ 이미지
	private static final String SELECTONE_IMAGE = "SELECT BOARD.BOARDNUM, MEMBER.MEMBERNUM, MEMBER.NICNAME, "
			+ "MEMBER.ID, BOARD.CATEGORY, BOARD.TITLE, BOARD.CONTENTS, TO_CHAR(BOARD.BOARDDATE, 'YYYY-MM-DD') AS BOARDDATE, BOARD.IMAGE, "
			+ "BOARD.VIEWCOUNT, COMMEND.COMMENDNUM, COMMEND.COMMENDNUM, "
			+ "COUNT(BOARD.BOARDNUM) AS CNT FROM BOARD "
			+ "JOIN MEMBER ON BOARD.MEMBERNUM = MEMBER.MEMBERNUM "
			+ "JOIN COMMEND ON BOARD.BOARDNUM = COMMEND.BOARDNUM "
			+ "AND MEMBER.MEMBERNUM = COMMEND.MEMBERNUM WHERE BOARD.BOARDNUM = ? "
			+ "GROUP BY BOARD.BOARDNUM, MEMBER.MEMBERNUM, MEMBER.NICNAME, MEMBER.ID, "
			+ "BOARD.CATEGORY, BOARD.TITLE, BOARD.CONTENTS, BOARD.BOARDDATE, BOARD.IMAGE, "
			+ "BOARD.VIEWCOUNT, COMMEND.COMMENDNUM";
	// 조인한 게시판 테이블
	// 추천 테이블, 회원 테이블
	// 사용한 컬럼(보여줄 목록) : 게시글번호, 작성자번호(회원 테이블), 회원 닉네임(회원테이블), 회원ID(회원 테이블), 게시글 카테고리, 글제목,
	// 게시글 내용, 게시글 작성일, 게시글 이미지, 조회수, 
	// 추천번호(추천테이블), 추천수(추천테이블), 카운트 함수 사용(추천수) - (추천 테이블)


	// 게시글 작성
	private static final String INSERT = "INSERT INTO BOARD VALUES((SELECT NVL(MAX(BOARDNUM),0)+1 FROM BOARD),?,?,?,?,?,?,?,?,?,?)";
	// 게시글 수정
	private static final String UPDATE = "UPDATE BOARD SET TITLE=?,  CONTENTS=?,  PRICE=?,  IMAGE=?,  COMPANY=?,  STATE=? WHERE BOARDNUM=?";
	// 조회수 증가
	private static final String UPDATE_PAGE = "UPDATE BOARD SET VIEWCOUNT = (VIEWCOUNT+1) WHERE BOARDNUM=?";
	// 게시글 삭제
	private static final String DELETE = "DELETE FROM BOARD WHERE BOARDNUM = ?";

	// 게시글 목록 출력
	public ArrayList<BoardDTO> selectAll(BoardDTO boardDTO) {
		ArrayList<BoardDTO> datas = new ArrayList<BoardDTO>();
		BoardDTO data = null;
		conn = JDBCUtil.connect();

		if (boardDTO.getCategory().equals("판매")) {
			try {
				if (boardDTO.getSearchCondision().equals("제목")) {
					pstmt = conn.prepareStatement(SELECTALL_SEARCHTITLE);
					pstmt.setString(1, boardDTO.getTitle());
				} else if (boardDTO.getSearchCondision().equals("작성자")) {
					pstmt = conn.prepareStatement(SELECTALL_SEARCHWRITER);
					pstmt.setString(1, boardDTO.getNickname());
				} else {
					pstmt = conn.prepareStatement(SELECTALL);
				}
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					data = new BoardDTO();
					data.setBoardNum(rs.getInt("BOARDNUM"));
					data.setMemberNum(rs.getInt("MEMBERNUM"));
					data.setTitle(rs.getString("TITLE"));
					data.setCategory(rs.getString("CATEGORY"));
					data.setBoardDate(rs.getString("BOARDDATE"));
					data.setState(rs.getString("STATE"));
					data.setViewCount(rs.getInt("VIEWCOUNT"));
					data.setCommendNum(rs.getInt("COMMENDNUM"));
					data.setNickname(rs.getString("NICNAME"));
					data.setID(rs.getString("ID"));
					data.setCommendCount(rs.getInt("COMMENDCOUNT"));
					datas.add(data);
				}

				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		} else if (boardDTO.getCategory().equals("리뷰")) {
			try {
				if (boardDTO.getSearchCondision().equals("제목")) {
					pstmt = conn.prepareStatement(SELECTALL_SEARCHTITLE);
					pstmt.setString(1, boardDTO.getTitle());
				} else if (boardDTO.getSearchCondision().equals("작성자")) {
					pstmt = conn.prepareStatement(SELECTALL_SEARCHWRITER);
					pstmt.setString(1, boardDTO.getNickname());
				} else {
					pstmt = conn.prepareStatement(SELECTALL);
				}
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					data = new BoardDTO();
					data.setBoardNum(rs.getInt("BOARDNUM"));	
					data.setMemberNum(rs.getInt("MEMBERNUM"));
					data.setTitle(rs.getString("TITLE"));
					data.setCategory(rs.getString("CATEGORY"));
					data.setBoardDate(rs.getString("BOARDDATE"));
					data.setState(rs.getString("STATE"));
					data.setViewCount(rs.getInt("VIEWCOUNT"));
					data.setCommendNum(rs.getInt("COMMENDNUM"));
					data.setNickname(rs.getString("NICNAME"));
					data.setID(rs.getString("ID"));
					data.setCommendCount(rs.getInt("COMMENDCOUNT"));
					datas.add(data);
				}

				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		} else {
			try {
				if (boardDTO.getSearchCondision().equals("제목")) {
					pstmt = conn.prepareStatement(SELECTALL_SEARCHTITLE);
					pstmt.setString(1, boardDTO.getTitle());
				} else if (boardDTO.getSearchCondision().equals("작성자")) {
					pstmt = conn.prepareStatement(SELECTALL_SEARCHWRITER);
					pstmt.setString(1, boardDTO.getNickname());
				} else {
					pstmt = conn.prepareStatement(SELECTALL);
				}
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					data = new BoardDTO();
					data.setBoardNum(rs.getInt("BOARDNUM"));
					data.setMemberNum(rs.getInt("MEMBERNUM"));
					data.setTitle(rs.getString("TITLE"));
					data.setCategory(rs.getString("CATEGORY"));
					data.setBoardDate(rs.getString("BOARDDATE"));
					data.setState(rs.getString("STATE"));
					data.setViewCount(rs.getInt("VIEWCOUNT"));
					data.setCommendNum(rs.getInt("COMMENDNUM"));
					data.setNickname(rs.getString("NICNAME"));
					data.setID(rs.getString("ID"));
					data.setCommendCount(rs.getInt("COMMENDCOUNT"));
					datas.add(data);
				}

				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}

		return datas;

	}
// 게시글 상세보기
	public BoardDTO selectOne(BoardDTO boardDTO) {
		// 조회수 증가하기 위해 조회수 증가 호출(조회수 증가를 위해 updatePage에 조회수 증가를 삽입해야한다.)
		update(boardDTO);
		
		BoardDTO data = null;
		conn = JDBCUtil.connect();
		if (boardDTO.getCategory().equals("이미지")) {
			try {
				pstmt = conn.prepareStatement(SELECTONE_IMAGE);
				pstmt.setInt(1, boardDTO.getBoardNum());
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					data = new BoardDTO();
					data.setBoardNum(rs.getInt("BOARDNUM"));
					data.setMemberNum(rs.getInt("MEMBERNUM"));
					data.setNickname(rs.getString("NICNAME"));
					data.setCategory(rs.getString("CATEGORY"));
					data.setTitle(rs.getString("TITLE"));
					data.setContents(rs.getString("CONTENTS"));
					data.setBoardDate(rs.getString("BOARDDATE"));
					data.setImage(rs.getString("IMAGE"));
					data.setState(rs.getString("STATE"));
					data.setViewCount(rs.getInt("VIEWCOUNT"));
					data.setCommendNum(rs.getInt("COMMENDNUM"));
					data.setID(rs.getString("ID"));
					data.setCommendCount(rs.getInt("COMMENDCOUNT"));
					data.setReviewNum(rs.getInt("REVIEWNUM"));
				} else {
					return null;
				}

				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		} else {
			try {
				pstmt = conn.prepareStatement(SELECTONE);
				pstmt.setInt(1, boardDTO.getBoardNum());
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					data = new BoardDTO();
					data.setBoardNum(rs.getInt("BOARDNUM"));
					data.setMemberNum(rs.getInt("MEMBERNUM"));
					data.setNickname(rs.getString("NICNAME"));
					data.setCategory(rs.getString("CATEGORY"));
					data.setTitle(rs.getString("TITLE"));
					data.setContents(rs.getString("CONTENTS"));
					data.setBoardDate(rs.getString("BOARDDATE"));
					data.setPrice(rs.getInt("PRICE"));
					data.setImage(rs.getString("IMAGE"));
					data.setProductcategory(rs.getString("PRODUCTCATEGORY"));
					data.setCompany(rs.getString("COMPANY"));
					data.setState(rs.getString("STATE"));
					data.setViewCount(rs.getInt("VIEWCOUNT"));
					data.setCommendNum(rs.getInt("COMMENDNUM"));
					data.setID(rs.getString("ID"));
					data.setCommendCount(rs.getInt("COMMENDCOUNT"));
					data.setReviewNum(rs.getInt("REVIEWNUM"));
				} else {
					return null;
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
	// 게시글 작성
	  public boolean insert(BoardDTO boardDTO) {
	      conn=JDBCUtil.connect();
	      try {
	         pstmt=conn.prepareStatement(INSERT);
	         pstmt.setInt(1, boardDTO.getMemberNum());
	         pstmt.setString(2, boardDTO.getCategory());
	         pstmt.setString(3, boardDTO.getTitle());
	         pstmt.setString(4, boardDTO.getContents());
	         pstmt.setInt(5, boardDTO.getPrice());
	         pstmt.setString(6, boardDTO.getImage());
	         pstmt.setString(7, boardDTO.getProductcategory());
	         pstmt.setString(8, boardDTO.getCompany());
	         pstmt.setString(9, boardDTO.getState());
	         pstmt.setInt(10, boardDTO.getViewCount());
	         pstmt.setInt(11, boardDTO.getCommendNum());
	         int rs=pstmt.executeUpdate();
	         if(rs<=0) {
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


	  // 조회수 증가와 게시글 수정
	  public boolean update(BoardDTO boardDTO) {
	      conn=JDBCUtil.connect();
	     // 조회수 증가
	      if (boardDTO.getUpdatePage().equals("조회수증가")) {
	    	  try {
			         pstmt=conn.prepareStatement(UPDATE_PAGE);
			         pstmt.setInt(1, boardDTO.getBoardNum());
			         int rs=pstmt.executeUpdate();
			         if(rs<=0) {
			            return false;
			         }
			      } catch (SQLException e) {
			         e.printStackTrace();
			         return false;
			      } finally {
			         JDBCUtil.disconnect(pstmt, conn);
			      }
		} else {	// 게시글 수정
			 try {
		         pstmt=conn.prepareStatement(UPDATE);
		         pstmt.setString(1, boardDTO.getTitle());
		         pstmt.setString(2, boardDTO.getContents());
		         pstmt.setInt(3, boardDTO.getPrice());
		         pstmt.setString(4, boardDTO.getImage());
		         pstmt.setString(5, boardDTO.getState());
		         int rs=pstmt.executeUpdate();
		         if(rs<=0) {
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
	  
	// 게시글 삭제
	public boolean delete(BoardDTO boardDTO) {
		conn=JDBCUtil.connect();
	      try {
	         pstmt=conn.prepareStatement(DELETE);
	         pstmt.setInt(1, boardDTO.getBoardNum());
	         int rs=pstmt.executeUpdate();
	         if(rs<=0) {
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
