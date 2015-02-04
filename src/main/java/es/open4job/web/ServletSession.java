package es.open4job.web;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.open4job.model.dao.BaseDatosDAO;
import es.open4job.model.dao.EstacionServicioDAO;
import es.open4job.model.vo.EstacionServicioVO;


public class ServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(ServletTaxis.class
			.getName());
       
    
    public ServletSession() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=0;
		HttpSession session = request.getSession(true);
		
		String idInt = (String)session.getAttribute("id");
		id = Integer.parseInt(idInt);
		
		//BaseDatosDAO bbdd = new BaseDatosDAO();
		
		try {
			
			//Connection conexion = bbdd.abrirConexion();
			EstacionServicioDAO estacionServicioDAO = new EstacionServicioDAO();
			EstacionServicioVO estacionServicioVO = estacionServicioDAO.getEstacionServicio(id);
			
			request.setAttribute("estacionServicioVO", estacionServicioVO);
			
			//Vista
			request.getRequestDispatcher("EstacionamientoSession.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//bbdd.cerrarConexion();
	
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
