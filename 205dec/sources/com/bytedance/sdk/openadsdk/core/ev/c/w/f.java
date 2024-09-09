package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.util.Map;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "is_direct_download")

    /* renamed from: a  reason: collision with root package name */
    private boolean f33453a;
    @com.bytedance.sdk.component.p.w.c(c = "download_dialog_listener")
    private com.bytedance.sdk.openadsdk.core.p.xv.c.c bk;
    @com.bytedance.sdk.component.p.w.c(c = "convert_from_landing_page")

    /* renamed from: c  reason: collision with root package name */
    protected boolean f33454c;
    @com.bytedance.sdk.component.p.w.c(c = "start_download_listener")
    private com.bytedance.sdk.openadsdk.core.p.xv.c.w ev;
    @com.bytedance.sdk.component.p.w.c(c = "event_tag")

    /* renamed from: f  reason: collision with root package name */
    private String f33455f;
    @com.bytedance.sdk.component.p.w.c(c = "is_show_download_dialog")
    private boolean gd = true;
    @com.bytedance.sdk.component.p.w.c(c = "dynamic_download_dialog_type")

    /* renamed from: k  reason: collision with root package name */
    private int f33456k;
    @com.bytedance.sdk.component.p.w.c(c = "is_from_new_click_event")

    /* renamed from: p  reason: collision with root package name */
    private boolean f33457p;
    @com.bytedance.sdk.component.p.w.c(c = DownloadModel.DOWNLOAD_URL)

    /* renamed from: r  reason: collision with root package name */
    private String f33458r;
    @com.bytedance.sdk.component.p.w.c(c = "is_app_market_convert")
    private boolean sr;
    @com.bytedance.sdk.component.p.w.c(c = "app_manage_model")
    private com.bytedance.sdk.openadsdk.core.u.xv ux;
    @com.bytedance.sdk.component.p.w.c(c = "context")

    /* renamed from: w  reason: collision with root package name */
    private Context f33459w;
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")
    private me xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        com.bytedance.sdk.openadsdk.core.p.xv.xv.xv xvVar = new com.bytedance.sdk.openadsdk.core.p.xv.xv.xv(this.f33459w, this.xv);
        xvVar.xv(this.f33453a);
        xvVar.c(this.gd);
        xvVar.c(this.f33456k);
        xvVar.w(this.f33457p);
        xvVar.c(this.bk);
        xvVar.c(c());
        if (!xvVar.c()) {
            cVar.w(map2);
            return true;
        }
        xvVar.c(this.ux, this.f33455f, this.f33458r, this.ev);
        cVar.c(map2);
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.p.xv.xv.c c() {
        if (this.sr) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.ux();
        }
        if (this.f33454c) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.sr();
        }
        return new com.bytedance.sdk.openadsdk.core.p.xv.xv.w();
    }
}
