package com.example.customlistviewexample;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

	// Student List
	ArrayList<Student> studentList = new ArrayList<Student>();

	// Adapter variables
	private StudentAdapterClass myADC;

	// list view variable
	private ListView myListView;
	
	ArrayList<Student> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Dao<Student, Void> simpleDao;
		try {
			simpleDao = getHelper().getDao();
			list = (ArrayList<Student>) simpleDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myListView = (ListView) findViewById(R.id.lvStudent);		

		/*
		 * studentList.add(new Student("Arun", "IC-03",
		 * R.drawable.ic_launcher)); studentList.add(new Student("Nikhil",
		 * "IC-13", R.drawable.ic_launcher)); studentList.add(new
		 * Student("Rony", "IC-23", R.drawable.ic_launcher));
		 * studentList.add(new Student("Clouds", "IC-33",
		 * R.drawable.ic_launcher)); studentList.add(new Student("Rajeev",
		 * "IC-43", R.drawable.ic_launcher)); studentList.add(new
		 * Student("Shri", "IC-53", R.drawable.ic_launcher));
		 * studentList.add(new Student("John", "IC-63",
		 * R.drawable.ic_launcher)); studentList.add(new Student("Rambo",
		 * "IC-73", R.drawable.ic_launcher)); studentList.add(new
		 * Student("Dark", "IC-83", R.drawable.ic_launcher));
		 * studentList.add(new Student("Knight", "IC-93",
		 * R.drawable.ic_launcher)); studentList.add(new Student("James",
		 * "IC-103", R.drawable.ic_launcher)); studentList.add(new
		 * Student("Gosling", "IC-113", R.drawable.ic_launcher));
		 */

		myADC = new StudentAdapterClass(MainActivity.this,
				R.layout.some_layout, list);

		// display the list.
		myListView.setAdapter(myADC);

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
