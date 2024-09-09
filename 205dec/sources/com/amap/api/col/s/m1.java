package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AAIDCreateRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m1 extends r1 {

    /* renamed from: n  reason: collision with root package name */
    public String f10010n;

    /* renamed from: o  reason: collision with root package name */
    public String f10011o;

    /* renamed from: p  reason: collision with root package name */
    public String f10012p;

    /* renamed from: q  reason: collision with root package name */
    public String f10013q;

    /* renamed from: r  reason: collision with root package name */
    public String f10014r;

    /* renamed from: s  reason: collision with root package name */
    public String f10015s;

    /* renamed from: t  reason: collision with root package name */
    public String f10016t;

    /* renamed from: u  reason: collision with root package name */
    public String f10017u;

    /* renamed from: v  reason: collision with root package name */
    public String f10018v;

    /* renamed from: w  reason: collision with root package name */
    protected byte[] f10019w;

    public m1(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        byte[] bArr = this.f10019w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "create");
            jSONObject.put("package_name", x0.f(this.f10146m));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.5");
            String a4 = n1.a();
            this.f10010n = a4;
            jSONObject.put("t1", a4);
            String e4 = n1.e();
            this.f10011o = e4;
            jSONObject.put("t2", e4);
            String h4 = n1.h();
            this.f10012p = h4;
            jSONObject.put("t3", h4);
            String i4 = n1.i();
            this.f10013q = i4;
            jSONObject.put("s1", i4);
            String j4 = n1.j();
            this.f10014r = j4;
            jSONObject.put("s2", j4);
            String k4 = n1.k();
            this.f10015s = k4;
            jSONObject.put("s3", k4);
            String l4 = n1.l();
            this.f10016t = l4;
            jSONObject.put("s4", l4);
            jSONObject.put("uuid", n1.b(this.f10146m));
            jSONObject.put("android_id", c1.z());
            jSONObject.put("hostname", n1.m());
            String Q = c1.Q(this.f10146m);
            this.f10017u = Q;
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, Q);
            String w3 = c1.w(this.f10146m);
            this.f10018v = w3;
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, w3);
            this.f10019w = n1.d(j1.y(jSONObject.toString().getBytes("utf-8")), j1.t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f10019w;
    }
}
