package com.example.calldriver;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ClientActivity extends ActionBarActivity {
	 ActionBar.Tab historyTab, callTab;
	 
	 Fragment historyFragmentTab = new HistoryFragmentTab();
	 Fragment callFragmentTab = new CallFragmentTab();
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_client);
		ActionBar actionBar = getActionBar();
		actionBar.setStackedBackgroundDrawable(getResources().getDrawable(R.drawable.Tab_Yellow));
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		callTab=actionBar.newTab().setText("©I¥s").setIcon(R.drawable.ic_action_call);
		historyTab=actionBar.newTab().setText("¾ú¥v").setIcon(R.drawable.ic_action_paste);
		
		callTab.setTabListener(new TabListener(callFragmentTab) );
		historyTab.setTabListener(new TabListener(historyFragmentTab));
		actionBar.addTab(callTab);
		actionBar.addTab(historyTab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.client, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
