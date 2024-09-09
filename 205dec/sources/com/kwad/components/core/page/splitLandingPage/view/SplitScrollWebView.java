package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.s.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int PS;
    private boolean Qp;
    private a Qq;
    private float Qr;
    private boolean Qs;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void d(float f4);

        boolean pY();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Qp = false;
        pS();
    }

    private void pS() {
        this.PS = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int screenHeight;
        if (this.PS != 0) {
            int statusBarHeight = d.rc() ? com.kwad.sdk.d.a.a.getStatusBarHeight(getContext()) : 0;
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
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (this.Qp) {
            return super.onTouchEvent(obtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y3 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float f4 = this.Qr;
                    float f5 = f4 - y3;
                    a aVar = this.Qq;
                    if (aVar != null && y3 <= f4) {
                        this.Qs = true;
                        aVar.d(f5);
                    }
                    return super.onTouchEvent(obtain);
                } else if (actionMasked != 3) {
                    return false;
                }
            }
            a aVar2 = this.Qq;
            if (aVar2 != null) {
                if ((this.Qr - y3 >= 0.0f || this.Qs) && aVar2.pY()) {
                    this.Qp = true;
                    return false;
                }
                return false;
            }
            return false;
        }
        this.Qr = y3;
        this.Qs = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setDisableAnimation(boolean z3) {
        this.Qp = z3;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Qq = aVar;
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Qp = false;
        pS();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.Qp = false;
        pS();
    }
}
