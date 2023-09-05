package service;

import java.util.ArrayList;

import dao.Crud;
import model.CartItem;

public class Cart {//��ٱ��Ͽ� ��ü
	private ArrayList<String> codeList = new ArrayList<String>();
	private String id;//��ٱ����� ����, �� ����
	public Cart(String id) { this.id = id; }
	private ArrayList<Integer> numList = new ArrayList<Integer>();
	
	public void modifyItem(String code, Integer num) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {//��ǰ��ȣ�� ��ġ�ϴ� ���
				numList.set(i, num);//i��° ��ǰ ������ num���� ����
				//��ٱ��� DB���̺��� ���� ���� ����
				Crud dao = new Crud();
				CartItem ci = new CartItem();
				ci.setId(this.id); ci.setCode(code); ci.setNum(numList.get(i));
				dao.updateCart(ci);
				//��ٱ��� DB���̺��� ���� ���� ��
				return;//�޼��� ����
			}
		}
	}//��ٱ��Ͽ��� ��ǰ�� ������ �����ϴ� �޼���
	public void deleteItem(String code) {
		for(int i=0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {//��ġ�ϴ� ���
				codeList.remove(i);//codeList���� i��° ��ǰ��ȣ�� ����
				numList.remove(i);//numList���� i��° ��ǰ������ ����
				//��ٱ��� DB���̺��� ��ǰ������ ���� ����
				Crud dao = new Crud();
				CartItem ci = new CartItem();
				ci.setId(this.id); ci.setCode(code);
				dao.deleteCart(ci);
				//��ٱ��� DB���̺��� ��ǰ������ ���� ��
				return;//�޼��� ����
			}//n��° ��ǰ��ȣ�� �����Ϸ��� ��ǰ��ȣ�� ��ġ�ϴ��� �˻�
		}
	}//��ٱ��Ͽ��� ��ǰ�� ����(��ǰ��ȣ, ��ǰ����)�ϴ� �޼���
	
	public void addCart(String code, Integer quantity) {
		//code�� �ִ� ��ǰ��ȣ�� �̹� ArrayList�� �ִ����� �˻��Ѵ�.������ ������ ����
		Crud dao = new Crud();
		for(int i = 0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, numList.get(i) + quantity);
				////////////��ٱ��� DB���̺� ���� ���� ����//////////
				CartItem ci = new CartItem();
				ci.setId(this.id); ci.setCode(code); ci.setNum(numList.get(i));
				dao.updateCart(ci);
				////////////��ٱ��� DB���̺� ���� ���� ��//////////
				return;//�޼��� ����
			}//��ٱ��Ͽ� �ִ� n��° ��ǰ�� ��ȣ�� �������� ��ǰ�� ��ȣ�� ���� ���
		}
		codeList.add(code);//��ǰ��ȣ�� ArrayList�� ����
		numList.add(quantity);//��ǰ������ ArrayList�� ����
		//////////��ٱ��� DB���̺� ���� ����/////////////////
		CartItem ci = new CartItem();
		ci.setSeqno(dao.getMaxCart()+1);
		ci.setId(this.id); ci.setCode(code); ci.setNum(quantity);
		dao.addCart(ci);
		//////////��ٱ��� DB���̺� ���� ��/////////////////
		
	}//��ٱ��Ͽ� ��ǰ��ȣ�� ������ ��� �޼���
	
	public ArrayList<String> getCodeList() {
		return codeList;
	}
	public ArrayList<Integer> getNumList() {
		return numList;
	}
	
}
