package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.R;
import com.github.barteksc.pdfviewer.util.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class DefaultScrollHandle extends RelativeLayout implements com.github.barteksc.pdfviewer.scroll.a {

    /* renamed from: i  reason: collision with root package name */
    private static final int f37291i = 65;

    /* renamed from: j  reason: collision with root package name */
    private static final int f37292j = 40;

    /* renamed from: k  reason: collision with root package name */
    private static final int f37293k = 16;

    /* renamed from: a  reason: collision with root package name */
    private float f37294a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f37295b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f37296c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f37297d;

    /* renamed from: e  reason: collision with root package name */
    private PDFView f37298e;

    /* renamed from: f  reason: collision with root package name */
    private float f37299f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f37300g;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f37301h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultScrollHandle.this.f();
        }
    }

    public DefaultScrollHandle(Context context) {
        this(context, false);
    }

    private void a() {
        float x3;
        float width;
        int width2;
        if (this.f37298e.Q()) {
            x3 = getY();
            width = getHeight();
            width2 = this.f37298e.getHeight();
        } else {
            x3 = getX();
            width = getWidth();
            width2 = this.f37298e.getWidth();
        }
        this.f37294a = ((x3 + this.f37294a) / width2) * width;
    }

    private boolean b() {
        PDFView pDFView = this.f37298e;
        return (pDFView == null || pDFView.getPageCount() <= 0 || this.f37298e.n()) ? false : true;
    }

    private void setPosition(float f4) {
        int width;
        if (Float.isInfinite(f4) || Float.isNaN(f4)) {
            return;
        }
        if (this.f37298e.Q()) {
            width = this.f37298e.getHeight();
        } else {
            width = this.f37298e.getWidth();
        }
        float f5 = width;
        float f6 = f4 - this.f37294a;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        } else if (f6 > f5 - f.a(this.f37296c, 40)) {
            f6 = f5 - f.a(this.f37296c, 40);
        }
        if (this.f37298e.Q()) {
            setY(f6);
        } else {
            setX(f6);
        }
        a();
        invalidate();
    }

    @Override // com.github.barteksc.pdfviewer.scroll.a
    public void f() {
        setVisibility(4);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.a
    public void g() {
        this.f37300g.postDelayed(this.f37301h, 1000L);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.a
    public void h() {
        this.f37298e.removeView(this);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.a
    public boolean i() {
        return getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.b()
            if (r0 != 0) goto Lb
            boolean r5 = super.onTouchEvent(r5)
            return r5
        Lb:
            int r0 = r5.getAction()
            r1 = 1
            if (r0 == 0) goto L2e
            if (r0 == r1) goto L25
            r2 = 2
            if (r0 == r2) goto L59
            r2 = 3
            if (r0 == r2) goto L25
            r2 = 5
            if (r0 == r2) goto L2e
            r2 = 6
            if (r0 == r2) goto L25
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L25:
            r4.g()
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f37298e
            r5.g0()
            return r1
        L2e:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f37298e
            r0.o0()
            android.os.Handler r0 = r4.f37300g
            java.lang.Runnable r2 = r4.f37301h
            r0.removeCallbacks(r2)
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f37298e
            boolean r0 = r0.Q()
            if (r0 == 0) goto L4e
            float r0 = r5.getRawY()
            float r2 = r4.getY()
            float r0 = r0 - r2
            r4.f37299f = r0
            goto L59
        L4e:
            float r0 = r5.getRawX()
            float r2 = r4.getX()
            float r0 = r0 - r2
            r4.f37299f = r0
        L59:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f37298e
            boolean r0 = r0.Q()
            r2 = 0
            if (r0 == 0) goto L7d
            float r5 = r5.getRawY()
            float r0 = r4.f37299f
            float r5 = r5 - r0
            float r0 = r4.f37294a
            float r5 = r5 + r0
            r4.setPosition(r5)
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f37298e
            float r0 = r4.f37294a
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            r5.l0(r0, r2)
            goto L97
        L7d:
            float r5 = r5.getRawX()
            float r0 = r4.f37299f
            float r5 = r5 - r0
            float r0 = r4.f37294a
            float r5 = r5 + r0
            r4.setPosition(r5)
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f37298e
            float r0 = r4.f37294a
            int r3 = r4.getWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            r5.l0(r0, r2)
        L97:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.github.barteksc.pdfviewer.scroll.a
    public void setPageNum(int i4) {
        String valueOf = String.valueOf(i4);
        if (this.f37295b.getText().equals(valueOf)) {
            return;
        }
        this.f37295b.setText(valueOf);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.a
    public void setScroll(float f4) {
        if (!i()) {
            show();
        } else {
            this.f37300g.removeCallbacks(this.f37301h);
        }
        PDFView pDFView = this.f37298e;
        if (pDFView != null) {
            setPosition((pDFView.Q() ? this.f37298e.getHeight() : this.f37298e.getWidth()) * f4);
        }
    }

    public void setTextColor(int i4) {
        this.f37295b.setTextColor(i4);
    }

    public void setTextSize(int i4) {
        this.f37295b.setTextSize(1, i4);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.a
    public void setupLayout(PDFView pDFView) {
        int i4;
        Drawable drawable;
        int i5 = 65;
        int i6 = 40;
        if (pDFView.Q()) {
            if (this.f37297d) {
                i4 = 9;
                drawable = ContextCompat.getDrawable(this.f37296c, R.drawable.default_scroll_handle_left);
            } else {
                i4 = 11;
                drawable = ContextCompat.getDrawable(this.f37296c, R.drawable.default_scroll_handle_right);
            }
        } else {
            if (this.f37297d) {
                i4 = 10;
                drawable = ContextCompat.getDrawable(this.f37296c, R.drawable.default_scroll_handle_top);
            } else {
                i4 = 12;
                drawable = ContextCompat.getDrawable(this.f37296c, R.drawable.default_scroll_handle_bottom);
            }
            i5 = 40;
            i6 = 65;
        }
        setBackground(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f.a(this.f37296c, i5), f.a(this.f37296c, i6));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.f37295b, layoutParams2);
        layoutParams.addRule(i4);
        pDFView.addView(this, layoutParams);
        this.f37298e = pDFView;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.a
    public void show() {
        setVisibility(0);
    }

    public DefaultScrollHandle(Context context, boolean z3) {
        super(context);
        this.f37294a = 0.0f;
        this.f37300g = new Handler();
        this.f37301h = new a();
        this.f37296c = context;
        this.f37297d = z3;
        this.f37295b = new TextView(context);
        setVisibility(4);
        setTextColor(-16777216);
        setTextSize(16);
    }
}
