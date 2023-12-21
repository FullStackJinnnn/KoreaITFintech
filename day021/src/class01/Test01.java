package class01;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test01 {

	public static void main(String[] args) {

		// 웹 크롤링
		// 스크랩핑이란?
		// 데이터를 많~이 모으는 작업
		// 크롤링이란?
		// 데이터를 정제하고 원하는 형태로 가공하는 작업
		// => 데이터를 많이 모아서, 원하는 output으로 정제·가공하는 작업
		// 빅데이터에서 많이 활용되는 기술
		// : 웹으로부터 데이터를 많이 모아서 가공할 예정
		// 크롤링할 타켓 웹 페이지를 알아야한다!
		// "주소"를 알아야한다!
		// "URL"
		//스크랩핑 크롤링이 별개였다원랜
		//url,target,webpage를알아야한ㄷㅏ.
		final String url = "https://www.dogpang.com/";

		// 말 그대로 해당 URL은 "페이지"로 구성되어있음!
		// 개발자가 페이지를 코드로 작성하면,
		// 웹 브라우저라는 sw가 코드(페이지)를 해석해서 UI로 구현해서 보여줌

		// 웹 페이지 정보를 JAVA에서는 Document라고 함
		Document doc = null;
		// 우리가 사용할 웹 페이지 정보(Document) 타입은 JAVA에서 기본제공 x
		// 외부로부터 Document를 지원해줄수있는 .jar파일을 추가해야함!
		// == ojdbc6.jar
		// jsoup.jar
		//웹페이지에서의 "요소"
		//element
		//엘리먼트
		//태그
		//웹페이지를 코딩하는 언어는 HTML 입니다.
		//마크업 언어
		// <> 태그로 이루어져있다.
//		내가 가져올 데이터가 "어떤 태그인가?"를 알아야함!!
//		영화 제목은 <strong> 태그에 존재한다!
//		
//		태그(요소)들은 "속성"을 가질수있습니다 :D
//		id 속성 > 유일한 요소에게 부여하는 값
//			ex)로고, 검색창, ,,,
//			#으로 표시
//		class 속성 => 여러 반복되는 요소에게 부여하는 값
//		ex) 영화 제목에게 붙는 title class 값
//		.으로 표시
//		(JAVA의 class와 완전히 다름! 무관합니다!!)
//		
//div#logo	<div id = "logo">로고<div>
//div.product	<div class="product>상품명<div>
//span.dt		<span class="dt">설명<span>
//
//	herf 속성=> 다른 링크를 첨부할때 사용하는 속성
//	a 태그와 많이 사용됨
//	<a href= "URL 링크">URL</a>
//	

//		1. 웹에서 샘플될 만한 데이터를 끌어와서
//		2. DB에 저장하고
//		3. JAVA에서 Client로 COnsole에 전체목록출력을 통해 샘플 데이터 출력
		
		

		try {
			doc = Jsoup.connect(url).get();
			// Jsoup.connect(url) => connection 객체가 반환됨
			// connection.get() => document 객체가 반환됨
			// JDBC와 유사
		} catch (IOException e) {
			e.printStackTrace();
		}

		///// System.out.println(doc);

		// 내가 확인하고 싶은 영화 제목은
		// <strong class="title">로 되어있다!
		Elements elems = doc.select("strong.price");
		Elements elems2 = doc.select("div.flex-contents");
		// Elements 는 일종의 ResultSet 역할

		// 이터레이터
		// 복사체
		// 컬렉션의 한 종류
		Iterator<Element> itr = elems.iterator();
		Iterator<Element> itr2 = elems2.iterator();
		// ResultSet 처럼 1개씩 보여줄수가없어서.
		// 1개씩 보여주려고 itr 를 사용함!

		while (itr.hasNext()) {
			String str = itr.next().text();
			String str2 = itr2.next().text();
			
			System.out.println(str);
			System.out.println(str2);
		}

	}

}
