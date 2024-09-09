package com.bytedance.sdk.openadsdk.core.component.reward.w;

import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.gd;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.ia.ev;
import com.bytedance.sdk.openadsdk.core.ia.r;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.stub.StubApp;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements r {

    /* renamed from: c  reason: collision with root package name */
    protected ev f32719c;

    /* renamed from: f  reason: collision with root package name */
    private w f32720f;
    private ux gd;

    /* renamed from: r  reason: collision with root package name */
    private String f32722r;
    private final TTBaseVideoActivity sr;
    private me ux;
    protected boolean xv;
    private boolean ev = false;

    /* renamed from: w  reason: collision with root package name */
    protected int f32723w = -1;

    /* renamed from: p  reason: collision with root package name */
    private boolean f32721p = false;

    public sr(TTBaseVideoActivity tTBaseVideoActivity) {
        this.sr = tTBaseVideoActivity;
    }

    private void a() {
        ev evVar;
        if (u.xv(this.ux) && (evVar = this.f32719c) != null) {
            evVar.unregisterReceiver();
            this.f32719c.c((r) null);
        }
    }

    private void k() {
        ev evVar;
        if (u.xv(this.ux) && (evVar = this.f32719c) != null) {
            evVar.c(this);
            this.f32719c.registerReceiver();
        }
    }

    public void c(w wVar, me meVar, String str, ux uxVar) {
        if (this.f32721p) {
            return;
        }
        this.f32721p = true;
        this.f32720f = wVar;
        this.ux = meVar;
        this.f32722r = str;
        this.gd = uxVar;
        sr();
    }

    public boolean ev() {
        w wVar = this.f32720f;
        if (wVar != null) {
            return wVar.eq();
        }
        return false;
    }

    public void f() {
        if (u.xv(this.ux)) {
            if (this.f32720f.yu() || ev()) {
                boolean z3 = !this.xv;
                this.xv = z3;
                this.f32720f.c(z3);
            }
        }
    }

    public boolean gd() {
        if (u.ux(this.ux)) {
            return this.f32720f.xk();
        }
        return false;
    }

    public boolean p() {
        return this.xv;
    }

    public void r() {
        a.w("RewardFullPlayableManager", "exitPrePosePlayable");
        this.f32720f.ba();
        this.gd.c(this.sr.b().au());
    }

    public void sr() {
        if (u.xv(this.ux) && !(this.sr.b() instanceof gd)) {
            ev evVar = new ev(StubApp.getOrigApplicationContext(this.sr.getApplicationContext()));
            this.f32719c = evVar;
            evVar.c(this);
            this.f32723w = this.f32719c.w();
            a.w("onVolumeChanged", "onCreate >>>>>> mVolume = " + this.f32723w);
            if (this.f32723w == 0) {
                this.xv = true;
            }
        }
    }

    public void ux() {
        if (u.xv(this.ux)) {
            HashMap hashMap = new HashMap();
            if (ng.bk(this.ux) != null) {
                hashMap.put("playable_url", u.c(this.ux));
            }
            com.bytedance.sdk.openadsdk.core.a.xv.p(this.ux, this.f32722r, "click_playable_download_button_loading", hashMap);
        }
    }

    public void w() {
        if (u.xv(this.ux)) {
            this.ev = false;
        }
    }

    public void xv() {
        if (u.xv(this.ux)) {
            a();
        }
    }

    public void w(boolean z3) {
        this.f32720f.f(z3);
    }

    public void c() {
        ev evVar;
        if (u.xv(this.ux)) {
            this.ev = true;
            k();
            if ((this.f32720f.yu() || ev()) && !this.xv && (evVar = this.f32719c) != null && evVar.w() == 0) {
                this.xv = true;
                this.gd.sr(true);
                this.f32720f.c(true);
            }
        }
    }

    public void c(boolean z3) {
        ev evVar;
        w wVar = this.f32720f;
        if (wVar != null && wVar.y()) {
            boolean z4 = z3 || ((evVar = this.f32719c) != null && evVar.w() == 0);
            this.xv = z4;
            this.gd.sr(z4);
            this.f32720f.c(z4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ia.r
    public void c(int i4) {
        this.f32723w = i4;
        if (this.ev) {
            if (this.f32720f.yu() || ev()) {
                boolean z3 = i4 == 0;
                this.xv = z3;
                this.gd.sr(z3);
                this.f32720f.c(this.xv);
            }
        }
    }

    public void c(boolean z3, boolean z4) {
        a.w("RewardFullPlayableManager", "startPrePosePlayable");
        this.f32720f.n();
        c(z3);
        w(z4);
    }

    public void c(int i4, int i5) {
        this.f32720f.w(i4, i5);
    }

    public void c(me meVar) {
        this.ux = meVar;
    }
}
