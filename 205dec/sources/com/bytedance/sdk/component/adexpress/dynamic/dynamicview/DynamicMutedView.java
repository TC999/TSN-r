package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.w {
    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        ImageView imageView = new ImageView(context);
        this.ys = imageView;
        imageView.setTag(5);
        addView(this.ys, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        if (com.bytedance.sdk.component.adexpress.sr.ux.w(this.f29140t.getRenderRequest().sr())) {
            ((ImageView) this.ys).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.ys).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.f29140t.f29187w);
        GradientDrawable gradientDrawable = (GradientDrawable) i.xv(getContext(), "tt_ad_skip_btn_bg");
        gradientDrawable.setCornerRadius(this.ev / 2);
        gradientDrawable.setColor(this.f29132a.z());
        ((ImageView) this.ys).setBackgroundDrawable(gradientDrawable);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.w
    public void setSoundMute(boolean z3) {
        int sr;
        if (com.bytedance.sdk.component.adexpress.sr.ux.w(this.f29140t.getRenderRequest().sr())) {
            if (z3) {
                sr = i.sr(getContext(), "tt_reward_full_mute");
            } else {
                sr = i.sr(getContext(), "tt_reward_full_unmute");
            }
        } else if (z3) {
            sr = i.sr(getContext(), "tt_mute");
        } else {
            sr = i.sr(getContext(), "tt_unmute");
        }
        ((ImageView) this.ys).setImageResource(sr);
        if (((ImageView) this.ys).getDrawable() == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ((ImageView) this.ys).getDrawable().setAutoMirrored(true);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean sr() {
        return true;
    }
}
