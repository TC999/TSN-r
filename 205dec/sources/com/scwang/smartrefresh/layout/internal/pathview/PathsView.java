package com.scwang.smartrefresh.layout.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class PathsView extends View {

    /* renamed from: a  reason: collision with root package name */
    protected b f48048a;

    public PathsView(Context context) {
        super(context);
        this.f48048a = new b();
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i4) {
        this.f48048a = new b();
    }

    public void b(int... iArr) {
        this.f48048a.h(iArr);
    }

    public void c(String... strArr) {
        this.f48048a.i(strArr);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f48048a.draw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            c(getTag().toString());
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        this.f48048a.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i6 - i4) - getPaddingRight(), getPaddingLeft()), Math.max((i7 - i5) - getPaddingTop(), getPaddingTop()));
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(this.f48048a.n() + getPaddingLeft() + getPaddingRight(), i4), View.resolveSize(this.f48048a.f() + getPaddingTop() + getPaddingBottom(), i5));
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48048a = new b();
        a(context, attributeSet, 0);
    }

    public PathsView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f48048a = new b();
        a(context, attributeSet, i4);
    }
}
