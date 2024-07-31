package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.webview.IWebProgressBar;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ProgressBar extends View implements IWebProgressBar {

    /* renamed from: a */
    Runnable f31191a;

    /* renamed from: b */
    private Rect f31192b;

    /* renamed from: c */
    private float f31193c;

    /* renamed from: d */
    private float f31194d;

    /* renamed from: e */
    private long f31195e;

    /* renamed from: f */
    private float f31196f;

    /* renamed from: g */
    private boolean f31197g;

    /* renamed from: h */
    private float f31198h;

    /* renamed from: i */
    private float f31199i;

    /* renamed from: j */
    private float f31200j;

    /* renamed from: k */
    private long f31201k;

    /* renamed from: l */
    private int f31202l;

    /* renamed from: m */
    private int f31203m;

    /* renamed from: n */
    private int f31204n;

    /* renamed from: o */
    private int f31205o;

    /* renamed from: p */
    private long f31206p;

    /* renamed from: q */
    private Drawable f31207q;

    /* renamed from: r */
    private Drawable f31208r;

    /* renamed from: s */
    private Drawable f31209s;

    /* renamed from: t */
    private Drawable f31210t;

    /* renamed from: u */
    private boolean f31211u;

    /* renamed from: v */
    private IWebProgressBar.InterfaceC11447a f31212v;

    /* renamed from: w */
    private Handler f31213w;

    /* renamed from: x */
    private boolean f31214x;

    /* renamed from: y */
    private boolean f31215y;

    public ProgressBar(Context context) {
        super(context);
        this.f31192b = new Rect();
        this.f31194d = 0.95f;
        this.f31206p = 25L;
        this.f31211u = false;
        this.f31213w = new Handler(Looper.getMainLooper());
        this.f31191a = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.f31215y = false;
        setWillNotDraw(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r12.f31214x != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r12.f31214x != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r12.f31214x != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r12.f31214x != false) goto L69;
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
    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public float getProgress() {
        return this.f31199i;
    }

    public void initResource(boolean z) {
        if (z || (this.f31210t == null && this.f31207q == null && this.f31208r == null && this.f31209s == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", MBSDKContext.m22865f().m22869d()));
            this.f31210t = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f31210t.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", MBSDKContext.m22865f().m22869d()));
            this.f31207q = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f31207q.getIntrinsicHeight());
            }
            this.f31208r = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", MBSDKContext.m22865f().m22869d()));
            this.f31209s = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", MBSDKContext.m22865f().m22869d()));
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f31193c = getMeasuredWidth();
    }

    public void onThemeChange() {
        if (this.f31211u) {
            initResource(true);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Drawable drawable = this.f31210t;
        if (drawable != null) {
            double intrinsicWidth = drawable.getIntrinsicWidth();
            Double.isNaN(intrinsicWidth);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * 1.5d), getHeight());
        }
        Drawable drawable2 = this.f31207q;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    public void setPaused(boolean z) {
        this.f31215y = z;
        if (z) {
            return;
        }
        this.f31195e = System.currentTimeMillis();
    }

    public void setProgress(float f, boolean z) {
        if (!z || f < 1.0f) {
            return;
        }
        startEndAnimation();
    }

    public void setProgressBarListener(IWebProgressBar.InterfaceC11447a interfaceC11447a) {
        this.f31212v = interfaceC11447a;
    }

    public void setProgressState(int i) {
        if (i == 5) {
            this.f31203m = 1;
            this.f31204n = 0;
            this.f31205o = 0;
            this.f31201k = 0L;
        } else if (i == 6) {
            this.f31204n = 1;
            if (this.f31205o == 1) {
                startEndAnimation();
            }
            this.f31201k = 0L;
        } else if (i == 7) {
            startEndAnimation();
        } else if (i != 8) {
        } else {
            this.f31205o = 1;
            if (this.f31204n == 1) {
                startEndAnimation();
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            IWebProgressBar.InterfaceC11447a interfaceC11447a = this.f31212v;
            if (interfaceC11447a != null) {
                interfaceC11447a.m21704a(true);
                return;
            }
            return;
        }
        IWebProgressBar.InterfaceC11447a interfaceC11447a2 = this.f31212v;
        if (interfaceC11447a2 != null) {
            interfaceC11447a2.m21704a(false);
        }
    }

    public void setVisible(boolean z) {
        if (z) {
            this.f31214x = true;
            this.f31195e = System.currentTimeMillis();
            this.f31196f = 0.0f;
            this.f31201k = 0L;
            this.f31197g = false;
            this.f31198h = 0.0f;
            this.f31199i = 0.0f;
            this.f31193c = getMeasuredWidth();
            this.f31215y = false;
            this.f31203m = 0;
            this.f31204n = 0;
            this.f31205o = 0;
            Drawable drawable = this.f31210t;
            if (drawable != null) {
                this.f31202l = -drawable.getIntrinsicWidth();
            } else {
                this.f31202l = 0;
            }
            Drawable drawable2 = this.f31208r;
            if (drawable2 != null) {
                drawable2.setAlpha(255);
            }
            Drawable drawable3 = this.f31209s;
            if (drawable3 != null) {
                drawable3.setAlpha(255);
            }
            Drawable drawable4 = this.f31207q;
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
        if (this.f31197g) {
            return;
        }
        this.f31197g = true;
        this.f31198h = 0.0f;
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f31192b = new Rect();
        this.f31194d = 0.95f;
        this.f31206p = 25L;
        this.f31211u = false;
        this.f31213w = new Handler(Looper.getMainLooper());
        this.f31191a = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.f31215y = false;
        setWillNotDraw(false);
    }
}
