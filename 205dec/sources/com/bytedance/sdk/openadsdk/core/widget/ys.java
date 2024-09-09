package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys {

    /* renamed from: c  reason: collision with root package name */
    private final c f35527c;

    /* renamed from: f  reason: collision with root package name */
    private int f35528f;

    /* renamed from: k  reason: collision with root package name */
    private boolean f35529k;

    /* renamed from: r  reason: collision with root package name */
    private int f35531r;
    private float sr;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f35532w = false;
    private boolean xv = false;
    private boolean ev = true;
    private boolean gd = false;

    /* renamed from: p  reason: collision with root package name */
    private final View.OnTouchListener f35530p = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ys.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (ys.this.f35527c.ys()) {
                return ys.this.f35532w || !ys.this.xv;
            }
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                ys ysVar = ys.this;
                ysVar.f35529k = ysVar.c(motionEvent);
                ys.this.sr = x3;
                ys.this.ux = y3;
                ys.this.f35528f = (int) x3;
                ys.this.f35531r = (int) y3;
                ys.this.ev = true;
                if (ys.this.f35527c != null && ys.this.xv && !ys.this.f35532w) {
                    ys.this.f35527c.c(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x3 - ys.this.f35528f) > 20.0f || Math.abs(y3 - ys.this.f35531r) > 20.0f) {
                    ys.this.ev = false;
                }
                if (!ys.this.f35532w) {
                    ys.this.ev = true;
                }
                ys.this.gd = false;
                ys.this.sr = 0.0f;
                ys.this.ux = 0.0f;
                ys.this.f35528f = 0;
                if (ys.this.f35527c != null) {
                    ys.this.f35527c.c(view, ys.this.ev);
                }
                ys.this.f35529k = false;
            } else if (action != 2) {
                if (action == 3) {
                    ys.this.f35529k = false;
                }
            } else if (ys.this.f35532w && !ys.this.f35529k) {
                float abs = Math.abs(x3 - ys.this.sr);
                float abs2 = Math.abs(y3 - ys.this.ux);
                if (!ys.this.gd) {
                    if (abs <= 20.0f && abs2 <= 20.0f) {
                        return true;
                    }
                    ys.this.gd = true;
                }
                if (ys.this.f35527c != null) {
                    ys.this.f35527c.t();
                }
                ys.this.sr = x3;
                ys.this.ux = y3;
            }
            return ys.this.f35532w || !ys.this.xv;
        }
    };

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(View view, boolean z3);

        void t();

        boolean ys();
    }

    public ys(c cVar) {
        this.f35527c = cVar;
    }

    public void c(View view) {
        if (view != null) {
            view.setOnTouchListener(this.f35530p);
        }
    }

    public void c(boolean z3) {
        this.xv = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            int sr = xk.sr(StubApp.getOrigApplicationContext(ls.getContext().getApplicationContext()));
            int ux = xk.ux(StubApp.getOrigApplicationContext(ls.getContext().getApplicationContext()));
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f4 = sr;
            if (rawX > f4 * 0.01f && rawX < f4 * 0.99f) {
                float f5 = ux;
                if (rawY > 0.01f * f5 && rawY < f5 * 0.99f) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
