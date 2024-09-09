package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c {
    public static BaseNativeExpressAd a(String str, ADSize aDSize, Context context, String str2, String str3, String str4) throws Exception {
        return (BaseNativeExpressAd) Class.forName(str).asSubclass(BaseNativeExpressAd.class).getDeclaredConstructor(Context.class, ADSize.class, String.class, String.class, String.class).newInstance(context, aDSize, str2, str3, str4);
    }
}
