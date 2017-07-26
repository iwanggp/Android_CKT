package com.ckt.wgp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ckt.utils.CrimeFragment;
import com.ckt.utils.SingleFragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {


	@Override
	protected Fragment createFragment() {
		return new CrimeFragment();
	}
}
