package com.ckt.wgp;

import android.support.v4.app.Fragment;

import com.ckt.utils.CrimeListFragment;
import com.ckt.utils.SingleFragmentActivity;

/**
 * Created by D22391 on 2017/7/26.
 */

public class CrimeListActivity extends SingleFragmentActivity {
	@Override
	protected Fragment createFragment() {
		return new CrimeListFragment();
	}
}
