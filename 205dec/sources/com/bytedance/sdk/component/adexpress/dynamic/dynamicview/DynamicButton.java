package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        AnimationButton animationButton = new AnimationButton(context);
        this.ys = animationButton;
        animationButton.setTag(Integer.valueOf(getClickArea()));
        addView(this.ys, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        if (TextUtils.equals("download-progress-button", this.bk.p().getType()) && TextUtils.isEmpty(this.f29132a.p())) {
            this.ys.setVisibility(4);
            return true;
        }
        this.ys.setTextAlignment(this.f29132a.ev());
        ((TextView) this.ys).setText(this.f29132a.p());
        ((TextView) this.ys).setTextColor(this.f29132a.r());
        ((TextView) this.ys).setTextSize(this.f29132a.ux());
        ((TextView) this.ys).setGravity(17);
        ((TextView) this.ys).setIncludeFontPadding(false);
        if ("fillButton".equals(this.bk.p().getType())) {
            this.ys.setPadding(0, 0, 0, 0);
        } else {
            this.ys.setPadding(this.f29132a.xv(), this.f29132a.w(), this.f29132a.sr(), this.f29132a.c());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.bytedance.sdk.component.adexpress.sr.c() && "fillButton".equals(this.bk.p().getType())) {
            ((TextView) this.ys).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.ys).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.f29132a.s() * 2;
            widgetLayoutParams.height -= this.f29132a.s() * 2;
            widgetLayoutParams.topMargin += this.f29132a.s();
            int s3 = widgetLayoutParams.leftMargin + this.f29132a.s();
            widgetLayoutParams.leftMargin = s3;
            widgetLayoutParams.setMarginStart(s3);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }
}
