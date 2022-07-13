
<%@page import="TECH_BLOGGER.com.dao.likeDao"%>
<%@page import="TECH_BLOGGER.com.dao.UserDao"%>
<%@page import="TECH_BLOGGER.com.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="TECH_BLOGGER.com.dao.blogDao"%>
<%@page import="TECH_BLOGGER.com.entities.User"%>
<%@page import="TECH_BLOGGER.com.entities.*" %>
<%@page import="TECH_BLOGGER.com.entities.post"%>
<%@page errorPage="error_page.jsp" %>
<%@page import="java.util.ArrayList" %>
<%
User user=(User)session.getAttribute("cu");
if(user==null){
	response.sendRedirect("Login_page.jsp");
}
 int Postid= Integer.parseInt(request.getParameter("post_id"));
 blogDao d=new blogDao(ConnectionProvider.getConnection());
 post p= d.getPostByPostId(Postid);
 likeDao ld=new likeDao(ConnectionProvider.getConnection());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
        <!--bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
          <!--css-->
          <link href="css/myStyles.css" rel="stylesheet" type="text/css"/>
     <!--icon css from font awesome intro-->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <style type="text/css">
	    
		    body{
		     background: url(img/b1.webp);
		         background-size: cover;
		    }
		        
	    </style>
	        

    </head>

<body>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v14.0" nonce="wXru8mkB"></script>
 <!-- nav started -->
			 <nav class="navbar navbar-expand-lg navbar-light primary-background1 ">
			  <div class="container-fluid">
			      <a class="navbar-brand text-light" href="index.jsp"><span class="fa fa-cubes"> </span>Blogs</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0 m-3">
			        <li class="nav-item">
			          <a class="nav-link active text-light" aria-current="page" href="Profile.jsp">
			              <span class="fa fa-rocket"></span>
			              Learn with us</a>
			        </li>
			        
			        
			        
			         
			         
			       
	     </ul>
		 <ul class="navbar-nav mr-right">
		 	  <li class="nav-item text-light">
			    <a data-bs-toggle="modal" data-bs-target="#profile-modal"><span class="fa fa-user-circle m-2 text-light"></span><%=user.getName() %></a>
			    <!-- here rather than page link in anchor tag we give modal and modal target (which model to run) -->
			  </li>
			  <li class="nav-item">
			         <a href="LogoutServlet1" class=" text-light " style="text-decoration: black"><span class="fa fa-user-o m-2"></span>Logout</a>
			  </li>        
			      
			      
			      
			      
		 </ul>
			      
			      
			      
			    </div>
			  </div>
			</nav>
<!--end of nav-->

<!-- start of main card for showing perticular post  -->		
	<div class="container">
		<div class="row mt-2 ">
		    <div class="col-md-8 offset-md-2">
		        <div class="card text-center">
		            <div class="post-title primary-background">
		            
		                 <h4> <%=p.getpTitle() %> </h4> 

		            </div>
		            <div class="card-body ">
		                 
		                <img src="img/<%=p.getpPic() %>" class="card-img-top my-2 text-center" height="250" width="100" alt="N.A" >
		                
		                 <div class="row my-3">
		                 <div class="col-md-7">
		                 <%
		                 UserDao d1=new UserDao(ConnectionProvider.getConnection());
		
		                 %>
		                 Posted by : <b><%=d1.getUserByUserId(p.getUserId()).getName() %></b>
		                 </div>
		                 
		                 <div class="col-md-5">
		                 Post Category: <b>Java</b>
		                 </div>
		                 
		                 </div>
		                 
		                  <%=p.getpContent() %> 
                         <br><br>
                         <div class="post-code">
                         <pre> <%=p.getpCode() %> </pre>
                         </div>
                         
		            </div>
		            <div class="post-footer primary-background text-white ">
					<!-- url rewritting --> 
			        
						<a href="#" onclick="dolike(<%=p.getPid() %> , <%=user.getId() %> )" class="btn btn-outline-primary btn-sm"><i class =" fa fa-thumbs-o-up"></i><span class="like-counter"><%=ld.countLikeOnPost(p.getPid()) %></span></a>
						<a href="#" class="btn btn-outline-primary btn-sm"><i class ="fa fa-commenting-o"></i></a>
						
						
					</div> 
					<div class="card-footer">
							<div id="fb-root"></div>
						    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v14.0" nonce="bNttF3XU"></script>
						    <div class="fb-comments" data-href="http://127.0.0.1:5500/a.html<%=p.getPid() %>" data-width="500" data-numposts="5"></div>
					</div>
					
		        </div>
		     </div>
		</div>
	</div>
	
<!-- end of main card for showing perticular post -->		      				
                               


<!--profile model start  -->
          <div id="profile-details">
				<!-- Modal -->
				<div class="modal fade" id="profile-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header text-center">
				        <h5 class="modal-title text-centre" id="staticBackdropLabel">Profile info</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				        <div class="text-center" id="body_card">
				        <img src="pic/<%=user.getProfile() %>" class="img-fluid" style="border-radius: 50%; height: 100px;" >
				       
				          <br>
					      <h5><%=user.getName() %></h5>
					      <br>  
					      
					      <!-- details -->
					      
					        <table class="table">
					        
								  <tbody>
								  
								    <tr>
								      <th scope="row">ID : </th>
								      <td><%=user.getId() %></td>
								    </tr>
								    
								    <tr>
								      <th scope="row">Mail :</th>
								      <td><%=user.getMail() %></td>
								    </tr>
								    
								    <tr>
								      <th scope="row">Gender</th>
								      <td colspan="2"><%=user.getGender() %></td>
								    </tr>
								    
								    <tr>
								      <th scope="row">Status</th>
								      <td colspan="2"><%=user.getAbout()%></td>
								    </tr>
								    
								  </tbody>
							
							</table>
				        
				        </div>
				        </div>

					     <div id="profile-edit" style="display: none;" class="text-center">
					     <h2>Please edit carefully.</h2>
					     <form action="EditServlet" method="POST" enctype="multipart/form-data"><!-- enctype="multipart/form-data"  tells that it contain video photo or music -->
						     <table class="table">
						     	<tr>
						     		<td>ID:</td>
						     		<td> <%=user.getId() %></td>
						     	</tr>
						     	<tr>
						     		<td>Email:</td>
						     		<td><input type="email" class="form-control" name="user_email" value="<%=user.getMail()%>"> </td>
						     	</tr>
						     	<tr>
						     		<td>Name:</td>
						     		<td><input type="text" class="form-control" name="user_name" value="<%=user.getName() %> "> </td>
						     	</tr>
						     	<tr>
						     		<td>Password:</td>
						     		<td><input type="password" class="form-control" name="user_password" value="<%=user.getPassword()%>"> </td>
						     	</tr>
						     	<tr>
						     		<td>Gender:</td>
						     		<td><%=user.getGender().toUpperCase()%></td>
						     	</tr>
						     	<tr>
						     		<td>About:</td>
						     	    <td> 
						     	    	<textarea class="form-control" name="user_about" rows="3"><%=user.getAbout() %></textarea>
						     		</td>
						     	</tr>
						     	<tr>
						     		<td>New Profile pic:</td>
						     		<td><input type="file" name="image" class="form-control"></td>
						     	</tr>
						     	
						     </table>
						     
						     <button type="submit" class="btn-outline-primary  mb-3">save</button>
					     </form>
					     </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				        <button id="edit-profile-btn" type="button" class="btn btn-primary">Edit</button>
				      </div>
				    </div>
				  </div>
				</div>

	<!--profile model end  -->
	
	<!-- post modal start -->
	
				<!-- Modal -->
				<div class="modal fade" id="add-post-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="staticBackdropLabel">Provide post details.</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">

								<form action="AddPostServlet"  id="id-post-form" method="POST">
								<div class="form-group">
									<select class="form-control" name="cid">
										
										<option selected="selected" disabled="disabled">---select cataagory---</option>
										<% 
										blogDao blogcatagory =new blogDao(ConnectionProvider.getConnection());
										ArrayList<Category> list=blogcatagory.getAllCategories();
										for(Category c: list){
											
										
										%>
																			
										<option value="<%= c.getCid()%>"><%=c.getCname() %></option>																				
										
										<%
										}
										%>
									</select>
								
								<br>
								
								</div>
								
									<div class="form-group">
										<input type="text" name="pTitle" placeholder="Enter title of blog" class="form-control"/>

									</div>
									<br>
									
									
									<div class="form-group">
										<textarea class="form-control" name="pContent" style="height: 250px" placeholder="Enter your content"></textarea>

									</div>
									<br>
									<div class="form-group">
										<textarea class="form-control" name="pCode" style="height: 250px" placeholder="Enter your Code (if possible)"></textarea>

									</div>
									<br>
									
									<div class="form-group">
									<label>select pic for blog</label><br>
										<input type="file" name="pPic" >

									</div>
									 <div class="container text-center ">
									      <button type="button" class="btn btn-secondary ml-3" id= "cde" data-bs-dismiss="modal">Close</button>  
									      <button type="submit" id="btnsub" name="abc" class="btn btn-primary ml-3">Post</button>
									        
									        
									 </div>
								</form>

				      </div>
				      <br>
				    </div>
				  </div>
				</div>
	<!-- post modal ends -->
	
	</div >
	
	
	 <!--jquary-->
		 <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
		 integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		 <!--js from bootstrap-->
	   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
		 <!--custom js file-->
		 <script src="js/myjs.js" type="text/javascript"></script>
		 <!-- sweet alert cdn  -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	
	<script type="text/javascript" lib.js">
	function dolike(pid ,uid){
		const d = {
				uid :uid,
				pid :pid,
				operation: 'like'
				
			}

			
		$.ajax({
			url: "LikeServlet1",
			data:d,
			success : function (data , textStatus, jqXHR){
								if(data.trim()=='true'){
									let c=$(".like-counter").html();
                                    c++;
                                    $(".like-counter").html(c);
								}
								
							},

							error : function(jqXHR ,textStatus ,errorThrown){
								console.log("wrong")
							},
			
			
			
		})
	}
	


</script>
</body>
</html>

