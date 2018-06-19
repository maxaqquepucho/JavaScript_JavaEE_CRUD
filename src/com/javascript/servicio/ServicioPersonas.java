package com.javascript.servicio;
import java.util.List;

import com.javascript.modelo.Personas;

public interface ServicioPersonas {
	
	public List<Personas> mostrar();
	public boolean agregar(Personas personas);
	public Personas buscar(int id);
	public boolean actulizar(Personas personas);
	public boolean eliminar(int id);
	
	public String getMessage();
}
