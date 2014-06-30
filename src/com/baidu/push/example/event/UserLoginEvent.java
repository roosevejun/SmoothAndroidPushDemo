package com.baidu.push.example.event;


/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/25 0025 10:42
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class UserLoginEvent {
    String eventName = "userLoginEvent";
    String loginName = null;
    String loginPass = null;

    public UserLoginEvent(String loginName, String loginPass) {
        this.loginName = loginName;
        this.loginPass = loginPass;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }
}
