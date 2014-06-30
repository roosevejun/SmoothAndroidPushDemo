package com.baidu.push.example.utils;

import android.telephony.TelephonyManager;
import com.baidu.push.example.bean.Terminal;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/26 0026 17:03
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class DeviceInformation {

    public static Terminal getTerminalInformation(TelephonyManager telephonyManager){
        Terminal terminal = new Terminal();
        terminal.setImei(telephonyManager.getDeviceId());
        terminal.setModel(android.os.Build.MODEL);
        terminal.setNumber(telephonyManager.getLine1Number());
        String subscriberId = telephonyManager.getSubscriberId();
        if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
            terminal.setType("中国移动");
        } else if (subscriberId.startsWith("46001")) {
            terminal.setType("中国联通");
        } else if (subscriberId.startsWith("46003")) {
            terminal.setType("中国电信");
        }
        terminal.setActory(android.os.Build.MODEL);
        terminal.setSim(telephonyManager.getSimSerialNumber());
        return terminal;
    }
}
