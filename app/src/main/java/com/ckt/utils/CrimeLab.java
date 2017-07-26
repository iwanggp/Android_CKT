package com.ckt.utils;

import android.content.Context;

import com.ckt.domain.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by D22391 on 2017/7/26.
 * 创建一个管理Crime类的管理器
 */

public class CrimeLab {
	private static CrimeLab sCrimeLab;//先创建一个单例的CrimeLab
	private List<Crime> mCrimes;

	public static CrimeLab get(Context context) {
		if (sCrimeLab == null) {
			sCrimeLab = new CrimeLab(context);
		}
		return sCrimeLab;
	}

	private CrimeLab(Context context) {
		mCrimes = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Crime crime = new Crime();
			crime.setTitle("Crime#" + i);
			crime.setSolved(i % 2 == 0);
			mCrimes.add(crime);
		}
	}

	public List<Crime> getCrimes() {
		return mCrimes;
	}

	public Crime getCrime(UUID id) {
		for (Crime crime : mCrimes) {
			if (crime.getID().equals(id)) {
				return crime;
			}
		}
		return null;
	}
}
