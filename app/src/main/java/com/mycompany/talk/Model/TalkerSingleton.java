package com.mycompany.talk.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by joshua on 5/12/2016.
 */

public class TalkerSingleton {

    private ArrayList<Talker> mTalkers;

    private static TalkerSingleton sTalkerSingleton = null;
    private Context mAppContext;

    private TalkerSingleton(Context appContext){
        mAppContext = appContext;
        mTalkers = new ArrayList<Talker>();

    }

    public ArrayList<Talker> getTalkers(){
        return mTalkers;
    }

    ////////////////////////////////////
    public Talker getTalker(UUID id){
        for(Talker c: mTalkers) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
    ////////////////////////////////////

    public static TalkerSingleton get(Context c){
        if(sTalkerSingleton == null){
            sTalkerSingleton = new TalkerSingleton(c.getApplicationContext());
        }
        return sTalkerSingleton;
    }

    public void addTalker(Talker t){
        mTalkers.add(t);
    }

    public void removeTalker(UUID id) {
        for (Talker c : mTalkers) {
            if (c.getId().equals(id))
                mTalkers.remove(c);
        }
    }
}