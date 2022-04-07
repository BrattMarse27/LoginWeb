
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PersonaDAO implements Validar{

    Connection con;
    Conexion cn= new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    @Override
    public int validar(Persona per) {
         String sql="SELECT * FROM persona where usuario=? and password=?";
         try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getUser());
            ps.setString(2, per.getPass());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setUser(rs.getString("usuario"));
                per.setPass(rs.getString("password"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
   
    }
    
}
