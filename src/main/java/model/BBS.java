package model;

public class BBS {
	private int seqno;//글번호
	private String title;//제목
	private String id;//작성자
	private String bbs_date;//작성일
	private String content;//글 내용
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBbs_date() {
		return bbs_date;
	}
	public void setBbs_date(String bbs_date) {
		this.bbs_date = bbs_date;
	}
}
