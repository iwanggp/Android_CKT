package com.ckt.wgp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private static final String TAG = "MainActivity";
	private TextView mQuestionTextView;
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private Button mmNextButton;
	private Question[] mQuestionsBanks = new Question[]{
			new Question(R.string.question_australia, true),
			new Question(R.string.question_oceans, true),
			new Question(R.string.question_mideast, false),
			new Question(R.string.question_africa, false),
			new Question(R.string.question_americas, true),
			new Question(R.string.question_asia, true),
	};
	private int mCurrentIndex = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//设置布局
		mQuestionTextView = (TextView) findViewById(R.id.tv_notice);
		mmNextButton = (Button) findViewById(R.id.bt4);
		mmNextButton.setOnClickListener(this);
		mNextButton = (Button) findViewById(R.id.bt3);
		mNextButton.setOnClickListener(this);
		mTrueButton = (Button) findViewById(R.id.bt1);
		mTrueButton.setOnClickListener(this);
		mFalseButton = (Button) findViewById(R.id.bt2);
		mFalseButton.setOnClickListener(this);
		Log.d(TAG, "onCreate() is run ....");

	}

	@Override
	public void onClick(View view) {
		int mView = view.getId();
		switch (mView) {
			case R.id.bt1:
				checkAnswer(true);
				break;
			case R.id.bt2:
				checkAnswer(false);
				break;
			case R.id.bt3:
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionsBanks.length;
				updateQuestion();
				break;
			case R.id.bt4:
				Intent intent = new Intent(this, NextActivity.class);
				startActivity(intent);
				break;
			default:
				break;//必须添加break
		}
	}

	private void updateQuestion() {
		int question = mQuestionsBanks[mCurrentIndex].getTextResId();
		mQuestionTextView.setText(question);
	}

	//增加验证答案是否正确的方法
	private void checkAnswer(boolean userPressedTrue) {
		boolean answerIsTrue = mQuestionsBanks[mCurrentIndex].isAnswerTrue();
		int messageId = 0;
		if (userPressedTrue == answerIsTrue) {
			messageId = R.string.correct_message;
		} else
			messageId = R.string.error_message;
		Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onStart() {
		super.onStart();//调用onStart()方法
		Log.d(TAG, "onStart() is run ....");
	}

	@Override
	protected void onResume() {
		super.onResume();//调用onResume()方法
		Log.d(TAG, "onResume() is run ......");

	}

	@Override
	protected void onPause() {
		super.onPause();//调用onPause()方法
		Log.d(TAG, "onPause() is run ......");
	}

	@Override
	protected void onStop() {
		super.onStop();//调用onStop()方法
		Log.d(TAG, "onStop() is run .....");
	}

	@Override
	protected void onRestart() {
		super.onRestart();//调用onRestart()方法
		Log.d(TAG, "onRestart() is run ....");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy() is run...");
	}
}
