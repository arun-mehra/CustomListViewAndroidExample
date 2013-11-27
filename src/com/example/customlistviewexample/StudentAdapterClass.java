package com.example.customlistviewexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentAdapterClass extends BaseAdapter {
	private Context mContext;
	private String[] StudentName;
	private String[] StudentRollNo;
	private LayoutInflater myInflater;
	private Bitmap[] bitmap;

	public StudentAdapterClass(Context conx, String[] StudentName,
			String[] StudentRollNo, Bitmap[] StudentImage) {
		this.mContext = conx;
		this.StudentName = StudentName;
		this.StudentRollNo = StudentRollNo;
		this.bitmap = StudentImage;
	}

	public int getCount() {
		if (StudentRollNo.length != 0) {
			return StudentRollNo.length;
		} else {
			return 0;
		}
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;

		if (convertView == null) {

			holder = new ViewHolder();
			myInflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = myInflater.inflate(R.layout.some_layout, null);

			holder.StudentImage = (ImageView) convertView
					.findViewById(R.id.imgStudent);
			holder.StudentName = (TextView) convertView
					.findViewById(R.id.tvStudentName);
			holder.StudentRollNo = (TextView) convertView
					.findViewById(R.id.tvRollNo);

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (StudentRollNo != null && StudentRollNo[position] != null) {

			holder.StudentName.setText(StudentName[position]);
			holder.StudentRollNo.setText(StudentRollNo[position]);
			if (position <= 11) {
				holder.StudentImage.setImageBitmap(bitmap[position]);

			} else {
				holder.StudentImage.setImageResource(R.drawable.ic_launcher);
			}
		}
		return convertView;
	}

	public class ViewHolder {
		public ImageView StudentImage;
		public TextView StudentName;
		public TextView StudentRollNo;

	}

	public void CustomDestoryAdapter() {
		myInflater = null;
		mContext = null;
	}

}
