package com.amap.api.col.p0003l;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CustomStyleRequest.java */
/* renamed from: com.amap.api.col.3l.v1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class v1 extends x3<String, a> {

    /* renamed from: r  reason: collision with root package name */
    private String f9192r;

    /* renamed from: s  reason: collision with root package name */
    private String f9193s;

    /* renamed from: t  reason: collision with root package name */
    private String f9194t;

    /* renamed from: u  reason: collision with root package name */
    private final String f9195u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f9196v;

    /* renamed from: w  reason: collision with root package name */
    private String f9197w;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CustomStyleRequest.java */
    /* renamed from: com.amap.api.col.3l.v1$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f9198a;

        /* renamed from: b  reason: collision with root package name */
        public int f9199b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f9200c = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9201d = false;
    }

    public v1(Context context, String str) {
        super(context, str);
        this.f9193s = "1.0";
        this.f9194t = "0";
        this.f9195u = "lastModified";
        this.f9196v = false;
        this.f9197w = null;
        this.f9405p = "/map/styles";
        this.f9406q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.x3
    /* renamed from: p */
    public a c(y6 y6Var) throws fc {
        List<String> list;
        if (y6Var != null) {
            a f4 = f(y6Var.f9524a);
            f4.f9201d = f4.f9198a != null;
            Map<String, List<String>> map = y6Var.f9525b;
            if (map == null || !map.containsKey("lastModified") || (list = y6Var.f9525b.get("lastModified")) == null || list.size() <= 0) {
                return f4;
            }
            f4.f9200c = list.get(0);
            return f4;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.x3
    /* renamed from: q */
    public a f(byte[] bArr) throws fc {
        a aVar = new a();
        aVar.f9198a = bArr;
        if (this.f9196v && bArr != null) {
            if (bArr.length == 0) {
                aVar.f9198a = null;
            } else if (bArr.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        aVar.f9198a = null;
                    }
                } catch (Exception e4) {
                    u5.p(e4, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
    }

    public final void b(String str) {
        this.f9197w = str;
    }

    public final void d(String str) {
        this.f9194t = str;
    }

    @Override // com.amap.api.col.p0003l.x3
    protected final /* bridge */ /* synthetic */ a e(String str) throws fc {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return a3.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(this.f9404k));
        if (!this.f9196v) {
            hashtable.put("output", "bin");
        } else {
            hashtable.put("sdkType", this.f9197w);
        }
        hashtable.put("styleid", this.f9192r);
        hashtable.put("protocol", this.f9193s);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.f9194t);
        String a4 = h4.a();
        String c4 = h4.c(this.f9404k, a4, q4.r(hashtable));
        hashtable.put("ts", a4);
        hashtable.put("scode", c4);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.x3, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        p4 s3 = a3.s();
        String e4 = s3 != null ? s3.e() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", fa.f7732c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", e4, "3dmap"));
        hashtable.put("x-INFO", h4.b(this.f9404k));
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(this.f9404k));
        hashtable.put("logversion", "2.1");
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

    public final void c(String str) {
        this.f9192r = str;
    }

    public v1(Context context, String str, boolean z3) {
        super(context, str);
        this.f9193s = "1.0";
        this.f9194t = "0";
        this.f9195u = "lastModified";
        this.f9197w = null;
        this.f9196v = z3;
        if (z3) {
            this.f9405p = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            this.f9405p = "/map/styles";
        }
        this.f9406q = true;
    }
}
