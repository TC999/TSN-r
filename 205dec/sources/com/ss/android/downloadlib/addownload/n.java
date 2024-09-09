package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.bl;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.p;
import com.ss.android.downloadlib.h.z;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n implements h, z.ok {
    private static final String ok = "n";

    /* renamed from: a  reason: collision with root package name */
    private final com.ss.android.downloadlib.h.z f48537a;
    private p bl;

    /* renamed from: h  reason: collision with root package name */
    private DownloadShortInfo f48538h;

    /* renamed from: i  reason: collision with root package name */
    private DownloadEventConfig f48539i;

    /* renamed from: io  reason: collision with root package name */
    private SoftReference<IDownloadButtonClickListener> f48540io;

    /* renamed from: j  reason: collision with root package name */
    private long f48541j;

    /* renamed from: k  reason: collision with root package name */
    private final IDownloadListener f48542k;
    private final Map<Integer, Object> kf;

    /* renamed from: n  reason: collision with root package name */
    private WeakReference<Context> f48543n;

    /* renamed from: p  reason: collision with root package name */
    private DownloadInfo f48544p;

    /* renamed from: q  reason: collision with root package name */
    private bl f48545q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f48546r;
    private long rh;

    /* renamed from: s  reason: collision with root package name */
    private s f48547s;

    /* renamed from: t  reason: collision with root package name */
    private DownloadModel f48548t;
    private SoftReference<OnItemClickListener> td;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f48549u;

    /* renamed from: x  reason: collision with root package name */
    private DownloadController f48550x;

    /* renamed from: z  reason: collision with root package name */
    private String f48551z;
    private boolean zz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void ok(long j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface ok {
        void ok();
    }

    public n() {
        com.ss.android.downloadlib.h.z zVar = new com.ss.android.downloadlib.h.z(Looper.getMainLooper(), this);
        this.f48537a = zVar;
        this.kf = new ConcurrentHashMap();
        this.f48542k = new p.ok(zVar);
        this.rh = -1L;
        this.f48548t = null;
        this.f48539i = null;
        this.f48550x = null;
        this.bl = new p(this);
        this.f48547s = new s(zVar);
        this.f48549u = com.ss.android.socialbase.downloader.h.ok.bl().ok("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.f48543n;
        if (weakReference != null && weakReference.get() != null) {
            return this.f48543n.get();
        }
        return r.getContext();
    }

    private void i() {
        bl blVar = this.f48545q;
        if (blVar != null && blVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f48545q.cancel(true);
        }
        this.f48545q = new bl();
        if (!TextUtils.isEmpty(this.f48551z)) {
            com.ss.android.downloadlib.h.a.ok(this.f48545q, this.f48548t.getDownloadUrl(), this.f48548t.getPackageName(), this.f48551z);
        } else {
            com.ss.android.downloadlib.h.a.ok(this.f48545q, this.f48548t.getDownloadUrl(), this.f48548t.getPackageName());
        }
    }

    @NonNull
    private DownloadEventConfig j() {
        DownloadEventConfig downloadEventConfig = this.f48539i;
        return downloadEventConfig == null ? new bl.ok().ok() : downloadEventConfig;
    }

    private void r() {
        SoftReference<OnItemClickListener> softReference = this.td;
        if (softReference != null && softReference.get() != null) {
            this.td.get().onItemClick(this.f48548t, j(), z());
            this.td = null;
            return;
        }
        r.a().ok(getContext(), this.f48548t, z(), j());
    }

    private void rh() {
        String str = ok;
        com.ss.android.downloadlib.h.r.ok(str, "pICD", null);
        if (this.bl.s(this.f48544p)) {
            com.ss.android.downloadlib.h.r.ok(str, "pICD BC", null);
            kf(false);
            return;
        }
        com.ss.android.downloadlib.h.r.ok(str, "pICD IC", null);
        r();
    }

    private boolean t() {
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_click_start")) {
            DownloadInfo downloadInfo = this.f48544p;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.f48544p.getCurBytes() <= 0) || this.f48544p.getStatus() == 0 || this.f48544p.getStatus() == -4) {
                return true;
            }
            return com.ss.android.socialbase.downloader.q.kf.ok(this.f48544p.getStatus(), this.f48544p.getSavePath(), this.f48544p.getName());
        }
        DownloadInfo downloadInfo2 = this.f48544p;
        if (downloadInfo2 == null) {
            return true;
        }
        return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(r.getContext()).canResume(this.f48544p.getId())) || this.f48544p.getStatus() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo x() {
        if (this.f48538h == null) {
            this.f48538h = new DownloadShortInfo();
        }
        return this.f48538h;
    }

    @NonNull
    private DownloadController z() {
        if (this.f48550x == null) {
            this.f48550x = new com.ss.android.download.api.download.a();
        }
        return this.f48550x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final boolean z3) {
        this.f48547s.ok(new com.ss.android.downloadlib.addownload.a.n(this.rh, this.f48548t, j(), z()));
        this.f48547s.ok(0, 0L, 0L, new ok() { // from class: com.ss.android.downloadlib.addownload.n.9
            @Override // com.ss.android.downloadlib.addownload.n.ok
            public void ok() {
                if (n.this.f48547s.ok()) {
                    return;
                }
                n.this.p(z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z3) {
        for (DownloadStatusChangeListener downloadStatusChangeListener : p.ok(this.kf)) {
            downloadStatusChangeListener.onDownloadStart(this.f48548t, z());
        }
        int ok2 = this.bl.ok(r.getContext(), this.f48542k);
        String str = ok;
        com.ss.android.downloadlib.h.r.ok(str, "beginDown id:" + ok2, null);
        if (ok2 != 0) {
            if (this.f48544p != null && !com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_click_start")) {
                this.bl.ok(this.f48544p, false);
            } else if (z3) {
                this.bl.ok();
            }
        } else {
            DownloadInfo ok3 = new DownloadInfo.ok(this.f48548t.getDownloadUrl()).ok();
            ok3.setStatus(-1);
            ok(ok3);
            com.ss.android.downloadlib.s.ok.ok().ok(this.rh, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.n.bl.ok().a("beginDown");
        }
        if (this.bl.ok(bl())) {
            com.ss.android.downloadlib.h.r.ok(str, "beginDown IC id:" + ok2, null);
            r();
        }
    }

    public boolean bl() {
        DownloadInfo downloadInfo = this.f48544p;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    public void kf() {
        this.f48537a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.n.2
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadStatusChangeListener downloadStatusChangeListener : p.ok(n.this.kf)) {
                    downloadStatusChangeListener.onInstalled(n.this.x());
                }
            }
        });
    }

    public boolean n() {
        return r.q().optInt("quick_app_enable_switch", 0) == 0 && this.f48548t.getQuickAppModel() != null && !TextUtils.isEmpty(this.f48548t.getQuickAppModel().ok()) && com.ss.android.downloadlib.addownload.bl.ok(this.f48544p) && com.ss.android.downloadlib.h.j.ok(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.f48548t.getQuickAppModel().ok())));
    }

    public boolean q() {
        SoftReference<IDownloadButtonClickListener> softReference = this.f48540io;
        if (softReference == null) {
            return false;
        }
        return q.ok(this.f48548t, softReference.get());
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public long s() {
        return this.f48541j;
    }

    private boolean bl(int i4) {
        if (n()) {
            int i5 = -1;
            String ok2 = this.f48548t.getQuickAppModel().ok();
            if (i4 == 1) {
                i5 = 5;
            } else if (i4 == 2) {
                i5 = 4;
            }
            DownloadModel downloadModel = this.f48548t;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            boolean bl2 = com.ss.android.downloadlib.h.q.bl(r.getContext(), ok2);
            if (bl2) {
                com.ss.android.downloadlib.s.ok.ok().ok(this.rh, i4);
                Message obtain = Message.obtain();
                obtain.what = i5;
                obtain.obj = Long.valueOf(this.f48548t.getId());
                com.ss.android.downloadlib.addownload.bl.ok().ok(this, i5, this.f48548t);
            } else {
                com.ss.android.downloadlib.s.ok.ok().ok(this.rh, false, 0);
            }
            return bl2;
        }
        return false;
    }

    private void kf(final boolean z3) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = ok;
        com.ss.android.downloadlib.h.r.ok(str, "pBCD", null);
        if (t()) {
            com.ss.android.downloadlib.addownload.a.n n4 = com.ss.android.downloadlib.addownload.a.kf.ok().n(this.rh);
            if (this.zz) {
                if (q()) {
                    if (s(false) && (downloadController2 = n4.f48373s) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        ok(z3, true);
                        return;
                    }
                    return;
                }
                ok(z3, true);
                return;
            } else if (this.f48548t.isAd() && (downloadController = n4.f48373s) != null && downloadController.enableShowComplianceDialog() && n4.f48371a != null && com.ss.android.downloadlib.addownload.compliance.a.ok().ok(n4.f48371a) && com.ss.android.downloadlib.addownload.compliance.a.ok().ok(n4)) {
                return;
            } else {
                ok(z3, true);
                return;
            }
        }
        com.ss.android.downloadlib.h.r.ok(str, "pBCD continue download, status:" + this.f48544p.getStatus(), null);
        DownloadInfo downloadInfo = this.f48544p;
        if (downloadInfo != null && (downloadModel = this.f48548t) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.f48544p.getStatus();
        final int id = this.f48544p.getId();
        final com.ss.android.downloadad.api.ok.a ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.f48544p);
        if (status != -2 && status != -1) {
            if (z.ok(status)) {
                if (this.f48548t.enablePause()) {
                    this.f48547s.ok(true);
                    com.ss.android.downloadlib.bl.p.ok().a(com.ss.android.downloadlib.addownload.a.kf.ok().s(this.rh));
                    if (com.ss.android.downloadlib.h.n.ok(ok2).ok("cancel_pause_optimise_switch", 0) == 1) {
                        com.ss.android.downloadlib.addownload.s.s.ok().ok(ok2, status, new com.ss.android.downloadlib.addownload.s.p() { // from class: com.ss.android.downloadlib.addownload.n.6
                            @Override // com.ss.android.downloadlib.addownload.s.p
                            public void ok(com.ss.android.downloadad.api.ok.a aVar) {
                                if (n.this.f48544p == null && com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_handle_pause")) {
                                    n.this.f48544p = Downloader.getInstance(r.getContext()).getDownloadInfo(id);
                                }
                                n.this.bl.ok(n.this.f48544p, z3);
                                if (n.this.f48544p != null && com.ss.android.socialbase.downloader.q.kf.a(r.getContext()) && n.this.f48544p.isPauseReserveOnWifi()) {
                                    n.this.f48544p.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_cancel_on_wifi", ok2);
                                    return;
                                }
                                n nVar = n.this;
                                nVar.ok(id, status, nVar.f48544p);
                            }
                        }, new com.ss.android.downloadlib.addownload.ok.bl() { // from class: com.ss.android.downloadlib.addownload.n.5
                            @Override // com.ss.android.downloadlib.addownload.ok.bl
                            public void delete() {
                                n.this.ok(true);
                            }
                        });
                        return;
                    } else {
                        com.ss.android.downloadlib.addownload.s.r.ok().ok(ok2, status, new com.ss.android.downloadlib.addownload.s.p() { // from class: com.ss.android.downloadlib.addownload.n.7
                            @Override // com.ss.android.downloadlib.addownload.s.p
                            public void ok(com.ss.android.downloadad.api.ok.a aVar) {
                                if (n.this.f48544p == null && com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_handle_pause")) {
                                    n.this.f48544p = Downloader.getInstance(r.getContext()).getDownloadInfo(id);
                                }
                                n.this.bl.ok(n.this.f48544p, z3);
                                if (n.this.f48544p != null && com.ss.android.socialbase.downloader.q.kf.a(r.getContext()) && n.this.f48544p.isPauseReserveOnWifi()) {
                                    n.this.f48544p.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.s.ok.ok().a("pause_reserve_wifi_cancel_on_wifi", ok2);
                                    return;
                                }
                                n nVar = n.this;
                                nVar.ok(id, status, nVar.f48544p);
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.bl.ok(this.f48544p, z3);
            ok(id, status, this.f48544p);
            return;
        }
        this.bl.ok(this.f48544p, z3);
        if (ok2 != null) {
            ok2.p(System.currentTimeMillis());
            ok2.q(this.f48544p.getCurBytes());
        }
        this.f48544p.setDownloadFromReserveWifi(false);
        this.f48547s.ok(new com.ss.android.downloadlib.addownload.a.n(this.rh, this.f48548t, j(), z()));
        this.f48547s.ok(id, this.f48544p.getCurBytes(), this.f48544p.getTotalBytes(), new ok() { // from class: com.ss.android.downloadlib.addownload.n.3
            @Override // com.ss.android.downloadlib.addownload.n.ok
            public void ok() {
                if (n.this.f48547s.ok()) {
                    return;
                }
                n nVar = n.this;
                nVar.ok(id, status, nVar.f48544p);
            }
        });
        if (status == -2 && com.ss.android.downloadlib.h.n.ok(ok2).ok("show_pause_continue_toast", 0) == 1) {
            com.ss.android.downloadlib.h.ok().a().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.n.4
                @Override // java.lang.Runnable
                public void run() {
                    r.bl().ok(13, r.getContext(), n.this.f48548t, "\u5df2\u6062\u590d\u4e0b\u8f7d", null, 0);
                }
            }, 500L);
        }
    }

    public boolean s(boolean z3) {
        SoftReference<IDownloadButtonClickListener> softReference = this.f48540io;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z3) {
                    this.f48540io.get().handleComplianceDialog(true);
                } else {
                    this.f48540io.get().handleMarketFailedComplianceDialog();
                }
                this.f48540io = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.n.bl.ok().a("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.n.bl.ok().a("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void h() {
        if (this.kf.size() == 0) {
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : p.ok(this.kf)) {
            downloadStatusChangeListener.onIdle();
        }
        DownloadInfo downloadInfo = this.f48544p;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: ok */
    public n a(Context context) {
        if (context != null) {
            this.f48543n = new WeakReference<>(context);
        }
        r.a(context);
        return this;
    }

    private void n(boolean z3) {
        if (com.ss.android.downloadlib.h.n.a(this.f48548t).a("notification_opt_2") == 1 && this.f48544p != null) {
            com.ss.android.socialbase.downloader.notification.a.ok().kf(this.f48544p.getId());
        }
        kf(z3);
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: ok */
    public n a(int i4, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (r.q().optInt("back_use_softref_listener") == 1) {
                this.kf.put(Integer.valueOf(i4), downloadStatusChangeListener);
            } else if (r.q().optInt("use_weakref_listener") == 1) {
                this.kf.put(Integer.valueOf(i4), new WeakReference(downloadStatusChangeListener));
            } else {
                this.kf.put(Integer.valueOf(i4), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public boolean a() {
        return this.f48546r;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void a(final int i4) {
        if (i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.bl.ok(this.rh);
        if (!com.ss.android.downloadlib.addownload.a.kf.ok().n(this.rh).m()) {
            com.ss.android.downloadlib.n.bl.ok().ok("handleDownload ModelBox !isStrictValid");
        }
        if (this.bl.ok(i4, this.f48548t)) {
            com.ss.android.downloadlib.addownload.compliance.kf.ok().ok(this.bl.ok, new com.ss.android.downloadlib.addownload.compliance.p() { // from class: com.ss.android.downloadlib.addownload.n.1
                @Override // com.ss.android.downloadlib.addownload.compliance.p
                public void ok(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!com.ss.android.downloadlib.h.p.ok(n.this.getContext(), n.this.bl.ok, str, jSONObject, true, i4)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.ss.android.downloadlib.addownload.compliance.kf.ok().ok(1, n.this.bl.ok, jSONObject);
                            int i5 = i4;
                            if (i5 == 1) {
                                String str2 = n.ok;
                                com.ss.android.socialbase.downloader.bl.ok.ok(str2, "miui new rollback fail: handleDownload id:" + n.this.rh + ",tryPerformButtonClick:", null);
                                n.this.bl(true);
                            } else if (i5 == 2) {
                                String str3 = n.ok;
                                com.ss.android.socialbase.downloader.bl.ok.ok(str3, "miui new rollback fail: handleDownload id:" + n.this.rh + ",tryPerformButtonClick:", null);
                                n.this.a(true);
                            }
                        } else {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            com.ss.android.downloadlib.addownload.compliance.kf.ok().ok(0, n.this.bl.ok, jSONObject);
                        }
                    } catch (Exception e4) {
                        com.ss.android.downloadlib.n.bl.ok().ok(e4, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.p
                public void ok() {
                    int i5 = i4;
                    if (i5 == 1) {
                        String str = n.ok;
                        com.ss.android.socialbase.downloader.bl.ok.ok(str, "miui new get miui deeplink fail: handleDownload id:" + n.this.rh + ",tryPerformButtonClick:", null);
                        n.this.bl(true);
                    } else if (i5 != 2) {
                    } else {
                        String str2 = n.ok;
                        com.ss.android.socialbase.downloader.bl.ok.ok(str2, "miui new get miui deeplink fail: handleDownload id:" + n.this.rh + ",tryPerformButtonClick:", null);
                        n.this.a(true);
                    }
                }
            });
        } else if (this.bl.ok(getContext(), i4, this.zz)) {
        } else {
            boolean bl2 = bl(i4);
            if (i4 == 1) {
                if (bl2) {
                    return;
                }
                String str = ok;
                com.ss.android.downloadlib.h.r.ok(str, "handleDownload id:" + this.rh + ",pIC:", null);
                bl(true);
            } else if (i4 == 2 && !bl2) {
                String str2 = ok;
                com.ss.android.downloadlib.h.r.ok(str2, "handleDownload id:" + this.rh + ",pBC:", null);
                a(true);
            }
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: ok */
    public n a(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.n.bl.ok().ok("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.n.bl.ok().ok(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadModel);
            this.rh = downloadModel.getId();
            this.f48548t = downloadModel;
            if (q.ok(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.ok.a s3 = com.ss.android.downloadlib.addownload.a.kf.ok().s(this.rh);
                if (s3 != null && s3.j() != 3) {
                    s3.n(3L);
                    com.ss.android.downloadlib.addownload.a.q.ok().ok(s3);
                }
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class bl extends AsyncTask<String, Void, DownloadInfo> {
        private bl() {
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
                    if (n.this.f48548t != null && !TextUtils.isEmpty(n.this.f48548t.getFilePath())) {
                        if (TextUtils.isEmpty(str)) {
                            downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(str2, n.this.f48548t.getFilePath());
                        } else {
                            downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(Downloader.getInstance(r.getContext()).getDownloadId(str, n.this.f48548t.getFilePath()));
                        }
                    }
                    if (downloadInfo == null) {
                        if (!TextUtils.isEmpty(str)) {
                            return com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), str);
                        }
                        return com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), str2);
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
            if (isCancelled() || n.this.f48548t == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.a.bl ok = com.ss.android.downloadlib.h.j.ok(n.this.f48548t.getPackageName(), n.this.f48548t.getVersionCode(), n.this.f48548t.getVersionName());
                com.ss.android.downloadlib.addownload.a.p.ok().ok(n.this.f48548t.getVersionCode(), ok.a(), com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo));
                boolean ok2 = ok.ok();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (ok2 || !Downloader.getInstance(r.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(r.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (n.this.f48544p == null || n.this.f48544p.getStatus() != -4) {
                        n.this.f48544p = downloadInfo;
                        if (n.this.f48549u) {
                            Downloader.getInstance(r.getContext()).setMainThreadListener(n.this.f48544p.getId(), n.this.f48542k, false);
                        } else {
                            Downloader.getInstance(r.getContext()).setMainThreadListener(n.this.f48544p.getId(), n.this.f48542k);
                        }
                    } else {
                        n.this.f48544p = null;
                    }
                    n.this.bl.ok(n.this.f48544p, n.this.x(), p.ok(n.this.kf));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(r.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.a.ok().kf(downloadInfo.getId());
                        n.this.f48544p = null;
                    }
                    if (n.this.f48544p != null) {
                        Downloader.getInstance(r.getContext()).removeTaskMainListener(n.this.f48544p.getId());
                        if (n.this.f48549u) {
                            Downloader.getInstance(n.this.getContext()).setMainThreadListener(n.this.f48544p.getId(), n.this.f48542k, false);
                        } else {
                            Downloader.getInstance(n.this.getContext()).setMainThreadListener(n.this.f48544p.getId(), n.this.f48542k);
                        }
                    }
                    if (!ok2) {
                        for (DownloadStatusChangeListener downloadStatusChangeListener : p.ok(n.this.kf)) {
                            downloadStatusChangeListener.onIdle();
                        }
                        n.this.f48544p = null;
                    } else {
                        n nVar = n.this;
                        nVar.f48544p = new DownloadInfo.ok(nVar.f48548t.getDownloadUrl()).ok();
                        n.this.f48544p.setStatus(-3);
                        n.this.bl.ok(n.this.f48544p, n.this.x(), p.ok(n.this.kf));
                    }
                }
                n.this.bl.bl(n.this.f48544p);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void bl(boolean z3) {
        if (z3) {
            com.ss.android.downloadlib.s.ok.ok().ok(this.rh, 1);
        }
        rh();
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void p() {
        com.ss.android.downloadlib.addownload.a.kf.ok().kf(this.rh);
    }

    public void a(boolean z3) {
        n(z3);
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: ok */
    public n a(DownloadController downloadController) {
        JSONObject extra;
        this.f48550x = downloadController;
        if (com.ss.android.downloadlib.h.n.a(this.f48548t).a("force_auto_open") == 1) {
            z().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_show_dialog") && (extra = this.f48548t.getExtra()) != null && extra.optInt("subprocess") > 0) {
            z().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.rh, z());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: ok */
    public n a(DownloadEventConfig downloadEventConfig) {
        this.f48539i = downloadEventConfig;
        this.zz = j().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.rh, j());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h ok(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.td = null;
        } else {
            this.td = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void ok() {
        this.f48546r = true;
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.rh, j());
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.rh, z());
        this.bl.ok(this.rh);
        i();
        if (r.q().optInt("enable_empty_listener", 1) == 1 && this.kf.get(Integer.MIN_VALUE) == null) {
            a(Integer.MIN_VALUE, new com.ss.android.download.api.config.ok());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public boolean ok(int i4) {
        if (i4 == 0) {
            this.kf.clear();
        } else {
            this.kf.remove(Integer.valueOf(i4));
        }
        if (this.kf.isEmpty()) {
            this.f48546r = false;
            this.f48541j = System.currentTimeMillis();
            if (this.f48544p != null) {
                Downloader.getInstance(r.getContext()).removeTaskMainListener(this.f48544p.getId());
            }
            bl blVar = this.f48545q;
            if (blVar != null && blVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f48545q.cancel(true);
            }
            this.bl.ok(this.f48544p);
            String str = ok;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f48544p;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.h.r.ok(str, sb.toString(), null);
            this.f48537a.removeCallbacksAndMessages(null);
            this.f48538h = null;
            this.f48544p = null;
            return true;
        }
        if (this.kf.size() == 1 && this.kf.containsKey(Integer.MIN_VALUE)) {
            this.bl.a(this.f48544p);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void ok(boolean z3) {
        if (this.f48544p != null) {
            if (z3) {
                com.ss.android.socialbase.appdownloader.bl.s a4 = com.ss.android.socialbase.appdownloader.s.k().a();
                if (a4 != null) {
                    a4.ok(this.f48544p);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).cancel(this.f48544p.getId(), true);
                return;
            }
            Intent intent = new Intent(r.getContext(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f48544p.getId());
            r.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h ok(long j4) {
        if (j4 != 0) {
            DownloadModel ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j4);
            if (ok2 != null) {
                this.f48548t = ok2;
                this.rh = j4;
                this.bl.ok(j4);
            }
        } else {
            com.ss.android.downloadlib.n.bl.ok().ok(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.h.z.ok
    public void ok(Message message) {
        if (message != null && this.f48546r && message.what == 3) {
            this.f48544p = (DownloadInfo) message.obj;
            this.bl.ok(message, x(), this.kf);
        }
    }

    public void ok(boolean z3, final boolean z4) {
        if (z3) {
            com.ss.android.downloadlib.s.ok.ok().ok(this.rh, 2);
        }
        if (!com.ss.android.downloadlib.h.j.ok()) {
            if (!com.ss.android.downloadlib.h.k.a("android.permission.WRITE_EXTERNAL_STORAGE") && !z().enableNewActivity()) {
                this.f48548t.setFilePath(this.bl.a());
            }
        } else if (!com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_VIDEO") && !z().enableNewActivity()) {
            this.f48548t.setFilePath(this.bl.a());
        }
        if (com.ss.android.downloadlib.h.n.bl(this.f48548t) == 0) {
            com.ss.android.downloadlib.h.r.ok(ok, "pBCD not start", null);
            this.bl.ok(new u() { // from class: com.ss.android.downloadlib.addownload.n.8
                public void ok() {
                    com.ss.android.downloadlib.h.r.ok(n.ok, "pBCD start download", null);
                    n.this.h(z4);
                }

                public void ok(String str) {
                    com.ss.android.downloadlib.h.r.ok(n.ok, "pBCD onDenied", null);
                }
            });
            return;
        }
        h(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, int i5, @NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_click_start")) {
            if (i5 != -3 && !com.ss.android.socialbase.downloader.downloader.s.ok().n(i4)) {
                ok(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), i4, i5);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), i4, i5);
    }

    private void ok(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.f48537a.sendMessage(obtain);
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h ok(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f48551z = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h ok(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.f48540io = null;
        } else {
            this.f48540io = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
