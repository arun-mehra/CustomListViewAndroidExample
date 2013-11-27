package com.example.customlistviewexample;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentAdapterClass extends ArrayAdapter<Student> {

	private Context mContext;
	private ArrayList<Student> StudentObjects;

	public StudentAdapterClass(Context context, int textViewResourceId,
			ArrayList<Student> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.StudentObjects = objects;

	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;

		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.some_layout, null);
		}

		Student i = StudentObjects.get(position);

		if (i != null) {

			TextView StudentName = (TextView) v
					.findViewById(R.id.tvStudentName);
			TextView StudentRollNo = (TextView) v.findViewById(R.id.tvRollNo);
			ImageView StudentImage = (ImageView) v
					.findViewById(R.id.imgStudent);

			if (StudentName != null) {
				StudentName.setText(i.getStudentName());
			}
			if (StudentRollNo != null) {
				StudentRollNo.setText(i.getStudentRollNo());
			}
			if (StudentImage != null) {
				StudentImage.setImageResource(i.getStudentImage());
			}
		}

		return v;

	}

}
