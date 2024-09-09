package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private GestureDetector GU;
    private MotionEvent aSS;
    private c fs;
    private View mView;

    public f(Context context, @NonNull View view, c cVar) {
        this.mView = view;
        view.setOnTouchListener(this);
        this.GU = new GestureDetector(context, this);
        this.fs = cVar;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z3 = false;
        if (action == 0) {
            this.aSS = MotionEvent.obtain(motionEvent);
        } else if (action == 1) {
            MotionEvent motionEvent2 = this.aSS;
            if (motionEvent2 != null && a(motionEvent2, motionEvent)) {
                c cVar = this.fs;
                if (cVar != null) {
                    cVar.b(view);
                }
                z3 = true;
            }
            this.aSS = null;
        }
        return z3;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        c cVar = this.fs;
        if (cVar != null) {
            cVar.a(this.mView);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean onTouchEvent = this.GU.onTouchEvent(motionEvent);
        motionEvent.getAction();
        if (onTouchEvent) {
            return true;
        }
        return a(view, motionEvent);
    }

    public f(View view, c cVar) {
        if (view == null) {
            return;
        }
        this.mView = view;
        view.setOnTouchListener(this);
        this.GU = new GestureDetector(view.getContext(), this);
        this.fs = cVar;
    }

    private static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f ? 1 : (Math.abs(motionEvent.getX() - motionEvent2.getX()) == 20.0f ? 0 : -1)) > 0) || ((Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f ? 1 : (Math.abs(motionEvent.getY() - motionEvent2.getY()) == 20.0f ? 0 : -1)) > 0);
    }
}
