package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.DownloadManager;
import com.amap.api.col.p0463l.IDownloadListener;
import com.amap.api.col.p0463l.Privacy;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.w0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NetFileFetch implements DownloadManager.InterfaceC1941a {

    /* renamed from: a */
    SiteInfoBean f5579a;

    /* renamed from: d */
    long f5582d;

    /* renamed from: f */
    private Context f5584f;

    /* renamed from: g */
    OfflineDBOperation f5585g;

    /* renamed from: h */
    private IDownloadListener f5586h;

    /* renamed from: i */
    private String f5587i;

    /* renamed from: j */
    private TimeoutDownloadManager f5588j;

    /* renamed from: k */
    private FileAccessI f5589k;

    /* renamed from: n */
    InterfaceC1977a f5592n;

    /* renamed from: b */
    long f5580b = 0;

    /* renamed from: c */
    long f5581c = 0;

    /* renamed from: e */
    boolean f5583e = true;

    /* renamed from: l */
    long f5590l = 0;

    /* renamed from: m */
    private boolean f5591m = false;

    /* compiled from: NetFileFetch.java */
    /* renamed from: com.amap.api.col.3l.w0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1977a {
        /* renamed from: c */
        void mo53612c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NetFileFetch.java */
    /* renamed from: com.amap.api.col.3l.w0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1978b extends AbstractAMapRequest {

        /* renamed from: i */
        private final String f5593i;

        public C1978b(String str) {
            this.f5593i = str;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getURL() {
            return this.f5593i;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public NetFileFetch(SiteInfoBean siteInfoBean, String str, Context context, IDownloadListener iDownloadListener) throws IOException {
        this.f5579a = null;
        this.f5585g = OfflineDBOperation.m54085b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f5579a = siteInfoBean;
        this.f5584f = context;
        this.f5587i = str;
        this.f5586h = iDownloadListener;
        m53618f();
    }

    /* renamed from: b */
    private void m53622b(long j) {
        IDownloadListener iDownloadListener;
        long j2 = this.f5582d;
        if (j2 <= 0 || (iDownloadListener = this.f5586h) == null) {
            return;
        }
        iDownloadListener.mo55528a(j2, j);
        this.f5590l = System.currentTimeMillis();
    }

    /* renamed from: e */
    private void m53619e() throws IOException {
        OfflineDownloadRequest offlineDownloadRequest = new OfflineDownloadRequest(this.f5587i);
        offlineDownloadRequest.setConnectionTimeout(30000);
        offlineDownloadRequest.setSoTimeout(30000);
        this.f5588j = new TimeoutDownloadManager(offlineDownloadRequest, this.f5580b, this.f5581c, MapsInitializer.getProtocol() == 2);
        this.f5589k = new FileAccessI(this.f5579a.m53566b() + File.separator + this.f5579a.m53565c(), this.f5580b);
    }

    /* renamed from: f */
    private void m53618f() {
        File file = new File(this.f5579a.m53566b() + this.f5579a.m53565c());
        if (file.exists()) {
            this.f5583e = false;
            this.f5580b = file.length();
            try {
                long m53615i = m53615i();
                this.f5582d = m53615i;
                this.f5581c = m53615i;
                return;
            } catch (IOException unused) {
                IDownloadListener iDownloadListener = this.f5586h;
                if (iDownloadListener != null) {
                    iDownloadListener.mo55527a(IDownloadListener.EnumC1754a.file_io_exception);
                    return;
                }
                return;
            }
        }
        this.f5580b = 0L;
        this.f5581c = 0L;
    }

    /* renamed from: g */
    private boolean m53617g() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5579a.m53566b());
        sb.append(File.separator);
        sb.append(this.f5579a.m53565c());
        return new File(sb.toString()).length() >= 10;
    }

    /* renamed from: h */
    private void m53616h() throws AMapException {
        if (AuthConfigManager.f4097a != 1) {
            for (int i = 0; i < 3; i++) {
                try {
                    AuthConfigManager.m55061c(this.f5584f, C1732a3.m55691s(), "", null);
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
                if (AuthConfigManager.f4097a == 1) {
                    return;
                }
            }
        }
    }

    /* renamed from: i */
    private long m53615i() throws IOException {
        if (Privacy.m54995a(this.f5584f, C1732a3.m55691s()).f4676a != Privacy.EnumC1812c.SuccessCode) {
            return -1L;
        }
        String m53567a = this.f5579a.m53567a();
        Map<String, String> map = null;
        try {
            NetManger.m53582n();
            map = NetManger.m53579q(new C1978b(m53567a), MapsInitializer.getProtocol() == 2);
        } catch (AMapCoreException e) {
            e.printStackTrace();
        }
        int i = -1;
        if (map != null) {
            for (String str : map.keySet()) {
                if ("Content-Length".equalsIgnoreCase(str)) {
                    i = Integer.parseInt(map.get(str));
                }
            }
        }
        return i;
    }

    /* renamed from: j */
    private void m53614j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f5579a == null || currentTimeMillis - this.f5590l <= 500) {
            return;
        }
        m53613k();
        this.f5590l = currentTimeMillis;
        m53622b(this.f5580b);
    }

    /* renamed from: k */
    private void m53613k() {
        this.f5585g.m54081f(this.f5579a.m53563e(), this.f5579a.m53564d(), this.f5582d, this.f5580b, this.f5581c);
    }

    /* renamed from: a */
    public final void m53623a() {
        try {
            if (C1732a3.m55703h0(this.f5584f)) {
                m53616h();
                if (AuthConfigManager.f4097a != 1) {
                    IDownloadListener iDownloadListener = this.f5586h;
                    if (iDownloadListener != null) {
                        iDownloadListener.mo55527a(IDownloadListener.EnumC1754a.amap_exception);
                        return;
                    }
                    return;
                }
                if (!m53617g()) {
                    this.f5583e = true;
                }
                if (this.f5583e) {
                    long m53615i = m53615i();
                    this.f5582d = m53615i;
                    if (m53615i != -1 && m53615i != -2) {
                        this.f5581c = m53615i;
                    }
                    this.f5580b = 0L;
                }
                IDownloadListener iDownloadListener2 = this.f5586h;
                if (iDownloadListener2 != null) {
                    iDownloadListener2.mo55526m();
                }
                if (this.f5580b >= this.f5581c) {
                    onFinish();
                    return;
                }
                m53619e();
                this.f5588j.m53927b(this);
                return;
            }
            IDownloadListener iDownloadListener3 = this.f5586h;
            if (iDownloadListener3 != null) {
                iDownloadListener3.mo55527a(IDownloadListener.EnumC1754a.network_exception);
            }
        } catch (AMapException e) {
            SDKLogHandler.m53863p(e, "SiteFileFetch", "download");
            IDownloadListener iDownloadListener4 = this.f5586h;
            if (iDownloadListener4 != null) {
                iDownloadListener4.mo55527a(IDownloadListener.EnumC1754a.amap_exception);
            }
        } catch (IOException unused) {
            IDownloadListener iDownloadListener5 = this.f5586h;
            if (iDownloadListener5 != null) {
                iDownloadListener5.mo55527a(IDownloadListener.EnumC1754a.file_io_exception);
            }
        }
    }

    /* renamed from: c */
    public final void m53621c(InterfaceC1977a interfaceC1977a) {
        this.f5592n = interfaceC1977a;
    }

    /* renamed from: d */
    public final void m53620d() {
        TimeoutDownloadManager timeoutDownloadManager = this.f5588j;
        if (timeoutDownloadManager != null) {
            timeoutDownloadManager.m53928a();
        }
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public final void onDownload(byte[] bArr, long j) {
        try {
            this.f5589k.m54014a(bArr);
            this.f5580b = j;
            m53614j();
        } catch (IOException e) {
            e.printStackTrace();
            SDKLogHandler.m53863p(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            IDownloadListener iDownloadListener = this.f5586h;
            if (iDownloadListener != null) {
                iDownloadListener.mo55527a(IDownloadListener.EnumC1754a.file_io_exception);
            }
            TimeoutDownloadManager timeoutDownloadManager = this.f5588j;
            if (timeoutDownloadManager != null) {
                timeoutDownloadManager.m53928a();
            }
        }
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public final void onException(Throwable th) {
        FileAccessI fileAccessI;
        this.f5591m = true;
        m53620d();
        IDownloadListener iDownloadListener = this.f5586h;
        if (iDownloadListener != null) {
            iDownloadListener.mo55527a(IDownloadListener.EnumC1754a.network_exception);
        }
        if ((th instanceof IOException) || (fileAccessI = this.f5589k) == null) {
            return;
        }
        fileAccessI.m54013b();
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public final void onFinish() {
        m53614j();
        IDownloadListener iDownloadListener = this.f5586h;
        if (iDownloadListener != null) {
            iDownloadListener.mo55525n();
        }
        FileAccessI fileAccessI = this.f5589k;
        if (fileAccessI != null) {
            fileAccessI.m54013b();
        }
        InterfaceC1977a interfaceC1977a = this.f5592n;
        if (interfaceC1977a != null) {
            interfaceC1977a.mo53612c();
        }
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public final void onStop() {
        if (this.f5591m) {
            return;
        }
        IDownloadListener iDownloadListener = this.f5586h;
        if (iDownloadListener != null) {
            iDownloadListener.mo55524o();
        }
        m53613k();
    }
}
