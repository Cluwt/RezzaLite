/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Csarp
 */
public class ConexaoDAO {
    
 Connection connection = null;
 PreparedStatement sql = null;
 ResultSet rs = null;

public void abrirConexao() throws Exception
{
	if (connection == null) 
	{
            String url = "jdbc:mysql://localhost:3306/sistemarestaurante";
	    String user = "root";
	    String passwd = "";
	    connection = DriverManager.getConnection(url,user,passwd);
	}
}
public void fecharConexao() throws Exception
{
	if ( connection != null)
	{
		connection.close();
                sql.close();
                rs.close();
	}
}
}
