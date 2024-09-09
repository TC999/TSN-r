package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressInteractView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t implements ev<PressInteractView> {

    /* renamed from: c  reason: collision with root package name */
    private PressInteractView f29289c;

    public t(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29289c = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.sr.f.c(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, 20.0f);
        this.f29289c.setLayoutParams(layoutParams);
        this.f29289c.setGuideText(rVar.bm());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29289c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: sr */
    public PressInteractView xv() {
        return this.f29289c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29289c.w();
    }
}
