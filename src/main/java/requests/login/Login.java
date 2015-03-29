package requests.login;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import core.db.sqlite.ConnectSQLite3;
import core.db.sqlite.FilePath;
import core.db.sqlite.storedfunction.LoginQuery;
import core.db.tables.Tables;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
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
		OutputStream out = response.getOutputStream();
		out.write("<p>Login in...</p><br>".getBytes());

		String login = request.getParameterMap().get("login")[0];
		String password = request.getParameterMap().get("passwd")[0];
		
		LoginQuery query = new LoginQuery(login, password);
		
		ConnectSQLite3 conn = new ConnectSQLite3(FilePath.DATABASE_SOURCE.toString());
		conn.connect();
		try {
			ResultSet rs = conn.executeQuery(query.getSQL());

			if(!conn.isResultSetEmpty()) {
				HttpSession session = request.getSession();
				User user = new User(rs, session);
				session.setAttribute(Tables.USERS.toString(), user);
				session.setMaxInactiveInterval(30 * 60);
				response.sendRedirect("timesheet.jsp");
			} else {
				out.write("<script type=\"text/javascript\">alert('Wrong login or password.');window.location.assign(\"login.jsp\");</script>".getBytes());
			}
			rs.close();
			
		} catch(Exception ex) {
			out.write(ex.getMessage().getBytes());
		} finally {
			conn.closeConnection();
			out.flush();
			out.close();
		}
	}
}
