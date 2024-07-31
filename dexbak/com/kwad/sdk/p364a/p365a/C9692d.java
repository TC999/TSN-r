package com.kwad.sdk.p364a.p365a;

import android.text.TextUtils;
import com.kwad.components.core.p330s.C8940e;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdInfo;

/* renamed from: com.kwad.sdk.a.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9692d {
    /* renamed from: F */
    public static String m28032F(AdInfo adInfo) {
        return C10251d.m26529Cz().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", C8940e.m29559a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }

    /* renamed from: zS */
    public static String m28031zS() {
        String m26561CA = C10251d.m26561CA();
        return TextUtils.isEmpty(m26561CA) ? "安装" : m26561CA;
    }

    /* renamed from: zT */
    public static String m28030zT() {
        String m26560CB = C10251d.m26560CB();
        return TextUtils.isEmpty(m26560CB) ? "取消" : m26560CB;
    }
}
