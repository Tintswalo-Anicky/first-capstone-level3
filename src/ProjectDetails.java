/*  # TASK 8
	# Compulsory Task
	# ProjectDetails.java
	# written by Tintswalo Anicky Makhubele
	# date:  28 June 2020
	# Function: This program helps a small structural engineering firm called “Poised” to keep track of the many projects on which they work.
	*/
public class ProjectDetails {
	
	private String projectName;
	private int projectNumber;
	private String buildingDesign;
	private String address;
	private int ERF;
	private double projectFee;
	private double amountPaid;
	private String isCompleted;
	private String projectDueDate;
	private String completedDate;
	private People architecture;
	private People client;
	private People buildingContractor;

	public ProjectDetails() {
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getBuildingDesign() {
		return buildingDesign;
	}

	public void setBuildingDesign(String buildingDesign) {
		this.buildingDesign = buildingDesign;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getERF() {
		return ERF;
	}

	public void setERF(int eRF) {
		ERF = eRF;
	}

	public double getProjectFee() {
		return projectFee;
	}

	public void setProjectFee(double projectFee) {
		this.projectFee = projectFee;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getProjectDueDate() {
		return projectDueDate;
	}

	public void setProjectDueDate(String projectDueDate) {
		this.projectDueDate = projectDueDate;
	}

	public String getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}

	public People getArchitecture() {
		return architecture;
	}

	public void setArchitecture(People architecture) {
		this.architecture = architecture;
	}

	public People getClient() {
		return client;
	}

	public void setClient(People client) {
		this.client = client;
	}

	public People getBuildingContractor() {
		return buildingContractor;
	}

	public void setBuildingContractor(People buildingContractor) {
		this.buildingContractor = buildingContractor;
	}

}
