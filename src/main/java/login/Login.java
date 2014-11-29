package login;

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
import core.db.sqlite.querybuilder.BooleanType;
import core.db.sqlite.querybuilder.ConditionEquals;
import core.db.sqlite.querybuilder.Select;
import core.db.tables.TabUsers;
import core.db.tables.Tables;

/**
 * Servlet implementation class Login
 */
@WebServlet(asyncSupported = true, description = "Class that authenticate.", urlPatterns = { "/login" })
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
		
		Select select = new Select(Tables.USERS.toString());
		select.addColumnName("*");
		
		ConditionEquals condLogin = new ConditionEquals("login");
		condLogin.setBooleanAfter(BooleanType.AND);
		condLogin.setField(TabUsers.LOGIN.toString(), login);
		select.addCondition(condLogin);
		
		ConditionEquals condPasswd = new ConditionEquals("passwd");
		condPasswd.setField(TabUsers.PASSWD.toString(), password);
		select.addCondition(condPasswd);		
		
		//out.write(select.toSQL().getBytes());
		
		ConnectSQLite3 conn = new ConnectSQLite3(FilePath.DATABASE_SOURCE.toString());
		conn.connect();
		
		try {
			StringBuilder str = new StringBuilder();
			ResultSet result = conn.executeQuery(select.toSQL());
			
			while(result.next()) {
				str.append("<p>");
				str.append(result.getString(TabUsers.UID.toString()));
				str.append(" | ");
				str.append(result.getString(TabUsers.FIRST_NAME.toString()));
				str.append(" | ");
				str.append(result.getString(TabUsers.LAST_NAME.toString()));
				str.append(" | ");
				str.append(result.getString(TabUsers.LOGIN.toString()));
				str.append(" | ");
				str.append(result.getString(TabUsers.PASSWD.toString()));
				str.append(" | ");
				str.append(result.getString(TabUsers.EMAIL.toString()));
				str.append("</p>");
			}
			if(str.length() > 0) {
				out.write(str.toString().getBytes());
				out.write(("<p>" + request.getSession().getId() + "</p>").getBytes());
				request.getSession().invalidate();
			} else {
				out.write("<script type=\"text/javascript\">alert('Wrong login or password.');window.location.assign(\"./login.jsp\");</script>".getBytes());
			}
			
		} catch (Exception e) {
			out.write("FUCK!".getBytes());
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
