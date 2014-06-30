package com.baidu.push.example.event;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/30 0030 14:18
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class NetworkStateEvent {
    private  String mTypeName = "Unknown";
    private String mSubtypeName = "Unknown";
    private boolean mAvailable = false;

    public NetworkStateEvent(String mTypeName, String mSubtypeName, boolean mAvailable) {
        this.mTypeName = mTypeName;
        this.mSubtypeName = mSubtypeName;
        this.mAvailable = mAvailable;
    }

    public String getmTypeName() {
        return mTypeName;
    }

    public String getmSubtypeName() {
        return mSubtypeName;
    }

    public boolean ismAvailable() {
        return mAvailable;
    }
}
