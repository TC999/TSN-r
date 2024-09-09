package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUp3DView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s implements ev<SlideUp3DView> {

    /* renamed from: c  reason: collision with root package name */
    private SlideUp3DView f29286c;
    private com.bytedance.sdk.component.adexpress.dynamic.xv.r sr;

    /* renamed from: w  reason: collision with root package name */
    private Context f29287w;
    private DynamicBaseWidget xv;

    public s(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29287w = context;
        this.xv = dynamicBaseWidget;
        this.sr = rVar;
        sr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29286c.w();
    }

    protected void sr() {
        this.f29286c = new SlideUp3DView(this.f29287w);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.sr.f.c(this.f29287w, 250.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(this.f29287w, 120.0f);
        this.f29286c.setLayoutParams(layoutParams);
        this.f29286c.setGuideText(this.sr.bm());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: ux */
    public SlideUp3DView xv() {
        return this.f29286c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29286c.xv();
    }
}
