package com.mycompany.talk.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mycompany.talk.Login;
import com.mycompany.talk.Model.Talker;
import com.mycompany.talk.R;

import java.util.ArrayList;

/**
 * Created by joshua on 3/16/2016.
 */
public class UserProfileFragment extends Fragment {
//This is a comment
    private TextView UserName;

    private Button logout;
    private Button bChat;
    private ArrayList<Talker> talkers;
    private Talker t;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_user_profile,container,false);

        UserName = (TextView)v.findViewById(R.id.tvUserName);


        logout = (Button)v.findViewById(R.id.bLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Login.class);
                startActivity(i);
            }
        });

        bChat = (Button)v.findViewById(R.id.bChat);
        bChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return v;
    }
}
