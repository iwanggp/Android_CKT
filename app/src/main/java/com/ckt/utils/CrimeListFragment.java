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
	}


	//定义ViewHolder以便使用RecyclerView
	private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		private TextView mTitleTextView;
		private TextView mDataTextView;
		private View line;
		private Crime mCrime;

		public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
			super(inflater.inflate(R.layout.list_item_crime, parent, false));
			mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
			mDataTextView = (TextView) itemView.findViewById(R.id.crime_date);
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

	private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
		private List<Crime> mCrimes;

		public CrimeAdapter(List<Crime> crimes) {
			mCrimes = crimes;
		}

		@Override
		public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
			return new CrimeHolder(layoutInflater, parent);
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
