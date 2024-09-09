package com.bytedance.msdk.core.admanager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.activity.TTTransparentActivity;
import com.bytedance.msdk.core.c;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.ref.SoftReference;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends com.bytedance.msdk.core.r.sr {
    private SoftReference<Activity> be;
    private int bs;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27813c;

    /* renamed from: e  reason: collision with root package name */
    private com.bytedance.msdk.c.ux f27814e;
    private SoftReference<Activity> eu;

    /* renamed from: g  reason: collision with root package name */
    private Handler f27815g;
    private String kk;
    private int lf;
    private int mu;
    private TTAdConstant.RitScenes tl;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f27816w;
    private int xg;
    protected boolean xv;
    private final Application.ActivityLifecycleCallbacks zr;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private Toast f27822c;

        /* renamed from: w  reason: collision with root package name */
        private final int f27823w;
        private final Handler xv;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27823w > 0) {
                this.f27822c.cancel();
                Context context = com.bytedance.msdk.core.c.getContext();
                Toast makeText = Toast.makeText(context, this.f27823w + "\u79d2\u540e\u64ad\u653e\u4e0b\u4e00\u4e2a\u5e7f\u544a", 0);
                this.f27822c = makeText;
                makeText.show();
                Handler handler = this.xv;
                handler.postDelayed(new c(this.f27822c, this.f27823w - 1, handler), 1000L);
                return;
            }
            this.f27822c.cancel();
        }

        private c(Toast toast, int i4, Handler handler) {
            this.f27822c = toast;
            this.f27823w = i4;
            this.xv = handler;
        }
    }

    public w(Context context, String str, int i4) {
        super(context, str, i4);
        this.f27813c = false;
        this.xv = true;
        this.f27816w = false;
        this.eu = new SoftReference<>(null);
        this.be = new SoftReference<>(null);
        this.bs = 0;
        this.lf = 2;
        this.xg = 0;
        this.mu = 15000;
        this.zr = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.core.admanager.w.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                Activity activity2;
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- onActivityCreated: activity: " + activity);
                String name = activity.getClass().getName();
                if (activity.getClass() == PluginActivityWrapper.class && (activity2 = ((PluginActivityWrapper) activity).mOriginActivity) != null) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- onActivityCreated: originActivity: " + activity2);
                    name = activity2.getClass().getName();
                }
                Activity activity3 = (Activity) w.this.be.get();
                if (activity3 == null && f.c(name)) {
                    w.this.be = new SoftReference(activity);
                    if (activity instanceof TTTransparentActivity) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- onActivityCreated: start transparent activity, callSuperShowAd");
                        w wVar = w.this;
                        wVar.w(wVar.f27814e, activity, w.this.tl, w.this.kk);
                    }
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- onActivityCreated: end");
                    return;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- onActivityCreated: end: " + activity3);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity) {
            }
        };
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null) {
            this.xg = wVar.bk();
            if (fp()) {
                this.lf = this.f28159r.t();
                int gd = this.f28159r.gd(i4);
                this.mu = gd;
                if (gd <= 0) {
                    this.mu = 15000;
                }
                this.f27815g = new Handler(Looper.getMainLooper());
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- inter full refresh is not enabled");
        }
    }

    private boolean fp() {
        return this.xg != 0;
    }

    private void ia() {
        if (this.f27816w) {
            return;
        }
        Application c4 = c.C0415c.c();
        if (c4 == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- app is null, \u63d2\u5168\u5c4f\u8f6e\u64ad\u76f4\u63a5return");
            return;
        }
        c4.unregisterActivityLifecycleCallbacks(this.zr);
        c4.registerActivityLifecycleCallbacks(this.zr);
        this.f27816w = true;
    }

    private int mu() {
        boolean z3;
        List<com.bytedance.msdk.c.ux> list = this.f28162u;
        if (list == null || list.size() <= 0) {
            z3 = false;
        } else {
            z3 = false;
            for (com.bytedance.msdk.c.ux uxVar : this.f28162u) {
                if (uxVar != null && uxVar.isReady(this.gd) && !uxVar.isHasShown()) {
                    if (!uxVar.isCustomAd() && !f.c(uxVar.getAdNetWorkName(), uxVar.getAdType(), uxVar.getSubAdType())) {
                        return 0;
                    }
                    z3 = true;
                }
            }
        }
        List<com.bytedance.msdk.c.ux> list2 = this.f28160s;
        if (list2 != null && list2.size() > 0) {
            for (com.bytedance.msdk.c.ux uxVar2 : this.f28160s) {
                if (uxVar2 != null && uxVar2.isReady(this.gd) && !uxVar2.isHasShown()) {
                    if (!uxVar2.isCustomAd() && !f.c(uxVar2.getAdNetWorkName(), uxVar2.getAdType(), uxVar2.getSubAdType())) {
                        return 0;
                    }
                    z3 = true;
                }
            }
        }
        List<com.bytedance.msdk.c.ux> list3 = this.fz;
        if (list3 != null && list3.size() > 0) {
            for (com.bytedance.msdk.c.ux uxVar3 : this.fz) {
                if (uxVar3 != null && uxVar3.isReady(this.gd) && !uxVar3.isHasShown()) {
                    if (!uxVar3.isCustomAd() && !f.c(uxVar3.getAdNetWorkName(), uxVar3.getAdType(), uxVar3.getSubAdType())) {
                        return 0;
                    }
                    z3 = true;
                }
            }
        }
        List<com.bytedance.msdk.core.k.p> list4 = null;
        try {
            list4 = be();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (list4 != null && list4.size() > 0) {
            for (com.bytedance.msdk.core.k.p pVar : list4) {
                String ia = pVar.ia();
                if (pVar.fz() && com.bytedance.msdk.core.ux.c.c.c().sr(this.gd, ia, u()) && com.bytedance.msdk.core.ux.c.c.c().c(ia, this.f28155k, false) == 3) {
                    if (!pVar.yu() && !f.c(pVar.t(), pVar.a(), pVar.ux())) {
                        return 0;
                    }
                    z3 = true;
                }
            }
        }
        return z3 ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg() {
        Handler handler = this.f27815g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Application c4 = c.C0415c.c();
        if (c4 != null) {
            c4.unregisterActivityLifecycleCallbacks(this.zr);
        }
    }

    protected void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e_() {
        if (fp()) {
            this.xv = true;
            this.bs++;
            final Activity activity = this.eu.get();
            final Activity activity2 = this.be.get();
            final com.bytedance.msdk.c.ux uxVar = this.f27814e;
            if (!c(activity2, activity, uxVar)) {
                xg();
                return;
            }
            Handler handler = this.f27815g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                c(this.f27815g, activity2);
                this.f27815g.postDelayed(new Runnable() { // from class: com.bytedance.msdk.core.admanager.w.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!w.this.c(activity2)) {
                            w.this.xg();
                            return;
                        }
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad \u5f00\u59cb\uff0c\u5148showingActivity finish");
                        w.this.xv = false;
                        activity2.finish();
                        uxVar.onDestroy();
                        w.this.be = new SoftReference(null);
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\u5f00\u59cb showingActivity finish end");
                        w.this.f27813c = true;
                        w wVar = w.this;
                        wVar.c(activity, wVar.tl, w.this.kk);
                    }
                }, this.mu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f_() {
        if (fp()) {
            if (this.xv) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u7528\u6237\u5173\u95ed\u4e86\u5e7f\u544a\uff0c\u505c\u6b62\u8f6e\u64ad");
                Activity activity = this.be.get();
                if (activity instanceof TTTransparentActivity) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u7528\u6237\u5173\u95ed\u4e86\u5e7f\u544a\uff0cfinish showingActivity");
                    activity.finish();
                    this.be = new SoftReference<>(null);
                }
                xg();
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u8c03\u7528finish\u89e6\u53d1\u4e86close\u56de\u8c03");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        if (fp()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u7528\u6237\u70b9\u51fb\u4e86\u5e7f\u544a\uff0c\u505c\u6b62\u8f6e\u64ad");
            xg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.sr
    public boolean r() {
        return this.f27813c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.msdk.c.ux uxVar, Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        super.c(uxVar, activity, ritScenes, str);
    }

    @Override // com.bytedance.msdk.core.r.sr
    public void c(com.bytedance.msdk.c.ux uxVar, Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (fp()) {
            ia();
            this.eu = new SoftReference<>(activity);
            this.f27814e = uxVar;
            this.tl = ritScenes;
            this.kk = str;
            if (uxVar != null && f.w(uxVar.getAdNetWorkName(), uxVar.getAdType(), uxVar.getSubAdType())) {
                Intent intent = new Intent(com.bytedance.msdk.core.c.getContext(), TTTransparentActivity.class);
                intent.addFlags(268435456);
                com.bytedance.msdk.core.c.getContext().startActivity(intent);
                return;
            }
            super.c(uxVar, activity, ritScenes, str);
            return;
        }
        super.c(uxVar, activity, ritScenes, str);
    }

    private void c(final Handler handler, final Activity activity) {
        int i4 = this.mu - 2000;
        if (i4 <= 0) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.bytedance.msdk.core.admanager.w.2
            @Override // java.lang.Runnable
            public void run() {
                if (!w.this.c(activity)) {
                    w.this.xg();
                    return;
                }
                Context context = com.bytedance.msdk.core.c.getContext();
                Toast makeText = Toast.makeText(context, "2\u79d2\u540e\u64ad\u653e\u4e0b\u4e00\u4e2a\u5e7f\u544a", 0);
                makeText.show();
                Handler handler2 = handler;
                handler2.postDelayed(new c(makeText, 1, handler2), 1000L);
            }
        }, i4);
    }

    private boolean c(Activity activity, Activity activity2, com.bytedance.msdk.c.ux uxVar) {
        if (this.bs >= this.lf) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0c\u8f6e\u64ad\u6b21\u6570\u5df2\u8fbe\u4e0a\u9650: " + this.lf);
            return false;
        } else if (activity2 == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad \u505c\u6b62\u8f6e\u64ad developerActivity\u4e3anull");
            return false;
        } else if (uxVar == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0cttBaseAd\u4e3anull\uff0c\u4e0d\u8f6e\u64ad");
            return false;
        } else if (uxVar.isCustomAd()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0c\u5c55\u793a\u7684\u662f\u81ea\u5b9a\u4e49adn\uff0c\u5219\u4e0d\u8f6e\u64ad");
            return false;
        } else if (!f.c(uxVar.getAdNetWorkName(), uxVar.getAdType(), uxVar.getSubAdType())) {
            if (activity == null) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0cshowingActivity\u662fnull\uff0c\u505c\u6b62\u8f6e\u64ad");
                com.bytedance.msdk.xv.r.c(this.f28155k, 81010);
                return false;
            }
            return true;
        } else {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0c\u5f53\u524d\u5c55\u793a\u7684\u5e7f\u544a\u4e0d\u652f\u6301\u8f6e\u64ad: " + uxVar.getAdNetWorkName() + ", adtype: " + uxVar.getAdType() + ", subType: " + uxVar.getSubAdType());
            com.bytedance.msdk.xv.r.c(this.f28155k, 81011);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            int mu = mu();
            if (mu == 2) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0c\u65e0\u4efb\u4f55\u5e7f\u544a\u53ef\u7528\uff0c\u505c\u6b62\u8f6e\u64ad");
                com.bytedance.msdk.xv.r.c(this.f28155k, 81008);
                return false;
            } else if (mu == 1) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0c\u4ec5\u6709\u81ea\u5b9a\u4e49adn\u5e7f\u544a\u53ef\u7528\uff0c\u505c\u6b62\u8f6e\u64ad");
                com.bytedance.msdk.xv.r.c(this.f28155k, 81009);
                return false;
            } else {
                int w3 = sr.w(this.gd);
                if (w3 != 0) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0c\u547d\u4e2d\u4e86\u5c55\u793a\u9891\u63a7\uff0c\u505c\u6b62\u8f6e\u64ad");
                    com.bytedance.msdk.xv.r.c(this.f28155k, w3);
                    return false;
                }
                return true;
            }
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- \u63d2\u5168\u5c4f\u8f6e\u64ad\uff0cshowingActivity\u6b63\u5728finish\u6216\u5df2\u7ecfdestroy\uff0c\u505c\u6b62\u8f6e\u64ad");
        return false;
    }
}
