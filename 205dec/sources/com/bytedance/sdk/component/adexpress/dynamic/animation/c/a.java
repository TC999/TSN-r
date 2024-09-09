package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends sr {
    public a(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    @SuppressLint({"ObjectAnimatorBinding"})
    List<ObjectAnimator> c() {
        int i4;
        int i5;
        this.xv.setTag(2097610711, Integer.valueOf(this.f29067w.sr()));
        View view = this.xv;
        if (view == null || !com.bytedance.sdk.component.adexpress.sr.w.c(view.getContext())) {
            i4 = 0;
            i5 = 1;
        } else {
            i4 = 1;
            i5 = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "shineValue", i4, i5).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
