/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dal;

import java.sql.*;
/**
 *
 * @author Rafael Di Bonito
 */
public class ModuloConexao {
    
    // Método responsavél por estabelecer a conexão com banco de dados
    public static Connection conector(){
        Connection conexao = null;
        
        // A linha abaixo chama o driver mysql-connector
        String driver = "com.mysql.cj.jdbc.Driver";
       
        // Armazenando informações referente ao banco de dados
        String url = "jdbc:mysql://localhost:3306/db_empresa";
        String user = "root";
        String password = "root";
        
        // Estabelecendo a conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        }   catch (Exception e) {
            //System.out.println(e);
                return null;  
        }
        
        
    }
    
}
