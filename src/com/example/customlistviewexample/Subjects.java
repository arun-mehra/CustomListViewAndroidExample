package com.example.customlistviewexample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Subjects")
public class Subjects {

	@DatabaseField(id = true)
	private String subjectCode;

	@DatabaseField(canBeNull = false)
	private String subjectName;
	
	public Subjects(){
		
	}
	
	public Subjects(String subjectCode, String subjectName){
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}
