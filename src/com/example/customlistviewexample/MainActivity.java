package com.example.customlistviewexample;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	// Student List
	ArrayList<Student> studentList = new ArrayList<Student>();

	// Adapter variables
	private StudentAdapterClass myADC;

	// list view variable
	private ListView myListView;

	ArrayList<Student> list;

	// private MyDatabase databaseHelper = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DatabaseHelper myDB = new DatabaseHelper(MainActivity.this);

		try {
			myDB.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d("onCreateDataBase",
					"Error while creating database MainActivity");
			e.printStackTrace();
		}
		
		//myDB.insertIntoStudentTable(1, "Arun", "IC-18", R.drawable.ic_launcher, "P101");
		
		myDB.showData();

		/*if (myDB.insertIntoStudentTable(1, "Physics", "P101")) {
			Toast.makeText(this, "Insert successful", Toast.LENGTH_SHORT)
					.show();
		} else {
			Toast.makeText(this, "Unable to insert record", Toast.LENGTH_SHORT)
					.show();
		}*/
		
		
		/*
		 * Dao<Student, Void> simpleDao; try { // simpleDao =
		 * getHelper().getDaoStudent(); list = (ArrayList<Student>)
		 * simpleDao.queryForAll(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		myListView = (ListView) findViewById(R.id.lvStudent);

		myADC = new StudentAdapterClass(MainActivity.this,
				R.layout.some_layout, list);

		/*
		 * if (myADC.isEmpty()) { Toast.makeText(MainActivity.this,
		 * "No records found", Toast.LENGTH_SHORT).show(); } else {
		 * myListView.setAdapter(myADC); }
		 */
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		/*
		 * if (databaseHelper != null) { OpenHelperManager.releaseHelper();
		 * databaseHelper = null; }
		 */
	}

	/*
	 * private MyDatabase getHelper() { if (databaseHelper == null) {
	 * databaseHelper = OpenHelperManager.getHelper(this, MyDatabase.class); }
	 * return databaseHelper; }
	 */

}