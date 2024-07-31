package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.kwad.components.core.p330s.C8939d;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.p430d.p431a.C10751a;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {

    /* renamed from: PI */
    private int f28638PI;

    /* renamed from: PJ */
    private int f28639PJ;

    /* renamed from: PK */
    private final int[] f28640PK;

    /* renamed from: PL */
    private final int[] f28641PL;

    /* renamed from: PM */
    private int f28642PM;

    /* renamed from: PN */
    private boolean f28643PN;

    /* renamed from: PO */
    private int f28644PO;

    /* renamed from: PP */
    private int f28645PP;

    /* renamed from: PQ */
    private NestedScrollingChildHelper f28646PQ;

    /* renamed from: PR */
    private VelocityTracker f28647PR;

    /* renamed from: PS */
    private int f28648PS;

    public NestedScrollWebView(Context context) {
        super(context);
        this.f28640PK = new int[2];
        this.f28641PL = new int[2];
        m29755pS();
    }

    /* renamed from: pS */
    private void m29755pS() {
        this.f28648PS = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f28646PQ = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.f28645PP = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f28644PO = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f28646PQ.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f28646PQ.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f28646PQ.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f28646PQ.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f28646PQ.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f28646PQ.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int screenHeight;
        if (this.f28648PS != 0) {
            int statusBarHeight = C8939d.m29560rc() ? C10751a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = C10751a.m24911e((Activity) getContext());
            } else {
                screenHeight = C10751a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.f28648PS, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        int[] iArr;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            this.f28642PM = 0;
        }
        if (this.f28647PR == null) {
            this.f28647PR = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.f28642PM);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.f28638PI - y;
                    if (dispatchNestedPreScroll(0, i, this.f28641PL, this.f28640PK)) {
                        i -= this.f28641PL[1];
                        obtain.offsetLocation(0.0f, this.f28640PK[1]);
                        this.f28642PM += this.f28640PK[1];
                    }
                    int scrollY = getScrollY();
                    this.f28638PI = y - this.f28640PK[1];
                    int max = Math.max(0, scrollY + i);
                    int i2 = i - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i2, 0, i2, this.f28640PK)) {
                        this.f28638PI = this.f28638PI - this.f28640PK[1];
                        obtain.offsetLocation(0.0f, iArr[1]);
                        this.f28642PM += this.f28640PK[1];
                    }
                    if (Math.abs(this.f28641PL[1]) < 5 && Math.abs(this.f28640PK[1]) < 5) {
                        if (this.f28643PN) {
                            this.f28643PN = false;
                            onTouchEvent = false;
                        } else {
                            onTouchEvent = super.onTouchEvent(obtain);
                        }
                        obtain.recycle();
                    } else {
                        if (!this.f28643PN) {
                            this.f28643PN = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        stopNestedScroll();
                        onTouchEvent = super.onTouchEvent(motionEvent);
                    }
                    onTouchEvent = false;
                }
            }
            this.f28647PR.addMovement(motionEvent);
            this.f28647PR.computeCurrentVelocity(1000, this.f28645PP);
            float f = -VelocityTrackerCompat.getYVelocity(this.f28647PR, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f) > this.f28644PO && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.f28638PI) < 10.0f) {
                Math.abs(motionEvent.getX() - this.f28639PJ);
            }
            onTouchEvent = onTouchEvent2;
            z = true;
        } else {
            this.f28638PI = y;
            this.f28639PJ = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr2 = this.f28641PL;
            iArr2[0] = 0;
            iArr2[1] = 0;
            int[] iArr3 = this.f28640PK;
            iArr3[0] = 0;
            iArr3[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.f28643PN = false;
        }
        if (!z) {
            this.f28647PR.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f28646PQ.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.f28646PQ.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f28646PQ.stopNestedScroll();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28640PK = new int[2];
        this.f28641PL = new int[2];
        m29755pS();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28640PK = new int[2];
        this.f28641PL = new int[2];
        m29755pS();
    }
}
