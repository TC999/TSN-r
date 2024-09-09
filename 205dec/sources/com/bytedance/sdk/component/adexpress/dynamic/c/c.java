package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ux;
import com.bytedance.sdk.component.adexpress.dynamic.xv.f;
import com.bytedance.sdk.component.adexpress.sr.xv;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.adexpress.w.ev;
import com.bytedance.sdk.component.adexpress.w.k;
import com.bytedance.sdk.component.adexpress.w.r;
import com.bytedance.sdk.component.adexpress.w.sr;
import com.bytedance.sdk.component.adexpress.w.t;
import com.bytedance.sdk.component.utils.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements k, sr<DynamicRootView> {

    /* renamed from: c  reason: collision with root package name */
    private DynamicRootView f29100c;
    private AtomicBoolean ev = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private bk f29101f;

    /* renamed from: r  reason: collision with root package name */
    private ScheduledFuture<?> f29102r;
    private r sr;
    private ev ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.sr.ev f29103w;
    private Context xv;

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class RunnableC0436c implements Runnable {

        /* renamed from: w  reason: collision with root package name */
        private int f29110w;

        public RunnableC0436c(int i4) {
            this.f29110w = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f29110w == 2) {
                a.w("DynamicRender", "Dynamic parse time out");
                c.this.f29100c.c(c.this.f29103w instanceof com.bytedance.sdk.component.adexpress.dynamic.sr.r ? 127 : 117, (String) null);
            }
        }
    }

    public c(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z3, com.bytedance.sdk.component.adexpress.dynamic.sr.ev evVar, bk bkVar, com.bytedance.sdk.component.adexpress.dynamic.ux.c cVar) {
        this.xv = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z3, bkVar, cVar);
        this.f29100c = dynamicRootView;
        this.f29103w = evVar;
        this.f29101f = bkVar;
        dynamicRootView.setRenderListener(this);
        this.f29101f = bkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        this.f29101f.ux().w(xv());
        JSONObject xv = this.f29101f.xv();
        if (!com.bytedance.sdk.component.adexpress.c.w.w.c(xv)) {
            int i4 = this.f29103w instanceof com.bytedance.sdk.component.adexpress.dynamic.sr.r ? 123 : 113;
            DynamicRootView dynamicRootView = this.f29100c;
            StringBuilder sb = new StringBuilder();
            sb.append("data null is ");
            sb.append(xv == null);
            dynamicRootView.c(i4, sb.toString());
            return;
        }
        this.f29103w.c(new com.bytedance.sdk.component.adexpress.dynamic.ux.w() { // from class: com.bytedance.sdk.component.adexpress.dynamic.c.c.2
            @Override // com.bytedance.sdk.component.adexpress.dynamic.ux.w
            public void c(final com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
                c.this.p();
                c.this.f29101f.ux().xv(c.this.xv());
                c.this.c(evVar);
                c.this.w(evVar);
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    c.this.xv(evVar);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.c.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.xv(evVar);
                        }
                    });
                }
                if (c.this.f29100c == null || evVar == null) {
                    return;
                }
                c.this.f29100c.setBgColor(evVar.c());
                c.this.f29100c.setBgMaterialCenterCalcColor(evVar.w());
            }
        });
        this.f29103w.c(this.f29101f);
    }

    private boolean gd() {
        DynamicRootView dynamicRootView = this.f29100c;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            ScheduledFuture<?> scheduledFuture = this.f29102r;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.f29102r.cancel(false);
                this.f29102r = null;
            }
            a.w("DynamicRender", "WebView Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public DynamicRootView f() {
        return this.f29100c;
    }

    public void sr() {
        this.f29100c.c();
    }

    public void ux() {
        this.f29100c.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        float f4;
        float f5;
        List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> k4;
        if (evVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> k5 = evVar.k();
        if (k5 == null || k5.size() <= 0) {
            f4 = 0.0f;
        } else {
            f4 = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar2 : k5) {
                if (evVar2.r() > evVar.r() - evVar2.gd() || (k4 = evVar2.k()) == null || k4.size() <= 0) {
                    f5 = 0.0f;
                } else {
                    f5 = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar3 : k4) {
                        if (evVar3.p().getType().equals("logo-union")) {
                            f5 = evVar3.p().ux();
                            f4 = (((-f5) + evVar.r()) - evVar2.r()) + evVar2.p().sr().jv();
                        }
                    }
                }
                w(evVar2);
                if (f5 <= -15.0f) {
                    evVar2.f(evVar2.gd() - f5);
                    evVar2.sr(evVar2.r() + f5);
                    for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar4 : evVar2.k()) {
                        evVar4.sr(evVar4.r() - f5);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.xv.ev a4 = evVar.a();
        if (a4 == null) {
            return;
        }
        evVar.xv(evVar.f() - a4.f());
        evVar.sr(evVar.r() - a4.r());
        if (f4 > 0.0f) {
            evVar.sr(evVar.r() - f4);
            evVar.f(evVar.gd() + f4);
            for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar5 : evVar.k()) {
                evVar5.sr(evVar5.r() + f4);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    public void c(r rVar) {
        this.sr = rVar;
        int f4 = this.f29101f.f();
        if (f4 < 0) {
            int i4 = this.f29103w instanceof com.bytedance.sdk.component.adexpress.dynamic.sr.r ? 127 : 117;
            DynamicRootView dynamicRootView = this.f29100c;
            dynamicRootView.c(i4, "time is " + f4);
            return;
        }
        this.f29102r = xv.c(new RunnableC0436c(2), f4, TimeUnit.MILLISECONDS);
        if (Looper.getMainLooper() == Looper.myLooper() && this.f29101f.gd() <= 0) {
            ev();
        } else {
            com.bytedance.sdk.component.utils.ev.w().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.ev();
                }
            }, this.f29101f.gd());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    public int xv() {
        return this.f29103w instanceof com.bytedance.sdk.component.adexpress.dynamic.sr.r ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        if (evVar == null) {
            this.f29100c.c(this.f29103w instanceof com.bytedance.sdk.component.adexpress.dynamic.sr.r ? 123 : 113, "layoutUnit is null");
            return;
        }
        this.f29101f.ux().sr(xv());
        try {
            this.f29100c.c(evVar, xv());
        } catch (Exception e4) {
            int i4 = this.f29103w instanceof com.bytedance.sdk.component.adexpress.dynamic.sr.r ? 128 : 118;
            DynamicRootView dynamicRootView = this.f29100c;
            dynamicRootView.c(i4, "exception is " + e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev> k4;
        if (evVar == null || (k4 = evVar.k()) == null || k4.size() <= 0) {
            return;
        }
        Collections.sort(k4, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.xv.ev>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.c.c.3
            @Override // java.util.Comparator
            /* renamed from: c */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar2, com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar3) {
                f sr = evVar2.p().sr();
                f sr2 = evVar3.p().sr();
                if (sr == null || sr2 == null) {
                    return 0;
                }
                return sr.kk() >= sr2.kk() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar2 : k4) {
            if (evVar2 != null) {
                c(evVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    /* renamed from: c */
    public DynamicRootView r() {
        return f();
    }

    private void c(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i4 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i4 >= viewGroup.getChildCount()) {
                    break;
                }
                c(viewGroup.getChildAt(i4));
                i4++;
            }
        }
        if (view instanceof ux) {
            ((ux) view).w();
        }
    }

    public void c(boolean z3) {
        this.f29100c.setSoundMute(z3);
    }

    public void c(ev evVar) {
        this.ux = evVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.k
    public void c(t tVar) {
        if (this.ev.get()) {
            return;
        }
        this.ev.set(true);
        if (tVar.xv() && gd()) {
            this.f29100c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.sr.c(r(), tVar);
            return;
        }
        this.sr.c(tVar.k(), tVar.p());
    }

    public void w() {
        c(r());
    }

    @Override // com.bytedance.sdk.component.adexpress.w.k
    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar) {
        ev evVar = this.ux;
        if (evVar != null) {
            evVar.c(view, i4, xvVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.k
    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar, int i5) {
        ev evVar = this.ux;
        if (evVar != null) {
            evVar.c(view, i4, xvVar, i5);
        }
    }
}
