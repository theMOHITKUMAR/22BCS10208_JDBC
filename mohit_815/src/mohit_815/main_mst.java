package mohit_815;

import java.sql.SQLException;
import java.util.Scanner;



public class main_mst {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // new - dynamic memory allocator.
//		ConnectionClass object = new ConnectionClass();
		operation_mst object = new operation_mst();
		while(true) {
		
			System.out.println("Enter 1 for insert a Record");
			System.out.println("Enter 2 for delete a Record");
			System.out.println("Enter 3 for update a Record");
			System.out.println("Enter 4 for insert a Record");
			System.out.println("Enter 5 for insert a Record");
			
			int reply = sc.nextInt();
			
			switch(reply) {
			case 1:
				object.insert_record();
				break;
			case 2:
				object.delete();
				break;
			case 3:
				object.update();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid Input");
					
			}
		}
		
		
		
	}

	}


