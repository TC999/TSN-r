package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.ia;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.p.w.xv f32695c;

    /* renamed from: f  reason: collision with root package name */
    private String f32696f;

    /* renamed from: r  reason: collision with root package name */
    private String f32699r;
    private TTBaseVideoActivity sr;
    private me ux;

    /* renamed from: w  reason: collision with root package name */
    View f32701w = null;
    final Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> xv = Collections.synchronizedMap(new HashMap());
    private long ev = 0;
    private long gd = 0;

    /* renamed from: p  reason: collision with root package name */
    private long f32698p = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f32697k = 0;

    /* renamed from: a  reason: collision with root package name */
    private long f32694a = 0;
    private long bk = 0;
    private boolean ys = true;
    private final xv fp = new xv();

    /* renamed from: t  reason: collision with root package name */
    private boolean f32700t = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0483c {
        void c(View view, gd gdVar);

        void c(String str, JSONObject jSONObject);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(boolean z3);

        void c(boolean z3, long j4, long j5, String str, String str2);

        void c(boolean z3, long j4, String str, String str2);

        void c(boolean z3, String str, String str2);

        void w(boolean z3, long j4, long j5, String str, String str2);

        void xv(boolean z3, long j4, long j5, String str, String str2);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class xv implements DownloadListener {

        /* renamed from: w  reason: collision with root package name */
        private boolean f32709w = true;

        public xv() {
        }

        public void c(boolean z3) {
            this.f32709w = z3;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
            c(this.f32709w);
            c.this.c(str, true);
            c.this.sr.c(1);
        }
    }

    public c(TTBaseVideoActivity tTBaseVideoActivity) {
        this.sr = tTBaseVideoActivity;
    }

    private void ev() {
        me meVar = this.ux;
        if (meVar == null || meVar.v() != 4) {
            return;
        }
        this.f32695c = com.bytedance.sdk.openadsdk.core.p.xv.c(this.sr, this.ux, this.f32696f);
    }

    public xv r() {
        return this.fp;
    }

    public void c(me meVar, String str, String str2) {
        if (this.f32700t) {
            return;
        }
        this.f32700t = true;
        this.ux = meVar;
        this.f32696f = str;
        ev();
        this.f32699r = str2;
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f32695c;
        if (xvVar != null) {
            xvVar.f();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : this.xv.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().f();
            }
        }
        try {
            c(this.f32699r);
        } catch (Throwable th) {
            a.xv("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    public void sr() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f32695c;
        if (xvVar != null) {
            xvVar.c(this.sr);
            this.f32695c.sr();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : this.xv.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().sr();
            }
        }
    }

    public void ux() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f32695c;
        if (xvVar != null) {
            xvVar.ux();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : this.xv.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().ux();
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.p.w.xv w() {
        return this.f32695c;
    }

    public boolean xv() {
        return this.f32695c != null;
    }

    public void c() {
        me meVar;
        if (this.f32695c == null && (meVar = this.ux) != null && meVar.v() == 4) {
            this.f32695c = com.bytedance.sdk.openadsdk.core.p.xv.c(this.sr, this.ux, this.f32696f);
        }
    }

    private void c(final String str) {
        ev.w(new p("executeMultiProcessAppDownloadCallBack") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.c(3).c(str, "recycleRes", 0L, 0L, "", "");
                } catch (Throwable th) {
                    a.xv("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected ia c(int i4) {
        return ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(i4));
    }

    public void c(final w wVar) {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f32695c;
        if (xvVar == null) {
            return;
        }
        xvVar.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.c.2
            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c() {
                boolean z3;
                a.w("RewardFullDownloadManager", "DownloadManager onIdle");
                if (System.currentTimeMillis() - c.this.ev > NativeExpressView.f34019s) {
                    z3 = true;
                    c.this.ev = System.currentTimeMillis();
                } else {
                    z3 = false;
                }
                w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.c(z3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void w(long j4, long j5, String str, String str2) {
                boolean z3;
                a.w("RewardFullDownloadManager", "DownloadManager onDownloadPaused");
                if (System.currentTimeMillis() - c.this.gd > NativeExpressView.f34019s) {
                    c.this.gd = System.currentTimeMillis();
                    z3 = true;
                } else {
                    z3 = false;
                }
                w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.w(z3, j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void xv(long j4, long j5, String str, String str2) {
                boolean z3;
                a.w("RewardFullDownloadManager", "DownloadManager onDownloadFailed");
                if (System.currentTimeMillis() - c.this.f32697k > NativeExpressView.f34019s) {
                    c.this.f32697k = System.currentTimeMillis();
                    z3 = true;
                } else {
                    z3 = false;
                }
                w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.xv(z3, j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, long j5, String str, String str2) {
                boolean z3;
                a.w("RewardFullDownloadManager", "DownloadManager onDownloadActive");
                if (System.currentTimeMillis() - c.this.f32698p > NativeExpressView.f34019s) {
                    c.this.f32698p = System.currentTimeMillis();
                    z3 = true;
                } else {
                    z3 = false;
                }
                w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.c(z3, j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, String str, String str2) {
                boolean z3;
                a.w("RewardFullDownloadManager", "DownloadManager onDownloadFinished");
                if (System.currentTimeMillis() - c.this.f32694a > NativeExpressView.f34019s) {
                    c.this.f32694a = System.currentTimeMillis();
                    z3 = true;
                } else {
                    z3 = false;
                }
                w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.c(z3, j4, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(String str, String str2) {
                boolean z3;
                a.w("RewardFullDownloadManager", "DownloadManager onInstalled");
                if (System.currentTimeMillis() - c.this.bk > NativeExpressView.f34019s) {
                    z3 = true;
                    c.this.bk = System.currentTimeMillis();
                } else {
                    z3 = false;
                }
                w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.c(z3, str, str2);
                }
            }
        });
    }

    public void c(String str, boolean z3) {
        if (this.xv.containsKey(str)) {
            com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.xv.get(str);
            if (xvVar != null) {
                if (z3) {
                    xvVar.c(k.c(this.ux));
                }
                if (xvVar instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) {
                    ((com.bytedance.sdk.openadsdk.core.p.xv.f) xvVar).c().c(this.ys);
                } else if (xvVar instanceof com.bytedance.sdk.openadsdk.core.p.xv.gd) {
                    ((com.bytedance.sdk.openadsdk.core.p.xv.gd) xvVar).c().c(this.ys);
                }
                xvVar.c(me.ux(this.ux));
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(this.sr, str, this.ux, this.f32696f);
        if (z3) {
            c4.c(k.c(this.ux));
        }
        if (c4 instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) {
            ((com.bytedance.sdk.openadsdk.core.p.xv.f) c4).c().c(this.ys);
        } else if (c4 instanceof com.bytedance.sdk.openadsdk.core.p.xv.gd) {
            ((com.bytedance.sdk.openadsdk.core.p.xv.gd) c4).c().c(this.ys);
        }
        this.xv.put(str, c4);
        c4.c(me.ux(this.ux));
    }

    public void c(boolean z3) {
        this.ys = z3;
        this.fp.c(z3);
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f32695c;
        if (xvVar instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) {
            ((com.bytedance.sdk.openadsdk.core.p.xv.f) xvVar).c().c(this.ys);
        } else if (xvVar instanceof com.bytedance.sdk.openadsdk.core.p.xv.gd) {
            ((com.bytedance.sdk.openadsdk.core.p.xv.gd) xvVar).c().c(this.ys);
        }
    }

    public void c(final InterfaceC0483c interfaceC0483c) {
        this.f32695c.c(1, new ITTDownloadAdapter.OnEventLogHandler() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.c.3
            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler
            public boolean onEventLog(int i4, String str, String str2, String str3, Object obj) {
                if (i4 == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if ((str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad")) && str3.equals("click_start")) {
                        interfaceC0483c.c(c.this.f32701w, new gd());
                        c.this.f32701w = null;
                        return true;
                    }
                    if (!str2.equals("fullscreen_interstitial_ad") && !str2.equals("rewarded_video")) {
                        if (str2.equals("rewarded_video_landingpage") && "click_open".equals(str3) && u.ux(c.this.ux)) {
                            com.bytedance.sdk.openadsdk.core.a.xv.ev(c.this.ux, str2, "click_play_open", null);
                            return true;
                        }
                    } else {
                        str3.hashCode();
                        char c4 = '\uffff';
                        switch (str3.hashCode()) {
                            case -1297985154:
                                if (str3.equals("click_continue")) {
                                    c4 = 0;
                                    break;
                                }
                                break;
                            case -777040223:
                                if (str3.equals("click_open")) {
                                    c4 = 1;
                                    break;
                                }
                                break;
                            case 1682049151:
                                if (str3.equals("click_pause")) {
                                    c4 = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c4) {
                            case 0:
                                com.bytedance.sdk.openadsdk.core.a.xv.w(c.this.ux, str2, "click_play_continue", (Map<String, Object>) null);
                                break;
                            case 1:
                                com.bytedance.sdk.openadsdk.core.a.xv.ev(c.this.ux, str2, "click_play_open", null);
                                return true;
                            case 2:
                                com.bytedance.sdk.openadsdk.core.a.xv.w(c.this.ux, str2, "click_play_pause", (Map<String, Object>) null);
                                return true;
                        }
                    }
                    return true;
                }
                return true;
            }
        });
    }

    public void c(View view, InterfaceC0483c interfaceC0483c, gd gdVar) {
        if (this.f32695c != null && view != null) {
            if (view.getId() == 2114387608) {
                interfaceC0483c.c("click_play_star_level", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387629) {
                interfaceC0483c.c("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387878) {
                interfaceC0483c.c("click_play_source", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387795) {
                interfaceC0483c.c("click_play_logo", (JSONObject) null);
                return;
            } else {
                return;
            }
        }
        interfaceC0483c.c(view, gdVar);
    }

    public void c(c.InterfaceC0499c interfaceC0499c) {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f32695c;
        if (xvVar != null) {
            xvVar.c(interfaceC0499c);
        }
    }
}
