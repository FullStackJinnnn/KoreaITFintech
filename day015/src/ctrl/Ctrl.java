
package ctrl;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductDTO;
import view.View;

public class Ctrl {

	private ProductDAO productDAO; // MODEL
	private View view;
	public Ctrl() {
		this.productDAO=new ProductDAO();
		this.view=new View();
	}

	public void start() {
		int PK = 1003;
		while(true) {
			view.printMenu();
			int action=view.inputInteger();
			if(action==0) {
				break;
			}
			else if(action==1234) {
				while(true) {
					view.printAdminMenu();
					action=view.inputInteger();
//					System.out.println("1. 메뉴추가");
//					System.out.println("2. 메뉴재고변경");
//					System.out.println("3. 메뉴삭제");
//					System.out.println("0. 관리자모드 종료");
					if(action==0) {
						view.printAdminOut();
						break;
					}
					else if(action==1) {
						String name = view.inputName();
						int price = view.inputPrice();
						int cnt = view.inputCnt();
						ProductDTO productDTO=new ProductDTO();
						productDTO.setNum(PK++);
						productDTO.setName(name);
						productDTO.setPrice(price);
						productDTO.setCnt(cnt);
						boolean flag=productDAO.insert(productDTO);
						if(flag) {
							view.printTrue();
						} else {
							view.printFalse();
						}
						
					}
					else if(action==2) {
						ProductDTO productDTO=new ProductDTO();
						ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);
						view.printDatas(datas);
						view.printCntChange();
						int num =view.inputInteger();
						productDTO.setNum(num);
					
						productDTO=productDAO.selectOne(productDTO);
						if(productDTO==null) {
							view.printFalse();
							continue;
							}
						int cntUpdate = view.inputCntUpdate();
						productDTO.setCnt(cntUpdate);

						productDTO.setSearchConditon("재고변경");
							productDAO.update(productDTO);
							
						
						

					}
					else if(action==3) {
						ProductDTO productDTO=new ProductDTO();
						ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);
						view.printDatas(datas);
						view.printCntChange();
						int num =view.inputInteger();
						productDTO.setNum(num);
						ProductDTO data=productDAO.selectOne(productDTO);
						if(data!=null) {
							productDAO.delete(data);
							
						}
						


					}
				}
			}
			else if(action==1) {
				ProductDTO productDTO=new ProductDTO();
				ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);
				view.printDatas(datas);
			}
			else if(action==2) {
				int num=view.inputInteger();
				ProductDTO productDTO=new ProductDTO();
				productDTO.setNum(num);
				ProductDTO data=productDAO.selectOne(productDTO);
				view.printData(data);
				if(data!=null && data.getCnt()>0) { // 구매성공이라면
					data.setSearchConditon("구매");
					productDAO.update(data);
					
				}
			}
		}		
	}

}
