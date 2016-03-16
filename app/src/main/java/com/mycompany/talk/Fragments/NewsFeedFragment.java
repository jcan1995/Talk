package com.mycompany.talk.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mycompany.talk.R;
import com.mycompany.talk.Talker;
import com.mycompany.talk.TalkerSingleton;

import java.util.ArrayList;

/**
 * Created by joshua on 12/28/2015.
 */
public class NewsFeedFragment extends ListFragment {

    private ArrayList<Talker> mTalkers;

    @Override
    public void onResume(){
        super.onResume();
        ((TalkerAdapter)getListAdapter()).notifyDataSetChanged();

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mTalkers = TalkerSingleton.get(getActivity()).getTalkers();
        TalkerAdapter adapter = new TalkerAdapter(mTalkers);
        setListAdapter(adapter);

    }

    private class TalkerAdapter extends ArrayAdapter<Talker>{

        public TalkerAdapter(ArrayList<Talker> talker){
            super(getActivity(),0,talker);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_newsfeed,null);
            }

            Talker t = getItem(position);

            TextView tUserName = (TextView)convertView.findViewById(R.id.text_userName);
            tUserName.setText(t.getUserName());

            TextView tAge = (TextView)convertView.findViewById(R.id.text_age);
            tAge.setText(t.getAge());

            TextView tGender = (TextView)convertView.findViewById(R.id.text_gender);
            tGender.setText(t.getGender());

            TextView tEmail = (TextView)convertView.findViewById(R.id.text_email);
            tEmail.setText(t.getEmail());

            return convertView;
        }


    }

}
