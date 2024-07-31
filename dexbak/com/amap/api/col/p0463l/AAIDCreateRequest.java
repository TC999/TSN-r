package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.t4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AAIDCreateRequest extends BaseAAIDRequest {

    /* renamed from: j */
    public String f5370j;

    /* renamed from: k */
    public String f5371k;

    /* renamed from: p */
    public String f5372p;

    /* renamed from: q */
    public String f5373q;

    /* renamed from: r */
    public String f5374r;

    /* renamed from: s */
    public String f5375s;

    /* renamed from: t */
    public String f5376t;

    /* renamed from: u */
    public String f5377u;

    /* renamed from: v */
    public String f5378v;

    /* renamed from: w */
    protected byte[] f5379w;

    public AAIDCreateRequest(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f5379w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "create");
            jSONObject.put("package_name", C1780e4.m55243g(this.f5786i));
            jSONObject.put(C2624bk.f8685i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.11");
            String m53800a = AAIDKeyFactorUtil.m53800a();
            this.f5370j = m53800a;
            jSONObject.put("t1", m53800a);
            String m53796e = AAIDKeyFactorUtil.m53796e();
            this.f5371k = m53796e;
            jSONObject.put("t2", m53796e);
            String m53793h = AAIDKeyFactorUtil.m53793h();
            this.f5372p = m53793h;
            jSONObject.put("t3", m53793h);
            String m53792i = AAIDKeyFactorUtil.m53792i();
            this.f5373q = m53792i;
            jSONObject.put("s1", m53792i);
            String m53791j = AAIDKeyFactorUtil.m53791j();
            this.f5374r = m53791j;
            jSONObject.put("s2", m53791j);
            String m53790k = AAIDKeyFactorUtil.m53790k();
            this.f5375s = m53790k;
            jSONObject.put("s3", m53790k);
            String m53789l = AAIDKeyFactorUtil.m53789l();
            this.f5376t = m53789l;
            jSONObject.put("s4", m53789l);
            jSONObject.put("uuid", AAIDKeyFactorUtil.m53799b(this.f5786i));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceInfo.m54815G());
            jSONObject.put("hostname", AAIDKeyFactorUtil.m53788m());
            String m54784f0 = DeviceInfo.m54784f0(this.f5786i);
            this.f5377u = m54784f0;
            jSONObject.put("gaid", m54784f0);
            String m54818D = DeviceInfo.m54818D(this.f5786i);
            this.f5378v = m54818D;
            jSONObject.put("oaid", m54818D);
            this.f5379w = AAIDKeyFactorUtil.m53797d(C1925p4.m54178z(jSONObject.toString().getBytes("utf-8")), C1925p4.m54183u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f5379w;
    }
}
