package com.amap.api.col.p0463l;

import android.content.Context;
import com.clj.fastble.BleManager;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Hashtable;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.aa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AuthRequest extends AbstractBasicHandler<String, C1739a> {

    /* renamed from: r */
    private boolean f3567r;

    /* renamed from: s */
    private int[] f3568s;

    /* compiled from: AuthRequest.java */
    /* renamed from: com.amap.api.col.3l.aa$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1739a {

        /* renamed from: b */
        public String f3570b;

        /* renamed from: c */
        public String f3571c;

        /* renamed from: a */
        public int f3569a = -1;

        /* renamed from: d */
        public boolean f3572d = false;
    }

    public AuthRequest(Context context, String str) {
        super(context, str);
        this.f3568s = new int[]{BleManager.f22896l, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        this.f5674p = "/feedback";
        this.isPostFlag = false;
        this.f3567r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        r1.f3572d = true;
     */
    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.col.p0463l.AuthRequest.C1739a mo53402e(java.lang.String r6) throws com.amap.api.col.p0463l.AMapException {
        /*
            r5 = this;
            java.lang.String r0 = "errcode"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L41
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            boolean r2 = r1.has(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = ""
            if (r2 == 0) goto L21
            int r6 = r1.optInt(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = "errmsg"
            java.lang.String r3 = r1.optString(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = "errdetail"
            java.lang.String r0 = r1.optString(r0)     // Catch: java.lang.Throwable -> L41
            goto L22
        L21:
            r0 = r3
        L22:
            com.amap.api.col.3l.aa$a r1 = new com.amap.api.col.3l.aa$a     // Catch: java.lang.Throwable -> L41
            r1.<init>()     // Catch: java.lang.Throwable -> L41
            r1.f3569a = r6     // Catch: java.lang.Throwable -> L41
            r1.f3570b = r3     // Catch: java.lang.Throwable -> L41
            r1.f3571c = r0     // Catch: java.lang.Throwable -> L41
            r0 = 0
            r1.f3572d = r0     // Catch: java.lang.Throwable -> L41
            int[] r2 = r5.f3568s     // Catch: java.lang.Throwable -> L41
            int r3 = r2.length     // Catch: java.lang.Throwable -> L41
        L33:
            if (r0 >= r3) goto L40
            r4 = r2[r0]     // Catch: java.lang.Throwable -> L41
            if (r4 != r6) goto L3d
            r6 = 1
            r1.f3572d = r6     // Catch: java.lang.Throwable -> L41
            goto L40
        L3d:
            int r0 = r0 + 1
            goto L33
        L40:
            return r1
        L41:
            r6 = move-exception
            r6.printStackTrace()
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AuthRequest.mo53402e(java.lang.String):com.amap.api.col.3l.aa$a");
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getIPV6URL() {
        return C1732a3.m55685y(getURL());
    }

    @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(this.f5673k));
        if (this.f3567r) {
            hashtable.put("pname", "3dmap");
        }
        String m54933a = ClientInfo.m54933a();
        String m54931c = ClientInfo.m54931c(this.f5673k, m54933a, C1925p4.m54186r(hashtable));
        hashtable.put("ts", m54933a);
        hashtable.put("scode", m54931c);
        return hashtable;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        return "http://restsdk.amap.com/v4" + this.f5674p;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: m */
    protected final String mo53401m() {
        return null;
    }
}
