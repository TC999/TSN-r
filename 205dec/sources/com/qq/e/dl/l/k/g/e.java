package com.qq.e.dl.l.k.g;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends RecyclerView implements com.qq.e.dl.l.e<c> {

    /* renamed from: c  reason: collision with root package name */
    private h f47224c;

    public e(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        int i4;
        h hVar = this.f47224c;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i4, int i5) {
        com.qq.e.dl.l.k.a i6 = this.f47224c.i();
        Pair<Integer, Integer> d4 = i6.d(i4, i5);
        super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
        Pair<Integer, Integer> c4 = i6.c(i4, i5);
        if (c4 != null) {
            super.setMeasuredDimension(View.MeasureSpec.getSize(((Integer) c4.first).intValue()), View.MeasureSpec.getSize(((Integer) c4.second).intValue()));
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i4) {
        this.f47224c.a(view, i4);
    }

    @Override // com.qq.e.dl.l.e
    public void a(c cVar) {
        this.f47224c = cVar;
    }
}
