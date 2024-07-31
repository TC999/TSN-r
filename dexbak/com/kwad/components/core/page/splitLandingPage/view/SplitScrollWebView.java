package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.p330s.C8939d;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.p430d.p431a.C10751a;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SplitScrollWebView extends KsAdWebView {

    /* renamed from: PS */
    private int f28679PS;

    /* renamed from: Qp */
    private boolean f28680Qp;

    /* renamed from: Qq */
    private InterfaceC8861a f28681Qq;

    /* renamed from: Qr */
    private float f28682Qr;

    /* renamed from: Qs */
    private boolean f28683Qs;

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8861a {
        /* renamed from: d */
        void mo29723d(float f);

        /* renamed from: pY */
        boolean mo29722pY();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.f28680Qp = false;
        m29724pS();
    }

    /* renamed from: pS */
    private void m29724pS() {
        this.f28679PS = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int screenHeight;
        if (this.f28679PS != 0) {
            int statusBarHeight = C8939d.m29560rc() ? C10751a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = C10751a.m24911e((Activity) getContext());
            } else {
                screenHeight = C10751a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.f28679PS, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (this.f28680Qp) {
            return super.onTouchEvent(obtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float f = this.f28682Qr;
                    float f2 = f - y;
                    InterfaceC8861a interfaceC8861a = this.f28681Qq;
                    if (interfaceC8861a != null && y <= f) {
                        this.f28683Qs = true;
                        interfaceC8861a.mo29723d(f2);
                    }
                    return super.onTouchEvent(obtain);
                } else if (actionMasked != 3) {
                    return false;
                }
            }
            InterfaceC8861a interfaceC8861a2 = this.f28681Qq;
            if (interfaceC8861a2 != null) {
                if ((this.f28682Qr - y >= 0.0f || this.f28683Qs) && interfaceC8861a2.mo29722pY()) {
                    this.f28680Qp = true;
                    return false;
                }
                return false;
            }
            return false;
        }
        this.f28682Qr = y;
        this.f28683Qs = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setDisableAnimation(boolean z) {
        this.f28680Qp = z;
    }

    public void setSplitScrollWebViewListener(InterfaceC8861a interfaceC8861a) {
        this.f28681Qq = interfaceC8861a;
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28680Qp = false;
        m29724pS();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28680Qp = false;
        m29724pS();
    }
}
