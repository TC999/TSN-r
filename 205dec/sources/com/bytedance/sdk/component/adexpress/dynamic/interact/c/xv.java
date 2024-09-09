package com.bytedance.sdk.component.adexpress.dynamic.interact.c;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private float f29269c;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private gd f29270f;
    private boolean gd;

    /* renamed from: r  reason: collision with root package name */
    private int f29271r;
    private float sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29272w;
    private float xv;

    public xv(gd gdVar) {
        this(gdVar, 5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gd gdVar;
        gd gdVar2;
        gd gdVar3;
        if (this.gd) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f29269c = motionEvent.getX();
            this.f29272w = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.sr = motionEvent.getX();
                this.xv = motionEvent.getY();
                if (Math.abs(this.sr - this.f29269c) > 10.0f) {
                    this.ux = true;
                }
                if (Math.abs(this.sr - this.f29269c) > 8.0f || Math.abs(this.xv - this.f29272w) > 8.0f) {
                    this.ev = false;
                }
                int w3 = com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), Math.abs(this.sr - this.f29269c));
                if (this.sr > this.f29269c && w3 > this.f29271r && (gdVar3 = this.f29270f) != null) {
                    gdVar3.c();
                    this.gd = true;
                }
            }
        } else if (!this.ux && !this.ev) {
            return false;
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int w4 = com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), Math.abs(this.sr - this.f29269c));
            if (this.sr > this.f29269c && w4 > this.f29271r && (gdVar2 = this.f29270f) != null) {
                gdVar2.c();
                this.gd = true;
            }
            float abs = Math.abs(x3 - this.f29269c);
            float abs2 = Math.abs(y3 - this.f29272w);
            if ((abs < 8.0f || abs2 < 8.0f) && (gdVar = this.f29270f) != null) {
                gdVar.w();
                this.gd = true;
            }
        }
        return true;
    }

    public xv(gd gdVar, int i4) {
        this.f29271r = 5;
        this.ev = true;
        this.f29270f = gdVar;
        if (i4 > 0) {
            this.f29271r = i4;
        }
    }
}
