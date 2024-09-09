package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends c {
    public ux(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
    }

    public static int w(me meVar) {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public int ba() {
        return w(this.f32514w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean bm() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.f fVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.f(this.f32502c, this.f32514w, z3);
        this.gd = fVar;
        return fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public View gd() {
        if (this.xv == 2) {
            int tz = this.f32514w.tz();
            if (tz != 3) {
                if (tz != 33) {
                    return com.bytedance.sdk.openadsdk.res.ux.u(this.f32502c);
                }
                return com.bytedance.sdk.openadsdk.res.ux.fz(this.f32502c);
            }
            return com.bytedance.sdk.openadsdk.res.ux.s(this.f32502c);
        }
        int tz2 = this.f32514w.tz();
        if (tz2 != 3) {
            if (tz2 != 33) {
                return com.bytedance.sdk.openadsdk.res.ux.j(this.f32502c);
            }
            return com.bytedance.sdk.openadsdk.res.ux.q(this.f32502c);
        }
        return com.bytedance.sdk.openadsdk.res.ux.i(this.f32502c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        if (this.f32508p.f()) {
            return this.f32508p.k();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        this.gd.ux(8);
        this.gd.f(8);
        this.f32504i.ux(com.bytedance.sdk.openadsdk.n.gd.c(this.f32514w));
        this.f32504i.w(this.f32514w.bx());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void wo() {
        super.wo();
        if (m.ia(this.f32514w)) {
            this.f32502c.xv(0);
            int gb = gb();
            if (gb <= x() && !this.f32511s) {
                int f4 = f(true);
                int f5 = f(false);
                com.bytedance.sdk.openadsdk.core.r.xv.f34517c = f4;
                boolean z3 = gb > this.ys || this.f32502c.au();
                com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = this.f32504i;
                boolean z4 = this.f32512t;
                StringBuilder sb = new StringBuilder();
                sb.append(f5);
                sb.append("s");
                sb.append(this.f32512t ? "\u540e\u53ef\u9886\u53d6\u5956\u52b1" : "");
                uxVar.c(z4, sb.toString(), null, z3, z3);
                w(f4);
                if (this.f32508p == null || j() != 7) {
                    return;
                }
                this.f32508p.c((CharSequence) String.valueOf(f5), gb, 0, false);
                return;
            }
            com.bytedance.sdk.openadsdk.core.r.xv.f34517c = 0;
            com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar2 = this.f32504i;
            boolean z5 = this.f32512t;
            uxVar2.c(z5, z5 ? "\u9886\u53d6\u6210\u529f" : "", null, true, true);
            this.f32502c.mt();
            if (this.f32508p == null || j() != 7) {
                return;
            }
            this.f32508p.c((CharSequence) "0", gb, 0, false);
        }
    }

    public static boolean c(me meVar) {
        if (meVar == null) {
            return false;
        }
        return !me.w(meVar);
    }
}
