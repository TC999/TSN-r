package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicTimeOuterSkip extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.xv {

    /* renamed from: c  reason: collision with root package name */
    private boolean f29206c;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.f29206c = dynamicRootView.getRenderRequest().bk();
        }
    }

    private String c(boolean z3) {
        String c4 = i.c(com.bytedance.sdk.component.adexpress.sr.getContext(), "tt_reward_screen_skip_tx");
        if ("skip-with-time-skip-btn".equals(this.bk.p().getType())) {
            if (com.bytedance.sdk.component.adexpress.sr.c() && this.f29206c) {
                c4 = "X";
            }
            if (z3) {
                return c4;
            }
            return "| " + c4;
        }
        return c4;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        if (TextUtils.equals(this.bk.p().getType(), "skip-with-time-skip-btn")) {
            ((TextView) this.ys).setText("");
            return true;
        }
        return true;
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
        if (TextUtils.equals("skip-with-time-skip-btn", this.bk.p().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f29138r, this.ev);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            this.ys.setTextAlignment(1);
            ((TextView) this.ys).setGravity(17);
        } else {
            super.ux();
        }
        if (!"skip-with-time-skip-btn".equals(this.bk.p().getType())) {
            this.ys.setTextAlignment(1);
            ((TextView) this.ys).setGravity(17);
        }
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xv
    public void c(CharSequence charSequence, boolean z3, int i4, boolean z4) {
        if (z3) {
            ((TextView) this.ys).setText(c(z4));
            setVisibility(0);
            return;
        }
        if (z4) {
            ((TextView) this.ys).setText(c(z4));
        }
        setVisibility(z4 ? 0 : 8);
    }
}
