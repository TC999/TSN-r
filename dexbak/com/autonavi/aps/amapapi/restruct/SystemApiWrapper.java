package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;

/* renamed from: com.autonavi.aps.amapapi.restruct.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SystemApiWrapper {
    /* renamed from: a */
    public static String m51511a(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getBSSID();
    }

    /* renamed from: b */
    public static String m51510b(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getSSID();
    }

    /* renamed from: c */
    public static int m51509c(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return -1;
        }
        return wifiInfo.getRssi();
    }
}
