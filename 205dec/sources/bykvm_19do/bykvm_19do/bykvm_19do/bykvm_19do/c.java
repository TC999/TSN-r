package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a0;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r;
import cn.jpush.android.local.JPushConstants;

/* compiled from: URLConst.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f551a;

    /* renamed from: b  reason: collision with root package name */
    private static String f552b;

    public static String a() {
        return a0.a(JPushConstants.HTTPS_PRE + a.f().f());
    }

    public static String b() {
        return a0.a(c() + "/api/ad/union/mediation/exchange/");
    }

    private static String c() {
        String e4 = e();
        return !TextUtils.isEmpty(e4) ? e4 : "https://pangolin.snssdk.com";
    }

    public static String d() {
        return a0.a(c() + "/api/ad/union/mediation/stats/");
    }

    private static String e() {
        String d4 = r.a("tt_sdk_settings", a.d()).d("server_dist_host");
        if (TextUtils.isEmpty(d4)) {
            return null;
        }
        if (TextUtils.equals(d4, f551a) && !TextUtils.isEmpty(f552b)) {
            return f552b;
        }
        f551a = d4;
        f552b = null;
        if (!TextUtils.isEmpty(d4)) {
            f552b = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.a(f551a, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b.a());
        }
        if (TextUtils.isEmpty(f552b)) {
            return null;
        }
        String str = JPushConstants.HTTPS_PRE + f552b;
        f552b = str;
        return str;
    }

    public static String f() {
        return a0.a(c() + "/api/ad/union/mediation/config/");
    }
}
