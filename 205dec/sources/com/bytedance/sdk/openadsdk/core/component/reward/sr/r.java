package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.w;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.x;
import com.bytedance.sdk.openadsdk.core.u.z;
import com.bytedance.sdk.openadsdk.core.z;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends c {
    private com.bytedance.sdk.openadsdk.core.w.c pr;
    protected boolean wv;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.w wx;
    protected final AtomicBoolean xk;
    private boolean yu;

    public r(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity, meVar);
        this.wv = false;
        this.xk = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z3);
            com.bytedance.sdk.openadsdk.core.component.reward.layout.ux uxVar = this.f32508p;
            if (uxVar != null) {
                uxVar.c("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void h() {
        com.bytedance.sdk.openadsdk.core.w.r rVar;
        if (this.wv || (rVar = this.ev) == null) {
            return;
        }
        if (((com.bytedance.sdk.openadsdk.core.w.c.c.w) rVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).w().fp()) {
            this.wv = true;
            w(8, 0);
        } else if (bw.c(this.f32514w)) {
            int ux = bw.ux(this.f32514w);
            if (this.f32514w.fh() == 2) {
                w(0, -1);
            }
            if (ux != 3) {
                return;
            }
            long r3 = bw.r(this.f32514w) * 1000;
            if (this.f32509q.me() >= r3) {
                w(8, 0);
                oh();
                this.wv = true;
                return;
            }
            w(0, (int) ((r3 - this.f32509q.me()) / 1000));
        }
    }

    private void oh() {
        if (this.ev == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_auto_click", Boolean.TRUE);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.ev.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
        this.ev.c(null, new com.bytedance.sdk.openadsdk.core.u.gd());
    }

    private JSONObject ok() {
        JSONObject jSONObject = new JSONObject();
        z ed = this.f32514w.ed();
        if (ed == null) {
            return jSONObject;
        }
        String sr = ed.sr();
        if (TextUtils.isEmpty(sr)) {
            return jSONObject;
        }
        try {
            String optString = new JSONObject(sr).optString("token");
            jSONObject.put("req_id", ed.f());
            jSONObject.put("token", optString);
            jSONObject.put("action", "query_box");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    private void sr(int i4) {
        com.bytedance.sdk.openadsdk.core.w.r rVar = this.ev;
        if (rVar != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) rVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(i4);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.ux uxVar = this.f32507n;
        if (uxVar != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(i4);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.f fVar = this.gb;
        if (fVar != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(i4);
        }
    }

    public static int w(me meVar) {
        return 2;
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
        this.gd.xv(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public View gd() {
        if (this.xv == 2) {
            return com.bytedance.sdk.openadsdk.res.ux.fp(this.f32502c);
        }
        return com.bytedance.sdk.openadsdk.res.ux.ia(this.f32502c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public boolean ia() {
        if (this.yu) {
            return true;
        }
        if (TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(this.f32514w)) {
            return false;
        }
        return !bw.xv(this.f32514w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean mt() {
        return true;
    }

    public void ng() {
        if (bw.c(this.f32514w)) {
            z ed = this.f32514w.ed();
            if (ed != null || TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(this.f32514w)) {
                int yu = yu();
                if (ed != null) {
                    ed.c(yu);
                }
                sr(yu);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean oo() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public void ox() {
        if (f()) {
            this.f32504i.w(false);
            this.f32504i.ux(false);
            this.gd.f(8);
            this.gd.ux(8);
            this.gd.xv(8);
            return;
        }
        this.f32504i.w(this.f32514w.bx());
        this.f32504i.ux(true);
        this.gd.f(0);
        this.gd.ux(0);
        this.gd.xv(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void u() {
        super.u();
        ng();
        if (this.f32508p.f()) {
            return;
        }
        if (TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(this.f32514w)) {
            h();
        } else if (bw.c(this.f32514w) && this.wx == null && !com.bytedance.sdk.openadsdk.core.xv.c().w("is_reward_deep_link_to_live", false) && bw.ux(this.f32514w) != 1 && this.f32509q.me() >= bw.r(this.f32514w) * 1000) {
            this.xk.set(true);
            com.bytedance.sdk.openadsdk.core.component.reward.w.f fVar = this.f32509q;
            if (fVar != null && fVar.w()) {
                this.f32502c.x();
            }
            this.wx = new com.bytedance.sdk.openadsdk.core.component.reward.view.w(this.f32502c, this.f32514w, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.r.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.w.c
                public void c(Dialog dialog) {
                    r.this.wx.dismiss();
                    r.this.f32502c.m();
                    r.this.xk.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.w.c
                public void w(Dialog dialog) {
                    if (r.this.pr != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("is_auto_click", Boolean.TRUE);
                        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) r.this.pr.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
                        r.this.pr.c(null, new com.bytedance.sdk.openadsdk.core.u.gd());
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.f32502c, this.f32514w, this.f32501a, 7) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.r.3
                @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
                public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                    super.c(view, gdVar);
                    r.this.wx.dismiss();
                }
            };
            this.pr = cVar;
            this.f32502c.c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
            this.wx.c(this.pr);
            if (this.f32502c.isFinishing()) {
                return;
            }
            this.wx.show();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    public boolean up() {
        return mt() && this.f32514w.y() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public boolean y() {
        return this.xk.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void w(boolean z3) {
        super.w(z3);
        if (!com.bytedance.sdk.openadsdk.core.xv.c().w("is_reward_deep_link_to_live", false) || bw.xv(this.f32514w) || z3) {
            return;
        }
        ls.c().c(ok(), new ck.sr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.r.1
            @Override // com.bytedance.sdk.openadsdk.core.ck.sr
            public void c(int i4, String str) {
                r.this.ev(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.sr
            public void c(z.xv xvVar) {
                x xVar = xvVar.xv;
                if (xVar == null) {
                    return;
                }
                boolean c4 = xVar.c();
                r.this.ev(c4);
                if (c4) {
                    r.this.f32502c.sr(0);
                    if (r.this.f32508p.f()) {
                        return;
                    }
                    r.this.f32502c.wx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.r.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            r.this.f32504i.f();
                        }
                    });
                }
            }
        });
    }

    public static boolean c(me meVar) {
        return com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ev evVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ev(this.f32502c, this.f32514w, z3);
        this.gd = evVar;
        return evVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.c
    public void c(int i4, int i5, Intent intent) {
        super.c(i4, i5, intent);
        if (bw.xv(this.f32514w) || i4 != 1 || intent == null || intent.getExtras() == null || this.yu) {
            return;
        }
        long j4 = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int yu = (int) (yu() - j4);
        this.f32502c.k(yu);
        if (j4 <= 0) {
            ev(true);
            sr(0);
            this.yu = true;
            return;
        }
        c(yu);
    }

    private void w(int i4, int i5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = this.gd;
        if (wVar != null && (wVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ev)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ev) wVar).c(i4, i5);
        }
    }

    private void c(long j4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j4);
            com.bytedance.sdk.openadsdk.core.component.reward.layout.ux uxVar = this.f32508p;
            if (uxVar == null || !uxVar.f()) {
                return;
            }
            this.f32508p.c("rewardInnerLiveShowTime", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
