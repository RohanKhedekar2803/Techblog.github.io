package TECH_BLOGGER.com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.PingTarget;
import com.mysql.cj.Session;

import TECH_BLOGGER.com.dao.blogDao;
import TECH_BLOGGER.com.entities.Message;
import TECH_BLOGGER.com.entities.User;
import TECH_BLOGGER.com.entities.post;
import TECH_BLOGGER.com.helper.ConnectionProvider;
import TECH_BLOGGER.com.helper.helper;

@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
//take out all data in local variables from form
		String Title=request.getParameter("pTitle");
		int cid = Integer.parseInt(request.getParameter("cid"));
		String Content=request.getParameter("pContent");
		String Code=request.getParameter("pCode");
		String imgpath=request.getParameter("pPic");
		Part part =request.getPart("pPic");
		
		
	//using seession take out id of user	
		HttpSession s=request.getSession();
		User user = (User)s.getAttribute("cu");
		int userid=user.getId();
		
		
//           create object of post
		post p=new post(Title, Content, Code , part.getSubmittedFileName(),cid, userid);
	//create object of dao which are mwthods to save post	
		blogDao dao=new blogDao(ConnectionProvider.getConnection());
		log("hiiiiii");
		if(dao.savePostInDb(p)) {
			String pathfile = request.getRealPath("/")+"img"+File.separator+part.getSubmittedFileName();
            helper.saveFile(part.getInputStream(), pathfile);
            
            out.println("done");
		}else {
			log("no");
		}

	}

}
