package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.ys.w.w.ys;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends RecyclerView.c {

    /* renamed from: c  reason: collision with root package name */
    private List<ys> f34155c;

    /* renamed from: f  reason: collision with root package name */
    private int f34156f;
    private List<me> gd;

    /* renamed from: p  reason: collision with root package name */
    private ExpressOnePointFiveView f34157p;
    private w sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private Context f34159w;
    private int xv;

    /* renamed from: r  reason: collision with root package name */
    private HashSet<Integer> f34158r = new HashSet<>();
    private int ev = 0;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c extends RecyclerView.j {

        /* renamed from: c  reason: collision with root package name */
        private FrameLayout f34160c;

        public c(View view) {
            super(view);
            this.f34160c = (FrameLayout) view.findViewById(2114387613);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c();
    }

    public f(Context context, ExpressOnePointFiveView expressOnePointFiveView, int i4, int i5) {
        this.ux = 0;
        this.f34156f = 0;
        this.f34159w = context;
        this.ux = xk.ux(context, i4 + 3);
        this.f34156f = xk.ux(context, i5);
        this.f34157p = expressOnePointFiveView;
    }

    public void c(List<me> list, List<ys> list2, int i4) {
        this.gd = list;
        this.f34155c = list2;
        this.xv = i4;
        this.f34158r.clear();
        this.ev = 0;
        xv();
    }

    public int sr() {
        List<ys> list = this.f34155c;
        int size = list == null ? 0 : list.size();
        int size2 = this.f34158r.size() - this.ev;
        this.ev = this.f34158r.size();
        if (size2 < 0) {
            return 0;
        }
        return size2 < size ? size2 : size;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public long w(int i4) {
        return i4;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public RecyclerView.j c(ViewGroup viewGroup, int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c(com.bytedance.sdk.openadsdk.res.ux.ta(this.f34159w));
        }
        View ge = com.bytedance.sdk.openadsdk.res.ux.ge(this.f34159w);
        ge.setLayoutParams(new RecyclerView.p(this.ux, this.f34156f));
        return new c(ge);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public void c(RecyclerView.j jVar, int i4) {
        ys ysVar;
        w wVar;
        ys ysVar2 = null;
        if (jVar instanceof c) {
            try {
                ysVar = this.f34155c.get(i4);
            } catch (Throwable unused) {
            }
            if (ysVar == null) {
                try {
                    ysVar2 = this.f34157p.c(this.gd.get(i4), i4);
                    this.f34155c.set(i4, ysVar2);
                } catch (Throwable unused2) {
                    ysVar2 = ysVar;
                }
                ysVar = ysVar2;
            }
            if (ysVar == null) {
                return;
            }
            c cVar = (c) jVar;
            View c4 = ysVar.c();
            if (c4 != null) {
                if (c4 instanceof NativeExpressView) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("refer", "ad");
                    NativeExpressView nativeExpressView = (NativeExpressView) c4;
                    ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) nativeExpressView.getClickListener().c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
                    ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) nativeExpressView.getClickCreativeListener().c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
                }
                Object tag = c4.getTag(2114387466);
                if (!(tag instanceof Boolean) || !((Boolean) tag).booleanValue()) {
                    ysVar.c().setTag(2114387466, Boolean.TRUE);
                    ysVar.sr();
                }
                try {
                    cVar.f34160c.removeAllViews();
                    if (c4.getParent() != null) {
                        ((ViewGroup) c4.getParent()).removeView(c4);
                    }
                    cVar.f34160c.addView(c4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else if (jVar instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c cVar2 = (com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) jVar;
            cVar2.w((View) null);
            if (this.xv == 1) {
                cVar2.c("\u677e\u624b\u67e5\u770b\u66f4\u591a", "\u5de6\u6ed1\u67e5\u770b\u66f4\u591a");
            } else {
                cVar2.c("\u770b\u5b8c\u5566\uff0c\u5237\u65b0\u518d\u770b\u770b", "\u770b\u5b8c\u5566\uff0c\u5237\u65b0\u518d\u770b\u770b");
            }
            cVar2.c(this.f34156f);
        }
        try {
            if (this.xv == 2 && i4 + 1 == this.f34155c.size() && (wVar = this.sr) != null) {
                wVar.c();
            }
            if (this.f34158r == null || i4 + 1 == c()) {
                return;
            }
            this.f34158r.add(Integer.valueOf(i4));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public int c(int i4) {
        List<me> list = this.gd;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return i4 + 1 == c() ? 2 : 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public int c() {
        List<me> list = this.gd;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.gd.size() + 1;
    }

    public void c(w wVar) {
        this.sr = wVar;
    }
}
