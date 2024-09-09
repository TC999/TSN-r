package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.xv {

    /* renamed from: c  reason: collision with root package name */
    private boolean f29205c;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.f29205c = dynamicRootView.getRenderRequest().bk();
        }
        this.f29138r = this.ev;
        ImageView imageView = new ImageView(context);
        this.ys = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.ys, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xv
    public void c(CharSequence charSequence, boolean z3, int i4, boolean z4) {
        if (z3) {
            setVisibility(0);
        } else {
            setVisibility(z4 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        ((ImageView) this.ys).setScaleType(ImageView.ScaleType.CENTER_CROP);
        GradientDrawable gradientDrawable = (GradientDrawable) i.xv(getContext(), "tt_ad_skip_btn_bg");
        gradientDrawable.setCornerRadius(this.ev / 2);
        gradientDrawable.setColor(this.f29132a.z());
        ((ImageView) this.ys).setBackgroundDrawable(gradientDrawable);
        ((ImageView) this.ys).setImageResource(this.f29205c ? i.sr(getContext(), "tt_close_move_details_normal") : i.sr(getContext(), "tt_skip_btn_wrapper"));
        setVisibility(8);
        return true;
    }
}
