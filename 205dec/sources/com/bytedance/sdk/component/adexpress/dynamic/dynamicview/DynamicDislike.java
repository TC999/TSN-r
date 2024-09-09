package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        DislikeView dislikeView = new DislikeView(context);
        this.ys = dislikeView;
        dislikeView.setTag(3);
        addView(this.ys, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.ys);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        super.ev();
        int c4 = (int) f.c(this.f29136k, this.f29132a.ia());
        View view = this.ys;
        if (view instanceof DislikeView) {
            ((DislikeView) view).setRadius((int) f.c(this.f29136k, this.f29132a.ys()));
            ((DislikeView) this.ys).setStrokeWidth(c4);
            ((DislikeView) this.ys).setStrokeColor(this.f29132a.fp());
            ((DislikeView) this.ys).setBgColor(this.f29132a.z());
            ((DislikeView) this.ys).setDislikeColor(this.f29132a.r());
            ((DislikeView) this.ys).setDislikeWidth((int) f.c(this.f29136k, 1.0f));
            return true;
        }
        return true;
    }
}
