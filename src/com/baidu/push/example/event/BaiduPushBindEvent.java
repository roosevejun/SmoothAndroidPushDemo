package com.baidu.push.example.event;

import com.baidu.push.example.bean.Appterminal;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/27 0027 15:25
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class BaiduPushBindEvent extends Appterminal {


    public BaiduPushBindEvent(String appid, String channelId, String mobileId) {
        super.baiduid = appid;
        super.channelid = channelId;
        this.terminalid = mobileId;
    }


}
