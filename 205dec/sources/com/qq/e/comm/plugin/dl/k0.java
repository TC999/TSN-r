package com.qq.e.comm.plugin.dl;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class k0 {

    /* renamed from: a  reason: collision with root package name */
    private static final b f42477a = new o0();

    /* renamed from: b  reason: collision with root package name */
    private static final b f42478b = new m0();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<com.qq.e.comm.plugin.b.g, JSONObject> f42479c = new HashMap(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42480a;

        static {
            int[] iArr = new int[com.qq.e.comm.plugin.b.g.values().length];
            f42480a = iArr;
            try {
                iArr[com.qq.e.comm.plugin.b.g.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42480a[com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42480a[com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42480a[com.qq.e.comm.plugin.b.g.UNIFIED_BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f42480a[com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f42480a[com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f42480a[com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        String a();

        String b();

        String c();

        String d();

        String e();

        String f();

        String g();
    }

    static String a(com.qq.e.comm.plugin.b.g gVar) {
        b bVar = l0.a(gVar) ? f42478b : f42477a;
        switch (a.f42480a[gVar.ordinal()]) {
            case 1:
                return bVar.c();
            case 2:
                return bVar.b();
            case 3:
                return bVar.a();
            case 4:
                return bVar.d();
            case 5:
                return bVar.f();
            case 6:
                return bVar.e();
            case 7:
                return bVar.g();
            default:
                return "{}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(com.qq.e.comm.plugin.b.g gVar, String str) {
        JSONObject jSONObject = f42479c.get(gVar);
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject(a(gVar));
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            f42479c.put(gVar, jSONObject);
        }
        return jSONObject.optString(str);
    }
}
