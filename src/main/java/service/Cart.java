package service;

import java.util.ArrayList;

import dao.Crud;
import model.CartItem;

public class Cart {//장바구니용 객체
	private ArrayList<String> codeList = new ArrayList<String>();
	private String id;//장바구니의 주인, 즉 계정
	public Cart(String id) { this.id = id; }
	private ArrayList<Integer> numList = new ArrayList<Integer>();
	
	public void modifyItem(String code, Integer num) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {//상품번호가 일치하는 경우
				numList.set(i, num);//i번째 상품 갯수를 num으로 수정
				//장바구니 DB테이블에서 갯수 변경 시작
				Crud dao = new Crud();
				CartItem ci = new CartItem();
				ci.setId(this.id); ci.setCode(code); ci.setNum(numList.get(i));
				dao.updateCart(ci);
				//장바구니 DB테이블에서 갯수 변경 끝
				return;//메서드 종료
			}
		}
	}//장바구니에서 상품의 갯수를 수정하는 메서드
	public void deleteItem(String code) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {//일치하는 경우
				codeList.remove(i);//codeList에서 i번째 상품번호를 삭제
				numList.remove(i);//numList에서 i번째 상품갯수를 삭제
				//장바구니 DB테이블에서 상품정보를 삭제 시작
				Crud dao = new Crud();
				CartItem ci = new CartItem();
				ci.setId(this.id); ci.setCode(code);
				dao.deleteCart(ci);
				//장바구니 DB테이블에서 상품정보를 삭제 끝
				return;//메서드 종료
			}//n번째 상품번호와 삭제하려는 상품번호가 일치하는지 검사
		}
	}//장바구니에서 상품을 삭제(상품번호, 상품갯수)하는 메서드
	
	public void addCart(String code, Integer quantity) {
		//code에 있는 상품번호가 이미 ArrayList에 있는지를 검사한다.있으면 갯수만 증가
		Crud dao = new Crud();
		for(int i = 0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, numList.get(i) + quantity);
				////////////장바구니 DB테이블에 갯수 변경 시작//////////
				CartItem ci = new CartItem();
				ci.setId(this.id); ci.setCode(code); ci.setNum(numList.get(i));
				dao.updateCart(ci);
				////////////장바구니 DB테이블에 갯수 변경 끝//////////
				return;//메서드 종료
			}//장바구니에 있는 n번째 상품의 번호와 담으려는 상품의 번호가 같은 경우
		}
		codeList.add(code);//상품번호를 ArrayList에 저장
		numList.add(quantity);//상품갯수를 ArrayList에 저장
		//////////장바구니 DB테이블에 삽입 시작/////////////////
		CartItem ci = new CartItem();
		ci.setSeqno(dao.getMaxCart()+1);
		ci.setId(this.id); ci.setCode(code); ci.setNum(quantity);
		dao.addCart(ci);
		//////////장바구니 DB테이블에 삽입 끝/////////////////
		
	}//장바구니에 상품번호와 갯수를 담는 메서드
	
	public ArrayList<String> getCodeList() {
		return codeList;
	}
	public ArrayList<Integer> getNumList() {
		return numList;
	}
	
}
