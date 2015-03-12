package com.example.nurseproject;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.format.Time;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.*;


public class MainActivity extends Activity {
   protected static final int CALL_REQUEST = 0;
   Time t=new Time();
   String or="";
Button insert,update,delete;
EditText show;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		insert=(Button) findViewById(R.id.button1);
		update=(Button) findViewById(R.id.button2);
		delete=(Button) findViewById(R.id.button3);
		show=(EditText) findViewById(R.id.editText1);
		
		insert.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent add=new Intent(MainActivity.this,add.class);
				startActivityForResult(add,CALL_REQUEST);
			}
		});
	}
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode==CALL_REQUEST){
    		if(resultCode==RESULT_CANCELED){
    			t.setToNow();
    			String add="";
    			Bundle bundle = data.getExtras();
    			String color=bundle.getString("color").toString();
    			if(color.equals("r")){
    			   add="<font color=\"#f00000\">"+t.year+":"+t.month+":"+t.monthDay+":"+t.hour+":"+t.minute+"->"+bundle.getString("addstring")+"\n</font><br>";
    			}
    			if(color.equals("g")){
    			   add="<font color=\"#66cdaa\">"+t.year+":"+t.month+":"+t.monthDay+":"+t.hour+":"+t.minute+"->"+bundle.getString("addstring")+"\n</font><br>";
    			}
    			if(color.equals("y")){
    			   add="<font color=\"#ffff00\">"+t.year+":"+t.month+":"+t.monthDay+":"+t.hour+":"+t.minute+"->"+bundle.getString("addstring")+"\n</font><br>";
    			}
    				
    		    or=add+or;
    			show.setText(Html.fromHtml(or));
    		}
    	}
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
