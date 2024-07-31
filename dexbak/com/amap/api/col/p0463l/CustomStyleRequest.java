package com.amap.api.col.p0463l;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.v1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CustomStyleRequest extends AbstractBasicHandler<String, C1967a> {

    /* renamed from: r */
    private String f5537r;

    /* renamed from: s */
    private String f5538s;

    /* renamed from: t */
    private String f5539t;

    /* renamed from: u */
    private final String f5540u;

    /* renamed from: v */
    private boolean f5541v;

    /* renamed from: w */
    private String f5542w;

    /* compiled from: CustomStyleRequest.java */
    /* renamed from: com.amap.api.col.3l.v1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1967a {

        /* renamed from: a */
        public byte[] f5543a;

        /* renamed from: b */
        public int f5544b = -1;

        /* renamed from: c */
        public String f5545c = null;

        /* renamed from: d */
        public boolean f5546d = false;
    }

    public CustomStyleRequest(Context context, String str) {
        super(context, str);
        this.f5538s = "1.0";
        this.f5539t = "0";
        this.f5540u = "lastModified";
        this.f5541v = false;
        this.f5542w = null;
        this.f5674p = "/map/styles";
        this.f5675q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: p */
    public C1967a mo53539c(ResponseEntity responseEntity) throws AMapException {
        List<String> list;
        if (responseEntity != null) {
            C1967a mo53538f = mo53538f(responseEntity.f5682a);
            mo53538f.f5546d = mo53538f.f5543a != null;
            Map<String, List<String>> map = responseEntity.f5683b;
            if (map == null || !map.containsKey("lastModified") || (list = responseEntity.f5683b.get("lastModified")) == null || list.size() <= 0) {
                return mo53538f;
            }
            mo53538f.f5545c = list.get(0);
            return mo53538f;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: q */
    public C1967a mo53538f(byte[] bArr) throws AMapException {
        C1967a c1967a = new C1967a();
        c1967a.f5543a = bArr;
        if (this.f5541v && bArr != null) {
            if (bArr.length == 0) {
                c1967a.f5543a = null;
            } else if (bArr.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        c1967a.f5543a = null;
                    }
                } catch (Exception e) {
                    SDKLogHandler.m53863p(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return c1967a;
    }

    /* renamed from: b */
    public final void m53670b(String str) {
        this.f5542w = str;
    }

    /* renamed from: d */
    public final void m53668d(String str) {
        this.f5539t = str;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: e */
    protected final /* bridge */ /* synthetic */ C1967a mo53402e(String str) throws AMapException {
        return null;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getIPV6URL() {
        return C1732a3.m55685y(getURL());
    }

    @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(this.f5673k));
        if (!this.f5541v) {
            hashtable.put("output", "bin");
        } else {
            hashtable.put("sdkType", this.f5542w);
        }
        hashtable.put("styleid", this.f5537r);
        hashtable.put("protocol", this.f5538s);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.f5539t);
        String m54933a = ClientInfo.m54933a();
        String m54931c = ClientInfo.m54931c(this.f5673k, m54933a, C1925p4.m54186r(hashtable));
        hashtable.put("ts", m54933a);
        hashtable.put("scode", m54931c);
        return hashtable;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler, com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getRequestHead() {
        SDKInfo m55691s = C1732a3.m55691s();
        String m54396e = m55691s != null ? m55691s.m54396e() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", ConfigableConst.f3943c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", m54396e, "3dmap"));
        hashtable.put("x-INFO", ClientInfo.m54932b(this.f5673k));
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(this.f5673k));
        hashtable.put("logversion", "2.1");
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

    /* renamed from: c */
    public final void m53669c(String str) {
        this.f5537r = str;
    }

    public CustomStyleRequest(Context context, String str, boolean z) {
        super(context, str);
        this.f5538s = "1.0";
        this.f5539t = "0";
        this.f5540u = "lastModified";
        this.f5542w = null;
        this.f5541v = z;
        if (z) {
            this.f5674p = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            this.f5674p = "/map/styles";
        }
        this.f5675q = true;
    }
}
