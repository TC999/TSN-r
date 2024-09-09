package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicSkipCountDown extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.xv {
    public DynamicSkipCountDown(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xv
    public void c(CharSequence charSequence, boolean z3, int i4, boolean z4) {
        if (i4 == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else {
            String c4 = i.c(com.bytedance.sdk.component.adexpress.sr.getContext(), "tt_reward_full_skip_count_down");
            ((TextView) this.ys).setText(" | " + String.format(c4, Integer.valueOf(i4)));
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (TextUtils.isEmpty(((TextView) this.ys).getText())) {
            setMeasuredDimension(0, this.ev);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ux() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f29138r, this.ev);
        int i4 = this.gd;
        layoutParams.leftMargin = i4;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(i4);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
