package com.ckt.wgp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityForResult extends AppCompatActivity {
	private static final String TAG = "ActivityForResult";
	private EditText et1;
	private EditText et2;
	private Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_for_result);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		bt = (Button) findViewById(R.id.bt);
		final Intent mIntent = new Intent();

		bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String et1Value = et1.getText().toString().trim();
				String et2Value = et2.getText().toString().trim();
				Log.d(TAG, et1Value);
				Log.d(TAG, et2Value);
				mIntent.putExtra("change01", et1Value);
				mIntent.putExtra("change02", et2Value);
				ActivityForResult.this.setResult(RESULT_OK, mIntent);
				ActivityForResult.this.finish();
			}
		});

	}
}
