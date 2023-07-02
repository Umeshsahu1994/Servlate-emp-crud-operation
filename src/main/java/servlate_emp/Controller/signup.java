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
@WebServlet("/sign")
public class signup extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nam = req.getParameter("sname");
		long num = Long.parseLong(req.getParameter("sphone")) ;
		String address = req.getParameter("saddress");
		String email = req.getParameter("semail");
		String password = req.getParameter("spassword");
		
		emp p=new emp();
		p.setName(nam);
		p.setPhone(num);
		p.setAddress(address);
		p.setEmail(email);
		p.setPassword(password);
		
		empdao.saveStudent(p);
		RequestDispatcher lo = req.getRequestDispatcher("home.html");
		lo.forward(req, resp);
	}

}
