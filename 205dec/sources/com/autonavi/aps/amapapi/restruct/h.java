package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SystemApiWrapper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h {
    public static String a(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getBSSID();
    }

    public static String b(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getSSID();
    }

    public static int c(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return -1;
        }
        return wifiInfo.getRssi();
    }
}
