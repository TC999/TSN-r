package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AAIDCreateRequest.java */
/* renamed from: com.amap.api.col.3l.u4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u4 extends z4 {

    /* renamed from: j  reason: collision with root package name */
    public String f9143j;

    /* renamed from: k  reason: collision with root package name */
    public String f9144k;

    /* renamed from: p  reason: collision with root package name */
    public String f9145p;

    /* renamed from: q  reason: collision with root package name */
    public String f9146q;

    /* renamed from: r  reason: collision with root package name */
    public String f9147r;

    /* renamed from: s  reason: collision with root package name */
    public String f9148s;

    /* renamed from: t  reason: collision with root package name */
    public String f9149t;

    /* renamed from: u  reason: collision with root package name */
    public String f9150u;

    /* renamed from: v  reason: collision with root package name */
    public String f9151v;

    /* renamed from: w  reason: collision with root package name */
    protected byte[] f9152w;

    public u4(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f9152w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "create");
            jSONObject.put("package_name", e4.g(this.f9583i));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.11");
            String a4 = v4.a();
            this.f9143j = a4;
            jSONObject.put("t1", a4);
            String e4 = v4.e();
            this.f9144k = e4;
            jSONObject.put("t2", e4);
            String h4 = v4.h();
            this.f9145p = h4;
            jSONObject.put("t3", h4);
            String i4 = v4.i();
            this.f9146q = i4;
            jSONObject.put("s1", i4);
            String j4 = v4.j();
            this.f9147r = j4;
            jSONObject.put("s2", j4);
            String k4 = v4.k();
            this.f9148s = k4;
            jSONObject.put("s3", k4);
            String l4 = v4.l();
            this.f9149t = l4;
            jSONObject.put("s4", l4);
            jSONObject.put("uuid", v4.b(this.f9583i));
            jSONObject.put("android_id", i4.G());
            jSONObject.put("hostname", v4.m());
            String f02 = i4.f0(this.f9583i);
            this.f9150u = f02;
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, f02);
            String D = i4.D(this.f9583i);
            this.f9151v = D;
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, D);
            this.f9152w = v4.d(q4.z(jSONObject.toString().getBytes("utf-8")), q4.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f9152w;
    }
}
