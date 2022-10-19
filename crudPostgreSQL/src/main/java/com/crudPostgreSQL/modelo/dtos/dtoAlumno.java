package com.crudPostgreSQL.modelo.dtos;

/** dtoAlumno - DTO de la entidad alumnos de la BBDD de PostgreSQL
 * @author garfe
 * 19/10/2022
 */
public class dtoAlumno {
	
	//CONSTRUCTOR
	public dtoAlumno(int id, String nom, String ape, String ema) {
		
		id_alumno = id;
		nombre = nom;
		apellidos = ape;
		email = ema;
		
	}
	
	//ATRIBUTOS	
	int id_alumno;
	String nombre;
	String apellidos;
	String email;
	
	
	//GETTERS & SETTERS
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
