package com.baidu.push.example.bean;


import java.io.Serializable;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/5/16 0016 15:46
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */


public class App implements Serializable {
    private String baiduid;
    private String name;
    private String model;
    private String release;
    private String secretkey;
    private String apikey;
    private String remarks;

    public String getBaiduid() {
        return baiduid;
    }

    public void setBaiduid(String baiduid) {
        this.baiduid = baiduid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
