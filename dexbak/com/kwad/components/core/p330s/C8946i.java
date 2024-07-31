package com.kwad.components.core.p330s;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.core.widget.InterfaceC9373d;

/* renamed from: com.kwad.components.core.s.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8946i {
    /* renamed from: a */
    public static void m29551a(C9374e c9374e, ViewGroup viewGroup) {
        if (c9374e == null || viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof InterfaceC9373d) {
                ((InterfaceC9373d) childAt).mo28874a(c9374e);
            } else if (childAt instanceof ViewGroup) {
                m29551a(c9374e, (ViewGroup) childAt);
            }
        }
    }

    /* renamed from: b */
    public static void m29550b(C9374e c9374e, Drawable drawable) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(c9374e.m28873tt());
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(c9374e.m28873tt());
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(c9374e.m28873tt());
        }
    }
}
