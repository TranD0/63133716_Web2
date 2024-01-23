package vn.trthaingocdo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Bai_1_2
 */
public class Bai_1_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bai_1_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	response.setCharacterEncoding("utf-8");
    	PrintWriter traVe = response.getWriter();
    	traVe.append("Bạn vừa gửi yêu cầu dạng GET, đây là đáp ứng của tôi");
    	String noiDungHTML =" <form method= POST action=\"/BaitapWeb/Bai_1_2\""
    			+" <label>Họ:</label>"
    			+" <input type=\"text\" name=\"fname\" ><br>\r\n"
    			+" <label>Tên:</label>"
    			+" <input type=\"text\" name=\"lname\" ><br>"
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
    	PrintWriter traVe = response.getWriter();
    	traVe.append("bạn vừa gửi yêu cầu dạng POST, đây là đáp ứng của tôi");
    	traVe.append("giá trị fname=");
    	traVe.append(value1);
    	traVe.append("\n giá trị lname=");
    	traVe.append(value2);
	}

}
