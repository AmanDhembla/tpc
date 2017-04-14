

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tpoServletNonTech
 */
@WebServlet("/tpoServletNonTech")
public class tpoServletNonTech extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tpoServletNonTech() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String rollno=request.getParameter("rollno");
		String toEdit=request.getParameter("edit");
		String value=request.getParameter("value");
		System.out.println(rollno);
		tpo t=new tpo();
		t.editNonTechStudent(toEdit, rollno, value);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String rollno=request.getParameter("rollno");
		String name=request.getParameter("name");
		String emailID=request.getParameter("emailID");
		String company=request.getParameter("company");
		String password=request.getParameter("password");
		String interest=request.getParameter("interest");
		double salary= Double.parseDouble(request.getParameter("salary"));
		int status=Integer.parseInt(request.getParameter("status"));
		double cpi= Double.parseDouble(request.getParameter("cpi"));
		//System.out.println(rollno+name);
		tpo t=new tpo();
		t.insertNonTechStud(rollno,name,password,emailID,cpi,
				status,company,salary,interest);
		response.sendRedirect("successful.html");
	}

}
