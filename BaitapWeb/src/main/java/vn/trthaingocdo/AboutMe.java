package vn.trthaingocdo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AboutMe
 */
public class AboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	response.setCharacterEncoding("utf-8");
    	PrintWriter traVe = response.getWriter();
    	traVe.append("Bạn vừa gửi yêu cầu dạng GET, đây là đáp ứng của tôi");
    	String noiDungHTML =" <form method= POST action=\"/BaitapWeb/AboutMe\""
    			+" <label>Họ:</label>"
    			+" <input type=\"text\" name=\"fname\" ><br>\r\n"
    			+" <label>Tên:</label>"
    			+" <input type=\"text\" name=\"lname\" ><br>"
    			+" <label>Mã số sinh viên:</label>"
    			+" <input type=\"text\" name=\"mssv\" ><br>"
    			+" <input type=\"submit\" value=\"gửi đi\">"
    			+ "<form>";
    	traVe.append(noiDungHTML);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
    	response.setCharacterEncoding("utf-8");
    	String value1 = request.getParameter("fname");
    	String value2= request.getParameter("lname");
    	String value3= request.getParameter("mssv");
    	PrintWriter traVe = response.getWriter();
    	traVe.append("thông tin của bạn");
    	traVe.append("Họ bạn là: ");
    	traVe.append(value1);
    	traVe.append("\n Tên bạn là:");
    	traVe.append(value2);
    	traVe.append("\n Mã số sinh viên: ");
    	traVe.append(value3);
	}

}
