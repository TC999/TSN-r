package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends sr {
    public k(View view, com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar) {
        super(view, cVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.c.sr
    List<ObjectAnimator> c() {
        float f4;
        float k4 = (float) this.f29067w.k();
        float a4 = (float) this.f29067w.a();
        String fp = this.f29067w.fp();
        float f5 = 1.0f;
        if ("reverse".equals(fp) || "alternate-reverse".equals(fp)) {
            f4 = 1.0f;
        } else {
            f5 = k4;
            f4 = a4;
            k4 = 1.0f;
            a4 = 1.0f;
        }
        this.xv.setTag(2097610710, this.f29067w.w());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.xv, "scaleX", k4, f5).setDuration((int) (this.f29067w.p() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.xv, "scaleY", a4, f4).setDuration((int) (this.f29067w.p() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        return arrayList;
    }
}
