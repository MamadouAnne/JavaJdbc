import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormReader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");
		
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(age);
		
		//Check if phone number is 10 digits in length
				if (phone.length() == 10) {
					response.getWriter().print("<html><h1>Thanks for registering " + fname + " " + lname + "</h1></html>");
				} else {
					response.getWriter().print("<html><h1><font color=red>Sorry invalid phone number</font></h1></html>");
				}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet (request, response);
	}

}

