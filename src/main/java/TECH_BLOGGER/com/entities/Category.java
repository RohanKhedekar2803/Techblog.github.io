package TECH_BLOGGER.com.entities;

public class Category {
     private String cname;
     private String cdescription;
     private int cid;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Category(String cname, String cdescription, int cid) {
		this.cname = cname;
		this.cdescription = cdescription;
		this.cid = cid;
	}
	public Category() {}     
	public Category(String cname, String cdescription) {
		this.cname = cname;
		this.cdescription = cdescription;
	}
     
}
