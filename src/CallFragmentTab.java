package com.example.calldriver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Fragment;
import android.content.Intent;
public class CallFragmentTab extends Fragment {
    private ListView listView ;
    private String[] list = {"driver1","driver2","driver3","driver4","driver5","driver6","driver7","driver8","driver9","driver10"};
    private ArrayAdapter<String> listAdapter;
    private View v;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    		
		v = inflater.inflate(R.layout.activity_clientcall, container, false);
	    listView = (ListView)v.findViewById(R.id.clientcalllist);
	    listAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
	    listView.setAdapter(listAdapter);
	        
	    	listView.setOnItemClickListener( new ListView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO 自動產生的方法 Stub
					Intent intent =new Intent();
					intent.setClass(getActivity(),DriverShowActivity.class);
					intent.putExtra("drivername",listAdapter.getItem(position).toString());
					startActivity(intent);
				}
	    			
			});
	        
	    return v;
    }
    

}
