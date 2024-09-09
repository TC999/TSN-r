package com.bytedance.sdk.openadsdk.core.ugeno.gd;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.c.c.d;
import com.bytedance.adsdk.ugeno.c.c.f;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.a.ux;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends com.bytedance.sdk.openadsdk.core.ugeno.r.c {

    /* renamed from: j  reason: collision with root package name */
    private int f34968j;
    private boolean ls;

    /* renamed from: q  reason: collision with root package name */
    private List<f> f34969q;

    public sr(Context context, ViewGroup viewGroup, ux uxVar, me meVar, String str, int i4) {
        super(context, viewGroup, uxVar, meVar, str, i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int S_() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int T_() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void U_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void V_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void W_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void X_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void Y_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void a_(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4, float f5, float f6, float f7, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void c(RecyclerView recyclerView, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void ev() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void f() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void f(b<View> bVar) {
        if (bVar == null) {
            return;
        }
        a.w("ShopPageInflater", "onDeActive");
        JSONObject p3 = bVar.p();
        if (p3 == null) {
            return;
        }
        int optInt = p3.optInt("image_mode");
        b<View> w3 = bVar.w("video_" + optInt);
        if (w3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) w3).q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.c
    public List<f> k() {
        this.f34969q = new ArrayList();
        JSONObject mo = this.ux.mo();
        this.f34969q.add(0, new f(mo, -1221270899));
        this.f34969q.add(new f(mo, -2134548432));
        return this.f34969q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void setPauseFromExpressView(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void sr(b<View> bVar) {
        c(bVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void ux(b<View> bVar) {
        if (bVar == null) {
            return;
        }
        if (this.f34968j <= 0 && !this.ls && TextUtils.equals(bVar.t(), "header")) {
            xv(0);
            this.ls = true;
        }
        a.w("ShopPageInflater", "onActive");
        JSONObject p3 = bVar.p();
        if (p3 == null) {
            return;
        }
        int optInt = p3.optInt("image_mode");
        b<View> w3 = bVar.w("video_" + optInt);
        if (w3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) w3;
            wVar.c(this.bk);
            wVar.fz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void w(int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long xv() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void c(int i4, int i5) {
        if (i5 > 0) {
            this.f34991p.set(1);
        }
    }

    public void xv(int i4) {
        this.f34968j = i4;
        if (i4 < 0) {
            return;
        }
        final String format = String.format("\u6d4f\u89c8%d\u79d2\u53ef\u9886\u91d1\u5e01", Integer.valueOf(i4));
        if (this.f34993r instanceof com.bytedance.adsdk.ugeno.c.c.b) {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gd.sr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.r.c) sr.this).f34993r != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((com.bytedance.adsdk.ugeno.c.c.b) ((com.bytedance.sdk.openadsdk.core.ugeno.r.c) sr.this).f34993r).xv();
                            if (recyclerView.getScrollState() != 0 || recyclerView.t()) {
                                return;
                            }
                            ((com.bytedance.adsdk.ugeno.c.c.b) ((com.bytedance.sdk.openadsdk.core.ugeno.r.c) sr.this).f34993r).d(0, "header");
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            ((com.bytedance.adsdk.ugeno.c.c.b) this.f34993r).h(new d.b() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gd.sr.2
                @Override // com.bytedance.adsdk.ugeno.c.c.d.b
                public void c(RecyclerView.j jVar, int i5) {
                    b w3 = ((d.c) jVar).e().w("count_down");
                    if (w3 instanceof com.bytedance.adsdk.ugeno.component.text.b) {
                        ((com.bytedance.adsdk.ugeno.component.text.b) w3).j(format);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.sr
    public void c(b bVar, int i4, View view, f fVar) {
        if (fVar == null || fVar.a() == null) {
            return;
        }
        int hashCode = fVar.a().hashCode();
        if (this.f34989k.get(Integer.valueOf(hashCode)) != null && this.f34989k.containsKey(Integer.valueOf(hashCode)) && this.f34989k.get(Integer.valueOf(hashCode)).booleanValue()) {
            return;
        }
        a.w("ShopPageInflater", "show key = " + hashCode + "; position = " + i4);
        c(fVar.a());
        this.f34989k.put(Integer.valueOf(hashCode), Boolean.TRUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.xv
    public void xv(b bVar) {
        me c4;
        if (bVar == null || (c4 = com.bytedance.sdk.openadsdk.core.w.c(bVar.p())) == null) {
            return;
        }
        c(c4, bVar);
    }
}
