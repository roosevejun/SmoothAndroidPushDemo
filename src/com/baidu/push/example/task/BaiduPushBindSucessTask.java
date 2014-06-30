package com.baidu.push.example.task;

import android.content.Context;
import android.util.Log;
import com.baidu.push.example.R;
import com.baidu.push.example.bean.Appterminal;
import com.baidu.push.example.bean.Jackson2HttpMessageConverterConfig;

import org.springframework.web.client.RestTemplate;
import roboguice.inject.InjectResource;
import roboguice.util.RoboAsyncTask;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/26 0026 14:54
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class BaiduPushBindSucessTask extends RoboAsyncTask<Appterminal> {

    private Appterminal appterminal;
    @InjectResource(R.string.systemBindUrl)
    private String systemBindUrl;
    private Jackson2HttpMessageConverterConfig converterConfig;

    public BaiduPushBindSucessTask(Context context, Appterminal appterminal) {
        super(context);
        this.appterminal = appterminal;
    }

    @Override
    protected void onPreExecute() throws Exception {
        super.onPreExecute();
        converterConfig = new Jackson2HttpMessageConverterConfig();


    }

    @Override
    public Appterminal call() throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(converterConfig.getConverter());
            restTemplate.getMessageConverters().add(converterConfig.getStringHttpMessageConverter());
             appterminal = restTemplate.postForObject(systemBindUrl, appterminal, Appterminal.class);
            return appterminal;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onSuccess(Appterminal appterminal) throws Exception {
        super.onSuccess(appterminal);

    }
}
