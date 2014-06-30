package com.baidu.push.example.listener;

import com.baidu.push.example.event.InitializeAppEndEvent;
import com.baidu.push.example.event.UserLoginEvent;
import com.google.common.eventbus.Subscribe;
import roboguice.event.Observes;
import roboguice.util.Ln;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/25 0025 17:21
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class UserLoginListener {

    public void doUserLoginEvent(@Observes UserLoginEvent loginEvent) {
        Ln.d("UserLoginEvent Hello, world!"+loginEvent.getLoginName()+loginEvent.getLoginPass());
    }
    @Subscribe
    public void initializeAppEndEvent( InitializeAppEndEvent endEvent) {
        Ln.d("UserLoginEvent Hello, world!"+endEvent.getApikey()+endEvent.getSecretkey());
    }
}
