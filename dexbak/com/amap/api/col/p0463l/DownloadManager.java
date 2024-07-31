package com.amap.api.col.p0463l;

import com.amap.api.col.p0463l.AbstractC1840if;

/* renamed from: com.amap.api.col.3l.s6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DownloadManager {

    /* renamed from: a */
    private HttpUrlUtil f5287a;

    /* renamed from: b */
    private AbstractC1840if f5288b;

    /* renamed from: c */
    private long f5289c;

    /* renamed from: d */
    private long f5290d;

    /* compiled from: DownloadManager.java */
    /* renamed from: com.amap.api.col.3l.s6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1941a {
        void onDownload(byte[] bArr, long j);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public DownloadManager(AbstractC1840if abstractC1840if) {
        this(abstractC1840if, (byte) 0);
    }

    /* renamed from: a */
    public final void m53928a() {
        HttpUrlUtil httpUrlUtil = this.f5287a;
        if (httpUrlUtil != null) {
            httpUrlUtil.m53759k();
        }
    }

    /* renamed from: b */
    public final void m53927b(InterfaceC1941a interfaceC1941a) {
        try {
            HttpUrlUtil httpUrlUtil = new HttpUrlUtil();
            this.f5287a = httpUrlUtil;
            httpUrlUtil.m53750t(this.f5290d);
            this.f5287a.m53758l(this.f5289c);
            BaseNetManager.m54175b();
            if (BaseNetManager.m54170g(this.f5288b)) {
                this.f5288b.setDegradeType(AbstractC1840if.EnumC1842b.NEVER_GRADE);
                this.f5287a.m53757m(this.f5288b, interfaceC1941a);
                return;
            }
            this.f5288b.setDegradeType(AbstractC1840if.EnumC1842b.DEGRADE_ONLY);
            this.f5287a.m53757m(this.f5288b, interfaceC1941a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DownloadManager(AbstractC1840if abstractC1840if, byte b) {
        this(abstractC1840if, 0L, -1L, false);
    }

    public DownloadManager(AbstractC1840if abstractC1840if, long j, long j2, boolean z) {
        this.f5288b = abstractC1840if;
        this.f5289c = j;
        this.f5290d = j2;
        abstractC1840if.setHttpProtocol(z ? AbstractC1840if.EnumC1843c.HTTPS : AbstractC1840if.EnumC1843c.HTTP);
        this.f5288b.setDegradeAbility(AbstractC1840if.EnumC1841a.SINGLE);
    }
}
