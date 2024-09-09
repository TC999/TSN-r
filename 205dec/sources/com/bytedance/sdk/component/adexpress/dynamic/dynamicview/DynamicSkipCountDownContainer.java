package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.xv {

    /* renamed from: c  reason: collision with root package name */
    private int f29191c;

    /* renamed from: u  reason: collision with root package name */
    private int f29192u;

    /* renamed from: w  reason: collision with root package name */
    private int f29193w;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        gd();
    }

    private void gd() {
        List<ev> k4 = this.bk.k();
        if (k4 == null || k4.size() <= 0) {
            return;
        }
        for (ev evVar : k4) {
            if (evVar.p().c() == 21) {
                this.f29191c = (int) (this.f29138r - f.c(this.f29136k, evVar.ev()));
            }
            if (evVar.p().c() == 20) {
                this.f29193w = (int) (this.f29138r - f.c(this.f29136k, evVar.ev()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xv
    public void c(CharSequence charSequence, boolean z3, int i4, boolean z4) {
        this.f29192u = i4;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        setBackground(getBackgroundDrawable());
        setPadding((int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.xv()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.w()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.sr()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.c()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f29192u == 0) {
            setMeasuredDimension(this.f29193w, this.ev);
        } else {
            setMeasuredDimension(this.f29191c, this.ev);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ux() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i4 = this.gd;
        layoutParams.leftMargin = i4;
        layoutParams.topMargin = this.f29137p;
        layoutParams.setMarginStart(i4);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
