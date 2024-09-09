package com.romainpiel.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ShimmerViewHelper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: k  reason: collision with root package name */
    private static final int f47447k = -1;

    /* renamed from: a  reason: collision with root package name */
    private View f47448a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f47449b;

    /* renamed from: c  reason: collision with root package name */
    private float f47450c;

    /* renamed from: d  reason: collision with root package name */
    private LinearGradient f47451d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f47452e;

    /* renamed from: f  reason: collision with root package name */
    private int f47453f;

    /* renamed from: g  reason: collision with root package name */
    private int f47454g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f47455h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f47456i;

    /* renamed from: j  reason: collision with root package name */
    private a f47457j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ShimmerViewHelper.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void a(View view);
    }

    public d(View view, Paint paint, AttributeSet attributeSet) {
        this.f47448a = view;
        this.f47449b = paint;
        d(attributeSet);
    }

    private void d(AttributeSet attributeSet) {
        this.f47454g = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.f47448a.getContext().obtainStyledAttributes(attributeSet, R.styleable.ShimmerView, 0, 0);
            try {
                if (obtainStyledAttributes != null) {
                    try {
                        this.f47454g = obtainStyledAttributes.getColor(R.styleable.ShimmerView_reflectionColor, -1);
                    } catch (Exception e4) {
                        Log.e("ShimmerTextView", "Error while creating the view:", e4);
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f47452e = new Matrix();
    }

    private void i() {
        int i4 = this.f47453f;
        LinearGradient linearGradient = new LinearGradient(-this.f47448a.getWidth(), 0.0f, 0.0f, 0.0f, new int[]{i4, this.f47454g, i4}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f47451d = linearGradient;
        this.f47449b.setShader(linearGradient);
    }

    public float a() {
        return this.f47450c;
    }

    public int b() {
        return this.f47453f;
    }

    public int c() {
        return this.f47454g;
    }

    public boolean e() {
        return this.f47456i;
    }

    public boolean f() {
        return this.f47455h;
    }

    public void g() {
        if (this.f47455h) {
            if (this.f47449b.getShader() == null) {
                this.f47449b.setShader(this.f47451d);
            }
            this.f47452e.setTranslate(this.f47450c * 2.0f, 0.0f);
            this.f47451d.setLocalMatrix(this.f47452e);
            return;
        }
        this.f47449b.setShader(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        i();
        if (this.f47456i) {
            return;
        }
        this.f47456i = true;
        a aVar = this.f47457j;
        if (aVar != null) {
            aVar.a(this.f47448a);
        }
    }

    public void j(a aVar) {
        this.f47457j = aVar;
    }

    public void k(float f4) {
        this.f47450c = f4;
        this.f47448a.invalidate();
    }

    public void l(int i4) {
        this.f47453f = i4;
        if (this.f47456i) {
            i();
        }
    }

    public void m(int i4) {
        this.f47454g = i4;
        if (this.f47456i) {
            i();
        }
    }

    public void n(boolean z3) {
        this.f47455h = z3;
    }
}
