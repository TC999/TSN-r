package com.qq.e.comm.plugin.o0.h;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private int f45195c;

    /* renamed from: d  reason: collision with root package name */
    private int f45196d;

    /* renamed from: e  reason: collision with root package name */
    private final i f45197e;

    public h(Context context) {
        super(context);
        this.f45197e = new i();
    }

    public void a(int i4, int i5) {
        this.f45197e.a(i4, i5);
        this.f45195c = i4;
        this.f45196d = i5;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        if (this.f45195c > 0 && this.f45196d > 0) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            Pair<Integer, Integer> a4 = this.f45197e.a(mode, View.MeasureSpec.getMode(i5), size, View.MeasureSpec.getSize(i5));
            setMeasuredDimension(((Integer) a4.first).intValue(), ((Integer) a4.second).intValue());
            return;
        }
        super.onMeasure(i4, i5);
    }
}
