package com.javascript.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import com.javascript.modelo.Personas;
import com.javascript.servicio.ServicioPersonas;

 import com.javascript.jdbc.ConectarDB;;

public class PersonasSQL implements ServicioPersonas  {

	private final ConectarDB mysql;
	String SQL = "";
	
	public PersonasSQL() {
		this.mysql = new ConectarDB();
	}
	
	@Override
	public List<Personas> mostrar() {
		
		List<Personas> lista = new LinkedList<Personas>();
		Personas personas = new Personas();
		SQL = "select * from personas";
		
		Connection conectado = mysql.getConnection();
		mysql.establecerConexion();
		
		try {
			Statement st = conectado.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			
			while (rs.next()) {
				personas.setCodigo(rs.getInt("codigo"));
				personas.setNombre(rs.getString("nombre"));
				personas.setApellido(rs.getString("apellido"));
				personas.setCorreo(rs.getString("correo"));
				personas.setCelular(rs.getInt("celular"));
				personas.setTipoUsuario(rs.getString("tipoUsuario"));
				personas.setSexo(rs.getString("sexo"));
				personas.setContrasenia(rs.getString("contrasenia"));
				
				lista.add(personas);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mysql.cerrarConexion();
		}
		return lista;
	}

	@Override
	public boolean agregar(Personas personas) {
		SQL = "INSERT INTO personas (nombre, apellido, correo, celular, " + 
				"            tipoUsusario, sexo, contrasenia) " + 
				"            VALUES ( ?, ?, ?, ?, ?, ?, ?);";
		
		Connection conectado = mysql.getConnection();
		mysql.establecerConexion();
		
		try {
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setInt(1, personas.getCodigo());
			pst.setString(2, personas.getNombre());
			pst.setString(3, personas.getApellido());
			pst.setString(4, personas.getCorreo());
			pst.setInt(5, personas.getCelular());
			pst.setString(6, personas.getTipoUsuario());
			pst.setString(7, personas.getSexo());
			pst.setString(8, personas.getContrasenia());
			
			int n = pst.executeUpdate();
			mysql.cerrarConexion();
			if (n != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			System.out.println("Se Agrego con Exito - @Override\r\n" + 
					"	public boolean agregar");
		}
		
	}

	@Override
	public Personas buscar(int id) {
		Personas personas = new Personas();
		
		SQL = "SELECT * from personas where codigo = ?";
		Connection conectado = mysql.getConnection();
		mysql.establecerConexion();
		
		try {
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				personas.setCodigo(rs.getInt("codigo"));
				personas.setNombre(rs.getString("nombre"));
				personas.setApellido(rs.getString("apellido"));
				personas.setCorreo(rs.getString("correo"));
				personas.setCelular(rs.getInt("celular"));
				personas.setTipoUsuario(rs.getString("tipoUsuario"));
				personas.setSexo(rs.getString("sexo"));
				personas.setContrasenia(rs.getString("contrasenia"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mysql.cerrarConexion();
		}
		
		return personas;
	}

	@Override
	public boolean actulizar(Personas personas) {
		SQL = "UPDATE personas SET nombre = ?, apellido = ?, correo = ?, celular = ?, " + 
"                     tipoUsusario = ?, sexo = ?, contrasenia = ? " + 
"                     WHERE codigo = ?";
		Connection conectado = mysql.getConnection();
		mysql.establecerConexion();
		
		try {
			PreparedStatement pst = conectado.prepareStatement(SQL);
			
			pst.setInt(1, personas.getCodigo());
			pst.setString(2, personas.getNombre());
			pst.setString(3, personas.getApellido());
			pst.setString(4, personas.getCorreo());
			pst.setInt(5, personas.getCelular());
			pst.setString(6, personas.getTipoUsuario());
			pst.setString(7, personas.getSexo());
			pst.setString(8, personas.getContrasenia());
			
			int n = pst.executeUpdate();
			mysql.cerrarConexion();
			if (n != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean eliminar(int id) {
		SQL = "DELETE FROM personas WHERE codigo = ?";
		Connection conectado = mysql.getConnection();
		mysql.establecerConexion();
		
		try {
			PreparedStatement  pst = conectado.prepareStatement(SQL);
			pst.setInt(1, id);
			
			int n = pst.executeUpdate();
			mysql.cerrarConexion();
			if (n != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
