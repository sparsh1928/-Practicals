// Java program to illustrate 
// inserting to the Database 
import java.sql.*; 

public class assign3 
{ 
	public static void main(String args[]) 
	{ 
		String id = "root"; 
		String pwd = "12345"; 
                String newPwd = "11111";
		String fullname = "geeks for geeks"; 
		String email = "geeks@geeks.org"; 
		
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/core_demo", "root", "12345"); 
			Statement stmt = con.createStatement(); 
			
			// Inserting data in database 
			String q1 = "insert into userid values('" +id+ "', '" +pwd+ 
								"', '" +fullname+ "', '" +email+ "')"; 
			int x = stmt.executeUpdate(q1); 
			if (x > 0)			 
				System.out.println("Successfully Inserted");			 
			else			
				System.out.println("Insert Failed"); 
			// Updating data in database
                        String q2 = "UPDATE userid set pwd = '" + newPwd +"' WHERE id = '" +id+ "' AND pwd = '" + pwd + "'"; 
                        int y = stmt.executeUpdate(q2); 
              
                        if (y > 0)             
                        System.out.println("Password Successfully Updated");             
                        else            
                        System.out.println("ERROR OCCURED :("); 
                        
                        //Deleting from database
                        String q3 = "DELETE from userid WHERE id = '" + id +  "' AND pwd = '" + pwd + "'"; 
                      
                        int z = stmt.executeUpdate(q3); 
              
                        if (z > 0)             
                        System.out.println("One User Successfully Deleted");             
                        else
                        System.out.println("ERROR OCCURED :(");   
            
			// SELECT query 
            String q4 = "select * from userid WHERE id = '" + id +  
                                    "' AND pwd = '" + newPwd + "'"; 
            ResultSet rs = stmt.executeQuery(q4); 
            if (rs.next()) 
            { 
                System.out.println("User-Id : " + rs.getString(1)); 
                System.out.println("Full Name :" + rs.getString(3)); 
                System.out.println("E-mail :" + rs.getString(4)); 
            } 
            else
            { 
                System.out.println("No such user id is already registered"); 
            } 
                        con.close(); 
                    	} 
                
                catch(Exception e) 
		{ 
			System.out.println(e); 
		} 
	} 
} 
