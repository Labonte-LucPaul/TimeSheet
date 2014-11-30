package initialconfig;

import initialconfig.createdb.CreateAndPopulateTables;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.sqlite.ConnectSQLite3;
import core.db.sqlite.FilePath;
import core.db.tables.TabUsers;

/**
 * Servlet implementation class InitConfig
 */
@WebServlet("/InitConfig")
public class InitConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitConfig() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
		CreateAndPopulateTables create = new CreateAndPopulateTables(request.getParameterMap());
		create.execute();
		
		//ConnectSQLite3 conn = new ConnectSQLite3(FilePath.DATABASE_SOURCE.toString());
		//conn.connect();
		try {
			StringBuilder str = new StringBuilder();

			str.append("<script type=\"text/javascript\">alert('Initialization completed successfully.\nRedirecting to login page.');");
			str.append("window.location.assign(\"login.jsp\");");
			str.append("</script>");
			
			OutputStream out = response.getOutputStream();
			out.write(str.toString().getBytes());
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
