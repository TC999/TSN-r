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
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int PI;
    private int PJ;
    private final int[] PK;
    private final int[] PL;
    private int PM;
    private boolean PN;
    private int PO;
    private int PP;
    private NestedScrollingChildHelper PQ;
    private VelocityTracker PR;
    private int PS;

    public NestedScrollWebView(Context context) {
        super(context);
        this.PK = new int[2];
        this.PL = new int[2];
        pS();
    }

    private void pS() {
        this.PS = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.PQ = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.PP = viewConfiguration.getScaledMaximumFlingVelocity();
        this.PO = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f4, float f5, boolean z3) {
        return this.PQ.dispatchNestedFling(f4, f5, z3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return this.PQ.dispatchNestedPreFling(f4, f5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return this.PQ.dispatchNestedPreScroll(i4, i5, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return this.PQ.dispatchNestedScroll(i4, i5, i6, i7, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.PQ.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.PQ.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int screenHeight;
        if (this.PS != 0) {
            int statusBarHeight = com.kwad.components.core.s.d.rc() ? com.kwad.sdk.d.a.a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.d.a.a.e((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.d.a.a.getScreenHeight(getContext());
            }
            i5 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.PS, 1073741824);
        }
        super.onMeasure(i4, i5);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
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
        boolean z3 = false;
        if (actionMasked == 0) {
            this.PM = 0;
        }
        if (this.PR == null) {
            this.PR = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y3 = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.PM);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i4 = this.PI - y3;
                    if (dispatchNestedPreScroll(0, i4, this.PL, this.PK)) {
                        i4 -= this.PL[1];
                        obtain.offsetLocation(0.0f, this.PK[1]);
                        this.PM += this.PK[1];
                    }
                    int scrollY = getScrollY();
                    this.PI = y3 - this.PK[1];
                    int max = Math.max(0, scrollY + i4);
                    int i5 = i4 - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i5, 0, i5, this.PK)) {
                        this.PI = this.PI - this.PK[1];
                        obtain.offsetLocation(0.0f, iArr[1]);
                        this.PM += this.PK[1];
                    }
                    if (Math.abs(this.PL[1]) < 5 && Math.abs(this.PK[1]) < 5) {
                        if (this.PN) {
                            this.PN = false;
                            onTouchEvent = false;
                        } else {
                            onTouchEvent = super.onTouchEvent(obtain);
                        }
                        obtain.recycle();
                    } else {
                        if (!this.PN) {
                            this.PN = true;
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
            this.PR.addMovement(motionEvent);
            this.PR.computeCurrentVelocity(1000, this.PP);
            float f4 = -VelocityTrackerCompat.getYVelocity(this.PR, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f4) > this.PO && !dispatchNestedPreFling(0.0f, f4) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f4, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.PI) < 10.0f) {
                Math.abs(motionEvent.getX() - this.PJ);
            }
            onTouchEvent = onTouchEvent2;
            z3 = true;
        } else {
            this.PI = y3;
            this.PJ = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr2 = this.PL;
            iArr2[0] = 0;
            iArr2[1] = 0;
            int[] iArr3 = this.PK;
            iArr3[0] = 0;
            iArr3[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.PN = false;
        }
        if (!z3) {
            this.PR.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z3) {
        this.PQ.setNestedScrollingEnabled(z3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i4) {
        return this.PQ.startNestedScroll(i4);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.PQ.stopNestedScroll();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PK = new int[2];
        this.PL = new int[2];
        pS();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.PK = new int[2];
        this.PL = new int[2];
        pS();
    }
}
