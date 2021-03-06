package com.portal.parejas;

import com.portal.parejas.negocio.NegocioBasico;
import com.portal.parejas.persistencia.PersonaJdbcDao;
import com.portal.parejas.servicio.ServicioPortalParejas;

public class Contenedor {

	private PersonaJdbcDao persistencia;
	private ServicioPortalParejas servicio;
	private NegocioBasico negocio;
	
	public Contenedor() {
		persistencia =  new PersonaJdbcDao();
		negocio = new NegocioBasico();
		servicio = new ServicioPortalParejas(persistencia, negocio);
	}
	
	/*public Persistencia getPersistencia(){
		return persistencia;
	}
	
	public Negocio getNegocio(){
		return negocio;
	}
	
	public Servicio getServicio(){
		return servicio;
	}*/
	
	public Object getBean(String nombre){
		switch (nombre) {
		case "persistencia":
			return persistencia;
		case "negocio":
			return negocio;
		case "servicio":
			return servicio;
		default:
			return null;
		}
	}
}
