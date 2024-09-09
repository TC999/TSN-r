package com.bytedance.sdk.openadsdk.core.p.xv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends gd {

    /* renamed from: a  reason: collision with root package name */
    private int f34325a = 0;
    private volatile com.bytedance.sdk.openadsdk.core.p.xv.xv.xv bk;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f34326c;

    /* renamed from: f  reason: collision with root package name */
    private String f34327f;
    private AdDownloadController gd;

    /* renamed from: k  reason: collision with root package name */
    private Bridge f34328k;

    /* renamed from: p  reason: collision with root package name */
    private DownloadEventConfig f34329p;
    private DownloadModel sr;

    /* renamed from: t  reason: collision with root package name */
    private volatile boolean f34330t;
    private final me ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34331w;
    private AdDownloadModel.Builder xv;

    public p(Context context, String str, me meVar, String str2) {
        this.f34326c = new WeakReference<>(context);
        this.ux = meVar;
        this.f34327f = str2;
        this.f34331w = str;
        AdDownloadModel.Builder c4 = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(str, str2, meVar, null);
        this.xv = c4;
        this.sr = c4.build();
        this.gd = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(meVar).build();
        this.f34329p = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(this.f34327f).build();
        this.f34328k = com.bytedance.sdk.openadsdk.core.k.sr().u();
        xv();
    }

    private synchronized void a() {
        if (this.f34328k == null) {
            return;
        }
        if (!bk()) {
            this.f34328k.call(5, b.a().h(0, new y().c("downloadModel", this.sr).c("hashCode", Integer.valueOf(hashCode()))).l(), Void.class);
            return;
        }
        if (((Boolean) this.f34328k.call(19, b.a().h(0, new y().c("id", Long.valueOf(this.sr.getId()))).l(), Boolean.class)).booleanValue()) {
            this.f34328k.call(14, b.a().h(0, new y().c("id", Long.valueOf(this.sr.getId())).c("logExtra", this.sr.getLogExtra()).c("hashCode", Integer.valueOf(hashCode()))).l(), Boolean.class);
        }
    }

    private boolean bk() {
        me meVar = this.ux;
        if (meVar != null) {
            return ia.c(meVar);
        }
        return false;
    }

    private boolean fp() {
        me meVar = this.ux;
        com.bytedance.sdk.openadsdk.core.u.ux zg = meVar != null ? meVar.zg() : null;
        String k4 = zg != null ? zg.k() : "";
        Intent w3 = TextUtils.isEmpty(k4) ? null : wv.w(getContext(), k4);
        if (w3 != null && wv.xv(getContext(), k4)) {
            try {
                getContext().startActivity(w3);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private boolean fz() {
        if (this.f34328k == null) {
            return false;
        }
        return ((Boolean) this.f34328k.call(6, b.a().h(0, new y().c("downloadUrl", this.f34331w)).l(), Boolean.class)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.f34326c;
            if (weakReference == null) {
                return ls.getContext();
            }
            Context context = weakReference.get();
            return context == null ? ls.getContext() : context;
        } catch (Throwable unused) {
            return ls.getContext();
        }
    }

    private Map<String, Object> i() {
        if (bk()) {
            return new y().c("userAgent", null).c("isDisableDialog", Boolean.TRUE).c("downloadModel", this.sr).c("downloadEventConfig", this.f34329p).c("downloadController", this.gd).c("downloadStatusChangeListener", null).c("hashCode", Integer.valueOf(hashCode()));
        }
        return new y().c("downloadUrl", this.f34331w).c("id", Long.valueOf(this.sr.getId())).c("action_type_button", 2).c("downloadEventConfig", this.f34329p).c("downloadController", this.gd);
    }

    private boolean ia() {
        me meVar = this.ux;
        if (meVar == null || meVar.qu() == null) {
            return false;
        }
        String c4 = this.ux.qu().c();
        if (TextUtils.isEmpty(c4)) {
            return false;
        }
        Uri parse = Uri.parse(c4);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        if (wv.c(getContext(), intent)) {
            if (!(getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                getContext().startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private void q() {
        AdDownloadController adDownloadController;
        if (eq.f33190w < 5400 || !w() || this.sr == null || this.f34330t || (adDownloadController = this.gd) == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(false);
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        if (this.f34328k == null || ia.ia(this.ux) == 1 || ia.ev(this.ux) || !fz()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.p.3
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(p.this.getContext(), "\u5e94\u7528\u6b63\u5728\u4e0b\u8f7d...", 0).show();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        int i4 = this.f34325a;
        if (i4 != 1) {
            if (i4 != 2) {
                return false;
            }
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.p.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.u.xv c4 = ls.c().c(p.this.ux, p.this.f34331w);
                    if (c4 != null && c4.ux()) {
                        String f4 = c4.f();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject = new JSONObject(f4);
                        } catch (JSONException unused) {
                        }
                        com.bytedance.sdk.openadsdk.core.u.ux ux = com.bytedance.sdk.openadsdk.core.w.ux(jSONObject);
                        com.bytedance.sdk.openadsdk.core.u.ux zg = p.this.ux.zg();
                        if (zg == null) {
                            p.this.ux.c(ux);
                        } else {
                            zg.ev(ux.a());
                            zg.w(ux.ux());
                            zg.sr(ux.r());
                            zg.w(ux.p());
                            zg.ux(ux.ev());
                            zg.r(ux.k());
                            zg.xv(ux.f());
                            ux = zg;
                        }
                        if (p.this.ys()) {
                            return;
                        }
                        p.this.xv.setAppIcon(ux.f());
                        p.this.xv.setAppName(ux.a());
                        p.this.xv.setPackageName(ux.k());
                        p.this.c(c4);
                        return;
                    }
                    k.c(ls.getContext());
                }
            });
            return true;
        } else if (ys()) {
            return true;
        } else {
            k.c(ls.getContext());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        final Map<String, Object> i4 = i();
        if (!w()) {
            c(16, i4);
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(i4, new IDownloadButtonClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.p.4
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z3) {
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (i4 == null || p.this.gd == null) {
                    return;
                }
                p.this.gd.setDownloadMode(0);
                p.this.c().c(p.this.p());
                i4.remove("downloadButtonClickListener");
                if (p.this.t()) {
                    return;
                }
                p.this.c((com.bytedance.sdk.openadsdk.core.u.xv) null);
            }
        });
        c(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ys() {
        return ia() || fp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(int i4, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(com.bytedance.sdk.openadsdk.core.p.w.c cVar, boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean c(boolean z3) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean ev() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean gd() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void ux() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void w(JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean xv(JSONObject jSONObject) {
        return false;
    }

    private synchronized void k() {
        if (this.f34328k == null) {
            return;
        }
        if (bk()) {
            this.f34328k.call(18, b.a().h(0, new y().c("id", Long.valueOf(this.sr.getId())).c("hashCode", Integer.valueOf(hashCode()))).l(), Boolean.class);
            return;
        }
        this.f34328k.call(4, b.b(1).h(0, new y().c("downloadUrl", this.sr.getDownloadUrl()).c("hashCode", Integer.valueOf(hashCode()))).l(), Void.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.p.xv.xv.c p() {
        if (w()) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.ux();
        }
        return new com.bytedance.sdk.openadsdk.core.p.xv.xv.sr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void f() {
        k();
        WeakReference<Context> weakReference = this.f34326c;
        if (weakReference != null) {
            weakReference.clear();
            this.f34326c = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void r() {
        if (this.f34328k != null) {
            this.f34328k.call(8, b.a().h(0, new y().c("downloadUrl", this.sr.getDownloadUrl()).c("force", Boolean.TRUE)).l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void sr() {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean w() {
        AdDownloadController adDownloadController = this.gd;
        return adDownloadController != null && adDownloadController.getDownloadMode() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void xv() {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void sr(boolean z3) {
        AdDownloadController adDownloadController;
        if (eq.f33190w >= 5400 && z3) {
            this.f34330t = z3;
            if (w() && (adDownloadController = this.gd) != null) {
                try {
                    adDownloadController.setEnableOppoAutoDownload(true);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private boolean w(com.bytedance.sdk.openadsdk.core.u.xv xvVar) {
        com.bytedance.sdk.openadsdk.core.p.xv.xv.xv c4 = c();
        if (c4.c() && !fz()) {
            if (c(getContext(), this.ux, this.f34327f)) {
                return true;
            }
            c4.c(xvVar, this.f34327f, this.f34331w, new com.bytedance.sdk.openadsdk.core.p.xv.c.w() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.p.2
                @Override // com.bytedance.sdk.openadsdk.core.p.xv.c.w
                public void c() {
                    p.this.u();
                    p.this.sr(true);
                }
            });
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.gd
    public com.bytedance.sdk.openadsdk.core.p.xv.xv.xv c() {
        if (this.bk == null) {
            synchronized (this) {
                if (this.bk == null) {
                    this.bk = new com.bytedance.sdk.openadsdk.core.p.xv.xv.xv(getContext(), this.ux);
                }
            }
        }
        return this.bk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(JSONObject jSONObject) {
        c().c(p());
        if (s()) {
            if (w() || !t()) {
                c((com.bytedance.sdk.openadsdk.core.u.xv) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.u.xv xvVar) {
        q();
        if (w(xvVar)) {
            return;
        }
        u();
    }

    private void c(final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.p.ev.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.p.5
            @Override // java.lang.Runnable
            public void run() {
                p.this.c(17, map);
            }
        }, this.ux);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i4, final Map<String, Object> map) {
        try {
            if (this.f34328k == null) {
                return;
            }
            if (bk()) {
                this.f34328k.call(13, b.a().h(0, map).l(), Void.class);
                this.f34330t = false;
            } else if (eq.f33190w < 4500) {
                this.f34328k.call(i4, b.a().h(0, map).l(), Void.class);
                this.f34330t = false;
            } else {
                map.put("itemClickListener", new OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.p.6
                    @Override // com.ss.android.download.api.config.OnItemClickListener
                    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
                        p.this.f34329p.setDownloadScene(1);
                        map.remove("itemClickListener");
                        p.this.f34328k.call(i4, b.a().h(0, map).l(), Void.class);
                    }
                });
                this.f34328k.call(i4, b.a().h(0, map).l(), Void.class);
                this.f34330t = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(int i4) {
        this.f34325a = i4;
    }
}
