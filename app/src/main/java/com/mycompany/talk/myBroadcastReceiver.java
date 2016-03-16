package com.mycompany.talk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by joshua on 1/13/2016.
 */
public class myBroadcastReceiver extends BroadcastReceiver {

     WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    private MainAppActivity mActivity;
   // private WifiP2pManager.PeerListListener mPeerListListener;
    private List peers = new ArrayList();
/*
    private WifiP2pManager.PeerListListener mPeerListListener = new WifiP2pManager.PeerListListener() {
        @Override
        public void onPeersAvailable(WifiP2pDeviceList peerList) {
            peers.clear();
            peers.addAll(peerList.getDeviceList());
            Log.e("myPeerList", "Peer count = " + peers.size());
            if(peers.size() == 0){
                Log.d("myPeersize", "No devices found.");

            }
        }
    };
    */
    public myBroadcastReceiver(WifiP2pManager manager, WifiP2pManager.Channel channel, MainAppActivity activity) {
        this.mManager = manager;
        this.mChannel = channel;
        this.mActivity = activity;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

            Log.e("onReceive","onReceive method called!!!!!");
        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if(state == WifiP2pManager.WIFI_P2P_STATE_ENABLED){
                Log.e("myWIFI","Wifi p2p is enabled");
            }
            else if(state == WifiP2pManager.WIFI_P2P_STATE_DISABLED){
                Log.e("myWIFI", "Wifi p2p is not enabled");
            }
            // Check to see if Wi-Fi is enabled and notify appropriate activity
        }

        else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            if(mManager != null) {


                mManager.requestPeers(mChannel, new WifiP2pManager.PeerListListener() {
                    @Override
                    public void onPeersAvailable(WifiP2pDeviceList peerList) {
                        Log.e("myonPeersAvailable","onPeersAvailable called");

                        peers.clear();
                        peers.addAll(peerList.getDeviceList());
                        Log.e("myPeerList", "Peer count = " + peers.size());
                        if (peers.size() == 0) {
                            Log.d("myPeersize", "No devices found.");
                        }
                    }

                });
                    Log.e("myrequestPeers", "requestPeers called");
            }
                        // Call WifiP2pManager.requestPeers() to get a list of current peers
            }
        else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            // Respond to new connection or disconnections
            //May need to updateUi after establishing new connections

        }
        else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
        }
    }
}

