package com.yalantis.ucrop.util;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SelectedStateListDrawable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i extends StateListDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f54444a;

    public i(Drawable drawable, int i4) {
        this.f54444a = i4;
        addState(new int[]{16842913}, drawable);
        addState(new int[0], drawable);
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z3 = false;
        for (int i4 : iArr) {
            if (i4 == 16842913) {
                z3 = true;
            }
        }
        if (z3) {
            super.setColorFilter(this.f54444a, PorterDuff.Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
