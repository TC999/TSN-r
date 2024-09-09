package com.bytedance.msdk.core;

import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.msdk.f.x;
import com.bytedance.msdk.ux.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static String f28285c;

    /* renamed from: w  reason: collision with root package name */
    private static String f28286w;

    public static String c() {
        return x.c(f() + "/api/ad/union/mediation/config/");
    }

    private static String f() {
        String r3 = r();
        return !TextUtils.isEmpty(r3) ? r3 : "https://gromore.pangolin-sdk-toutiao.com";
    }

    private static String r() {
        String w3 = f.c().w("server_dist_host");
        if (TextUtils.isEmpty(w3)) {
            return null;
        }
        if (TextUtils.equals(w3, f28285c) && !TextUtils.isEmpty(f28286w)) {
            return f28286w;
        }
        f28285c = w3;
        f28286w = null;
        if (!TextUtils.isEmpty(w3)) {
            f28286w = com.bytedance.msdk.f.c.w(f28285c, com.bytedance.msdk.f.w.c());
        }
        if (TextUtils.isEmpty(f28286w)) {
            return null;
        }
        String str = JPushConstants.HTTPS_PRE + f28286w;
        f28286w = str;
        return str;
    }

    public static String sr() {
        return x.c(f() + "/api/ad/union/mediation/exchange/");
    }

    public static String ux() {
        return x.c(f() + "/api/ad/union/mediation/reward_video/reward/");
    }

    public static String w() {
        return x.c(f() + "/api/ad/union/mediation/stats/");
    }

    public static String xv() {
        return x.c(JPushConstants.HTTPS_PRE + c.w().r());
    }
}
