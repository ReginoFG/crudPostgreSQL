package com.crudPostgreSQL.modelo.consultas;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crudPostgreSQL.modelo.dtos.dtoAlumno;
import com.crudPostgreSQL.modelo.operacionesDto.aDTO;

/** consultasPostgreSQL - Clase que define las consultas a realizar sobre PostgreSQL
 * @author garfe
 * 19/10/2022
 */
public class consultasPostgreSQL {
	
	/** selectAllAlumnos - Consulta sobre la tabla alumnos.
	 * SELECT * FROM \"proyectoEclipse\".\"alumnos\"
	 * @author garfe
	 * @param Connection conexionGenerada
	 * @return ArrayList<dtoAlumno>
	 */
	public static ArrayList<dtoAlumno> selectAllAlumnos(Connection conexionGenerada) {
		
		System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnos] Entra en selectAllAlumnos");

		//VARIABLES
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<dtoAlumno>();
		
		//SELECT
		try {
			
			/*Se abre una declaración*/
			declaracionSQL = conexionGenerada.createStatement();
			/*Se define la consulta de la declaración y se ejecuta*/
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"proyectoEclipse\".\"alumnos\"");
		    
			/*Llamada a la conversión a dtoAlumno*/
			listAlumnos = aDTO.resultsetAdtoAlumno(resultadoConsulta);
			int i = listAlumnos.size();
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnos] Número alumnos: "+i);
			
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnos] Cierre declaración y resultado");				
		    resultadoConsulta.close();
		    declaracionSQL.close();
		    
		    System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnos] Sale de selectAllAlumnos");
		    			
		} catch (SQLException e) {
			
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL: " + e);
			return listAlumnos;
			
		}
		return listAlumnos;
		
	}
	
	/** insertNuevoAlumno - Insert informado en el parámetro consulta sobre la tabla alumnos.
	 * @author garfe
	 * @param String consulta
	 * @param Connection conexionGenerada
	 * @return void
	 * 19/10/2022
	 */
	public static void insertNuevoAlumno(String consulta, Connection conexionGenerada) {
		
		System.out.println("[INFORMACIÓN-consultasPostgreSQL-insertNuevoAlumno] Entra en insertNuevoAlumno");
		
		//VARIABLES
		Statement declaracionSQL = null;
		
		//INSERT
		try {
			
			declaracionSQL = conexionGenerada.createStatement();
			declaracionSQL.execute(consulta);
			declaracionSQL.close();
			
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-insertNuevoAlumno] Cierre declaración.");
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-insertNuevoAlumno] Sale de insertNuevoAlumno");
			
		} catch (SQLException e) {
			
			System.out.println("[ERROR-consultasPostgreSQL-insertNuevoAlumno] Error al insertar alumno: " + e);
		
		}
		
	}

}
