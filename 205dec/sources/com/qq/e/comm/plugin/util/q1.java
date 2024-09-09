package com.qq.e.comm.plugin.util;

import com.qq.e.comm.constants.CustomPkgConstants;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q1 {
    public static String a() {
        String aDActivityName = CustomPkgConstants.getADActivityName();
        return aDActivityName == null ? "com.qq.e.ads.ADActivity" : aDActivityName;
    }

    public static String b() {
        String downLoadServiceName = CustomPkgConstants.getDownLoadServiceName();
        return downLoadServiceName == null ? "com.qq.e.comm.DownloadService" : downLoadServiceName;
    }

    public static String c() {
        String landscapeADActivityName = CustomPkgConstants.getLandscapeADActivityName();
        return landscapeADActivityName == null ? "com.qq.e.ads.LandscapeADActivity" : landscapeADActivityName;
    }

    public static String d() {
        String portraitADActivityName = CustomPkgConstants.getPortraitADActivityName();
        return portraitADActivityName == null ? "com.qq.e.ads.PortraitADActivity" : portraitADActivityName;
    }
}
