package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AAIDRemapRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p1 extends r1 {

    /* renamed from: n  reason: collision with root package name */
    public String f10084n;

    /* renamed from: o  reason: collision with root package name */
    public String f10085o;

    /* renamed from: p  reason: collision with root package name */
    public String f10086p;

    /* renamed from: q  reason: collision with root package name */
    public String f10087q;

    /* renamed from: r  reason: collision with root package name */
    public String f10088r;

    /* renamed from: s  reason: collision with root package name */
    public String f10089s;

    /* renamed from: t  reason: collision with root package name */
    public String f10090t;

    /* renamed from: u  reason: collision with root package name */
    public String f10091u;

    /* renamed from: v  reason: collision with root package name */
    public String f10092v;

    /* renamed from: w  reason: collision with root package name */
    protected byte[] f10093w;

    public p1(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        byte[] bArr = this.f10093w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "remap");
            jSONObject.put("package_name", x0.f(this.f10146m));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.5");
            String a4 = n1.a();
            this.f10084n = a4;
            jSONObject.put("t1", a4);
            jSONObject.put("old_t1", k1.n(this.f10146m));
            String e4 = n1.e();
            this.f10085o = e4;
            jSONObject.put("t2", e4);
            jSONObject.put("old_t2", k1.p(this.f10146m));
            String h4 = n1.h();
            this.f10086p = h4;
            jSONObject.put("t3", h4);
            jSONObject.put("old_t3", k1.r(this.f10146m));
            String i4 = n1.i();
            this.f10087q = i4;
            jSONObject.put("s1", i4);
            jSONObject.put("old_s1", k1.t(this.f10146m));
            String j4 = n1.j();
            this.f10088r = j4;
            jSONObject.put("s2", j4);
            jSONObject.put("old_s2", k1.v(this.f10146m));
            String k4 = n1.k();
            this.f10089s = k4;
            jSONObject.put("s3", k4);
            jSONObject.put("old_s3", k1.x(this.f10146m));
            String l4 = n1.l();
            this.f10090t = l4;
            jSONObject.put("s4", l4);
            jSONObject.put("old_s4", k1.z(this.f10146m));
            jSONObject.put("uuid", n1.b(this.f10146m));
            jSONObject.put("android_id", c1.z());
            jSONObject.put("hostname", n1.m());
            String Q = c1.Q(this.f10146m);
            this.f10091u = Q;
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, Q);
            jSONObject.put("old_gaid", k1.B(this.f10146m));
            String w3 = c1.w(this.f10146m);
            this.f10092v = w3;
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, w3);
            jSONObject.put("old_oaid", k1.d(this.f10146m));
            jSONObject.put("aaid", k1.f(this.f10146m));
            jSONObject.put("resetToken", k1.l(this.f10146m));
            jSONObject.put("uabc", k1.j(this.f10146m));
            this.f10093w = n1.d(j1.y(jSONObject.toString().getBytes("utf-8")), j1.t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f10093w;
    }
}
