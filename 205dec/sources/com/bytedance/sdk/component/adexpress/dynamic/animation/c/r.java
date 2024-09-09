package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends sr {
    public r(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    @SuppressLint({"ObjectAnimatorBinding"})
    List<ObjectAnimator> c() {
        this.xv.setTag(2097610709, Integer.valueOf(this.f29067w.xv()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
