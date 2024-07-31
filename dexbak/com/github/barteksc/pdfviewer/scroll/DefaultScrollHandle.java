package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.github.barteksc.pdfviewer.C6643R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.C6668f;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class DefaultScrollHandle extends RelativeLayout implements ScrollHandle {

    /* renamed from: i */
    private static final int f23722i = 65;

    /* renamed from: j */
    private static final int f23723j = 40;

    /* renamed from: k */
    private static final int f23724k = 16;

    /* renamed from: a */
    private float f23725a;

    /* renamed from: b */
    protected TextView f23726b;

    /* renamed from: c */
    protected Context f23727c;

    /* renamed from: d */
    private boolean f23728d;

    /* renamed from: e */
    private PDFView f23729e;

    /* renamed from: f */
    private float f23730f;

    /* renamed from: g */
    private Handler f23731g;

    /* renamed from: h */
    private Runnable f23732h;

    /* renamed from: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6662a implements Runnable {
        RunnableC6662a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultScrollHandle.this.mo35318f();
        }
    }

    public DefaultScrollHandle(Context context) {
        this(context, false);
    }

    /* renamed from: a */
    private void m35320a() {
        float x;
        float width;
        int width2;
        if (this.f23729e.m35486Q()) {
            x = getY();
            width = getHeight();
            width2 = this.f23729e.getHeight();
        } else {
            x = getX();
            width = getWidth();
            width2 = this.f23729e.getWidth();
        }
        this.f23725a = ((x + this.f23725a) / width2) * width;
    }

    /* renamed from: b */
    private boolean m35319b() {
        PDFView pDFView = this.f23729e;
        return (pDFView == null || pDFView.getPageCount() <= 0 || this.f23729e.m35450n()) ? false : true;
    }

    private void setPosition(float f) {
        int width;
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return;
        }
        if (this.f23729e.m35486Q()) {
            width = this.f23729e.getHeight();
        } else {
            width = this.f23729e.getWidth();
        }
        float f2 = width;
        float f3 = f - this.f23725a;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > f2 - C6668f.m35294a(this.f23727c, 40)) {
            f3 = f2 - C6668f.m35294a(this.f23727c, 40);
        }
        if (this.f23729e.m35486Q()) {
            setY(f3);
        } else {
            setX(f3);
        }
        m35320a();
        invalidate();
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    /* renamed from: f */
    public void mo35318f() {
        setVisibility(4);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    /* renamed from: g */
    public void mo35317g() {
        this.f23731g.postDelayed(this.f23732h, 1000L);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    /* renamed from: h */
    public void mo35316h() {
        this.f23729e.removeView(this);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    /* renamed from: i */
    public boolean mo35315i() {
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
            boolean r0 = r4.m35319b()
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
            r4.mo35317g()
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f23729e
            r5.m35463g0()
            return r1
        L2e:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f23729e
            r0.m35447o0()
            android.os.Handler r0 = r4.f23731g
            java.lang.Runnable r2 = r4.f23732h
            r0.removeCallbacks(r2)
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f23729e
            boolean r0 = r0.m35486Q()
            if (r0 == 0) goto L4e
            float r0 = r5.getRawY()
            float r2 = r4.getY()
            float r0 = r0 - r2
            r4.f23730f = r0
            goto L59
        L4e:
            float r0 = r5.getRawX()
            float r2 = r4.getX()
            float r0 = r0 - r2
            r4.f23730f = r0
        L59:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f23729e
            boolean r0 = r0.m35486Q()
            r2 = 0
            if (r0 == 0) goto L7d
            float r5 = r5.getRawY()
            float r0 = r4.f23730f
            float r5 = r5 - r0
            float r0 = r4.f23725a
            float r5 = r5 + r0
            r4.setPosition(r5)
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f23729e
            float r0 = r4.f23725a
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            r5.m35453l0(r0, r2)
            goto L97
        L7d:
            float r5 = r5.getRawX()
            float r0 = r4.f23730f
            float r5 = r5 - r0
            float r0 = r4.f23725a
            float r5 = r5 + r0
            r4.setPosition(r5)
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f23729e
            float r0 = r4.f23725a
            int r3 = r4.getWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            r5.m35453l0(r0, r2)
        L97:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setPageNum(int i) {
        String valueOf = String.valueOf(i);
        if (this.f23726b.getText().equals(valueOf)) {
            return;
        }
        this.f23726b.setText(valueOf);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setScroll(float f) {
        if (!mo35315i()) {
            show();
        } else {
            this.f23731g.removeCallbacks(this.f23732h);
        }
        PDFView pDFView = this.f23729e;
        if (pDFView != null) {
            setPosition((pDFView.m35486Q() ? this.f23729e.getHeight() : this.f23729e.getWidth()) * f);
        }
    }

    public void setTextColor(int i) {
        this.f23726b.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.f23726b.setTextSize(1, i);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setupLayout(PDFView pDFView) {
        int i;
        Drawable drawable;
        int i2 = 65;
        int i3 = 40;
        if (pDFView.m35486Q()) {
            if (this.f23728d) {
                i = 9;
                drawable = ContextCompat.getDrawable(this.f23727c, C6643R.C6645drawable.default_scroll_handle_left);
            } else {
                i = 11;
                drawable = ContextCompat.getDrawable(this.f23727c, C6643R.C6645drawable.default_scroll_handle_right);
            }
        } else {
            if (this.f23728d) {
                i = 10;
                drawable = ContextCompat.getDrawable(this.f23727c, C6643R.C6645drawable.default_scroll_handle_top);
            } else {
                i = 12;
                drawable = ContextCompat.getDrawable(this.f23727c, C6643R.C6645drawable.default_scroll_handle_bottom);
            }
            i2 = 40;
            i3 = 65;
        }
        setBackground(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(C6668f.m35294a(this.f23727c, i2), C6668f.m35294a(this.f23727c, i3));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.f23726b, layoutParams2);
        layoutParams.addRule(i);
        pDFView.addView(this, layoutParams);
        this.f23729e = pDFView;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void show() {
        setVisibility(0);
    }

    public DefaultScrollHandle(Context context, boolean z) {
        super(context);
        this.f23725a = 0.0f;
        this.f23731g = new Handler();
        this.f23732h = new RunnableC6662a();
        this.f23727c = context;
        this.f23728d = z;
        this.f23726b = new TextView(context);
        setVisibility(4);
        setTextColor(ViewCompat.MEASURED_STATE_MASK);
        setTextSize(16);
    }
}
