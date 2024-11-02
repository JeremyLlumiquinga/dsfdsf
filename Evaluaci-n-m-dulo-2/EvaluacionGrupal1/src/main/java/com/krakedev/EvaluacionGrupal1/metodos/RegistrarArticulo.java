package com.krakedev.EvaluacionGrupal1.metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.EvaluacionGrupal1.conexion.ConexionBDD;
import com.krakedev.EvaluacionGrupal1.entidades.Articulo;
import com.krakedev.EvaluacionGrupal1.exepcion.KrakedevException;

public class RegistrarArticulo {
	public void Registrar(Articulo art) throws KrakedevException {
		Connection con= null;
		PreparedStatement ps= null;
		try {
			con=ConexionBDD.obtenerConexion();
				ps=con.prepareStatement("insert into articulos (id,nombre,precio_venta,precio_compra,id_grupo)"
						+ "values(?,?,?,?,?)");
				ps.setString(1, art.getId());
				ps.setString(2, art.getNombre());
				ps.setBigDecimal(3, art.getPrecio_venta());
				ps.setBigDecimal(4, art.getPrecio_compra());
				ps.setString(5, art.getId_grupo().getId());
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
