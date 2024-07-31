package com.bxkj.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class WaveView extends View {

    /* renamed from: a */
    private float f15282a;

    /* renamed from: b */
    private float f15283b;

    /* renamed from: c */
    private float f15284c;

    /* renamed from: d */
    private long f15285d;

    /* renamed from: e */
    private int f15286e;

    /* renamed from: f */
    private Interpolator f15287f;

    /* renamed from: g */
    private List f15288g;

    /* renamed from: h */
    private boolean f15289h;

    /* renamed from: i */
    private boolean f15290i;

    /* renamed from: j */
    private Paint f15291j;

    /* renamed from: k */
    private long f15292k;

    /* renamed from: l */
    private Runnable f15293l;

    /* renamed from: com.bxkj.base.view.WaveView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC4003a implements Runnable {
        RunnableC4003a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WaveView.this.f15289h) {
                WaveView.this.m43491j();
                WaveView waveView = WaveView.this;
                waveView.postDelayed(waveView.f15293l, WaveView.this.f15286e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bxkj.base.view.WaveView$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4004b {

        /* renamed from: a */
        private long f15295a = System.currentTimeMillis();

        public C4004b() {
        }

        /* renamed from: b */
        public int m43487b() {
            return (int) ((1.0f - WaveView.this.f15287f.getInterpolation((((float) (System.currentTimeMillis() - this.f15295a)) * 1.0f) / ((float) WaveView.this.f15285d))) * 255.0f);
        }

        /* renamed from: c */
        public float m43486c() {
            return WaveView.this.f15282a + (WaveView.this.f15287f.getInterpolation((((float) (System.currentTimeMillis() - this.f15295a)) * 1.0f) / ((float) WaveView.this.f15285d)) * (WaveView.this.f15284c - WaveView.this.f15282a));
        }
    }

    public WaveView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m43491j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f15292k < this.f15286e) {
            return;
        }
        this.f15288g.add(new C4004b());
        invalidate();
        this.f15292k = currentTimeMillis;
    }

    /* renamed from: i */
    public boolean m43492i() {
        return this.f15289h;
    }

    /* renamed from: k */
    public void m43490k() {
        if (this.f15289h) {
            return;
        }
        this.f15289h = true;
        this.f15293l.run();
    }

    /* renamed from: l */
    public void m43489l() {
        this.f15289h = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Iterator it = this.f15288g.iterator();
        while (it.hasNext()) {
            C4004b c4004b = (C4004b) it.next();
            if (System.currentTimeMillis() - c4004b.f15295a < this.f15285d) {
                this.f15291j.setAlpha(c4004b.m43487b());
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, c4004b.m43486c(), this.f15291j);
            } else {
                it.remove();
            }
        }
        if (this.f15288g.size() > 0) {
            postInvalidateDelayed(10L);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.f15290i) {
            return;
        }
        this.f15284c = (Math.min(i, i2) * this.f15283b) / 2.0f;
    }

    public void setColor(int i) {
        this.f15291j.setColor(i);
    }

    public void setDuration(long j) {
        this.f15285d = j;
    }

    public void setInitialRadius(float f) {
        this.f15282a = f;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f15287f = interpolator;
        if (interpolator == null) {
            this.f15287f = new LinearInterpolator();
        }
    }

    public void setMaxRadius(float f) {
        this.f15284c = f;
        this.f15290i = true;
    }

    public void setMaxRadiusRate(float f) {
        this.f15283b = f;
    }

    public void setSpeed(int i) {
        this.f15286e = i;
    }

    public void setStyle(Paint.Style style) {
        this.f15291j.setStyle(style);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15283b = 0.85f;
        this.f15285d = 2000L;
        this.f15286e = 500;
        this.f15287f = new LinearInterpolator();
        this.f15288g = new ArrayList();
        this.f15293l = new RunnableC4003a();
        this.f15291j = new Paint(1);
        setStyle(Paint.Style.FILL);
    }
}
