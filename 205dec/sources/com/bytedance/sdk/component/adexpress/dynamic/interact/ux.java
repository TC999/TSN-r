package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends fz<ClickSlideUpView> {
    public ux(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        super(context, dynamicBaseWidget, rVar);
        c(rVar);
    }

    private void c(com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29273c = new ClickSlideUpView(this.f29274w);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(this.f29274w, rVar.mt());
        this.f29273c.setLayoutParams(layoutParams);
        this.f29273c.setSlideText(this.sr.bm());
        SlideUpView slideUpView = this.f29273c;
        if (slideUpView instanceof ClickSlideUpView) {
            ((ClickSlideUpView) slideUpView).setButtonText(this.sr.p());
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
