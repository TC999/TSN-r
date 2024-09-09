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
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdBaseFrameLayout extends FrameLayout implements d, e {
    private static final ac.a aCH = new ac.a();
    private List<View.OnTouchListener> aCF;
    private c aCG;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.aCF = new ArrayList();
        this.aCG = new c();
    }

    @UiThread
    public final void a(View.OnTouchListener onTouchListener) {
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
            com.kwad.sdk.core.e.c.printStackTrace(th);
            com.kwad.sdk.service.c.gatherException(th);
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
            ac.a aVar = aCH;
            aVar.z(getWidth(), getHeight());
            aVar.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            aCH.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public ac.a getTouchCoords() {
        return aCH;
    }

    @Override // com.kwad.sdk.core.view.d
    @NonNull
    public c getWindowFocusChangeHelper() {
        return this.aCG;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        com.kwad.sdk.core.e.c.d("KsAdBaseFrameLayout", this + ": onWindowFocusChanged hasWindowFocus: " + z3);
        this.aCG.j(this, z3);
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCF = new ArrayList();
        this.aCG = new c();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.aCF = new ArrayList();
        this.aCG = new c();
    }
}
