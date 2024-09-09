package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Map;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "url")

    /* renamed from: c  reason: collision with root package name */
    private String f33446c;
    @com.bytedance.sdk.component.p.w.c(c = "title")

    /* renamed from: w  reason: collision with root package name */
    private String f33447w;
    @com.bytedance.sdk.component.p.w.c(c = "context")
    private Context xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        TTDelegateActivity.sr(this.xv, this.f33446c, this.f33447w);
        cVar.c(map2);
        return true;
    }
}
