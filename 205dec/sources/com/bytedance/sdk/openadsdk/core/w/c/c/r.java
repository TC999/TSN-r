package com.bytedance.sdk.openadsdk.core.w.c.c;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.pr;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends w {
    private void w(com.bytedance.sdk.openadsdk.core.p.w.xv xvVar) {
        gd gdVar;
        if (xvVar == null || this.sr == null || this.f35279w == null || (gdVar = this.xv) == null) {
            return;
        }
        if (gdVar.u()) {
            xvVar.sr(true);
            return;
        }
        try {
            View view = this.sr;
            if (view instanceof TextView) {
                if (view instanceof TextView) {
                    CharSequence text = ((TextView) view).getText();
                    if (TextUtils.isEmpty(text) || !text.toString().contains("\u4e0b\u8f7d")) {
                        return;
                    }
                }
                Resources resources = this.f35279w.getResources();
                if (resources == null) {
                    return;
                }
                String resourceEntryName = resources.getResourceEntryName(this.sr.getId());
                if (!TextUtils.isEmpty(resourceEntryName) && resourceEntryName.startsWith("tt")) {
                    xvVar.sr(true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w
    public boolean xv(Map<String, Object> map) {
        ux uxVar;
        if (pr.c(this.f35278c, this.ux.bk()) && !"feed_video_middle_page".equals(this.ux.k())) {
            return !this.f35291f.c(map, true, wv.c(this.ux.gd()), this.ux.f(), false, true);
        }
        if (this.xv != null && (uxVar = this.ux) != null && uxVar.s() != null) {
            ev evVar = new ev();
            evVar.ux = this.ux;
            evVar.c(this.ux.w());
            evVar.c(this.ux.bk());
            evVar.c(this.f35279w);
            evVar.xv(this.ux.f());
            evVar.f35291f = this.f35291f;
            return evVar.xv(map);
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv ev = this.ux.ev();
        if (ev == null) {
            return true;
        }
        w(ev);
        sr(map);
        ev.w(me.ux(this.f35278c));
        map.put("convert_res", Boolean.TRUE);
        this.f35291f.c();
        return false;
    }
}
