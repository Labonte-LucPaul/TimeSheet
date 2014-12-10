package requests.settings.projects;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.storedproc.projects.SelectProjects;

/**
 * Servlet implementation class Projects
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/getProjects", 
				"/UpdateProjects"
		})
public class Projects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Projects() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getServletPath();
		ServletOutputStream  out = response.getOutputStream();

		if(s.equalsIgnoreCase("getProjects")) {
			SelectProjects select = new SelectProjects();
			select.getJSON().write(response.getWriter());
			//out.write(select.getJSON().toString().getBytes());
		
		} else if(s.equalsIgnoreCase("UpdateProjects")) {
			
		} else {
			out.flush();
			out.close();
			new Exception("Projects POST Wrong pattern: " + s);
		}
		out.flush();
		out.close();
	}

}
