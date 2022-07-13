package TECH_BLOGGER.com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import TECH_BLOGGER.com.dao.UserDao;
import TECH_BLOGGER.com.entities.Message;
import TECH_BLOGGER.com.entities.User;
import TECH_BLOGGER.com.helper.ConnectionProvider;
import TECH_BLOGGER.com.helper.helper;

@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		fetching all data
		String email=request.getParameter("user_email");
		String name=request.getParameter("user_name");
		String password=request.getParameter("user_password");
		String about=request.getParameter("user_about");
		Part part=request.getPart("image");
		String imageNmae=part.getSubmittedFileName();
//		part datat type which store all info related to multipart data(img ,audio,video)
//		access name of img
		
//		lets fetch user from session
		HttpSession s=request.getSession();
		User user=(User) s.getAttribute("cu");
		
	    user.setName(name);
	    user.setMail(email);
	    user.setPassword(password);
	    user.setGender(user.getGender());
	    String oldfile=user.getProfile();
	    user.setProfile(imageNmae);
	    user.setAbout(about);
	    
	    UserDao userdao =new UserDao(ConnectionProvider.getConnection());
	    boolean ans=userdao.UpdateUser(user);
	    if(ans) {
//	    	input stream and path we need to use delete photo and update photo inputstream we get from part part and path we need to create
	    	String path = request.getRealPath("/")+"pic"+File.separator+user.getProfile();
//	    	request.getRealPath("/") takes you till project path img is folder name then for / u=we use file  seperator then name of file
	    	String oldpathfile = request.getRealPath("/")+"pic"+File.separator+oldfile;
	    	if(!oldpathfile.equals("default.png")) {
	    		boolean a=helper.deleteFile(oldpathfile);
	    	}
	    	
	    	
	    	
	    	if(helper.saveFile(part.getInputStream(), path)) {
	    		Message msg =new Message("all details updated successfully.!", "success", "alert-success");
				s.setAttribute("msg_session", msg);
				
	    	}else {
//	    		Message msg =new Message("something went wrong.!", "error", "alert-danger");
//				s.setAttribute("msg_session", msg);
	    		Message msg =new Message("all details updated successfully.!", "success", "alert-success");
				s.setAttribute("msg_session", msg);
				
		    }
	    	
	    }else {
	    	Message msg =new Message("something went wrong.!", "error", "alert-danger");
			s.setAttribute("msg_session", msg);
	    }
	    response.sendRedirect("Profile.jsp");
		
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
