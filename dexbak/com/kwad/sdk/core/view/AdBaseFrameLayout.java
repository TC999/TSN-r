package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.C10974c;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.widget.InterfaceC11147e;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdBaseFrameLayout extends FrameLayout implements InterfaceC10594d, InterfaceC11147e {
    private static final C11008ac.C11009a aCH = new C11008ac.C11009a();
    private List<View.OnTouchListener> aCF;
    private C10593c aCG;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.aCF = new ArrayList();
        this.aCG = new C10593c();
    }

    @UiThread
    /* renamed from: a */
    public final void m25392a(View.OnTouchListener onTouchListener) {
        if (this.aCF.contains(onTouchListener)) {
            return;
        }
        this.aCF.add(onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
            C10974c.gatherException(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.aCF.isEmpty()) {
            for (View.OnTouchListener onTouchListener : this.aCF) {
                onTouchListener.onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            C11008ac.C11009a c11009a = aCH;
            c11009a.m24146z(getWidth(), getHeight());
            c11009a.m24148f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            aCH.m24147g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11147e
    @MainThread
    public C11008ac.C11009a getTouchCoords() {
        return aCH;
    }

    @Override // com.kwad.sdk.core.view.InterfaceC10594d
    @NonNull
    public C10593c getWindowFocusChangeHelper() {
        return this.aCG;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        C10331c.m26254d("KsAdBaseFrameLayout", this + ": onWindowFocusChanged hasWindowFocus: " + z);
        this.aCG.m25357j(this, z);
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCF = new ArrayList();
        this.aCG = new C10593c();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCF = new ArrayList();
        this.aCG = new C10593c();
    }
}
