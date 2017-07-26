package com.ckt.wgp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityLifeDemo extends AppCompatActivity implements View.OnClickListener {
	private static final String TAG = "ActivityLifeDemo";
	private TextView mTextView1;
	private TextView mTextView2;
	private Button mButton1;
	private Button mButton2;
	private Intent mIntent;
	private int requestCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		mTextView1 = (TextView) findViewById(R.id.tv1);
		mTextView2 = (TextView) findViewById(R.id.tv2);
		mButton1 = (Button) findViewById(R.id.bt1);
		mButton2 = (Button) findViewById(R.id.bt2);
		mButton1.setOnClickListener(this);
		mButton2.setOnClickListener(this);
		mIntent = new Intent();
		mIntent.setClass(ActivityLifeDemo.this, ActivityForResult.class);
	}


	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.bt1:
				requestCode = 100;//定义的请求码
				startActivityForResult(mIntent, requestCode);//获取第二个Activity的值，需要重写这个方法
				break;
			case R.id.bt2:
				requestCode = 200;
				startActivityForResult(mIntent, requestCode);
				break;
			default:
				break;
		}
	}

	/**
	 * 重写这个方法来获得返回的值
	 * @param requestCode
	 * @param resultCode
	 * @param data
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		String change01 = data.getStringExtra("change01");
		String change02 = data.getStringExtra("change02");
		switch (requestCode) {
			case 100:
				mTextView1.setText(change01);
				break;
			case 200:
				mTextView2.setText(change02);
				break;
			default:
				break;
		}
	}
}
