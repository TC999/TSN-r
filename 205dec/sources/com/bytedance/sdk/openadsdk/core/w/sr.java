package com.bytedance.sdk.openadsdk.core.w;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.eq.q;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class sr implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private static float f35363c = 0.0f;
    protected static int gd = 8;
    private static float sr;
    private static long ux;

    /* renamed from: w  reason: collision with root package name */
    private static float f35364w;
    private static float xv;

    /* renamed from: f  reason: collision with root package name */
    protected final Context f35365f;

    /* renamed from: r  reason: collision with root package name */
    protected gd f35366r = new gd();
    protected final com.bytedance.sdk.openadsdk.core.w.c.sr ev = new com.bytedance.sdk.openadsdk.core.w.c.sr();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public int f35367c;
        public long sr;

        /* renamed from: w  reason: collision with root package name */
        public double f35368w;
        public double xv;

        public c(int i4, double d4, double d5, long j4) {
            this.f35367c = i4;
            this.f35368w = d4;
            this.xv = d5;
            this.sr = j4;
        }
    }

    static {
        try {
            if (ViewConfiguration.get(ls.getContext()) != null) {
                gd = ViewConfiguration.get(ls.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public sr(Context context) {
        if (context == null) {
            this.f35365f = ls.getContext();
        } else {
            this.f35365f = context;
        }
    }

    public <T extends com.bytedance.sdk.openadsdk.core.w.c.c> T c(Class<T> cls) {
        return (T) this.ev.c(cls);
    }

    protected abstract void c(View view, gd gdVar);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.bytedance.sdk.openadsdk.core.z.f.c()) {
            c(view, this.f35366r);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i4;
        this.f35366r.w(motionEvent.getDeviceId());
        this.f35366r.c(motionEvent.getToolType(0));
        this.f35366r.xv(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f35366r.sr((int) motionEvent.getRawX());
            this.f35366r.ux((int) motionEvent.getRawY());
            this.f35366r.c(motionEvent.getRawX());
            this.f35366r.w(motionEvent.getRawY());
            this.f35366r.c(System.currentTimeMillis());
            this.f35366r.c(motionEvent.getToolType(0));
            this.f35366r.w(motionEvent.getDeviceId());
            this.f35366r.xv(motionEvent.getSource());
            ux = System.currentTimeMillis();
            this.f35366r.c(true);
            q.c(motionEvent);
            i4 = 0;
        } else if (actionMasked == 1) {
            this.f35366r.xv(motionEvent.getRawX());
            this.f35366r.sr(motionEvent.getRawY());
            if (Math.abs(this.f35366r.ys() - this.f35366r.r()) >= gd || Math.abs(this.f35366r.fp() - this.f35366r.ev()) >= gd) {
                this.f35366r.c(false);
            }
            this.f35366r.w(System.currentTimeMillis());
            Context context = this.f35365f;
            if (context == null) {
                context = ls.getContext();
            }
            com.bytedance.sdk.openadsdk.core.w.c.w wVar = (com.bytedance.sdk.openadsdk.core.w.c.w) c(com.bytedance.sdk.openadsdk.core.w.c.w.class);
            if (wVar != null) {
                wVar.c(this.f35366r);
            }
            if (com.bytedance.sdk.component.adexpress.dynamic.w.c.c(view)) {
                if (com.bytedance.sdk.component.adexpress.dynamic.w.c.c(view, this.f35366r.ys(), this.f35366r.fp(), this.f35366r.r(), this.f35366r.ev())) {
                    return false;
                }
                if (com.bytedance.sdk.component.adexpress.dynamic.w.c.w(view)) {
                    c(view, this.f35366r);
                }
                return true;
            }
            if (wVar != null) {
                Point point = new Point((int) this.f35366r.ys(), (int) this.f35366r.fp());
                if (view != null && !wVar.c(view, context) && wVar.c((View) view.getParent(), point)) {
                    return true;
                }
            }
            i4 = 3;
        } else if (actionMasked == 2) {
            xv += Math.abs(motionEvent.getX() - f35363c);
            sr += Math.abs(motionEvent.getY() - f35364w);
            f35363c = motionEvent.getX();
            f35364w = motionEvent.getY();
            long currentTimeMillis = System.currentTimeMillis() - ux;
            this.f35366r.xv(motionEvent.getRawX());
            this.f35366r.sr(motionEvent.getRawY());
            if (Math.abs(this.f35366r.ys() - this.f35366r.r()) >= gd || Math.abs(this.f35366r.fp() - this.f35366r.ev()) >= gd) {
                this.f35366r.c(false);
            }
            if (currentTimeMillis > 200) {
                float f4 = xv;
                int i5 = gd;
                if (f4 > i5 || f35364w > i5) {
                    i4 = 1;
                }
            }
            i4 = 2;
        } else if (actionMasked != 3) {
            i4 = -1;
        } else if (com.bytedance.sdk.component.adexpress.dynamic.w.c.c(view) && com.bytedance.sdk.component.adexpress.dynamic.w.c.w(view)) {
            c(view, this.f35366r);
            return true;
        } else {
            i4 = 4;
        }
        this.f35366r.gd().put(motionEvent.getActionMasked(), new c(i4, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }
}
