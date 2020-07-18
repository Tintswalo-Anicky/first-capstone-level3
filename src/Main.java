/*  # TASK 8
	# Compulsory Task
	# Main.java
	# written by Tintswalo Anicky Makhubele
	# date:  25 june 2020
	# Function: This program helps a small structural engineering firm called “Poised” to keep track of the many projects on which they work and store projects in a database.
	*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		ResultSet results ; 
		try {
		// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
        // Use username "otheruser", password "swordfish".
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/poisePMS?useSSL=false",
                "otheruser",
                "swordfish"
                );

		// Create a direct line to the database for running our queries
        Statement statement = connection.createStatement();
		int rowsAffected;
		
		ArrayList<PoisedProjects> projectObjects = getDataFromPoise(); 
		
		Scanner scanner = new Scanner(System.in);
		Boolean control = true;
		while (control) {
		System.out.println("\nEnter : \na- add a project \ne- edit existing project \nv- view incomplete tasks \no- Overdue projects \np- all poised projects" );
		
		String option = scanner.nextLine();
		String optionLower = option.toLowerCase();
		try {
			if(optionLower.equals("a")) {
				
		        //create a client
				System.out.print("\nENTER CLIENT'S DETAILS:\n");
		        People client = new People();
		
		      //set client's name
		        Scanner clientInput = new Scanner(System.in);
		        System.out.print("Name: ");
		        client.setName(clientInput.nextLine());
		        String clientName = client.getName();
		        

		      //set client's surname
		        clientInput = new Scanner(System.in);
		        System.out.print("Surname: ");
		        client.setSurname(clientInput.nextLine());
		        String clientSurname = client.getSurname();

		        //set client's telephone number
		        
		        clientInput = new Scanner(System.in);
		        System.out.print("Tel: ");
			        
			    try { 
			    	String input = clientInput.next();
			    	
			    	for(int i = 0; i < input.length(); i++) {
			    	
			    	if (!Character.isDigit(input.charAt(i))) {
			    		
			    		throw new Exception();
			    	}
			    	}
			    	Long.parseLong(input);
			    	if (input.length()!=10) {
			    	throw new NumberFormatException();
			    	}
		        	client.setTel(input);
			    }
			    catch  (Exception E) { 
		        	System.out.print("invalid phone numbers\n");
		        	boolean invalid_number = true;
		        	do {
			    		System.out.println("You have entered incorrect phone number");
		        		System.out.print("Tel: ");
		        		clientInput = new Scanner(System.in);
		        		Boolean hasNext = clientInput.hasNext();
		        		String input = clientInput.next();
		        		
		        		if (hasNext) {
		        			client.setTel(input);
		        			invalid_number = false;
		        		}
		        		if  (input.length()!=10) {
		        			invalid_number = true;
		        		}
                       for(int i = 0; i < input.length(); i++) {
					    	
					    	if (!Character.isDigit(input.charAt(i))) {
					    		invalid_number = true;
					    		continue;
					    	}
					    	}
		        		
		        		}while(invalid_number);
			    }
			    String clientTel = client.getTel();
		
			  //set client's email
		        clientInput = new Scanner(System.in);
		        System.out.print("Email: ");
		        client.setEmail(clientInput.nextLine());
		        String clientEmail = client.getEmail();
		
		      //set client's address 
		        clientInput = new Scanner(System.in);
		        System.out.print("Address: ");
		        client.setAddress(clientInput.nextLine());
		        String clientAddress = client.getAddress();
		
		        System.out.print("\nENTER ARCHITECTURE'S DETAILS:\n");
		        People achitecture = new People();
		        //set achitecture's name
		        Scanner achitectureInput = new Scanner(System.in);
		        System.out.print("Name: ");
		        achitecture.setName(achitectureInput.nextLine());
		        String achitectureName = achitecture.getName();

		        //set achitecture's surname
		        achitectureInput = new Scanner(System.in);
		        System.out.print("Surname: ");
		        achitecture.setSurname(achitectureInput.nextLine());
		        String achitectureSurname = achitecture.getSurname();

		      //set achitecture's telephone number
		        String archi;
		        
		        achitectureInput = new Scanner(System.in);
		        System.out.print("Tel: ");
		        
		        try {
		        	String input = achitectureInput.next();
		        	for(int i = 0; i < input.length(); i++) {
				    	
				    	if (!Character.isDigit(input.charAt(i))) {
				    		
				    		throw new Exception();
				    	}
				    	}
			    	Long.parseLong(input);
			    	if (input.length()!=10) {
			    	throw new NumberFormatException();
			    	}
			    	
		        	achitecture.setTel(input);
			    }
			    catch  (Exception E) { 
		        	System.out.print("invalid phone numbers\n");
		        	boolean invalid_number = true;
		        	do {
			    		System.out.println("You have entered incorrect phone number");
		        		System.out.print("Tel: ");
		        		achitectureInput = new Scanner(System.in);
		        		Boolean hasNext = achitectureInput.hasNext();
		        		String input = achitectureInput.next();
		        		if (hasNext) {
		        			achitecture.setTel(input);
		        			invalid_number = false;
		        		}
		        		if  (input.length()!=10) {
		        			invalid_number = true;
		        		}
		        		 for(int i = 0; i < input.length(); i++) {
						    	
						    	if (!Character.isDigit(input.charAt(i))) {
						    		invalid_number = true;
						    		continue;
						    	}
						    	}
		     
		        		}while(invalid_number);
			    }
		        String achitectureTel = achitecture.getTel();
		       
		      //set achitecture's email
		        achitectureInput = new Scanner(System.in);
		        System.out.print("Email: ");
		        achitecture.setEmail(achitectureInput.nextLine());
		        String achitectureEmail = achitecture.getEmail();

		        //set achitecture's address
		        achitectureInput = new Scanner(System.in);
		        System.out.print("Address: ");
		        achitecture.setAddress(achitectureInput.nextLine());
		        String achitectureAddress = achitecture.getAddress();

		        System.out.print("\nENTER CONTRACTOR'S DETAILS:\n");
		        People contractor = new People();
		        //setting contracto's name
		        Scanner contractorInput = new Scanner(System.in);
		        System.out.print("Name: ");
		        contractor.setName(contractorInput.nextLine());
		        String contractorName = contractor.getName();

		        //setting contractor's surname
		        contractorInput = new Scanner(System.in);
		        System.out.print("Surname: ");
		        contractor.setSurname(contractorInput.nextLine());
		        String contractorSurname = contractor.getSurname();

		        //setting contractor's telephone number
		        String contr;
		        contractorInput = new Scanner(System.in);
		        System.out.print("Tel: ");
		        
		    try {
		    	String input = contractorInput.nextLine();
                for(int i = 0; i < input.length(); i++) {
			    	
			    	if (!Character.isDigit(input.charAt(i))) {
			    		
			    		throw new Exception();
			    	}
			    	}
		    	Long tel = Long.parseLong(input);
		    	if (input.length()!=10) {
		    	throw new NumberFormatException();
		    	}
	        
	        	contractor.setTel(input);
		    } catch (Exception E) {
		    	System.out.print("invalid phone number\n");
		    	boolean invalid_number = true;
		    	do {
		    		System.out.println("You have entered incorrect phone number");
	        		System.out.print("Tel: ");
	        		contractorInput = new Scanner(System.in);
	        		Boolean hasNext = contractorInput.hasNext();
	        		String input = contractorInput.next();
	        		if (hasNext) {
	        			contractor.setTel(input);
	        			invalid_number = false;
	        		}
	        	
	        		if  (input.length()!=10) {
	        			invalid_number = true;
	        		}
	        		 for(int i = 0; i < input.length(); i++) {
					    	
					    	if (!Character.isDigit(input.charAt(i))) {
					    		invalid_number = true;
					    		continue;
					    	}
					    	}
		    	} while (invalid_number);
			  }
		    	String contractorTel = contractor.getTel();

		      //setting contractor's email
		        contractorInput = new Scanner(System.in);
		        System.out.print("Email: ");
		        contractor.setEmail(contractorInput.nextLine());
		        String contractorEmail = contractor.getEmail();
		        
			  //setting contractor's address
		        contractorInput = new Scanner(System.in);
		        System.out.print("Address: ");
		        contractor.setAddress(contractorInput.nextLine());
		        String contractorAddress = contractor.getAddress();
		        
		        
		        System.out.print("\nENTER PROJECT'S DETAILS: \n");
		        PoisedProjects project = new PoisedProjects();
		        Scanner projectInput = new Scanner(System.in);
		        
		        //setting project number
		        projectInput = new Scanner(System.in);
		        System.out.print("Project Number: ");
		        try {
		        	project.setProjectNumber(projectInput.nextInt());
		        }
		        catch (Exception E) {
		        	boolean invalid_number = true;
		        	do {
		        	System.out.println("You have entered incorrect project number");
		        		System.out.print("Project Number: ");
		        		projectInput = new Scanner(System.in);
		        		if(projectInput.hasNextInt()) {
		        			project.setProjectNumber(projectInput.nextInt());
		        			invalid_number = false;
		        		}
		        		
		        		}while(invalid_number);
		        	project.setProjectNumber(0);
		        }
		        int projectNumber = project.getProjectNumber();
		        
		      //setting Building Type
		        projectInput = new Scanner(System.in);
		        System.out.print("Building Type (e.g. House): ");
		        project.setBuildingDesign(projectInput.nextLine());
		        String BuildingDesign = project.getBuildingDesign();

		      //setting name
		        projectInput = new Scanner(System.in);
		        System.out.print("Project Name: ");
		        String pname = "";
		        String projectname = projectInput.nextLine();
	        	project.setProjectName(projectname);
	        	if (!projectInput.hasNextLine()) {
		        	pname = project.getBuildingDesign() + " " + client.getSurname();
			        project.setProjectName(pname);}
		        
		        //setting address for the project
		        projectInput = new Scanner(System.in);
		        System.out.print("Address: ");
		        project.setAddress(projectInput.nextLine());
		        String ProjectAddress = project.getAddress();
		
		        //setting erf
		        projectInput = new Scanner(System.in);
		        System.out.print("ERF Number: ");
		        try {
		        	project.setERF(projectInput.nextInt());
		        }
		        catch (Exception E) {
		        	boolean invalid_erf = true;
		        	do {
		        	System.out.println("incorrect ERF Number");
		        	System.out.println("ERF Number: ");
		        	projectInput = new Scanner(System.in);
		        	if(projectInput.hasNextInt()) {
		        		invalid_erf = false;
		        		project.setERF(projectInput.nextInt());
		        	}
		        	}while(invalid_erf);
		        }
		        int ERFnumber = project.getERF();
		        
		        //setting Project fees
		        projectInput = new Scanner(System.in);
		        System.out.print("Project Fees:R ");
		        try {
		        	project.setProjectFee(projectInput.nextDouble());
		        	
		        }
		        catch (Exception E) {
		        	System.out.println("Entered invalid digits");
		        	project.setProjectFee(0);
		        	
		        }
		        double ProjectFee = project.getProjectFee();
		
		        //setting amount paid
		        projectInput = new Scanner(System.in);
		        System.out.print("Amount paid:R ");
		        try {
		        	project.setAmountPaid(projectInput.nextDouble());
		        	
		        }
		        catch (Exception E) {
		        	System.out.println("wrong input");
		        	project.setAmountPaid(0);
		        
		        }
		        double AmountPaid = project.getAmountPaid();
		        
		        //setting isCompleted
		        project.setCompleted("No");
		        String isCompleted = project.isCompleted();
		
		        //setting Project Due Date
		        projectInput = new Scanner(System.in);
		        System.out.print("Project Due Date (yyyy-MM-dd): ");
		        project.setProjectDueDate(projectInput.nextLine());
		        String ProjectDueDate = project.getProjectDueDate();
		        
		      //setting Architecture
		        project.setArchitecture(achitecture);
		
		        //setting client
		        project.setClient(client);
		        
		        // setting buildingContractor
		        project.setbuildingContractor(contractor);
		        
		       // insert client's values to the database table called People_table
		        String clientQuery = "INSERT INTO People_table VALUES('"+
		        					clientName +"', '"+ 
			                	   clientSurname +"', '"+ 
			                	   clientTel +"','"+ 
			                	   clientEmail +"', '"+ 
			                	   clientAddress +"');";
		        rowsAffected = statement.executeUpdate(clientQuery);
		        System.out.println("Query complete, " + rowsAffected + " rows added.");
		        
		     // insert achitect's values to the database table called People_table
        		String achiQuery = "INSERT INTO People_table VALUES('"+
        							achitectureName +"', '"+ 
			                	   achitectureSurname +"', '"+ 
			                       achitectureTel +"','"+ 
			                	   achitectureEmail +"', '"+ 
			                	   achitectureAddress +"');";
        		rowsAffected = statement.executeUpdate(achiQuery);
        		System.out.println("Query complete, " + rowsAffected + " rows added.");
		        
        		// insert contractor's values to the database table called People_table
				String contQuery = "INSERT INTO People_table VALUES('"+
									contractorName + "', '"+ 
			                	   contractorSurname +"', '"+ 
			                	   contractorTel +"','"+ 
		                		   contractorEmail +"', '"+ 
			                	   contractorAddress +"');";
				rowsAffected = statement.executeUpdate(contQuery);
                System.out.println("\n");
	            System.out.println("Query complete, " + rowsAffected + " rows added.");
                
			     // insert project's values to the database table called Project_table
              String ProjectQuery = "INSERT INTO Project_table VALUES("+
            		  				projectNumber +", '"+ 
		                		   project.getProjectName() +"', '"+ 
		                		   BuildingDesign +"', '"+ 
		                		   ProjectAddress +"', "+ 
		                		   ERFnumber +", "+ 
		                		   ProjectFee +", "+ 
		                		   AmountPaid +", '"+
		                		   isCompleted +"', '"+ 
		                		   ProjectDueDate +"', '"+
					        	   project.getCompletedDate()+"', '"+
		        				   clientName +"', '"+ 
			                	   clientSurname +"', '"+
			                	   achitectureName +"', '"+ 
			                	   achitectureSurname +"', '"+
			                	   contractorName + "', '"+ 
			                	   contractorSurname +"');";
				   
                rowsAffected = statement.executeUpdate(ProjectQuery);
                System.out.println("\n");
	            System.out.println("Query complete, " + rowsAffected + " rows added.");
		        
		        projectObjects.add(project);
		        System.out.println("project added successfully");

		        // display project's details to the user
		        System.out.println("\nPROJECT'S DETAILS\n");
		    	try {
			        
			        results = statement.executeQuery("SELECT Project_Number, Project_Name, Building_Type, Project_Address, ERF_Number, Project_Fee, Paid_Amount, Project_Completed, Project_Duedate, Completion_Date FROM Project_table WHERE Project_Number = " + projectNumber + "");
			        while (results.next()) {
			            System.out.println(
			            		"Project Number    | " + results.getInt("Project_Number") +
			            		"\nProject Name      | " + results.getString("Project_Name") + 
			                    "\nBuilding Type     | " + results.getString("Building_Type") +
			                    "\nProject Address   | " + results.getString("Project_Address") +
			                    "\nERF Number        | " + results.getInt("ERF_Number") +
			                    "\nProject Fee       |R " + results.getDouble("Project_Fee") +
			                    "\nAmount Paid       |R " + results.getDouble("Paid_Amount") +
			                    "\nProject DueDate   | " + results.getString("Project_Duedate") +
			                    "\nProject Completed | " + results.getString("Project_Completed") +
			                    "\nCompletion Date   | " + results.getString("Completion_Date"));
			        }
			    } catch(SQLException ex) {
			        ex.printStackTrace();
			    }
		    	
		        // display client's details to the user
		        System.out.println("\nCLIENT'S DETAILS\n");
		        try {
		        	
    		        results = statement.executeQuery("SELECT Name, Surname, Telephone, Email_Address, Physical_Address  FROM People_table WHERE Name = '" + clientName + "' AND Surname = '" + clientSurname + "'");

			        while (results.next()) {
			            System.out.println(
			            		"Name             | " + results.getString("Name") +
			            		"\nSurname          | " + results.getString("Surname") + 
			            		"\nTelephone        | " + results.getString("Telephone") + 
			                    "\nEmail Address    | " + results.getString("Email_Address") +
			                    "\nPhysical Address | " + results.getString("Physical_Address") 
			                );
			        }
		        } catch(SQLException ex) {
		            ex.printStackTrace();
		        }
		        
		        // display achitect's details to the user
		        System.out.println("\nACHITECTURE'S DETAILS\n");
		        try {
		        	results = statement.executeQuery("SELECT Name, Surname, Telephone, Email_Address, Physical_Address  FROM People_table WHERE Name = '" + achitectureName + "' AND Surname = '" + achitectureSurname + "'");

			        while (results.next()) {
			            System.out.println(
			            		"Name             | " + results.getString("Name") +
			            		"\nSurname          | " + results.getString("Surname") + 
			            		"\nTelephone        | " + results.getString("Telephone") + 
			                    "\nEmail Address    | " + results.getString("Email_Address") +
			                    "\nPhysical Address | " + results.getString("Physical_Address") 
			                );
			        }
		        } catch(SQLException ex) {
		            ex.printStackTrace();
		        }
		        
		        // display contractor's details to the user
		        System.out.println("\nCONTRACTOR'S DETAILS\n");
		        try {
    		        results = statement.executeQuery("SELECT Name, Surname, Telephone, Email_Address, Physical_Address  FROM People_table WHERE Name = '" + contractorName + "' AND Surname = '" + contractorSurname + "'");

			        while (results.next()) {
			            System.out.println(
			            		"Name             | " + results.getString("Name") +
			            		"\nSurname          | " + results.getString("Surname") + 
			            		"\nTelephone        | " + results.getString("Telephone") + 
			                    "\nEmail Address    | " + results.getString("Email_Address") +
			                    "\nPhysical Address | " + results.getString("Physical_Address") 
			                );
			        }
		        } catch(SQLException ex) {
		            ex.printStackTrace();
		        }
		        
			} 
			else if (optionLower.equals("e"))
			{
	            
		        // the editing part of the project is put inside a loop to allow the user to choose if they want to change specific details of the project.
		        Boolean control_edit = true;
		        while (control_edit) {
		            Scanner user_input = new Scanner(System.in);
					System.out.print("\nEnter the project number of the project you want to edit\n");
					Scanner scan = new Scanner(System.in);
					showProjects(projectObjects);
					int proj_number = scan.nextInt();
					
					ArrayList<PoisedProjects> projects = getDataFromPoise();
					
					for(int i = 0; i < projects.size(); i++) {
					if (proj_number == projects.get(i).getProjectNumber()) {
		            String edit_projectLower = "yes";
		
		            // user chooses what they want to edit should they want to edit
		            if (edit_projectLower.equals("yes")) {
		                Scanner input = new Scanner(System.in);
		                System.out.println("\nPlease enter the letter of what you want to edit: \nd-duedate, \na-amount paid, \nu-update contractor, \nf-finalize- ");
		                String edit_choice = input.nextLine();
		                String edit_choiceLower = edit_choice.toLowerCase();
		
		                // if the user chooses to edit the deadline, they are asked to enter the new details and the necessary changes are made.
		                switch (edit_choiceLower) {
		                case "d":

		                    Scanner NwDeadline = new Scanner(System.in);
		                    System.out.print("Enter new duedate as (yyyy-mm-dd)");
		                    String nwDeadline = NwDeadline.nextLine();
		                    String OldDeadline = projects.get(i).getProjectDueDate();
		          
		                    
		                    rowsAffected = statement.executeUpdate("UPDATE Project_table set Project_Duedate  = '" + nwDeadline + "' Where Project_Number ='" + proj_number +"'");
		                    System.out.println("Query complete, " + rowsAffected + " rows updated.");
		                    projects.get(i).setProjectDueDate(nwDeadline); // getting the new date from the user as a string
		                    System.out.println("\nDUEDATE CHANGED FROM : " + OldDeadline  + " TO " +projects.get(i).getProjectDueDate());
		                    System.out.print("\nThe new project details\n_______________________________________________________________\n" + projects.get(i).toString() + "\n_______________________________________________________________\n");

		                    control_edit =false;
		                break;
		                
		                
		                // edit amount paid
		                case "a":
		                    Scanner newAmount_paid = new Scanner(System.in);
		                    System.out.print("Enter new amount paid: R");
		                    int newAmount = newAmount_paid.nextInt();
		                    
		                    rowsAffected = statement.executeUpdate("UPDATE  Project_table set Paid_Amount = " + newAmount + " Where Project_Number = " + proj_number );
		                    System.out.println("Query complete, " + rowsAffected + " rows updated.");
		                    projects.get(i).setAmountPaid(newAmount); // adding new amount entered to not overwrite current amount paid.
		                    System.out.print("\nThe new project details\n_______________________________________________________________\n" + projects.get(i).toString() + "\n_______________________________________________________________\n");
		                    

		                    control_edit =false;
		                    break;
		
		                   
		                    // if user chooses to update the contractor's details, they are asked to enter the new details and the necessary changes are made.
		                case "u":
		                	
		                	String contraName = projects.get(i).getBuildingContractor().getName();
		                	String contraSurname = projects.get(i).getBuildingContractor().getSurname();
		                    System.out.print("\nChanging the details of the contractor named: " + contraName + " " + contraSurname + "\n");
		                    
		                    Scanner contractor_phoneNumber_inputnew = new Scanner(System.in);
		                    System.out.print("Please enter their new telephone number: ");
		                    String newTel =contractor_phoneNumber_inputnew.nextLine();
		                    rowsAffected = statement.executeUpdate("UPDATE  People_table set Telephone = '" + newTel + "' WHERE Name = '" + contraName + "' AND Surname = '" + contraSurname + "';");
		                    System.out.println("Query complete, " + rowsAffected + " rows updated.");

		                    Scanner contractor_email_inputnew = new Scanner(System.in);
		                    System.out.print("Please enter their new email address: ");
		                    String newEmail = contractor_email_inputnew.nextLine();
		                    rowsAffected = statement.executeUpdate("UPDATE  People_table set Email_Address = '" + newEmail + "' WHERE Name = '" + contraName + "' AND Surname = '" + contraSurname + "';");
		                    System.out.println("Query complete, " + rowsAffected + " rows updated.");
		                    
		                    // display new contractor's details
		                    System.out.print("\nThe new details of the contractor\n_______________________________________________________________\n");
            		        
            		        try {
                		        results = statement.executeQuery("SELECT Name, Surname, Telephone, Email_Address, Physical_Address  FROM People_table WHERE Name = '" + contraName + "' AND Surname = '" + contraSurname + "'");

            			        while (results.next()) {
            			            System.out.println(
            			            		"Name             | " + results.getString("Name") +
            			            		"\nSurname          | " + results.getString("Surname") + 
            			            		"\nTelephone        | " + results.getString("Telephone") + 
            			                    "\nEmail Address    | " + results.getString("Email_Address") +
            			                    "\nPhysical Address | " + results.getString("Physical_Address") 
            			                );
            			        }
            		        } catch(SQLException ex) {
            		            ex.printStackTrace();
            		        }
            		        System.out.print("\n_______________________________________________________________\n");
		                    control_edit =false;
		
		                   break; 
		                    
		                   
		                   // if user chooses to finalize the project, if the user still owes the company, an invoice is generated and insert in the invoice table
		                case "f":
		                    if (projects.get(i).getProjectFee() > projects.get(i).getAmountPaid()) {
			                        double balance = projects.get(i).getProjectFee() - projects.get(i).getAmountPaid();
			                        System.out.println(balance);
			                       
	                        			String invoiceString = "INSERT INTO Invoice_table VALUES (" +
	                        			
	                        					proj_number + ", '" +
	                        					projects.get(i).getClient().getName() + "', '" + 
	                        					projects.get(i).getClient().getSurname() + "', " +
	                        					projects.get(i).getProjectFee() + ", " + 
			                        			projects.get(i).getAmountPaid() + ", " +
			                        			balance + ");";
	                        			
	                        			rowsAffected = statement.executeUpdate(invoiceString);
	                        			System.out.println("Query complete, " + rowsAffected + " rows created.");
	                        			System.out.println("Invoice Saved in the Invoice table");
	                        			
				                  
	                        // if the customer has already fully paid, no invoice is generated.
	                    } else
	                        System.out.println("\nNo invoice to be generated, the client settled the balance.");}
	           
		                    Scanner mark_complete = new Scanner(System.in);
		                    System.out.println("\nDo you want to mark this task complete? (Yes or No) ");
		                    String complete_task = mark_complete.nextLine();
		                    String complete_taskLower = complete_task.toLowerCase();
		                    
		                    // if the user chooses to mark the task complete, we mark it with a Yes and assign the current date to the completion date.
		                    if (complete_taskLower.equals("yes")) {
		                    	
		                		rowsAffected = statement.executeUpdate("UPDATE  Project_table set Project_Completed = 'YES' Where Project_Number =" + proj_number );
		            			
		                		// setting the current date
		                		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        	            String date = sdf.format(new Date());
		
		                		rowsAffected = statement.executeUpdate("UPDATE  Project_table set Completion_Date = '" + date + "' Where Project_Number =" + proj_number );
		                		System.out.println("Query complete, " + rowsAffected + " rows created.");
		                        control_edit = false;
		                        }
			                   
		                    // if user chooses not to edit the project, we exit the program.
		                    else if (complete_taskLower.equals("no")) {
		                    	System.out.print("\nExit successful, thank you\n");
		                    	control_edit = false;
		                    	break;}
		                    
		                    else {
		                    	System.out.print("\nYou have made an invalid choice\n");
		                    	control_edit = false;
		                    
			                    	}break;
		                    	}
		                	}
		            	
					// if user chooses not to edit the project, we exit the program.
                    else {
                    	System.out.print("\nInvalid project number\n");}
					}
				}
	        }
			// if user chooses to view incomplete tasks	        
	        else if(optionLower.equals("v")) {
	        	
				showIncompletedProjects(projectObjects);
        		
        	}
			// if user chooses	to view overdue projects
			else if(optionLower.equals("o")) {

				showPastDueDate(projectObjects);
			}
			// if user chooses to view all poised projects
			else if(optionLower.equals("p")) {
	
				printAllTasks(statement);
			}
			// if enters a wrong letter.
            else {
            	System.out.print("\nYou have entered an invalid input\n");}
			
        }catch(Exception error) {
		System.out.print("\nYou have entered an invalid input");
	 	}
		}
				}catch(SQLException ex) {
    	// We only want to catch a SQLException - anything else is off-limits for now.
        ex.printStackTrace();
		}
	}
	
	
	// Gets data from text file and stores in Array list
	static ArrayList<PoisedProjects> getDataFromPoise() {
        
        ArrayList<PoisedProjects> projectObjects= new ArrayList<PoisedProjects>();

		ResultSet results ; 
		try {
			

			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
		    // Use username "otheruser", password "swordfish".
		    Connection connection = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/poisePMS?useSSL=false",
		            "otheruser",
		            "swordfish"
		            );
		
			// Create a direct line to the database for running our queries
		    Statement statement = connection.createStatement();
		    results = statement.executeQuery("select * from Project_table");
		    
    		while (results.next()) {
    			
    			People client = new People(results.getString("Client_Name"),results.getString("Client_Surname"));
            	People architect = new People(results.getString("Architect_Name"),results.getString("Architect_Surname"));
    			People contractor = new People(results.getString("Contractor_Name"),results.getString("Contractor_Surname"));
    			
    			PoisedProjects newProject = new PoisedProjects(Integer.parseInt(results.getString("Project_Number")),results.getString("Project_Name"),results.getString("Building_Type"),results.getString("Project_Address"),Integer.parseInt(results.getString("ERF_Number")), Double.parseDouble(results.getString("Project_Fee")),Double.parseDouble(results.getString("Paid_Amount")),results.getString("Project_Completed"),results.getString("Project_Duedate"),results.getString("Completion_Date"), client, architect, contractor);
        		
    			projectObjects.add(newProject);
			}
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		                                                                                                                                                                                              
    		return projectObjects;
	 }
	 
	static void showProjects(ArrayList<PoisedProjects> project) {
		for(int i = 0; i < project.size(); i++) {
		
			System.out.println(project.get(i).getProjectNumber() + " : " + project.get(i).getProjectName());
		}
	}
	
	// Only displays projects that are incomplete
	static void showIncompletedProjects(ArrayList<PoisedProjects> project) {
		for(int i = 0; i < project.size(); i++) {
			String isComplete = project.get(i).isCompleted();
			String isCompleteLower = isComplete.toLowerCase();
			if(isCompleteLower.equals("no")) {
				System.out.println("\nINCOMPLETE PROJECT:\n");
				System.out.println(i + 1 + "\n"+ project.get(i).toString() + "\n");
			}
			else
			System.out.println("\nYOU DO NOT HAVE INCOMPLETE PROJECTS!\n");
		}
	}
	
	// displays projects that have passed due date
	static void showPastDueDate(ArrayList<PoisedProjects> project) {
		
		for(int i = 0; i < project.size(); i++) {
			try {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
	            String date = sdf.format(new Date());
	            Date today;
				Date duedate;
				today = sdf.parse(date);
				duedate = sdf.parse(project.get(i).getProjectDueDate());
				String isComplete = project.get(i).isCompleted();
				String isCompleteLower = isComplete.toLowerCase();
				  
				if(today.compareTo(duedate) > 0 && isCompleteLower.equals("no")){
					System.out.println("\nOVERDUE PROJECT:\n");
	
					System.out.println("The duedate for this project is : " + sdf.format(duedate));
		            System.out.println("The today's date is: " + sdf.format(today));
					System.out.println(i +1 + "\n" + project.get(i).toString() + "\n");
				}
			}
			catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	// displays projects in the table
	static void printAllTasks(Statement statement) throws SQLException{
		ResultSet results ; 
		try {
			
	        results = statement.executeQuery("SELECT *  FROM Project_table");
	        System.out.println("\nPOISED PROJECTS:\n");
	        
	        while (results.next()) {
	        	
	            System.out.println(
	            		
	            		"Project Number    | " + results.getInt("Project_Number") +
	            		"\nProject Name      | " + results.getString("Project_Name") + 
	                    "\nBuilding Type     | " + results.getString("Building_Type") +
	                    "\nProject Address   | " + results.getString("Project_Address") +
	                    "\nERF Number        | " + results.getInt("ERF_Number") +
	                    "\nProject Fee       | R " + results.getDouble("Project_Fee") +
	                    "\nAmount Paid       | R " + results.getDouble("Paid_Amount") +
	                    "\nProject DueDate   | " + results.getString("Project_Duedate") +
	                    "\nProject Completed | " + results.getString("Project_Completed") +
	                    "\nCompletion Date   | " + results.getString("Completion_Date")+
	                    "\nClient Name       | " + results.getString("Client_Name")+
	                    "\nClient Surname    | " + results.getString("Client_Surname")+
	                    "\nArchitect Name    | " + results.getString("Architect_Name")+
	                    "\nArchitect Surname | " + results.getString("Architect_Surname")+
	                    "\nContractor Name   | " + results.getString("Contractor_Name")+
	                    "\nContractor Surname| " + results.getString("Contractor_Surname")+
	                    "\n\n"
	                    
	            		);}
	        
        
	    } catch(SQLException ex) {
	        ex.printStackTrace();
	    }
	}

}

//***********************************************************************************************END********************************************************************************