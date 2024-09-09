package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.w;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.n.gd;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends w {
    private boolean ux;

    public c(TTBaseVideoActivity tTBaseVideoActivity, me meVar, String str, boolean z3, boolean z4) {
        super(tTBaseVideoActivity, meVar, str, z3, z4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.w
    public void c(NativeExpressView nativeExpressView) {
        Map<String, Object> gw = this.f32291c.gw();
        if (nativeExpressView.getDynamicShowType() == 0) {
            ls.c(gw, this.f32297w, nativeExpressView);
        } else {
            gw.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
        }
        com.bytedance.sdk.openadsdk.core.u.ls dc = this.f32297w.dc();
        Double d4 = null;
        if (dc != null) {
            gw.put("refresh_num", Integer.valueOf(dc.xv()));
            if (this.ux) {
                d4 = this.f32291c.vc();
            }
        }
        xv.c(this.f32297w, this.xv, gw, d4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.w
    public sr k() {
        sr c4 = ng.c(1, this.f32297w);
        c4.w(this.f32297w.jr());
        c4.w(100);
        c4.xv(100);
        c4.xv(this.f32297w.cf());
        c4.w(this.sr);
        if (gd.c(this.f32297w)) {
            c4.c(true);
        }
        return c4;
    }

    public void xv(boolean z3) {
        this.ux = z3;
    }
}
