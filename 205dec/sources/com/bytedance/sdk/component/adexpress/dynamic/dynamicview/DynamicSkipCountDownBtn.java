package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicSkipCountDownBtn extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.xv {

    /* renamed from: c  reason: collision with root package name */
    private int[] f29188c;

    /* renamed from: u  reason: collision with root package name */
    private int f29189u;

    /* renamed from: w  reason: collision with root package name */
    private int f29190w;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        dynamicRootView.setTimeOutListener(this);
    }

    private void gd() {
        this.f29190w = ((this.ev - ((int) f.c(this.f29136k, this.f29132a.ux()))) / 2) - this.f29132a.c();
        this.f29189u = 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xv
    @SuppressLint({"SetTextI18n"})
    public void c(CharSequence charSequence, boolean z3, int i4, boolean z4) {
        String c4 = i.c(com.bytedance.sdk.component.adexpress.sr.getContext(), "tt_reward_screen_skip_tx");
        if (i4 == 0) {
            this.ys.setVisibility(0);
            ((TextView) this.ys).setText("| " + c4);
            this.ys.measure(-2, -2);
            this.f29188c = new int[]{this.ys.getMeasuredWidth() + 1, this.ys.getMeasuredHeight()};
            View view = this.ys;
            int[] iArr = this.f29188c;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.ys).setGravity(17);
            ((TextView) this.ys).setIncludeFontPadding(false);
            gd();
            this.ys.setPadding(this.f29132a.xv(), this.f29190w, this.f29132a.sr(), this.f29189u);
        }
        requestLayout();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        ((TextView) this.ys).setText("");
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (TextUtils.isEmpty(((TextView) this.ys).getText())) {
            setMeasuredDimension(0, this.ev);
        } else {
            setMeasuredDimension(this.f29138r, this.ev);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ux() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f29138r, this.ev);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
