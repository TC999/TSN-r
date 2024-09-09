package com.qq.e.comm.plugin.nativeadunified;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class m implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private final ViewGroup f44985c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f44986d;

    public m(ViewGroup viewGroup) {
        this.f44985c = viewGroup;
    }

    private boolean a(float f4, float f5, int i4, int i5) {
        return f4 < 0.0f || f4 > ((float) i4) || f5 < 0.0f || f5 > ((float) i5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int[] iArr2 = new int[2];
        this.f44985c.getLocationInWindow(iArr2);
        int i6 = iArr2[0];
        int i7 = iArr2[1];
        int round = Math.round(i4 - i6);
        int round2 = Math.round(i5 - i7);
        d1.a("NativeUnifiedToucheListener", "onTouch event = %d, clickViewX=%d, clickViewY=%d, viewGroupX=%d,viewGroupY=%d, relativeContainerX=%d, relativeContainerY=%d", Integer.valueOf(motionEvent.getActionMasked()), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(round), Integer.valueOf(round2));
        com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f44985c);
        if (d4 != null) {
            d4.a(motionEvent, false, round, round2);
        } else {
            d1.b("NativeUnifiedToucheListener", "view hasn't attache to collector");
        }
        int width = view.getWidth();
        int height = view.getHeight();
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        d1.a("NativeUnifiedToucheListener", "onTouch width=%d, height=%d, eventX=%.2f, eventY=%.2f, eventRawX=%.2f, eventRawY=%.2f", Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(x3), Float.valueOf(y3), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f44986d = true;
        } else if (actionMasked == 1) {
            if (a(x3, y3, width, height)) {
                this.f44986d = false;
            }
            if (this.f44986d) {
                view.performClick();
            }
        } else if (actionMasked != 2) {
            this.f44986d = false;
        } else if (a(x3, y3, width, height)) {
            this.f44986d = false;
        }
        return true;
    }
}
