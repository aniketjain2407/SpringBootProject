package RawMaterial.Model.enums;

public enum UserType {
	Admin(0),
	Accountant(1),
	Student(2);
	
	long userTypeId;

	UserType(long userTypeId) {
		this.userTypeId = userTypeId;
	}
	
	public long getUserTypeId() {
		return userTypeId;
	}



}
