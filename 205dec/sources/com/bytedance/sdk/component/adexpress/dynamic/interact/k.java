package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k implements ev<ViewGroup> {

    /* renamed from: c  reason: collision with root package name */
    private final DynamicLottieView f29282c;

    /* renamed from: w  reason: collision with root package name */
    private final FrameLayout f29283w;

    public k(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar, String str) {
        DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
        this.f29282c = dynamicLottieView;
        dynamicLottieView.setImageLottieTosPath(str);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f29283w = frameLayout;
        frameLayout.addView(dynamicLottieView, new FrameLayout.LayoutParams(-2, -2));
        double oh = rVar.oh();
        oh = oh == 0.0d ? 1.0d : oh;
        double fm = rVar.fm();
        double d4 = fm != 0.0d ? fm : 1.0d;
        double dynamicWidth = dynamicBaseWidget.getDynamicWidth();
        Double.isNaN(dynamicWidth);
        double dynamicWidth2 = dynamicBaseWidget.getDynamicWidth();
        Double.isNaN(dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (dynamicWidth * 0.32d * oh), (int) (dynamicWidth2 * 0.32d * d4));
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29282c.f();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29282c.sr();
        ViewParent parent = this.f29283w.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f29283w);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public ViewGroup xv() {
        return this.f29283w;
    }
}
