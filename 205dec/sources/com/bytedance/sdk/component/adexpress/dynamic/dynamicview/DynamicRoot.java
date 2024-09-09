package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicRoot extends DynamicBaseWidgetImp {

    /* renamed from: c  reason: collision with root package name */
    public w f29178c;

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public w c(Bitmap bitmap) {
        c cVar = new c(bitmap, this.f29178c);
        this.f29178c = cVar;
        return cVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        return super.ev();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected GradientDrawable getDrawable() {
        w wVar = new w();
        this.f29178c = wVar;
        return wVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public GradientDrawable c(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        w wVar = new w(orientation, iArr);
        this.f29178c = wVar;
        return wVar;
    }
}
