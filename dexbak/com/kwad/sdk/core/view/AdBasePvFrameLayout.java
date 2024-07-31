package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11066bp;
import com.kwad.sdk.utils.C11102k;
import com.kwad.sdk.widget.InterfaceC11154j;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long aCI;
    private float aCJ;
    private boolean aCK;
    private boolean aCL;
    private ViewTreeObserver.OnScrollChangedListener aCM;
    private ViewTreeObserver aCN;
    private C11066bp aCO;

    /* renamed from: cD */
    private InterfaceC11154j f29614cD;

    /* renamed from: mf */
    private int f29615mf;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.aCI = 500L;
        this.aCJ = 0.1f;
        this.aCL = true;
        init();
    }

    /* renamed from: GH */
    private void m25391GH() {
        if (m25389GJ()) {
            m25390GI();
        } else {
            m25388GK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: GJ */
    public boolean m25389GJ() {
        if (!this.aCO.m23854Nr() || Math.abs(this.aCO.aQY.height() - getHeight()) > getHeight() * (1.0f - this.aCJ) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.aCO.aQY;
        return rect.bottom > 0 && rect.top < this.f29615mf;
    }

    /* renamed from: GK */
    private void m25388GK() {
        if (this.aCM == null) {
            this.aCM = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.m25389GJ()) {
                        AdBasePvFrameLayout.this.m25390GI();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aCN = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aCM);
            }
        }
    }

    /* renamed from: GL */
    private void m25387GL() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.aCM != null && (viewTreeObserver = this.aCN) != null && viewTreeObserver.isAlive()) {
                this.aCN.removeOnScrollChangedListener(this.aCM);
            }
            this.aCM = null;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    private void init() {
        this.aCO = new C11066bp(this);
        this.f29615mf = C11102k.getScreenHeight(getContext());
        this.aCL = true;
    }

    /* renamed from: oD */
    private void m25385oD() {
        if (this.aCL) {
            m25391GH();
        }
    }

    /* renamed from: GI */
    protected final void m25390GI() {
        m25387GL();
        InterfaceC11154j interfaceC11154j = this.f29614cD;
        if (interfaceC11154j != null) {
            interfaceC11154j.mo23526ao();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m25388GK();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m25387GL();
        this.aCK = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.aCK || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.aCK = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            m25385oD();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.aCJ = f;
    }

    public void setVisibleListener(InterfaceC11154j interfaceC11154j) {
        this.f29614cD = interfaceC11154j;
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCI = 500L;
        this.aCJ = 0.1f;
        this.aCL = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCI = 500L;
        this.aCJ = 0.1f;
        this.aCL = true;
        init();
    }
}
