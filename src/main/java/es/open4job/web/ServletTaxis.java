package es.open4job.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.open4job.model.dao.EstacionServicioDAO;
import es.open4job.model.vo.EstacionServicioVO;
import es.open4job.model.dao.BaseDatosDAO;



public class ServletTaxis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(ServletTaxis.class
			.getName());
       
   
    public ServletTaxis() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Controlador
		int id=0;
		String idInt = (String)request.getParameter("id");
		id = Integer.parseInt(idInt);
		//Modelo
		BaseDatosDAO bbdd = new BaseDatosDAO();
		
		try {
			
			Connection conexion = bbdd.abrirConexion();
			EstacionServicioDAO estacionServicioDAO = new EstacionServicioDAO();
			EstacionServicioVO estacionServicioVO = estacionServicioDAO.getEstacionServicio(id, conexion);
			//Vista
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>"+estacionServicioVO.toString()+"</h1>");
			out.println("</body>");
			out.println("</html>");
			
			
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
		
		bbdd.cerrarConexion();
	
	}


}
