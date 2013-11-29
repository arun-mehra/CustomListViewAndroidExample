package com.example.customlistviewexample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "student")
public class Student {
	@DatabaseField(canBeNull = false)
	private String studentName;
	
	@DatabaseField(canBeNull = false)
	private String studentRollNo;
	
	@DatabaseField(canBeNull = false)
	private int studentImage;
	

	public Student() {

	}

	public Student(String studentName, String studentRollNo, int studentImage) {
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
		this.studentImage = studentImage;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentRollNo() {
		return studentRollNo;
	}

	public int getStudentImage() {
		return studentImage;
	}

}
