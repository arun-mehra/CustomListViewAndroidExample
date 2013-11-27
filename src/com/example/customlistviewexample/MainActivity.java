package com.example.customlistviewexample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	//Student List
	ArrayList<Student> StudentList = new ArrayList<Student>();

	
	//Adapter variables
	private StudentAdapterClass myADC;
	
	//list view variable
	private ListView myListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myListView = (ListView) findViewById(R.id.lvStudent);
		
		StudentList.add(new Student("Arun", "IC-03", R.drawable.ic_launcher));
		StudentList.add(new Student("Nikhil", "IC-13", R.drawable.ic_launcher));
		StudentList.add(new Student("Rony", "IC-23", R.drawable.ic_launcher));
		StudentList.add(new Student("Clouds", "IC-33", R.drawable.ic_launcher));
		StudentList.add(new Student("Rajeev", "IC-43", R.drawable.ic_launcher));
		StudentList.add(new Student("Shri", "IC-53", R.drawable.ic_launcher));
		StudentList.add(new Student("John", "IC-63", R.drawable.ic_launcher));
		StudentList.add(new Student("Rambo", "IC-73", R.drawable.ic_launcher));
		StudentList.add(new Student("Dark", "IC-83", R.drawable.ic_launcher));
		StudentList.add(new Student("Knight", "IC-93", R.drawable.ic_launcher));
		StudentList.add(new Student("James", "IC-103", R.drawable.ic_launcher));
		StudentList.add(new Student("Gosling", "IC-113", R.drawable.ic_launcher));
		
		myADC = new StudentAdapterClass(MainActivity.this, R.layout.some_layout, StudentList);

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
