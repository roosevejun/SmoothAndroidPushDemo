package com.baidu.push.example.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import com.baidu.push.example.R;
import com.baidu.push.example.bean.Jackson2HttpMessageConverterConfig;
import com.baidu.push.example.bean.Terminal;
import com.baidu.push.example.utils.DeviceInformation;

import org.springframework.web.client.RestTemplate;
import roboguice.inject.InjectResource;
import roboguice.util.RoboAsyncTask;

import java.util.Map;


/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/26 0026 16:07
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class DeviceInformationTask extends RoboAsyncTask<Terminal> {
    private TelephonyManager telephonyManager;
    private Terminal terminal;
    private Jackson2HttpMessageConverterConfig converterConfig;
    @InjectResource(R.string.updateDeviceInformationTaskUrl)
    public String initializeUrl;
    private SharedPreferences perferences;

    public DeviceInformationTask(Context context, TelephonyManager telephonyManager) {
        super(context);
        this.telephonyManager = telephonyManager;
    }

    @Override
    protected void onPreExecute() {
        converterConfig = new Jackson2HttpMessageConverterConfig();
        terminal = DeviceInformation.getTerminalInformation(telephonyManager);
        perferences = context.getSharedPreferences("com.baidu.push.mobileInfo", context.MODE_PRIVATE);
    }

    @Override
    public Terminal call() throws Exception {
        String id = perferences.getString("id", "");
        if (id == null || id.trim().length() == 0) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(converterConfig.getConverter());
            restTemplate.getMessageConverters().add(converterConfig.getStringHttpMessageConverter());
            terminal = restTemplate.postForObject(initializeUrl + terminal.getImei(), terminal, Terminal.class);
        }
        return terminal;
    }

    @Override
    protected void onSuccess(Terminal result) {
        // do this in the UI thread if call() succeeds
        if (result != null && result.getId() != null) {
            SharedPreferences.Editor editor = perferences.edit();
            Map<String, String> objectAsMap = converterConfig.getMapper().convertValue(result, Map.class);
            for (Map.Entry<String, String> entry : objectAsMap.entrySet()) {
                editor.putString(entry.getKey(), entry.getValue());
            }
            editor.commit();
        }
//        EventBus.getDefault().post(new InitializeAppEndEvent(result.getSecretkey(), result.getApikey()));
    }


}
