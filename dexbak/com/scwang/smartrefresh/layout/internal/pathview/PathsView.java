package com.scwang.smartrefresh.layout.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PathsView extends View {

    /* renamed from: a */
    protected PathsDrawable f33714a;

    public PathsView(Context context) {
        super(context);
        this.f33714a = new PathsDrawable();
        m19829a(context, null, 0);
    }

    /* renamed from: a */
    private void m19829a(Context context, AttributeSet attributeSet, int i) {
        this.f33714a = new PathsDrawable();
    }

    /* renamed from: b */
    public void m19828b(int... iArr) {
        this.f33714a.m19801h(iArr);
    }

    /* renamed from: c */
    public void m19827c(String... strArr) {
        this.f33714a.m19800i(strArr);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f33714a.draw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            m19827c(getTag().toString());
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f33714a.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i3 - i) - getPaddingRight(), getPaddingLeft()), Math.max((i4 - i2) - getPaddingTop(), getPaddingTop()));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(this.f33714a.m19795n() + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(this.f33714a.m19803f() + getPaddingTop() + getPaddingBottom(), i2));
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33714a = new PathsDrawable();
        m19829a(context, attributeSet, 0);
    }

    public PathsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33714a = new PathsDrawable();
        m19829a(context, attributeSet, i);
    }
}
