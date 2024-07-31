package com.amap.api.col.p0463l;

import android.content.Context;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.3l.d7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OfflineLocEntity {

    /* renamed from: a */
    private Context f3876a;

    /* renamed from: b */
    private SDKInfo f3877b;

    /* renamed from: c */
    private String f3878c;

    public OfflineLocEntity(Context context, SDKInfo sDKInfo, String str) {
        this.f3876a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f3877b = sDKInfo;
        this.f3878c = str;
    }

    /* renamed from: a */
    private static String m55280a(Context context, SDKInfo sDKInfo, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(sDKInfo.m54395f());
            sb.append("\",\"product\":\"");
            sb.append(sDKInfo.m54400a());
            sb.append("\",\"nt\":\"");
            sb.append(DeviceInfo.m54759y(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final byte[] m55279b() {
        return C1925p4.m54189o(m55280a(this.f3876a, this.f3877b, this.f3878c));
    }
}
