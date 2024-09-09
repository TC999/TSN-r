package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.u.gw;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends c {
    private final AtomicBoolean bw;
    private final com.bytedance.sdk.openadsdk.core.video.w.w gw;

    /* renamed from: m  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.c.c.c f32529m;
    private final AtomicBoolean pr;
    protected final AtomicLong wv;
    private final AtomicBoolean wx;

    /* renamed from: x  reason: collision with root package name */
    private final AtomicBoolean f32530x;
    private final int xk;
    private long yu;

    public gd(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
        this.xk = 4;
        this.yu = 4L;
        this.wx = new AtomicBoolean(false);
        this.pr = new AtomicBoolean(false);
        this.bw = new AtomicBoolean(false);
        this.f32530x = new AtomicBoolean(false);
        this.wv = new AtomicLong();
        this.gw = new com.bytedance.sdk.openadsdk.core.video.w.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.gd.1
            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public boolean c() {
                if (gd.this.bw.get() || gw.w(gd.this.f32514w)) {
                    gd.this.ok();
                    return true;
                }
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public void ev() {
                gd.this.h();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public boolean f() {
                return gd.this.ls.p();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public void gd() {
                gd.this.f32502c.m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public int k() {
                return gd.this.bw.get() ? 1 : 2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public void p() {
                TTBaseVideoActivity tTBaseVideoActivity2 = gd.this.f32502c;
                if (tTBaseVideoActivity2 != null) {
                    tTBaseVideoActivity2.fp();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public Map<String, Object> r() {
                HashMap hashMap = new HashMap();
                hashMap.put("refer", "in_video");
                return hashMap;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public boolean sr() {
                return gd.this.f32530x.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public long ux() {
                return gd.this.wv.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public void w() {
                gd.this.bw.set(false);
                gd.this.gd.ux(8);
                if (!gd.this.r()) {
                    gd.this.f32502c.m();
                }
                gd.this.f32502c.n();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public void xv() {
                gd.this.me();
                gd.this.f32530x.set(true);
                gd.this.f32502c.ia();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.w
            public void c(long j4, long j5) {
                gd.this.f32509q.w(j4);
                gd.this.u();
                gd.this.wv.set(j4);
            }
        };
    }

    private void fm() {
        if (this.wx.get()) {
            ng();
            te();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.wx.set(false);
    }

    private void oh() {
        this.pr.set(true);
        this.f32529m.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok() {
        this.gd.ux(0);
        this.f32502c.x();
        this.f32529m.xv();
        this.f32502c.ev(2);
    }

    private void te() {
        if (this.pr.get()) {
            long j4 = this.yu - 1;
            this.yu = j4;
            if (j4 != 0) {
                if (j4 > 0) {
                    this.f32529m.c(j4);
                    return;
                }
                return;
            }
            this.f32529m.c(j4);
            this.bw.set(true);
            if (r()) {
                this.f32529m.c(this.f32507n);
            } else {
                this.f32529m.c(this.ev);
            }
        }
    }

    public static int w(me meVar) {
        return 10;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean au() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public int ba() {
        return w(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ls() {
        super.ls();
        this.f32504i.c(false, "\u5956\u52b1\u5df2\u9886\u53d6", "\u8df3\u8fc7", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void me() {
        super.me();
        this.f32504i.c(false, "\u5956\u52b1\u5df2\u9886\u53d6", "\u8df3\u8fc7", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return true;
    }

    public void ng() {
        if (this.pr.get()) {
            return;
        }
        int me = (int) this.f32509q.me();
        int q3 = (int) this.f32509q.q();
        int xv = gw.xv(this.f32514w);
        if (xv == 1) {
            c(gw.sr(this.f32514w), q3, 1000 * this.fp, false);
        } else if (xv == 2) {
            c((int) (q3 * 0.001f * 0.01f * gw.sr(this.f32514w)), q3, me, false);
        } else if (xv != 3) {
        } else {
            c(yu(), q3, me, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        this.gd.ux(8);
        this.gd.f(0);
        this.f32504i.ux(true);
        this.f32504i.xv(true);
        this.f32504i.w(true);
        this.f32504i.c(true);
        this.f32502c.up();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void u() {
        super.u();
        this.fz = false;
        boolean z3 = ((int) (this.f32509q.me() / 1000)) >= this.ys || this.f32502c.au();
        if (this.f32509q.yu()) {
            this.f32504i.c(false, null, "\u8df3\u8fc7", false, true);
            return;
        }
        int eq = this.f32509q.eq();
        if (this.f32509q.c()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = this.f32504i;
        uxVar.c(false, eq + "s", z3 ? "\u8df3\u8fc7" : "", false, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void wo() {
        fm();
        if (m.ia(this.f32514w)) {
            this.f32502c.xv(0);
            if (gb() > x() || this.f32511s) {
                com.bytedance.sdk.openadsdk.core.r.xv.f34517c = 0;
            }
            com.bytedance.sdk.openadsdk.core.r.xv.f34517c = pr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public com.bytedance.sdk.openadsdk.core.video.w.w wv() {
        return this.gw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void xu() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.ux uxVar = this.f32507n;
        if (uxVar != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.gw);
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f32507n.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(this.gw);
        }
        com.bytedance.sdk.openadsdk.core.w.r rVar = this.ev;
        if (rVar != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) rVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.gw);
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.ev.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(this.gw);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.c.c.c cVar = new com.bytedance.sdk.openadsdk.core.component.reward.c.c.c(this.f32502c, this.f32514w, this.gw);
        this.f32529m = cVar;
        cVar.c(this.f32502c.wv().getSceneFrameContainer(), this.f32502c.wv().getSceneFrame());
        this.wx.set(gw.xv(this.f32514w) != 0);
        if (this.wx.get()) {
            n();
            this.fz = true;
        }
    }

    public static boolean c(me meVar) {
        return gw.c(meVar);
    }

    private void c(int i4, long j4, long j5, boolean z3) {
        if (z3) {
            if (i4 <= 3) {
                oh();
            }
        } else if (i4 >= 1) {
            long j6 = i4 * 1000;
            if (j6 > j4) {
                return;
            }
            long j7 = j6 - j5;
            if (j7 <= 0 || Math.abs(j7) > 3200) {
                return;
            }
            oh();
        }
    }
}
