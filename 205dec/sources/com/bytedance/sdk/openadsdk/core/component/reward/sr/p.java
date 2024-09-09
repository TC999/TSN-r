package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends c {
    boolean wv;
    private boolean xk;

    public p(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
        this.wv = false;
        this.xk = false;
        this.xk = com.bytedance.sdk.openadsdk.core.live.xv.w.c(meVar) == 1;
    }

    public static int c(me meVar) {
        return 9;
    }

    private void ev(final boolean z3) {
        if (this.gd instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.gd) {
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.p.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = p.this.gd;
                    if (wVar == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.gd gdVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.gd) wVar;
                    if (z3) {
                        gdVar.w();
                    } else {
                        gdVar.xv();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng() {
        if (this.wv) {
            return;
        }
        this.wv = true;
        ev(false);
        this.f32502c.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public int ba() {
        return c(this.f32514w);
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
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c, com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    protected void xv() {
        this.f32502c.w(true, true);
        this.gd.xv(true);
        this.f32508p.xv(false);
        this.f32504i.c(false);
        int ev = xk.ev(ls.getContext());
        com.bytedance.sdk.openadsdk.core.a.xv.c("click", this.f32514w, new ev.c().f(-1.0f).ux(-1.0f).sr(-1.0f).xv(-1.0f).w(-1L).c(-1L).xv(-1).sr(-1).ux(-1024).w(com.bytedance.sdk.openadsdk.core.k.sr().w() ? 1 : 2).c(ev).c(xk.f(ls.getContext())).w(xk.r(ls.getContext())).c(), this.f32501a, true, this.f32502c.gw(), -1, false);
    }

    public static boolean c(Context context, me meVar) {
        if (bw.sr(meVar)) {
            long j4 = 0;
            if (ba.c(meVar)) {
                j4 = ba.w(meVar) * 1000;
            } else if (ng.bk(meVar) != null) {
                j4 = (long) (ng.ux(meVar) * 1000.0d);
            }
            long min = Math.min(m.c(), ((float) j4) * (meVar.wq() / 100.0f));
            HashMap hashMap = new HashMap(3);
            hashMap.put("reward_countdown", Long.valueOf(min));
            hashMap.put("event_tag", "rewarded_video");
            hashMap.put("reward_live_scene", Integer.valueOf(com.bytedance.sdk.openadsdk.core.live.xv.w.c(meVar)));
            return TTLiveCommerceHelper.getInstance().getRewardToLiveRoomCode(context, meVar, hashMap) == 0;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.gd gdVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.gd(this.f32502c, this.f32514w, z3);
        this.gd = gdVar;
        return gdVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void c(int i4, int i5, Intent intent) {
        super.c(i4, i5, intent);
        com.bytedance.sdk.component.utils.a.w("rewardAuthFlag", "req code = " + i4);
        if (i4 != 1) {
            this.f32502c.finish();
        } else if (intent != null && intent.getExtras() != null) {
            long j4 = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
            com.bytedance.sdk.component.utils.a.w("rewardAuthFlag", "rew liv cd = " + j4);
            if (j4 <= 0) {
                int i6 = intent.getExtras().getInt("csj.reward_auth_status", 0);
                com.bytedance.sdk.component.utils.a.w("rewardAuthFlag", "rew aut status = " + i6);
                com.bytedance.sdk.component.utils.a.w("rewardAuthFlag", "rew aut scene = " + this.xk);
                if (this.xk && i6 == 1) {
                    com.bytedance.sdk.component.utils.a.w("rewardAuthFlag", "rew no fin auth");
                    this.f32502c.finish();
                    return;
                }
                com.bytedance.sdk.component.utils.a.f("rewardAuthFlag", "verify rew....");
                this.f32502c.sr(0);
                ev(true);
                this.f32502c.wx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.p.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p.this.ng();
                    }
                }, 2000L);
                return;
            }
            this.f32502c.finish();
        } else {
            this.f32502c.finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void c(int i4) {
        super.c(i4);
        if (i4 == 0) {
            ng();
        }
    }
}
