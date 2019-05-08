package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
//@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleConnection d=new SimpleConnection();
	Connection con=d.EstablishingConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int flag=0;
		
		PrintWriter out=response.getWriter();
		out.println("<h1>First Servlet</h1>");
		
		String u=request.getParameter("username");
		String pw=request.getParameter("password1");
		
		Statement stmt=null;
		try {
			stmt=con.createStatement();
			String sql="select username,password from userdatabase";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String u1=rs.getString("username");
				String p1=rs.getString("password");
				
				if(u.equals(u1) && pw.equals(p1))
				{
					flag = 1;
					break;
				}
				else
				{
					flag=0;
				}	
			}
			
			if(flag==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/LoggedIn.html");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("http://localhost:8082/IWP_PROJECT/Servlet3");
				
				//response.getWriter().append("<h5>Invalid Credintials!</h5>").append("<h5>Please try again..........</h5>");
				/*out.println("<h5>Invalid Credintials!</h5>");
				out.println("<h5>Please try again..........</h5>");*/
				
				/*RequestDispatcher rd=request.getRequestDispatcher("/LoginForm.html");
				rd.include(request, response);*/
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*if(u.equals("seed") && pw.equals("seed"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/Servlet2");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("http://localhost:8082/IWP_PROJECT/Servlet3");
			
			//response.getWriter().append("<h5>Invalid Credintials!</h5>").append("<h5>Please try again..........</h5>");
			out.println("<h5>Invalid Credintials!</h5>");
			out.println("<h5>Please try again..........</h5>");
			
			RequestDispatcher rd=request.getRequestDispatcher("/LoginForm.html");
			rd.include(request, response);
		}*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
