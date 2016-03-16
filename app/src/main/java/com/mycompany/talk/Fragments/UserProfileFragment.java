package com.mycompany.talk.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mycompany.talk.Login;
import com.mycompany.talk.R;

/**
 * Created by joshua on 3/16/2016.
 */
public class UserProfileFragment extends Fragment {

    Button logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_user_profile,container,false);

        logout = (Button)v.findViewById(R.id.bLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Login.class);
                startActivity(i);
            }
        });

        return v;
    }
}
