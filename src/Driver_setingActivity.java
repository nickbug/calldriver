package com.example.calldriver;

import android.support.v7.app.ActionBarActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Driver_setingActivity extends ActionBarActivity {
	EditText ed1;
	EditText ed2;
	EditText ed3;
	EditText ed4;
	Button btn;
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dirver_seting);
		
		ed1 = (EditText) findViewById(R.id.driver_setting_editText1);
		ed2 = (EditText) findViewById(R.id.driver_setting_editText2);
		ed3 = (EditText) findViewById(R.id.driver_setting_editText3);
		ed4 = (EditText) findViewById(R.id.driver_setting_editText4);
		
		preferences = getSharedPreferences("PREF_Driver-setting", MODE_PRIVATE);
		editor = preferences.edit();
			
		ed1.setText(preferences.getString("pref_name","" ));
		ed2.setText(preferences.getString("pref_phone", ""));
		ed3.setText(preferences.getString("pref_carID", ""));
		ed4.setText(preferences.getString("pref_model", ""));
		
		btn = (Button) findViewById(R.id.driver_setting_btn1);
		btn.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
				String pref_name = ed1.getText().toString();
				String pref_phone= ed2.getText().toString();
				String pref_carID = ed3.getText().toString();
				String pref_model = ed4.getText().toString();
				if(pref_carID.isEmpty() || pref_model.isEmpty() || pref_name.isEmpty() || pref_phone.isEmpty()){
					Toast.makeText(Driver_setingActivity.this, "������٨S��@~", Toast.LENGTH_SHORT).show();				
				}
				else{
					editor.putString("pref_carID", pref_carID);
					editor.putString("pref_model", pref_model);
					editor.putString("pref_name", pref_name);
					editor.putString("pref_phone", pref_phone);
					editor.commit();
					finish();
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dirver_seting, menu);
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
