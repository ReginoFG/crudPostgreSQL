package com.crudPostgreSQL.modelo.operacionesDto;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crudPostgreSQL.modelo.dtos.dtoAlumno;

/** aDTO - Clase que gestiona los métodos para pasar la información recibida de base de datos a DTOs.
 * @author garfe
 * 19/10/2022
 */
public class aDTO {
	
	/** resultsetAdtoAlumno - Método para pasar la información de alumnos del ResultSet a un listado de dtoAlumno.
	 * @param ResulSet resultadoConsulta
	 * @return ArrayList<dtoAlumno>
	 * @author garfe
	 * 19/10/2022
	 */
	public static ArrayList<dtoAlumno> resultsetAdtoAlumno(ResultSet resultadoConsulta){
		
		System.out.println("[INFORMACIÓN-aDTO-resultsetAdtoAlumno] Entrando en resultsetAdtoAlumno");
		
		//VARIABLES
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<dtoAlumno>();
		
		//ASIGNACIÓN A DTO
		try {
			/*Se lee el ResultSet hasta que no quedan filas*/
			while ( resultadoConsulta.next() ) {
				
				listAlumnos.add(new dtoAlumno(resultadoConsulta.getInt("id_alumno"),
						resultadoConsulta.getString("nombre"),
						resultadoConsulta.getString("apellidos"),
						resultadoConsulta.getString("email"))
						);
			}
			
			int i = listAlumnos.size();
			System.out.println("[INFORMACIÓN-aDTO-resultsetAdtoAlumno] Número alumnos: "+i);
			System.out.println("[INFORMACIÓN-aDTO-resultsetAdtoAlumno] Saliendo de resultsetAdtoAlumno");
			
		} catch (SQLException e) {
			
			System.out.println("[ERROR-aDTO-resultsetAdtoAlumno] Error al convertir a dtoAlumno: " + e);
			
		}
		
		return listAlumnos;
		
	}

}
