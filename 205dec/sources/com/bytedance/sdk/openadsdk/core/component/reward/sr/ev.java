package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.stub.StubApp;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends c {
    int wv;
    private HomeWatcherReceiver wx;
    int xk;
    boolean yu;

    public ev(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
        this.wv = 0;
        this.xk = 0;
        this.yu = false;
    }

    public static boolean c(me meVar) {
        return u.ux(meVar);
    }

    private void ok() {
        try {
            HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
            this.wx = homeWatcherReceiver;
            homeWatcherReceiver.c(new HomeWatcherReceiver.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.ev.1
                @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.c
                public void c() {
                    ev.this.yu = true;
                }

                @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.c
                public void w() {
                    ev.this.yu = true;
                }
            });
            StubApp.getOrigApplicationContext(this.f32502c.getApplicationContext()).registerReceiver(this.wx, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean b() {
        return fp.sr(this.f32514w);
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
        if (!fp.sr(this.f32514w) && wx.u(this.f32514w) == 0) {
            return this.f32505j.fz();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ev() {
        super.ev();
        ok();
        com.bytedance.sdk.openadsdk.core.playable.sr.c().c(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public boolean f() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public View gd() {
        return com.bytedance.sdk.openadsdk.res.ux.c(this.f32502c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return true;
    }

    public void ng() {
        int ms2 = this.f32514w.ms();
        if (ms2 == 0) {
            this.gd.ux(0);
            this.f32504i.ux(true);
            this.f32504i.w(this.f32514w.bx());
        } else if (ms2 != 1) {
            if (ms2 != 3) {
                return;
            }
            this.f32504i.ux(false);
            this.f32504i.w(false);
            this.f32504i.c(false, null, null, true, true);
        } else {
            this.gd.ux(0);
            this.f32504i.w(this.f32514w.bx());
            if (fp.sr(this.f32514w)) {
                this.f32504i.ux(me.w(this.f32514w));
            } else {
                this.f32504i.ux(com.bytedance.sdk.openadsdk.n.gd.c(this.f32514w));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        return fp.sr(this.f32514w) && me.w(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        this.f32504i.c(true);
        this.gd.f(8);
        if (fp.c(this.f32514w)) {
            ng();
            return;
        }
        this.f32504i.ux(true);
        this.f32504i.w(this.f32514w.bx());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public View p() {
        if (fp.sr(this.f32514w)) {
            this.f32506k = new RewardJointEndCardFrameLayout(this.f32502c, this.f32514w);
        }
        return super.p();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int r(boolean z3) {
        int i4;
        if (fp.k(this.f32514w) || (i4 = this.wv) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i4, 27.0f)) - gb());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void t() {
        super.t();
        this.f32502c.bw();
        c("go_background");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void w(boolean z3) {
        super.w(z3);
        c("return_foreground");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void wo() {
        if (fp.k(this.f32514w)) {
            return;
        }
        int gb = gb();
        int i4 = this.wv;
        int i5 = i4 - gb;
        if (gb >= i4) {
            this.f32504i.c(false, null, null, true, true);
            if (!fp.k(this.f32514w)) {
                this.f32502c.ia();
            }
        } else {
            int i6 = this.xk;
            if (i6 >= i4) {
                this.f32504i.c(false, String.valueOf(i5), null, false, false);
            } else if (gb >= i6) {
                this.f32504i.c(false, String.valueOf(i5), "\u8df3\u8fc7", false, true);
            } else {
                com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = this.f32504i;
                String valueOf = String.valueOf(i5);
                uxVar.c(false, valueOf, (this.xk - gb) + "s\u540e\u53ef\u8df3\u8fc7", false, false);
            }
        }
        this.f32502c.xv(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    protected int wx() {
        if (fp.k(this.f32514w) || this.wv == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.wv * this.f32514w.wq()) / 100.0f, 27.0f)) - gb());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c, com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    protected void xv() {
        this.f32504i.c(4);
        this.f32505j.c();
        this.f32502c.ls();
        this.f32505j.u();
        this.wv = u.r(this.f32514w);
        this.xk = u.ev(this.f32514w);
        n();
        if (fp.sr(this.f32514w)) {
            this.f32502c.gd();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void ys() {
        super.ys();
        c(this.f32502c);
        com.bytedance.sdk.openadsdk.core.playable.sr.c().w(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void c(View view) {
        super.c(view);
        if (view.getId() == 2114387727) {
            this.ls.ux();
        }
    }

    public static int w(me meVar) {
        if (wx.ys(meVar)) {
            return 5;
        }
        return fp.c(meVar) ? 6 : 0;
    }

    private void c(Context context) {
        if (u.xv(this.f32514w)) {
            try {
                this.wx.c(null);
                StubApp.getOrigApplicationContext(context.getApplicationContext()).unregisterReceiver(this.wx);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(String str) {
        if (this.yu) {
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(this.f32505j.ls()));
            com.bytedance.sdk.openadsdk.core.a.xv.r(this.f32514w, this.f32501a, str, hashMap);
            if ("return_foreground".equals(str)) {
                this.yu = false;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void xv(boolean z3) {
        super.xv(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public w.c c(final com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar) {
        if (this.ls.gd()) {
            return new w.c(false, 0, "");
        }
        this.f32502c.x();
        this.f32502c.bw();
        com.bytedance.sdk.openadsdk.core.component.reward.xv.ev evVar = new com.bytedance.sdk.openadsdk.core.component.reward.xv.ev(this.f32502c, this.f32514w);
        evVar.c(this.f32505j.fz());
        evVar.c(pr());
        return evVar.w(new com.bytedance.sdk.openadsdk.core.component.reward.xv.p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.ev.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void c() {
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.c();
                }
                ev.this.f32502c.m();
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
}
