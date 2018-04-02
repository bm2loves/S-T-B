package stbservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import stbdao.Detailsofstb;
import stbbean.Trashbindetails;

/**
 * Servlet implementation class Watchit
 */
@WebServlet("/Watchit")
public class Watchit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			 String BinId=request.getParameter("BinId");
			 
			 Detailsofstb dstb=new Detailsofstb();
			 
			 Trashbindetails tsb=new Trashbindetails();
			 
			 tsb.setBinId(BinId);
			 
		    List<Trashbindetails> bindetails=dstb.tsbdetails(BinId);
	   	    request.setAttribute("bindetails", bindetails);
			RequestDispatcher rsd = request.getRequestDispatcher("bindetails.jsp");
			rsd.forward(request, response);
		
	}
}
