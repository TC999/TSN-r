package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends sr {
    public c(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    List<ObjectAnimator> c() {
        float s3 = this.f29067w.s() / 100.0f;
        float fz = this.f29067w.fz() / 100.0f;
        if ("reverse".equals(this.f29067w.fp()) && this.f29067w.t() <= 0.0d) {
            fz = s3;
            s3 = fz;
        }
        this.xv.setAlpha(s3);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "alpha", s3, fz).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
