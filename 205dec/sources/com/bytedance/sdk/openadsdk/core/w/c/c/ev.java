package com.bytedance.sdk.openadsdk.core.w.c.c;

import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends w {

    /* renamed from: r  reason: collision with root package name */
    protected boolean f35280r = false;

    public void ux(boolean z3) {
        this.f35280r = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w
    public boolean xv(Map<String, Object> map) {
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        String k4 = this.ux.k();
        if (this.ux.ux()) {
            if ((this.ux.bk() instanceof t) || this.f35280r) {
                map.put("is_need_report_click_button", Boolean.TRUE);
            }
            boolean f4 = this.ux.f();
            map.put("key_open_video_detail_page_direct", Boolean.TRUE);
            str = k4;
            z4 = f4;
            z3 = false;
            z5 = false;
        } else {
            boolean xv = u.xv(this.f35278c);
            ux uxVar = this.ux;
            String k5 = xv ? uxVar.k() : wv.c(uxVar.gd());
            this.ux.c(k5);
            this.ux.w(xv);
            str = k5;
            z3 = xv;
            z4 = true;
            z5 = true;
        }
        sr(map);
        this.f35291f.c(this.f35278c, map);
        return !this.f35291f.c(map, z3, str, z4, z5, false);
    }
}
