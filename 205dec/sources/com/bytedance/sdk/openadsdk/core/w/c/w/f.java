package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.u;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends w {

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.w.sr f35311f;

    /* renamed from: r  reason: collision with root package name */
    private int f35312r;
    private String ux;

    public f() {
    }

    public static boolean w(int i4) {
        switch (i4) {
            case 101:
            case 102:
            case 103:
                return true;
            default:
                return false;
        }
    }

    private boolean w(Map<String, Object> map) {
        String fz;
        if (this.f35312r < 2) {
            return false;
        }
        HashMap hashMap = new HashMap(2);
        if (w(this.f35312r)) {
            hashMap.put("live_saas_param_interaction_type", Integer.valueOf(this.f35312r));
        }
        hashMap.put("event_tag", this.ux);
        com.bytedance.sdk.openadsdk.core.u.gd gdVar = this.xv;
        if (gdVar != null && (fz = gdVar.fz()) != null) {
            hashMap.put("dpa_tag", fz);
        }
        TTLiveCommerceHelper.getInstance().convertViewTagToAction(this.sr, this.f35278c.sk(), hashMap, map);
        int canOpenLive = TTLiveCommerceHelper.getInstance().canOpenLive(this.f35279w, this.f35278c, hashMap);
        int i4 = canOpenLive & 255;
        int i5 = (65280 & canOpenLive) >> 8;
        map.put("key_live_commerce_jump", Integer.valueOf(i4));
        if (i5 > 0) {
            map.put("click_saas_action", Integer.valueOf(i5));
        }
        map.put("key_live_commerce_jump", Integer.valueOf(canOpenLive));
        if (i4 != 0) {
            return false;
        }
        xv(map);
        return true;
    }

    private void xv(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.w.sr srVar = this.f35311f;
        if (srVar != null) {
            try {
                com.bytedance.sdk.openadsdk.core.w.c.c.w wVar = (com.bytedance.sdk.openadsdk.core.w.c.c.w) srVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class);
                if (wVar != null && wVar.w() != null) {
                    final com.bytedance.sdk.openadsdk.core.w.c.c.ux w3 = wVar.w();
                    final w.c c4 = w3.c();
                    com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w.c cVar = c4;
                            if (cVar != null) {
                                cVar.c(((com.bytedance.sdk.openadsdk.core.w.c.c) f.this).sr, w3.sr());
                            }
                        }
                    });
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f35311f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(map)) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) this.f35311f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class)).c(map);
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.xv) this.f35311f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.xv.class)).c(map);
        }
    }

    public f(me meVar, Context context, com.bytedance.sdk.openadsdk.core.w.sr srVar) {
        this.f35278c = meVar;
        this.f35279w = context;
        this.f35311f = srVar;
        c();
    }

    public void c(String str) {
        this.ux = str;
    }

    public void c(u uVar) {
        try {
            int optInt = uVar.c().optInt("live_saas_param_interaction_type", -1);
            a.w("glsas", "lsit: " + optInt);
            this.f35312r = optInt;
            a.c("LiveSaasH5ClickHandler", uVar.c());
        } catch (Exception unused) {
        }
    }

    public void c(int i4) {
        a.w("glsas", "lsit: " + i4);
        this.f35312r = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(Map<String, Object> map) {
        boolean z3;
        try {
            z3 = w(map);
            try {
                a.w("glsas", "dr: " + z3);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z3 = false;
        }
        c();
        return z3;
    }

    public void c() {
        me meVar = this.f35278c;
        if (meVar != null) {
            this.f35312r = meVar.kp();
        } else {
            this.f35312r = -1;
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        f fVar;
        if (wVar == null) {
            fVar = null;
        } else {
            try {
                fVar = (f) wVar.c(f.class);
            } catch (NullPointerException unused) {
                return;
            }
        }
        if (fVar != null) {
            fVar.c();
        }
    }
}
