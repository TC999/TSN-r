package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.r.c.xv;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.component.reward.c.w.c;
import com.bytedance.sdk.openadsdk.core.component.reward.c.w.w;
import com.bytedance.sdk.openadsdk.core.component.reward.ev;
import com.bytedance.sdk.openadsdk.core.component.reward.k;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.ux;
import com.bytedance.sdk.openadsdk.core.component.reward.w.f;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.q;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.pr;
import com.bytedance.sdk.openadsdk.core.u.yu;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private String au;

    /* renamed from: b  reason: collision with root package name */
    private xv f32196b;
    private int bj;
    protected int bw;
    private String mt;
    private String oo;

    /* renamed from: x  reason: collision with root package name */
    private final int f32198x = 10111;

    /* renamed from: m  reason: collision with root package name */
    private final int f32197m = 10112;
    private final int gw = 10113;
    private final int vc = 10114;
    private final int up = 10115;
    private final AtomicBoolean bm = new AtomicBoolean();
    private final c wo = new w(new c.InterfaceC0477c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
        @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.InterfaceC0477c
        public me c() {
            return TTRewardVideoActivity.this.ba;
        }

        @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.InterfaceC0477c
        public Activity getActivity() {
            return TTRewardVideoActivity.this.f32167z;
        }

        @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.InterfaceC0477c
        public void sr() {
            TTRewardVideoActivity.this.x();
        }

        @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.InterfaceC0477c
        public void ux() {
            f fVar = TTRewardVideoActivity.this.ls;
            if (fVar != null) {
                fVar.r();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.InterfaceC0477c
        public String w() {
            return TTRewardVideoActivity.this.eq;
        }

        @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.InterfaceC0477c
        public void xv() {
            TTRewardVideoActivity.super.ux();
        }

        @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.InterfaceC0477c
        public void c(int i4, TTProgressBar tTProgressBar) {
            try {
                TTRewardVideoActivity.this.ia.c(i4, tTProgressBar);
            } catch (Exception unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.InterfaceC0477c
        public void c(boolean z3, String str, String str2) {
            if (u.ux(TTRewardVideoActivity.this.ba)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("visible", z3);
                jSONObject.put("entrance_text", yu.c(TTRewardVideoActivity.this.ba, str, str2));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            TTRewardVideoActivity.this.fz.c("showPlayAgainEntrance", jSONObject);
            TTRewardVideoActivity.this.f32159q.c(jSONObject);
            if (TTRewardVideoActivity.this.f32159q.yu()) {
                return;
            }
            TTRewardVideoActivity.this.f32153i.r(z3);
            TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
            tTRewardVideoActivity.f32153i.c(yu.c(tTRewardVideoActivity.ba, str, str2));
        }
    });

    @DungeonFlag
    private int h() {
        final int i4 = 0;
        if (m.sr(this.ba) && !ok()) {
            i4 = 10111;
        }
        if (ls.w().tx() == 0) {
            return i4;
        }
        boolean f4 = q.f();
        int c4 = q.c(this.ba.hk() + "_" + this.ba.qq());
        if (f4) {
            i4 = 10115;
        } else if (c4 == q.f33289w) {
            i4 = 10114;
        } else if (c4 == q.xv) {
            i4 = 10113;
        }
        a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.openadsdk.core.fz.c.xv<com.bytedance.sdk.openadsdk.core.fz.c.xv> w3 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w();
                w3.c("armor_reward");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", i4);
                w3.w(jSONObject.toString());
                return w3;
            }
        }, "armor_reward");
        return i4;
    }

    private void ng() {
        ux uxVar;
        if (m.r(this.ba) && this.ls.q() >= m.p(this.ba)) {
            if (this.ck.r() && (uxVar = this.fz) != null && uxVar.gd() == 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("toast_text", m.gd(this.ba));
                    this.fz.c("showToast", jSONObject);
                    return;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            xk.c(this.f32167z, m.gd(this.ba));
        }
    }

    private void oh() {
        this.fz.c("cancelClickLandingRewardTip", (JSONObject) null);
    }

    private boolean ok() {
        if (TextUtils.isEmpty(this.ba.xq())) {
            return false;
        }
        return this.bm.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public int ba() {
        if (this.bj != 0 && !TextUtils.isEmpty(this.au)) {
            return this.bj;
        }
        if (m.w(this.ba) == 0 || TextUtils.isEmpty(m.c(this.ba))) {
            return 0;
        }
        return m.w(this.ba);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean ck() {
        return super.ck() || this.wo.ux();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String eq() {
        if (this.wo.c() && !TextUtils.isEmpty(this.wo.r()) && !TextUtils.isEmpty(this.wo.f())) {
            return this.wo.r();
        }
        return ba() + "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void gd(int i4) {
        if (!this.ux.containsKey(0)) {
            this.f32164w.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(TTRewardVideoActivity.this.f32167z, "\u5f53\u524d\u4e0d\u6ee1\u8db3\u6761\u4ef6\uff0c\u4e0b\u6b21\u8bb0\u5f97\u770b\u5b8c\u89c6\u9891\u54e6\uff5e", 1).show();
                }
            });
        } else if (pr.c(this.ba)) {
            this.f32164w.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(TTRewardVideoActivity.this.f32167z, "\u975e\u5e38\u62b1\u6b49\uff0c\u5f53\u524d\u4e0d\u652f\u6301\u518d\u770b\u4e00\u4e2a", 1).show();
                }
            });
        } else {
            this.wo.xv(i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String me() {
        if (this.wo.c() && !TextUtils.isEmpty(this.wo.r()) && !TextUtils.isEmpty(this.wo.f())) {
            return this.wo.f();
        }
        return y() + "";
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (this.f32159q.yu()) {
            return;
        }
        this.ck.c(i4, i5, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        xv xvVar;
        super.onDestroy();
        this.wo.xv();
        List<xv> c4 = com.bytedance.sdk.component.r.w.c.c();
        if (c4 == null || c4.size() == 0 || (xvVar = this.f32196b) == null) {
            return;
        }
        c4.remove(xvVar);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (this.wo.w()) {
            super.ux();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (m.ia(this.ba)) {
            this.xk += com.bytedance.sdk.openadsdk.core.r.xv.f34518w;
            com.bytedance.sdk.openadsdk.core.r.xv.xv = false;
            com.bytedance.sdk.openadsdk.core.r.xv.f34518w = 0;
            com.bytedance.sdk.openadsdk.core.r.xv.f34517c = this.ck.pr();
            xv(0);
        }
        if (m.fz(this.ba) && com.bytedance.sdk.openadsdk.core.r.xv.sr) {
            oh();
            sr(4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void p() {
        if (bw.c(this.ba)) {
            this.f32153i.w(this.ck.yu());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void r() {
        xv xvVar = new xv() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
            @Override // com.bytedance.sdk.component.r.c.xv
            public void c(String str, String str2) {
                me meVar = TTRewardVideoActivity.this.ba;
                if (meVar != null) {
                    String xq = meVar.xq();
                    if (TextUtils.equals("show", str) && TextUtils.equals(str2, xq)) {
                        TTRewardVideoActivity.this.bm.set(true);
                    }
                }
            }
        };
        this.f32196b = xvVar;
        com.bytedance.sdk.component.r.w.c.c(xvVar);
        super.r();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void sr(final int i4) {
        if (this.ux.containsKey(Integer.valueOf(i4))) {
            return;
        }
        this.ux.put(Integer.valueOf(i4), Boolean.TRUE);
        this.f32157n.xv();
        boolean z3 = !m.gb(this.ba);
        final int ba = ba();
        final String y3 = y();
        int h4 = h();
        boolean z4 = h4 == 0;
        if (z4 && !z3) {
            w(i4, true);
            ls.c().c(c(i4, z4), new ck.ux() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.core.ck.ux
                public void c(int i5, String str) {
                    TTRewardVideoActivity.this.xv(TTRewardVideoActivity.this.c(i4, false, i5, str, ba, y3, false));
                }

                @Override // com.bytedance.sdk.openadsdk.core.ck.ux
                public void c(z.sr srVar) {
                    int c4 = srVar.xv.c();
                    String w3 = srVar.xv.w();
                    TTRewardVideoActivity.this.xv(srVar.f35781w ? TTRewardVideoActivity.this.c(i4, true, 10111, "reward failed", c4, w3, true) : TTRewardVideoActivity.this.c(i4, false, 10112, "server refuse", c4, w3, true));
                }
            });
            return;
        }
        xv(c(i4, z4, h4, "reward failed", ba, y3, false));
        w(i4, z4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void up() {
        if (m.ia(this.ba) || this.f32159q.eq() || fp.sr(this.ba)) {
            return;
        }
        if (this.ls.yu()) {
            this.f32153i.c(false, null, "\u8df3\u8fc7", false, true);
            return;
        }
        int f4 = this.ck.f(true);
        int f5 = this.ck.f(false);
        if (!xu() && !this.ck.ia()) {
            com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = this.f32153i;
            uxVar.c(false, f5 + "s", null, false, false);
        } else {
            com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar2 = this.f32153i;
            uxVar2.c(false, f5 + "s", "\u8df3\u8fc7", false, true);
        }
        this.ck.w(f4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void ux() {
        if (this.ux.containsKey(0) && this.wo.xv(2)) {
            return;
        }
        super.ux();
    }

    public boolean xu() {
        return Math.round(((float) (this.ls.me() + (((long) this.xk) * 1000))) / 1000.0f) >= this.yu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String y() {
        if (this.bj == 0 || TextUtils.isEmpty(this.au)) {
            return (m.w(this.ba) == 0 || TextUtils.isEmpty(m.c(this.ba))) ? "" : m.c(this.ba);
        }
        return this.au;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void w() {
        if (this.wo.c() || this.fp) {
            return;
        }
        k.c(ls.getContext()).f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void xv(int i4) {
        if (this.ux.containsKey(Integer.valueOf(i4))) {
            return;
        }
        if (i4 != 0) {
            sr(i4);
        } else if (this.ck.yu() <= 0 && this.ck.eq()) {
            sr(i4);
        }
    }

    private void w(int i4, boolean z3) {
        if (i4 == 0) {
            this.gb.w(z3);
            this.wo.sr();
            ng();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void c(Intent intent) {
        super.c(intent);
        if (intent == null) {
            return;
        }
        this.mt = intent.getStringExtra("media_extra");
        this.oo = intent.getStringExtra("user_id");
        this.au = intent.getStringExtra("reward_name");
        this.bj = intent.getIntExtra("reward_amount", 0);
        this.wo.c(intent.getBooleanExtra("is_play_again", false));
        this.wo.c(intent.getIntExtra("play_again_count", 0));
        this.wo.w(intent.getBooleanExtra("custom_play_again", false));
        this.wo.w(intent.getIntExtra("source_rit_id", 0));
        this.wo.c(intent.getStringExtra("reward_again_name"));
        this.wo.w(intent.getStringExtra("reward_again_amount"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void xv() {
        if (this.xv.getAndSet(true) || this.wo.c()) {
            return;
        }
        c("onAdClose");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(Bundle bundle) {
        int i4 = bundle.getInt("callback_extra_key_reward_type");
        if (i4 == 0) {
            c("onRewardVerify", bundle);
        }
        c("onRewardArrived", bundle);
        this.f32157n.c(bundle);
        this.ck.c(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean c(Bundle bundle) {
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        c4.c("is_reward_deep_link_to_live", false);
        c4.c("click_to_live_duration", System.currentTimeMillis());
        return super.c(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean c(long j4, boolean z3) {
        com.bytedance.sdk.component.utils.a.w("TTRewardVideoActivity", "bindVideoAd execute");
        this.ls.c(this.wx);
        this.ls.c(this.ck.s(), this.f32151c, c());
        this.ls.c(a());
        if (this.ck.f()) {
            this.fz.c(this.ls.x());
        }
        this.ls.c(this.pr);
        boolean w3 = w(j4, z3);
        if (w3 && !z3) {
            this.bw = (int) (System.currentTimeMillis() / 1000);
        }
        return w3;
    }

    @DungeonFlag
    private JSONObject c(int i4, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", y());
            jSONObject.put("reward_amount", ba());
            jSONObject.put("network", ys.xv(ls.getContext()));
            jSONObject.put("sdk_version", eq.xv);
            jSONObject.put("user_agent", wv.f());
            jSONObject.put("extra", this.ba.wt());
            jSONObject.put("media_extra", this.mt);
            jSONObject.put("video_duration", this.ls.y());
            jSONObject.put("play_start_ts", this.bw);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put("duration", this.ls.q());
            jSONObject.put("user_id", this.oo);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            jSONObject.put("reward_type", i4);
            if (m.sr(this.ba)) {
                jSONObject.put("show_result", z3 ? 1 : 0);
            }
            com.bytedance.sdk.openadsdk.t.c.c(this.f32167z, jSONObject);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public Bundle c(int i4, boolean z3, int i5, String str, int i6, String str2, boolean z4) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z3);
        bundle.putInt("callback_extra_key_reward_type", i4);
        bundle.putInt("callback_extra_key_reward_amount", i6);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", m.c(this.ba, i4));
        bundle.putBoolean("callback_extra_key_is_server_verify", z4);
        if (!z3) {
            bundle.putInt("callback_extra_key_error_code", i5);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i4 == 0 && m.r(this.ba) && this.ls.q() >= m.p(this.ba)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    private void c(String str, Bundle bundle) {
        ev.c(0, this.wo.c() ? yu.c(this.eq) : this.eq, str, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void c(String str) {
        c(str, (Bundle) null);
    }
}
