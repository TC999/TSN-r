package com.p521ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;
import com.p521ss.android.download.api.download.C11974a;
import com.p521ss.android.download.api.download.C11975bl;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.DownloadStatusChangeListener;
import com.p521ss.android.download.api.model.C11980a;
import com.p521ss.android.download.api.p523bl.C11952ok;
import com.p521ss.android.downloadad.api.InterfaceC11996a;
import com.p521ss.android.downloadad.api.download.AdDownloadController;
import com.p521ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12127q;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.compliance.C12058a;
import com.p521ss.android.downloadlib.addownload.p528a.C12031h;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.p527a.C12018ok;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12215q;
import com.p521ss.android.downloadlib.p534h.C12216r;
import com.p521ss.android.downloadlib.p536n.C12232a;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12000a implements InterfaceC11996a {

    /* renamed from: a */
    private static volatile C12000a f33985a = null;

    /* renamed from: ok */
    private static String f33986ok = "a";

    /* renamed from: bl */
    private C12257p f33987bl = C12257p.m18572ok(C12128r.getContext());

    private C12000a() {
    }

    /* renamed from: bl */
    public static DownloadEventConfig m19424bl() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    /* renamed from: a */
    public Dialog m19425a(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (mo19422ok(downloadModel.getId())) {
            if (z2) {
                m19420ok(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                m19427a(downloadModel.getId());
            }
            return null;
        } else if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        } else {
            this.f33987bl.m18571ok(context, i, downloadStatusChangeListener, downloadModel);
            boolean z3 = true;
            final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) C12197j.m18775ok(downloadEventConfig, m19424bl());
            final DownloadController downloadController2 = (DownloadController) C12197j.m18775ok(downloadController, m19428a());
            downloadEventConfig2.setDownloadScene(1);
            boolean z4 = (C12128r.m18946q().optInt("disable_lp_dialog", 0) == 1) | z;
            if (!downloadController2.enableShowComplianceDialog() || !C12058a.m19228ok().m19224ok(downloadModel)) {
                z3 = z4;
            }
            if (z3) {
                this.f33987bl.m18565ok(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
                return null;
            }
            String str2 = f33986ok;
            C12216r.m18673ok(str2, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
            Dialog mo19529a = C12128r.m18968bl().mo19529a(new C11980a.C11983ok(context).m19598ok(downloadModel.getName()).m19609a("确认要下载此应用吗？").m19607bl("确认").m19594s("取消").m19600ok(new C11980a.InterfaceC11982a() { // from class: com.ss.android.downloadlib.a.2
                @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
                /* renamed from: a */
                public void mo18862a(DialogInterface dialogInterface) {
                    C12270ok.m18539ok().m18527ok("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }

                @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
                /* renamed from: bl */
                public void mo18861bl(DialogInterface dialogInterface) {
                    C12270ok.m18539ok().m18527ok("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                }

                @Override // com.p521ss.android.download.api.model.C11980a.InterfaceC11982a
                /* renamed from: ok */
                public void mo18860ok(DialogInterface dialogInterface) {
                    C12000a.this.f33987bl.m18566ok(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                    C12270ok.m18539ok().m18527ok("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }
            }).m19602ok(0).m19603ok());
            C12270ok.m18539ok().m18527ok("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
            return mo19529a;
        }
    }

    /* renamed from: ok */
    public static C12000a m19423ok() {
        if (f33985a == null) {
            synchronized (C12000a.class) {
                if (f33985a == null) {
                    f33985a = new C12000a();
                }
            }
        }
        return f33985a;
    }

    @Override // com.p521ss.android.downloadad.api.InterfaceC11996a
    /* renamed from: ok */
    public Dialog mo19416ok(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return m19414ok(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.p521ss.android.downloadad.api.InterfaceC11996a
    /* renamed from: ok */
    public Dialog mo19415ok(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return m19413ok(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    /* renamed from: ok */
    public Dialog m19414ok(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return m19413ok(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    /* renamed from: ok */
    public Dialog m19413ok(final Context context, final String str, final boolean z, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) C12232a.m18649ok(new C12232a.InterfaceC12234ok<Dialog>() { // from class: com.ss.android.downloadlib.a.1
            @Override // com.p521ss.android.downloadlib.p536n.C12232a.InterfaceC12234ok
            /* renamed from: ok */
            public Dialog mo18645a() {
                return C12000a.this.m19425a(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.p521ss.android.downloadad.api.InterfaceC11996a
    /* renamed from: ok */
    public boolean mo19419ok(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        C11998a m19311s = C12032kf.m19324ok().m19311s(j);
        if (m19311s != null) {
            this.f33987bl.m18571ok(context, i, downloadStatusChangeListener, m19311s.m19513d());
            return true;
        }
        DownloadModel m19322ok = C12032kf.m19324ok().m19322ok(j);
        if (m19322ok != null) {
            this.f33987bl.m18571ok(context, i, downloadStatusChangeListener, m19322ok);
            return true;
        }
        return false;
    }

    @Override // com.p521ss.android.downloadad.api.InterfaceC11996a
    /* renamed from: ok */
    public boolean mo19421ok(long j, int i) {
        DownloadModel m19322ok = C12032kf.m19324ok().m19322ok(j);
        if (m19322ok != null) {
            this.f33987bl.m18567ok(m19322ok.getDownloadUrl(), i);
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    public void m19420ok(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel m19322ok = C12032kf.m19324ok().m19322ok(j);
        C11998a m19311s = C12032kf.m19324ok().m19311s(j);
        if (m19322ok == null && m19311s != null) {
            m19322ok = m19311s.m19513d();
        }
        if (m19322ok == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof C11975bl) && !(downloadController instanceof C11974a)) {
            downloadEventConfig.setDownloadScene(1);
            this.f33987bl.m18566ok(m19322ok.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
            return;
        }
        m19427a(j);
    }

    /* renamed from: a */
    public void m19427a(long j) {
        DownloadModel m19322ok = C12032kf.m19324ok().m19322ok(j);
        C11998a m19311s = C12032kf.m19324ok().m19311s(j);
        if (m19322ok == null && m19311s != null) {
            m19322ok = m19311s.m19513d();
        }
        if (m19322ok == null) {
            return;
        }
        DownloadEventConfig m19332a = C12032kf.m19324ok().m19332a(j);
        DownloadController m19327bl = C12032kf.m19324ok().m19327bl(j);
        if (m19332a instanceof C11975bl) {
            m19332a = null;
        }
        if (m19327bl instanceof C11974a) {
            m19327bl = null;
        }
        if (m19311s == null) {
            if (m19332a == null) {
                m19332a = m19424bl();
            }
            if (m19327bl == null) {
                m19327bl = m19428a();
            }
        } else {
            if (m19332a == null) {
                m19332a = new AdDownloadEventConfig.Builder().setClickButtonTag(m19311s.mo19303k()).setRefer(m19311s.mo19296q()).setIsEnableV3Event(m19311s.mo19286z()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (m19327bl == null) {
                m19327bl = m19311s.m19516c();
            }
        }
        DownloadEventConfig downloadEventConfig = m19332a;
        downloadEventConfig.setDownloadScene(1);
        this.f33987bl.m18566ok(m19322ok.getDownloadUrl(), j, 2, downloadEventConfig, m19327bl);
    }

    @Override // com.p521ss.android.downloadad.api.InterfaceC11996a
    /* renamed from: ok */
    public boolean mo19422ok(long j) {
        return (C12032kf.m19324ok().m19322ok(j) == null && C12032kf.m19324ok().m19311s(j) == null) ? false : true;
    }

    @Override // com.p521ss.android.downloadad.api.InterfaceC11996a
    /* renamed from: ok */
    public boolean mo19418ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return mo19417ok(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.p521ss.android.downloadad.api.InterfaceC11996a
    /* renamed from: ok */
    public boolean mo19417ok(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) C12232a.m18649ok(new C12232a.InterfaceC12234ok<Boolean>() { // from class: com.ss.android.downloadlib.a.3
            @Override // com.p521ss.android.downloadlib.p536n.C12232a.InterfaceC12234ok
            /* renamed from: ok */
            public Boolean mo18645a() {
                return Boolean.valueOf(C12000a.this.m19426a(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    /* renamed from: ok */
    public static DownloadController m19410ok(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19426a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadController2 = downloadController;
        if (C11952ok.m19657ok(uri) && C12128r.m18946q().optInt("disable_market") != 1) {
            Context context2 = context == null ? C12128r.getContext() : context;
            String m19658a = C11952ok.m19658a(uri);
            if (downloadModel == null) {
                return C12215q.m18681ok(context2, m19658a).getType() == 5;
            }
            if (!TextUtils.isEmpty(m19658a) && (downloadModel instanceof AdDownloadModel)) {
                ((AdDownloadModel) downloadModel).setPackageName(m19658a);
            }
            if (downloadController2 != null) {
                downloadController2.setDownloadMode(2);
            } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
                ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
                downloadController2 = m19410ok(true);
            } else if (downloadModel.getDownloadUrl().startsWith("market")) {
                downloadController2 = m19410ok(true);
            } else {
                downloadController2 = m19428a();
            }
            C12035n c12035n = new C12035n(downloadModel.getId(), downloadModel, (DownloadEventConfig) C12197j.m18775ok(downloadEventConfig, m19424bl()), downloadController2);
            C12032kf.m19324ok().m19319ok(c12035n.f34076a);
            C12032kf.m19324ok().m19320ok(c12035n.f34079ok, c12035n.f34077bl);
            C12032kf.m19324ok().m19321ok(c12035n.f34079ok, c12035n.f34080s);
            if (C12197j.m18788ok(downloadModel) && C12534ok.m17605bl().m17607a("app_link_opt") == 1 && C12018ok.m19379ok(c12035n)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            C12197j.m18778ok(jSONObject, "market_url", uri.toString());
            C12197j.m18778ok(jSONObject, "download_scene", (Object) 1);
            C12270ok.m18539ok().m18540a("market_click_open", jSONObject, c12035n);
            C12031h m18682ok = C12215q.m18682ok(context2, c12035n, m19658a);
            String m18774ok = C12197j.m18774ok(m18682ok.m19335a(), "open_market");
            if (m18682ok.getType() == 5) {
                C12018ok.m19374ok(m18774ok, jSONObject, c12035n, true);
                return true;
            } else if (m18682ok.getType() == 6) {
                C12197j.m18778ok(jSONObject, "error_code", Integer.valueOf(m18682ok.m19334ok()));
                C12270ok.m18539ok().m18540a("market_open_failed", jSONObject, c12035n);
                if (C12127q.m18976ok(downloadModel, iDownloadButtonClickListener)) {
                    iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
                }
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static DownloadController m19428a() {
        return m19410ok(false);
    }
}
