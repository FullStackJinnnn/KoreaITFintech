package ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.DogfoodDAO;
import model.DogfoodDTO;
import view.VIEW;

public class CTRL {

	private DogfoodDAO bDAO;
	private VIEW view;

	private DogfoodDTO bDTO;

	public CTRL() {
		bDAO = new DogfoodDAO();
		bDTO = new DogfoodDTO();
		view = new VIEW();
	}

	public void start() {
		final String url = "https://www.dogpang.com/";

		
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
			// Jsoup.connect(url) => connection 객체가 반환됨
			// connection.get() => document 객체가 반환됨
			// JDBC와 유사
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements elems = doc.select("strong.price");
		Elements elems2 = doc.select("div.flex-contents");
	
		Iterator<Element> itr = elems.iterator();
		Iterator<Element> itr2 = elems2.iterator();
		
		
		
		while (true) {

			int action = view.inputAction();
			if (action == 0) {
				break;
			} else if (action == 1) {

			} else if (action == 2) {

			}

			else if (action == 3) {
				while (itr.hasNext()) {
					String str = itr.next().text();
					String str2 = itr2.next().text();
					String str3;
					str3 = str2.substring(0,30);
					bDTO.setPrice(str);
//					System.out.println(str3);
//					bDTO.setTitle("A");
					bDTO.setTitle(str3);
					bDAO.insert(bDTO);
					
//					System.out.println(str);
//					System.out.println(str2);
				}
			} else if (action == 4) {
				DogfoodDTO bDTO = new DogfoodDTO();
				ArrayList<DogfoodDTO> datas = bDAO.selectAll(bDTO);
				view.printDatas(datas);

			} else if (action == 5) {

			} else if (action == 6) {

			}
		}
	}

}
