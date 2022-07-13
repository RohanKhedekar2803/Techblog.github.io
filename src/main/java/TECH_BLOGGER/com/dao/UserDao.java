package TECH_BLOGGER.com.dao;
import java.sql.*;
import java.util.ArrayList;

import TECH_BLOGGER.com.entities.*;
public  class  UserDao {
   private Connection con;
   
    public UserDao(Connection con) {
        this.con = con;
    }
    
//    method to insert user to db
    public  boolean saveUser(User user){
        boolean f=false;
        try {
//            user--->database
            String query="insert into user1(name,mail,password,gender,about) values(?,?,?,?,?)";
                    PreparedStatement pstmt  =this.con.prepareStatement(query);
                     pstmt.setString(1,user.getName());
                     pstmt.setString(2,user.getMail());
                     pstmt.setString(3,user.getPassword());
                     pstmt.setString(4,user.getGender());
                     pstmt.setString(5,user.getAbout());
                    
                     pstmt.executeUpdate();
                     
                     f=true;
                     
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return f;
    }
    
//    getting user by id password
    User user=null;
    public User getUserByEmailAndPassword(String email,String password) {
    	
    	
    	try {
    		String query ="select * from user1 where mail =? and password =?";
    		PreparedStatement pstmt =con.prepareStatement(query);
    		pstmt.setString(1, email);
    		pstmt.setString(2, password);
    		
    		ResultSet set=pstmt.executeQuery();
//    		user with given id password is taken in set
    		
    		if(set.next()) {
//    			if there is any user then following will be done
    			user=new User();
    			String name=set.getString("name");
    			user.setName(name);  			
//    		we taken and  stored users name in name
    			
//    			taken all values in one entity called user 
    			user.setId(set.getInt("id"));
    			user.setMail(set.getString("mail"));
    			user.setPassword(set.getString("password"));
    			user.setGender(set.getString("gender"));
    			user.setAbout(set.getString("about"));
    			user.setProfile(set.getString("profile"));
    		}
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	
    	return user ;
    }

    boolean exist=false;
    public boolean getUserByEmail(String email) {
          
    	try {
    		String query ="select * from user1 where mail =?";
    		PreparedStatement pstmt =con.prepareStatement(query);
    		pstmt.setString(1, email);
    		
    		ResultSet set=pstmt.executeQuery();
    		if(set.next()) {
    			exist=true;
    		}
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	
    	return exist;
    }

    boolean flag=false;
   public boolean UpdateUser(User user) {
	   
	   try {
		String query="update user1 set name=? , mail=? , password=? , about=? ,profile=? where id=?";
		PreparedStatement p =con.prepareStatement(query);
		p.setString(1, user.getName());
		p.setString(2, user.getMail());
		p.setString(3, user.getPassword());
		p.setString(5, user.getProfile());
		p.setString(4, user.getAbout());
		p.setInt(6,user.getId());
		p.executeUpdate();
		   flag=true;
		  
		   
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return flag;
   }
   
   public User getUserByUserId(int userid) {
		User user=null;
		String query ="select * from user1 where id=?";
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userid);
			ResultSet set=pstmt.executeQuery();
//			user with given id password is taken in set
			
			if(set.next()) {
//				if there is any user then following will be done
				user=new User();
				String name=set.getString("name");
				user.setName(name);  			
//			we taken and  stored users name in name
				
//				taken all values in one entity called user 
				user.setId(set.getInt("id"));
				user.setMail(set.getString("mail"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setProfile(set.getString("profile"));
			} 
		}	
			catch (SQLException e) {
					e.printStackTrace();
		   }
			
		
return user;
	
    }
   ArrayList<User> al=new ArrayList<User>();
   public ArrayList<User> getUsers() {
		User user=null;
		String query ="select * from user1 ";
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(query);
			ResultSet set=pstmt.executeQuery();
//			user with given id password is taken in set
			
			while(set.next()) {
//				if there is any user then following will be done
				user=new User();
				String name=set.getString("name");
				user.setName(name);  			
//			we taken and  stored users name in name
				
//				taken all values in one entity called user 
				user.setId(set.getInt("id"));
				user.setMail(set.getString("mail"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setProfile(set.getString("profile"));
				al.add(user);
			} 
		}	
			catch (SQLException e) {
					e.printStackTrace();
		   }
			
		
return al;
	
   }
}   
