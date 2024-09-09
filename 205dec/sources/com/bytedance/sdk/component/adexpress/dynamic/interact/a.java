package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.HandLongPressView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a implements ev {

    /* renamed from: c  reason: collision with root package name */
    private HandLongPressView f29235c;

    public a(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29235c = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.sr.f.c(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, 180.0f));
        layoutParams.gravity = 17;
        this.f29235c.setLayoutParams(layoutParams);
        this.f29235c.setGuideText(rVar.bm());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29235c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29235c.w();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public ViewGroup xv() {
        return this.f29235c;
    }
}
