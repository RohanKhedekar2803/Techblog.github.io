
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>
<%@page import="TECH_BLOGGER.com.helper.*" %>
<%@page import="TECH_BLOGGER.com.dao.UserDao"%>
<%@page import="TECH_BLOGGER.com.dao.likeDao"%>
<%@page import="TECH_BLOGGER.com.entities.post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TECH_BLOGGER.com.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="TECH_BLOGGER.com.dao.blogDao"%>
<%@page import="TECH_BLOGGER.com.entities.User"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
          <!--css-->
          <link href="css/myStyles.css" rel="stylesheet" type="text/css"/>
          
     <!--icon css from font awesome intro-->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    
    <!--navbar-->
  
   <%@include  file="custom_navbar.jsp"  %>
    
    <!--banner-->
    <div class="container-fluid primary-background-color1 p-0 m-0 ">
        <div class="jumbotron primary-background text-dark p-5" >
            <div class="container">
                <h3 class="display-3">Welcome to Tech Blogs</h3>
                 <p>
                What’s a techblog? A blog is a piece of written content along with some related pictures that is published on a site.The topics of blogs can vary from person to person or even business to business.
The main purpose of our blogs is to convey information in a way that is more informal or conversational than other long-form written content.
So now, what is a blog website? And how does it differ from your company’s main website?
A blog website is a site that is updated with new information on an ongoing basis. It normally consists of a collection of posts.
                </p>
                
                
                <a href="Regestration.jsp" class="btn btn-outline-light btn-lg"> <span class="fa fa-diamond"></span>Start! Your Free Trial</a>
                <a href="Login_page.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-o fa-spin"></span>Login</a>
            </div>
            
        </div>
        
    </div>
    
    <br>
    
    
    <% 
likeDao ld=new likeDao(ConnectionProvider.getConnection()); 
blogDao b=new blogDao(ConnectionProvider.getConnection());
UserDao ud=new UserDao(ConnectionProvider.getConnection());             
ArrayList<User> lst=ud.getUsers();
int count=0;
  %>
    
    <div >
    
    <div class="text-center"><h4><b><i>Top contributers</i></b></h4></div>
    <!--cards-->
    <div class="container">
        <div class="row">
            <!--creted a row-->
            <%
            for(User u:lst){
		           if(count==3){
		        	   break;
		        	   }
            	%>
            	 <div class="col-md-4">
                <!--created a div with 4col of 12-->
                <div class="card">
                  
                  <div class="card-body">
                    <h5 class="card-title"><%=u.getName() %></h5>
                    <p class="card-text"><%=u.getMail() %></p>
                    
                     <p class="card-text"><%=u.getAbout()%></p>
                    <a href="Regestration.jsp" class="btn btn-primary">Read More.</a>
                  </div>
                </div>
                 </div>
            	<%
            	count++;
            }
            %>
           
                
                
           
            
            
            </div>
            </div>
            </div>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
           
        
        
        
        <!--jquary-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <!--js from bootstrap-->
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <!--custom js file-->
        <script src="js/myjs.js" type="text/javascript"></script>

       


    
</html>