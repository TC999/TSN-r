package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView2;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends fz<ClickSlideUpView> {
    public f(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        super(context, dynamicBaseWidget, rVar);
        c(rVar);
    }

    private void c(com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29273c = new ClickSlideUpView2(this.f29274w);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.f29273c.setLayoutParams(layoutParams);
        SlideUpView slideUpView = this.f29273c;
        if (slideUpView instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) slideUpView).setButtonText(this.sr.bm());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.fz
    protected void sr() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.fz, com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29273c.w();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.fz, com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29273c.c();
    }
}
