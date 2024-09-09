package com.amap.api.col.p0003l;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Hashtable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AuthRequest.java */
/* renamed from: com.amap.api.col.3l.ba  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ba extends x3<String, a> {

    /* renamed from: r  reason: collision with root package name */
    private boolean f7277r;

    /* renamed from: s  reason: collision with root package name */
    private int[] f7278s;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AuthRequest.java */
    /* renamed from: com.amap.api.col.3l.ba$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f7280b;

        /* renamed from: c  reason: collision with root package name */
        public String f7281c;

        /* renamed from: a  reason: collision with root package name */
        public int f7279a = -1;

        /* renamed from: d  reason: collision with root package name */
        public boolean f7282d = false;
    }

    public ba(Context context, String str) {
        super(context, str);
        this.f7278s = new int[]{10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        this.f9405p = "/feedback";
        this.isPostFlag = false;
        this.f7277r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        r1.f7282d = true;
     */
    @Override // com.amap.api.col.p0003l.x3
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.col.p0003l.ba.a e(java.lang.String r6) throws com.amap.api.col.p0003l.fc {
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
            com.amap.api.col.3l.ba$a r1 = new com.amap.api.col.3l.ba$a     // Catch: java.lang.Throwable -> L41
            r1.<init>()     // Catch: java.lang.Throwable -> L41
            r1.f7279a = r6     // Catch: java.lang.Throwable -> L41
            r1.f7280b = r3     // Catch: java.lang.Throwable -> L41
            r1.f7281c = r0     // Catch: java.lang.Throwable -> L41
            r0 = 0
            r1.f7282d = r0     // Catch: java.lang.Throwable -> L41
            int[] r2 = r5.f7278s     // Catch: java.lang.Throwable -> L41
            int r3 = r2.length     // Catch: java.lang.Throwable -> L41
        L33:
            if (r0 >= r3) goto L40
            r4 = r2[r0]     // Catch: java.lang.Throwable -> L41
            if (r4 != r6) goto L3d
            r6 = 1
            r1.f7282d = r6     // Catch: java.lang.Throwable -> L41
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ba.e(java.lang.String):com.amap.api.col.3l.ba$a");
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return a3.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(this.f9404k));
        if (this.f7277r) {
            hashtable.put("pname", "3dmap");
        }
        String a4 = h4.a();
        String c4 = h4.c(this.f9404k, a4, q4.r(hashtable));
        hashtable.put("ts", a4);
        hashtable.put("scode", c4);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return "http://restsdk.amap.com/v4" + this.f9405p;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0003l.x3
    protected final String m() {
        return null;
    }
}
