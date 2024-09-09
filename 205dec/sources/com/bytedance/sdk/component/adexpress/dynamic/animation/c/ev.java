package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends sr {
    public ev(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    @SuppressLint({"ObjectAnimatorBinding"})
    List<ObjectAnimator> c() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.f29067w.p() * 1000.0d));
        ((ViewGroup) this.xv.getParent()).setClipChildren(false);
        ((ViewGroup) this.xv.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.xv.getParent().getParent().getParent()).setClipChildren(false);
        this.xv.setTag(2097610712, this.f29067w.ev());
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
