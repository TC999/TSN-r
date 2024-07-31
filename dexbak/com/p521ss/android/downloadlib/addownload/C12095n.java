package com.p521ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p205p0.C7282g;
import com.p521ss.android.download.api.config.C11962ok;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;
import com.p521ss.android.download.api.config.InterfaceC11970u;
import com.p521ss.android.download.api.config.OnItemClickListener;
import com.p521ss.android.download.api.download.C11974a;
import com.p521ss.android.download.api.download.C11975bl;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.DownloadStatusChangeListener;
import com.p521ss.android.download.api.model.DownloadShortInfo;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.downloadlib.addownload.C12121p;
import com.p521ss.android.downloadlib.addownload.compliance.C12058a;
import com.p521ss.android.downloadlib.addownload.compliance.C12067kf;
import com.p521ss.android.downloadlib.addownload.compliance.InterfaceC12083p;
import com.p521ss.android.downloadlib.addownload.p528a.C12030bl;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.addownload.p528a.C12037p;
import com.p521ss.android.downloadlib.addownload.p528a.C12038q;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl;
import com.p521ss.android.downloadlib.addownload.p532s.C12157r;
import com.p521ss.android.downloadlib.addownload.p532s.C12158s;
import com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12155p;
import com.p521ss.android.downloadlib.p533bl.C12176p;
import com.p521ss.android.downloadlib.p534h.C12190a;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12198k;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p534h.C12205p;
import com.p521ss.android.downloadlib.p534h.C12215q;
import com.p521ss.android.downloadlib.p534h.C12216r;
import com.p521ss.android.downloadlib.p534h.HandlerC12218z;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12095n implements InterfaceC12089h, HandlerC12218z.InterfaceC12219ok {

    /* renamed from: ok */
    private static final String f34220ok = "n";

    /* renamed from: a */
    private final HandlerC12218z f34221a;

    /* renamed from: bl */
    private C12121p f34222bl;

    /* renamed from: h */
    private DownloadShortInfo f34223h;

    /* renamed from: i */
    private DownloadEventConfig f34224i;

    /* renamed from: io */
    private SoftReference<IDownloadButtonClickListener> f34225io;

    /* renamed from: j */
    private long f34226j;

    /* renamed from: k */
    private final IDownloadListener f34227k;

    /* renamed from: kf */
    private final Map<Integer, Object> f34228kf;

    /* renamed from: n */
    private WeakReference<Context> f34229n;

    /* renamed from: p */
    private DownloadInfo f34230p;

    /* renamed from: q */
    private AsyncTaskC12106bl f34231q;

    /* renamed from: r */
    private boolean f34232r;

    /* renamed from: rh */
    private long f34233rh;

    /* renamed from: s */
    private C12134s f34234s;

    /* renamed from: t */
    private DownloadModel f34235t;

    /* renamed from: td */
    private SoftReference<OnItemClickListener> f34236td;

    /* renamed from: u */
    private final boolean f34237u;

    /* renamed from: x */
    private DownloadController f34238x;

    /* renamed from: z */
    private String f34239z;

    /* renamed from: zz */
    private boolean f34240zz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.downloadlib.addownload.n$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12105a {
        /* renamed from: ok */
        void mo18911ok(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.downloadlib.addownload.n$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12107ok {
        /* renamed from: ok */
        void mo19048ok();
    }

    public C12095n() {
        HandlerC12218z handlerC12218z = new HandlerC12218z(Looper.getMainLooper(), this);
        this.f34221a = handlerC12218z;
        this.f34228kf = new ConcurrentHashMap();
        this.f34227k = new C12121p.C12126ok(handlerC12218z);
        this.f34233rh = -1L;
        this.f34235t = null;
        this.f34224i = null;
        this.f34238x = null;
        this.f34222bl = new C12121p(this);
        this.f34234s = new C12134s(handlerC12218z);
        this.f34237u = C12534ok.m17605bl().m17595ok("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.f34229n;
        if (weakReference != null && weakReference.get() != null) {
            return this.f34229n.get();
        }
        return C12128r.getContext();
    }

    /* renamed from: i */
    private void m19094i() {
        AsyncTaskC12106bl asyncTaskC12106bl = this.f34231q;
        if (asyncTaskC12106bl != null && asyncTaskC12106bl.getStatus() != AsyncTask.Status.FINISHED) {
            this.f34231q.cancel(true);
        }
        this.f34231q = new AsyncTaskC12106bl();
        if (!TextUtils.isEmpty(this.f34239z)) {
            C12190a.m18819ok(this.f34231q, this.f34235t.getDownloadUrl(), this.f34235t.getPackageName(), this.f34239z);
        } else {
            C12190a.m18819ok(this.f34231q, this.f34235t.getDownloadUrl(), this.f34235t.getPackageName());
        }
    }

    @NonNull
    /* renamed from: j */
    private DownloadEventConfig m19093j() {
        DownloadEventConfig downloadEventConfig = this.f34224i;
        return downloadEventConfig == null ? new C11975bl.C11977ok().m19626ok() : downloadEventConfig;
    }

    /* renamed from: r */
    private void m19060r() {
        SoftReference<OnItemClickListener> softReference = this.f34236td;
        if (softReference != null && softReference.get() != null) {
            this.f34236td.get().onItemClick(this.f34235t, m19093j(), m19053z());
            this.f34236td = null;
            return;
        }
        C12128r.m18970a().mo18935ok(getContext(), this.f34235t, m19053z(), m19093j());
    }

    /* renamed from: rh */
    private void m19059rh() {
        String str = f34220ok;
        C12216r.m18673ok(str, "pICD", null);
        if (this.f34222bl.m18985s(this.f34230p)) {
            C12216r.m18673ok(str, "pICD BC", null);
            m19088kf(false);
            return;
        }
        C12216r.m18673ok(str, "pICD IC", null);
        m19060r();
    }

    /* renamed from: t */
    private boolean m19055t() {
        if (C12534ok.m17605bl().m17595ok("fix_click_start")) {
            DownloadInfo downloadInfo = this.f34230p;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.f34230p.getCurBytes() <= 0) || this.f34230p.getStatus() == 0 || this.f34230p.getStatus() == -4) {
                return true;
            }
            return C12713kf.m16572ok(this.f34230p.getStatus(), this.f34230p.getSavePath(), this.f34230p.getName());
        }
        DownloadInfo downloadInfo2 = this.f34230p;
        if (downloadInfo2 == null) {
            return true;
        }
        return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(C12128r.getContext()).canResume(this.f34230p.getId())) || this.f34230p.getStatus() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public DownloadShortInfo m19054x() {
        if (this.f34223h == null) {
            this.f34223h = new DownloadShortInfo();
        }
        return this.f34223h;
    }

    @NonNull
    /* renamed from: z */
    private DownloadController m19053z() {
        if (this.f34238x == null) {
            this.f34238x = new C11974a();
        }
        return this.f34238x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m19095h(final boolean z) {
        this.f34234s.m18921ok(new C12035n(this.f34233rh, this.f34235t, m19093j(), m19053z()));
        this.f34234s.m18926ok(0, 0L, 0L, new InterfaceC12107ok() { // from class: com.ss.android.downloadlib.addownload.n.9
            @Override // com.p521ss.android.downloadlib.addownload.C12095n.InterfaceC12107ok
            /* renamed from: ok */
            public void mo19048ok() {
                if (C12095n.this.f34234s.m18928ok()) {
                    return;
                }
                C12095n.this.m19063p(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m19063p(boolean z) {
        for (DownloadStatusChangeListener downloadStatusChangeListener : C12121p.m18988ok(this.f34228kf)) {
            downloadStatusChangeListener.onDownloadStart(this.f34235t, m19053z());
        }
        int m18997ok = this.f34222bl.m18997ok(C12128r.getContext(), this.f34227k);
        String str = f34220ok;
        C12216r.m18673ok(str, "beginDown id:" + m18997ok, null);
        if (m18997ok != 0) {
            if (this.f34230p != null && !C12534ok.m17605bl().m17595ok("fix_click_start")) {
                this.f34222bl.m18990ok(this.f34230p, false);
            } else if (z) {
                this.f34222bl.m19002ok();
            }
        } else {
            DownloadInfo m17104ok = new DownloadInfo.C12595ok(this.f34235t.getDownloadUrl()).m17104ok();
            m17104ok.setStatus(-1);
            m19069ok(m17104ok);
            C12270ok.m18539ok().m18535ok(this.f34233rh, new BaseException(2, "start download failed, id=0"));
            C12235bl.m18640ok().m18643a("beginDown");
        }
        if (this.f34222bl.m18987ok(m19101bl())) {
            C12216r.m18673ok(str, "beginDown IC id:" + m18997ok, null);
            m19060r();
        }
    }

    /* renamed from: bl */
    public boolean m19101bl() {
        DownloadInfo downloadInfo = this.f34230p;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    /* renamed from: kf */
    public void m19090kf() {
        this.f34221a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.n.2
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadStatusChangeListener downloadStatusChangeListener : C12121p.m18988ok(C12095n.this.f34228kf)) {
                    downloadStatusChangeListener.onInstalled(C12095n.this.m19054x());
                }
            }
        });
    }

    /* renamed from: n */
    public boolean m19087n() {
        return C12128r.m18946q().optInt("quick_app_enable_switch", 0) == 0 && this.f34235t.getQuickAppModel() != null && !TextUtils.isEmpty(this.f34235t.getQuickAppModel().m19538ok()) && C12045bl.m19259ok(this.f34230p) && C12197j.m18791ok(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.f34235t.getQuickAppModel().m19538ok())));
    }

    /* renamed from: q */
    public boolean m19062q() {
        SoftReference<IDownloadButtonClickListener> softReference = this.f34225io;
        if (softReference == null) {
            return false;
        }
        return C12127q.m18976ok(this.f34235t, softReference.get());
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: s */
    public long mo19058s() {
        return this.f34226j;
    }

    /* renamed from: bl */
    private boolean m19100bl(int i) {
        if (m19087n()) {
            int i2 = -1;
            String m19538ok = this.f34235t.getQuickAppModel().m19538ok();
            if (i == 1) {
                i2 = 5;
            } else if (i == 2) {
                i2 = 4;
            }
            DownloadModel downloadModel = this.f34235t;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            boolean m18684bl = C12215q.m18684bl(C12128r.getContext(), m19538ok);
            if (m18684bl) {
                C12270ok.m18539ok().m18537ok(this.f34233rh, i);
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = Long.valueOf(this.f34235t.getId());
                C12045bl.m19263ok().m19261ok(this, i2, this.f34235t);
            } else {
                C12270ok.m18539ok().m18534ok(this.f34233rh, false, 0);
            }
            return m18684bl;
        }
        return false;
    }

    /* renamed from: kf */
    private void m19088kf(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = f34220ok;
        C12216r.m18673ok(str, "pBCD", null);
        if (m19055t()) {
            C12035n m19325n = C12032kf.m19324ok().m19325n(this.f34233rh);
            if (this.f34240zz) {
                if (m19062q()) {
                    if (m19056s(false) && (downloadController2 = m19325n.f34080s) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        m19066ok(z, true);
                        return;
                    }
                    return;
                }
                m19066ok(z, true);
                return;
            } else if (this.f34235t.isAd() && (downloadController = m19325n.f34080s) != null && downloadController.enableShowComplianceDialog() && m19325n.f34076a != null && C12058a.m19228ok().m19224ok(m19325n.f34076a) && C12058a.m19228ok().m19223ok(m19325n)) {
                return;
            } else {
                m19066ok(z, true);
                return;
            }
        }
        C12216r.m18673ok(str, "pBCD continue download, status:" + this.f34230p.getStatus(), null);
        DownloadInfo downloadInfo = this.f34230p;
        if (downloadInfo != null && (downloadModel = this.f34235t) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.f34230p.getStatus();
        final int id = this.f34230p.getId();
        final C11998a m19315ok = C12032kf.m19324ok().m19315ok(this.f34230p);
        if (status != -2 && status != -1) {
            if (C12159z.m18875ok(status)) {
                if (this.f34235t.enablePause()) {
                    this.f34234s.m18913ok(true);
                    C12176p.m18851ok().m18857a(C12032kf.m19324ok().m19311s(this.f34233rh));
                    if (C12201n.m18737ok(m19315ok).m17593ok("cancel_pause_optimise_switch", 0) == 1) {
                        C12158s.m18879ok().m18878ok(m19315ok, status, new InterfaceC12155p() { // from class: com.ss.android.downloadlib.addownload.n.6
                            @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12155p
                            /* renamed from: ok */
                            public void mo18883ok(C11998a c11998a) {
                                if (C12095n.this.f34230p == null && C12534ok.m17605bl().m17595ok("fix_handle_pause")) {
                                    C12095n.this.f34230p = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(id);
                                }
                                C12095n.this.f34222bl.m18990ok(C12095n.this.f34230p, z);
                                if (C12095n.this.f34230p != null && C12713kf.m16620a(C12128r.getContext()) && C12095n.this.f34230p.isPauseReserveOnWifi()) {
                                    C12095n.this.f34230p.stopPauseReserveOnWifi();
                                    C12270ok.m18539ok().m18526ok("cancel_pause_reserve_wifi_cancel_on_wifi", m19315ok);
                                    return;
                                }
                                C12095n c12095n = C12095n.this;
                                c12095n.m19082ok(id, status, c12095n.f34230p);
                            }
                        }, new InterfaceC12111bl() { // from class: com.ss.android.downloadlib.addownload.n.5
                            @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl
                            public void delete() {
                                C12095n.this.mo19067ok(true);
                            }
                        });
                        return;
                    } else {
                        C12157r.m18881ok().m18880ok(m19315ok, status, new InterfaceC12155p() { // from class: com.ss.android.downloadlib.addownload.n.7
                            @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12155p
                            /* renamed from: ok */
                            public void mo18883ok(C11998a c11998a) {
                                if (C12095n.this.f34230p == null && C12534ok.m17605bl().m17595ok("fix_handle_pause")) {
                                    C12095n.this.f34230p = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(id);
                                }
                                C12095n.this.f34222bl.m18990ok(C12095n.this.f34230p, z);
                                if (C12095n.this.f34230p != null && C12713kf.m16620a(C12128r.getContext()) && C12095n.this.f34230p.isPauseReserveOnWifi()) {
                                    C12095n.this.f34230p.stopPauseReserveOnWifi();
                                    C12270ok.m18539ok().m18541a("pause_reserve_wifi_cancel_on_wifi", m19315ok);
                                    return;
                                }
                                C12095n c12095n = C12095n.this;
                                c12095n.m19082ok(id, status, c12095n.f34230p);
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.f34222bl.m18990ok(this.f34230p, z);
            m19082ok(id, status, this.f34230p);
            return;
        }
        this.f34222bl.m18990ok(this.f34230p, z);
        if (m19315ok != null) {
            m19315ok.m19468p(System.currentTimeMillis());
            m19315ok.m19464q(this.f34230p.getCurBytes());
        }
        this.f34230p.setDownloadFromReserveWifi(false);
        this.f34234s.m18921ok(new C12035n(this.f34233rh, this.f34235t, m19093j(), m19053z()));
        this.f34234s.m18926ok(id, this.f34230p.getCurBytes(), this.f34230p.getTotalBytes(), new InterfaceC12107ok() { // from class: com.ss.android.downloadlib.addownload.n.3
            @Override // com.p521ss.android.downloadlib.addownload.C12095n.InterfaceC12107ok
            /* renamed from: ok */
            public void mo19048ok() {
                if (C12095n.this.f34234s.m18928ok()) {
                    return;
                }
                C12095n c12095n = C12095n.this;
                c12095n.m19082ok(id, status, c12095n.f34230p);
            }
        });
        if (status == -2 && C12201n.m18737ok(m19315ok).m17593ok("show_pause_continue_toast", 0) == 1) {
            C12184h.m18835ok().m18841a().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.n.4
                @Override // java.lang.Runnable
                public void run() {
                    C12128r.m18968bl().mo19528ok(13, C12128r.getContext(), C12095n.this.f34235t, "已恢复下载", null, 0);
                }
            }, 500L);
        }
    }

    /* renamed from: s */
    public boolean m19056s(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.f34225io;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.f34225io.get().handleComplianceDialog(true);
                } else {
                    this.f34225io.get().handleMarketFailedComplianceDialog();
                }
                this.f34225io = null;
                return true;
            } catch (Exception unused) {
                C12235bl.m18640ok().m18643a("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        C12235bl.m18640ok().m18643a("mDownloadButtonClickListener has recycled");
        return false;
    }

    /* renamed from: h */
    public void m19097h() {
        if (this.f34228kf.size() == 0) {
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : C12121p.m18988ok(this.f34228kf)) {
            downloadStatusChangeListener.onIdle();
        }
        DownloadInfo downloadInfo = this.f34230p;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public C12095n mo19108a(Context context) {
        if (context != null) {
            this.f34229n = new WeakReference<>(context);
        }
        C12128r.m18969a(context);
        return this;
    }

    /* renamed from: n */
    private void m19085n(boolean z) {
        if (C12201n.m18751a(this.f34235t).m17607a("notification_opt_2") == 1 && this.f34230p != null) {
            C12644a.m16876ok().m16878kf(this.f34230p.getId());
        }
        m19088kf(z);
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public C12095n mo19109a(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (C12128r.m18946q().optInt("back_use_softref_listener") == 1) {
                this.f34228kf.put(Integer.valueOf(i), downloadStatusChangeListener);
            } else if (C12128r.m18946q().optInt("use_weakref_listener") == 1) {
                this.f34228kf.put(Integer.valueOf(i), new WeakReference(downloadStatusChangeListener));
            } else {
                this.f34228kf.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: a */
    public boolean mo19111a() {
        return this.f34232r;
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: a */
    public void mo19110a(final int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f34222bl.m18999ok(this.f34233rh);
        if (!C12032kf.m19324ok().m19325n(this.f34233rh).m19301m()) {
            C12235bl.m18640ok().m18639ok("handleDownload ModelBox !isStrictValid");
        }
        if (this.f34222bl.m19000ok(i, this.f34235t)) {
            C12067kf.m19204ok().m19201ok(this.f34222bl.f34306ok, new InterfaceC12083p() { // from class: com.ss.android.downloadlib.addownload.n.1
                @Override // com.p521ss.android.downloadlib.addownload.compliance.InterfaceC12083p
                /* renamed from: ok */
                public void mo19051ok(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!C12205p.m18701ok(C12095n.this.getContext(), C12095n.this.f34222bl.f34306ok, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            C12067kf.m19204ok().m19202ok(1, C12095n.this.f34222bl.f34306ok, jSONObject);
                            int i2 = i;
                            if (i2 == 1) {
                                String str2 = C12095n.f34220ok;
                                C12409ok.m17895ok(str2, "miui new rollback fail: handleDownload id:" + C12095n.this.f34233rh + ",tryPerformButtonClick:", null);
                                C12095n.this.m19098bl(true);
                            } else if (i2 == 2) {
                                String str3 = C12095n.f34220ok;
                                C12409ok.m17895ok(str3, "miui new rollback fail: handleDownload id:" + C12095n.this.f34233rh + ",tryPerformButtonClick:", null);
                                C12095n.this.m19102a(true);
                            }
                        } else {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            C12067kf.m19204ok().m19202ok(0, C12095n.this.f34222bl.f34306ok, jSONObject);
                        }
                    } catch (Exception e) {
                        C12235bl.m18640ok().mo18637ok(e, "generate miui new market param error");
                    }
                }

                @Override // com.p521ss.android.downloadlib.addownload.compliance.InterfaceC12083p
                /* renamed from: ok */
                public void mo19052ok() {
                    int i2 = i;
                    if (i2 == 1) {
                        String str = C12095n.f34220ok;
                        C12409ok.m17895ok(str, "miui new get miui deeplink fail: handleDownload id:" + C12095n.this.f34233rh + ",tryPerformButtonClick:", null);
                        C12095n.this.m19098bl(true);
                    } else if (i2 != 2) {
                    } else {
                        String str2 = C12095n.f34220ok;
                        C12409ok.m17895ok(str2, "miui new get miui deeplink fail: handleDownload id:" + C12095n.this.f34233rh + ",tryPerformButtonClick:", null);
                        C12095n.this.m19102a(true);
                    }
                }
            });
        } else if (this.f34222bl.m18998ok(getContext(), i, this.f34240zz)) {
        } else {
            boolean m19100bl = m19100bl(i);
            if (i == 1) {
                if (m19100bl) {
                    return;
                }
                String str = f34220ok;
                C12216r.m18673ok(str, "handleDownload id:" + this.f34233rh + ",pIC:", null);
                m19098bl(true);
            } else if (i == 2 && !m19100bl) {
                String str2 = f34220ok;
                C12216r.m18673ok(str2, "handleDownload id:" + this.f34233rh + ",pBC:", null);
                m19102a(true);
            }
        }
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public C12095n mo19105a(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    C12235bl.m18640ok().m18639ok("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                C12235bl.m18640ok().m18636ok(false, "setDownloadModel id=0");
                if (C12534ok.m17605bl().m17595ok("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            C12032kf.m19324ok().m19319ok(downloadModel);
            this.f34233rh = downloadModel.getId();
            this.f34235t = downloadModel;
            if (C12127q.m18977ok(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                C11998a m19311s = C12032kf.m19324ok().m19311s(this.f34233rh);
                if (m19311s != null && m19311s.mo19304j() != 3) {
                    m19311s.m19477n(3L);
                    C12038q.m19278ok().m19277ok(m19311s);
                }
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.addownload.n$bl */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class AsyncTaskC12106bl extends AsyncTask<String, Void, DownloadInfo> {
        private AsyncTaskC12106bl() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ok */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr != null) {
                if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                    String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
                    String str2 = strArr[0];
                    if (C12095n.this.f34235t != null && !TextUtils.isEmpty(C12095n.this.f34235t.getFilePath())) {
                        if (TextUtils.isEmpty(str)) {
                            downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(str2, C12095n.this.f34235t.getFilePath());
                        } else {
                            downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(Downloader.getInstance(C12128r.getContext()).getDownloadId(str, C12095n.this.f34235t.getFilePath()));
                        }
                    }
                    if (downloadInfo == null) {
                        if (!TextUtils.isEmpty(str)) {
                            return C12361s.m18068k().m18061ok(C12128r.getContext(), str);
                        }
                        return C12361s.m18068k().m18061ok(C12128r.getContext(), str2);
                    }
                    return downloadInfo;
                }
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ok */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || C12095n.this.f34235t == null) {
                return;
            }
            try {
                C12030bl m18782ok = C12197j.m18782ok(C12095n.this.f34235t.getPackageName(), C12095n.this.f34235t.getVersionCode(), C12095n.this.f34235t.getVersionName());
                C12037p.m19282ok().m19281ok(C12095n.this.f34235t.getVersionCode(), m18782ok.m19339a(), C12032kf.m19324ok().m19315ok(downloadInfo));
                boolean m19337ok = m18782ok.m19337ok();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (m19337ok || !Downloader.getInstance(C12128r.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(C12128r.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (C12095n.this.f34230p == null || C12095n.this.f34230p.getStatus() != -4) {
                        C12095n.this.f34230p = downloadInfo;
                        if (C12095n.this.f34237u) {
                            Downloader.getInstance(C12128r.getContext()).setMainThreadListener(C12095n.this.f34230p.getId(), C12095n.this.f34227k, false);
                        } else {
                            Downloader.getInstance(C12128r.getContext()).setMainThreadListener(C12095n.this.f34230p.getId(), C12095n.this.f34227k);
                        }
                    } else {
                        C12095n.this.f34230p = null;
                    }
                    C12095n.this.f34222bl.m18991ok(C12095n.this.f34230p, C12095n.this.m19054x(), C12121p.m18988ok(C12095n.this.f34228kf));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(C12128r.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        C12644a.m16876ok().m16878kf(downloadInfo.getId());
                        C12095n.this.f34230p = null;
                    }
                    if (C12095n.this.f34230p != null) {
                        Downloader.getInstance(C12128r.getContext()).removeTaskMainListener(C12095n.this.f34230p.getId());
                        if (C12095n.this.f34237u) {
                            Downloader.getInstance(C12095n.this.getContext()).setMainThreadListener(C12095n.this.f34230p.getId(), C12095n.this.f34227k, false);
                        } else {
                            Downloader.getInstance(C12095n.this.getContext()).setMainThreadListener(C12095n.this.f34230p.getId(), C12095n.this.f34227k);
                        }
                    }
                    if (!m19337ok) {
                        for (DownloadStatusChangeListener downloadStatusChangeListener : C12121p.m18988ok(C12095n.this.f34228kf)) {
                            downloadStatusChangeListener.onIdle();
                        }
                        C12095n.this.f34230p = null;
                    } else {
                        C12095n c12095n = C12095n.this;
                        c12095n.f34230p = new DownloadInfo.C12595ok(c12095n.f34235t.getDownloadUrl()).m17104ok();
                        C12095n.this.f34230p.setStatus(-3);
                        C12095n.this.f34222bl.m18991ok(C12095n.this.f34230p, C12095n.this.m19054x(), C12121p.m18988ok(C12095n.this.f34228kf));
                    }
                }
                C12095n.this.f34222bl.m19007bl(C12095n.this.f34230p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: bl */
    public void m19098bl(boolean z) {
        if (z) {
            C12270ok.m18539ok().m18537ok(this.f34233rh, 1);
        }
        m19059rh();
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: p */
    public void mo19065p() {
        C12032kf.m19324ok().m19326kf(this.f34233rh);
    }

    /* renamed from: a */
    public void m19102a(boolean z) {
        m19085n(z);
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public C12095n mo19107a(DownloadController downloadController) {
        JSONObject extra;
        this.f34238x = downloadController;
        if (C12201n.m18751a(this.f34235t).m17607a("force_auto_open") == 1) {
            m19053z().setLinkMode(1);
        }
        if (C12534ok.m17605bl().m17595ok("fix_show_dialog") && (extra = this.f34235t.getExtra()) != null && extra.optInt("subprocess") > 0) {
            m19053z().setEnableNewActivity(false);
        }
        C12032kf.m19324ok().m19321ok(this.f34233rh, m19053z());
        return this;
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public C12095n mo19106a(DownloadEventConfig downloadEventConfig) {
        this.f34224i = downloadEventConfig;
        this.f34240zz = m19093j().getDownloadScene() == 0;
        C12032kf.m19324ok().m19320ok(this.f34233rh, m19093j());
        return this;
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public InterfaceC12089h mo19077ok(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.f34236td = null;
        } else {
            this.f34236td = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public void mo19084ok() {
        this.f34232r = true;
        C12032kf.m19324ok().m19320ok(this.f34233rh, m19093j());
        C12032kf.m19324ok().m19321ok(this.f34233rh, m19053z());
        this.f34222bl.m18999ok(this.f34233rh);
        m19094i();
        if (C12128r.m18946q().optInt("enable_empty_listener", 1) == 1 && this.f34228kf.get(Integer.MIN_VALUE) == null) {
            mo19109a(Integer.MIN_VALUE, new C11962ok());
        }
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public boolean mo19083ok(int i) {
        if (i == 0) {
            this.f34228kf.clear();
        } else {
            this.f34228kf.remove(Integer.valueOf(i));
        }
        if (this.f34228kf.isEmpty()) {
            this.f34232r = false;
            this.f34226j = System.currentTimeMillis();
            if (this.f34230p != null) {
                Downloader.getInstance(C12128r.getContext()).removeTaskMainListener(this.f34230p.getId());
            }
            AsyncTaskC12106bl asyncTaskC12106bl = this.f34231q;
            if (asyncTaskC12106bl != null && asyncTaskC12106bl.getStatus() != AsyncTask.Status.FINISHED) {
                this.f34231q.cancel(true);
            }
            this.f34222bl.m18992ok(this.f34230p);
            String str = f34220ok;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f34230p;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            C12216r.m18673ok(str, sb.toString(), null);
            this.f34221a.removeCallbacksAndMessages(null);
            this.f34223h = null;
            this.f34230p = null;
            return true;
        }
        if (this.f34228kf.size() == 1 && this.f34228kf.containsKey(Integer.MIN_VALUE)) {
            this.f34222bl.m19010a(this.f34230p);
        }
        return false;
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public void mo19067ok(boolean z) {
        if (this.f34230p != null) {
            if (z) {
                InterfaceC12308s m18079a = C12361s.m18068k().m18079a();
                if (m18079a != null) {
                    m18079a.mo18382ok(this.f34230p);
                }
                Downloader.getInstance(C12490bl.m17807l()).cancel(this.f34230p.getId(), true);
                return;
            }
            Intent intent = new Intent(C12128r.getContext(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f34230p.getId());
            C12128r.getContext().startService(intent);
        }
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public InterfaceC12089h mo19080ok(long j) {
        if (j != 0) {
            DownloadModel m19322ok = C12032kf.m19324ok().m19322ok(j);
            if (m19322ok != null) {
                this.f34235t = m19322ok;
                this.f34233rh = j;
                this.f34222bl.m18999ok(j);
            }
        } else {
            C12235bl.m18640ok().m18636ok(false, "setModelId");
        }
        return this;
    }

    @Override // com.p521ss.android.downloadlib.p534h.HandlerC12218z.InterfaceC12219ok
    /* renamed from: ok */
    public void mo18671ok(Message message) {
        if (message != null && this.f34232r && message.what == 3) {
            this.f34230p = (DownloadInfo) message.obj;
            this.f34222bl.m18996ok(message, m19054x(), this.f34228kf);
        }
    }

    /* renamed from: ok */
    public void m19066ok(boolean z, final boolean z2) {
        if (z) {
            C12270ok.m18539ok().m18537ok(this.f34233rh, 2);
        }
        if (!C12197j.m18795ok()) {
            if (!C12198k.m18769a(C7282g.f24952j) && !m19053z().enableNewActivity()) {
                this.f34235t.setFilePath(this.f34222bl.m19012a());
            }
        } else if (!C12198k.m18769a("android.permission.READ_MEDIA_IMAGES") && !C12198k.m18769a("android.permission.READ_MEDIA_AUDIO") && !C12198k.m18769a("android.permission.READ_MEDIA_VIDEO") && !m19053z().enableNewActivity()) {
            this.f34235t.setFilePath(this.f34222bl.m19012a());
        }
        if (C12201n.m18746bl(this.f34235t) == 0) {
            C12216r.m18673ok(f34220ok, "pBCD not start", null);
            this.f34222bl.m18995ok(new InterfaceC11970u() { // from class: com.ss.android.downloadlib.addownload.n.8
                @Override // com.p521ss.android.download.api.config.InterfaceC11970u
                /* renamed from: ok */
                public void mo18984ok() {
                    C12216r.m18673ok(C12095n.f34220ok, "pBCD start download", null);
                    C12095n.this.m19095h(z2);
                }

                @Override // com.p521ss.android.download.api.config.InterfaceC11970u
                /* renamed from: ok */
                public void mo18983ok(String str) {
                    C12216r.m18673ok(C12095n.f34220ok, "pBCD onDenied", null);
                }
            });
            return;
        }
        m19095h(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m19082ok(int i, int i2, @NonNull DownloadInfo downloadInfo) {
        if (C12534ok.m17605bl().m17595ok("fix_click_start")) {
            if (i2 != -3 && !C12515s.m17660ok().m17662n(i)) {
                m19066ok(false, false);
                return;
            } else {
                C12361s.m18068k().m18062ok(C12128r.getContext(), i, i2);
                return;
            }
        }
        C12361s.m18068k().m18062ok(C12128r.getContext(), i, i2);
    }

    /* renamed from: ok */
    private void m19069ok(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.f34221a.sendMessage(obtain);
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public InterfaceC12089h mo19068ok(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f34239z = str;
        }
        return this;
    }

    @Override // com.p521ss.android.downloadlib.addownload.InterfaceC12089h
    /* renamed from: ok */
    public InterfaceC12089h mo19078ok(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.f34225io = null;
        } else {
            this.f34225io = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
