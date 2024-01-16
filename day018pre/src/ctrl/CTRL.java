package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberDTO;
import model.ProductDAO;
import model.ProductDTO;
import view.AdminVIEW;
import view.CommonVIEW;
import view.LoginVIEW;
import view.LogoutVIEW;
import view.UserVIEW;

public class CTRL {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private AdminVIEW adminVIEW;
	private UserVIEW userVIEW;
	private CommonVIEW commonVIEW;
	private LoginVIEW loginVIEW;
	private LogoutVIEW logoutVIEW;
	private ProductDTO pDTO;
	private ArrayList<ProductDTO> pDTOarr;
	private MemberDTO presentUser;

	public CTRL() {
		mDAO = new MemberDAO();
		pDAO = new ProductDAO();
		adminVIEW = new AdminVIEW();
		userVIEW = new UserVIEW();
		commonVIEW = new CommonVIEW();
		loginVIEW = new LoginVIEW();
		logoutVIEW = new LogoutVIEW();
		pDTO = new ProductDTO();
		pDTOarr = new ArrayList<ProductDTO>();
		presentUser = null;

	}

	public void start() {
		while (true) {
			if (presentUser != null) {
				if (presentUser.getGrade().equals("admin")) {
					commonVIEW.printMenu();
					userVIEW.printMenu();
					adminVIEW.printMenu();
					logoutVIEW.printMenu();
					loginVIEW.printMenu();
				}
			} else {
			commonVIEW.printMenu();
			userVIEW.printMenu();
			logoutVIEW.printMenu();
			loginVIEW.printMenu();
			}
			int action = commonVIEW.inputAction();

			// ※ 모든 action 수행은 자격이 있다고 가정하고 하겠습니다.
			// ※ 즉, 별도의 인증 작업을 생략하겠습니다.

			if (action == 0) {
				break;
			} else if (action == 1) {
				// 모델아, 전체목록주라!
				// 받은것들 뷰에서 출력
				commonVIEW.printDatas(pDAO.selectAll(new ProductDTO()));
			} else if (action == 2) {
				ArrayList<ProductDTO> datas = new ArrayList<ProductDTO>();
				ProductDTO pDTO = new ProductDTO();
				pDTO.setSearchCondition("가격검색");
				pDTO.setMinPrice(commonVIEW.inputPrice());
				pDTO.setMaxPrice(commonVIEW.inputPrice());

				datas = pDAO.selectAll(pDTO);
				commonVIEW.printDatas(datas);

				// ※ 최저 → 최고 가격 순서로 입력을 잘 했다고 가정하고 하겠습니다.

				// 최저가격입력
				// 최고가격입력
				// 모델아, 가격검색목록주라!
				// 받은것들 뷰에서 출력

				/*
				 * int 최저가격=commonVIEW.inputPrice(); int 최고가격=commonVIEW.inputPrice();
				 * commonVIEW.printDatas(pDAO.selectAll(new ProductDTO()));
				 * 
				 * int 최저가격=commonVIEW.inputPrice(); int 최고가격=commonVIEW.inputPrice();
				 * ProductDTO pDTO=new ProductDTO(); pDTO.setPrice(최저가격); pDTO.setPrice(최고가격);
				 * commonVIEW.printDatas(pDAO.selectAll(pDTO));
				 */

			} else if (action == 3) {
				ProductDTO pDTO = new ProductDTO();
				int num = commonVIEW.inputPid();
				pDTO.setPid(num);
				pDTO = pDAO.selectOne(pDTO);
				if (pDTO == null) {
					commonVIEW.printFalse();
				}
				this.pDTOarr.add(pDTO);

			} else if (action == 4) {
				ProductDTO pDTO = new ProductDTO();
				pDTO.setSearchCondition("장바구니");
				for (int i = 0; i < this.pDTOarr.size(); i++) {
					pDTO.setPid(pDTOarr.get(i).getPid());
					pDAO.update(pDTO);
				}
				pDTOarr.clear();
			} else if (action == 5) {
				if (presentUser == null) {
					commonVIEW.printFalse();
					continue;
				}
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setSearchCondition("관리자체크");
				memberDTO.setMid(presentUser.getMid());
				memberDTO.setGrade(presentUser.getGrade());
				memberDTO = mDAO.selectOne(memberDTO);
				if (memberDTO == null) {
					commonVIEW.printFalse();
					continue;
				}
				ProductDTO pDTO = new ProductDTO();
				pDTO.setPid(commonVIEW.inputPid());
				pDTO = pDAO.selectOne(pDTO);
				if (pDTO == null) {
					commonVIEW.printFalse();
					continue;
				}
				pDTO.setSearchCondition("재고추가");
				pDTO.setCnt(commonVIEW.inputCnt());
				pDAO.update(pDTO);

			} else if (action == 6) {
				if (presentUser != null) {
					continue;
				}
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setSearchCondition("중복검사");
				String mid;
				while (true) {
					mid = logoutVIEW.inputIdnPw();
					memberDTO.setMid(mid);
					memberDTO = mDAO.selectOne(memberDTO);
					if (memberDTO == null) {
						break;
					}
					commonVIEW.printFalse();
				}

				memberDTO = new MemberDTO();
				memberDTO.setMid(mid);
				memberDTO.setMpw(logoutVIEW.inputIdnPw());
				memberDTO.setName(logoutVIEW.inputNamenGrade());
				memberDTO.setGrade(logoutVIEW.inputNamenGrade());
				mDAO.insert(memberDTO);
				commonVIEW.printTrue();

			} else if (action == 7) {
				if (presentUser != null) {
					continue;
				}
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMid(logoutVIEW.inputIdnPw());
				memberDTO.setMpw(logoutVIEW.inputIdnPw());
				memberDTO.setSearchCondition("로그인");
				memberDTO = mDAO.selectOne(memberDTO);
				if (memberDTO == null) {
					commonVIEW.printFalse();
				} else {
					presentUser = memberDTO;
					commonVIEW.printTrue();
					loginVIEW.hello(presentUser);
				}

			} else if (action == 8) {
				logoutVIEW.goodBye(presentUser);
				presentUser = null;

			} else if (action == 9) {
				if (presentUser == null) {
					continue;
				}
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMid(presentUser.getMid());
				memberDTO.setMpw(logoutVIEW.inputIdnPw());
				memberDTO.setSearchCondition("로그인");
				memberDTO = mDAO.selectOne(memberDTO);
				if (memberDTO == null) {
					commonVIEW.printFalse();
				} else {
					memberDTO.setMpw(logoutVIEW.inputIdnPw());
					mDAO.update(memberDTO);
					commonVIEW.printTrue();
					presentUser = null;
				}

			} else if (action == 10) {
				if (presentUser == null) {
					continue;
				}
				mDAO.delete(presentUser);
				presentUser = null;
				commonVIEW.printTrue();

			}
		}
	}
}
