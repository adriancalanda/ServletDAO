package es.open4job.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class BaseDatosDAO {

	private String driver;
	private String url;
	private String user;
	private String password;
	protected Connection connection = null;

	public BaseDatosDAO() {
		 driver = "oracle.jdbc.driver.OracleDriver";
		 String host = "54.154.192.80";
		 String puerto = "1521";
		 String sid = "xe";
		 user = "test";
		 password = "test";
		 url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection abrirConexion() throws SQLException, ClassNotFoundException {
		Connection conection = null;
		try {
			Class.forName(driver);
			conection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return conection;
	}

	public void cerrarConexion() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
