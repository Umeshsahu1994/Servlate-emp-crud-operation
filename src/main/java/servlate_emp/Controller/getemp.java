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
@WebServlet("/get")
public class getemp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("ename");
		
		emp em = empdao.update(id, name);
		PrintWriter out = resp.getWriter();
		if(em!=null) {
			
			out.println("update Successfully");
		}
		else
		{
			out.println("not any data");
			RequestDispatcher ress = req.getRequestDispatcher("get.html");
			ress.forward(req, resp);
			
		}
	}

}
