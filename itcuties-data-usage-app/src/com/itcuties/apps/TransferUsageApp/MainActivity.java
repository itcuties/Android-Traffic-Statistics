package com.itcuties.apps.TransferUsageApp;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ListActivity;
import android.net.TrafficStats;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.itcuties.apps.TransferUsageApp.adapters.ListAdapter;

public class MainActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get running processes
		ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> runningProcesses = manager.getRunningAppProcesses();
		if (runningProcesses != null && runningProcesses.size() > 0) {
			// Set data to the list adapter
			setListAdapter(new ListAdapter(this, runningProcesses));
		} else {
			// In case there are no processes running (not a chance :))
			Toast.makeText(getApplicationContext(), "No application is running", Toast.LENGTH_LONG).show();
		}

	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		long send 		= 0;
		long recived 	= 0;
		// Get UID of the selected process
		int uid = ((RunningAppProcessInfo)getListAdapter().getItem(position)).uid;
		
		// Get traffic data
		recived = TrafficStats.getUidRxBytes(uid);
		send = TrafficStats.getUidTxBytes(uid);
		
		// Display data
		Toast.makeText(getApplicationContext(), "UID " + uid + " details...\n send: " + send/1000 + "kB" + " \n recived: " + recived/1000 + "kB", Toast.LENGTH_LONG).show();
	}

}
