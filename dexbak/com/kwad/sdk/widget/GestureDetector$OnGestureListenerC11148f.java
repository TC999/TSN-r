package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* renamed from: com.kwad.sdk.widget.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class GestureDetector$OnGestureListenerC11148f implements GestureDetector.OnGestureListener, View.OnTouchListener {

    /* renamed from: GU */
    private GestureDetector f29691GU;
    private MotionEvent aSS;

    /* renamed from: fs */
    private InterfaceC11145c f29692fs;
    private View mView;

    public GestureDetector$OnGestureListenerC11148f(Context context, @NonNull View view, InterfaceC11145c interfaceC11145c) {
        this.mView = view;
        view.setOnTouchListener(this);
        this.f29691GU = new GestureDetector(context, this);
        this.f29692fs = interfaceC11145c;
    }

    /* renamed from: a */
    private boolean m23543a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.aSS = MotionEvent.obtain(motionEvent);
        } else if (action == 1) {
            MotionEvent motionEvent2 = this.aSS;
            if (motionEvent2 != null && m23544a(motionEvent2, motionEvent)) {
                InterfaceC11145c interfaceC11145c = this.f29692fs;
                if (interfaceC11145c != null) {
                    interfaceC11145c.mo23545b(view);
                }
                z = true;
            }
            this.aSS = null;
        }
        return z;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        InterfaceC11145c interfaceC11145c = this.f29692fs;
        if (interfaceC11145c != null) {
            interfaceC11145c.mo23546a(this.mView);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean onTouchEvent = this.f29691GU.onTouchEvent(motionEvent);
        motionEvent.getAction();
        if (onTouchEvent) {
            return true;
        }
        return m23543a(view, motionEvent);
    }

    public GestureDetector$OnGestureListenerC11148f(View view, InterfaceC11145c interfaceC11145c) {
        if (view == null) {
            return;
        }
        this.mView = view;
        view.setOnTouchListener(this);
        this.f29691GU = new GestureDetector(view.getContext(), this);
        this.f29692fs = interfaceC11145c;
    }

    /* renamed from: a */
    private static boolean m23544a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f ? 1 : (Math.abs(motionEvent.getX() - motionEvent2.getX()) == 20.0f ? 0 : -1)) > 0) || ((Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f ? 1 : (Math.abs(motionEvent.getY() - motionEvent2.getY()) == 20.0f ? 0 : -1)) > 0);
    }
}
