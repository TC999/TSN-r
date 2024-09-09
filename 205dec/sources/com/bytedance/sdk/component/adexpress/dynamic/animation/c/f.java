package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends sr {
    public f(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    List<ObjectAnimator> c() {
        float f4 = this.xv.getLayoutParams().width;
        this.xv.setTranslationX(f4);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "translationX", f4, 0.0f).setDuration((int) (this.f29067w.p() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.xv, "alpha", 0.0f, 1.0f).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        return arrayList;
    }
}
