package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk extends c {
    public bk(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
    }

    public static boolean c(me meVar) {
        return true;
    }

    public static int w(me meVar) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean b() {
        if (this.f32512t) {
            if (this.f32514w.y() == 2 && this.f32514w.ld() == 3) {
                return false;
            }
            return (this.f32514w.y() == 2 && this.f32514w.ld() == 7) ? false : true;
        }
        return false;
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
    public void fp() {
        super.fp();
        this.f32504i.w(this.f32514w.bx());
        this.f32504i.ux(true);
        this.gd.f(0);
        this.gd.ux(0);
        this.f32502c.up();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        if (f()) {
            this.gd.ux(8);
            this.gd.f(8);
            this.f32504i.c(false);
            this.f32504i.w(false);
            return;
        }
        this.gd.ux(0);
        this.gd.f(0);
        this.f32504i.ux(true);
        this.f32504i.w(this.f32514w.bx());
        this.f32502c.up();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void q() {
        super.q();
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return mt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void wo() {
        if (m.ia(this.f32514w)) {
            boolean z3 = !m.xv();
            boolean xv = m.xv();
            this.f32502c.xv(0);
            if (gb() <= x() && !this.f32511s) {
                int f4 = f(true);
                int f5 = f(false);
                com.bytedance.sdk.openadsdk.core.r.xv.f34517c = f4;
                boolean z4 = gb() > this.ys || this.f32502c.au();
                boolean z5 = z3 && z4;
                boolean z6 = xv && z4;
                com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = this.f32504i;
                boolean z7 = this.f32512t;
                StringBuilder sb = new StringBuilder();
                sb.append(f5);
                sb.append("s");
                sb.append(this.f32512t ? "\u540e\u53ef\u9886\u53d6\u5956\u52b1" : "");
                uxVar.c(z7, sb.toString(), z5 ? "\u8df3\u8fc7" : "", z6, z4);
                w(f4);
                return;
            }
            com.bytedance.sdk.openadsdk.core.r.xv.f34517c = 0;
            com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar2 = this.f32504i;
            boolean z8 = this.f32512t;
            uxVar2.c(z8, z8 ? "\u9886\u53d6\u6210\u529f" : "", z3 ? "\u8df3\u8fc7" : "", xv, true);
            this.f32502c.mt();
        }
    }
}
