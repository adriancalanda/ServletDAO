package es.open4job.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.open4job.model.vo.EstacionServicioVO;



public class EstacionServicioDAO {

	
	// Listado de la estacion de servicio
	
		public ArrayList<EstacionServicioVO> getlistaServicio() throws Exception {
		
			Connection conexion = getDataSource().getConnection();
			ArrayList<EstacionServicioVO> lista = new ArrayList<EstacionServicioVO>();
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM ESTACION_SERVICIO");
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				lista.add(new EstacionServicioVO(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6)));
			}
			
		return lista;
		}
		
		//Devuelve la la estacion de servicio por el id
		
		public  EstacionServicioVO getEstacionServicio(int id) throws Exception {
			
			Connection conexion = getDataSource().getConnection();
			EstacionServicioVO idLista = null;
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM ESTACION_SERVICIO WHERE id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()){
				idLista = new EstacionServicioVO(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6));
			}
		return idLista;
		
		}
		public DataSource getDataSource() throws Exception {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");

			return ds;
			
		}
		
}

