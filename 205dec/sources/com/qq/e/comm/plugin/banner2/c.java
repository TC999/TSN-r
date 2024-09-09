package com.qq.e.comm.plugin.banner2;

import android.app.Activity;
import com.qq.e.mediation.interfaces.BaseBannerAd;
import java.lang.reflect.Constructor;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static BaseBannerAd a(String str, Activity activity, String str2, String str3, String str4) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(BaseBannerAd.class).getDeclaredConstructor(Activity.class, String.class, String.class, String.class);
        declaredConstructor.setAccessible(true);
        return (BaseBannerAd) declaredConstructor.newInstance(activity, str2, str3, str4);
    }
}
