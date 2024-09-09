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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class WaveView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f18852a;

    /* renamed from: b  reason: collision with root package name */
    private float f18853b;

    /* renamed from: c  reason: collision with root package name */
    private float f18854c;

    /* renamed from: d  reason: collision with root package name */
    private long f18855d;

    /* renamed from: e  reason: collision with root package name */
    private int f18856e;

    /* renamed from: f  reason: collision with root package name */
    private Interpolator f18857f;

    /* renamed from: g  reason: collision with root package name */
    private List f18858g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18859h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18860i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f18861j;

    /* renamed from: k  reason: collision with root package name */
    private long f18862k;

    /* renamed from: l  reason: collision with root package name */
    private Runnable f18863l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WaveView.this.f18859h) {
                WaveView.this.j();
                WaveView waveView = WaveView.this;
                waveView.postDelayed(waveView.f18863l, WaveView.this.f18856e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private long f18865a = System.currentTimeMillis();

        public b() {
        }

        public int b() {
            return (int) ((1.0f - WaveView.this.f18857f.getInterpolation((((float) (System.currentTimeMillis() - this.f18865a)) * 1.0f) / ((float) WaveView.this.f18855d))) * 255.0f);
        }

        public float c() {
            return WaveView.this.f18852a + (WaveView.this.f18857f.getInterpolation((((float) (System.currentTimeMillis() - this.f18865a)) * 1.0f) / ((float) WaveView.this.f18855d)) * (WaveView.this.f18854c - WaveView.this.f18852a));
        }
    }

    public WaveView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f18862k < this.f18856e) {
            return;
        }
        this.f18858g.add(new b());
        invalidate();
        this.f18862k = currentTimeMillis;
    }

    public boolean i() {
        return this.f18859h;
    }

    public void k() {
        if (this.f18859h) {
            return;
        }
        this.f18859h = true;
        this.f18863l.run();
    }

    public void l() {
        this.f18859h = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Iterator it = this.f18858g.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (System.currentTimeMillis() - bVar.f18865a < this.f18855d) {
                this.f18861j.setAlpha(bVar.b());
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, bVar.c(), this.f18861j);
            } else {
                it.remove();
            }
        }
        if (this.f18858g.size() > 0) {
            postInvalidateDelayed(10L);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        if (this.f18860i) {
            return;
        }
        this.f18854c = (Math.min(i4, i5) * this.f18853b) / 2.0f;
    }

    public void setColor(int i4) {
        this.f18861j.setColor(i4);
    }

    public void setDuration(long j4) {
        this.f18855d = j4;
    }

    public void setInitialRadius(float f4) {
        this.f18852a = f4;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f18857f = interpolator;
        if (interpolator == null) {
            this.f18857f = new LinearInterpolator();
        }
    }

    public void setMaxRadius(float f4) {
        this.f18854c = f4;
        this.f18860i = true;
    }

    public void setMaxRadiusRate(float f4) {
        this.f18853b = f4;
    }

    public void setSpeed(int i4) {
        this.f18856e = i4;
    }

    public void setStyle(Paint.Style style) {
        this.f18861j.setStyle(style);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18853b = 0.85f;
        this.f18855d = 2000L;
        this.f18856e = 500;
        this.f18857f = new LinearInterpolator();
        this.f18858g = new ArrayList();
        this.f18863l = new a();
        this.f18861j = new Paint(1);
        setStyle(Paint.Style.FILL);
    }
}
