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
import javax.servlet.http.HttpSession;

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
		//int id=0;
		HttpSession session = request.getSession(true);
		String idInt = (String)request.getParameter("id");
		//id = Integer.parseInt(idInt);
		//Modelo
		//Realización getSession para guardar la sesion.
		session.setAttribute("id",idInt);
		request.getRequestDispatcher("Confirmacion.jsp").forward(request, response);
		
		/*BaseDatosDAO bbdd = new BaseDatosDAO();
		
		try {
			
			Connection conexion = bbdd.abrirConexion();
			EstacionServicioDAO estacionServicioDAO = new EstacionServicioDAO();
			EstacionServicioVO estacionServicioVO = estacionServicioDAO.getEstacionServicio(id, conexion);
			
			//Vista
		
			//Realización de getrequest sin guardar la sesión.
			
			request.setAttribute("Estacionamiento",estacionServicioVO);
			request.getRequestDispatcher("Estacionamientoid.jsp").forward(request,response);
			
			
			
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
		
		bbdd.cerrarConexion();*/
	
	}


}
