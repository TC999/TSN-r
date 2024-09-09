package com.qq.e.comm.plugin.rewardvideo;

import android.content.Context;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.lang.reflect.Constructor;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b {
    public static BaseRewardAd a(String str, Context context, String str2, String str3, String str4) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(BaseRewardAd.class).getDeclaredConstructor(Context.class, String.class, String.class, String.class);
        declaredConstructor.setAccessible(true);
        return (BaseRewardAd) declaredConstructor.newInstance(context, str2, str3, str4);
    }
}
