package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends c {
    int wv;
    int xk;
    private com.bytedance.sdk.openadsdk.core.a.ux yu;

    public a(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
        this.wv = 0;
        this.xk = 0;
        com.bytedance.sdk.openadsdk.core.a.ux uxVar = new com.bytedance.sdk.openadsdk.core.a.ux(meVar);
        this.yu = uxVar;
        uxVar.c(true);
    }

    public static boolean c(me meVar) {
        return meVar.t() == 1 && fp.c(meVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public int ba() {
        return w(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public boolean eq() {
        if (yu() > 0) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32514w)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) this.gd).c(0);
            return true;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ev() {
        JSONObject xv;
        super.ev();
        com.bytedance.sdk.openadsdk.core.playable.sr.c().c(this.f32514w);
        if (!com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32514w) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
            this.wv = u.r(this.f32514w);
        } else {
            com.bytedance.sdk.openadsdk.core.ugeno.gd.c fp = this.f32514w.fp();
            this.wv = 30;
            if (fp != null && (xv = fp.xv()) != null) {
                this.wv = xv.optInt("reward_time", 30);
            }
        }
        this.xk = u.ev(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public boolean f() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public View gd() {
        FrameLayout frameLayout = new FrameLayout(this.f32502c);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void i() {
        super.i();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        this.gd.ux(0);
        this.f32504i.c(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
            this.f32504i.ux(true);
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32514w) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
            this.f32504i.w(this.f32514w.bx());
        } else {
            this.f32504i.w(false);
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.xv(this.f32514w)) {
            this.f32504i.xv(true);
            this.f32504i.ux(true);
            com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = this.f32504i;
            boolean z3 = this.f32512t;
            StringBuilder sb = new StringBuilder();
            sb.append(yu());
            sb.append("s");
            sb.append(this.f32512t ? "\u540e\u53ef\u9886\u53d6\u5956\u52b1" : "");
            uxVar.c(z3, sb.toString(), null, true, true);
            return;
        }
        this.f32504i.ux(false);
        this.f32504i.c(false, null, null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void q() {
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) this.gd).xv()) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) this.gd).c(false);
        } else {
            super.q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int r(boolean z3) {
        if ((this.f32505j.yu() && fp.c(this.f32514w)) || this.wv == 0) {
            return 0;
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32514w) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
            return Math.max(Math.min(this.wv, 27) - gb(), 0);
        }
        return Math.max(this.wv - gb(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void t() {
        super.t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ux(boolean z3) {
        super.ux(z3);
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) this.gd).w(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void w(boolean z3) {
        super.w(z3);
        this.yu.xv();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.c) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) wVar).gd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void wo() {
        int gb = gb();
        int max = Math.max(0, this.wv - gb);
        if (!this.f32505j.yu()) {
            int i4 = this.wv;
            if (gb >= i4) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.f.xv(this.f32514w)) {
                    com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = this.f32504i;
                    boolean z3 = this.f32512t;
                    uxVar.c(z3, z3 ? "\u9886\u53d6\u6210\u529f" : "", null, true, true);
                } else {
                    this.f32504i.c(false, null, null, true, true);
                }
                this.f32502c.ia();
            } else if (this.xk >= i4) {
                this.f32504i.c(false, String.valueOf(max), null, false, false);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.f.xv(this.f32514w)) {
                com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar2 = this.f32504i;
                boolean z4 = this.f32512t;
                StringBuilder sb = new StringBuilder();
                sb.append(max);
                sb.append("s");
                sb.append(this.f32512t ? "\u540e\u53ef\u9886\u53d6\u5956\u52b1" : "");
                uxVar2.c(z4, sb.toString(), null, this.xk <= gb, true);
            } else if (!com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32514w) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
                if (gb >= this.xk) {
                    this.f32504i.c(false, String.valueOf(max), "\u8df3\u8fc7", false, true);
                } else {
                    com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar3 = this.f32504i;
                    String valueOf = String.valueOf(max);
                    uxVar3.c(false, valueOf, (this.xk - gb) + "s\u540e\u53ef\u8df3\u8fc7", false, false);
                }
            } else if (gb >= this.xk) {
                this.f32504i.c(false, null, null, true, true);
            }
        }
        this.f32502c.xv(0);
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
            this.f32504i.c(this.wv, max);
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32514w)) {
            this.f32504i.c(this.wv, max);
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) this.gd).c(max);
        }
        if (max == 0) {
            com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
            if (wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.c) {
                ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) wVar).r();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int wx() {
        if ((this.f32505j.yu() && fp.c(this.f32514w)) || this.wv == 0) {
            return 0;
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32514w) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
            return Math.max(((int) Math.min((this.wv * this.f32514w.wq()) / 100.0f, 27.0f)) - gb(), 0);
        }
        return Math.max(this.wv - gb(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void xv(boolean z3) {
        super.xv(z3);
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.c) {
            if (((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) wVar).f()) {
                this.yu.c(((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) this.gd).ux().get());
            }
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) this.gd).ev();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ys() {
        super.ys();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
        if ((wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.c) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) wVar).f()) {
            this.yu.sr();
        }
        this.gd.p();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.c cVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.c(this.f32502c, this.f32514w, z3, this.yu, this.f32504i);
        this.gd = cVar;
        return cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public w.c c(final com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar) {
        this.f32502c.x();
        this.f32502c.bw();
        com.bytedance.sdk.openadsdk.core.component.reward.xv.ev evVar = new com.bytedance.sdk.openadsdk.core.component.reward.xv.ev(this.f32502c, this.f32514w);
        evVar.c(this.f32505j.fz());
        evVar.c(pr());
        return evVar.w(new com.bytedance.sdk.openadsdk.core.component.reward.xv.p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.a.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void c() {
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.c();
                }
                if (com.bytedance.sdk.openadsdk.core.ugeno.f.sr(a.this.f32514w) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) a.this.gd).sr()) {
                    return;
                }
                a.this.f32502c.m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void w() {
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.w();
                }
            }
        });
    }

    public static int w(me meVar) {
        return com.bytedance.sdk.openadsdk.core.ugeno.f.xv(meVar) ? 6 : 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c, com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    protected void xv() {
        this.f32504i.c(4);
        this.gd.xv(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32514w) || com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32514w)) {
            this.f32504i.k();
            this.f32504i.w(this.wv);
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.c) this.gd).c(Math.max(0, this.wv - gb()));
        }
        this.f32502c.w(true, true);
        n();
    }
}
