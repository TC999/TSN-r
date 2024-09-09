package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia implements ev {

    /* renamed from: c  reason: collision with root package name */
    private SlideRightView f29280c;
    private com.bytedance.sdk.component.adexpress.dynamic.xv.r sr;

    /* renamed from: w  reason: collision with root package name */
    private Context f29281w;
    private DynamicBaseWidget xv;

    public ia(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29281w = context;
        this.xv = dynamicBaseWidget;
        this.sr = rVar;
        sr();
    }

    private void sr() {
        this.f29280c = new SlideRightView(this.f29281w);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.sr.f.c(this.f29281w, 120.0f));
        layoutParams.gravity = 17;
        this.f29280c.setLayoutParams(layoutParams);
        this.f29280c.setClipChildren(false);
        this.f29280c.setGuideText(this.sr.bm());
        DynamicBaseWidget dynamicBaseWidget = this.xv;
        if (dynamicBaseWidget != null) {
            this.f29280c.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        SlideRightView slideRightView = this.f29280c;
        if (slideRightView != null) {
            slideRightView.c();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        SlideRightView slideRightView = this.f29280c;
        if (slideRightView != null) {
            slideRightView.w();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public ViewGroup xv() {
        return this.f29280c;
    }
}
