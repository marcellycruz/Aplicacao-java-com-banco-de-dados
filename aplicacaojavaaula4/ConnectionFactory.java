package aplicacaojavaaula4;

import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            Connection conexao = DriverManager.getConnection(
                    "", 
                    "", 
                    "");
            return conexao;
        }catch(SQLException ex){
            System.out.println("Falha de conexão com o banco");
        }
        return null;
    }
}
