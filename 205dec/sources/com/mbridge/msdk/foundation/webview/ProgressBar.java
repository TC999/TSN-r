package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.webview.a;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ProgressBar extends View implements a {

    /* renamed from: a  reason: collision with root package name */
    Runnable f39964a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f39965b;

    /* renamed from: c  reason: collision with root package name */
    private float f39966c;

    /* renamed from: d  reason: collision with root package name */
    private float f39967d;

    /* renamed from: e  reason: collision with root package name */
    private long f39968e;

    /* renamed from: f  reason: collision with root package name */
    private float f39969f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f39970g;

    /* renamed from: h  reason: collision with root package name */
    private float f39971h;

    /* renamed from: i  reason: collision with root package name */
    private float f39972i;

    /* renamed from: j  reason: collision with root package name */
    private float f39973j;

    /* renamed from: k  reason: collision with root package name */
    private long f39974k;

    /* renamed from: l  reason: collision with root package name */
    private int f39975l;

    /* renamed from: m  reason: collision with root package name */
    private int f39976m;

    /* renamed from: n  reason: collision with root package name */
    private int f39977n;

    /* renamed from: o  reason: collision with root package name */
    private int f39978o;

    /* renamed from: p  reason: collision with root package name */
    private long f39979p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f39980q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f39981r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f39982s;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f39983t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f39984u;

    /* renamed from: v  reason: collision with root package name */
    private a.InterfaceC0745a f39985v;

    /* renamed from: w  reason: collision with root package name */
    private Handler f39986w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f39987x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f39988y;

    public ProgressBar(Context context) {
        super(context);
        this.f39965b = new Rect();
        this.f39967d = 0.95f;
        this.f39979p = 25L;
        this.f39984u = false;
        this.f39986w = new Handler(Looper.getMainLooper());
        this.f39964a = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.f39988y = false;
        setWillNotDraw(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r12.f39987x != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r12.f39987x != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r12.f39987x != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r12.f39987x != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
        r8 = 1.0f;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.ProgressBar.draw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean z3) {
        return null;
    }

    public float getProgress() {
        return this.f39972i;
    }

    public void initResource(boolean z3) {
        if (z3 || (this.f39983t == null && this.f39980q == null && this.f39981r == null && this.f39982s == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
            this.f39983t = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f39983t.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
            this.f39980q = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f39980q.getIntrinsicHeight());
            }
            this.f39981r = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
            this.f39982s = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f39966c = getMeasuredWidth();
    }

    public void onThemeChange() {
        if (this.f39984u) {
            initResource(true);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        Drawable drawable = this.f39983t;
        if (drawable != null) {
            double intrinsicWidth = drawable.getIntrinsicWidth();
            Double.isNaN(intrinsicWidth);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * 1.5d), getHeight());
        }
        Drawable drawable2 = this.f39980q;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    public void setPaused(boolean z3) {
        this.f39988y = z3;
        if (z3) {
            return;
        }
        this.f39968e = System.currentTimeMillis();
    }

    public void setProgress(float f4, boolean z3) {
        if (!z3 || f4 < 1.0f) {
            return;
        }
        startEndAnimation();
    }

    public void setProgressBarListener(a.InterfaceC0745a interfaceC0745a) {
        this.f39985v = interfaceC0745a;
    }

    public void setProgressState(int i4) {
        if (i4 == 5) {
            this.f39976m = 1;
            this.f39977n = 0;
            this.f39978o = 0;
            this.f39974k = 0L;
        } else if (i4 == 6) {
            this.f39977n = 1;
            if (this.f39978o == 1) {
                startEndAnimation();
            }
            this.f39974k = 0L;
        } else if (i4 == 7) {
            startEndAnimation();
        } else if (i4 != 8) {
        } else {
            this.f39978o = 1;
            if (this.f39977n == 1) {
                startEndAnimation();
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        if (i4 == 0) {
            a.InterfaceC0745a interfaceC0745a = this.f39985v;
            if (interfaceC0745a != null) {
                interfaceC0745a.a(true);
                return;
            }
            return;
        }
        a.InterfaceC0745a interfaceC0745a2 = this.f39985v;
        if (interfaceC0745a2 != null) {
            interfaceC0745a2.a(false);
        }
    }

    public void setVisible(boolean z3) {
        if (z3) {
            this.f39987x = true;
            this.f39968e = System.currentTimeMillis();
            this.f39969f = 0.0f;
            this.f39974k = 0L;
            this.f39970g = false;
            this.f39971h = 0.0f;
            this.f39972i = 0.0f;
            this.f39966c = getMeasuredWidth();
            this.f39988y = false;
            this.f39976m = 0;
            this.f39977n = 0;
            this.f39978o = 0;
            Drawable drawable = this.f39983t;
            if (drawable != null) {
                this.f39975l = -drawable.getIntrinsicWidth();
            } else {
                this.f39975l = 0;
            }
            Drawable drawable2 = this.f39981r;
            if (drawable2 != null) {
                drawable2.setAlpha(255);
            }
            Drawable drawable3 = this.f39982s;
            if (drawable3 != null) {
                drawable3.setAlpha(255);
            }
            Drawable drawable4 = this.f39980q;
            if (drawable4 != null) {
                drawable4.setAlpha(255);
            }
            setVisibility(0);
            invalidate();
            return;
        }
        setVisibility(4);
    }

    public void startEndAnimation() {
        if (this.f39970g) {
            return;
        }
        this.f39970g = true;
        this.f39971h = 0.0f;
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39965b = new Rect();
        this.f39967d = 0.95f;
        this.f39979p = 25L;
        this.f39984u = false;
        this.f39986w = new Handler(Looper.getMainLooper());
        this.f39964a = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.f39988y = false;
        setWillNotDraw(false);
    }
}
