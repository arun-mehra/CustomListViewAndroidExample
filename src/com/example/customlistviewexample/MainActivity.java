package com.example.customlistviewexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	// String array to store
	// the name of the students
	private String[] StudentName;

	// String array to store
	// the roll no of students
	private String[] StudentRollNo;

	// bitmap array to get the
	// bitmaps of the images
	private Bitmap[] bitmap;

	// integer array to
	// store images
	private int[] StudentImage = { R.drawable.ic_launcher, R.drawable.android,
			R.drawable.cup, R.drawable.donut, R.drawable.eclair,
			R.drawable.froyo, R.drawable.ginger, R.drawable.honey,
			R.drawable.ics, R.drawable.java, R.drawable.jellybean,
			R.drawable.kitkat };

	//Adapter variables
	private StudentAdapterClass myADC;
	
	//progressbar variable
	private ProgressBar myPB;
	
	//list view variable
	private ListView myListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myListView = (ListView) findViewById(R.id.lvStudent);

		myPB = (ProgressBar) findViewById(R.id.progressBar1);
		myPB.setVisibility(View.VISIBLE);

		Thread t = new Thread(StudentRunnable);
		t.start();
		
		//initializing the bitmap array and
		//resizing the images 

		bitmap = new Bitmap[StudentImage.length + 1];

		for (int i = 0; i < 12; i++) {
			bitmap[i] = BitmapFactory.decodeResource(getResources(),
					StudentImage[i]);
			bitmap[i] = Bitmap.createScaledBitmap(bitmap[i], 80, 80, false);
		}
	}

	private Runnable StudentRunnable = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub

			
			//generating 100 student names and roll numbers
			StudentName = new String[100];
			StudentRollNo = new String[100];

			for (int i = 0; i < 100; i++) {
				try {
					StudentName[i] = RandomStringGenerator
							.generateRandomString(10,
									RandomStringGenerator.Mode.ALPHANUMERIC);
					StudentRollNo[i] = RandomStringGenerator
							.generateRandomString(10,
									RandomStringGenerator.Mode.ALPHANUMERIC);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					myPB.setVisibility(View.INVISIBLE);
					myADC = new StudentAdapterClass(MainActivity.this,
							StudentName, StudentRollNo, bitmap);

					if (myADC.isEmpty()) {
						Toast.makeText(MainActivity.this, "No Data to Display",
								3).show();
					} else {
						myListView.setAdapter(myADC);
					}
				}
			});
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
