package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp extends sr {
    public fp(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    List<ObjectAnimator> c() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), 20.0f), 0.0f, -com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), 20.0f), 0.0f).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
