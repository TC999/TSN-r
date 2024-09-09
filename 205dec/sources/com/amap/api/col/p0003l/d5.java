package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: LogMemCacher.java */
/* renamed from: com.amap.api.col.3l.d5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d5 {

    /* renamed from: d  reason: collision with root package name */
    private static int f7423d = 100;

    /* renamed from: e  reason: collision with root package name */
    private static int f7424e = 10000;

    /* renamed from: a  reason: collision with root package name */
    private Vector<a5> f7425a;

    /* renamed from: b  reason: collision with root package name */
    private int f7426b;

    /* renamed from: c  reason: collision with root package name */
    private int f7427c;

    /* compiled from: SPConfigUtil.java */
    /* renamed from: com.amap.api.col.3l.d5$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, d5> f7428a = new HashMap();
    }

    /* compiled from: SPConfigUtil.java */
    /* renamed from: com.amap.api.col.3l.d5$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f7429a;

        /* renamed from: b  reason: collision with root package name */
        private String f7430b;

        /* renamed from: c  reason: collision with root package name */
        private String f7431c;

        public b(String str, String str2, String str3) {
            this.f7429a = str;
            this.f7430b = str2;
            this.f7431c = str3;
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
                    if (!TextUtils.isEmpty(bVar.f7431c)) {
                        jSONArray.put(bVar.f());
                    }
                }
            }
            return jSONArray;
        }

        private JSONObject f() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkVersion", this.f7429a);
                jSONObject.put("cpuType", this.f7430b);
                jSONObject.put("content", this.f7431c);
                return jSONObject;
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }

        public final boolean g(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f7429a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f7430b;
            }
            return this.f7429a.equals(str) && this.f7430b.equals(str2);
        }
    }

    public d5() {
        this.f7427c = 0;
        this.f7426b = 10;
        this.f7425a = new Vector<>();
    }

    public final Vector<a5> a() {
        return this.f7425a;
    }

    public final synchronized void b(a5 a5Var) {
        if (a5Var != null) {
            if (!TextUtils.isEmpty(a5Var.g())) {
                this.f7425a.add(a5Var);
                this.f7427c += a5Var.g().getBytes().length;
            }
        }
    }

    public final synchronized boolean c(String str) {
        if (str == null) {
            return false;
        }
        if (this.f7425a.size() >= this.f7426b) {
            return true;
        }
        return this.f7427c + str.getBytes().length > f7424e;
    }

    public final synchronized void d() {
        this.f7425a.clear();
        this.f7427c = 0;
    }

    public d5(byte b4) {
        this.f7426b = f7423d;
        this.f7427c = 0;
        this.f7425a = new Vector<>();
    }
}
