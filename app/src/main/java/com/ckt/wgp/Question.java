package com.ckt.wgp;

/**
 * Created by D22391 on 2017/7/24.
 * 定义的问题类，是MVC的model模型。主要用于问题的业务逻辑处理
 */

public class Question {
	private int mTextResId;
	private boolean mAnswerTrue;

	public Question(int mTextResId, boolean mAnswerTrue) {
		this.mTextResId = mTextResId;
		this.mAnswerTrue = mAnswerTrue;
	}

	public int getTextResId() {
		return mTextResId;
	}

	public void setTextResId(int textResId) {
		mTextResId = textResId;
	}

	public boolean isAnswerTrue() {
		return mAnswerTrue;
	}

	public void setAnswerTrue(boolean answerTrue) {
		mAnswerTrue = answerTrue;
	}
}
