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
			commonVIEW.printMenu();
			userVIEW.printMenu();
			adminVIEW.printMenu();
			logoutVIEW.printMenu();
			loginVIEW.printMenu();

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
				this.pDTOarr.add(pDAO.selectOne(pDTO));
			} else if (action == 4) {
				ProductDTO pDTO = new ProductDTO();
				pDTO.setSearchCondition("장바구니");
				for (int i = 0; i < this.pDTOarr.size(); i++) {
					pDTO.setPid(pDTOarr.get(i).getPid());
					pDAO.update(pDTO);
				}
				pDTOarr.clear();
			} else if (action == 5) {
				ProductDTO pDTO = new ProductDTO();
				pDTO.setSearchCondition("재고추가");
				pDTO.setPid(commonVIEW.inputPid());
				pDTO.setCnt(commonVIEW.inputCnt());
				pDAO.update(pDTO);

			} else if (action == 6) {
				if (presentUser != null) {
					continue;
				}
				MemberDTO mDTO = new MemberDTO();
				mDTO.setSearchCondition("중복검사");
				String mid;
				while (true) {
					mid = logoutVIEW.inputIdnPw();
					mDTO.setMid(mid);
					mDTO = mDAO.selectOne(mDTO);
					if (mDTO == null) {
						break;
					}
					commonVIEW.printFalse();
				}

				mDTO = new MemberDTO();
				mDTO.setMid(mid);
				mDTO.setMpw(logoutVIEW.inputIdnPw());
				mDTO.setName(logoutVIEW.inputNamenGrade());
				mDTO.setGrade(logoutVIEW.inputNamenGrade());
				mDAO.insert(mDTO);
				commonVIEW.printTrue();

			} else if (action == 7) {
				if (presentUser != null) {
					continue;
				}
				MemberDTO mDTO = new MemberDTO();
				mDTO.setMid(logoutVIEW.inputIdnPw());
				mDTO.setMpw(logoutVIEW.inputIdnPw());
				mDTO.setSearchCondition("로그인");
				mDTO = mDAO.selectOne(mDTO);
				if (mDTO == null) {
					commonVIEW.printFalse();
				} else {
					presentUser = mDTO;
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
				MemberDTO mDTO = new MemberDTO();
				mDTO.setMid(presentUser.getMid());
				mDTO.setMpw(logoutVIEW.inputIdnPw());
				mDTO.setSearchCondition("로그인");
				mDTO = mDAO.selectOne(mDTO);
				if (mDTO == null) {
					commonVIEW.printFalse();
				} else {
					mDTO.setMpw(logoutVIEW.inputIdnPw());
					mDAO.update(mDTO);
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
