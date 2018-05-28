package com.hsc.cat.enums;


//New class added
public enum RoleCategoryEnum {
	FRONTEND_DEVELOPER(1, "Fronteend Developer"), BACKEND_DEVELOPER(2, "Backend Developer"), FULLSTACK_DEVELOPER(3,
			"Fullstack Developer"), MANUAL_TESTER(4, "Manual Tester"), AUTOMATION_TESTER(4, "Automation Tester");
	int value;
	String name;

	private RoleCategoryEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
