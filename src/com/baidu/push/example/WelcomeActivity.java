package com.baidu.push.example;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.push.example.event.BaiduPushBindEvent;
import com.baidu.push.example.event.InitializeAppEndEvent;
import com.baidu.push.example.event.NetworkStateEvent;
import com.baidu.push.example.event.UserLoginEvent;
import com.baidu.push.example.listener.UserLoginListener;
import com.baidu.push.example.network.NetworkStateReceiver;
import com.baidu.push.example.task.BaiduPushBindSucessTask;
import com.baidu.push.example.task.DeviceInformationTask;
import com.baidu.push.example.task.InitializeAppTask;
import de.greenrobot.event.EventBus;
import roboguice.activity.RoboActivity;
import roboguice.event.EventManager;
import roboguice.event.Observes;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import com.google.inject.Inject;


/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/19 0019 14:54
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@ContentView(R.layout.activity_welcome)
public class WelcomeActivity extends RoboActivity {
    @Inject
    protected EventManager eventManager;
    @Inject
    protected UserLoginListener userLoginListener;

    @InjectView(R.id.image_btn_login_confirm)
    ImageButton loginBtn = null;
    @InjectView(R.id.usernameeditText)
    TextView loginName = null;
    @InjectView(R.id.userpasseditText)
    TextView loginPass = null;
    private static final String LOG_TAG = WelcomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        loginBtn.setEnabled(false);
        loginBtn.setOnClickListener(LoginViewListener);
    }

    private View.OnClickListener LoginViewListener = new View.OnClickListener() {
        public void onClick(View v) {
            eventManager.fire(new UserLoginEvent(loginName.getText().toString(), loginPass.getText().toString()));
        }
    };

    protected void handleEvent(@Observes UserLoginEvent event) {
        Toast.makeText(this, "Custom event",
                Toast.LENGTH_LONG).show();
    }

    public void onEventBackgroundThread(InitializeAppEndEvent event) {
        PushManager.startWork(getApplicationContext(),
                PushConstants.LOGIN_TYPE_API_KEY, event.getApikey());
    }

    public void onEventBackgroundThread(BaiduPushBindEvent event) {
        new BaiduPushBindSucessTask(this.getApplicationContext(), event).execute();
    }

    public void onEventMainThread(InitializeAppEndEvent event) {
        loginBtn.setEnabled(true);
    }

    public void onEventMainThread(NetworkStateEvent event) {
        Log.i(LOG_TAG, "Network Type: " + event.getmTypeName()
                + ", subtype: " + event.getmSubtypeName()
                + ", available: " + event.ismAvailable());
        Toast.makeText(this, "网络状态:" + event.ismAvailable() + "\t" + event.getmTypeName(),
                Toast.LENGTH_LONG).show();
    }
    public void onEventBackgroundThread(NetworkStateEvent event) {
        Log.i(LOG_TAG, "Network Type: " + event.getmTypeName()
                + ", subtype: " + event.getmSubtypeName()
                + ", available: " + event.ismAvailable());
        /**
         * 判断当前设备是否有网络条件，在有网络条件的基础完成设备信息端注册
         */
        if (event.ismAvailable()) {
            new DeviceInformationTask(this.getApplicationContext(), (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)).execute();
            new InitializeAppTask(this.getApplicationContext()).execute();
        }
    }

}
