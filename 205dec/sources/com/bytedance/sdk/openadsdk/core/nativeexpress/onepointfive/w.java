package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.openadsdk.ls.c.w.c.w {

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.ls.c.w.c.w f34163c;

    /* renamed from: w  reason: collision with root package name */
    public c f34164w;
    public int xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(int i4);
    }

    public w(c cVar, int i4, com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar) {
        super(null);
        this.f34163c = wVar;
        this.f34164w = cVar;
        this.xv = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
    public void onAdClicked(View view, int i4) {
        com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar = this.f34163c;
        if (wVar != null) {
            wVar.onAdClicked(view, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
    public void onAdShow(View view, int i4) {
        com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar = this.f34163c;
        if (wVar != null) {
            wVar.onAdShow(view, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
    public void onRenderFail(View view, String str, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
    public void onRenderSuccess(View view, float f4, float f5) {
        c cVar = this.f34164w;
        if (cVar != null) {
            cVar.c(this.xv);
        }
    }
}
