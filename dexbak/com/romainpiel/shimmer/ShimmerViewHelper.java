package com.romainpiel.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/* renamed from: com.romainpiel.shimmer.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ShimmerViewHelper {

    /* renamed from: k */
    private static final int f32988k = -1;

    /* renamed from: a */
    private View f32989a;

    /* renamed from: b */
    private Paint f32990b;

    /* renamed from: c */
    private float f32991c;

    /* renamed from: d */
    private LinearGradient f32992d;

    /* renamed from: e */
    private Matrix f32993e;

    /* renamed from: f */
    private int f32994f;

    /* renamed from: g */
    private int f32995g;

    /* renamed from: h */
    private boolean f32996h;

    /* renamed from: i */
    private boolean f32997i;

    /* renamed from: j */
    private InterfaceC11839a f32998j;

    /* compiled from: ShimmerViewHelper.java */
    /* renamed from: com.romainpiel.shimmer.d$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC11839a {
        /* renamed from: a */
        void mo20263a(View view);
    }

    public ShimmerViewHelper(View view, Paint paint, AttributeSet attributeSet) {
        this.f32989a = view;
        this.f32990b = paint;
        m20274d(attributeSet);
    }

    /* renamed from: d */
    private void m20274d(AttributeSet attributeSet) {
        this.f32995g = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.f32989a.getContext().obtainStyledAttributes(attributeSet, C11833R.styleable.ShimmerView, 0, 0);
            try {
                if (obtainStyledAttributes != null) {
                    try {
                        this.f32995g = obtainStyledAttributes.getColor(C11833R.styleable.ShimmerView_reflectionColor, -1);
                    } catch (Exception e) {
                        Log.e("ShimmerTextView", "Error while creating the view:", e);
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f32993e = new Matrix();
    }

    /* renamed from: i */
    private void m20269i() {
        int i = this.f32994f;
        LinearGradient linearGradient = new LinearGradient(-this.f32989a.getWidth(), 0.0f, 0.0f, 0.0f, new int[]{i, this.f32995g, i}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f32992d = linearGradient;
        this.f32990b.setShader(linearGradient);
    }

    /* renamed from: a */
    public float m20277a() {
        return this.f32991c;
    }

    /* renamed from: b */
    public int m20276b() {
        return this.f32994f;
    }

    /* renamed from: c */
    public int m20275c() {
        return this.f32995g;
    }

    /* renamed from: e */
    public boolean m20273e() {
        return this.f32997i;
    }

    /* renamed from: f */
    public boolean m20272f() {
        return this.f32996h;
    }

    /* renamed from: g */
    public void m20271g() {
        if (this.f32996h) {
            if (this.f32990b.getShader() == null) {
                this.f32990b.setShader(this.f32992d);
            }
            this.f32993e.setTranslate(this.f32991c * 2.0f, 0.0f);
            this.f32992d.setLocalMatrix(this.f32993e);
            return;
        }
        this.f32990b.setShader(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m20270h() {
        m20269i();
        if (this.f32997i) {
            return;
        }
        this.f32997i = true;
        InterfaceC11839a interfaceC11839a = this.f32998j;
        if (interfaceC11839a != null) {
            interfaceC11839a.mo20263a(this.f32989a);
        }
    }

    /* renamed from: j */
    public void m20268j(InterfaceC11839a interfaceC11839a) {
        this.f32998j = interfaceC11839a;
    }

    /* renamed from: k */
    public void m20267k(float f) {
        this.f32991c = f;
        this.f32989a.invalidate();
    }

    /* renamed from: l */
    public void m20266l(int i) {
        this.f32994f = i;
        if (this.f32997i) {
            m20269i();
        }
    }

    /* renamed from: m */
    public void m20265m(int i) {
        this.f32995g = i;
        if (this.f32997i) {
            m20269i();
        }
    }

    /* renamed from: n */
    public void m20264n(boolean z) {
        this.f32996h = z;
    }
}
