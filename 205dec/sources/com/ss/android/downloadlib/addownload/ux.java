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
import com.ss.android.download.api.download.xv;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.ev;
import com.ss.android.downloadlib.r.bk;
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

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux implements r, bk.c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f48671c = "ux";

    /* renamed from: a  reason: collision with root package name */
    private long f48672a;
    private String bk;
    private DownloadInfo ev;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Integer, Object> f48673f;
    private DownloadEventConfig fp;
    private boolean fz;
    private xv gd;

    /* renamed from: i  reason: collision with root package name */
    private SoftReference<IDownloadButtonClickListener> f48674i;
    private DownloadController ia;

    /* renamed from: k  reason: collision with root package name */
    private boolean f48675k;

    /* renamed from: p  reason: collision with root package name */
    private final IDownloadListener f48676p;

    /* renamed from: r  reason: collision with root package name */
    private DownloadShortInfo f48677r;

    /* renamed from: s  reason: collision with root package name */
    private SoftReference<OnItemClickListener> f48678s;
    private sr sr;

    /* renamed from: t  reason: collision with root package name */
    private long f48679t;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f48680u;
    private WeakReference<Context> ux;

    /* renamed from: w  reason: collision with root package name */
    private final com.ss.android.downloadlib.r.bk f48681w;
    private ev xv;
    private DownloadModel ys;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface c {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface w {
        void c(long j4);
    }

    public ux() {
        com.ss.android.downloadlib.r.bk bkVar = new com.ss.android.downloadlib.r.bk(Looper.getMainLooper(), this);
        this.f48681w = bkVar;
        this.f48673f = new ConcurrentHashMap();
        this.f48676p = new ev.c(bkVar);
        this.f48679t = -1L;
        this.ys = null;
        this.fp = null;
        this.ia = null;
        this.xv = new ev(this);
        this.sr = new sr(bkVar);
        this.f48680u = com.ss.android.socialbase.downloader.r.c.xv().c("ttdownloader_callback_twice");
    }

    @NonNull
    private DownloadEventConfig a() {
        DownloadEventConfig downloadEventConfig = this.fp;
        return downloadEventConfig == null ? new xv.c().c() : downloadEventConfig;
    }

    @NonNull
    private DownloadController bk() {
        if (this.ia == null) {
            this.ia = new com.ss.android.download.api.download.w();
        }
        return this.ia;
    }

    private void fp() {
        xv xvVar = this.gd;
        if (xvVar != null && xvVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.gd.cancel(true);
        }
        this.gd = new xv();
        if (!TextUtils.isEmpty(this.bk)) {
            com.ss.android.downloadlib.r.w.c(this.gd, this.ys.getDownloadUrl(), this.ys.getPackageName(), this.bk);
        } else {
            com.ss.android.downloadlib.r.w.c(this.gd, this.ys.getDownloadUrl(), this.ys.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.ux;
        if (weakReference != null && weakReference.get() != null) {
            return this.ux.get();
        }
        return k.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo ia() {
        if (this.f48677r == null) {
            this.f48677r = new DownloadShortInfo();
        }
        return this.f48677r;
    }

    private void k() {
        SoftReference<OnItemClickListener> softReference = this.f48678s;
        if (softReference != null && softReference.get() != null) {
            this.f48678s.get().onItemClick(this.ys, a(), bk());
            this.f48678s = null;
            return;
        }
        k.w().c(getContext(), this.ys, bk(), a());
    }

    private void t() {
        String str = f48671c;
        com.ss.android.downloadlib.r.k.c(str, "pICD", null);
        if (this.xv.sr(this.ev)) {
            com.ss.android.downloadlib.r.k.c(str, "pICD BC", null);
            f(false);
            return;
        }
        com.ss.android.downloadlib.r.k.c(str, "pICD IC", null);
        k();
    }

    private boolean ys() {
        if (com.ss.android.socialbase.downloader.r.c.xv().c("fix_click_start")) {
            DownloadInfo downloadInfo = this.ev;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.ev.getCurBytes() <= 0) || this.ev.getStatus() == 0 || this.ev.getStatus() == -4) {
                return true;
            }
            return com.ss.android.socialbase.downloader.gd.f.c(this.ev.getStatus(), this.ev.getSavePath(), this.ev.getName());
        }
        DownloadInfo downloadInfo2 = this.ev;
        if (downloadInfo2 == null) {
            return true;
        }
        return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(k.getContext()).canResume(this.ev.getId())) || this.ev.getStatus() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(boolean z3) {
        for (DownloadStatusChangeListener downloadStatusChangeListener : ev.c(this.f48673f)) {
            downloadStatusChangeListener.onDownloadStart(this.ys, bk());
        }
        int c4 = this.xv.c(k.getContext(), this.f48676p);
        String str = f48671c;
        com.ss.android.downloadlib.r.k.c(str, "beginDown id:" + c4, null);
        if (c4 != 0) {
            if (this.ev != null && !com.ss.android.socialbase.downloader.r.c.xv().c("fix_click_start")) {
                this.xv.c(this.ev, false);
            } else if (z3) {
                this.xv.c();
            }
        } else {
            DownloadInfo c5 = new DownloadInfo.c(this.ys.getDownloadUrl()).c();
            c5.setStatus(-1);
            c(c5);
            com.ss.android.downloadlib.sr.c.c().c(this.f48679t, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.ux.xv.c().w("beginDown");
        }
        if (this.xv.c(xv())) {
            com.ss.android.downloadlib.r.k.c(str, "beginDown IC id:" + c4, null);
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final boolean z3) {
        this.sr.c(new com.ss.android.downloadlib.addownload.w.ux(this.f48679t, this.ys, a(), bk()));
        this.sr.c(0, 0L, 0L, new c() { // from class: com.ss.android.downloadlib.addownload.ux.9
            @Override // com.ss.android.downloadlib.addownload.ux.c
            public void c() {
                if (ux.this.sr.c()) {
                    return;
                }
                ux.this.ev(z3);
            }
        });
    }

    public void f() {
        this.f48681w.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.ux.2
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadStatusChangeListener downloadStatusChangeListener : ev.c(ux.this.f48673f)) {
                    downloadStatusChangeListener.onInstalled(ux.this.ia());
                }
            }
        });
    }

    public boolean gd() {
        SoftReference<IDownloadButtonClickListener> softReference = this.f48674i;
        if (softReference == null) {
            return false;
        }
        return gd.c(this.ys, softReference.get());
    }

    public long sr() {
        return this.f48672a;
    }

    public boolean ux() {
        return k.gd().optInt("quick_app_enable_switch", 0) == 0 && this.ys.getQuickAppModel() != null && !TextUtils.isEmpty(this.ys.getQuickAppModel().c()) && com.ss.android.downloadlib.addownload.xv.c(this.ev) && com.ss.android.downloadlib.r.a.c(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.ys.getQuickAppModel().c())));
    }

    public boolean xv() {
        DownloadInfo downloadInfo = this.ev;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    private void f(final boolean z3) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = f48671c;
        com.ss.android.downloadlib.r.k.c(str, "pBCD", null);
        if (ys()) {
            com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(this.f48679t);
            if (this.fz) {
                if (gd()) {
                    if (sr(false) && (downloadController2 = ux.sr) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        c(z3, true);
                        return;
                    }
                    return;
                }
                c(z3, true);
                return;
            } else if (this.ys.isAd() && (downloadController = ux.sr) != null && downloadController.enableShowComplianceDialog() && ux.f48723w != null && com.ss.android.downloadlib.addownload.compliance.w.c().c(ux.f48723w) && com.ss.android.downloadlib.addownload.compliance.w.c().c(ux)) {
                return;
            } else {
                c(z3, true);
                return;
            }
        }
        com.ss.android.downloadlib.r.k.c(str, "pBCD continue download, status:" + this.ev.getStatus(), null);
        DownloadInfo downloadInfo = this.ev;
        if (downloadInfo != null && (downloadModel = this.ys) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.ev.getStatus();
        final int id = this.ev.getId();
        final com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(this.ev);
        if (status != -2 && status != -1) {
            if (bk.c(status)) {
                if (this.ys.enablePause()) {
                    this.sr.c(true);
                    com.ss.android.downloadlib.xv.ev.c().w(com.ss.android.downloadlib.addownload.w.f.c().sr(this.f48679t));
                    if (com.ss.android.downloadlib.r.ux.c(c4).c("cancel_pause_optimise_switch", 0) == 1) {
                        com.ss.android.downloadlib.addownload.sr.sr.c().c(c4, status, new com.ss.android.downloadlib.addownload.sr.ev() { // from class: com.ss.android.downloadlib.addownload.ux.6
                            @Override // com.ss.android.downloadlib.addownload.sr.ev
                            public void c(com.ss.android.downloadad.api.c.w wVar) {
                                if (ux.this.ev == null && com.ss.android.socialbase.downloader.r.c.xv().c("fix_handle_pause")) {
                                    ux.this.ev = Downloader.getInstance(k.getContext()).getDownloadInfo(id);
                                }
                                ux.this.xv.c(ux.this.ev, z3);
                                if (ux.this.ev != null && com.ss.android.socialbase.downloader.gd.f.w(k.getContext()) && ux.this.ev.isPauseReserveOnWifi()) {
                                    ux.this.ev.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.sr.c.c().c("cancel_pause_reserve_wifi_cancel_on_wifi", c4);
                                    return;
                                }
                                ux uxVar = ux.this;
                                uxVar.c(id, status, uxVar.ev);
                            }
                        }, new com.ss.android.downloadlib.addownload.c.xv() { // from class: com.ss.android.downloadlib.addownload.ux.5
                            @Override // com.ss.android.downloadlib.addownload.c.xv
                            public void delete() {
                                ux.this.c(true);
                            }
                        });
                        return;
                    } else {
                        com.ss.android.downloadlib.addownload.sr.k.c().c(c4, status, new com.ss.android.downloadlib.addownload.sr.ev() { // from class: com.ss.android.downloadlib.addownload.ux.7
                            @Override // com.ss.android.downloadlib.addownload.sr.ev
                            public void c(com.ss.android.downloadad.api.c.w wVar) {
                                if (ux.this.ev == null && com.ss.android.socialbase.downloader.r.c.xv().c("fix_handle_pause")) {
                                    ux.this.ev = Downloader.getInstance(k.getContext()).getDownloadInfo(id);
                                }
                                ux.this.xv.c(ux.this.ev, z3);
                                if (ux.this.ev != null && com.ss.android.socialbase.downloader.gd.f.w(k.getContext()) && ux.this.ev.isPauseReserveOnWifi()) {
                                    ux.this.ev.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.sr.c.c().w("pause_reserve_wifi_cancel_on_wifi", c4);
                                    return;
                                }
                                ux uxVar = ux.this;
                                uxVar.c(id, status, uxVar.ev);
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.xv.c(this.ev, z3);
            c(id, status, this.ev);
            return;
        }
        this.xv.c(this.ev, z3);
        if (c4 != null) {
            c4.ev(System.currentTimeMillis());
            c4.gd(this.ev.getCurBytes());
        }
        this.ev.setDownloadFromReserveWifi(false);
        this.sr.c(new com.ss.android.downloadlib.addownload.w.ux(this.f48679t, this.ys, a(), bk()));
        this.sr.c(id, this.ev.getCurBytes(), this.ev.getTotalBytes(), new c() { // from class: com.ss.android.downloadlib.addownload.ux.3
            @Override // com.ss.android.downloadlib.addownload.ux.c
            public void c() {
                if (ux.this.sr.c()) {
                    return;
                }
                ux uxVar = ux.this;
                uxVar.c(id, status, uxVar.ev);
            }
        });
        if (status == -2 && com.ss.android.downloadlib.r.ux.c(c4).c("show_pause_continue_toast", 0) == 1) {
            com.ss.android.downloadlib.r.c().w().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.ux.4
                @Override // java.lang.Runnable
                public void run() {
                    k.xv().c(13, k.getContext(), ux.this.ys, "\u5df2\u6062\u590d\u4e0b\u8f7d", null, 0);
                }
            }, 500L);
        }
    }

    private boolean xv(int i4) {
        if (ux()) {
            int i5 = -1;
            String c4 = this.ys.getQuickAppModel().c();
            if (i4 == 1) {
                i5 = 5;
            } else if (i4 == 2) {
                i5 = 4;
            }
            DownloadModel downloadModel = this.ys;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            boolean xv2 = com.ss.android.downloadlib.r.gd.xv(k.getContext(), c4);
            if (xv2) {
                com.ss.android.downloadlib.sr.c.c().c(this.f48679t, i4);
                Message obtain = Message.obtain();
                obtain.what = i5;
                obtain.obj = Long.valueOf(this.ys.getId());
                com.ss.android.downloadlib.addownload.xv.c().c(this, i5, this.ys);
            } else {
                com.ss.android.downloadlib.sr.c.c().c(this.f48679t, false, 0);
            }
            return xv2;
        }
        return false;
    }

    public boolean sr(boolean z3) {
        SoftReference<IDownloadButtonClickListener> softReference = this.f48674i;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z3) {
                    this.f48674i.get().handleComplianceDialog(true);
                } else {
                    this.f48674i.get().handleMarketFailedComplianceDialog();
                }
                this.f48674i = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.ux.xv.c().w("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.ux.xv.c().w("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void r() {
        if (this.f48673f.size() == 0) {
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : ev.c(this.f48673f)) {
            downloadStatusChangeListener.onIdle();
        }
        DownloadInfo downloadInfo = this.ev;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    /* renamed from: c */
    public ux w(Context context) {
        if (context != null) {
            this.ux = new WeakReference<>(context);
        }
        k.w(context);
        return this;
    }

    private void ux(boolean z3) {
        if (com.ss.android.downloadlib.r.ux.w(this.ys).w("notification_opt_2") == 1 && this.ev != null) {
            com.ss.android.socialbase.downloader.notification.w.c().f(this.ev.getId());
        }
        f(z3);
    }

    /* renamed from: c */
    public ux w(int i4, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (k.gd().optInt("back_use_softref_listener") == 1) {
                this.f48673f.put(Integer.valueOf(i4), downloadStatusChangeListener);
            } else if (k.gd().optInt("use_weakref_listener") == 1) {
                this.f48673f.put(Integer.valueOf(i4), new WeakReference(downloadStatusChangeListener));
            } else {
                this.f48673f.put(Integer.valueOf(i4), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    public boolean w() {
        return this.f48675k;
    }

    public void w(final int i4) {
        if (i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.xv.c(this.f48679t);
        if (!com.ss.android.downloadlib.addownload.w.f.c().ux(this.f48679t).gb()) {
            com.ss.android.downloadlib.ux.xv.c().c("handleDownload ModelBox !isStrictValid");
        }
        if (this.xv.c(i4, this.ys)) {
            com.ss.android.downloadlib.addownload.compliance.f.c().c(this.xv.f48525c, new com.ss.android.downloadlib.addownload.compliance.ev() { // from class: com.ss.android.downloadlib.addownload.ux.1
                @Override // com.ss.android.downloadlib.addownload.compliance.ev
                public void c(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!com.ss.android.downloadlib.r.ev.c(ux.this.getContext(), ux.this.xv.f48525c, str, jSONObject, true, i4)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.ss.android.downloadlib.addownload.compliance.f.c().c(1, ux.this.xv.f48525c, jSONObject);
                            int i5 = i4;
                            if (i5 == 1) {
                                String str2 = ux.f48671c;
                                com.ss.android.socialbase.downloader.xv.c.c(str2, "miui new rollback fail: handleDownload id:" + ux.this.f48679t + ",tryPerformButtonClick:", null);
                                ux.this.xv(true);
                            } else if (i5 == 2) {
                                String str3 = ux.f48671c;
                                com.ss.android.socialbase.downloader.xv.c.c(str3, "miui new rollback fail: handleDownload id:" + ux.this.f48679t + ",tryPerformButtonClick:", null);
                                ux.this.w(true);
                            }
                        } else {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            com.ss.android.downloadlib.addownload.compliance.f.c().c(0, ux.this.xv.f48525c, jSONObject);
                        }
                    } catch (Exception e4) {
                        com.ss.android.downloadlib.ux.xv.c().c(e4, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.ev
                public void c() {
                    int i5 = i4;
                    if (i5 == 1) {
                        String str = ux.f48671c;
                        com.ss.android.socialbase.downloader.xv.c.c(str, "miui new get miui deeplink fail: handleDownload id:" + ux.this.f48679t + ",tryPerformButtonClick:", null);
                        ux.this.xv(true);
                    } else if (i5 != 2) {
                    } else {
                        String str2 = ux.f48671c;
                        com.ss.android.socialbase.downloader.xv.c.c(str2, "miui new get miui deeplink fail: handleDownload id:" + ux.this.f48679t + ",tryPerformButtonClick:", null);
                        ux.this.w(true);
                    }
                }
            });
        } else if (this.xv.c(getContext(), i4, this.fz)) {
        } else {
            boolean xv2 = xv(i4);
            if (i4 == 1) {
                if (xv2) {
                    return;
                }
                String str = f48671c;
                com.ss.android.downloadlib.r.k.c(str, "handleDownload id:" + this.f48679t + ",pIC:", null);
                xv(true);
            } else if (i4 == 2 && !xv2) {
                String str2 = f48671c;
                com.ss.android.downloadlib.r.k.c(str2, "handleDownload id:" + this.f48679t + ",pBC:", null);
                w(true);
            }
        }
    }

    /* renamed from: c */
    public ux w(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.ux.xv.c().c("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.ux.xv.c().c(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.r.c.xv().c("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.w.f.c().c(downloadModel);
            this.f48679t = downloadModel.getId();
            this.ys = downloadModel;
            if (gd.c(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.c.w sr = com.ss.android.downloadlib.addownload.w.f.c().sr(this.f48679t);
                if (sr != null && sr.a() != 3) {
                    sr.ux(3L);
                    com.ss.android.downloadlib.addownload.w.gd.c().c(sr);
                }
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public class xv extends com.bytedance.sdk.component.gd.sr.w<String, Void, DownloadInfo> {
        private xv() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr != null) {
                if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                    String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
                    String str2 = strArr[0];
                    if (ux.this.ys != null && !TextUtils.isEmpty(ux.this.ys.getFilePath())) {
                        if (TextUtils.isEmpty(str)) {
                            downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(str2, ux.this.ys.getFilePath());
                        } else {
                            downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(Downloader.getInstance(k.getContext()).getDownloadId(str, ux.this.ys.getFilePath()));
                        }
                    }
                    if (downloadInfo == null) {
                        if (!TextUtils.isEmpty(str)) {
                            return com.ss.android.socialbase.appdownloader.sr.p().c(k.getContext(), str);
                        }
                        return com.ss.android.socialbase.appdownloader.sr.p().c(k.getContext(), str2);
                    }
                    return downloadInfo;
                }
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || ux.this.ys == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.w.xv c4 = com.ss.android.downloadlib.r.a.c(ux.this.ys.getPackageName(), ux.this.ys.getVersionCode(), ux.this.ys.getVersionName());
                com.ss.android.downloadlib.addownload.w.ev.c().c(ux.this.ys.getVersionCode(), c4.w(), com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo));
                boolean c5 = c4.c();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (c5 || !Downloader.getInstance(k.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(k.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (ux.this.ev == null || ux.this.ev.getStatus() != -4) {
                        ux.this.ev = downloadInfo;
                        if (ux.this.f48680u) {
                            Downloader.getInstance(k.getContext()).setMainThreadListener(ux.this.ev.getId(), ux.this.f48676p, false);
                        } else {
                            Downloader.getInstance(k.getContext()).setMainThreadListener(ux.this.ev.getId(), ux.this.f48676p);
                        }
                    } else {
                        ux.this.ev = null;
                    }
                    ux.this.xv.c(ux.this.ev, ux.this.ia(), ev.c(ux.this.f48673f));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(k.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.w.c().f(downloadInfo.getId());
                        ux.this.ev = null;
                    }
                    if (ux.this.ev != null) {
                        Downloader.getInstance(k.getContext()).removeTaskMainListener(ux.this.ev.getId());
                        if (ux.this.f48680u) {
                            Downloader.getInstance(ux.this.getContext()).setMainThreadListener(ux.this.ev.getId(), ux.this.f48676p, false);
                        } else {
                            Downloader.getInstance(ux.this.getContext()).setMainThreadListener(ux.this.ev.getId(), ux.this.f48676p);
                        }
                    }
                    if (!c5) {
                        for (DownloadStatusChangeListener downloadStatusChangeListener : ev.c(ux.this.f48673f)) {
                            downloadStatusChangeListener.onIdle();
                        }
                        ux.this.ev = null;
                    } else {
                        ux uxVar = ux.this;
                        uxVar.ev = new DownloadInfo.c(uxVar.ys.getDownloadUrl()).c();
                        ux.this.ev.setStatus(-3);
                        ux.this.xv.c(ux.this.ev, ux.this.ia(), ev.c(ux.this.f48673f));
                    }
                }
                ux.this.xv.xv(ux.this.ev);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void xv(boolean z3) {
        if (z3) {
            com.ss.android.downloadlib.sr.c.c().c(this.f48679t, 1);
        }
        t();
    }

    public void ev() {
        com.ss.android.downloadlib.addownload.w.f.c().f(this.f48679t);
    }

    public void w(boolean z3) {
        ux(z3);
    }

    /* renamed from: c */
    public ux w(DownloadController downloadController) {
        JSONObject extra;
        this.ia = downloadController;
        if (com.ss.android.downloadlib.r.ux.w(this.ys).w("force_auto_open") == 1) {
            bk().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.r.c.xv().c("fix_show_dialog") && (extra = this.ys.getExtra()) != null && extra.optInt("subprocess") > 0) {
            bk().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.w.f.c().c(this.f48679t, bk());
        return this;
    }

    /* renamed from: c */
    public ux w(DownloadEventConfig downloadEventConfig) {
        this.fp = downloadEventConfig;
        this.fz = a().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.w.f.c().c(this.f48679t, a());
        return this;
    }

    public r c(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.f48678s = null;
        } else {
            this.f48678s = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    public void c() {
        this.f48675k = true;
        com.ss.android.downloadlib.addownload.w.f.c().c(this.f48679t, a());
        com.ss.android.downloadlib.addownload.w.f.c().c(this.f48679t, bk());
        this.xv.c(this.f48679t);
        fp();
        if (k.gd().optInt("enable_empty_listener", 1) == 1 && this.f48673f.get(Integer.MIN_VALUE) == null) {
            w(Integer.MIN_VALUE, new com.ss.android.download.api.config.c());
        }
    }

    public boolean c(int i4) {
        if (i4 == 0) {
            this.f48673f.clear();
        } else {
            this.f48673f.remove(Integer.valueOf(i4));
        }
        if (this.f48673f.isEmpty()) {
            this.f48675k = false;
            this.f48672a = System.currentTimeMillis();
            if (this.ev != null) {
                Downloader.getInstance(k.getContext()).removeTaskMainListener(this.ev.getId());
            }
            xv xvVar = this.gd;
            if (xvVar != null && xvVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.gd.cancel(true);
            }
            this.xv.c(this.ev);
            String str = f48671c;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.ev;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.r.k.c(str, sb.toString(), null);
            this.f48681w.removeCallbacksAndMessages(null);
            this.f48677r = null;
            this.ev = null;
            return true;
        }
        if (this.f48673f.size() == 1 && this.f48673f.containsKey(Integer.MIN_VALUE)) {
            this.xv.w(this.ev);
        }
        return false;
    }

    public void c(boolean z3) {
        if (this.ev != null) {
            if (z3) {
                com.ss.android.socialbase.appdownloader.xv.sr w3 = com.ss.android.socialbase.appdownloader.sr.p().w();
                if (w3 != null) {
                    w3.c(this.ev);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).cancel(this.ev.getId(), true);
                return;
            }
            Intent intent = new Intent(k.getContext(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.ev.getId());
            k.getContext().startService(intent);
        }
    }

    public r c(long j4) {
        if (j4 != 0) {
            DownloadModel c4 = com.ss.android.downloadlib.addownload.w.f.c().c(j4);
            if (c4 != null) {
                this.ys = c4;
                this.f48679t = j4;
                this.xv.c(j4);
            }
        } else {
            com.ss.android.downloadlib.ux.xv.c().c(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.r.bk.c
    public void c(Message message) {
        if (message != null && this.f48675k && message.what == 3) {
            this.ev = (DownloadInfo) message.obj;
            this.xv.c(message, ia(), this.f48673f);
        }
    }

    public void c(boolean z3, final boolean z4) {
        if (z3) {
            com.ss.android.downloadlib.sr.c.c().c(this.f48679t, 2);
        }
        if (!com.ss.android.downloadlib.r.a.c()) {
            if (!com.ss.android.downloadlib.r.p.w("android.permission.WRITE_EXTERNAL_STORAGE") && !bk().enableNewActivity()) {
                this.ys.setFilePath(this.xv.w());
            }
        } else if (!com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.r.p.w("android.permission.READ_MEDIA_VIDEO") && !bk().enableNewActivity()) {
            this.ys.setFilePath(this.xv.w());
        }
        if (com.ss.android.downloadlib.r.ux.xv(this.ys) == 0) {
            com.ss.android.downloadlib.r.k.c(f48671c, "pBCD not start", null);
            this.xv.c(new u() { // from class: com.ss.android.downloadlib.addownload.ux.8
                @Override // com.ss.android.download.api.config.u
                public void c() {
                    com.ss.android.downloadlib.r.k.c(ux.f48671c, "pBCD start download", null);
                    ux.this.r(z4);
                }

                @Override // com.ss.android.download.api.config.u
                public void c(String str) {
                    com.ss.android.downloadlib.r.k.c(ux.f48671c, "pBCD onDenied", null);
                }
            });
            return;
        }
        r(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, int i5, @NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.r.c.xv().c("fix_click_start")) {
            if (i5 != -3 && !com.ss.android.socialbase.downloader.downloader.sr.c().ux(i4)) {
                c(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.sr.p().c(k.getContext(), i4, i5);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.sr.p().c(k.getContext(), i4, i5);
    }

    private void c(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.f48681w.sendMessage(obtain);
    }

    public r c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bk = str;
        }
        return this;
    }

    public r c(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.f48674i = null;
        } else {
            this.f48674i = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
