package com.bytedance.sdk.openadsdk.core.component.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ls;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.component.reward.r;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.z;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class gd {

    /* renamed from: c  reason: collision with root package name */
    protected Context f32379c;

    /* renamed from: w  reason: collision with root package name */
    protected AtomicBoolean f32380w = new AtomicBoolean(false);
    protected List<w> xv = Collections.synchronizedList(new ArrayList());
    protected final ls.c sr = new ls.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.gd.3
        @Override // com.bytedance.sdk.component.utils.ls.c
        public void c(Context context, Intent intent, boolean z3, int i4) {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || i4 == 0) {
                return;
            }
            Iterator<w> it = gd.this.xv.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.gd.ev.c(it.next(), 1);
                it.remove();
            }
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.gd$7  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f32391c;

        static {
            int[] iArr = new int[TTAdLoadType.values().length];
            f32391c = iArr;
            try {
                iArr[TTAdLoadType.LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32391c[TTAdLoadType.PRELOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void w();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    protected class w extends com.bytedance.sdk.component.gd.p {

        /* renamed from: c  reason: collision with root package name */
        me f32392c;

        /* renamed from: w  reason: collision with root package name */
        com.bytedance.sdk.openadsdk.ys.w.xv.w f32393w;

        /* JADX INFO: Access modifiers changed from: package-private */
        public w(me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
            super("RewardFull Task");
            this.f32392c = meVar;
            this.f32393w = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            me meVar = this.f32392c;
            if (meVar == null) {
                return;
            }
            gd.this.c(this.f32393w, meVar, (c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public gd(Context context) {
        this.f32379c = context == null ? com.bytedance.sdk.openadsdk.core.ls.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
        xv();
    }

    public static void ux() {
        try {
            r.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), false).c();
            r.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), true).c();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(w wVar) {
        if (wVar == null) {
            return;
        }
        if (this.xv.size() >= 1) {
            this.xv.remove(0);
        }
        this.xv.add(wVar);
    }

    abstract void c(me meVar);

    protected abstract void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar);

    protected abstract boolean c();

    public void f() {
        com.bytedance.sdk.openadsdk.n.f.c(new com.bytedance.sdk.component.gd.p("rewardFull preloadOnDestroy") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.gd.4
            @Override // java.lang.Runnable
            public void run() {
                r c4 = r.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), gd.this.c());
                com.bytedance.sdk.openadsdk.ys.w.xv.w c5 = c4.c(true);
                if (c5 == null || TextUtils.isEmpty(c5.f())) {
                    return;
                }
                me ux = c4.ux(c5.f());
                if (com.bytedance.sdk.openadsdk.core.ls.w().w(c5.f()) && ux != null) {
                    if (ux.j() + ux.a() < System.currentTimeMillis()) {
                        c4.c(c5.f());
                    }
                }
                if (ux == null) {
                    gd.this.c(c5);
                }
            }
        });
    }

    protected void finalize() throws Throwable {
        super.finalize();
        sr();
    }

    protected void sr() {
        if (this.f32380w.get()) {
            this.f32380w.set(false);
            ls.c(this.sr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(String str, me meVar) {
        try {
            gb kr = meVar.kr();
            if (kr == null || TextUtils.isEmpty(kr.c())) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.q.xv xvVar = new com.bytedance.sdk.openadsdk.core.q.xv(true);
            xvVar.c(str);
            xvVar.c(8);
            xvVar.xv(meVar.jr());
            xvVar.sr(meVar.cf());
            xvVar.w(wv.a(meVar));
            com.bytedance.sdk.openadsdk.r.w.c(kr).c(xvVar);
            c(meVar);
        } catch (Throwable unused) {
        }
    }

    protected void xv() {
        if (this.f32380w.get()) {
            return;
        }
        this.f32380w.set(true);
        ls.c(this.sr, this.f32379c);
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final me meVar, final c cVar) {
        if (ng.bk(meVar) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(1, meVar);
            c4.c("material_meta", meVar);
            c4.c("ad_slot", wVar);
            com.bytedance.sdk.openadsdk.core.video.sr.w.c(c4, new com.bykv.vk.openvk.component.video.api.ux.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.gd.1
                @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
                public void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar, int i4) {
                    com.bytedance.sdk.component.utils.a.xv("RewardFullLoadManager", "RewardFullLog: Cached ad onVideoPreloadSuccess");
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.w();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
                public void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar, int i4, String str) {
                    com.bytedance.sdk.component.utils.a.xv("RewardFullLoadManager", "RewardFullLog: Cached ad onVideoPreloadFail");
                    if (!ng.k(meVar)) {
                        com.bytedance.sdk.component.utils.a.xv("RewardFullLoadManager", "RewardFullLog: Cached ad onVideoPreloadFail and block onCached");
                        return;
                    }
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.w();
                    }
                }
            });
            return;
        }
        r.c(this.f32379c, c()).c(meVar, new r.c<Object>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.gd.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.c
            public void c(boolean z3, Object obj) {
                com.bytedance.sdk.component.utils.a.w("RewardFullLoadManager", "download video file: " + z3);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.w();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(String str, me meVar) {
        me ux;
        if (!com.bytedance.sdk.openadsdk.core.ls.w().w(str) || meVar == null || (ux = r.c(this.f32379c, c()).ux(str)) == null) {
            return false;
        }
        if (ux.j() + ux.a() < System.currentTimeMillis()) {
            r.c(this.f32379c, c()).c(str);
            return true;
        }
        if (!TextUtils.equals(ux.u(), meVar.u())) {
            if (com.bytedance.sdk.openadsdk.core.w.c(meVar, c() ? 7 : 8) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(meVar.fz());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.get(next);
                ux.wt().put(next, jSONObject.get(next));
            }
            ux.i(ux.wt().toString());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    public void w(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        com.bytedance.sdk.openadsdk.n.f.c(new com.bytedance.sdk.component.gd.p("full_reward_preload_wait") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.gd.5
            @Override // java.lang.Runnable
            public void run() {
                gd gdVar = gd.this;
                r.c(gdVar.f32379c, gdVar.c()).w(wVar);
            }
        });
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.w w(String str) {
        return r.c(this.f32379c, c()).sr(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, me meVar, boolean z3) {
        boolean z4;
        if (com.bytedance.sdk.openadsdk.core.ls.w().w(wVar.f())) {
            String j4 = wVar.j();
            if (meVar == null) {
                com.bytedance.sdk.openadsdk.core.fz.a.c().xv(3);
                return false;
            } else if (j4 == null) {
                com.bytedance.sdk.openadsdk.core.fz.a.c().xv(1);
                return false;
            } else {
                long a4 = meVar.a();
                String u3 = meVar.u();
                try {
                    if (TextUtils.isEmpty(j4)) {
                        com.bytedance.sdk.openadsdk.core.fz.a.c().xv(1);
                        return false;
                    }
                    JSONObject c4 = com.bytedance.sdk.openadsdk.core.xv.r.c(new JSONObject(j4), false, true);
                    if (c4 == null) {
                        com.bytedance.sdk.openadsdk.core.fz.a.c().xv(1);
                        return false;
                    }
                    z.c c5 = z.c.c(c4, wVar, null);
                    com.bytedance.sdk.openadsdk.core.u.c cVar = c5.ev;
                    if (cVar == null) {
                        com.bytedance.sdk.openadsdk.core.fz.a.c().xv(1);
                        return false;
                    }
                    cVar.xv(c4.toString());
                    List<me> w3 = c5.ev.w();
                    if (w3 == null) {
                        com.bytedance.sdk.openadsdk.core.fz.a.c().xv(1);
                        return false;
                    }
                    Iterator<me> it = w3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z4 = false;
                            break;
                        }
                        me next = it.next();
                        if (TextUtils.isEmpty(next.u())) {
                            com.bytedance.sdk.openadsdk.core.fz.a.c().xv(2);
                            return false;
                        } else if (!next.s()) {
                            com.bytedance.sdk.openadsdk.core.fz.a.c().xv(5);
                            return false;
                        } else if (TextUtils.equals(next.u(), u3)) {
                            meVar.n(next.iu());
                            z4 = true;
                            break;
                        }
                    }
                    if (!z4) {
                        com.bytedance.sdk.openadsdk.core.fz.a.c().xv(3);
                        return false;
                    } else if (meVar.j() + a4 < System.currentTimeMillis()) {
                        r.c(this.f32379c, z3).c(wVar.f());
                        com.bytedance.sdk.openadsdk.core.fz.a.c().xv(4);
                        return false;
                    } else {
                        return true;
                    }
                } catch (Exception e4) {
                    com.bytedance.sdk.openadsdk.core.fz.a.c().xv(1000);
                    e4.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    public void c(String str) {
        r.c(this.f32379c, c()).c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, me meVar) {
        if (meVar == null) {
            return;
        }
        new c.C0472c().ux(meVar.jr()).c(c() ? "rewarded_video" : "fullscreen_interstitial_ad").sr(meVar.cf()).w("get_preload_ad").c(new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.gd.6
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                if (wVar.gb() != null) {
                    int i4 = AnonymousClass7.f32391c[wVar.gb().ordinal()];
                    if (i4 == 1) {
                        jSONObject2.put("req_type", 3);
                    } else if (i4 != 2) {
                        jSONObject2.put("req_type", -1);
                    } else {
                        jSONObject2.put("req_type", 1);
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }
}
