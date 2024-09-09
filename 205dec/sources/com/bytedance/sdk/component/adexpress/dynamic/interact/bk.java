package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk implements ev {

    /* renamed from: c  reason: collision with root package name */
    private PressButtonInteractView f29236c;

    public bk(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29236c = new PressButtonInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 8388629;
        this.f29236c.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29236c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: sr */
    public PressButtonInteractView xv() {
        return this.f29236c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29236c.w();
    }
}
