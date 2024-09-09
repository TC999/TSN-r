package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fz<E extends SlideUpView> implements ev<E> {

    /* renamed from: c  reason: collision with root package name */
    protected SlideUpView f29273c;
    protected com.bytedance.sdk.component.adexpress.dynamic.xv.r sr;
    protected int ux;

    /* renamed from: w  reason: collision with root package name */
    protected Context f29274w;
    protected DynamicBaseWidget xv;

    public fz(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar, int i4) {
        this.ux = i4;
        this.f29274w = context;
        this.xv = dynamicBaseWidget;
        this.sr = rVar;
        sr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29273c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: f */
    public E xv() {
        return (E) this.f29273c;
    }

    protected void sr() {
        this.f29273c = new SlideUpView(this.f29274w, this.sr.m());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.sr.f.c(this.f29274w, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(this.f29274w, 100 - this.ux);
        this.f29273c.setLayoutParams(layoutParams);
        try {
            this.f29273c.setGuideText(this.sr.bm());
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29273c.w();
    }

    public fz(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this(context, dynamicBaseWidget, rVar, 0);
    }
}
