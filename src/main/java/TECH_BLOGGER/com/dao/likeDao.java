package TECH_BLOGGER.com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;import org.apache.catalina.startup.SetNextNamingRule;

import TECH_BLOGGER.com.helper.ConnectionProvider;

public class likeDao {
	Connection con=null;
	   public likeDao(Connection con) {
		this.con=con;
	   }
   
   public boolean insertLike(int pid,int uid) {

	   boolean f=false;
	   
	   try {
		String q="insert into liked(pid,uid) values(?,?)";
		PreparedStatement p= con.prepareStatement(q);
		p.setInt(1, pid);
		p.setInt(2, uid);
		p.executeUpdate();
		f=true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
  
	   
	   
	   return f;
   }


   public int countLikeOnPost(int pid) {
    int cnt=0;
	   
	   try {
		String q="select count(*) from liked where pid=?";
		PreparedStatement p= con.prepareStatement(q);
		p.setInt(1, pid);
		ResultSet set=p.executeQuery();
		if(set.next()) {
			cnt=set.getInt("count(*)");
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
  
	   
	   
	   return cnt;
   }
   
   public boolean isLikedByUser(int pid,int uid) {

	   boolean f=false;
	   
	   try {
		String q="select * from liked(pid,uid) values(?,?)";
		PreparedStatement p= con.prepareStatement(q);
		p.setInt(1, pid);
		p.setInt(2, uid);
		ResultSet set= p.executeQuery();
		if(set.next()) {
			f=true;
		}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
  
	   
	   
	   return f;
   }
   
   public boolean deleteLike(int pid,int uid) {

	   boolean f=false;
	   
	   try {
		String q="delete * from liked where pid=? uid=?";
		PreparedStatement p= con.prepareStatement(q);
		p.setInt(1, pid);
		p.setInt(2, uid);
		p.executeUpdate();
        f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	   return f;
   }
   
   
}  
   
