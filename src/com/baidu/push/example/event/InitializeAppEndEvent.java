package com.baidu.push.example.event;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/26 0026 14:41
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class InitializeAppEndEvent {
    private String secretkey;
    private String apikey;

    public InitializeAppEndEvent(String secretkey, String apikey) {
        this.secretkey = secretkey;
        this.apikey = apikey;
    }

    public void onEvent(String secretkey, String apikey) {
        this.secretkey = secretkey;
        this.apikey = apikey;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public String getApikey() {
        return apikey;
    }

}
