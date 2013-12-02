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

	@DatabaseField(foreign = true, canBeNull = false)
	private Subjects subject;

	public Student() {

	}

	public Student(String studentName, String studentRollNo, int studentImage,
			Subjects subject) {
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
		this.studentImage = studentImage;
		this.subject = subject;
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

	public Subjects getSubject() {
		return subject;
	}

}