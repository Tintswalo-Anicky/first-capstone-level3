/*  # TASK 8
	# Compulsory Task
	# PoisedProjects.java
	# written by Tintswalo Anicky Makhubele
	# date:  17 June 2020
	# Function: This program helps a small structural engineering firm called “Poised” to keep track of the many projects on which they work.
	*/
public class PoisedProjects {
	
	private ProjectDetails data = new ProjectDetails();
	PoisedProjects() {
    	
    }
    // initialization for project constructor
    public PoisedProjects(int projectNumber,String projectName,  String buildingDesign, String address, int ERF, double projectFee, double amountPaid, String isCompleted, String projectDueDate, String completedDate, People architecture, People contractor,People client) {
        
        this.data.setProjectNumber(projectNumber);
        this.data.setProjectName(projectName);
        this.data.setBuildingDesign(buildingDesign);
        this.data.setAddress(address);
        this.data.setERF(ERF);
        this.data.setProjectFee(projectFee);
        this.data.setAmountPaid(amountPaid);
        this.data.setIsCompleted(isCompleted);
        this.data.setProjectDueDate(projectDueDate);
        this.data.setCompletedDate(completedDate);
        this.data.setArchitecture(architecture);
        this.data.setClient(client);
        this.data.setBuildingContractor(contractor);
     }

	public String getProjectName() {
	    return data.getProjectName();
	}
	
	public void setProjectName(String projectName) {
	    this.data.setProjectName(projectName);
	}
	
	public int getProjectNumber() {
	    return data.getProjectNumber();
	}
	
	public void setProjectNumber(int projectNumber) {
	    this.data.setProjectNumber(projectNumber);
	}
	
	public String getBuildingDesign() {
	    return data.getBuildingDesign();
	}
	
	public void setBuildingDesign(String buildingDesign) {
	    this.data.setBuildingDesign(buildingDesign);
	}
	
	public String getAddress() {
	    return data.getAddress();
	}
	
	public void setAddress(String address) {
	    this.data.setAddress(address);
	}
	
	public int getERF() {
	    return data.getERF();
	}
	
	public void setERF(int ERF) {
	    this.data.setERF(ERF);
	}
	
	public double getProjectFee() {
	    return data.getProjectFee();
	}
	
	public void setProjectFee(double projectFee) {
	    this.data.setProjectFee(projectFee);
	}
	
	public double getAmountPaid() {
	    return data.getAmountPaid();
	}
	
	public void setAmountPaid(double amountPaid) {
	    this.data.setAmountPaid(amountPaid);
	}
	
	public String isCompleted() {
	    return data.getIsCompleted();
	}
	
	public void setCompleted(String completed) {
	    data.setIsCompleted(completed);
	}
	
	public String getProjectDueDate() {
	    return data.getProjectDueDate();
	}
	
	public void setProjectDueDate(String projectDueDate) {
	    this.data.setProjectDueDate(projectDueDate);
	}
	
	public String getCompletedDate() {
	    return data.getCompletedDate();
	}
	
	public void setCompletedDate(String completedDate) {
	    this.data.setCompletedDate(completedDate);
	}
	
	public People getArchitecture() {
	    return data.getArchitecture();
	}
	
	public void setArchitecture(People architecture) {
	    this.data.setArchitecture(architecture);
	}

	public People getBuildingContractor() {
	    return data.getBuildingContractor();
	}
	
	public void setbuildingContractor(People contractor){
		this.data.setBuildingContractor(contractor);
		
	}
	
	public People getClient() {
	    return data.getClient();
	}
	
	public void setClient(People client) {
	    this.data.setClient(client);
	}
	
    
    @Override
    public String toString() {
        return  "Project Number       | " + data.getProjectNumber() +
                "\nProject Name         | " + data.getProjectName() +
                "\nBuilding Type        | " + data.getBuildingDesign() +
                "\nProject Address      | " + data.getAddress() +
                "\nERF Number           | " + data.getERF() +
                "\nProject Fee          | R" + data.getProjectFee() +
                "\nAmount Paid          | R" + data.getAmountPaid() +
                "\nProject Completed?   | " + data.getIsCompleted() +
                "\nProject DueDate      | " + data.getProjectDueDate() +
                "\nCompletion Date      | " + data.getCompletedDate();
    }
}

//***********************************************************END**********************************************************************