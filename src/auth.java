

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Cell_Member.CellMember;
import stu.student;
/**
 * Servlet implementation class servlet
 */
@WebServlet(description = "first servelet", urlPatterns = { "/servletReady" })
public class auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter p= response.getWriter();
		response.setContentType("text/html");
		//System.out.println();
		//p.print("<h2>hello all</h2>");
		String rollno=request.getParameter("rollno");
		String pass=request.getParameter("password");
		String des=request.getParameter("Designation");
		p.println(rollno+pass+des);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter p= response.getWriter();
		response.setContentType("text/html");
		//System.out.println();
		//p.print("<h2>hello all</h2>");
		String rollno=request.getParameter("rollno");
		String pass=request.getParameter("password");
		String des=request.getParameter("Designation");
		
		HttpSession session=request.getSession();    
		//p.println(rollno+pass+des);
		
		vald v=new vald();
		int val;
		val=v.validate(rollno, pass,des);
		if(val==1  & des.equals("student")){
			//p.print("heeloo");
		student s=new student();
		
		s.getdata(rollno);
		
		session.setAttribute("s",s);
		
		response.sendRedirect("sinfo.jsp");
		
		}
		if(val==1 & des.equals("tpo")){
			response.sendRedirect("tpo.html");
		}
		if(val==1 & des.equals("cell_members")){
			CellMember c=new CellMember();
			
			c.showDetails(rollno);
			
			session.setAttribute("c",c);
			
			response.sendRedirect("CellMemberInfo.jsp");
		}
		if(val==0)
			response.sendRedirect("invalid.html");
		p.print(val);
	}
	

}

