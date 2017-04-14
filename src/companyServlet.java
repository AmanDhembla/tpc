

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class companyServlet
 */
@WebServlet("/companyServlet")
public class companyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public companyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String field=request.getParameter("field");
		if(field.equals("tech")){
			TechCompany c= new TechCompany();
			TechStudent t[]=new TechStudent[10];
			t=c.selectedTech(name);
			for(int i=0;i<10;i++){
				try{
					System.out.println(t[i].id+"  "+t[i].name);
				}
				catch(Exception e){}
			}
		}
		
		if(field.equals("non-tech")){
			NonTechCompany c= new NonTechCompany();
			NonTechstud t[]=new NonTechstud[10];
			t=c.selectedTech(name);
			for(int i=0;i<10;i++){
				try{
					System.out.println(t[i].id+"  "+t[i].name);
				}
				catch(Exception e){}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String field=request.getParameter("field");
		//System.out.println(sdate+edate+field);
		if(field.equals("tech")){
		TechCompany c= new TechCompany();
		TechCompany d[] = new TechCompany[10];
		d=c.CompanyVisit(sdate,edate);
		for(int i=0;i<10;i++){
			try{
				System.out.println(d[i].name+"  "+d[i].visitdate);
			}
			catch(Exception e){}
		}
	}
		
		if(field.equals("non-tech")){
			NonTechCompany c= new NonTechCompany();
			NonTechCompany d[] = new NonTechCompany[10];
			d=c.CompanyVisit(sdate,edate);
			for(int i=0;i<10;i++){
				try{
					System.out.println(d[i].name+"  "+d[i].visitdate);
				}
				catch(Exception e){}
			}
		}

}
}
