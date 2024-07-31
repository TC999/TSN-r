package com.p518qq.p519e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.p518qq.p519e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a */
    private ViewStatusListener f32843a;

    /* renamed from: b */
    private ViewStatus f32844b;

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C118091 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32845a;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f32845a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32845a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$ViewStatus */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f32844b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32844b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32844b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f32843a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.m20308d("NativeAdContainer onAttachedToWindow");
        this.f32844b = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f32843a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.m20308d("NativeAdContainer onDetachedFromWindow");
        this.f32844b = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f32843a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        GDTLogger.m20308d("onWindowFocusChanged: hasWindowFocus: " + z);
        ViewStatusListener viewStatusListener = this.f32843a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        GDTLogger.m20308d("onWindowVisibilityChanged: visibility: " + i);
        ViewStatusListener viewStatusListener = this.f32843a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f32843a = viewStatusListener;
        if (viewStatusListener != null) {
            int ordinal = this.f32844b.ordinal();
            if (ordinal == 1) {
                this.f32843a.onAttachToWindow();
            } else if (ordinal != 2) {
            } else {
                this.f32843a.onDetachFromWindow();
            }
        }
    }
}
