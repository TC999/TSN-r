package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.sr.k;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        TextView textView = new TextView(context);
        this.ys = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.ys, getWidgetLayoutParams());
    }

    private boolean gd() {
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.f29132a.f29376w) && this.f29132a.f29376w.contains("adx:")) || k.w();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        this.ys.setTextAlignment(this.f29132a.ev());
        ((TextView) this.ys).setTextColor(this.f29132a.r());
        ((TextView) this.ys).setTextSize(this.f29132a.ux());
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            ((TextView) this.ys).setIncludeFontPadding(false);
            ((TextView) this.ys).setTextSize(Math.min(((f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), this.ev) - this.f29132a.w()) - this.f29132a.c()) - 0.5f, this.f29132a.ux()));
            ((TextView) this.ys).setText(i.c(getContext(), "tt_logo_en"));
            return true;
        } else if (gd()) {
            if (k.w()) {
                ((TextView) this.ys).setText(k.c());
                return true;
            }
            ((TextView) this.ys).setText(k.c(this.f29132a.f29376w));
            return true;
        } else {
            ((TextView) this.ys).setText(i.w(getContext(), "tt_logo_cn"));
            return true;
        }
    }
}
