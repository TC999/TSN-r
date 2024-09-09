package com.bytedance.msdk.api.sr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.msdk.f.z;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class gd {

    /* renamed from: c  reason: collision with root package name */
    private static Context f27631c = null;
    private static long sr = -1;

    /* renamed from: w  reason: collision with root package name */
    private static c f27632w = null;
    private static long xv = -1;

    @Deprecated
    public static void a() {
        com.bytedance.msdk.core.c.w().w(com.bytedance.msdk.ux.f.c().xv("if_test"));
    }

    @Nullable
    public static Map<String, Object> bk() {
        return com.bytedance.msdk.core.w.k().vc();
    }

    public static void c(final Activity activity, final List<a> list, final int i4, final int i5) {
        c(new ys() { // from class: com.bytedance.msdk.api.sr.gd.1
            @Override // com.bytedance.msdk.api.sr.ys
            public void c() {
                com.bytedance.msdk.core.ux.w.w.c().c(activity, list, i4, i5);
            }
        });
    }

    @Nullable
    public static Map<String, String> ev() {
        return com.bytedance.msdk.core.w.k().ia();
    }

    public static boolean f() {
        return com.bytedance.msdk.core.w.k().ys();
    }

    public static boolean gd() {
        return com.bytedance.msdk.core.w.k().n();
    }

    @Nullable
    public static String k() {
        return com.bytedance.msdk.core.w.k().a();
    }

    @Nullable
    public static String p() {
        return com.bytedance.msdk.core.w.k().i();
    }

    @Nullable
    public static String r() {
        return com.bytedance.msdk.core.w.k().fp();
    }

    public static void sr() {
        if (f27631c == null) {
            Log.d("TTMediationSDK_SDK_Init", "GMMediationAdSdk\u521d\u59cb\u5316\u5931\u8d25\uff0ccontext\u4e0d\u80fd\u662fnull\uff0c\u8bf7\u68c0\u6d4binit\u65b9\u6cd5\u4e2d\u4f20\u5165\u7684context\u503c");
        } else if (f27632w == null) {
            Log.d("TTMediationSDK_SDK_Init", "GMMediationAdSdk\u521d\u59cb\u5316\u5931\u8d25\uff0cGMAdConfig\u4e0d\u80fd\u662fnull\uff0c\u8bf7\u68c0\u6d4binit\u65b9\u6cd5\u4e2d\u4f20\u5165\u7684config\u503c");
        } else {
            if (sr == -1) {
                sr = System.currentTimeMillis();
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "call start up time " + sr);
            }
            w(f27631c, f27632w);
            com.bytedance.msdk.xv.r.w();
        }
    }

    public static String ux() {
        return com.bytedance.msdk.c.sr.w();
    }

    public static long w() {
        return xv;
    }

    public static long xv() {
        return sr;
    }

    public static void c(ys ysVar) {
        com.bytedance.msdk.core.c.w().c(ysVar);
    }

    @Nullable
    @Deprecated
    public static com.bytedance.msdk.adapter.c.xv f(String str) {
        return com.bytedance.msdk.sr.w.w.c().c(str);
    }

    @Nullable
    @Deprecated
    public static com.bytedance.msdk.api.sr.c.w.f.c ux(String str) {
        return com.bytedance.msdk.sr.w.c.c(str);
    }

    private static void w(@NonNull Context context, @NonNull c cVar) {
        com.bytedance.msdk.ux.c.c.p().c(cVar.c(), cVar.ia());
        com.bytedance.msdk.ux.c.c.p().k();
        com.bytedance.msdk.f.bk.c(context);
        com.bytedance.msdk.sr.xv.c(cVar, StubApp.getOrigApplicationContext(context.getApplicationContext()));
        com.bytedance.msdk.ux.c.c.p().a();
    }

    @Nullable
    public static String xv(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1841217171:
                if (str.equals(PangleAdapterUtils.KEY_PANGLE_PREVIEW_EXT)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1114711305:
                if (str.equals(PangleAdapterUtils.KEY_PANGLE_PREVIEW_CREATIVE_ID)) {
                    c4 = 1;
                    break;
                }
                break;
            case 112517891:
                if (str.equals(PangleAdapterUtils.KEY_PANGLE_PREVIEW_AD_ID)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return com.bytedance.msdk.f.sr.sr.xv();
            case 1:
                return com.bytedance.msdk.f.sr.sr.w();
            case 2:
                return com.bytedance.msdk.f.sr.sr.c();
            default:
                return null;
        }
    }

    public static boolean c() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.w.k().a())) {
            return false;
        }
        return com.bytedance.msdk.core.c.w().ls();
    }

    public static void c(@NonNull Context context, @NonNull c cVar) {
        if (xv == -1) {
            xv = System.currentTimeMillis();
            if (cVar != null && cVar.xv()) {
                com.bytedance.msdk.adapter.sr.xv.c();
                com.bytedance.sdk.component.ev.c.c();
            }
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "call init time " + xv);
            f27631c = context;
            f27632w = cVar;
        }
    }

    public static void w(String str) {
        com.bytedance.msdk.core.w.k().ux(str);
    }

    @Nullable
    public static String w(Context context) {
        return z.c();
    }

    public static boolean w(String str, String str2) {
        return com.bytedance.msdk.sr.c.w(str, str2);
    }

    @Deprecated
    public static boolean sr(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(com.bytedance.msdk.core.w.k().a())) {
            return false;
        }
        return com.bytedance.msdk.core.c.w().xv(str);
    }

    @Deprecated
    public static void w(int i4) {
        com.bytedance.msdk.core.c.w().w(i4);
    }

    public static void c(f fVar) {
        com.bytedance.msdk.core.w.k().c(fVar, false);
    }

    public static void c(String str) {
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "app\u8fd0\u884c\u4e2dsetPulisherDid: " + str);
        com.bytedance.msdk.core.w.k().sr(str);
    }

    public static void c(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar) {
        com.bytedance.msdk.core.w.k().w().setMediationCustomControllerValueSet(com.bytedance.msdk.sr.w.ux.c(srVar));
        com.bytedance.msdk.core.w.k().eq();
        com.bytedance.msdk.sr.xv.c(com.bytedance.msdk.sr.w.ux.c(srVar));
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        com.bytedance.msdk.f.sr.c(context, intent, null);
    }

    public static void c(Context context, int[] iArr) {
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra(TTDelegateActivity.INTENT_PERMISSIONS, iArr);
        if (context != null) {
            com.bytedance.msdk.f.sr.c(context, intent, null);
        }
    }

    public static void c(int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.bytedance.msdk.adapter.c.sr.ux, Integer.valueOf(i4));
        Map<String, com.bytedance.msdk.adapter.c.xv> w3 = com.bytedance.msdk.sr.w.w.c().w();
        if (w3 == null || w3.size() == 0) {
            return;
        }
        for (com.bytedance.msdk.adapter.c.xv xvVar : com.bytedance.msdk.sr.w.w.c().xv()) {
            if (xvVar != null) {
                xvVar.c(hashMap);
            }
        }
    }

    public static int c(xv xvVar) {
        com.bytedance.msdk.adapter.c.xv c4 = com.bytedance.msdk.sr.w.w.c().c("gdt");
        if (c4 == null) {
            return 0;
        }
        return c4.c(xvVar);
    }

    public static boolean c(String str, String str2) {
        return com.bytedance.msdk.sr.c.c(str, str2);
    }

    public static void c(com.bytedance.msdk.api.sr.c.gd.c cVar) {
        if (!com.bytedance.msdk.sr.xv.w()) {
            com.bytedance.msdk.core.w.k().c(cVar);
        } else if (cVar != null) {
            cVar.c();
        }
    }
}
