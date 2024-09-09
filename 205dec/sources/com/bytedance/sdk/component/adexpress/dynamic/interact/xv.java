package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements ev {

    /* renamed from: c  reason: collision with root package name */
    private CircleLongPressView f29292c;

    public xv(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        this.f29292c = new CircleLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.sr.f.c(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, 180.0f));
        layoutParams.gravity = 17;
        this.f29292c.setLayoutParams(layoutParams);
        this.f29292c.setGuideText(rVar.bm());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29292c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    /* renamed from: sr */
    public CircleLongPressView xv() {
        return this.f29292c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29292c.w();
    }
}
