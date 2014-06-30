package com.baidu.push.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;


import com.baidu.frontia.FrontiaApplication;
import com.baidu.push.example.network.NetworkStateReceiver;


/*
 * 如果您的工程中实现了Application的继承类，那么，您需要将父类改为com.baidu.frontia.FrontiaApplication。
 * 如果您没有实现Application的继承类，那么，请在AndroidManifest.xml的Application标签中增加属性： 
 * <application android:name="com.baidu.frontia.FrontiaApplication"
 * 。。。
 */
public class DemoApplication extends FrontiaApplication {
    private static final String LOG_TAG = DemoApplication.class.getSimpleName();
    public BroadcastReceiver connectivityReceiver;
    private IntentFilter mNetworkStateChangedFilter;

    @Override
    public void onCreate() {
        super.onCreate();
        connectivityReceiver = new NetworkStateReceiver();
        mNetworkStateChangedFilter = new IntentFilter();
        mNetworkStateChangedFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityReceiver, mNetworkStateChangedFilter);
    }
}
