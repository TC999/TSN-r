package com.qq.e.comm.plugin.edgeanalytics.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f43017a = com.qq.e.comm.plugin.d0.a.d().a();

    /* renamed from: b  reason: collision with root package name */
    private final b f43018b;

    public c(b bVar) {
        this.f43018b = bVar;
    }

    public String a(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            com.qq.e.comm.plugin.edgeanalytics.h.c.a.a(str);
        }
        int optInt = new j0(jSONObject).a().optInt("std", 3);
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject a4 = new j0(str2).a("ts", currentTimeMillis).a();
        String jSONObject2 = a4.toString();
        if ((optInt & 4) > 0) {
            this.f43018b.a(str, a4);
        }
        if ((optInt & 2) > 0) {
            com.qq.e.comm.plugin.edgeanalytics.h.c.a.b(str, jSONObject2);
        }
        if ((optInt & 1) > 0) {
            String optString = a4.optString("ph");
            a4.remove("ph");
            a4.remove("ts");
            a.a(this.f43017a).a(str, a4.toString(), optString, currentTimeMillis);
        }
        return jSONObject2;
    }

    public JSONArray b(String str) {
        return a.a(this.f43017a).b(str);
    }

    public int b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return a.a(this.f43017a).a(str, new JSONArray(str2));
            } catch (JSONException e4) {
                d1.a(e4.getMessage(), e4);
            }
        }
        return -1;
    }

    public int a(String str) {
        return a.a(this.f43017a).a(str);
    }

    public int a(String str, String str2) {
        return a.a(this.f43017a).a(str, str2);
    }
}
