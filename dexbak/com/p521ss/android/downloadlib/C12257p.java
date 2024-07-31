package com.p521ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.p521ss.android.download.api.InterfaceC11990ok;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;
import com.p521ss.android.download.api.config.InterfaceC11960kf;
import com.p521ss.android.download.api.config.OnItemClickListener;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.DownloadStatusChangeListener;
import com.p521ss.android.download.api.download.p524ok.InterfaceC11979ok;
import com.p521ss.android.downloadad.api.InterfaceC11996a;
import com.p521ss.android.downloadad.api.InterfaceC11997ok;
import com.p521ss.android.downloadlib.addownload.C12090j;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.p533bl.C12168h;
import com.p521ss.android.downloadlib.p533bl.C12172kf;
import com.p521ss.android.downloadlib.p533bl.C12173n;
import com.p521ss.android.downloadlib.p533bl.C12181s;
import com.p521ss.android.downloadlib.p535kf.C12222bl;
import com.p521ss.android.downloadlib.p536n.C12232a;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.downloadlib.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12257p {

    /* renamed from: ok */
    private static volatile C12257p f34566ok;

    /* renamed from: a */
    private final InterfaceC11990ok f34567a;

    /* renamed from: bl */
    private final C12184h f34568bl;

    /* renamed from: kf */
    private long f34569kf;

    /* renamed from: n */
    private InterfaceC11996a f34570n;

    /* renamed from: s */
    private final InterfaceC11997ok f34571s;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public C12184h m18561p() {
        return this.f34568bl;
    }

    /* renamed from: bl */
    public void m18577bl() {
        this.f34569kf = System.currentTimeMillis();
    }

    /* renamed from: h */
    public void m18576h() {
        C12265s.m18554ok().m18555n();
    }

    /* renamed from: kf */
    public String m18575kf() {
        return C12128r.m18944rh();
    }

    /* renamed from: n */
    public InterfaceC11996a m18574n() {
        if (this.f34570n == null) {
            this.f34570n = C12000a.m19423ok();
        }
        return this.f34570n;
    }

    /* renamed from: s */
    public InterfaceC11997ok m18560s() {
        return this.f34571s;
    }

    private C12257p(Context context) {
        this.f34568bl = C12184h.m18835ok();
        this.f34567a = new C12228n();
        this.f34569kf = System.currentTimeMillis();
        m18580a(context);
        this.f34571s = C12238ok.m18626ok();
    }

    /* renamed from: a */
    private void m18580a(Context context) {
        C12128r.m18958ok(context);
        Downloader.getInstance(C12128r.getContext());
        C12032kf.m19324ok().m19333a();
        C12361s.m18068k().m18060ok(C12128r.getContext(), "misc_config", new C12168h(), new C12172kf(context), new C12162bl());
        C12181s c12181s = new C12181s();
        C12361s.m18068k().m18058ok(c12181s);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(c12181s);
        C12361s.m18068k().m18050ok(new C12090j());
        C12490bl.m17780ok(new C12173n());
        C12361s.m18068k().m18057ok(C12222bl.m18668ok());
    }

    /* renamed from: ok */
    public static C12257p m18572ok(final Context context) {
        if (f34566ok == null) {
            synchronized (C12257p.class) {
                if (f34566ok == null) {
                    C12232a.m18648ok(new Runnable() { // from class: com.ss.android.downloadlib.p.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C12257p unused = C12257p.f34566ok = new C12257p(context);
                        }
                    });
                }
            }
        }
        return f34566ok;
    }

    /* renamed from: ok */
    public InterfaceC11990ok m18573ok() {
        return this.f34567a;
    }

    /* renamed from: ok */
    public InterfaceC11990ok m18568ok(String str) {
        InterfaceC11960kf m18670a = C12220kf.m18669ok().m18670a();
        if (m18670a != null && m18670a.m19650ok(str)) {
            return m18670a.m19651a(str);
        }
        return this.f34567a;
    }

    /* renamed from: a */
    public long m18581a() {
        return this.f34569kf;
    }

    /* renamed from: a */
    public DownloadInfo m18578a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return C12361s.m18068k().m18061ok(C12128r.getContext(), str);
    }

    @MainThread
    /* renamed from: ok */
    public void m18571ok(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        C12232a.m18648ok(new Runnable() { // from class: com.ss.android.downloadlib.p.4
            @Override // java.lang.Runnable
            public void run() {
                C12257p.this.m18561p().m18834ok(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    @MainThread
    /* renamed from: ok */
    public void m18564ok(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        C12232a.m18648ok(new Runnable() { // from class: com.ss.android.downloadlib.p.5
            @Override // java.lang.Runnable
            public void run() {
                C12257p.this.m18561p().m18822ok(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    /* renamed from: ok */
    public void m18566ok(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        C12232a.m18648ok(new Runnable() { // from class: com.ss.android.downloadlib.p.6
            @Override // java.lang.Runnable
            public void run() {
                C12257p.this.m18561p().m18824ok(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    /* renamed from: ok */
    public void m18565ok(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        C12232a.m18648ok(new Runnable() { // from class: com.ss.android.downloadlib.p.7
            @Override // java.lang.Runnable
            public void run() {
                C12257p.this.m18561p().m18823ok(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    /* renamed from: ok */
    public void m18567ok(final String str, final int i) {
        C12232a.m18648ok(new Runnable() { // from class: com.ss.android.downloadlib.p.2
            @Override // java.lang.Runnable
            public void run() {
                C12257p.this.m18561p().m18825ok(str, i);
            }
        });
    }

    @MainThread
    /* renamed from: ok */
    public void m18562ok(final String str, final boolean z) {
        C12232a.m18648ok(new Runnable() { // from class: com.ss.android.downloadlib.p.3
            @Override // java.lang.Runnable
            public void run() {
                C12257p.this.m18561p().m18821ok(str, z);
            }
        });
    }

    /* renamed from: ok */
    public void m18570ok(InterfaceC11979ok interfaceC11979ok) {
        m18561p().m18831ok(interfaceC11979ok);
    }

    /* renamed from: ok */
    public DownloadInfo m18563ok(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return m18578a(str);
        }
        return Downloader.getInstance(C12128r.getContext()).getDownloadInfo(str, str2);
    }
}
