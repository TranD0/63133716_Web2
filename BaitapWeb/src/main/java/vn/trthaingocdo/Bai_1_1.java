package vn.trthaingocdo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class Bai_1_1
 */
public class Bai_1_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bai_1_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value1= request.getParameter("param1");
		String value2= request.getParameter("param2");
		response.setContentType("text/html");
		
		PrintWriter traVe =response.getWriter();
		traVe.append("Gía trị Param 1: ");
		traVe.append(value1);
		traVe.append("\n Gía trị Param 2: ");
		traVe.append(value2);
	}


}
