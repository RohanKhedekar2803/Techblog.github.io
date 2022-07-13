package TECH_BLOGGER.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import TECH_BLOGGER.com.dao.likeDao;
import TECH_BLOGGER.com.helper.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LikeServlet1  extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
        	out.print("data from server");
    		String operation=request.getParameter("operation");
    		int  uid=Integer.parseInt(request.getParameter("uid"));
    		int  pid=Integer.parseInt(request.getParameter("pid"));
    		
    		likeDao ld=new likeDao(ConnectionProvider.getConnection());
    		if(operation.equals("like")) {
    			boolean f=ld.insertLike(pid, uid);
    			out.print(f);
    		}
    		
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
//		String operation=request.getParameter("operation");
//		int  uid=Integer.parseInt("uid");
//		int  pid=Integer.parseInt("pid");
		out.print("data from server");
//		response.getWriter().append("Served at:kk ").append("hihi");
//		out.print(operation+" "+uid+" "+pid);
	
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
