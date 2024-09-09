package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends fz<ClickSlideUpShakeView> implements fp {
    public r(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar, int i4, int i5, int i6) {
        super(context, dynamicBaseWidget, rVar);
        this.f29274w = context;
        this.sr = rVar;
        this.xv = dynamicBaseWidget;
        c(i4, i5, i6, rVar);
    }

    private void c(int i4, int i5, int i6, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        int i7;
        this.f29273c = new ClickSlideUpShakeView(this.f29274w, i4, i5, i6);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.sr.f.c(this.f29274w, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.f29274w;
        if (rVar.mt() > 0) {
            i7 = rVar.mt();
        } else {
            i7 = com.bytedance.sdk.component.adexpress.sr.c() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, i7);
        this.f29273c.setLayoutParams(layoutParams);
        this.f29273c.setClipChildren(false);
        this.f29273c.setSlideText(this.sr.bm());
        SlideUpView slideUpView = this.f29273c;
        if (slideUpView instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) slideUpView).setShakeText(this.sr.wo());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.f29273c).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.c() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.r.1
                    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.c
                    public void c(boolean z3) {
                        if (r.this.xv.getDynamicClickListener() != null) {
                            r.this.xv.getDynamicClickListener().c(z3, r.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.xv.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.fz
    protected void sr() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.fp
    public void ux() {
        if (this.f29273c.getParent() != null) {
            ((ViewGroup) this.f29273c.getParent()).setVisibility(8);
        }
    }
}
