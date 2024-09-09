package com.bytedance.sdk.component.adexpress.dynamic.interact.c;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements View.OnTouchListener {
    private static int xv = 10;

    /* renamed from: c  reason: collision with root package name */
    private float f29249c;
    private boolean sr;
    private gd ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29250w;

    public f(gd gdVar) {
        this.ux = gdVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f29249c = motionEvent.getX();
            this.f29250w = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                if (Math.abs(x3 - this.f29249c) >= xv || Math.abs(y3 - this.f29250w) >= xv) {
                    this.sr = true;
                }
            } else if (action == 3) {
                this.sr = false;
            }
        } else if (this.sr) {
            this.sr = false;
            return false;
        } else {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            if (Math.abs(x4 - this.f29249c) < xv && Math.abs(y4 - this.f29250w) < xv) {
                gd gdVar = this.ux;
                if (gdVar != null) {
                    gdVar.c();
                }
            } else {
                this.sr = false;
            }
        }
        return true;
    }
}
