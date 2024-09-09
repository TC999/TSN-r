package com.baidu.mobads.sdk.api;

import androidx.annotation.DrawableRes;
import com.baidu.mobads.sdk.internal.co;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdSettings {
    public static String getSDKVersion() {
        return co.c() + "";
    }

    public static void setNotificationChannel(String str) {
        CustomNotification.setNotificationChannel(str);
    }

    public static void setNotificationIcon(@DrawableRes int i4) {
        CustomNotification.setNotificationIcon(i4);
    }
}
