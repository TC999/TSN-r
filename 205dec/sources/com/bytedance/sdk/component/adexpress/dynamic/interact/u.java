package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u implements ev<DynamicUnlockView> {

    /* renamed from: c  reason: collision with root package name */
    private final DynamicUnlockView f29290c;

    public u(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        int i4;
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.f29290c = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (rVar.mt() > 0) {
            i4 = rVar.mt();
        } else {
            i4 = com.bytedance.sdk.component.adexpress.sr.c() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, i4);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(rVar.bm());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        DynamicUnlockView dynamicUnlockView = this.f29290c;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.c();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: sr */
    public DynamicUnlockView xv() {
        return this.f29290c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        DynamicUnlockView dynamicUnlockView = this.f29290c;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.w();
        }
    }
}