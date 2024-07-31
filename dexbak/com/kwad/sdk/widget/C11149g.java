package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11066bp;
import com.kwad.sdk.utils.C11102k;

/* renamed from: com.kwad.sdk.widget.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11149g {
    private final C11066bp aCO;
    private final InterfaceC11153i aST;
    private boolean aSV;
    private boolean aSW;
    private ViewTreeObserver.OnScrollChangedListener aSY;
    private final View mView;

    /* renamed from: mf */
    private final int f29693mf;
    private float aSU = 0.1f;
    private boolean aSX = true;

    public C11149g(View view, InterfaceC11153i interfaceC11153i) {
        this.mView = view;
        this.aST = interfaceC11153i;
        this.aCO = new C11066bp(view);
        this.f29693mf = C11102k.getScreenHeight(view.getContext());
    }

    /* renamed from: GK */
    private void m23542GK() {
        if (this.aSY == null) {
            this.aSY = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (C11149g.this.m23538NU()) {
                        C11149g.this.m23536ao();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aSY);
            }
        }
    }

    /* renamed from: GL */
    private void m23541GL() {
        if (this.aSY == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.aSY);
            }
            this.aSY = null;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: NT */
    private void m23539NT() {
        if (m23538NU()) {
            m23536ao();
            return;
        }
        m23541GL();
        m23542GK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NU */
    public boolean m23538NU() {
        if (this.aCO.m23854Nr() && Math.abs(this.aCO.aQY.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.aSU) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.aCO.aQY;
            if (rect.bottom > 0 && rect.top < this.f29693mf) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ao */
    public void m23536ao() {
        try {
            m23541GL();
            InterfaceC11153i interfaceC11153i = this.aST;
            if (interfaceC11153i != null) {
                interfaceC11153i.mo23527A(this.mView);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: oD */
    private void m23532oD() {
        if (this.aSX) {
            m23539NT();
        }
    }

    /* renamed from: NS */
    public final void m23540NS() {
        if (this.aSW) {
            m23532oD();
        }
    }

    /* renamed from: ce */
    public final void m23533ce(boolean z) {
        this.aSX = z;
    }

    public final float getVisiblePercent() {
        return this.aSU;
    }

    public final void onAttachedToWindow() {
        m23542GK();
    }

    public final void onDetachedFromWindow() {
        m23541GL();
        this.aSV = false;
    }

    public final void setVisiblePercent(float f) {
        this.aSU = f;
    }

    /* renamed from: b */
    public final void m23535b(int i, int i2, int i3, int i4) {
        this.aSW = false;
        if (this.aSV || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.aSW = true;
        this.aSV = true;
    }
}
