package com.example.customlistviewexample;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentAdapterClass extends ArrayAdapter<Student> {

	private Context mContext;
	private LayoutInflater myInflater;

	public StudentAdapterClass(Context context, int textViewResourceId,
			ArrayList<Student> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this.mContext = context;

	}

	@Override
	public Student getItem(int position) {
		// TODO Auto-generated method stub
		return super.getItem(position);
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		final ViewHolder holder;

		if (convertView == null) {

			holder = new ViewHolder();
			myInflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = myInflater.inflate(R.layout.some_layout, null);

			holder.studentImage = (ImageView) convertView
					.findViewById(R.id.imgStudent);
			holder.studentName = (TextView) convertView
					.findViewById(R.id.tvStudentName);
			holder.studentRollNo = (TextView) convertView
					.findViewById(R.id.tvRollNo);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (getItem(position) != null) {

			holder.studentName.setText(getItem(position).getStudentName());
			holder.studentRollNo.setText(getItem(position).getStudentRollNo());
			holder.studentImage.setImageResource(getItem(position)
					.getStudentImage());
		}
		return convertView;
	}

	public class ViewHolder {
		public ImageView studentImage;
		public TextView studentName;
		public TextView studentRollNo;
	}

	public void customDestory() {
		mContext = null;
		myInflater = null;
	}

}
