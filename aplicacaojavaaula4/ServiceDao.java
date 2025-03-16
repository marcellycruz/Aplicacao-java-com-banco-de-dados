package aplicacaojavaaula4;

import java.sql.*;
import java.util.ArrayList;

public class ServiceDao {
    private Connection connection;

    public ServiceDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean insertBath(int id, Bath bath){
        String sql = "INSERT INTO PETSERVICES VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.setString(2, bath.getPetName());
            stmt.setString(3, bath.getOwnerName());
            stmt.setString(4, "banho");
            stmt.setInt(5, bath.getDuration());
            stmt.setDouble(6, bath.getPrice());

            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList <Bath> getAllBath(){
        String sql = "SELECT * FROM PETSERVICES WHERE SERVICE = 'banho'";

        ArrayList<Bath> baths = new ArrayList<Bath>();
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                //criando objeto do tipo Bath
                Bath bath = new Bath();
                bath.setId(rs.getInt("IDSERVICE"));
                bath.setPetName(rs.getString("PETNAME"));
                bath.setOwnerName(rs.getString("OWNERNAME"));
                bath.setDuration(rs.getInt("DURATION"));
                bath.setPrice(rs.getDouble("PRICE"));
                
                //adicionando o objeto ao Arraylist
                baths.add(bath);
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return baths;
    }
}
