package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk extends sr {
    public bk(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    List<ObjectAnimator> c() {
        View view = this.xv;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicImageView)) {
            View view2 = (View) this.xv.getParent();
            this.xv = view2;
            ((ViewGroup) view2).setClipChildren(true);
            ((ViewGroup) this.xv.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
