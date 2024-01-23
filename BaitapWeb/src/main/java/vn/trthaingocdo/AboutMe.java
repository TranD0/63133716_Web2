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
    	String noiDungHTML ="<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:14px;margin-left:50px;\">\r\n"
    			+ "    <tr>\r\n"
    			+ "        <td>\r\n"
    			+ "            <table cellpadding=\"2\" cellspacing=\"10\">\r\n"
    			+ "                <caption><b>THÔNG TIN CHI TIẾT</b></caption>\r\n"
    			+ "                <tr>\r\n"
    			+ "                    <td>Mã số sinh viên:</td>\r\n"
    			+ "                    <td>63133716</td>\r\n"
    			+ "                </tr>\r\n"
    			+ "                <tr>\r\n"
    			+ "                    <td>Họ và tên:</td>\r\n"
    			+ "                    <td>Trần Thái Ngọc Đô</td>\r\n"
    			+ "                </tr>\r\n"   		  
    			+ "                <tr>\r\n"
    			+ "                    <td>Giới tính:</td>\r\n"	
    			+ "                    <td>Nam</td>\r\n"	
    			+ "                <tr>\r\n"
    			+ "                    <td>Ngày sinh:</td>\r\n"
    			+ "                    <td>18/08/2003</td>\r\n"
    			+ "                </tr>\r\n"
    			+ "                <tr>\r\n"
    			+ "                    <td>Địa chỉ:</td>\r\n"
    			+ "                    <td>Nha Trang</td>\r\n"
    			+ "                </tr>\r\n"
    			+ "            </table>\r\n"
    			+ "        </td>\r\n"
    			+ "    </tr>\r\n"
    			+ "</table>";
    	traVe.append(noiDungHTML);
    }
    


}
