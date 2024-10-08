package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: AAIDRemapRequest.java */
/* renamed from: com.amap.api.col.s.p1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2115p1 extends C2128r1 {

    /* renamed from: n */
    public String f6356n;

    /* renamed from: o */
    public String f6357o;

    /* renamed from: p */
    public String f6358p;

    /* renamed from: q */
    public String f6359q;

    /* renamed from: r */
    public String f6360r;

    /* renamed from: s */
    public String f6361s;

    /* renamed from: t */
    public String f6362t;

    /* renamed from: u */
    public String f6363u;

    /* renamed from: v */
    public String f6364v;

    /* renamed from: w */
    protected byte[] f6365w;

    public C2115p1(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: q */
    public final byte[] mo52382q() {
        byte[] bArr = this.f6365w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "remap");
            jSONObject.put("package_name", C2199x0.m52330f(this.f6418m));
            jSONObject.put(C2624bk.f8685i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.5");
            String m52746a = C2101n1.m52746a();
            this.f6356n = m52746a;
            jSONObject.put("t1", m52746a);
            jSONObject.put("old_t1", C2085k1.m52793n(this.f6418m));
            String m52742e = C2101n1.m52742e();
            this.f6357o = m52742e;
            jSONObject.put("t2", m52742e);
            jSONObject.put("old_t2", C2085k1.m52791p(this.f6418m));
            String m52739h = C2101n1.m52739h();
            this.f6358p = m52739h;
            jSONObject.put("t3", m52739h);
            jSONObject.put("old_t3", C2085k1.m52789r(this.f6418m));
            String m52738i = C2101n1.m52738i();
            this.f6359q = m52738i;
            jSONObject.put("s1", m52738i);
            jSONObject.put("old_s1", C2085k1.m52787t(this.f6418m));
            String m52737j = C2101n1.m52737j();
            this.f6360r = m52737j;
            jSONObject.put("s2", m52737j);
            jSONObject.put("old_s2", C2085k1.m52785v(this.f6418m));
            String m52736k = C2101n1.m52736k();
            this.f6361s = m52736k;
            jSONObject.put("s3", m52736k);
            jSONObject.put("old_s3", C2085k1.m52783x(this.f6418m));
            String m52735l = C2101n1.m52735l();
            this.f6362t = m52735l;
            jSONObject.put("s4", m52735l);
            jSONObject.put("old_s4", C2085k1.m52781z(this.f6418m));
            jSONObject.put("uuid", C2101n1.m52745b(this.f6418m));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, C2023c1.m53148z());
            jSONObject.put("hostname", C2101n1.m52734m());
            String m53187Q = C2023c1.m53187Q(this.f6418m);
            this.f6363u = m53187Q;
            jSONObject.put("gaid", m53187Q);
            jSONObject.put("old_gaid", C2085k1.m52807B(this.f6418m));
            String m53151w = C2023c1.m53151w(this.f6418m);
            this.f6364v = m53151w;
            jSONObject.put("oaid", m53151w);
            jSONObject.put("old_oaid", C2085k1.m52803d(this.f6418m));
            jSONObject.put("aaid", C2085k1.m52801f(this.f6418m));
            jSONObject.put("resetToken", C2085k1.m52795l(this.f6418m));
            jSONObject.put("uabc", C2085k1.m52797j(this.f6418m));
            this.f6365w = C2101n1.m52743d(C2079j1.m52852y(jSONObject.toString().getBytes("utf-8")), C2079j1.m52857t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f6365w;
    }
}
