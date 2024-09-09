package com.kwad.components.core.s;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i {
    public static void a(com.kwad.components.core.widget.e eVar, ViewGroup viewGroup) {
        if (eVar == null || viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof com.kwad.components.core.widget.d) {
                ((com.kwad.components.core.widget.d) childAt).a(eVar);
            } else if (childAt instanceof ViewGroup) {
                a(eVar, (ViewGroup) childAt);
            }
        }
    }

    public static void b(com.kwad.components.core.widget.e eVar, Drawable drawable) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(eVar.tt());
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(eVar.tt());
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(eVar.tt());
        }
    }
}
