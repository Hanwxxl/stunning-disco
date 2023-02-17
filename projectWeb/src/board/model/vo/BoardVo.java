package board.model.vo;

public class BoardVo {

//	BBSID        NOT NULL NUMBER(38)     
//	BBSTITLE              VARCHAR2(50)   
//	USERID                VARCHAR2(20)   
//	BBSDATE               TIMESTAMP(6)   
//	BBSCONTENT            VARCHAR2(2048) 
//	BBSAVAILABLE          NUMBER(38)  
	
	private int bbsID;
	private String bbsTitle;
	private String userID;
	private String bbsDate;
	private String bbsContent;
	private int bbsAvailable;
	
	public int getBbsID() {
		return bbsID;
	}
	
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	
	public String getBbsTitle() {
		return bbsTitle;
	}
	
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getBbsDate() {
		return bbsDate;
	}
	
	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}
	
	public String getBbsContent() {
		return bbsContent;
	}
	
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	
	public int getBbsAvailable() {
		return bbsAvailable;
	}
	
	public void setBbsAvailable(int bbsAvailable) {
		this.bbsAvailable = bbsAvailable;
	}

	
}