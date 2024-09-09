package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        ImageView imageView = new ImageView(context);
        this.ys = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            this.ev = Math.max(dynamicRootView.getLogoUnionHeight(), this.ev);
        }
        addView(this.ys, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            ((ImageView) this.ys).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.ys).setImageResource(i.sr(getContext(), "tt_ad_logo_reward_full"));
        } else {
            ((ImageView) this.ys).setImageResource(i.sr(getContext(), "tt_ad_logo"));
        }
        ((ImageView) this.ys).setColorFilter(this.f29132a.r(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
