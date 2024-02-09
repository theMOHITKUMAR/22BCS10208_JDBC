package mohit_815;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class operation_mst {
	Scanner sc = new Scanner(System.in);
	Connection con=null;
	connection_mst conObject = new connection_mst();
	int count = 0;
	public void insert_record() throws ClassNotFoundException, SQLException {
		System.out.println("Enter student UID:");
		String studentsUID = sc.next();
		System.out.println("Enter student Name:");
		String studentName = sc.next();
		System.out.println("Enter student Course:");
		String studentsCourse = sc.next();
		System.out.println("Enter student Batch:");
		int studentBatch = sc.nextInt();
		if(con==null) {
			con = conObject.getConnection();
		}
		String countStatus = "select max(ID) from jdbc";
		PreparedStatement psmt1 = con.prepareStatement(countStatus);
		ResultSet rs = psmt1.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		String insertQuery = "insert into jdbc values(?,?,?,?,?)";
		
		
		PreparedStatement psmt2 = con.prepareStatement(insertQuery);
		count+=1;
		psmt2.setInt(1, count);
		psmt2.setString(2, studentsUID);
		psmt2.setString(3, studentName);
		psmt2.setString(4, studentsCourse);
		psmt2.setInt(5, studentBatch);
		
		int status = psmt2.executeUpdate();
		if(status>0) {
			System.out.println("Record inserted successfully");
		}
		else {
			System.out.println("Record not inserted");
		}
		psmt1.close();
		psmt2.close();
		//con.close();
	}


       public void delete() throws ClassNotFoundException, SQLException {
           System.out.println("Eneter students UID");
    	   String studentsUID = sc.next();
    		String searchQuery = "select * from jdbc where studentsUID=?";
    		con=conObject.getConnection();
			PreparedStatement psmt1 = con.prepareStatement(searchQuery);
    		psmt1.setString(1, studentsUID);
    		
			ResultSet rs = psmt1.executeQuery();
			if(rs.next()) {
				System.out.println("Student UID:"+rs.getString(2));
				System.out.println("Student Name:"+rs.getString(3));
				System.out.println("Student Course:"+rs.getString(4));
				System.out.println("Student Batch:"+rs.getInt(5));
				System.out.println("Do you confirm for delete record?1/Yes, 0/No");
				int reply = sc.nextInt();
				if (reply==1) {
					String deleteQuery="delete from jdbc where studentsUID=?";
					PreparedStatement psmt2 = con.prepareStatement(deleteQuery);
					psmt2.setString(1, studentsUID);
					
					int status1 = psmt2.executeUpdate();
					if (status1>0) {
						System.out.println("Record deleted successfully");
						
					}
					else {
						System.out.println("No record deleted");
					}
			}
       }
			else {
				System.out.println("No record foun");
			}
			
       }
       public void update() throws SQLException, ClassNotFoundException {
    	   System.out.println("enter the student uid = ");
    	   String studentsUID=sc.next();
    	   String searchQuery="select * from jdbc where studentsUID = ?";
    	   if(con==null) {
    		   con=conObject.getConnection();
    	   }
    	   PreparedStatement psmt1 = con.prepareStatement(searchQuery);
    	   psmt1.setString(1, studentsUID);
    	   ResultSet rs = psmt1.executeQuery();
    	   if(rs.next()) {
				System.out.println("Student UID:"+rs.getString(2));
				System.out.println("Student Name:"+rs.getString(3));
				System.out.println("Student Course:"+rs.getString(4));
				System.out.println("Student Batch:"+rs.getInt(5));
				System.out.println("enter the updated course");
				String updatedCourse=sc.next();
				String updatedQuery="update jdbc set studentsCourse=? where studentsUID=?";
				PreparedStatement psmt2 = con.prepareStatement(updatedQuery);
				psmt2.setString(1, updatedCourse);
				psmt2.setString(2, studentsUID);
				int status = psmt2.executeUpdate();
					if (status>0) {
						System.out.println("Record updated successfully");
						
					}
					psmt1.close();
					psmt2.close();
					con.close();
    	   
    	   
    	   
    	   
    	   
       }
       }
}
