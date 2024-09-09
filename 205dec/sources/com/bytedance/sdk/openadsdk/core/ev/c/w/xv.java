package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.p.c.w;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "context")

    /* renamed from: c  reason: collision with root package name */
    private Context f33519c;
    @com.bytedance.sdk.component.p.w.c(c = "cancel_event")
    private String ev;
    @com.bytedance.sdk.component.p.w.c(c = "confirm_event")

    /* renamed from: f  reason: collision with root package name */
    private String f33520f;
    @com.bytedance.sdk.component.p.w.c(c = "deny_event")

    /* renamed from: r  reason: collision with root package name */
    private String f33521r;
    @com.bytedance.sdk.component.p.w.c(c = "permission_popup_listener")
    private f.c sr;
    @com.bytedance.sdk.component.p.w.c(c = "app_manage_model")
    private String ux;
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")

    /* renamed from: w  reason: collision with root package name */
    private me f33522w;
    @com.bytedance.sdk.component.p.w.c(c = "ad_id")
    private String xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.xv, c());
        TTDelegateActivity.c(this.f33519c, this.xv, this.ux);
        cVar.c(map2);
        return true;
    }

    private f.c c() {
        return new f.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.xv.1
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                if (xv.this.sr == null) {
                    return;
                }
                xv.this.sr.c();
                xv xvVar = xv.this;
                xvVar.c(xvVar.f33520f);
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                if (xv.this.sr == null) {
                    return;
                }
                xv.this.sr.w();
                xv xvVar = xv.this;
                xvVar.c(xvVar.f33521r);
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                if (xv.this.sr == null) {
                    return;
                }
                xv.this.sr.xv();
                xv xvVar = xv.this;
                xvVar.c(xvVar.ev);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.f33522w == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.f33522w);
        hashMap.put("context", this.f33519c);
        new w.c(str).c(this.f33522w.mo()).c(hashMap).c().c();
    }
}
