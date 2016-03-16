package com.mycompany.talk;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by joshua on 2/22/2016.
 */
public class TalkerSingleton {

    private ArrayList<Talker> mTalkers;

    private static TalkerSingleton sTalkerSingleton = null;
    private Context mAppContext;

    private TalkerSingleton(Context appContext){
        mAppContext = appContext;
        mTalkers = new ArrayList<Talker>();
        //Add talkers???
    }

    public ArrayList<Talker> getTalkers(){
        return mTalkers;
    }

    public Talker getTalker(UUID id){
        for(Talker c: mTalkers) {
            if (c.getId().equals(id))
                return c;
            }
        return null;
        }
    public static TalkerSingleton get(Context c){
        if(sTalkerSingleton == null){
            sTalkerSingleton = new TalkerSingleton(c.getApplicationContext());
        }
        return sTalkerSingleton;
    }

    public void addTalker(Talker t){
        mTalkers.add(t);
    }

    public void removeTalker(Talker t){
        mTalkers.remove(t);

    }
}


