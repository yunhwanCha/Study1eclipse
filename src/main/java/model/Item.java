package model;

public class Item {
	private String code;//상품번호
	private String title;//상품이름
	private int price;//상품가격
	private String content;//상품설명
	private String origin;//원산지
	private String item_date;//등록일
	
	private Integer num;//상품의 갯수
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getItem_date() {
		return item_date;
	}
	public void setItem_date(String item_date) {
		this.item_date = item_date;
	}
}
