import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDAO;

public class FormReader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");

		// START VALIDATION OF THE INPUT
		boolean check = true;

		String errorMessages = "<html>";

		// Check if phone number is 10 digits in length
		if (phone.length() != 10) {
			errorMessages += "<h1><font color=red>Sorry invalid phone number (too long)</font></h1>";
			check = false;
		}

		Validation val = new Validation();

		// Check if phone number is 10 digits in length
		if (val.checkNum(phone) == false) {
			errorMessages += "<h1><font color=red>Sorry invalid phone number (not a valid number)</font></h1>";
			check = false;
		}

		// check if age is a number
		if (val.checkNum(age) == false) {
			errorMessages += "<h1><font color=red>Sorry invalid age (not a valid number)</font></h1>";
			check = false;
		}

		// check if email is valid

		if (email.contains("@") == false || email.contains(".") == false) {
			errorMessages += "<h1><font color=red>Sorry invalid email (missing a . or @ symbol)</font></h1>";
			check = false;
		}

		errorMessages += "</html>";

		// Either show them the error messages or success message
		if (check == true) {

			// Use the DAO and call its insert method to insert the form data
			// into the mySQL database
			RegistrationDAO dao = new RegistrationDAO();
			
			//Convert the age (String) value to an integer
			int ageValue = Integer.parseInt(age);
			
			//CALL THE INSERT METHOD
			dao.insertData(fname + " " + lname, email, phone, ageValue);

			response.getWriter().print(
					"<html><h1>Thanks for registering " + fname + " " + lname
							+ "</h1></html>");
		} else {
			response.getWriter().print(errorMessages);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
