package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.sr.k;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicTimeOuter extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.xv {

    /* renamed from: c  reason: collision with root package name */
    private boolean f29197c;

    /* renamed from: u  reason: collision with root package name */
    private boolean f29198u;

    /* renamed from: w  reason: collision with root package name */
    private boolean f29199w;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(evVar.p().getType())) {
            dynamicRootView.setTimedown(this.ev);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xv
    public void c(CharSequence charSequence, boolean z3, int i4, boolean z4) {
        if (!z4 && !this.f29198u) {
            try {
                if (Integer.parseInt((String) charSequence) <= 0) {
                    setVisibility(8);
                    return;
                }
            } catch (Exception unused) {
            }
            setVisibility(0);
            if (!z3 && this.f29140t.getRenderRequest().c() && com.bytedance.sdk.component.adexpress.sr.ux.w(this.f29140t.getRenderRequest().sr())) {
                ((TextView) this.ys).setText(String.format(i.c(com.bytedance.sdk.component.adexpress.sr.getContext(), "tt_reward_full_skip"), Integer.valueOf(i4)));
                this.f29197c = true;
                return;
            } else if (com.bytedance.sdk.component.adexpress.sr.c() && !"open_ad".equals(this.f29140t.getRenderRequest().sr()) && this.f29140t.getRenderRequest().c()) {
                this.f29198u = true;
                setVisibility(8);
                return;
            } else if ("timedown".equals(this.bk.p().getType())) {
                ((TextView) this.ys).setText(charSequence);
                return;
            } else {
                ((TextView) this.ys).setText(((Object) charSequence) + "s");
                this.f29199w = true;
                if (this.f29197c) {
                    CharSequence text = ((TextView) this.ys).getText();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (k.w(text != null ? text.toString() : "", this.f29132a.ux(), true)[0] + f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.xv() + this.f29132a.sr())), this.ev);
                    layoutParams.gravity = 8388629;
                    this.ys.setLayoutParams(layoutParams);
                    this.f29197c = false;
                    requestLayout();
                    return;
                }
                return;
            }
        }
        ((TextView) this.ys).setText("");
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        if (com.bytedance.sdk.component.adexpress.sr.ux.w(this.f29140t.getRenderRequest().sr())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.bk.p().getType())) {
            ((TextView) this.ys).setText(String.valueOf((int) Double.parseDouble(this.f29132a.p())));
            return true;
        }
        ((TextView) this.ys).setText(((int) Double.parseDouble(this.f29132a.p())) + "s");
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
        if (!TextUtils.equals("skip-with-countdowns-video-countdown", this.bk.p().getType()) && !TextUtils.equals("skip-with-time-countdown", this.bk.p().getType())) {
            super.ux();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f29138r, this.ev);
        layoutParams.gravity = 8388627;
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            layoutParams.leftMargin = this.gd;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
