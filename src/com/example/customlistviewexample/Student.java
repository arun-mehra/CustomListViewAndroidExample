package com.example.customlistviewexample;


public class Student {
	private String studentName;
	private String studentRollNo;
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
