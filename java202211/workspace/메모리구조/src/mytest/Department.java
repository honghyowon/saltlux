package mytest;

public class Department {

	// constructor
	public Department() {
		
	}
	
	public Department(String deptName, String detpNumber) {
		this.deptName = deptName;
		this.deptNumber = detpNumber;
	}

	
	// field
	private String deptName;	//학과명
	private String deptNumber;	//학과전화번호
	
	// method
	// business method
	// getter & setter
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}
	
	
}//
