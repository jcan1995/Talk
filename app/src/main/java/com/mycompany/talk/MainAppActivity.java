package com.mycompany.talk;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by joshua on 12/28/2015.
 */
public class MainAppActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Adapter adapter;
    ViewPager pager;
    private IntentFilter mIntentFilter;

    private myBroadcastReceiver mReceiver;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
/*
        WifiP2pManager mManager = (WifiP2pManager) this.getSystemService(Context.WIFI_P2P_SERVICE);

        WifiP2pManager.Channel mChannel = mManager.initialize(this, this.getMainLooper(),null);

        mReceiver = new myBroadcastReceiver(mManager,mChannel,this);

        mIntentFilter = new IntentFilter();

        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                Log.e("myonSuccess called", "Found device");
            }

            @Override
            public void onFailure(int i) {
                Log.e("onFailure called", "Found 0 devices");
            }
        });
*/
        adapter = new Adapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.vPager);
        pager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }
        });
    }
    /**********************ACTIVITY OVERRIDE METHODS*************************/

    @Override
    protected void onResume(){
        super.onResume();
      //  registerReceiver(mReceiver,mIntentFilter);
    }

    @Override
    protected void onPause(){
        super.onPause();
      //  unregisterReceiver(mReceiver);
    }

}
