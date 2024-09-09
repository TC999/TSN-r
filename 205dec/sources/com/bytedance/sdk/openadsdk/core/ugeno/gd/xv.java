package com.bytedance.sdk.openadsdk.core.ugeno.gd;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private float f34981c;

    /* renamed from: f  reason: collision with root package name */
    private Context f34982f;
    private c sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private float f34983w;
    private boolean xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void w();
    }

    public xv(Context context, c cVar, int i4) {
        this.f34982f = context;
        this.ux = i4;
        this.sr = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f34981c = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y3 = motionEvent.getY();
                this.f34983w = y3;
                if (Math.abs(y3 - this.f34981c) > 10.0f) {
                    this.xv = true;
                }
            }
        } else if (!this.xv) {
            c cVar = this.sr;
            if (cVar != null) {
                cVar.w();
            }
            return true;
        } else {
            int sr = xk.sr(this.f34982f, Math.abs(this.f34983w - this.f34981c));
            if (this.f34983w - this.f34981c < 0.0f && sr > this.ux) {
                c cVar2 = this.sr;
                if (cVar2 != null) {
                    cVar2.c();
                }
            } else {
                c cVar3 = this.sr;
                if (cVar3 != null) {
                    cVar3.w();
                }
            }
        }
        return true;
    }
}
