package es.open4job.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.open4job.model.vo.EstacionServicioVO;



public class EstacionServicioDAO {

	
	// Listado de la estacion de servicio
	
		public ArrayList<EstacionServicioVO> getlistaServicio(Connection conexion) throws SQLException {
		
	
			ArrayList<EstacionServicioVO> lista = new ArrayList<EstacionServicioVO>();
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM ESTACION_SERVICIO");
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				lista.add(new EstacionServicioVO(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6)));
			}
			
		return lista;
		}
		
		//Devuelve la la estacion de servicio por el id
		
		public  EstacionServicioVO getEstacionServicio(int id, Connection conexion) throws SQLException {
			
			
			EstacionServicioVO idLista = null;
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM ESTACION_SERVICIO WHERE id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()){
				idLista = new EstacionServicioVO(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6));
			}
		return idLista;
		
		}
		
}

