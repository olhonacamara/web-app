/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marcelosiedler
 */
public class Conexao {

    private static final String banco
            = "jdbc:mysql://127.0.0.1:3306/donc";

    private static final String driver
            = "com.mysql.jdbc.Driver";

    private static final String usuario = "root";
    private static final String senha = "";

    private static Connection con = null;

    /**
     * Metodo que retorna uma conexão com o banco de dados
     *
     * @return objeto java.sql.Connection
     */
    public static Connection getConexao() {
        // primeiro testo se o objeto con não foi inicializado
        if (con == null) {
            try {
                // defino a classe do driver a ser usado
                Class.forName(driver);
                // criação da conexão com o BD
                con
                        = DriverManager.getConnection(
                                banco, usuario, senha);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver");
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar: "
                        + ex.getMessage());
            }
        }
        return con;
    }

    /**
     * Método que recebe um comando SQL para ser executado
     *
     * @param sql
     * @return um objeto java.sql.PreparedStatement
     */
    public static PreparedStatement getPreparedStatement(String sql) {
        // testo se a conexão já foi criada
        if (con == null) {
            // cria a conexão
            con = getConexao();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return con.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Erro de sql: "
                    + e.getMessage());
        }
        return null;
    }

}
