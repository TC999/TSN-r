package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.p0463l.IDownloadListener;
import com.amap.api.col.p0463l.NetFileFetch;
import java.io.IOException;

/* renamed from: com.amap.api.col.3l.h0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OfflineMapDownloadTask extends ThreadTask implements NetFileFetch.InterfaceC1977a {

    /* renamed from: a */
    private NetFileFetch f4384a;

    /* renamed from: b */
    private UnZipFile f4385b;

    /* renamed from: c */
    private IDownloadItem f4386c;

    /* renamed from: d */
    private Context f4387d;

    /* renamed from: e */
    private Bundle f4388e;

    /* renamed from: g */
    private boolean f4389g;

    private OfflineMapDownloadTask(IDownloadItem iDownloadItem, Context context) {
        this.f4388e = new Bundle();
        this.f4389g = false;
        this.f4386c = iDownloadItem;
        this.f4387d = context;
    }

    /* renamed from: d */
    private String m54859d() {
        return C1732a3.m55707f0(this.f4387d);
    }

    /* renamed from: e */
    private void m54858e() throws IOException {
        NetFileFetch netFileFetch = new NetFileFetch(new SiteInfoBean(this.f4386c.getUrl(), m54859d(), this.f4386c.mo55568v(), this.f4386c.mo55567w()), this.f4386c.getUrl(), this.f4387d, this.f4386c);
        this.f4384a = netFileFetch;
        netFileFetch.m53621c(this);
        IDownloadItem iDownloadItem = this.f4386c;
        this.f4385b = new UnZipFile(iDownloadItem, iDownloadItem);
        if (this.f4389g) {
            return;
        }
        this.f4384a.m53623a();
    }

    /* renamed from: a */
    public final void m54861a() {
        this.f4389g = true;
        NetFileFetch netFileFetch = this.f4384a;
        if (netFileFetch != null) {
            netFileFetch.m53620d();
        } else {
            cancelTask();
        }
        UnZipFile unZipFile = this.f4385b;
        if (unZipFile != null) {
            unZipFile.m53430b();
        }
    }

    /* renamed from: b */
    public final void m54860b() {
        Bundle bundle = this.f4388e;
        if (bundle != null) {
            bundle.clear();
            this.f4388e = null;
        }
    }

    @Override // com.amap.api.col.p0463l.NetFileFetch.InterfaceC1977a
    /* renamed from: c */
    public final void mo53612c() {
        UnZipFile unZipFile = this.f4385b;
        if (unZipFile != null) {
            unZipFile.m53424h();
        }
    }

    @Override // com.amap.api.col.p0463l.ThreadTask
    public final void runTask() {
        if (this.f4386c.mo55569u()) {
            this.f4386c.mo55527a(IDownloadListener.EnumC1754a.file_io_exception);
            return;
        }
        try {
            m54858e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public OfflineMapDownloadTask(IDownloadItem iDownloadItem, Context context, byte b) {
        this(iDownloadItem, context);
    }
}
