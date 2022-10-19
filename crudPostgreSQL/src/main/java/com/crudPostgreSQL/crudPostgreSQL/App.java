package com.crudPostgreSQL.crudPostgreSQL;

/**
 * App - Clase que inicializa la aplicación
 *@autor garfer
 *19/10/2022
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	/*Llamada al controlador PostgreSQL*/
    	System.out.println("[INFORMACIÓN-App-main] Lamada a controladorPostgreSQL");
        com.crudPostgreSQL.controladores.controladorPostgreSQL.controladorPostgreSQL();
    }
}
