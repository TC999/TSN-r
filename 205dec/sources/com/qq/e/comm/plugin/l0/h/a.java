package com.qq.e.comm.plugin.l0.h;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.x1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    int f44623a;

    /* renamed from: b  reason: collision with root package name */
    String f44624b;

    /* renamed from: c  reason: collision with root package name */
    String f44625c;

    /* renamed from: d  reason: collision with root package name */
    int f44626d;

    /* renamed from: e  reason: collision with root package name */
    String f44627e;

    /* renamed from: f  reason: collision with root package name */
    int f44628f;

    /* renamed from: g  reason: collision with root package name */
    int f44629g;

    a(int i4, String str, String str2, int i5, int i6) {
        this.f44623a = i4;
        this.f44624b = str;
        this.f44625c = str2;
        this.f44626d = i5;
        this.f44627e = x1.a();
        this.f44628f = 0;
        this.f44629g = i6;
    }

    boolean a() {
        return !TextUtils.isEmpty(this.f44624b) && this.f44628f < 3 && this.f44627e.equals(x1.a());
    }

    JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f44623a);
            jSONObject.put("url", this.f44624b);
            jSONObject.put("headers", this.f44625c);
            jSONObject.put("error_code", this.f44626d);
            jSONObject.put("date", this.f44627e);
            jSONObject.put("retry_times", this.f44628f);
            jSONObject.put("adType", this.f44629g);
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        return jSONObject;
    }

    a(JSONObject jSONObject) {
        this.f44623a = jSONObject.optInt("type");
        this.f44624b = jSONObject.optString("url");
        this.f44625c = jSONObject.optString("headers");
        this.f44626d = jSONObject.optInt("error_code");
        this.f44627e = jSONObject.optString("date");
        this.f44628f = jSONObject.optInt("retry_times");
        this.f44629g = jSONObject.optInt("adType");
    }
}
