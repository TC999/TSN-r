package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickInteractView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements ev {

    /* renamed from: c  reason: collision with root package name */
    ClickInteractView f29288c;

    public sr(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29288c = new ClickInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 17;
        this.f29288c.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29288c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: sr */
    public ClickInteractView xv() {
        return this.f29288c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29288c.w();
    }
}
