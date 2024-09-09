package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.lang.reflect.Constructor;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b {
    public static BaseInterstitialAd a(String str, Activity activity, String str2, String str3, String str4) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(BaseInterstitialAd.class).getDeclaredConstructor(Activity.class, String.class, String.class, String.class);
        declaredConstructor.setAccessible(true);
        return (BaseInterstitialAd) declaredConstructor.newInstance(activity, str2, str3, str4);
    }
}
