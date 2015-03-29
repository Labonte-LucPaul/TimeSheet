package requests.settings.projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import core.db.storedproc.projects.InsertProject;
import core.db.storedproc.projects.RemoveProject;
import core.db.storedproc.projects.SelectProjects;

/**
 * Servlet implementation class Projects
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/getProjects", 
				"/UpdateProjects",
				"/DeleteProject"
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

		if(s.equalsIgnoreCase("/getProjects")) {
			SelectProjects select = new SelectProjects();
			String strJson = select.getJSON().toString();
			out.write(strJson.getBytes());

		} else if(s.equalsIgnoreCase("/UpdateProjects")) {
			InsertProject insert = new InsertProject(getJsonObject(request.getInputStream()));
			insert.executeQuery();
			
		} else if(s.equalsIgnoreCase("/DeleteProject")) {
			RemoveProject insert = new RemoveProject(getJsonObject(request.getInputStream()));
			insert.executeQuery();
			
		} else {
			out.flush();
			out.close();
			new Exception("Projects POST Wrong pattern: " + s + "\nRequired \"getProjects\" or \"UpdateProjects\".");
		}
		out.flush();
		out.close();
	}

	private JSONObject getJsonObject(ServletInputStream stream) {
		
		JSONObject json = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String strJson = "";
        try {
	        if(br != null){
	        	strJson = br.readLine();
	        }
	        br.close();
	        json = new JSONObject(strJson);
        } catch(JSONException | IOException e) {
        	e.printStackTrace();
        }
        
        return json;
	}
}
