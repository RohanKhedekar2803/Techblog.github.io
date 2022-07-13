package TECH_BLOGGER.com.dao;

import java.awt.Point;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import TECH_BLOGGER.com.entities.*;

public class blogDao {
    Connection con;

	public blogDao(Connection con) {

		this.con = con;
	}
	
	
	ArrayList<Category> list=new ArrayList<>();
	//to get all cattagories 
	public ArrayList<Category> getAllCategories(){


		try {
			String query="select * from categories";
			Statement st=this.con.createStatement(); 
			ResultSet set=st.executeQuery(query);
			
			while(set.next()) {
				int id=set.getInt("cid");
				String name=set.getString("cname");
				String description=set.getString("cdescription");
				Category c=new Category(name,description,id);
				list.add(c);
			}

			 
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return list;
	}

	
	//to save a post
	public boolean savePostInDb(post p) {
		boolean z=false;

		try {
			String query= "insert into posts(pTitle, pContent, pCode, pPic, categoryId, userId) values(?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, p.getpTitle());
			stmt.setString(2, p.getpContent());
			stmt.setString(3, p.getpCode());
			stmt.setString(4, p.getpPic());
			stmt.setInt(5, p.getCategoryId());
			stmt.setInt(6, p.getUserId());
			stmt.executeUpdate();
			z=true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return z;
	}

	
	ArrayList <post> list2 =new ArrayList();
	//to get all post
	public ArrayList<post> getAllposts(){
		try {
			PreparedStatement p=con.prepareStatement("select * from posts");
			ResultSet set=p.executeQuery();
			while(set.next()) {
				int id=set.getInt("pid");
				String title=set.getString("pTitle");
				String content=set.getString("pContent");
				String code=set.getString("pCode");
				String pic =set.getString("pPic");
				int catid=set.getInt("categoryId");
				int  userid=set.getInt("userId");
				post p1 =new post(id,title, content, code, pic, catid, userid);
				list2.add(p1);
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list2;
	}
	
	
	ArrayList <post> list3 =new ArrayList();
	//to get post using catagory id
	public ArrayList<post> getPostByCatId(int cat){
		
		try {
			PreparedStatement p=con.prepareStatement("select * from posts where categoryId=?");
			p.setInt(1, cat);
			ResultSet set=p.executeQuery();
			while(set.next()) {
				int id=set.getInt("pid");
				String title=set.getString("pTitle");
				String content=set.getString("pContent");
				String code=set.getString("pCode");
				String pic =set.getString("pPic");
				int catid=set.getInt("categoryId");
				int  userid=set.getInt("userId");
				post p1 =new post(id,title, content, code, pic, catid, userid);
				list3.add(p1);
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list3;
	}
	

	
	//to get post using id
	public post getPostByPostId(int postid){
		post p1=null;
		try {
			
			PreparedStatement p=con.prepareStatement("select * from posts where pid=?");
			p.setInt(1, postid);
			ResultSet set=p.executeQuery();
			if(set.next()) {
				int id=set.getInt("pid");
				String title=set.getString("pTitle");
				String content=set.getString("pContent");
				String code=set.getString("pCode");
				String pic =set.getString("pPic");
				int catid=set.getInt("categoryId");
				int  userid=set.getInt("userId");
			    p1 =new post(id,title, content, code, pic, catid, userid);
				return p1;
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return p1;
	}
	
	



}
