package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            ImageView imageView = new ImageView(context);
            this.ys = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f29138r = this.ev;
        } else {
            this.ys = new TextView(context);
        }
        this.ys.setTag(3);
        addView(this.ys, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.ys);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().ev()) {
            return;
        }
        this.ys.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            GradientDrawable gradientDrawable = (GradientDrawable) i.xv(getContext(), "tt_ad_skip_btn_bg");
            gradientDrawable.setCornerRadius(this.ev / 2);
            gradientDrawable.setColor(this.f29132a.z());
            ((ImageView) this.ys).setBackgroundDrawable(gradientDrawable);
            ((ImageView) this.ys).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.ys).setImageResource(i.sr(getContext(), "tt_reward_full_feedback"));
            return true;
        }
        ((TextView) this.ys).setText(getText());
        this.ys.setTextAlignment(this.f29132a.ev());
        ((TextView) this.ys).setTextColor(this.f29132a.r());
        ((TextView) this.ys).setTextSize(this.f29132a.ux());
        this.ys.setBackground(getBackgroundDrawable());
        if (!this.f29132a.q()) {
            ((TextView) this.ys).setMaxLines(1);
            ((TextView) this.ys).setGravity(17);
            ((TextView) this.ys).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int j4 = this.f29132a.j();
            if (j4 > 0) {
                ((TextView) this.ys).setLines(j4);
                ((TextView) this.ys).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.ys.setPadding((int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.xv()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.w()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.sr()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.c()));
        ((TextView) this.ys).setGravity(17);
        return true;
    }

    public String getText() {
        return i.c(com.bytedance.sdk.component.adexpress.sr.getContext(), "tt_reward_feedback");
    }
}
