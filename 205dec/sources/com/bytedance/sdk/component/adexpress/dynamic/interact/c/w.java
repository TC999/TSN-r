package com.bytedance.sdk.component.adexpress.dynamic.interact.c;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.dynamic.interact.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private float f29266c;

    /* renamed from: f  reason: collision with root package name */
    private gd f29267f;
    private boolean sr;
    private InteractViewContainer ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29268w;
    private long xv;

    public w(InteractViewContainer interactViewContainer, gd gdVar) {
        this.ux = interactViewContainer;
        this.f29267f = gdVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.xv = System.currentTimeMillis();
            this.f29266c = motionEvent.getX();
            this.f29268w = motionEvent.getY();
            this.ux.ux();
        } else if (action != 1) {
            if (action == 2) {
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                if (Math.abs(x3 - this.f29266c) >= com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), 10.0f) || Math.abs(y3 - this.f29268w) >= com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), 10.0f)) {
                    this.sr = true;
                    this.ux.f();
                }
            }
        } else if (this.sr) {
            return false;
        } else {
            if (System.currentTimeMillis() - this.xv >= 1500) {
                gd gdVar = this.f29267f;
                if (gdVar != null) {
                    gdVar.c();
                }
            } else {
                this.ux.f();
            }
        }
        return true;
    }
}
