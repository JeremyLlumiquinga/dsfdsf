package com.krakedev.EvaluacionGrupal1.metodos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.krakedev.EvaluacionGrupal1.conexion.ConexionBDD;

import com.krakedev.EvaluacionGrupal1.exepcion.KrakedevException;

public class EliminarGrupo {
public void EliminarGrupos(String id) throws KrakedevException{
		
		
		
		Connection con= null;
		PreparedStatement ps= null;
		
		
		try {
			con=ConexionBDD.obtenerConexion();
				ps=con.prepareStatement("delete from grupos where id=?");
				ps.setString(1, id);
				ps.executeUpdate();
		}
			 catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
				e.printStackTrace();
				throw new KrakedevException("Error al eliminar grupo"+e.getMessage());
			}
		
		
		
		}
}
