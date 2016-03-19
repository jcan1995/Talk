package com.mycompany.talk.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.talk.R;
import com.mycompany.talk.Talker;
import com.mycompany.talk.TalkerSingleton;

import java.util.ArrayList;

/**
 * Created by joshua on 12/28/2015.
 */
public class NewsFeedFragment extends ListFragment{

    private ArrayList<Talker> mTalkers;


    @Override
    public void onResume(){//Why "onResume() and not onStart()? Can't assume the activity is going to bne stopped when another ativity is stacked on top of it. The bottom activity may just be paused. OnResujme() is the safest place to update fragment views"
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_newsfeed,parent,false);



    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){//What do we want to happen when we click an item on the List? We want to start a CrimeFragment with the proper data. This is the method we use..
       Talker t = ((TalkerAdapter) getListAdapter()).getItem(position);

       // Intent i = new Intent(getActivity(),UserView.class);
      //  startActivity(i);
    }

    private class TalkerAdapter extends ArrayAdapter<Talker>{

        public TalkerAdapter(ArrayList<Talker> talker){
            super(getActivity(),android.R.layout.simple_list_item_1,talker);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_talker,null);
            }

            Talker t = getItem(position);

            TextView tUserName = (TextView)convertView.findViewById(R.id.text_userName);
            tUserName.setText(t.getUserName());

            TextView tGender = (TextView)convertView.findViewById(R.id.text_gender);
            tGender.setText(t.getGender());

            TextView tAge = (TextView)convertView.findViewById(R.id.text_age);
            tAge.setText(String.valueOf(t.getAge()));

            TextView tEmail = (TextView)convertView.findViewById(R.id.text_email);
            tEmail.setText(t.getEmail());

            return convertView;
        }


    }

}
