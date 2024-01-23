package vn.trthaingocdo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BMI
 */
public class BMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMI() {
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
    	String noiDungHTML =" <form method= POST action=\"/BaitapWeb/BMI\""
    			+" <label>Chiều cao(cm):</label>"
    			+" <input type=\"text\" name=\"height\" ><br>\r\n"
    			+" <label>Cân nặng(kg):</label>"
    			+" <input type=\"text\" name=\"weight\" ><br>"
    			+" <input type=\"submit\" value=\"gửi đi\">"
    			+ "<form>";
    	traVe.append(noiDungHTML);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
    	response.setCharacterEncoding("utf-8");
    	String value1 = request.getParameter("height");
    	String value2= request.getParameter("weight");
    	 float height = Float.parseFloat(value1)*(float)0.01;
    	    float weight = Float.parseFloat(value2);
    	PrintWriter traVe = response.getWriter();
    	float kq= weight/(height*height);
    	traVe.append("Chỉ số BMI của bạn là:"+kq);
	}

}
