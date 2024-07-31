package com.iab.omid.library.mmadbridge.p204d;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7100a {
    /* renamed from: a */
    public static String m34699a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    /* renamed from: b */
    public static String m34698b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m34697c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m34696d() {
        JSONObject jSONObject = new JSONObject();
        C7101b.m34688h(jSONObject, "deviceType", m34699a());
        C7101b.m34688h(jSONObject, "osVersion", m34698b());
        C7101b.m34688h(jSONObject, "os", m34697c());
        return jSONObject;
    }
}
