package com.example.calldriver;

import java.io.File;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DriverActivity extends ActionBarActivity {
	
	TextView tv1;
	TextView tv2;
	TextView tv3;
	TextView tv4;
	Uri uri = null;
	ImageView image;
	private File tempFile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_driver);	
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		image = (ImageView)findViewById(R.id.driver_imageView1);
		
		// �P�_���L�Ӥ�
		
		tempFile = new File(Environment.getExternalStorageDirectory(),"calldriver_photo.jpg");
		if(tempFile.exists()==true){
			image.setImageURI(Uri.fromFile(tempFile));
		}
		
		//���L���
		tv1 = (TextView) findViewById(R.id.driver_tv1);
		tv2 = (TextView) findViewById(R.id.driver_tv2);
		tv3 = (TextView) findViewById(R.id.driver_tv3);
		tv4 = (TextView) findViewById(R.id.driver_tv4);
		SharedPreferences preferences = getSharedPreferences("PREF_Driver-setting", MODE_PRIVATE);
		String pref_name = preferences.getString("pref_name","" );
		String pref_phone= preferences.getString("pref_phone", "");
		String pref_carID = preferences.getString("pref_carID", "");
		String pref_model = preferences.getString("pref_model", "");
		
		tv1.setText(pref_name);
		tv2.setText(pref_phone);
		tv3.setText(pref_carID);
		tv4.setText(pref_model);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.driver, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id){
			case R.id.driver_datasetting:
				Intent intent = new Intent();
				intent.setClass(DriverActivity.this, Driver_setingActivity.class);
				startActivity(intent);
				break;
			case R.id.driver_photosetting:
				crop();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	private void crop(){
		
		Intent intent = new Intent();

		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 4);
		intent.putExtra("aspectY", 3);
		intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(tempFile));
		intent.putExtra("outputFormat", "JPEG");
		startActivityForResult(Intent.createChooser(intent, "��ܹϤ�"),1);
		
	}
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {

		super.onActivityResult(arg0, arg1, arg2);
		image = (ImageView)findViewById(R.id.driver_imageView1);
		
		if(arg1 == RESULT_OK){
			image.setImageURI(Uri.fromFile(tempFile));
		}
		
	}
	
	
}
