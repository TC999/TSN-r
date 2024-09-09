package com.bytedance.sdk.openadsdk.core.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.stub.StubApp;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile r f32477c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile r f32478w;

    /* renamed from: f  reason: collision with root package name */
    private long f32479f;

    /* renamed from: r  reason: collision with root package name */
    private final Map<me, Long> f32480r = Collections.synchronizedMap(new HashMap());
    private boolean sr;
    private final w ux;
    private final Context xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c<T> {
        void c(boolean z3, T t3);
    }

    private r(Context context, boolean z3) {
        this.sr = true;
        this.xv = context == null ? ls.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.sr = z3;
        this.ux = new w(z3 ? "sp_reward_video" : "sp_full_screen_video");
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.w sr(String str) {
        return this.ux.f(str);
    }

    public me ux(String str) {
        int sr = this.ux.sr(str);
        boolean xv = this.ux.xv(str);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z3 = currentTimeMillis < xv(str);
        if (!xv && sr == 6106) {
            String c4 = this.ux.c(str);
            if (TextUtils.isEmpty(c4)) {
                return null;
            }
            try {
                me c5 = com.bytedance.sdk.openadsdk.core.w.c(new JSONObject(com.bytedance.sdk.component.utils.c.xv(c4)));
                if (c5 == null) {
                    return null;
                }
                long lp = c5.lp() * 1000;
                if (lp > 0 || z3) {
                    if (lp <= 0 || currentTimeMillis <= lp) {
                        c5.f(true);
                        c5.me(101);
                        if (u.ux(c5)) {
                            if (this.sr && !TextUtils.isEmpty(str) && str.endsWith("again")) {
                                return null;
                            }
                            return c5;
                        } else if (!com.bytedance.sdk.openadsdk.core.video.xv.c.c(c5) && ng.bk(c5) == null) {
                            return null;
                        } else {
                            return c5;
                        }
                    }
                    return null;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public long w() {
        return 10500000L;
    }

    public String w(String str) {
        long xv = ls.w().xv(str);
        if (xv <= 0 || System.currentTimeMillis() - this.f32479f >= xv) {
            me ux = ux(str);
            if (ux != null) {
                if (ux.j() + ux.a() < System.currentTimeMillis()) {
                    c(str);
                    return "1";
                }
                JSONObject c4 = c(ux);
                if (c4 != null) {
                    this.f32479f = System.currentTimeMillis();
                    return c4.toString();
                }
                return "0";
            }
            return "0";
        }
        return "1";
    }

    public long xv(String str) {
        return this.ux.w(str) + w();
    }

    public static r c(Context context, boolean z3) {
        if (z3) {
            if (f32477c == null) {
                synchronized (r.class) {
                    if (f32477c == null) {
                        f32477c = new r(context, true);
                    }
                }
            }
            return f32477c;
        }
        if (f32478w == null) {
            synchronized (r.class) {
                if (f32478w == null) {
                    f32478w = new r(context, false);
                }
            }
        }
        return f32478w;
    }

    public void w(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.ux.w(wVar);
    }

    public void w(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(wVar, str);
    }

    public void c(String str) {
        this.ux.ux(str);
    }

    public void c() {
        File xv;
        File[] listFiles;
        try {
            ba.c("sp_full_screen_video").w();
            ba.c("sp_reward_video").w();
        } catch (Throwable unused) {
        }
        try {
            if (("mounted".equals(com.bytedance.sdk.openadsdk.n.xv.c()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.openadsdk.api.plugin.w.xv(this.xv) != null) {
                xv = com.bytedance.sdk.openadsdk.api.plugin.w.xv(this.xv);
            } else {
                xv = com.bytedance.sdk.openadsdk.api.plugin.w.w(this.xv);
            }
            if (xv == null || !xv.exists() || !xv.isDirectory() || (listFiles = xv.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null) {
                        return file.getName().contains("reward_video_cache");
                    }
                    return false;
                }
            })) == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                try {
                    com.bytedance.sdk.component.utils.f.xv(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    private File c(String str, int i4) {
        return new File(com.bytedance.sdk.openadsdk.n.ev.c(i4).c(), str);
    }

    private JSONObject c(me meVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", meVar.ia());
            jSONObject.put("aid", Long.valueOf(meVar.zb()));
            jSONObject.put(BidResponsedEx.KEY_CID, Long.valueOf(meVar.jr()));
            jSONObject.put(BidResponsed.KEY_PRICE, meVar.q());
            jSONObject.put("material_key", meVar.u());
            jSONObject.put("s_send_ts", meVar.j());
            jSONObject.put("cache_time", meVar.a());
            jSONObject.put("ext", meVar.bk());
            return jSONObject;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, me meVar) {
        c(wVar);
        if (meVar != null) {
            try {
                this.ux.c(wVar.f(), com.bytedance.sdk.component.utils.c.w(meVar.mo().toString()));
            } catch (Throwable unused) {
            }
        }
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.ux.c(wVar);
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.w c(boolean z3) {
        return this.ux.c(z3);
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str) {
        this.ux.c(wVar, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3, me meVar, long j4, String str) {
        Long remove = this.f32480r.remove(meVar);
        long elapsedRealtime = remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue();
        com.bytedance.sdk.openadsdk.core.a.xv.ux(meVar, this.sr ? "rewarded_video" : "fullscreen_interstitial_ad", z3 ? "load_video_success" : "load_video_error", wv.c(z3, meVar, elapsedRealtime, j4, (z3 || str == null) ? null : str));
    }

    public void c(final me meVar, final c<Object> cVar) {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            return;
        }
        this.f32480r.put(meVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (!TextUtils.isEmpty(ng.c(meVar))) {
            if (cVar != null) {
                cVar.c(false, null);
            }
            c(false, meVar, -1L, " meta == null or meta.getVideo() == null ");
            return;
        }
        String c4 = ng.c(meVar);
        File c5 = c(ng.f(meVar), meVar.ou());
        com.bytedance.sdk.component.ev.w.c sr = com.bytedance.sdk.openadsdk.core.q.ux.c().w().sr();
        sr.c(c4);
        sr.c(c5.getParent(), c5.getName());
        sr.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.2
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                if (wVar.ev() && wVar.r() != null && wVar.r().exists()) {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(true, null);
                    }
                    com.bytedance.sdk.component.utils.a.xv("RewardFullAdCache", "onResponse: RewardFullVideo preload success ");
                    r.this.c(true, meVar, wVar.c(), wVar.w());
                    return;
                }
                c cVar3 = cVar;
                if (cVar3 != null) {
                    cVar3.c(false, null);
                }
                com.bytedance.sdk.component.utils.a.xv("RewardFullAdCache", "onResponse: RewardFullVideo preload fail ");
                r.this.c(false, meVar, wVar.c(), wVar.w());
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(false, null);
                }
                com.bytedance.sdk.component.utils.a.xv("RewardFullAdCache", "onFailure: RewardFullVideo preload fail ");
                r.this.c(false, meVar, -2L, iOException.getMessage());
            }
        });
    }
}
