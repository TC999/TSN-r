package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.amap.api.col.p0003l.u5;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AMapLogEntity.java */
/* renamed from: com.amap.api.col.3l.a5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a5 {

    /* renamed from: e  reason: collision with root package name */
    public static int f7099e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static int f7100f = 2;

    /* renamed from: a  reason: collision with root package name */
    private String f7101a;

    /* renamed from: b  reason: collision with root package name */
    private int f7102b;

    /* renamed from: c  reason: collision with root package name */
    private long f7103c = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    private String f7104d;

    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.a5$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    final class a implements u5.d {

        /* compiled from: AMapLogManager.java */
        /* renamed from: com.amap.api.col.3l.a5$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        final class RunnableC0099a implements Runnable {
            RunnableC0099a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a5.r(a5.this);
            }
        }

        a() {
        }

        @Override // com.amap.api.col.p0003l.u5.d
        public final void a(int i4) {
            if (i4 > 0 && a5.b(a5.this) != null) {
                ((b5) a5.m(a5.this).f).f(i4);
                a5.i(a5.this, "error", String.valueOf(((b5) a5.m(a5.this).f).h()));
                a5.b(a5.this).postDelayed(new RunnableC0099a(), 660000L);
            }
        }
    }

    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.a5$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    final class b implements u5.d {

        /* compiled from: AMapLogManager.java */
        /* renamed from: com.amap.api.col.3l.a5$b$a */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a5.x(a5.this);
            }
        }

        b() {
        }

        @Override // com.amap.api.col.p0003l.u5.d
        public final void a(int i4) {
            if (i4 <= 0) {
                return;
            }
            ((b5) a5.u(a5.this).f).f(i4);
            a5.i(a5.this, "info", String.valueOf(((b5) a5.u(a5.this).f).h()));
            if (a5.b(a5.this) == null) {
                return;
            }
            a5.b(a5.this).postDelayed(new a(), 660000L);
        }
    }

    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.a5$c */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class c {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, a5> f7109a = new HashMap();
    }

    private a5(int i4, String str, String str2) {
        this.f7101a = str2;
        this.f7102b = i4;
        this.f7104d = str;
    }

    public static a5 b(String str, String str2) {
        return new a5(f7099e, str, str2);
    }

    public static String c(int i4) {
        return i4 == f7100f ? "error" : "info";
    }

    public static String d(List<a5> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (a5 a5Var : list) {
                        String h4 = h(a5Var);
                        if (!TextUtils.isEmpty(h4)) {
                            jSONArray.put(h4);
                        }
                    }
                    return jSONArray.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static boolean e(a5 a5Var) {
        return (a5Var == null || TextUtils.isEmpty(a5Var.g())) ? false : true;
    }

    public static a5 f(String str, String str2) {
        return new a5(f7100f, str, str2);
    }

    private static String h(a5 a5Var) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("info", a5Var.g());
            jSONObject.put("session", a5Var.j());
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, a5Var.f7103c);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private String j() {
        return this.f7104d;
    }

    public final int a() {
        return this.f7102b;
    }

    public final String g() {
        new JSONObject();
        return this.f7101a;
    }

    public final String i() {
        return c(this.f7102b);
    }
}
