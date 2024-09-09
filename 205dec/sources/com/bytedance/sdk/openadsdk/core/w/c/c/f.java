package com.bytedance.sdk.openadsdk.core.w.c.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends w {
    @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w
    public boolean xv(Map<String, Object> map) {
        View view = this.sr;
        if (view == null) {
            return true;
        }
        boolean sr = wv.sr(view.getContext(), this.f35278c.ky());
        map.put("is_need_report_click_call", Boolean.TRUE);
        map.put("convert_res", Boolean.valueOf(sr));
        return false;
    }
}
