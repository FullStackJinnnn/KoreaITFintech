package model;

import java.util.ArrayList;

public class ProductDAO {
	private ArrayList<ProductDTO> pdatas;

	public ProductDAO() {
		pdatas = new ArrayList<ProductDTO>();

		ProductDTO sample01 = new ProductDTO();
		sample01.setPid(1001);
		sample01.setName("콜라");
		sample01.setPrice(1000);
		sample01.setCnt(5);
		pdatas.add(sample01);

		ProductDTO sample02 = new ProductDTO();
		sample02.setPid(1002);
		sample02.setName("사이다");
		sample02.setPrice(1200);
		sample02.setCnt(4);
		pdatas.add(sample02);

		ProductDTO sample03 = new ProductDTO();
		sample03.setPid(1003);
		sample03.setName("웰치스");
		sample03.setPrice(1500);
		sample03.setCnt(6);
		pdatas.add(sample03);

	}

	public ArrayList<ProductDTO> selectAll(ProductDTO pDTO) {

		if (pDTO.getSearchCondition() == null) {
			return this.pdatas;
		}

		else if (pDTO.getSearchCondition().equals("가격검색")) {
			int i;
			int min = -1;
			ArrayList<ProductDTO> datas = new ArrayList<ProductDTO>();
			for (i = 0; i < this.pdatas.size(); i++) {
				if (this.pdatas.get(i).getPrice() >= pDTO.getMinPrice()) {
					min = i;
					break;
				}
			}
			for (i = 0; i < this.pdatas.size(); i++) {
				if (this.pdatas.get(i).getPrice() > pDTO.getMaxPrice()) {
					break;
				}
			}
			for (int a = min; a < i; a++) {
				datas.add(this.pdatas.get(a));
			}
			// 상품목록전체출력
			// 가격검색출력
			return datas;
		}

		return null;
	}

	public ProductDTO selectOne(ProductDTO pDTO) {
		boolean flag = false;
		int i;
		for (i = 0; i < pdatas.size(); i++) {
			if (pdatas.get(i).getPid() == pDTO.getPid()) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			return null;
		}
		return this.pdatas.get(i);
		// 상품선택
	}

	private boolean insert(ProductDTO pDTO) {
		return false;
	}

	public boolean update(ProductDTO pDTO) {
		// 구매
		// 재고추가
		if (pDTO.getSearchCondition().equals("장바구니")) {
			for (int i = 0; i < pdatas.size(); i++) {
				if (pdatas.get(i).getPid() == pDTO.getPid()) {
					pdatas.get(i).setCnt(pdatas.get(i).getCnt() - 1);
				}
			}
		} else if (pDTO.getSearchCondition().equals("재고추가")) {
			for (int i = 0; i < pdatas.size(); i++) {
				if (pdatas.get(i).getPid() == pDTO.getPid()) {
					pdatas.get(i).setCnt(pdatas.get(i).getCnt() + pDTO.getCnt());
				}
			}
		}

		else {
			return false;
		}
		return true;
	}

	private boolean delete(ProductDTO pDTO) {
		return false;
	}
}
