package dao;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBS;
import model.CartItem;
import model.Customer;
import model.FromTo;
import model.ImageBBS;
import model.Item;

public class Crud {
	private final String MAPPER_NAME = "mapper.myMapper.";
	private final String IMAGE_MAPPER = "mapper.imageMapper.";
	
	public void updateOrderNo(ImageBBS bbs) {
		SqlSession ss = getSession();
		try {
			int res = ss.update(this.IMAGE_MAPPER+"updateOrderNo", bbs);
			if(res > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
	}
	
	public String updateImageBBS(ImageBBS bbs) {
		String result = "";//�����۾��� ���� ������ ���� ���� ����
		SqlSession ss = getSession();
		try {
			int res = ss.update(this.IMAGE_MAPPER+"updateImageBBS", bbs);
			if(res > 0) {
				ss.commit(); result = "OK";
			}else {
				ss.rollback(); result = "NOK";
			}
		}finally {
			ss.close();
		}
		return result;
	}
	
	public String deleteImageBBS(Integer no) {
		String result = "";//�����۾��� ���� ������ ���� ���� ����
		SqlSession ss = getSession();
		try {
			int res = ss.delete(this.IMAGE_MAPPER+"deleteImageBBS", no);
			if(res > 0) {
				ss.commit(); result = "OK";
			}else {
				ss.rollback(); result = "NOK";
			}
		}finally {
			ss.close();
		}
		return result;
	}
	
	public ImageBBS getImageDetail(Integer no) {
		ImageBBS bbs = null;//��ȸ����� ������ ���� ����
		SqlSession ss = getSession();
		try {
			bbs = ss.selectOne(this.IMAGE_MAPPER+"getImageDetail",no);
		}finally {
			ss.close();
		}
		return bbs;
	}
	
	public Integer getImageCount() {
		Integer result = 0;//��ȸ����� ������ ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.selectOne(this.IMAGE_MAPPER+"getImageCount");
		}finally {
			ss.close();
		}
		return result;
	}
	
	public ArrayList<ImageBBS> getImages(FromTo ft){
		ArrayList<ImageBBS> list = new ArrayList<ImageBBS>();
		SqlSession ss = getSession();
		try {
			list = (ArrayList)ss.selectList(this.IMAGE_MAPPER+"getImages", ft);
		}finally {
			ss.close();
		}
		return list;
	}
	
	public String putImageBBS(ImageBBS bbs) {
		String result = "";//���� ���� ������ ���� ���� ����
		SqlSession ss = getSession();
		try {
			int res = ss.insert(this.IMAGE_MAPPER+"putImageBBS", bbs);
			if(res > 0) {
				ss.commit(); result = "OK";
			}else {
				ss.rollback(); result = "NOK";
			}
		}finally {
			ss.close();
		}
		return result;
	}
	
	public Integer getMaxImageBBS() {
		Integer result = null;//�˻� ����� ������ ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.selectOne(this.IMAGE_MAPPER+"getMaxImageBBS");
			if(result == null) result = 0;
		}finally {
			ss.close();
		}
		return result;
	}
	
	public String deleteCart(CartItem ci) {
		String result = "";//�۾��� ���������� ���� ���� ����
		SqlSession ss = getSession();
		try {
			int res = ss.delete(this.MAPPER_NAME+"deleteCart",ci);
			if(res > 0) {
				ss.commit(); result = "OK";
			}else {
				ss.rollback(); result = "NOK";
			}
		}finally {
			ss.close();
		}
		return result;
	}
	
	public ArrayList<CartItem> getCart(String id){
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		SqlSession ss = getSession();
		try {
			list = (ArrayList)ss.selectList(this.MAPPER_NAME+"getCart",id);
		}finally {
			ss.close();
		}
		return list;
	}
	
	public Integer getMaxCart() {
		Integer result = 0;//�˻������ ���� ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.selectOne(this.MAPPER_NAME+"getMaxCart");
			if(result == null) result = 0;
		}finally {
			ss.close();
		}
		return result;
	}
	
	public String updateCart(CartItem ci) {
		String result = "";//���� ����� ���� ���� ����
		int res = 0;//�۾� ����� ���� ���� ����
		SqlSession ss = getSession();
		try {
			res = ss.update(this.MAPPER_NAME+"updateCart", ci);
			if(res > 0) {
				ss.commit(); result = "OK";
			}else {
				ss.rollback(); result = "NOK";
			}
		}finally {
			ss.close();
		}
		return result;
	}
	public String addCart(CartItem ci) {
		String result = "";//���� ����� ���� ���� ����
		int res = 0;//�۾� ����� ���� ���� ����
		SqlSession ss = getSession();
		try {
			res = ss.insert(this.MAPPER_NAME+"addCart", ci);
			if(res > 0) {
				ss.commit(); result = "OK";
			}else {
				ss.rollback(); result = "NOK";
			}
		}finally {
			ss.close();
		}
		return result;
	}
	
	public String updateItem(Item item) {
		String result = ""; int res = 0;
		SqlSession ss = getSession();
		try {
			res = ss.update(this.MAPPER_NAME+"updateItem", item);
			if(res > 0) {
				ss.commit(); result = "OK";
			}else {
				ss.rollback(); result = "NOK";
			}
		}finally {
			ss.close();
		}
		return result;
	}
	public String deleteItem(String code) {
		String result = "";//���ϰ���� ������ ���� ����
		int res = 0;//��������� ������ ���� ����
		SqlSession ss = getSession();
		try {
			res = ss.delete(this.MAPPER_NAME+"deleteItem", code);
			if(res > 0) {
				ss.commit(); result = "OK";
			}else {
				ss.rollback(); result = "NOK";
			}
		}finally {
			
		}
		return result;
	}
	
	public Item getItemDetail(String code) {
		Item result = null;//��ȸ����� ������ ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.selectOne(this.MAPPER_NAME+"getItemDetail",code);
		}finally {
			ss.close();
		}
		return result;
	}
	
	public Integer getItemCount() {
		Integer result = 0;//��ȸ����� ������ ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.selectOne(this.MAPPER_NAME+"getItemCount");
		}finally {
			ss.close();
		}
		return result;
	}
	
	public ArrayList<Item> getAllItems(FromTo ft){
		ArrayList<Item> list = new ArrayList<Item>();
		SqlSession ss = getSession();
		try {
			list = (ArrayList)ss.selectList(this.MAPPER_NAME+"getAllItems", ft);
		}finally {
			
		}
		return list;
	}
	
	public int putItem(Item item) {
		int result = 0;//���� ����� ����� ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.insert(this.MAPPER_NAME+"putItem",item);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	public String getItemCode(String code) {
		String result = null;//��ȸ ����� ����� ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.selectOne(this.MAPPER_NAME+"getItemCode",code);
		}finally {
			ss.close();
		}
		return result;
	}
	
	public int updateBBS(BBS bbs) {
		int result = 0;//��������� ������ ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.update(this.MAPPER_NAME+"updateBBS", bbs);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	public int deleteBBS(Integer seqno) {
		int result = 0;//��������� ������ ���� ����
		SqlSession ss = getSession();
		try {
			result = ss.delete(this.MAPPER_NAME+"deleteBBS", seqno);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	public BBS getBBS(Integer seqno) {
		SqlSession ss = getSession();
		BBS bbs = null;//��ȸ����� ������ ���� ����
		try {
			bbs = ss.selectOne(this.MAPPER_NAME+"getBBS",seqno);
		}finally {
			ss.close();
		}
		return bbs;
	}
	
	public Integer getBBSCount() {
		SqlSession ss = getSession();
		Integer result = 0;//��ȸ����� ������ ���� ����
		try {
			result = ss.selectOne(this.MAPPER_NAME+"getBBSCount");
		}finally {
			ss.close();
		}
		return result;
	}
	
	public ArrayList<BBS> getAllBBS(FromTo ft){
		SqlSession ss = getSession();
		ArrayList<BBS> list = null;
		try {
			list = (ArrayList)ss.selectList(MAPPER_NAME+"getAllBBS",ft);
		}finally {
			ss.close();
		}
		return list;
	}
	
	public int putBBS(BBS bbs) {
		SqlSession ss = getSession();
		int result = 0;//������ ����� ����� ���� ����
		try {
			result = ss.insert(MAPPER_NAME+"putBBS",bbs);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	public Integer maxBBS() {
		SqlSession ss = getSession();
		Integer result = null;//�˻��� ����� ����� ���� ����
		try {
			result = ss.selectOne(MAPPER_NAME+"maxBBS");
			if(result == null) result = 0;
		}finally {
			ss.close();
		}
		return result;
	}
	public int register(Customer c){
		SqlSession ss = getSession();
		int result = 0;//�۾��� ����� ����� ���� ����
		try {
			result = ss.insert(MAPPER_NAME+"register",c);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	public String getId(String id) {
		SqlSession ss = getSession();
		String result = null;//��ȸ����� ����� ���� ����
		try {
			result = ss.selectOne(MAPPER_NAME+"getId",id);
		}finally {
			ss.close();
		}
		return result;
	}
	
	public String getPwd(String id) {
		SqlSession ss = getSession();
		String result = null;//��ȸ ����� ����� ���� ����
		try {
			result = ss.selectOne(MAPPER_NAME+"getPwd",id);
		}finally {
			ss.close();
		}
		return result;
	}
	
	private SqlSession getSession() {
		String config = "mybatisConfig.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(config);
		}catch(Exception e) {}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession ss = factory.openSession();
		return ss;
	}
}
//����(create),����(delete),����(update),��ȸ(retrieval)->