package com.qq.e.dl.l.k.e;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.dl.l.e;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends FrameLayout implements e {

    /* renamed from: c  reason: collision with root package name */
    protected h f47191c;

    public c(Context context) {
        super(context);
    }

    @Override // com.qq.e.dl.l.e
    public void a(h hVar) {
        this.f47191c = hVar;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i4;
        h hVar = this.f47191c;
        com.qq.e.dl.l.i.d g4 = hVar == null ? null : hVar.g();
        int i5 = 0;
        if (g4 != null) {
            i5 = getWidth();
            i4 = getHeight();
            g4.a(canvas, i5, i4);
        } else {
            i4 = 0;
        }
        super.draw(canvas);
        if (g4 != null) {
            g4.b(canvas, i5, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        com.qq.e.dl.l.k.a i6 = this.f47191c.i();
        Pair<Integer, Integer> d4 = i6.d(i4, i5);
        super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
        Pair<Integer, Integer> c4 = i6.c(i4, i5);
        if (c4 != null) {
            super.onMeasure(((Integer) c4.first).intValue(), ((Integer) c4.second).intValue());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i4) {
        this.f47191c.a(view, i4);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f47191c.e(i4);
    }
}
