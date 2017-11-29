import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlHandler {
	private Connection conSQL = null;
	public SqlHandler(String username, String pw){
		try {
			/*load the driver*/
			Class.forName("com.mysql.jdbc.Driver");
			conSQL = DriverManager.getConnection("jdbc:mysql://localhost/apotheke","root","");
			//conSQL.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void writeUserInDatabase(String name,int hours,String type){
		String query = "insert into "+type+"(name,hours)"+"values(?,?)";
		try {
			PreparedStatement preStmt = conSQL.prepareStatement(query);
			preStmt.setString(1, name);
			preStmt.setInt(2, hours);
			preStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Worker> readWorker(){
		ArrayList<Worker> worker = new ArrayList<Worker>();
		Apotheker apotheker;
		Pta pta;
		String query ="SELECT * FROM apotheker";
		try {
			Statement st = conSQL.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				apotheker = new Apotheker(rs.getString("name"),rs.getInt("hours"));
				worker.add(apotheker);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		query ="SELECT * FROM pta";
		
		try {
			Statement st = conSQL.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				pta = new Pta(rs.getString("name"),rs.getInt("hours"));
				worker.add(pta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close();
		return worker;
	}
	public void flushDatabase(){
		String query ="DELETE FROM apotheker";
		try {
			PreparedStatement preStmt = conSQL.prepareStatement(query);
			preStmt.execute();
			query = "DELETE FROM pta";
			preStmt = conSQL.prepareStatement(query);
			preStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close();
	}
	public void close(){
		try {
			this.conSQL.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
