package com.example.customlistviewexample;

import java.sql.SQLException;
import java.util.ArrayList;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class DataHelperClass extends DatabaseHelper {

	private Context myContext;
	private Dao<Student, Void> simpleDAO = null;
	private RuntimeExceptionDao<Student, Void> simpleRuntimeDao = null;

	public DataHelperClass(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		myContext = context;
	}

	public Dao<Student, Void> getDAO() throws SQLException {
		if (simpleDAO == null) {
			simpleDAO = getDao(Student.class);
		}
		return simpleDAO;
	}

	public RuntimeExceptionDao<Student, Void> getSimpleDataDao() {
		if (simpleRuntimeDao == null) {
			simpleRuntimeDao = getRuntimeExceptionDao(Student.class);
		}
		return simpleRuntimeDao;
	}

	// method for insert data
	public int addData(Student student) {
		RuntimeExceptionDao<Student, Void> dao = getSimpleDataDao();
		int i = dao.create(student);
		return i;
	}

	// method for list of students
	public ArrayList<Student> GetData() {
		DataHelperClass helper = new DataHelperClass(myContext);
		RuntimeExceptionDao<Student, Void> simpleDao = helper
				.getSimpleDataDao();
		ArrayList<Student> list = (ArrayList<Student>) simpleDao.queryForAll();
		return list;
	}
}
