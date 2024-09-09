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
public class sr implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "context")

    /* renamed from: c  reason: collision with root package name */
    private Context f33505c;
    @com.bytedance.sdk.component.p.w.c(c = "cancel_event")
    private String ev;
    @com.bytedance.sdk.component.p.w.c(c = "confirm_event")

    /* renamed from: f  reason: collision with root package name */
    private String f33506f;
    @com.bytedance.sdk.component.p.w.c(c = "deny_event")

    /* renamed from: r  reason: collision with root package name */
    private String f33507r;
    @com.bytedance.sdk.component.p.w.c(c = "privacy_popup_listener")
    private f.c sr;
    @com.bytedance.sdk.component.p.w.c(c = "app_manage_model")
    private String ux;
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")

    /* renamed from: w  reason: collision with root package name */
    private me f33508w;
    @com.bytedance.sdk.component.p.w.c(c = "ad_id")
    private String xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.xv, c());
        TTDelegateActivity.w(this.f33505c, this.xv, this.ux);
        cVar.c(map2);
        return true;
    }

    private f.c c() {
        return new f.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.sr.1
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                if (sr.this.sr == null) {
                    return;
                }
                sr.this.sr.c();
                sr srVar = sr.this;
                srVar.c(srVar.f33506f);
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                if (sr.this.sr == null) {
                    return;
                }
                sr.this.sr.w();
                sr srVar = sr.this;
                srVar.c(srVar.f33507r);
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                if (sr.this.sr == null) {
                    return;
                }
                sr.this.sr.xv();
                sr srVar = sr.this;
                srVar.c(srVar.ev);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.f33508w == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.f33508w);
        hashMap.put("context", this.f33505c);
        new w.c(str).c(this.f33508w.mo()).c(hashMap).c().c();
    }
}
