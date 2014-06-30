package com.baidu.push.example.bean;

import java.io.Serializable;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/26 0026 16:09
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */


public class Terminal implements Serializable {
    private String id;
    private String imei;
    private String number;
    private String model;
    private String actory;
    private String type;
    private String sim;
    private String releaseStatus;
    private String useStatus;
    private String remarks;
    private Boolean rowStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getActory() {
        return actory;
    }

    public void setActory(String actory) {
        this.actory = actory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Boolean rowStatus) {
        this.rowStatus = rowStatus;
    }
}
