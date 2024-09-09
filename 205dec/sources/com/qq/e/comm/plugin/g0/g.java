package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f43572a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43573b;

    /* renamed from: c  reason: collision with root package name */
    public final String f43574c;

    /* renamed from: d  reason: collision with root package name */
    public final String f43575d;

    /* renamed from: e  reason: collision with root package name */
    public final String f43576e;

    /* renamed from: f  reason: collision with root package name */
    public final Integer f43577f;

    public g(int i4, String str, String str2) {
        this.f43572a = i4;
        this.f43573b = str;
        this.f43574c = str2;
        this.f43575d = null;
        this.f43576e = null;
        this.f43577f = null;
    }

    public boolean a() {
        return (this.f43577f == null && TextUtils.isEmpty(this.f43576e)) ? false : true;
    }

    public g(int i4, JSONObject jSONObject) {
        jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
        this.f43572a = i4;
        this.f43573b = jSONObject.optString("clickid");
        this.f43574c = jSONObject.optString("dstlink");
        this.f43575d = jSONObject.optString("fmcphone");
        this.f43576e = jSONObject.optString("wx_scheme_dstlink");
        if (jSONObject.has("wx_scheme_error")) {
            this.f43577f = Integer.valueOf(jSONObject.optInt("wx_scheme_error"));
        } else {
            this.f43577f = null;
        }
    }

    public g(int i4) {
        this(i4, null, null);
    }
}
