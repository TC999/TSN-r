package com.baidu.mobads.sdk.api;

import androidx.annotation.DrawableRes;
import com.baidu.mobads.sdk.internal.C2659cl;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdSettings {
    public static String getSDKVersion() {
        return C2659cl.m50634c() + "";
    }

    public static void setNotificationChannel(String str) {
        CustomNotification.setNotificationChannel(str);
    }

    public static void setNotificationIcon(@DrawableRes int i) {
        CustomNotification.setNotificationIcon(i);
    }
}
