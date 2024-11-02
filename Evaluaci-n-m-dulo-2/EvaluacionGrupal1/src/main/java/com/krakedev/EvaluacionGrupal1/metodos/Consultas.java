package com.krakedev.EvaluacionGrupal1.metodos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.EvaluacionGrupal1.conexion.ConexionBDD;
import com.krakedev.EvaluacionGrupal1.entidades.RegistroMovimiento;
import com.krakedev.EvaluacionGrupal1.exepcion.KrakedevException;

public class Consultas {

public ArrayList<RegistroMovimiento> recuperarTodos(String idArticulos) throws KrakedevException{
		
		ArrayList<RegistroMovimiento> movimientos= new ArrayList<RegistroMovimiento>();
		
		Connection con= null;
		PreparedStatement ps= null;
		java.sql.ResultSet rs= null;
		RegistroMovimiento cl=null;
		try {
			con=ConexionBDD.obtenerConexion();
				ps=con.prepareStatement("select * from registro_movimientos where id_articulos=?");
				ps.setString(1, idArticulos);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					int id=rs.getInt("id");
					String idArticulo=rs.getString("id_articulos");
					int cantidad=rs.getInt("cantidad");
					Date  fechaMovimiento=rs.getDate("fecha_movimiento");
					cl= new RegistroMovimiento(id,idArticulo,cantidad,fechaMovimiento);
					movimientos.add(cl);
				}
			
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
				e.printStackTrace();
				throw new KrakedevException("Error al consultar el articulo"+e.getMessage());
			}
		
		return movimientos;
	}
}
