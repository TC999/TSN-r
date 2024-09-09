package com.bytedance.sdk.component.adexpress.dynamic.interact.c;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.gd;
import com.bytedance.sdk.component.utils.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private final gd f29245c;

    /* renamed from: f  reason: collision with root package name */
    private float f29246f;

    /* renamed from: r  reason: collision with root package name */
    private float f29247r;
    private float sr;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private final boolean f29248w;
    private final int xv = 10;

    public ev(gd gdVar, boolean z3) {
        this.f29245c = gdVar;
        this.f29248w = z3;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gd gdVar;
        gd gdVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.sr = motionEvent.getX();
            this.ux = motionEvent.getY();
            a.c("ValidateSlideUpTouch", "mStartX: ", Float.valueOf(this.sr), ", mStartY: " + this.ux);
        } else if (action == 1) {
            this.f29246f = motionEvent.getX();
            this.f29247r = motionEvent.getY();
            a.c("ValidateSlideUpTouch", "mEndX: ", Float.valueOf(this.f29246f), ", mEndY: " + this.f29247r);
            if (!this.f29248w && (gdVar2 = this.f29245c) != null) {
                gdVar2.c();
                a.w("ValidateSlideUpTouch", "mInteractValidate is false, trigger mInteractListener.onInteractTouch()");
            } else {
                float f4 = this.f29246f - this.sr;
                float f5 = this.f29247r - this.ux;
                float sqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5));
                a.c("ValidateSlideUpTouch", "slideDistancePx: ", Float.valueOf(sqrt));
                float w3 = com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), Math.abs(sqrt));
                a.c("ValidateSlideUpTouch", "slideDistanceDp:", Float.valueOf(w3), " and ", "mSlideThreshold:", 10);
                if (w3 > 10.0f && (gdVar = this.f29245c) != null) {
                    gdVar.c();
                    a.w("ValidateSlideUpTouch", "trigger mInteractListener.onInteractTouch()");
                }
            }
        }
        return true;
    }
}
