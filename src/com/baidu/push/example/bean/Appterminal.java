package com.baidu.push.example.bean;


import java.io.Serializable;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/27 0027 15:41
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class Appterminal implements Serializable {
    protected String channelid;
    protected String terminalid;
    protected String baiduid;
    private String remarks;
    private Boolean rowStatus;


    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }


    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }


    public String getBaiduid() {
        return baiduid;
    }

    public void setBaiduid(String baiduid) {
        this.baiduid = baiduid;
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
