package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewStatusListener f41558a;

    /* renamed from: b  reason: collision with root package name */
    private ViewStatus f41559b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41560a;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f41560a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41560a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f41559b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41559b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f41559b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f41558a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.f41559b = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f41558a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.f41559b = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f41558a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z3);
        ViewStatusListener viewStatusListener = this.f41558a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z3);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i4);
        ViewStatusListener viewStatusListener = this.f41558a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i4);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f41558a = viewStatusListener;
        if (viewStatusListener != null) {
            int ordinal = this.f41559b.ordinal();
            if (ordinal == 1) {
                this.f41558a.onAttachToWindow();
            } else if (ordinal != 2) {
            } else {
                this.f41558a.onDetachFromWindow();
            }
        }
    }
}
