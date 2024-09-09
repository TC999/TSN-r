package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.os.Bundle;
import android.view.View;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private final TTBaseVideoActivity f32751c;
    private boolean sr = false;
    private View ux;

    /* renamed from: w  reason: collision with root package name */
    private me f32752w;
    private String xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c implements com.bytedance.sdk.openadsdk.ux.c.c {

        /* renamed from: c  reason: collision with root package name */
        private final int f32763c;

        /* renamed from: w  reason: collision with root package name */
        private final long f32764w;
        private final JSONObject xv;

        c(int i4, long j4, JSONObject jSONObject) {
            this.f32763c = i4;
            this.f32764w = j4;
            this.xv = jSONObject;
        }

        @Override // com.bytedance.sdk.openadsdk.ux.c.c
        public void c(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = this.xv;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.f32763c);
            jSONObject2.put("duration", this.f32764w);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        }
    }

    public xv(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f32751c = tTBaseVideoActivity;
    }

    private boolean ux() {
        me meVar = this.f32752w;
        return meVar == null || ia.gd(meVar) != 1;
    }

    public void c(me meVar, String str, View view) {
        if (this.sr) {
            return;
        }
        this.sr = true;
        this.f32752w = meVar;
        this.xv = str;
        this.ux = view;
    }

    @DungeonFlag
    protected JSONObject sr() {
        try {
            long ys = this.f32751c.bj().ys();
            int fp = this.f32751c.bj().fp();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", ys);
                jSONObject.put("percent", fp);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void w() {
        final JSONObject c4 = c(new JSONObject());
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f32752w, this.xv, "skip_endcard", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.xv.2
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("ad_extra_data", c4);
            }
        });
    }

    public void xv() {
        final JSONObject c4 = c(new JSONObject());
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f32752w, this.xv, "reward_arrived_begin", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.xv.3
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("ad_extra_data", c4);
            }
        });
    }

    @DungeonFlag
    private void w(View view, gd gdVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387608) {
            c("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387629) {
            c("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387878) {
            c("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387795) {
            c("click_play_logo", (JSONObject) null);
        } else if (view.getId() != 2114387648 && view.getId() != 2114387931 && view.getId() != 2114387964) {
            if (view.getId() == 2114387833) {
                c("click_start_play", sr());
            } else if (view.getId() == 2114387641) {
                c("click_video", sr());
            } else if (view.getId() == 2114387867) {
                c("fallback_endcard_click", sr());
            }
        } else {
            c("click_start_play_bar", sr());
        }
        xv(view, gdVar);
    }

    @DungeonFlag
    private void xv(View view, gd gdVar) {
        if (ux() || this.f32752w == null || view == null) {
            return;
        }
        if (view.getId() == 2114387608 || view.getId() == 2114387629 || view.getId() == 2114387878 || view.getId() == 2114387795 || view.getId() == 2114387648 || view.getId() == 2114387931 || view.getId() == 2114387964 || view.getId() == 2114387833 || view.getId() == 2114387641 || view.getId() == 2114387867) {
            int ev = xk.ev(ls.getContext());
            com.bytedance.sdk.openadsdk.core.a.xv.c("click_other", this.f32752w, new ev.c().f(gdVar.bk()).ux(gdVar.t()).sr(gdVar.ys()).xv(gdVar.fp()).w(System.currentTimeMillis()).c(0L).w(xk.c(this.ux)).c(xk.c((View) null)).xv(xk.xv(this.ux)).sr(xk.xv((View) null)).xv(gdVar.c()).sr(gdVar.w()).ux(gdVar.xv()).c(gdVar.gd()).w(k.sr().w() ? 1 : 2).c(ev).c(xk.f(ls.getContext())).w(xk.r(ls.getContext())).c(), this.xv, true, this.f32751c.gw(), -1, false);
        }
    }

    public JSONObject c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.f32751c.b() != null) {
                jSONObject.put("reward_full_scene_type", this.f32751c.b().ba());
                this.f32751c.b().c(jSONObject);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public void c(Map<String, Object> map) {
        if (map == null || this.f32751c.b() == null) {
            return;
        }
        map.put("reward_full_scene_type", Integer.valueOf(this.f32751c.b().ba()));
        this.f32751c.b().c(map);
    }

    public void c() {
        final JSONObject c4 = c(new JSONObject());
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f32752w, this.xv, "skip", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.xv.1
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("ad_extra_data", c4);
            }
        });
    }

    public void c(Bundle bundle) {
        int i4 = bundle.getInt("callback_extra_key_reward_type");
        boolean z3 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i5 = bundle.getInt("callback_extra_key_error_code");
        String string = bundle.getString("callback_extra_key_error_msg");
        boolean z4 = bundle.getBoolean("callback_extra_key_is_server_verify");
        String str = z3 ? "reward_arrived_success" : "reward_arrived_failed";
        final JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isRewardVerify", z3);
            jSONObject2.put("isServerCallback", z4);
            jSONObject2.put("rewardType", i4);
            jSONObject2.put("errorCode", i5);
            jSONObject2.put("errorMsg", string);
            jSONObject.put("reward_data_bundle", jSONObject2);
        } catch (Exception e4) {
            a.f("RewardFullEventManager", e4.getMessage());
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f32752w, this.xv, str, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.xv.4
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject3) throws JSONException {
                jSONObject3.put("ad_extra_data", xv.this.c(jSONObject));
            }
        });
    }

    public void c(String str, int i4, String str2) {
        final JSONObject c4 = c(new JSONObject());
        try {
            c4.put("dialog_type", i4);
            c4.put("template_url", str2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f32752w, this.xv, str, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.xv.5
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("ad_extra_data", xv.this.c(c4));
            }
        });
    }

    public void c(boolean z3, int i4, long j4) {
        new c.C0472c().ux(this.f32752w.jr()).c(this.xv).w(z3 ? "scroll_up" : "scroll_down").sr(this.f32752w.cf()).c(new c(i4, j4, c(new JSONObject())));
    }

    public void c(View view, gd gdVar) {
        try {
            w(view, gdVar);
        } catch (Exception e4) {
            a.f("RewardFullEventManager", "onClickReport error :" + e4.getMessage());
        }
    }

    public void c(String str, JSONObject jSONObject) {
        me meVar = this.f32752w;
        String str2 = this.xv;
        if (!this.f32751c.c()) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.core.a.xv.w(meVar, str2, str, jSONObject);
    }
}
