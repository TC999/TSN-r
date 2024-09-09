package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements ev<DynamicBrushMaskView> {

    /* renamed from: c  reason: collision with root package name */
    private DynamicBrushMaskView f29291c;

    public w(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        int i4;
        this.f29291c = new DynamicBrushMaskView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (rVar.mt() > 0) {
            i4 = rVar.mt();
        } else {
            i4 = com.bytedance.sdk.component.adexpress.sr.c() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, i4);
        this.f29291c.setLayoutParams(layoutParams);
        this.f29291c.setClipChildren(false);
        this.f29291c.setBrushText(rVar.bm());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        DynamicBrushMaskView dynamicBrushMaskView = this.f29291c;
        if (dynamicBrushMaskView != null) {
            dynamicBrushMaskView.c();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: sr */
    public DynamicBrushMaskView xv() {
        return this.f29291c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        DynamicBrushMaskView dynamicBrushMaskView = this.f29291c;
        if (dynamicBrushMaskView != null) {
            dynamicBrushMaskView.xv();
        }
    }
}
