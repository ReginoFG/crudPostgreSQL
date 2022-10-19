package com.crudPostgreSQL.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.crudPostgreSQL.modelo.consultas.consultasPostgreSQL;
import com.crudPostgreSQL.modelo.dtos.dtoAlumno;

/** controladorPostgreSQL - Controlador que gestiona las transacciones con PostgreSQL
 * @author garfe
 * 19/10/2022
 */
public class controladorPostgreSQL {

	
	public static void controladorPostgreSQL() {
		
		System.out.println("[INFORMACIÓN-controladorPostgreSQL-controladorPostgreSQL] Entra en controladorPostgreSQL");
		
		//VARIABLES
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<dtoAlumno>();

		System.out.println("[INFORMACIÓN-controladorPortgreSQL-controladorPortgreSQL] Lamada generaConexion");
		Connection conexionGenerada = com.crudPostgreSQL.modelo.conexiones.conexionPostgresql.generaConexion();
		
		if(conexionGenerada != null) {
			//Llamar al método que ejecuta la consulta de insert
			//Cambiar el id para probar
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-controladorPortgreSQL] Lamada insertNuevoAlumno");
			//Si los métodos se crean como estáticos no es necesario instanciar una clase.
			com.crudPostgreSQL.modelo.consultas.consultasPostgreSQL.insertNuevoAlumno("INSERT INTO \"proyectoEclipse\".\"alumnos\" (id_alumno,nombre,apellidos,email)"
					+ "VALUES(51,'Paco','Fernández','pf@altair.es')", conexionGenerada);
						
			//Llamar al método que ejecuta la consulta de select
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-controladorPortgreSQL] Lamada selectAllAlumnos");
			listAlumnos = com.crudPostgreSQL.modelo.consultas.consultasPostgreSQL.selectAllAlumnos(conexionGenerada);
			int i = listAlumnos.size();
			for(dtoAlumno alumno: listAlumnos) {
				System.out.println(alumno.getId_alumno() + " " +
				alumno.getNombre() + " " + alumno.getApellidos() + " " + alumno.getEmail());
			}
			
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-controladorPortgreSQL] Número alumnos: "+i);
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-controladorPortgreSQL] Llamada a cerrarConexion");
			com.crudPostgreSQL.modelo.conexiones.conexionPostgresql.cerrarConexion(conexionGenerada);
			
		}
		
		System.out.println("[INFORMACIÓN-controladorPostgreSQL-controladorPostgreSQL] Sale de controladorPostgreSQL");
	
	}

}
