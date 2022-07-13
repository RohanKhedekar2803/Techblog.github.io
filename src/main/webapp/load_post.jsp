<%@page import="TECH_BLOGGER.com.dao.UserDao"%>
<%@page import="TECH_BLOGGER.com.dao.likeDao"%>
<%@page import="TECH_BLOGGER.com.entities.post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TECH_BLOGGER.com.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="TECH_BLOGGER.com.dao.blogDao"%>
<%@page import="TECH_BLOGGER.com.entities.User"%>


<div class="row">
<% 
likeDao ld=new likeDao(ConnectionProvider.getConnection()); 
blogDao b=new blogDao(ConnectionProvider.getConnection());
User user=(User)session.getAttribute("cu");
if(user==null){
	response.sendRedirect("Login_page.jsp");
}
ArrayList<post> lst=null;
int catid=Integer.parseInt(request.getParameter("cid"));

  if(catid==0){
	   lst=b.getAllposts();
  }else{
	  lst=b.getPostByCatId(catid);
  }
  
  if(lst.size()==0){
	  out.print("<h4 class='text-center'>NO posts in this category.</h4>");
	  return;
  }
  
 
  for(post p : lst){
	%>
	
	<div class="col-6">
			<div class="card ">   
					<div class="card-body text-center outline-primary">
			            <img src="img/<%=p.getpPic() %>" class="card-img-top" alt="N.A" height="242" width="42" >
					    <br>
						<b><%=p.getpTitle() %></b>
						<pre><%=p.getpContent()%></pre>
						
						
					</div>
					<div class="card-footer  ">
					<!-- url rewritting -->
					
					<a href="Single_Blog.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-primary btn-sm">Read More...</a>
					<a href="#" onclick="dolike(<%=p.getPid() %> , <%=user.getId() %> )" class="btn btn-outline-primary btn-sm"><i class ="fa fa-thumbs-o-up"></i><%=ld.countLikeOnPost(p.getPid()) %></a>
					<a href="Single_Blog.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-primary btn-sm"><i class ="fa fa-commenting-o"></i></a>
					<% UserDao d1=new UserDao(ConnectionProvider.getConnection());%>
					
                     
								
				
					
					</div>
					
			</div>
	 </div>
	 
<%  
  }
%>
  </div>
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


