/*  # TASK 8
	# Compulsory Task
	# People.java
	# written by Tintswalo Anicky Makhubele
	# date:  18 June 2020
	# Function: This program helps a small structural engineering firm called “Poised” to keep track of the many projects on which they work.
	*/

public class People {
	
	// attributes of each person
	String name;
    String surname;
    String tel;
    String email;
    String address;
    
	People(){
	    	
	    }
	    
    // constructor
    public People(String name, String surname, String tel,  String email, String address) {
    	
        this.name = name;
        this.surname = surname;
        this.tel = tel;
        this.email = email;
        this.address = address;
    }
    
    public People(String name, String surname) {
    	this.name = name;
        this.surname = surname;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    // output format for details of each person
    public String toString() {
    	String output = "Name     | " + name;
    	output += "\nSurname  | " + surname;
    	output += "\nTelephone| " + tel;
    	output += "\nAddress  | " + address;
    	output += "\nEmail    | " + email;
    	
    	return output;
    }

}

//***********************************************************END**********************************************************************

