package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "outer_dislike")

    /* renamed from: c  reason: collision with root package name */
    private Dialog f33512c;
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")
    private me sr;
    @com.bytedance.sdk.component.p.w.c(c = "ad_dislike")

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.ui.c f33513w;
    @com.bytedance.sdk.component.p.w.c(c = "context")
    private Context xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        Dialog dialog = this.f33512c;
        if (dialog != null) {
            dialog.show();
            cVar.c(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar2 = this.f33513w;
        if (cVar2 != null) {
            cVar2.c();
            cVar.c(map2);
            return true;
        }
        TTDelegateActivity.c(this.xv, this.sr);
        cVar.c(map2);
        return true;
    }
}
