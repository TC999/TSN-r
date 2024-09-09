package com.baidu.mobads.sdk.api;

import android.app.Application;
import com.baidu.mobads.sdk.internal.ao;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NovelSDKConfig {
    public static void attachBaseContext(Application application, String str, String str2) {
        ao.a(application, str, str2);
    }

    public static boolean isInitNovelSDK() {
        return ao.f();
    }
}
