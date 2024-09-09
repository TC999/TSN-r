package com.bytedance.sdk.component.adexpress.dynamic.interact.c;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private float f29264c;
    private gd sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29265w;
    private boolean xv;

    public ux(gd gdVar, int i4) {
        this.sr = gdVar;
        this.ux = i4;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gd gdVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f29264c = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y3 = motionEvent.getY();
                this.f29265w = y3;
                if (Math.abs(y3 - this.f29264c) > 10.0f) {
                    this.xv = true;
                }
            }
        } else if (!this.xv) {
            return false;
        } else {
            int w3 = com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), Math.abs(this.f29265w - this.f29264c));
            if (this.f29265w - this.f29264c < 0.0f && w3 > this.ux && (gdVar = this.sr) != null) {
                gdVar.c();
            }
        }
        return true;
    }
}
