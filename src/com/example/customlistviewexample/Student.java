package com.example.customlistviewexample;

import java.util.Comparator;

public class Student {
	private String StudentName;
	private String StudentRollNo;
	private int StudentImage;

	public Student() {

	}

	public Student(String StudentName, String StudentRollNo, int StudentImage) {
		this.StudentName = StudentName;
		this.StudentRollNo = StudentRollNo;
		this.StudentImage = StudentImage;
	}

	public String getStudentName() {
		return StudentName;
	}

	public String getStudentRollNo() {
		return StudentRollNo;
	}

	public int getStudentImage() {
		return StudentImage;
	}

}
