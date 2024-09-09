package com.bytedance.sdk.component.adexpress.dynamic.interact.c;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private float f29258c;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private float f29259f;
    private gd gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f29260k;

    /* renamed from: p  reason: collision with root package name */
    private int f29261p;

    /* renamed from: r  reason: collision with root package name */
    private float f29262r;
    private float sr;
    private boolean ux = true;

    /* renamed from: w  reason: collision with root package name */
    private float f29263w;
    private float xv;

    public sr(gd gdVar, int i4, boolean z3) {
        this.gd = gdVar;
        this.f29261p = i4;
        this.f29260k = z3;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gd gdVar;
        gd gdVar2;
        gd gdVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f29258c = motionEvent.getX();
            this.f29263w = motionEvent.getY();
            this.f29259f = motionEvent.getY();
            this.ux = true;
        } else if (action != 1) {
            if (action == 2) {
                float y3 = motionEvent.getY();
                this.f29262r = y3;
                if (Math.abs(y3 - this.f29259f) > 10.0f) {
                    this.ev = true;
                }
                this.sr = motionEvent.getX();
                this.xv = motionEvent.getY();
                if (Math.abs(this.sr - this.f29258c) > 8.0f || Math.abs(this.xv - this.f29263w) > 8.0f) {
                    this.ux = false;
                }
            }
        } else if (!this.ev && !this.ux) {
            return false;
        } else {
            if (!this.f29260k && (gdVar3 = this.gd) != null) {
                gdVar3.c();
            } else {
                int w3 = com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), Math.abs(this.f29262r - this.f29259f));
                if (this.f29262r - this.f29259f < 0.0f && w3 > this.f29261p && (gdVar2 = this.gd) != null) {
                    gdVar2.c();
                } else if (this.ux && (gdVar = this.gd) != null) {
                    gdVar.c();
                }
            }
        }
        return true;
    }
}
