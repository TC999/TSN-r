package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys extends sr {
    public ys(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    List<ObjectAnimator> c() {
        float f4;
        float c4 = com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29067w.f());
        float c5 = com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29067w.r());
        float f5 = 0.0f;
        if ("reverse".equals(this.f29067w.fp())) {
            f5 = c4;
            f4 = c5;
            c4 = 0.0f;
            c5 = 0.0f;
        } else {
            f4 = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.sr.w.c(this.xv.getContext())) {
            c4 = -c4;
            f5 = -f5;
        }
        this.xv.setTranslationX(c4);
        this.xv.setTranslationY(c5);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "translationX", c4, f5).setDuration((int) (this.f29067w.p() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.xv, "translationY", c5, f4).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        return arrayList;
    }
}
