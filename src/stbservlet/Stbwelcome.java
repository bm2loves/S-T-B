package stbservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stbbean.*;
import stbdao.Authenticationdata;
/**
 * Servlet implementation class Stbwelcome
 */
@WebServlet("/Stbwelcome")
public class Stbwelcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Authname= request.getParameter("Uname");
		String Authpass= request.getParameter("Upass");
		
		Authentication auth=new Authentication();
		auth.setAuthname(Authname);
		 
		//Authenticationdata authdata=new Authenticationdata();
		
		if(Authenticationdata.checkit(Authname, Authpass)) {
			if(Authname.equals("Biswa")) {
				HttpSession stbsession=request.getSession();
				stbsession.setAttribute("Authname", Authname);
				request.getRequestDispatcher("StbAdmin.jsp").forward(request, response);
			}else {
				HttpSession stbsession=request.getSession();
				stbsession.setAttribute("Authname", Authname);
				request.getRequestDispatcher("fstb.html").forward(request, response);
			}
		}else {
			request.setAttribute("Error Anywhere!", Authenticationdata.checkit(Authname, Authpass));
			request.getRequestDispatcher("stblogin1rg.html").include(request, response);
		}
		
		
		
		
	}


}
