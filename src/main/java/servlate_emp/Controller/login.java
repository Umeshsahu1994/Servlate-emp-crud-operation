package servlate_emp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlate_emp.dao.empdao;
import servlate_emp.dto.emp;
@WebServlet("/elogin")
public class login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		String email = req.getParameter("semail");
		String password = req.getParameter("spassword");
		
		
		emp lo = empdao.loginemp(email, password);
		
		
		if(lo.getEmail().equals(email)&& lo.getPassword().equals(password)) {
			PrintWriter oop = resp.getWriter();
			oop.println("success");	
		
	}
		else
		{
			PrintWriter oop = resp.getWriter();
			oop.println("invalidd");
		}
	}

}
