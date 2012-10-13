package com.itcuties.apps.TransferUsageApp.adapters;

import java.util.List;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.itcuties.apps.TransferUsageApp.R;

public class ListAdapter extends ArrayAdapter<RunningAppProcessInfo> {
	// List context
	private final Context context;
	// List values
	private final List<RunningAppProcessInfo> values;

	public ListAdapter(Context context, List<RunningAppProcessInfo> values) {
		super(context, R.layout.main, values);
		this.context = context;
		this.values = values;
	}

	
	/**
	 * Constructing list element view
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.main, parent, false);
		
		TextView appName = (TextView) rowView.findViewById(R.id.appNameText);
		appName.setText(values.get(position).processName);
		
		return rowView;
	}
	
	
}
