package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: AAIDCreateRequest.java */
/* renamed from: com.amap.api.col.s.m1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2093m1 extends C2128r1 {

    /* renamed from: n */
    public String f6282n;

    /* renamed from: o */
    public String f6283o;

    /* renamed from: p */
    public String f6284p;

    /* renamed from: q */
    public String f6285q;

    /* renamed from: r */
    public String f6286r;

    /* renamed from: s */
    public String f6287s;

    /* renamed from: t */
    public String f6288t;

    /* renamed from: u */
    public String f6289u;

    /* renamed from: v */
    public String f6290v;

    /* renamed from: w */
    protected byte[] f6291w;

    public C2093m1(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: q */
    public final byte[] mo52382q() {
        byte[] bArr = this.f6291w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "create");
            jSONObject.put("package_name", C2199x0.m52330f(this.f6418m));
            jSONObject.put(C2624bk.f8685i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.5");
            String m52746a = C2101n1.m52746a();
            this.f6282n = m52746a;
            jSONObject.put("t1", m52746a);
            String m52742e = C2101n1.m52742e();
            this.f6283o = m52742e;
            jSONObject.put("t2", m52742e);
            String m52739h = C2101n1.m52739h();
            this.f6284p = m52739h;
            jSONObject.put("t3", m52739h);
            String m52738i = C2101n1.m52738i();
            this.f6285q = m52738i;
            jSONObject.put("s1", m52738i);
            String m52737j = C2101n1.m52737j();
            this.f6286r = m52737j;
            jSONObject.put("s2", m52737j);
            String m52736k = C2101n1.m52736k();
            this.f6287s = m52736k;
            jSONObject.put("s3", m52736k);
            String m52735l = C2101n1.m52735l();
            this.f6288t = m52735l;
            jSONObject.put("s4", m52735l);
            jSONObject.put("uuid", C2101n1.m52745b(this.f6418m));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, C2023c1.m53148z());
            jSONObject.put("hostname", C2101n1.m52734m());
            String m53187Q = C2023c1.m53187Q(this.f6418m);
            this.f6289u = m53187Q;
            jSONObject.put("gaid", m53187Q);
            String m53151w = C2023c1.m53151w(this.f6418m);
            this.f6290v = m53151w;
            jSONObject.put("oaid", m53151w);
            this.f6291w = C2101n1.m52743d(C2079j1.m52852y(jSONObject.toString().getBytes("utf-8")), C2079j1.m52857t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f6291w;
    }
}
