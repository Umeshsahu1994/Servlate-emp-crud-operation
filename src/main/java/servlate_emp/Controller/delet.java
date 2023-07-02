package servlate_emp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlate_emp.dao.empdao;
import servlate_emp.dto.emp;
@WebServlet("/delet")
public class delet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 int id = Integer.parseInt(req.getParameter("id"));
		emp od = empdao.delet(id);
		PrintWriter out = resp.getWriter();
		if(od!=null) {
			out.println("delet successfully");
		}
		else {
			out.println("invalid details");
		}
	}

}
