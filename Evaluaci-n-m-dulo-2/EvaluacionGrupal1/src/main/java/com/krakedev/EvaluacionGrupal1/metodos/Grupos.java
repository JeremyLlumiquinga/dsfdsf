package com.krakedev.EvaluacionGrupal1.metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.EvaluacionGrupal1.conexion.ConexionBDD;
import com.krakedev.EvaluacionGrupal1.entidades.Grupo;

import com.krakedev.EvaluacionGrupal1.exepcion.KrakedevException;

public class Grupos {
	public void insertar(Grupo grupo) throws KrakedevException {
		Connection con= null;
		PreparedStatement ps= null;
		try {
			con=ConexionBDD.obtenerConexion();
				ps=con.prepareStatement("insert into grupos (id,nombre)"
						+ "values(?,?)");
				ps.setString(1, grupo.getId());
				ps.setString(2, grupo.getNombre());
				ps.executeUpdate();		
			
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
				e.printStackTrace();
				throw new KrakedevException("Error al insertar el grupo"+e.getMessage());
			}
	
	}
}
