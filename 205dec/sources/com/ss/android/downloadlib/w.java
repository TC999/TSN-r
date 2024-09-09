package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.w;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.gd;
import com.ss.android.downloadlib.ux.w;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements com.ss.android.downloadad.api.w {

    /* renamed from: c  reason: collision with root package name */
    private static String f48952c = "w";

    /* renamed from: w  reason: collision with root package name */
    private static volatile w f48953w;
    private ev xv = ev.c(k.getContext());

    private w() {
    }

    public static DownloadEventConfig xv() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog w(Context context, String str, boolean z3, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i4, boolean z4, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (c(downloadModel.getId())) {
            if (z4) {
                c(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                w(downloadModel.getId());
            }
            return null;
        } else if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        } else {
            this.xv.c(context, i4, downloadStatusChangeListener, downloadModel);
            boolean z5 = true;
            final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) com.ss.android.downloadlib.r.a.c(downloadEventConfig, xv());
            final DownloadController downloadController2 = (DownloadController) com.ss.android.downloadlib.r.a.c(downloadController, w());
            downloadEventConfig2.setDownloadScene(1);
            boolean z6 = (k.gd().optInt("disable_lp_dialog", 0) == 1) | z3;
            if (!downloadController2.enableShowComplianceDialog() || !com.ss.android.downloadlib.addownload.compliance.w.c().c(downloadModel)) {
                z5 = z6;
            }
            if (z5) {
                this.xv.c(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
                return null;
            }
            String str2 = f48952c;
            com.ss.android.downloadlib.r.k.c(str2, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
            Dialog w3 = k.xv().w(new w.c(context).c(downloadModel.getName()).w("\u786e\u8ba4\u8981\u4e0b\u8f7d\u6b64\u5e94\u7528\u5417\uff1f").xv("\u786e\u8ba4").sr("\u53d6\u6d88").c(new w.InterfaceC0938w() { // from class: com.ss.android.downloadlib.w.2
                @Override // com.ss.android.download.api.model.w.InterfaceC0938w
                public void c(DialogInterface dialogInterface) {
                    w.this.xv.c(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                    com.ss.android.downloadlib.sr.c.c().c("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.download.api.model.w.InterfaceC0938w
                public void w(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.sr.c.c().c("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.download.api.model.w.InterfaceC0938w
                public void xv(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.sr.c.c().c("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                }
            }).c(0).c());
            com.ss.android.downloadlib.sr.c.c().c("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
            return w3;
        }
    }

    public static w c() {
        if (f48953w == null) {
            synchronized (w.class) {
                if (f48953w == null) {
                    f48953w = new w();
                }
            }
        }
        return f48953w;
    }

    @Override // com.ss.android.downloadad.api.w
    public Dialog c(Context context, String str, boolean z3, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i4) {
        return c(context, str, z3, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i4, false);
    }

    @Override // com.ss.android.downloadad.api.w
    public Dialog c(Context context, String str, boolean z3, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i4, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return c(context, str, z3, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i4, false, iDownloadButtonClickListener);
    }

    public Dialog c(Context context, String str, boolean z3, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i4, boolean z4) {
        return c(context, str, z3, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i4, z4, null);
    }

    public Dialog c(final Context context, final String str, final boolean z3, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i4, final boolean z4, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.ux.w.c(new w.c<Dialog>() { // from class: com.ss.android.downloadlib.w.1
            @Override // com.ss.android.downloadlib.ux.w.c
            /* renamed from: c */
            public Dialog w() {
                return w.this.w(context, str, z3, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i4, z4, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.w
    public boolean c(Context context, long j4, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i4) {
        com.ss.android.downloadad.api.c.w sr = com.ss.android.downloadlib.addownload.w.f.c().sr(j4);
        if (sr != null) {
            this.xv.c(context, i4, downloadStatusChangeListener, sr.ta());
            return true;
        }
        DownloadModel c4 = com.ss.android.downloadlib.addownload.w.f.c().c(j4);
        if (c4 != null) {
            this.xv.c(context, i4, downloadStatusChangeListener, c4);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadad.api.w
    public boolean c(long j4, int i4) {
        DownloadModel c4 = com.ss.android.downloadlib.addownload.w.f.c().c(j4);
        if (c4 != null) {
            this.xv.c(c4.getDownloadUrl(), i4);
            return true;
        }
        return false;
    }

    public void c(long j4, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel c4 = com.ss.android.downloadlib.addownload.w.f.c().c(j4);
        com.ss.android.downloadad.api.c.w sr = com.ss.android.downloadlib.addownload.w.f.c().sr(j4);
        if (c4 == null && sr != null) {
            c4 = sr.ta();
        }
        if (c4 == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.xv) && !(downloadController instanceof com.ss.android.download.api.download.w)) {
            downloadEventConfig.setDownloadScene(1);
            this.xv.c(c4.getDownloadUrl(), j4, 2, downloadEventConfig, downloadController);
            return;
        }
        w(j4);
    }

    public void w(long j4) {
        DownloadModel c4 = com.ss.android.downloadlib.addownload.w.f.c().c(j4);
        com.ss.android.downloadad.api.c.w sr = com.ss.android.downloadlib.addownload.w.f.c().sr(j4);
        if (c4 == null && sr != null) {
            c4 = sr.ta();
        }
        if (c4 == null) {
            return;
        }
        DownloadEventConfig w3 = com.ss.android.downloadlib.addownload.w.f.c().w(j4);
        DownloadController xv = com.ss.android.downloadlib.addownload.w.f.c().xv(j4);
        if (w3 instanceof com.ss.android.download.api.download.xv) {
            w3 = null;
        }
        if (xv instanceof com.ss.android.download.api.download.w) {
            xv = null;
        }
        if (sr == null) {
            if (w3 == null) {
                w3 = xv();
            }
            if (xv == null) {
                xv = w();
            }
        } else {
            if (w3 == null) {
                w3 = new AdDownloadEventConfig.Builder().setClickButtonTag(sr.p()).setRefer(sr.gd()).setIsEnableV3Event(sr.bk()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (xv == null) {
                xv = sr.be();
            }
        }
        DownloadEventConfig downloadEventConfig = w3;
        downloadEventConfig.setDownloadScene(1);
        this.xv.c(c4.getDownloadUrl(), j4, 2, downloadEventConfig, xv);
    }

    @Override // com.ss.android.downloadad.api.w
    public boolean c(long j4) {
        return (com.ss.android.downloadlib.addownload.w.f.c().c(j4) == null && com.ss.android.downloadlib.addownload.w.f.c().sr(j4) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.w
    public boolean c(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return c(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.w
    public boolean c(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.ux.w.c(new w.c<Boolean>() { // from class: com.ss.android.downloadlib.w.3
            @Override // com.ss.android.downloadlib.ux.w.c
            /* renamed from: c */
            public Boolean w() {
                return Boolean.valueOf(w.this.w(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController c(boolean z3) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z3) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadController2 = downloadController;
        if (com.ss.android.download.api.xv.c.c(uri) && k.gd().optInt("disable_market") != 1) {
            Context context2 = context == null ? k.getContext() : context;
            String w3 = com.ss.android.download.api.xv.c.w(uri);
            if (downloadModel == null) {
                return gd.c(context2, w3).getType() == 5;
            }
            if (!TextUtils.isEmpty(w3) && (downloadModel instanceof AdDownloadModel)) {
                ((AdDownloadModel) downloadModel).setPackageName(w3);
            }
            if (downloadController2 != null) {
                downloadController2.setDownloadMode(2);
            } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
                ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
                downloadController2 = c(true);
            } else if (downloadModel.getDownloadUrl().startsWith("market")) {
                downloadController2 = c(true);
            } else {
                downloadController2 = w();
            }
            com.ss.android.downloadlib.addownload.w.ux uxVar = new com.ss.android.downloadlib.addownload.w.ux(downloadModel.getId(), downloadModel, (DownloadEventConfig) com.ss.android.downloadlib.r.a.c(downloadEventConfig, xv()), downloadController2);
            com.ss.android.downloadlib.addownload.w.f.c().c(uxVar.f48723w);
            com.ss.android.downloadlib.addownload.w.f.c().c(uxVar.f48722c, uxVar.xv);
            com.ss.android.downloadlib.addownload.w.f.c().c(uxVar.f48722c, uxVar.sr);
            if (com.ss.android.downloadlib.r.a.c(downloadModel) && com.ss.android.socialbase.downloader.r.c.xv().w("app_link_opt") == 1 && com.ss.android.downloadlib.w.c.c(uxVar)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.r.a.c(jSONObject, "market_url", uri.toString());
            com.ss.android.downloadlib.r.a.c(jSONObject, "download_scene", (Object) 1);
            com.ss.android.downloadlib.sr.c.c().w("market_click_open", jSONObject, uxVar);
            com.ss.android.downloadlib.addownload.w.r c4 = gd.c(context2, uxVar, w3);
            String c5 = com.ss.android.downloadlib.r.a.c(c4.w(), "open_market");
            if (c4.getType() == 5) {
                com.ss.android.downloadlib.w.c.c(c5, jSONObject, uxVar, true);
                return true;
            } else if (c4.getType() == 6) {
                com.ss.android.downloadlib.r.a.c(jSONObject, "error_code", Integer.valueOf(c4.c()));
                com.ss.android.downloadlib.sr.c.c().w("market_open_failed", jSONObject, uxVar);
                if (com.ss.android.downloadlib.addownload.gd.c(downloadModel, iDownloadButtonClickListener)) {
                    iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
                }
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static DownloadController w() {
        return c(false);
    }
}
