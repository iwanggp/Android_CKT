package com.ckt.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ckt.domain.Crime;
import com.ckt.wgp.R;

import java.util.List;

/**
 * Created by D22391 on 2017/7/26.
 */
public class CrimeListFragment extends Fragment {
	private RecyclerView mCrimeRecyclerView;
	private CrimeAdapter mCrimeAdapter;
	private static final String TAG = "CrimeListFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
		mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
		mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		updateUI();
		return view;
	}

	private void updateUI() {
		CrimeLab crimeLab = CrimeLab.get(getActivity());
		List<Crime> crimes = crimeLab.getCrimes();
		Log.d(TAG, crimes.size() + "-----");
		mCrimeAdapter = new CrimeAdapter(crimes);
		mCrimeRecyclerView.setAdapter(mCrimeAdapter);
//		mCrimeRecyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
	}


	//定义ViewHolder以便使用RecyclerView
	private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		private TextView mTitleTextView;
		private TextView mDataTextView;
		private Crime mCrime;

		public CrimeHolder(View view) {
			super(view);
			mTitleTextView = (TextView) view.findViewById(R.id.crime_title);
			mDataTextView = (TextView) view.findViewById(R.id.crime_date);
			itemView.setOnClickListener(this);
		}

		public void bind(Crime crime) {
			mCrime = crime;
			mTitleTextView.setText(crime.getTitle());
			mDataTextView.setText(crime.getDate().toString());
		}

		@Override
		public void onClick(View view) {
			Toast.makeText(getActivity(), mCrime.getTitle() + "clicked", Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * 继承了RecyclerView.Adapter必须实现三个方法
	 * getItemCount返回数据的总数
	 * onCreateViewHolder 就是创建ViewHolder这个方法实际上调用的不多，当ViewHolder够用，就不在增加了
	 * onBindViewHolder 顾名思义就是数据绑定的作用
	 */
	private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
		private List<Crime> mCrimes;

		public CrimeAdapter(List<Crime> crimes) {
			mCrimes = crimes;
		}

		@Override
		public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
			View view = layoutInflater.inflate(R.layout.list_item_crime, parent, false);
			CrimeHolder holder = new CrimeHolder(view);
			return holder;
//			return new CrimeHolder(layoutInflater, parent);
		}

		@Override
		public void onBindViewHolder(CrimeHolder holder, int position) {
			Crime crime = mCrimes.get(position);
			holder.bind(crime);
		}

		@Override
		public int getItemCount() {
			return mCrimes.size();
		}
	}

}
