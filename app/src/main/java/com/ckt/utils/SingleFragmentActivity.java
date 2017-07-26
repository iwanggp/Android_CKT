package com.ckt.utils;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ckt.wgp.R;

/**
 * Created by D22391 on 2017/7/26.
 * 定义一个抽象的SingleFragmentActivity类，提高了代码的复用性
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
	protected abstract Fragment createFragment();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		FragmentManager fm=getSupportFragmentManager();
		Fragment fragment=fm.findFragmentById(R.id.fragment_container);//从定义的布局中找到容器标签
		if(fragment==null){
			fragment=createFragment();
			fm.beginTransaction().add(R.id.fragment_container,fragment).commit();//将fragment添加到容器中
		}
	}
}
