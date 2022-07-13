package TECH_BLOGGER.com.entities;
import java.sql.*;
public class post {
     private int pid;
     private String pTitle;
     private String pContent;
     private String pCode;
     private String pPic;
     private int CategoryId;
     private int userId;
     
	public post(String pTitle, String pContent, String pCode, String pPic, int categoryId, int userId) {
		this.pid = pid;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pPic = pPic;
		this.CategoryId = categoryId;
		this.userId=userId;
	}
     
	public post(int Pid,String Title, String Content, String Code, String Pic, int Cid, int Cuserid) {
		pid=Pid;
		pTitle = Title;
		pContent = Content;
        pCode = Code;
	    pPic = Pic;
		CategoryId = Cid;
		userId=Cuserid;
	}
	
//	public post( String pTitle, String pContent, String pCode, String pPic, int categoryId, int userId) {
//
//		this.pTitle = pTitle;
//		this.pContent = pContent;
//		this.pCode = pCode;
//		this.pPic = pPic;
//		this.CategoryId = categoryId;
//		this.userId=userId;
//	}
    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpPic() {
		return pPic;
	}

	public void setpPic(String pPic) {
		this.pPic = pPic;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	
}
