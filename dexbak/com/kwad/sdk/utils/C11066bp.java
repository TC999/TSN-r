package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* renamed from: com.kwad.sdk.utils.bp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11066bp {
    private View aRb;
    public Point aRa = new Point();
    public Rect aQY = new Rect();
    public Rect aQZ = new Rect();

    public C11066bp(View view) {
        this.aRb = view;
    }

    /* renamed from: Nr */
    public final boolean m23854Nr() {
        boolean globalVisibleRect = this.aRb.getGlobalVisibleRect(this.aQY, this.aRa);
        Point point = this.aRa;
        if (point.x == 0 && point.y == 0 && this.aQY.height() == this.aRb.getHeight() && this.aQZ.height() != 0 && Math.abs(this.aQY.top - this.aQZ.top) > this.aRb.getHeight() / 2) {
            this.aQY.set(this.aQZ);
        }
        this.aQZ.set(this.aQY);
        return globalVisibleRect;
    }
}
