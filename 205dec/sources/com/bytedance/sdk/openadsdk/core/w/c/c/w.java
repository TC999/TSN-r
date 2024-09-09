package com.bytedance.sdk.openadsdk.core.w.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.component.p.c.w;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wx;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.openadsdk.core.w.c.c {

    /* renamed from: f  reason: collision with root package name */
    sr f35291f;
    ux ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.w.c.c.w$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class AnonymousClass2 implements com.bytedance.sdk.component.p.sr.xv {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONArray f35294c;

        AnonymousClass2(JSONArray jSONArray) {
            this.f35294c = jSONArray;
        }

        @Override // com.bytedance.sdk.component.p.sr.xv
        public void c(com.bytedance.sdk.component.p.c.c cVar) {
            cVar.c(new com.bytedance.sdk.component.p.sr.sr() { // from class: com.bytedance.sdk.openadsdk.core.w.c.c.w.2.1
                @Override // com.bytedance.sdk.component.p.sr.sr
                public com.bytedance.sdk.component.p.sr.f w() {
                    return null;
                }

                @Override // com.bytedance.sdk.component.p.sr.sr
                public com.bytedance.sdk.component.p.sr.ux xv() {
                    return new com.bytedance.sdk.component.p.sr.ux() { // from class: com.bytedance.sdk.openadsdk.core.w.c.c.w.2.1.1
                        @Override // com.bytedance.sdk.component.p.sr.ux
                        public void c(com.bytedance.sdk.component.p.c.c cVar2) {
                        }

                        @Override // com.bytedance.sdk.component.p.sr.ux
                        public void c(com.bytedance.sdk.component.p.c.c cVar2, String str) {
                        }

                        @Override // com.bytedance.sdk.component.p.sr.ux
                        public void c(com.bytedance.sdk.component.p.c.c cVar2, Map<String, Object> map) {
                            try {
                                String c4 = cVar2.r().c();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", c4);
                                jSONObject.put("status", true);
                                AnonymousClass2.this.f35294c.put(jSONObject);
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        }

                        @Override // com.bytedance.sdk.component.p.sr.ux
                        public void w(com.bytedance.sdk.component.p.c.c cVar2, Map<String, Object> map) {
                            try {
                                String c4 = cVar2.r().c();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", c4);
                                jSONObject.put("status", false);
                                AnonymousClass2.this.f35294c.put(jSONObject);
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        }
                    };
                }
            });
        }

        @Override // com.bytedance.sdk.component.p.sr.xv
        public void c(com.bytedance.sdk.component.p.c.w wVar) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(View view, int i4);
    }

    public w() {
        ux uxVar = new ux();
        this.ux = uxVar;
        this.f35291f = new sr(uxVar);
    }

    private void f() {
        if (this.ux.ux()) {
            com.bytedance.sdk.openadsdk.u.c.w.c.c r3 = this.ux.r();
            if (!wv.w(this.f35278c) || r3 == null) {
                return;
            }
            r3.w();
        }
    }

    private boolean ux(Map<String, Object> map) {
        String fz;
        TTLiveCommerceHelper tTLiveCommerceHelper = TTLiveCommerceHelper.getInstance();
        if (tTLiveCommerceHelper.canOpenGoodsDetailPage(this.f35278c) == 1) {
            return false;
        }
        if (map == null) {
            map = new HashMap<>(1);
        }
        int rewardToLiveRoomCode = tTLiveCommerceHelper.getRewardToLiveRoomCode(this.ux) & 255;
        if (rewardToLiveRoomCode == 0) {
            map.put("key_live_commerce_jump", Integer.valueOf(rewardToLiveRoomCode));
            this.ux.ia();
            return false;
        }
        HashMap hashMap = new HashMap(3);
        ux uxVar = this.ux;
        hashMap.put("event_tag", uxVar != null ? uxVar.k() : "");
        gd gdVar = this.xv;
        if (gdVar != null && (fz = gdVar.fz()) != null) {
            hashMap.put("dpa_tag", fz);
        }
        TTLiveCommerceHelper.getInstance().convertViewTagToAction(this.sr, this.f35278c.sk(), hashMap, map);
        int canOpenLive = tTLiveCommerceHelper.canOpenLive(this.f35279w, this.f35278c, hashMap);
        int i4 = canOpenLive & 255;
        int i5 = (canOpenLive & 65280) >> 8;
        map.put("key_live_commerce_jump", Integer.valueOf(i4));
        if (i5 > 0) {
            map.put("click_saas_action", Integer.valueOf(i5));
        }
        if (i4 == 0) {
            return false;
        }
        return xv(map);
    }

    public void sr(boolean z3) {
        this.ux.w(z3);
    }

    public void w(Map<String, Object> map) {
        this.ux.c(map);
    }

    public void xv(boolean z3) {
        this.ux.xv(z3);
    }

    boolean xv(Map<String, Object> map) {
        return false;
    }

    private boolean sr() {
        boolean dd = this.f35278c.dd();
        Map<String, Object> p3 = this.ux.p();
        p3.put("valid_uchain", Boolean.valueOf(dd));
        boolean z3 = false;
        if (dd) {
            String i4 = this.xv.i();
            if (TextUtils.isEmpty(i4)) {
                return false;
            }
            p3.put("click_from_uchain", 1);
            p3.put("event_type", i4);
            wv.gb();
            HashMap hashMap = new HashMap();
            hashMap.put("material_meta", this.f35278c);
            hashMap.put("dpa_tag", this.xv.fz());
            hashMap.put("context", this.f35279w);
            hashMap.put("event_tag", this.ux.k());
            hashMap.put("source", Integer.valueOf(this.ux.gd()));
            com.bytedance.sdk.openadsdk.core.p.w.xv ev = this.ux.ev();
            hashMap.put("download_adapter", ev);
            if (ev != null && ev.w()) {
                z3 = true;
            }
            hashMap.put("is_market_covert", Boolean.valueOf(z3));
            com.bytedance.sdk.component.p.ux.c c4 = com.bytedance.sdk.component.p.ux.c.c();
            hashMap.putAll(c4.c(this.f35278c.hashCode() + this.f35278c.xq()));
            Boolean bool = Boolean.FALSE;
            hashMap.put("convert_from_downloader", bool);
            hashMap.put("convert_from_landing_page", Boolean.valueOf(this.ux.xv()));
            com.bytedance.sdk.openadsdk.core.ev.c.c.w.c cVar = new com.bytedance.sdk.openadsdk.core.ev.c.c.w.c(this.f35278c, this.f35279w, this.ux.k(), this.ux.gd());
            cVar.w(c(this.f35278c, this.ux.bk()));
            cVar.c(this.ux.ux());
            cVar.xv(this.ux.a());
            hashMap.put("is_open_web_page", bool);
            cVar.w(hashMap);
            hashMap.put("activity_type", Integer.valueOf(wv.c(cVar.w())));
            int c5 = cVar.c();
            if (c5 != Integer.MIN_VALUE) {
                this.ux.p().put("play_percent", Integer.valueOf(c5));
            }
            JSONArray jSONArray = new JSONArray();
            new w.c(i4).c(this.f35278c.mo()).c(hashMap).c(new AnonymousClass2(jSONArray)).c().c();
            JSONObject jSONObject = new JSONObject();
            UUID randomUUID = UUID.randomUUID();
            p3.put("uchain_event_id", randomUUID);
            try {
                jSONObject.put("uchain_event_id", randomUUID);
                jSONObject.put("clickEvent", jSONArray);
                com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f35278c, this.ux.k(), "uchain_event_tracker", jSONObject);
            } catch (JSONException unused) {
            }
            return true;
        }
        return false;
    }

    private void xv(int i4) {
        if (this.ux.ux()) {
            this.ux.c(i4);
        }
    }

    public void c(int i4) {
        this.ux.w(i4);
    }

    public void w(int i4) {
        this.ux.xv(i4);
    }

    public void c(String str) {
        this.ux.c(str);
    }

    public void w(boolean z3) {
        this.ux.sr(z3);
    }

    public void c(boolean z3) {
        this.ux.c(z3);
    }

    public ux w() {
        return this.ux;
    }

    public sr xv() {
        return this.f35291f;
    }

    public void c(me meVar) {
        this.f35278c = meVar;
        this.ux.c(meVar);
    }

    public void c(Context context) {
        this.f35279w = context;
        this.ux.c(context);
    }

    public void c(com.bytedance.sdk.openadsdk.core.p.w.xv xvVar) {
        this.ux.c(xvVar);
    }

    public com.bytedance.sdk.openadsdk.core.p.w.xv c() {
        return this.ux.ev();
    }

    public void c(Object obj) {
        this.ux.c(obj);
    }

    public void c(com.bytedance.sdk.openadsdk.u.c.w.c.c cVar) {
        this.ux.c(cVar);
    }

    public void c(c cVar) {
        this.ux.c(cVar);
    }

    public void c(long j4) {
        this.ux.c(j4);
    }

    public void c(com.bytedance.sdk.openadsdk.core.video.w.w wVar) {
        this.ux.c(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(Map<String, Object> map) {
        me meVar;
        if (this.f35279w == null) {
            this.f35279w = ls.getContext();
        }
        if (this.f35279w == null || (meVar = this.f35278c) == null) {
            return true;
        }
        xv(meVar.v());
        ux();
        final c c4 = this.ux.c();
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.c.w.1
            @Override // java.lang.Runnable
            public void run() {
                c cVar = c4;
                if (cVar != null) {
                    cVar.c(((com.bytedance.sdk.openadsdk.core.w.c.c) w.this).sr, w.this.ux.sr());
                }
            }
        });
        boolean ux = sr() ? false : ux(map);
        f();
        return ux;
    }

    private void ux() {
        if (this.ux.xv() && this.ux.ux()) {
            com.bytedance.sdk.openadsdk.core.p.w.xv ev = this.ux.ev();
            if (ev instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) {
                ((com.bytedance.sdk.openadsdk.core.p.xv.f) ev).w(true);
            }
        }
    }

    public static boolean c(me meVar, Object obj) {
        return u.sr(meVar) && !(obj == null && meVar.yx() == 100.0f) && wx.i(meVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sr(Map<String, Object> map) {
        View view = this.sr;
        if (view == null) {
            return;
        }
        Object tag = view.getTag(2114387593);
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            map.put("reward_browse_banner_from", Boolean.TRUE);
        }
    }
}
