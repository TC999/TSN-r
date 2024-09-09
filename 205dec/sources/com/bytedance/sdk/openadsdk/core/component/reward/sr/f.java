package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends c {
    public f(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
    }

    public static boolean c(me meVar) {
        return (meVar == null || meVar.yx() == 100.0f) ? false : true;
    }

    private boolean ng() {
        return me.w(this.f32514w);
    }

    private boolean ok() {
        return com.bytedance.sdk.openadsdk.n.gd.c(this.f32514w);
    }

    public static int w(me meVar) {
        return 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public int ba() {
        return w(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean bj() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ev() {
        super.ev();
        gw();
        try {
            final View decorView = this.f32502c.getWindow().getDecorView();
            if (decorView != null) {
                decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int k4 = (int) (xk.k(f.this.f32502c) / 2.0f);
                        int paddingLeft = decorView.getPaddingLeft();
                        int paddingRight = decorView.getPaddingRight();
                        int paddingTop = decorView.getPaddingTop();
                        int paddingBottom = decorView.getPaddingBottom();
                        if (f.this.xv == 1 && !xk.w()) {
                            paddingTop += k4;
                            paddingBottom += k4;
                        }
                        if (f.this.xv == 2 && !xk.w()) {
                            paddingLeft += k4;
                            paddingRight += k4;
                        }
                        decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void fp() {
        super.fp();
        this.f32504i.w(this.f32514w.bx());
        if (ng() || ok()) {
            this.f32504i.ux(true);
        }
        if (!ng()) {
            this.f32504i.c(false, null, null, true, true);
        }
        if (ng()) {
            this.gd.f(0);
            this.gd.ux(0);
            this.gd.xv(0);
            return;
        }
        this.gd.f(8);
        this.gd.ux(8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public View gd() {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f32514w)) {
            return com.bytedance.sdk.openadsdk.res.ux.ls(this.f32502c);
        }
        int i4 = (int) (this.sr * 1000.0f);
        if (this.xv == 1) {
            if (i4 != 666) {
                if (i4 != 1000) {
                    if (i4 != 1500) {
                        if (i4 != 1777) {
                            return com.bytedance.sdk.openadsdk.res.ux.ba(this.f32502c);
                        }
                        return com.bytedance.sdk.openadsdk.res.ux.z(this.f32502c);
                    }
                    return com.bytedance.sdk.openadsdk.res.ux.n(this.f32502c);
                }
                return com.bytedance.sdk.openadsdk.res.ux.ck(this.f32502c);
            }
            return com.bytedance.sdk.openadsdk.res.ux.gb(this.f32502c);
        } else if (i4 != 562) {
            if (i4 != 666) {
                if (i4 != 1000) {
                    if (i4 != 1500) {
                        return com.bytedance.sdk.openadsdk.res.ux.wv(this.f32502c);
                    }
                    return com.bytedance.sdk.openadsdk.res.ux.eq(this.f32502c);
                }
                return com.bytedance.sdk.openadsdk.res.ux.ck(this.f32502c);
            }
            return com.bytedance.sdk.openadsdk.res.ux.y(this.f32502c);
        } else {
            return com.bytedance.sdk.openadsdk.res.ux.me(this.f32502c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return ng();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        return ng() || ok();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        this.gd.ux(8);
        this.gd.f(8);
        boolean z3 = false;
        if (f()) {
            this.f32504i.c(false);
            return;
        }
        this.f32504i.w(this.f32514w.bx());
        this.f32504i.ux((ng() || ok()) ? true : true);
        if (ng()) {
            return;
        }
        this.f32504i.c(false, null, null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void sr(boolean z3) {
        int i4 = (int) (this.sr * 1000.0f);
        if (this.xv != 1) {
            this.gd.sr(8);
        } else if (i4 != 666 && i4 != 1000 && i4 != 1500 && i4 != 1777) {
            this.gd.sr(z3 ? 0 : 8);
        } else {
            this.gd.sr(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return mt() && this.f32514w.y() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public boolean vc() {
        return this.xv == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void xu() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.f fVar = this.gb;
        if (fVar != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c((Object) this.f32502c);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.ux uxVar = this.f32507n;
        if (uxVar != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c((Object) this.f32502c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void xv(boolean z3) {
        super.xv(z3);
        if (ls.w().k(wv.gd(this.f32514w))) {
            if (com.bytedance.sdk.openadsdk.core.p.xv.xv.f.xv && com.bytedance.sdk.openadsdk.core.p.xv.xv.f.f34386w && xv(this.f32514w)) {
                com.bytedance.sdk.openadsdk.core.p.xv.xv.f.f34386w = false;
                com.bytedance.sdk.openadsdk.core.p.xv.xv.f.xv = false;
                this.f32502c.finish();
            } else if (z3 && !com.bytedance.sdk.openadsdk.core.p.xv.xv.f.xv) {
                this.f32502c.finish();
            } else if (!this.f32505j.me() || com.bytedance.sdk.openadsdk.core.p.xv.xv.f.xv) {
            } else {
                this.f32502c.finish();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.r rVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.r(this.f32502c, this.f32514w, z3);
        this.gd = rVar;
        return rVar;
    }

    private boolean xv(me meVar) {
        return (meVar.v() == 4) && !TextUtils.isEmpty(meVar.ib());
    }
}
