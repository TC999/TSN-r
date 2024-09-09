package com.bytedance.sdk.openadsdk.core.ugeno.xv;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.adsdk.ugeno.w.l;
import com.bytedance.sdk.openadsdk.core.a.ux;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.me;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends c implements l {

    /* renamed from: a  reason: collision with root package name */
    private b f35093a;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35094f;
    private float gd;

    /* renamed from: k  reason: collision with root package name */
    private long f35095k;

    /* renamed from: p  reason: collision with root package name */
    private float f35096p;

    /* renamed from: r  reason: collision with root package name */
    private float f35097r;

    public xv(Activity activity, ViewGroup viewGroup, ux uxVar, me meVar, String str, int i4, com.bytedance.sdk.openadsdk.core.multipro.w.c cVar) {
        super(activity, viewGroup, uxVar, meVar, str, i4, cVar);
    }

    private void f() {
        Animation animation;
        b bVar = this.f35093a;
        if (bVar != null) {
            bVar.w(8);
            View gd = this.f35093a.gd();
            if (gd == null || (animation = gd.getAnimation()) == null) {
                return;
            }
            animation.cancel();
        }
    }

    private int ux() {
        double r3 = u.r(this.f35070c) * this.f35070c.wq();
        Double.isNaN(r3);
        return (int) (r3 / 100.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xv.c
    protected void c(JSONObject jSONObject) {
        this.f35076w.c((l) this);
        try {
            jSONObject.put("isPlayable", "true");
            jSONObject.put("remainTime", ux());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xv.c
    public void sr() {
        super.sr();
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xv.c
    protected void c(b<View> bVar) {
        this.f35093a = bVar.w("fl_count_down");
    }

    private void c(MotionEvent motionEvent) {
        if (!this.f35094f) {
            int ev = xk.ev(ls.getContext());
            com.bytedance.sdk.openadsdk.core.a.xv.c("click", this.f35070c, new ev.c().f(this.f35097r).ux(this.ev).sr(this.gd).xv(this.f35096p).w(this.f35095k).c(motionEvent.getEventTime()).xv(motionEvent.getToolType(0)).sr(motionEvent.getDeviceId()).ux(this.ux).w(k.sr().w() ? 1 : 2).c(ev).c(xk.f(ls.getContext())).w(xk.r(ls.getContext())).c(), this.sr, true, null, -1, false);
        }
        this.f35094f = true;
    }

    @Override // com.bytedance.adsdk.ugeno.w.l
    public void c(b bVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.f35094f) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f35095k = motionEvent.getDownTime();
            this.f35097r = motionEvent.getRawX();
            this.ev = motionEvent.getRawY();
            f();
        } else if (action != 1) {
        } else {
            this.gd = motionEvent.getRawX();
            this.f35096p = motionEvent.getRawY();
            c(motionEvent);
        }
    }
}
