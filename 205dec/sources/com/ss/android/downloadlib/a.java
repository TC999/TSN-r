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
import com.ss.android.download.api.model.a;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.q;
import com.ss.android.downloadlib.n.a;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements com.ss.android.downloadad.api.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f48326a = null;
    private static String ok = "a";
    private p bl = p.ok(com.ss.android.downloadlib.addownload.r.getContext());

    private a() {
    }

    public static DownloadEventConfig bl() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog a(Context context, String str, boolean z3, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i4, boolean z4, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (ok(downloadModel.getId())) {
            if (z4) {
                ok(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                a(downloadModel.getId());
            }
            return null;
        } else if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        } else {
            this.bl.ok(context, i4, downloadStatusChangeListener, downloadModel);
            boolean z5 = true;
            final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) j.ok(downloadEventConfig, bl());
            final DownloadController downloadController2 = (DownloadController) j.ok(downloadController, a());
            downloadEventConfig2.setDownloadScene(1);
            boolean z6 = (com.ss.android.downloadlib.addownload.r.q().optInt("disable_lp_dialog", 0) == 1) | z3;
            if (!downloadController2.enableShowComplianceDialog() || !com.ss.android.downloadlib.addownload.compliance.a.ok().ok(downloadModel)) {
                z5 = z6;
            }
            if (z5) {
                this.bl.ok(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
                return null;
            }
            String str2 = ok;
            com.ss.android.downloadlib.h.r.ok(str2, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
            Dialog a4 = com.ss.android.downloadlib.addownload.r.bl().a(new a.ok(context).ok(downloadModel.getName()).a("\u786e\u8ba4\u8981\u4e0b\u8f7d\u6b64\u5e94\u7528\u5417\uff1f").bl("\u786e\u8ba4").s("\u53d6\u6d88").ok(new a.InterfaceC0935a() { // from class: com.ss.android.downloadlib.a.2
                @Override // com.ss.android.download.api.model.a.InterfaceC0935a
                public void a(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.s.ok.ok().ok("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.download.api.model.a.InterfaceC0935a
                public void bl(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.s.ok.ok().ok("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                }

                @Override // com.ss.android.download.api.model.a.InterfaceC0935a
                public void ok(DialogInterface dialogInterface) {
                    a.this.bl.ok(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                    com.ss.android.downloadlib.s.ok.ok().ok("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }
            }).ok(0).ok());
            com.ss.android.downloadlib.s.ok.ok().ok("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
            return a4;
        }
    }

    public static a ok() {
        if (f48326a == null) {
            synchronized (a.class) {
                if (f48326a == null) {
                    f48326a = new a();
                }
            }
        }
        return f48326a;
    }

    @Override // com.ss.android.downloadad.api.a
    public Dialog ok(Context context, String str, boolean z3, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i4) {
        return ok(context, str, z3, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i4, false);
    }

    @Override // com.ss.android.downloadad.api.a
    public Dialog ok(Context context, String str, boolean z3, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i4, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ok(context, str, z3, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i4, false, iDownloadButtonClickListener);
    }

    public Dialog ok(Context context, String str, boolean z3, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i4, boolean z4) {
        return ok(context, str, z3, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i4, z4, null);
    }

    public Dialog ok(final Context context, final String str, final boolean z3, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i4, final boolean z4, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.n.a.ok(new a.ok<Dialog>() { // from class: com.ss.android.downloadlib.a.1
            @Override // com.ss.android.downloadlib.n.a.ok
            /* renamed from: ok */
            public Dialog a() {
                return a.this.a(context, str, z3, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i4, z4, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(Context context, long j4, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i4) {
        com.ss.android.downloadad.api.ok.a s3 = com.ss.android.downloadlib.addownload.a.kf.ok().s(j4);
        if (s3 != null) {
            this.bl.ok(context, i4, downloadStatusChangeListener, s3.d());
            return true;
        }
        DownloadModel ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j4);
        if (ok2 != null) {
            this.bl.ok(context, i4, downloadStatusChangeListener, ok2);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(long j4, int i4) {
        DownloadModel ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j4);
        if (ok2 != null) {
            this.bl.ok(ok2.getDownloadUrl(), i4);
            return true;
        }
        return false;
    }

    public void ok(long j4, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j4);
        com.ss.android.downloadad.api.ok.a s3 = com.ss.android.downloadlib.addownload.a.kf.ok().s(j4);
        if (ok2 == null && s3 != null) {
            ok2 = s3.d();
        }
        if (ok2 == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.bl) && !(downloadController instanceof com.ss.android.download.api.download.a)) {
            downloadEventConfig.setDownloadScene(1);
            this.bl.ok(ok2.getDownloadUrl(), j4, 2, downloadEventConfig, downloadController);
            return;
        }
        a(j4);
    }

    public void a(long j4) {
        DownloadModel ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j4);
        com.ss.android.downloadad.api.ok.a s3 = com.ss.android.downloadlib.addownload.a.kf.ok().s(j4);
        if (ok2 == null && s3 != null) {
            ok2 = s3.d();
        }
        if (ok2 == null) {
            return;
        }
        DownloadEventConfig a4 = com.ss.android.downloadlib.addownload.a.kf.ok().a(j4);
        DownloadController bl = com.ss.android.downloadlib.addownload.a.kf.ok().bl(j4);
        if (a4 instanceof com.ss.android.download.api.download.bl) {
            a4 = null;
        }
        if (bl instanceof com.ss.android.download.api.download.a) {
            bl = null;
        }
        if (s3 == null) {
            if (a4 == null) {
                a4 = bl();
            }
            if (bl == null) {
                bl = a();
            }
        } else {
            if (a4 == null) {
                a4 = new AdDownloadEventConfig.Builder().setClickButtonTag(s3.k()).setRefer(s3.q()).setIsEnableV3Event(s3.z()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (bl == null) {
                bl = s3.c();
            }
        }
        DownloadEventConfig downloadEventConfig = a4;
        downloadEventConfig.setDownloadScene(1);
        this.bl.ok(ok2.getDownloadUrl(), j4, 2, downloadEventConfig, bl);
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(long j4) {
        return (com.ss.android.downloadlib.addownload.a.kf.ok().ok(j4) == null && com.ss.android.downloadlib.addownload.a.kf.ok().s(j4) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return ok(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.n.a.ok(new a.ok<Boolean>() { // from class: com.ss.android.downloadlib.a.3
            @Override // com.ss.android.downloadlib.n.a.ok
            /* renamed from: ok */
            public Boolean a() {
                return Boolean.valueOf(a.this.a(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController ok(boolean z3) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z3) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadController2 = downloadController;
        if (com.ss.android.download.api.bl.ok.ok(uri) && com.ss.android.downloadlib.addownload.r.q().optInt("disable_market") != 1) {
            Context context2 = context == null ? com.ss.android.downloadlib.addownload.r.getContext() : context;
            String a4 = com.ss.android.download.api.bl.ok.a(uri);
            if (downloadModel == null) {
                return q.ok(context2, a4).getType() == 5;
            }
            if (!TextUtils.isEmpty(a4) && (downloadModel instanceof AdDownloadModel)) {
                ((AdDownloadModel) downloadModel).setPackageName(a4);
            }
            if (downloadController2 != null) {
                downloadController2.setDownloadMode(2);
            } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
                ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
                downloadController2 = ok(true);
            } else if (downloadModel.getDownloadUrl().startsWith("market")) {
                downloadController2 = ok(true);
            } else {
                downloadController2 = a();
            }
            com.ss.android.downloadlib.addownload.a.n nVar = new com.ss.android.downloadlib.addownload.a.n(downloadModel.getId(), downloadModel, (DownloadEventConfig) j.ok(downloadEventConfig, bl()), downloadController2);
            com.ss.android.downloadlib.addownload.a.kf.ok().ok(nVar.f48371a);
            com.ss.android.downloadlib.addownload.a.kf.ok().ok(nVar.ok, nVar.bl);
            com.ss.android.downloadlib.addownload.a.kf.ok().ok(nVar.ok, nVar.f48373s);
            if (j.ok(downloadModel) && com.ss.android.socialbase.downloader.h.ok.bl().a("app_link_opt") == 1 && com.ss.android.downloadlib.a.ok.ok(nVar)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            j.ok(jSONObject, "market_url", uri.toString());
            j.ok(jSONObject, "download_scene", (Object) 1);
            com.ss.android.downloadlib.s.ok.ok().a("market_click_open", jSONObject, nVar);
            com.ss.android.downloadlib.addownload.a.h ok2 = q.ok(context2, nVar, a4);
            String ok3 = j.ok(ok2.a(), "open_market");
            if (ok2.getType() == 5) {
                com.ss.android.downloadlib.a.ok.ok(ok3, jSONObject, nVar, true);
                return true;
            } else if (ok2.getType() == 6) {
                j.ok(jSONObject, "error_code", Integer.valueOf(ok2.ok()));
                com.ss.android.downloadlib.s.ok.ok().a("market_open_failed", jSONObject, nVar);
                if (com.ss.android.downloadlib.addownload.q.ok(downloadModel, iDownloadButtonClickListener)) {
                    iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
                }
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static DownloadController a() {
        return ok(false);
    }
}
