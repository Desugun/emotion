package com.example.nurseproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.*;

public class add extends Activity {
	EditText addedit;
	Button sure;
	RadioButton a,b,c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		addedit=(EditText) findViewById(R.id.editText1);
	    sure=(Button) findViewById(R.id.button1);
	    a=(RadioButton) findViewById(R.id.radioButton1);
	    b=(RadioButton) findViewById(R.id.radioButton2);
	    c=(RadioButton) findViewById(R.id.radioButton3);
	    sure.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
		   		on_Previous();			
			}  
	    });
	}
	void on_Previous(){
		Bundle bundle=new Bundle();
		String addString = addedit.getText().toString();
		bundle.putString("addstring", addString);
		
		if(a.isChecked()){
			bundle.putString("color", "r");
		}else if(b.isChecked()){
			bundle.putString("color", "g");
		}else if(c.isChecked()){
			bundle.putString("color", "y");
		}
		add.this.setResult(RESULT_CANCELED,add.this.getIntent().putExtras(bundle));
		add.this.finish();
	}
}
