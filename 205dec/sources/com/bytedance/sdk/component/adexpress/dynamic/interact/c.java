package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.BluePressInteractView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements ev {

    /* renamed from: c  reason: collision with root package name */
    private BluePressInteractView f29237c;

    public c(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar) {
        double oh = rVar.oh();
        oh = oh == 0.0d ? 1.0d : oh;
        double fm = rVar.fm();
        double d4 = fm != 0.0d ? fm : 1.0d;
        double dynamicWidth = dynamicBaseWidget.getDynamicWidth();
        Double.isNaN(dynamicWidth);
        int i4 = (int) (dynamicWidth * 0.32d * oh);
        double dynamicWidth2 = dynamicBaseWidget.getDynamicWidth();
        Double.isNaN(dynamicWidth2);
        int i5 = (int) (dynamicWidth2 * 0.32d * d4);
        this.f29237c = new BluePressInteractView(context, i4, i5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, rVar.ok() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.sr.f.c(context, rVar.h() - 3);
        this.f29237c.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void c() {
        this.f29237c.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public void w() {
        this.f29237c.w();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ev
    public ViewGroup xv() {
        return this.f29237c;
    }
}
