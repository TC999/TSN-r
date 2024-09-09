package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import com.bytedance.sdk.openadsdk.core.w.c.w.sr;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends w {
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35331f;
    private com.bytedance.sdk.openadsdk.core.w.w gd;

    /* renamed from: r  reason: collision with root package name */
    private c f35332r;
    private int ux;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        boolean c();

        boolean w();
    }

    public r(me meVar, Context context) {
        this.f35278c = meVar;
        this.f35279w = context;
    }

    private boolean f() {
        me meVar = this.f35278c;
        return meVar != null && meVar.x() == 1 && me.w(this.f35278c);
    }

    private boolean sr() {
        if (this.f35278c == null || ux() || !me.w(this.f35278c)) {
            return false;
        }
        if (this.ux == 0) {
            this.ux = wv.ev(this.f35278c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!isViewVisibility()=");
        sb.append(!c());
        sb.append(",isAutoPlay()=");
        sb.append(xv());
        sb.append(",!isCoverPageVisibility()=");
        sb.append(!w());
        a.w("ClickCreativeListener", sb.toString());
        if (this.ux == 5 && f() && xv() && !c() && !w()) {
            return false;
        }
        int i4 = this.ux;
        return i4 == 1 || i4 == 2 || i4 == 5;
    }

    private boolean ux() {
        return this.ev;
    }

    public void w(boolean z3) {
        this.f35331f = z3;
    }

    protected boolean xv() {
        me meVar = this.f35278c;
        if (meVar == null) {
            return true;
        }
        int r3 = ls.w().r(wv.gd(meVar));
        if (r3 != 1) {
            if (r3 == 2) {
                return ys.ux(this.f35279w) || ys.sr(this.f35279w) || ys.f(this.f35279w);
            } else if (r3 != 3) {
                return r3 != 5 || ys.sr(this.f35279w) || ys.f(this.f35279w);
            } else {
                return false;
            }
        }
        return ys.sr(this.f35279w);
    }

    private boolean w(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387663 || view.getId() == 2114387957 || view.getId() == 2114387766 || view.getId() == 2114387685 || view.getId() == 2114387625) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i4 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i4 >= viewGroup.getChildCount()) {
                return false;
            }
            if (w(viewGroup.getChildAt(i4))) {
                return true;
            }
            i4++;
        }
    }

    public void c(boolean z3) {
        this.ev = z3;
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        this.gd = wVar;
    }

    public void c(c cVar) {
        this.f35332r = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.w.w wVar;
        if (sr() && w(this.sr) && !this.f35331f && (wVar = this.gd) != null) {
            com.bytedance.sdk.openadsdk.core.w.c.c.w wVar2 = (com.bytedance.sdk.openadsdk.core.w.c.c.w) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class);
            final com.bytedance.sdk.openadsdk.core.w.c.c.ux w3 = wVar2.w();
            final com.bytedance.sdk.openadsdk.core.w.c.c.sr xv = wVar2.xv();
            final boolean xv2 = u.xv(this.f35278c);
            final String k4 = xv2 ? w3.k() : wv.c(w3.gd());
            w3.c(k4);
            w3.w(xv2);
            xv.c(this.f35278c, map);
            if (sr.c(this.f35278c, this.f35279w)) {
                new sr(this.f35278c, this.f35279w).c(k4).c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.r.1
                    @Override // com.bytedance.sdk.openadsdk.core.w.c.w.sr.c
                    public void c() {
                        r.this.c(w3, map, xv2, xv, k4);
                    }
                });
                return true;
            }
            c(w3, map, xv2, xv, k4);
            return true;
        }
        return false;
    }

    public boolean w() {
        c cVar = this.f35332r;
        if (cVar == null) {
            return false;
        }
        return cVar.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.bytedance.sdk.openadsdk.core.w.c.c.ux uxVar, Map<String, Object> map, boolean z3, com.bytedance.sdk.openadsdk.core.w.c.c.sr srVar, String str) {
        final w.c c4 = uxVar.c();
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.r.2
            @Override // java.lang.Runnable
            public void run() {
                w.c cVar = c4;
                if (cVar != null) {
                    cVar.c(((com.bytedance.sdk.openadsdk.core.w.c.c) r.this).sr, uxVar.sr());
                }
            }
        });
        if (!c(uxVar, map) ? srVar.c(map, z3, str, true, true, false) : true) {
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.gd.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(map);
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) this.gd.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class)).c(map);
        }
    }

    public boolean c() {
        c cVar = this.f35332r;
        if (cVar == null) {
            return false;
        }
        return cVar.c();
    }

    private boolean c(com.bytedance.sdk.openadsdk.core.w.c.c.ux uxVar, Map<String, Object> map) {
        String fz;
        TTLiveCommerceHelper tTLiveCommerceHelper = TTLiveCommerceHelper.getInstance();
        if (tTLiveCommerceHelper.canOpenGoodsDetailPage(this.f35278c) == 1) {
            return true;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("event_tag", uxVar != null ? uxVar.k() : "");
        com.bytedance.sdk.openadsdk.core.u.gd gdVar = this.xv;
        if (gdVar != null && (fz = gdVar.fz()) != null) {
            hashMap.put("dpa_tag", fz);
        }
        TTLiveCommerceHelper.getInstance().convertViewTagToAction(this.sr, this.f35278c.sk(), hashMap, map);
        int canOpenLive = tTLiveCommerceHelper.canOpenLive(this.f35279w, this.f35278c, hashMap);
        int i4 = canOpenLive & 255;
        if (map != null) {
            map.put("key_live_commerce_jump", Integer.valueOf(canOpenLive));
            int i5 = (canOpenLive & 65280) >> 8;
            if (i5 > 0) {
                map.put("click_saas_action", Integer.valueOf(i5));
            }
        }
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.xv) this.gd.c(com.bytedance.sdk.openadsdk.core.w.c.xv.xv.class)).c(map);
        return i4 == 0;
    }
}
