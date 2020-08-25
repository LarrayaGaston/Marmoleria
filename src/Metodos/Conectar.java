package Metodos;

import java.sql.*;
import java.sql.*;

//* @author Fernando,Estaban y Lucas

public class Conectar {
    
   public Connection miconexion;
   public Statement stSentencias;
   public ResultSet rsDatos;
   public PreparedStatement psPrepararSentencias;
    
    public Conectar () throws ClassNotFoundException, SQLException
    {
     try {
         Class.forName("com.mysql.jdbc.Driver");
         String url = ("jdbc:mysql://localhost/app_marmoleria");
         miconexion = DriverManager.getConnection(url, "root","");
         stSentencias = miconexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     }
     catch (ClassCastException ex)
     {
         throw ex;
     }
     catch (SQLException ex)
     {
         throw ex;
     }
    }
    
    public ResultSet consulta (String sql ) throws SQLException
    {
        try 
           {
            rsDatos = stSentencias.executeQuery(sql);
           }
        catch (SQLException ex)
             {
              throw ex;        
             }
    return rsDatos;
    }
    
    
}
