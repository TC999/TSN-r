package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicStarView extends DynamicBaseWidgetImp {

    /* renamed from: c  reason: collision with root package name */
    private int f29194c;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.f29194c = 0;
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(context, null);
        this.ys = tTRatingBar2;
        tTRatingBar2.setTag(Integer.valueOf(getClickArea()));
        addView(this.ys, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        DynamicRootView dynamicRootView;
        super.ev();
        double bk = this.f29132a.bk();
        if (com.bytedance.sdk.component.adexpress.sr.c() && (bk < 0.0d || bk > 5.0d || ((dynamicRootView = this.f29140t) != null && dynamicRootView.getRenderRequest() != null && this.f29140t.getRenderRequest().p() != 4))) {
            this.ys.setVisibility(8);
            return true;
        }
        double d4 = (bk < 0.0d || bk > 5.0d) ? 5.0d : bk;
        this.ys.setVisibility(0);
        ((TTRatingBar2) this.ys).c(d4, this.f29132a.r(), (int) this.f29132a.ux(), ((int) f.c(this.f29136k, this.f29132a.w())) + ((int) f.c(this.f29136k, this.f29132a.c())) + ((int) f.c(this.f29136k, this.f29132a.ux())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int c4 = (int) ((f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.ux()) * 5.0f) + f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.xv() + f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.sr())));
        if (this.f29138r > c4 && 4 == this.f29132a.ev()) {
            this.f29194c = (this.f29138r - c4) / 2;
        }
        this.f29138r = c4;
        return new FrameLayout.LayoutParams(this.f29138r, this.ev);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ux() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f29138r, this.ev);
        layoutParams.topMargin = this.f29137p;
        int i4 = this.gd + this.f29194c;
        layoutParams.leftMargin = i4;
        layoutParams.setMarginStart(i4);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
