package com.cleartrip.bmtc;

import java.io.File;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayPassActivity extends Activity {
	
	private ImageView picture,  passTypePicture;
	private TextView name;
	private TextView validityString;
	private TextView passType, authKey, authValue, ticketNumber;
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_pass);
		picture = (ImageView) findViewById(R.id.profilePicture);
		name = (TextView) findViewById(R.id.NameOnCard);
		passType = (TextView)findViewById(R.id.passDescription);
		authValue = (TextView)findViewById(R.id.authValue);
		ticketNumber = (TextView)findViewById(R.id.ticketNumber);
		validityString = (TextView) findViewById(R.id.validString);
		validityString.setText("Nov 1, 2014  to Nov 31, 2014");
		
		getActionBar().hide();
		
		authValue.setText("127790");
		ticketNumber.setText("CLMT111400123");
		File file = new File(Environment.getExternalStorageDirectory(),"temporary_holder.jpg");
		decodeFile(file.getAbsolutePath());
		
		if (getIntent() != null && getIntent().getExtras() != null) {
			name.setText(getIntent().getStringExtra("name"));
			String type = getIntent().getStringExtra("passType");
			if(type!=null){
				switch (type){
				case "1":
					//passTypePicture.setImageResource(R.drawable.vajraservices);
					passType.setText("Vajra A/c Bus Pass");
					break;
				}
			}
		}
		
	}
	
	public void decodeFile(String filePath) {
		BitmapFactory.Options o = new BitmapFactory.Options();
		o.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, o);
		int scale = 1;
		BitmapFactory.Options o2 = new BitmapFactory.Options();
		o2.inSampleSize = scale;
		Bitmap bitmap = BitmapFactory.decodeFile(filePath, o2);
		picture.setImageBitmap(bitmap);

	}
	

}
