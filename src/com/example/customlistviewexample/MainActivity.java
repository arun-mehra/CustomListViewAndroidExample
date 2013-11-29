package com.example.customlistviewexample;

import java.sql.SQLException;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

public class MainActivity extends Activity {

	// Student List
	ArrayList<Student> studentList = new ArrayList<Student>();

	// Adapter variables
	private StudentAdapterClass myADC;

	// list view variable
	private ListView myListView;

	ArrayList<Student> list;

	private DatabaseHelper databaseHelper = null;

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

	@Override
	protected void onDestroy() {
		super.onDestroy();

		if (databaseHelper != null) {
			OpenHelperManager.releaseHelper();
			databaseHelper = null;
		}
	}
	
	private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
                databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
}

}
