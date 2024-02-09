package mohit_815;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection_mst {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
         Connection con=null;
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit_815", "root", "Mohitkd@9896480943");
         System.out.println("connection established");
	}

}
