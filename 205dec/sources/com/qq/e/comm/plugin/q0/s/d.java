package com.qq.e.comm.plugin.q0.s;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f45538a;

    /* renamed from: b  reason: collision with root package name */
    private final String f45539b;

    /* renamed from: c  reason: collision with root package name */
    private final String f45540c;

    /* renamed from: d  reason: collision with root package name */
    private final JSONObject f45541d;

    /* renamed from: e  reason: collision with root package name */
    private final String f45542e;

    /* renamed from: f  reason: collision with root package name */
    private final long f45543f;

    public d(String str) {
        this(null, null, str, null);
    }

    public String a() {
        return this.f45539b;
    }

    public String b() {
        return this.f45540c;
    }

    public String c() {
        return this.f45542e;
    }

    public JSONObject d() {
        return this.f45541d;
    }

    public String e() {
        return this.f45538a;
    }

    public long f() {
        return this.f45543f;
    }

    public String toString() {
        return "GDTJsRequest [service=" + this.f45538a + ", action=" + this.f45539b + ", callbackId=" + this.f45540c + ", paraObj=" + this.f45541d + ", multiActionPara:" + this.f45542e + ",timeStamp:" + this.f45543f + "]";
    }

    public d(String str, String str2, String str3, JSONObject jSONObject) {
        this(str, str2, str3, jSONObject, null, System.currentTimeMillis());
    }

    public d(String str, String str2, String str3, JSONObject jSONObject, long j4) {
        this(str, str2, str3, jSONObject, null, j4);
    }

    public d(String str, String str2, String str3, JSONObject jSONObject, String str4, long j4) {
        this.f45538a = str;
        this.f45539b = str2;
        this.f45540c = str3;
        this.f45541d = jSONObject;
        this.f45542e = str4;
        this.f45543f = j4;
    }
}
