

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CellMemberServlet
 */
@WebServlet("/CellMemberServlet")
public class CellMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CellMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String userid=request.getParameter("userid");
		String toEdit=request.getParameter("edit");
		String value=request.getParameter("value");
		System.out.println(userid);
		tpo t=new tpo();
		t.editCellMember(toEdit, userid, value);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String userID=request.getParameter("userID");
		String name=request.getParameter("name");
		String emailID=request.getParameter("emailID");
		String category=request.getParameter("category");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		String gender=request.getParameter("gender");
		String year=request.getParameter("year");
		tpo t=new tpo();
		t.insertCellMember(userID,name,password,emailID,contact,
				year,gender,category);
	}

}
