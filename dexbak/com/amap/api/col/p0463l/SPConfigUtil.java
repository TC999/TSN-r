package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.d5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SPConfigUtil {

    /* renamed from: a */
    private SDKInfo f3868a;

    /* compiled from: SPConfigUtil.java */
    /* renamed from: com.amap.api.col.3l.d5$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1770a {

        /* renamed from: a */
        public static Map<String, SPConfigUtil> f3869a = new HashMap();
    }

    /* compiled from: SPConfigUtil.java */
    /* renamed from: com.amap.api.col.3l.d5$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class C1771b {

        /* renamed from: a */
        private String f3870a;

        /* renamed from: b */
        private String f3871b;

        /* renamed from: c */
        private String f3872c;

        public C1771b(String str, String str2, String str3) {
            this.f3870a = str;
            this.f3871b = str2;
            this.f3872c = str3;
        }

        /* renamed from: a */
        private static C1771b m55287a(JSONObject jSONObject) {
            try {
                return new C1771b(jSONObject.optString("sdkVersion"), jSONObject.optString("cpuType"), jSONObject.optString("content"));
            } catch (Throwable unused) {
                return null;
            }
        }

        /* renamed from: d */
        public static List<C1771b> m55284d(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(m55287a(jSONArray.getJSONObject(i)));
                }
                return arrayList;
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }

        /* renamed from: e */
        public static JSONArray m55283e(List<C1771b> list) {
            if (list == null) {
                return new JSONArray();
            }
            JSONArray jSONArray = new JSONArray();
            for (C1771b c1771b : list) {
                if (c1771b != null) {
                    if (!TextUtils.isEmpty(c1771b.f3872c)) {
                        jSONArray.put(c1771b.m55282f());
                    }
                }
            }
            return jSONArray;
        }

        /* renamed from: f */
        private JSONObject m55282f() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkVersion", this.f3870a);
                jSONObject.put("cpuType", this.f3871b);
                jSONObject.put("content", this.f3872c);
                return jSONObject;
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }

        /* renamed from: g */
        public final boolean m55281g(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f3870a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f3871b;
            }
            return this.f3870a.equals(str) && this.f3871b.equals(str2);
        }
    }

    private SPConfigUtil(SDKInfo sDKInfo) {
        this.f3868a = sDKInfo;
    }

    /* renamed from: a */
    public static SPConfigUtil m55294a(SDKInfo sDKInfo) {
        if (sDKInfo == null || TextUtils.isEmpty(sDKInfo.m54400a())) {
            return null;
        }
        if (C1770a.f3869a.get(sDKInfo.m54400a()) == null) {
            C1770a.f3869a.put(sDKInfo.m54400a(), new SPConfigUtil(sDKInfo));
        }
        return C1770a.f3869a.get(sDKInfo.m54400a());
    }

    /* renamed from: b */
    private static String m55293b(Context context, String str, String str2) {
        return m55290e(context, "C7ADB20F22F238708BA5EE26D0401DB9" + C1849l4.m54583d(str), "ik".concat(String.valueOf(str2)));
    }

    /* renamed from: e */
    private static String m55290e(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2)) ? "" : C1925p4.m54197g(AESMD5Util.m55295e(C1925p4.m54179y(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    /* renamed from: f */
    private static void m55289f(Context context, String str, String str2, String str3) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        m55288g(context, "C7ADB20F22F238708BA5EE26D0401DB9" + C1849l4.m54583d(str), "ik".concat(String.valueOf(str2)), str3);
    }

    /* renamed from: g */
    private static void m55288g(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        String m54206E = C1925p4.m54206E(AESMD5Util.m55297c(C1925p4.m54189o(str3)));
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, m54206E);
        edit.commit();
    }

    /* renamed from: c */
    public final String m55292c(Context context, String str, String str2, String str3) {
        SDKInfo sDKInfo;
        if (context != null && (sDKInfo = this.f3868a) != null && !TextUtils.isEmpty(sDKInfo.m54400a())) {
            List<C1771b> m55284d = C1771b.m55284d(m55293b(context, this.f3868a.m54400a(), str3));
            if (m55284d.size() == 0) {
                return "";
            }
            for (int i = 0; i < m55284d.size(); i++) {
                C1771b c1771b = m55284d.get(i);
                if (c1771b.m55281g(str, str2)) {
                    return c1771b.f3872c;
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public final void m55291d(Context context, String str, String str2, String str3, String str4) {
        SDKInfo sDKInfo;
        if (context == null || (sDKInfo = this.f3868a) == null || TextUtils.isEmpty(sDKInfo.m54400a())) {
            return;
        }
        List<C1771b> m55284d = C1771b.m55284d(m55293b(context, this.f3868a.m54400a(), str3));
        for (int i = 0; i < m55284d.size(); i++) {
            C1771b c1771b = m55284d.get(i);
            if (c1771b.m55281g(str, str2)) {
                c1771b.f3872c = str4;
                m55289f(context, this.f3868a.m54400a(), str3, C1771b.m55283e(m55284d).toString());
                return;
            }
        }
        m55284d.add(new C1771b(str, str2, str4));
        m55289f(context, this.f3868a.m54400a(), str3, C1771b.m55283e(m55284d).toString());
    }
}
