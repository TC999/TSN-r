package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import android.content.Context;
import com.bykv.c.c.c.c.b;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends c {
    private AdDownloadController gd;

    /* renamed from: p  reason: collision with root package name */
    private DownloadModel f33390p;

    public f(me meVar, Context context, String str, com.bytedance.sdk.openadsdk.core.p.xv.xv.xv xvVar, String str2, AdDownloadController adDownloadController, DownloadModel downloadModel) {
        this.gd = adDownloadController;
        this.f33390p = downloadModel;
        this.f33374c = meVar;
        this.f33379w = context;
        this.xv = str;
        this.sr = xvVar;
        this.ux = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c
    com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c w(final Map<String, Object> map) {
        DownloadEventConfig c4 = com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(this.xv).build(), this.f33374c.mo());
        map.put("id", Long.valueOf(this.f33390p.getId()));
        map.put("action_type_button", 2);
        map.put("downloadEventConfig", c4);
        map.put("downloadController", this.gd);
        if (!xv()) {
            c(map, true);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c cVar = new com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.f.1
            @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c, com.bytedance.sdk.openadsdk.core.n.c.c.c, com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z3) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c, com.bytedance.sdk.openadsdk.core.n.c.c.c, com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (map == null || f.this.gd == null) {
                    return;
                }
                f.this.gd.setDownloadMode(0);
                f fVar = f.this;
                fVar.sr.c(fVar.sr());
                map.remove("downloadButtonClickListener");
                if (f.this.c((com.bytedance.sdk.openadsdk.core.u.xv) null, (com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c) null, map)) {
                    return;
                }
                f.this.c(map, true);
            }
        };
        com.bytedance.sdk.openadsdk.core.p.xv.w.xv.c(map, cVar);
        return cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c
    boolean xv() {
        AdDownloadController adDownloadController = this.gd;
        return adDownloadController != null && adDownloadController.getDownloadMode() == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c
    public boolean c() {
        if (this.gd == null || this.f33390p == null) {
            return false;
        }
        return super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c
    com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.w c(final Map<String, Object> map, final y<String, Object> yVar) {
        return new com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.w() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.f.2
            @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.w, com.ss.android.download.api.config.OnItemClickListener
            public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
                if (!f.this.f33375f && !f.this.f33374c.ds()) {
                    f fVar = f.this;
                    me meVar = fVar.f33374c;
                    Context context = fVar.f33379w;
                    String str = fVar.xv;
                    com.bytedance.sdk.openadsdk.core.ev.c.c.w.c cVar = new com.bytedance.sdk.openadsdk.core.ev.c.c.w.c(meVar, context, str, wv.c(str));
                    cVar.sr(true);
                    cVar.c((Map<String, Object>) new HashMap());
                    return;
                }
                Object obj = map.get("downloadEventConfig");
                if (obj instanceof DownloadEventConfig) {
                    ((DownloadEventConfig) obj).setDownloadScene(1);
                    yVar.remove("itemClickListener");
                    f.this.ev.call(17, b.a().h(0, yVar).l(), Void.class);
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c
    com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c c(final com.bytedance.sdk.openadsdk.core.u.xv xvVar, final Map<String, Object> map) {
        return new com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.f.3
            @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c, com.bytedance.sdk.openadsdk.core.n.c.c.c, com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z3) {
                if (z3 && f.this.c(xvVar, (com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c) null, map)) {
                    return;
                }
                f.this.c((com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c) null, map);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c, com.bytedance.sdk.openadsdk.core.n.c.c.c, com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c.c
    void w(boolean z3) {
        AdDownloadController adDownloadController = this.gd;
        if (adDownloadController == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(z3);
        } catch (Throwable unused) {
        }
    }
}
