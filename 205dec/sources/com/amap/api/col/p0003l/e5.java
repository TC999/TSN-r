package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SPConfigUtil.java */
/* renamed from: com.amap.api.col.3l.e5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e5 {

    /* renamed from: a  reason: collision with root package name */
    private p4 f7488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SPConfigUtil.java */
    /* renamed from: com.amap.api.col.3l.e5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, e5> f7489a = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SPConfigUtil.java */
    /* renamed from: com.amap.api.col.3l.e5$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f7490a;

        /* renamed from: b  reason: collision with root package name */
        private String f7491b;

        /* renamed from: c  reason: collision with root package name */
        private String f7492c;

        public b(String str, String str2, String str3) {
            this.f7490a = str;
            this.f7491b = str2;
            this.f7492c = str3;
        }

        private static b a(JSONObject jSONObject) {
            try {
                return new b(jSONObject.optString("sdkVersion"), jSONObject.optString("cpuType"), jSONObject.optString("content"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public static List<b> d(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    arrayList.add(a(jSONArray.getJSONObject(i4)));
                }
                return arrayList;
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }

        public static JSONArray e(List<b> list) {
            if (list == null) {
                return new JSONArray();
            }
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.f7492c)) {
                        jSONArray.put(bVar.f());
                    }
                }
            }
            return jSONArray;
        }

        private JSONObject f() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkVersion", this.f7490a);
                jSONObject.put("cpuType", this.f7491b);
                jSONObject.put("content", this.f7492c);
                return jSONObject;
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }

        public final boolean g(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f7490a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f7491b;
            }
            return this.f7490a.equals(str) && this.f7491b.equals(str2);
        }
    }

    private e5(p4 p4Var) {
        this.f7488a = p4Var;
    }

    public static e5 a(p4 p4Var) {
        if (p4Var == null || TextUtils.isEmpty(p4Var.a())) {
            return null;
        }
        if (a.f7489a.get(p4Var.a()) == null) {
            a.f7489a.put(p4Var.a(), new e5(p4Var));
        }
        return a.f7489a.get(p4Var.a());
    }

    private static String b(Context context, String str, String str2) {
        return e(context, "C7ADB20F22F238708BA5EE26D0401DB9" + m4.d(str), "ik".concat(String.valueOf(str2)));
    }

    private static String e(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2)) ? "" : q4.g(d4.e(q4.y(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    private static void f(Context context, String str, String str2, String str3) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        g(context, "C7ADB20F22F238708BA5EE26D0401DB9" + m4.d(str), "ik".concat(String.valueOf(str2)), str3);
    }

    private static void g(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        String E = q4.E(d4.c(q4.o(str3)));
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, E);
        edit.commit();
    }

    public final String c(Context context, String str, String str2, String str3) {
        p4 p4Var;
        if (context != null && (p4Var = this.f7488a) != null && !TextUtils.isEmpty(p4Var.a())) {
            List<b> d4 = b.d(b(context, this.f7488a.a(), str3));
            if (d4.size() == 0) {
                return "";
            }
            for (int i4 = 0; i4 < d4.size(); i4++) {
                b bVar = d4.get(i4);
                if (bVar.g(str, str2)) {
                    return bVar.f7492c;
                }
            }
        }
        return null;
    }

    public final void d(Context context, String str, String str2, String str3, String str4) {
        p4 p4Var;
        if (context == null || (p4Var = this.f7488a) == null || TextUtils.isEmpty(p4Var.a())) {
            return;
        }
        List<b> d4 = b.d(b(context, this.f7488a.a(), str3));
        for (int i4 = 0; i4 < d4.size(); i4++) {
            b bVar = d4.get(i4);
            if (bVar.g(str, str2)) {
                bVar.f7492c = str4;
                f(context, this.f7488a.a(), str3, b.e(d4).toString());
                return;
            }
        }
        d4.add(new b(str, str2, str4));
        f(context, this.f7488a.a(), str3, b.e(d4).toString());
    }
}
