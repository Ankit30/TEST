package com.mmx.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mBtnPlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainactivity_screen);
		mBtnPlay = (Button)findViewById(R.id.btn_play);
		mBtnPlay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent newpage = new Intent(MainActivity.this, PlayGameActivity.class);
				startActivity(newpage);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() {
		empty();
		super.onDestroy();
	}
	
	private void empty() {
		mBtnPlay = null;
		System.gc();
	}

}
