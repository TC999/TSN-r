package com.bytedance.sdk.component.adexpress.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.sr.xv;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.i;
import java.io.File;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class GifView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f29551a;
    private volatile boolean bk;

    /* renamed from: c  reason: collision with root package name */
    private int f29552c;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29553f;
    private float gd;

    /* renamed from: k  reason: collision with root package name */
    private int f29554k;

    /* renamed from: p  reason: collision with root package name */
    private float f29555p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f29556r;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f29557t;
    private AnimatedImageDrawable ux;

    /* renamed from: w  reason: collision with root package name */
    private Movie f29558w;
    private long xv;
    private boolean ys;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.f29553f = Build.VERSION.SDK_INT >= 28;
        this.f29556r = false;
        this.f29557t = true;
        this.ys = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            this.ux = animatedImageDrawable;
            if (!this.bk) {
                animatedImageDrawable.start();
            }
            if (!this.ys) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        xv();
    }

    private void sr() {
        if (this.f29558w == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.xv == 0) {
            this.xv = uptimeMillis;
        }
        int duration = this.f29558w.duration();
        if (duration == 0) {
            duration = 1000;
        }
        if (!this.ys && Math.abs(duration - this.sr) < 60) {
            this.sr = duration;
            this.bk = true;
            return;
        }
        this.sr = (int) ((uptimeMillis - this.xv) % duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.ImageDecoder.Source w(byte[] r6) {
        /*
            r5 = this;
            r0 = 0
            com.bytedance.sdk.component.adexpress.c.c.c r1 = com.bytedance.sdk.component.adexpress.c.c.c.c()     // Catch: java.lang.Throwable -> L3c
            com.bytedance.sdk.component.adexpress.c.c.xv r1 = r1.xv()     // Catch: java.lang.Throwable -> L3c
            boolean r1 = r1.bk()     // Catch: java.lang.Throwable -> L3c
            android.content.Context r2 = r5.getContext()     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L16
            java.lang.String r1 = "GIF_AD_CACHE/"
            goto L18
        L16:
            java.lang.String r1 = "/GIF_CACHE/"
        L18:
            java.lang.String r3 = "TT_GIF_FILE"
            java.io.File r1 = c(r2, r1, r3)     // Catch: java.lang.Throwable -> L3c
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3c
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L3c
            r3 = 0
            int r4 = r6.length     // Catch: java.lang.Throwable -> L3a
            r2.write(r6, r3, r4)     // Catch: java.lang.Throwable -> L3a
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L3a
            r3 = 28
            if (r6 < r3) goto L36
            android.graphics.ImageDecoder$Source r6 = android.graphics.ImageDecoder.createSource(r1)     // Catch: java.lang.Throwable -> L3a
            r2.close()     // Catch: java.lang.Throwable -> L35
        L35:
            return r6
        L36:
            r2.close()     // Catch: java.lang.Throwable -> L48
            goto L48
        L3a:
            r6 = move-exception
            goto L3e
        L3c:
            r6 = move-exception
            r2 = r0
        L3e:
            java.lang.String r1 = "GifView"
            java.lang.String r3 = "GifView  getSourceByFile fail : "
            com.bytedance.sdk.component.utils.a.xv(r1, r3, r6)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L48
            goto L36
        L48:
            return r0
        L49:
            r6 = move-exception
            if (r2 == 0) goto L4f
            r2.close()     // Catch: java.lang.Throwable -> L4f
        L4f:
            goto L51
        L50:
            throw r6
        L51:
            goto L50
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.widget.GifView.w(byte[]):android.graphics.ImageDecoder$Source");
    }

    private void xv() {
        if (this.f29558w == null || this.f29553f || !this.f29557t) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f29558w != null && !this.f29553f) {
            try {
                if (!this.bk) {
                    sr();
                    c(canvas);
                    xv();
                } else {
                    c(canvas);
                }
                return;
            } catch (Throwable th) {
                a.xv("GifView", "onDraw->Throwable->", th);
                return;
            }
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (this.f29558w != null && !this.f29553f) {
            this.ev = (getWidth() - this.f29554k) / 2.0f;
            this.gd = (getHeight() - this.f29551a) / 2.0f;
        }
        this.f29557t = getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i4, int i5) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i4, i5);
        if (this.f29553f || (movie = this.f29558w) == null) {
            return;
        }
        int width = movie.width();
        int height = this.f29558w.height();
        float max = 1.0f / Math.max((View.MeasureSpec.getMode(i4) == 0 || width <= (size2 = View.MeasureSpec.getSize(i4))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i5) == 0 || height <= (size = View.MeasureSpec.getSize(i5))) ? 1.0f : height / size);
        this.f29555p = max;
        int i6 = (int) (width * max);
        this.f29554k = i6;
        int i7 = (int) (height * max);
        this.f29551a = i7;
        setMeasuredDimension(i6, i7);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i4) {
        super.onScreenStateChanged(i4);
        if (this.f29558w != null) {
            this.f29557t = i4 == 1;
            xv();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        if (this.f29558w != null) {
            this.f29557t = i4 == 0;
            xv();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        if (this.f29558w != null) {
            this.f29557t = i4 == 0;
            xv();
        }
    }

    public void setRepeatConfig(boolean z3) {
        AnimatedImageDrawable animatedImageDrawable;
        this.ys = z3;
        if (z3) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.ux) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e4) {
            a.xv("GifView", "setRepeatConfig error", e4);
        }
    }

    void c() {
        if (this.f29553f) {
            return;
        }
        setLayerType(1, null);
    }

    public void c(int i4, boolean z3) {
        this.bk = z3;
        this.f29552c = i4;
        if (i4 == -1) {
            return;
        }
        if (!this.f29553f) {
            this.f29558w = c(i4);
        } else {
            c(i4, new c() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.c
                public void c(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source w(int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ImageDecoder.createSource(i.c(getContext()), i4);
        }
        return null;
    }

    public void c(byte[] bArr, boolean z3) {
        this.bk = z3;
        if (bArr == null) {
            return;
        }
        if (!this.f29553f) {
            this.f29558w = c(bArr);
        } else {
            c(bArr, new c() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.c
                public void c(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    public void w() {
        if (this.f29558w == null || !this.bk) {
            return;
        }
        this.bk = false;
        if (!this.f29553f) {
            this.xv = SystemClock.uptimeMillis() - this.sr;
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.ux;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.ux.start();
    }

    private Movie c(int i4) {
        try {
            return Movie.decodeStream(i.c(getContext()).openRawResource(i4));
        } catch (Throwable th) {
            a.c("GifView", "createMovieWithResourceIdBySafely error", th);
            return null;
        }
    }

    private Movie c(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable th) {
            a.c("GifView", "createMovieWithByteArrayBySafely error1", th);
            return null;
        }
    }

    private void c(final int i4, final c cVar) {
        if (i4 == -1) {
            return;
        }
        xv.c(new p("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.3
            @Override // java.lang.Runnable
            public void run() {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    GifView gifView = GifView.this;
                    cVar2.c(gifView.c(gifView.w(i4)));
                }
            }
        }, 5);
    }

    private void c(final byte[] bArr, final c cVar) {
        if (bArr == null) {
            return;
        }
        xv.c(new p("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.4
            @Override // java.lang.Runnable
            public void run() {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    GifView gifView = GifView.this;
                    cVar2.c(gifView.c(gifView.w(bArr)));
                }
            }
        }, 5);
    }

    public static File c(Context context, String str, String str2) {
        int a4 = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().a();
        boolean bk = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().bk();
        if (a4 == 1) {
            a.f("splashLoadAd", "\u89c6\u9891\u5b58\u50a8\u4f7f\u7528\u5185\u90e8\u5b58\u50a8");
            return f.w(context, bk, str, str2);
        }
        a.f("splashLoadAd", "\u89c6\u9891\u5b58\u50a8\u4f7f\u7528\u5916\u5b58\u50a8");
        return f.c(context, bk, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable c(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable th) {
            a.c("GifView", "getAnimatedImageDrawable error", th);
            return null;
        }
    }

    private void c(Canvas canvas) {
        Movie movie = this.f29558w;
        if (movie == null) {
            return;
        }
        movie.setTime(this.sr);
        float f4 = this.f29555p;
        if (f4 == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.f29558w.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f4, f4);
            Movie movie2 = this.f29558w;
            float f5 = this.ev;
            float f6 = this.f29555p;
            movie2.draw(canvas, f5 / f6, this.gd / f6);
        }
        canvas.restore();
    }
}
