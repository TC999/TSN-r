package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "download_model")

    /* renamed from: a  reason: collision with root package name */
    private DownloadModel f33464a;
    @com.bytedance.sdk.component.p.w.c(c = "download_conf")
    private String bk;
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")

    /* renamed from: c  reason: collision with root package name */
    protected me f33465c;
    @com.bytedance.sdk.component.p.w.c(c = "is_open_oppo_market_auto_download")
    private volatile boolean ev;
    @com.bytedance.sdk.component.p.w.c(c = "download_popup_manager")

    /* renamed from: f  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.p.xv.xv.xv f33466f;
    @com.bytedance.sdk.component.p.w.c(c = com.mbridge.msdk.foundation.download.database.DownloadModel.DOWNLOAD_URL)
    private String gd;
    @com.bytedance.sdk.component.p.w.c(c = "download_controller")

    /* renamed from: k  reason: collision with root package name */
    private AdDownloadController f33467k;
    @com.bytedance.sdk.component.p.w.c(c = "dialog_to_landing_page_convert")

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ev.c.c.c f33468p;
    @com.bytedance.sdk.component.p.w.c(c = "event_tag")
    protected String sr;
    @com.bytedance.sdk.component.p.w.c(c = "download_status_listener")
    protected com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.w ux;
    @com.bytedance.sdk.component.p.w.c(c = "context")

    /* renamed from: w  reason: collision with root package name */
    protected Context f33470w;
    @com.bytedance.sdk.component.p.w.c(c = "convert_from_landing_page")
    protected volatile boolean xv = false;
    @com.bytedance.sdk.component.p.w.c(c = "need_check_compliance")

    /* renamed from: r  reason: collision with root package name */
    private int f33469r = 0;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        if (this.f33470w == null) {
            this.f33470w = ls.getContext();
        }
        if (!c()) {
            cVar.w(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.f fVar = new com.bytedance.sdk.openadsdk.core.ev.c.c.c.f(this.f33465c, this.f33470w, this.sr, this.f33466f, this.gd, this.f33467k, this.f33464a);
        fVar.c(this.ev);
        fVar.c(this.ux);
        fVar.xv(this.xv);
        fVar.c(this.f33469r);
        fVar.c(this.f33468p);
        try {
            if (!TextUtils.isEmpty(this.bk)) {
                fVar.c(new com.bytedance.sdk.openadsdk.core.u.ia(new JSONObject(this.bk)));
            }
        } catch (JSONException unused) {
        }
        if (fVar.c(new HashMap())) {
            cVar.c(map2);
        } else {
            cVar.w(map2);
        }
        return true;
    }

    private boolean c() {
        return (this.f33465c == null || this.f33470w == null || TextUtils.isEmpty(this.gd) || TextUtils.isEmpty(this.sr) || this.f33466f == null || this.f33467k == null || this.f33464a == null) ? false : true;
    }
}
