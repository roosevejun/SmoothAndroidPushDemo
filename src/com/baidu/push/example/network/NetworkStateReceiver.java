package com.baidu.push.example.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.baidu.push.example.event.NetworkStateEvent;
import de.greenrobot.event.EventBus;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/28 0028 10:47
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class NetworkStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context ctx, Intent intent) {
        Log.i(LOG_TAG, "Action: " + intent.getAction());
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            NetworkInfo info = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            String typeName = info.getTypeName();
            String subtypeName = info.getSubtypeName();
            boolean available = info.isAvailable();
//            Log.i(LOG_TAG, "Network Type: " + typeName
//                    + ", subtype: " + subtypeName
//                    + ", available: " + available);
            EventBus.getDefault().post(new NetworkStateEvent(typeName, subtypeName, available));
        }
    }

    private static final String LOG_TAG = NetworkStateReceiver.class.getSimpleName();
}
