package com.krakedev.EvaluacionGrupal1.metodos;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.krakedev.EvaluacionGrupal1.conexion.ConexionBDD;
import com.krakedev.EvaluacionGrupal1.entidades.RegistroMovimiento;
import com.krakedev.EvaluacionGrupal1.exepcion.KrakedevException;

public class RegistroMovimientos {
	public void Registrar(RegistroMovimiento registro) throws KrakedevException {
		Connection con= null;
		PreparedStatement ps= null;
		try {
			con=ConexionBDD.obtenerConexion();
				ps=con.prepareStatement("insert into registro_movimientos (id_articulos,cantidad,fecha_movimiento)"
						+ "values(?,?,?)");
				
				ps.setString(1,registro.getId_articulos());
				ps.setInt(2, registro.getCantidad());
				System.out.println(registro.getFecha_movimiento().toString());
				ps.setTimestamp(3, new Timestamp(registro.getFecha_movimiento().getTime()));
				//ps.setDate(3, Convertidor.convertirFecha(registro.getFecha_movimiento().toString()));
				
				
				
				
				
				ps.executeUpdate();		
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
				e.printStackTrace();
				throw new KrakedevException("Error al insertar el registro de movimientos "+e.getMessage());
			} catch (Exception e) {
			
			e.printStackTrace();
			throw new KrakedevException("Error al insertar fecha "+e.getMessage());
		}
	
	}
}
