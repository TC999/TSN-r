package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import com.bytedance.sdk.openadsdk.core.w.c.xv.sr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j {
    private ViewGroup bk;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.u.me f33770c;
    private com.bytedance.sdk.openadsdk.j.c.w.c.c ev;
    private com.bytedance.sdk.openadsdk.j.c.w.c.c fp;
    private com.bytedance.sdk.openadsdk.core.p.w.c fz;
    private long gd;

    /* renamed from: j  reason: collision with root package name */
    private View f33773j;

    /* renamed from: q  reason: collision with root package name */
    private View f33776q;

    /* renamed from: r  reason: collision with root package name */
    private String f33777r;

    /* renamed from: s  reason: collision with root package name */
    private com.bytedance.sdk.component.utils.q f33778s;
    private final Context sr;

    /* renamed from: t  reason: collision with root package name */
    private WeakReference<ViewGroup> f33779t;
    private com.bytedance.sdk.openadsdk.ys.w.w.t ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.xv f33781w;
    private com.bytedance.sdk.openadsdk.core.p.w.xv xv;
    private View ys;

    /* renamed from: f  reason: collision with root package name */
    private List<View> f33771f = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private Double f33775p = null;

    /* renamed from: k  reason: collision with root package name */
    private AtomicBoolean f33774k = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f33769a = new AtomicBoolean(false);
    private int ia = 5;

    /* renamed from: u  reason: collision with root package name */
    private volatile long f33780u = 0;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f33772i = true;

    public j(Context context, com.bytedance.sdk.openadsdk.ys.w.w.t tVar, com.bytedance.sdk.openadsdk.core.u.me meVar, String str) {
        this.f33777r = "embeded_ad";
        this.ux = tVar;
        this.f33770c = meVar;
        this.sr = context;
        this.f33777r = str;
        if (meVar.v() == 4) {
            this.f33781w = com.bytedance.sdk.openadsdk.core.p.xv.c(context, meVar, this.f33777r);
            com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(context, meVar, this.f33777r);
            this.xv = c4;
            if (c4 instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) {
                ((com.bytedance.sdk.openadsdk.core.p.xv.f) c4).c().xv(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> sr() {
        HashMap hashMap = new HashMap();
        if (this.f33771f != null) {
            JSONArray jSONArray = new JSONArray();
            for (View view : this.f33771f) {
                if (view != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("width", view.getWidth());
                        jSONObject.put("height", view.getHeight());
                        jSONObject.put("alpha", view.getAlpha());
                    } catch (Throwable unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
            hashMap.put("image_view", jSONArray.toString());
        }
        if (this.bk != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", this.bk.getWidth());
                jSONObject2.put("height", this.bk.getHeight());
                jSONObject2.put("alpha", this.bk.getAlpha());
            } catch (Throwable unused2) {
            }
            hashMap.put("root_view", jSONObject2.toString());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        com.bytedance.sdk.openadsdk.core.u.me meVar;
        com.bytedance.sdk.openadsdk.core.u.p ut;
        if (this.ia == 5 && (meVar = this.f33770c) != null && (ut = meVar.ut()) != null && ut.c() == 1) {
            final float w3 = ut.w();
            final float xv = ut.xv();
            if (this.f33778s == null) {
                this.f33778s = new com.bytedance.sdk.component.utils.q(ls.getContext(), 1);
            }
            this.f33778s.c(this.f33770c.mc());
            this.f33778s.c(this.f33770c.g());
            this.f33778s.c(new q.c() { // from class: com.bytedance.sdk.openadsdk.core.j.10
                @Override // com.bytedance.sdk.component.utils.q.c
                public void c(int i4) {
                    if (i4 == 1 && j.this.f33772i && wx.c(j.this.bk)) {
                        com.bytedance.sdk.openadsdk.core.eq.eq.c(j.this.f33779t, w3, xv, j.this.f33780u);
                    }
                }
            });
            this.f33778s.c();
        }
    }

    private View w(ViewGroup viewGroup) {
        Object obj;
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            Object tag = childAt.getTag();
            String str = "";
            if ((tag instanceof Map) && (obj = ((Map) tag).get("tag")) != null) {
                str = obj.toString();
            }
            if ("shake_compat".equals(str)) {
                return childAt;
            }
        }
        return null;
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.w.t tVar) {
        this.ux = tVar;
    }

    public void c(Activity activity) {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f33781w;
        if (xvVar != null) {
            xvVar.c(activity);
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar2 = this.xv;
        if (xvVar2 != null) {
            xvVar2.c(activity);
        }
    }

    public void c(View view, int i4) {
        com.bytedance.sdk.openadsdk.j.c.w.c.c cVar = this.ev;
        if (cVar != null) {
            cVar.onAdCreativeClick(view, this.ux);
        }
    }

    public com.bytedance.sdk.openadsdk.core.p.w.xv c() {
        return this.f33781w;
    }

    public void w() {
        WeakReference<ViewGroup> weakReference = this.f33779t;
        if (weakReference != null) {
            weakReference.clear();
        }
        final ViewGroup viewGroup = this.bk;
        final View view = this.f33776q;
        if (viewGroup != null && view != null) {
            com.bytedance.sdk.component.utils.ev.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.2
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view);
                }
            });
        }
        final View view2 = this.f33773j;
        if (viewGroup != null && view2 != null) {
            com.bytedance.sdk.component.utils.ev.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.3
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view2);
                }
            });
        }
        com.bytedance.sdk.component.utils.q qVar = this.f33778s;
        if (qVar != null) {
            qVar.w();
        }
    }

    public void c(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, final com.bytedance.sdk.openadsdk.j.c.w.c.c cVar, final com.bytedance.sdk.openadsdk.j.c.w.c.c cVar2) {
        this.ev = cVar;
        this.bk = viewGroup;
        this.f33779t = new WeakReference<>(this.bk);
        this.ys = view;
        this.fp = cVar2;
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f33781w;
        if (xvVar != null) {
            xvVar.sr();
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar2 = this.xv;
        if (xvVar2 != null) {
            xvVar2.sr();
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f33770c);
        c(viewGroup);
        EmptyView xv = xv(viewGroup);
        if (xv == null) {
            com.bytedance.sdk.openadsdk.core.u.me meVar = this.f33770c;
            EmptyView emptyView = new EmptyView(this.sr, viewGroup, meVar != null ? meVar.ek() : 1000) { // from class: com.bytedance.sdk.openadsdk.core.j.1
                @Override // android.view.View
                protected void onVisibilityChanged(View view2, int i4) {
                    super.onVisibilityChanged(view2, i4);
                    com.bytedance.sdk.component.utils.q qVar = j.this.f33778s;
                    if (qVar == null) {
                        return;
                    }
                    try {
                        j.this.f33772i = isShown();
                        if (isShown()) {
                            qVar.c();
                        } else {
                            qVar.w();
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            emptyView.setPreloadMainKey(this.f33770c);
            viewGroup.addView(emptyView);
            xv = emptyView;
        }
        xv.c();
        xv.setRefClickViews(list2);
        xv.setRefCreativeViews(list3);
        xv.setRefDirectDownloadViews(list4);
        this.f33776q = xv;
        this.f33771f = list;
        Context context = this.sr;
        com.bytedance.sdk.openadsdk.core.u.me meVar2 = this.f33770c;
        String str = this.f33777r;
        com.bytedance.sdk.openadsdk.core.w.w wVar = new com.bytedance.sdk.openadsdk.core.w.w(context, meVar2, str, com.bytedance.sdk.openadsdk.core.eq.wv.c(str));
        c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        HashMap hashMap = new HashMap();
        hashMap.put("click_type", 1);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
        wVar.c(viewGroup);
        wVar.w(view);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f33781w);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.ux);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.j.4
            @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
            public void c(View view2, int i4) {
                com.bytedance.sdk.openadsdk.j.c.w.c.c cVar3 = cVar;
                if (cVar3 != null) {
                    cVar3.onAdClicked(view2, j.this.ux);
                }
                com.bytedance.sdk.openadsdk.j.c.w.c.c cVar4 = cVar2;
                if (cVar4 != null) {
                    cVar4.onAdCreativeClick(view2, j.this.ux);
                }
            }
        });
        Context context2 = this.sr;
        com.bytedance.sdk.openadsdk.core.u.me meVar3 = this.f33770c;
        String str2 = this.f33777r;
        com.bytedance.sdk.openadsdk.core.w.c cVar3 = new com.bytedance.sdk.openadsdk.core.w.c(context2, meVar3, str2, com.bytedance.sdk.openadsdk.core.eq.wv.c(str2));
        c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) cVar3.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("click_type", 1);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar3.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap2);
        cVar3.c(viewGroup);
        cVar3.w(view);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar3.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f33781w);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar3.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.ux);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar3.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.j.5
            @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
            public void c(View view2, int i4) {
                com.bytedance.sdk.openadsdk.j.c.w.c.c cVar4 = cVar;
                if (cVar4 != null) {
                    cVar4.onAdCreativeClick(view2, j.this.ux);
                }
                com.bytedance.sdk.openadsdk.j.c.w.c.c cVar5 = cVar2;
                if (cVar5 != null) {
                    cVar5.onAdCreativeClick(view2, j.this.ux);
                }
            }
        });
        Context context3 = this.sr;
        com.bytedance.sdk.openadsdk.core.u.me meVar4 = this.f33770c;
        String str3 = this.f33777r;
        com.bytedance.sdk.openadsdk.core.w.c cVar4 = new com.bytedance.sdk.openadsdk.core.w.c(context3, meVar4, str3, com.bytedance.sdk.openadsdk.core.eq.wv.c(str3));
        c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) cVar4.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("click_type", 1);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar4.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap3);
        cVar4.c(viewGroup);
        cVar4.w(view);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar4.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar4.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.ux);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar4.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.j.6
            @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
            public void c(View view2, int i4) {
                com.bytedance.sdk.openadsdk.j.c.w.c.c cVar5 = cVar;
                if (cVar5 != null) {
                    cVar5.onAdCreativeClick(view2, j.this.ux);
                }
                com.bytedance.sdk.openadsdk.j.c.w.c.c cVar6 = cVar2;
                if (cVar6 != null) {
                    cVar6.onAdCreativeClick(view2, j.this.ux);
                }
                if (j.this.f33770c != null) {
                    j.this.f33770c.c(true);
                }
            }
        });
        xv.c(list2, wVar);
        xv.c(list3, cVar3);
        xv.c(list4, cVar4);
        xv.setCallback(new EmptyView.c() { // from class: com.bytedance.sdk.openadsdk.core.j.7
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(boolean z3) {
                if (j.this.f33781w != null) {
                    if (z3) {
                        j.this.f33781w.sr();
                    } else {
                        j.this.f33781w.ux();
                    }
                }
                if (j.this.xv != null) {
                    if (z3) {
                        j.this.xv.sr();
                    } else {
                        j.this.xv.ux();
                    }
                }
                j jVar = j.this;
                jVar.gd = com.bytedance.sdk.openadsdk.core.a.xv.c(jVar.gd, z3, j.this.f33770c, j.this.f33777r);
                if (j.this.f33778s != null) {
                    if (z3) {
                        j.this.f33778s.c();
                        return;
                    }
                    try {
                        if (j.this.f33778s != null) {
                            j.this.f33778s.w();
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.a.f("ShakeUtils", "onPause error:" + th.getMessage());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void w() {
                if (j.this.f33781w != null) {
                    j.this.f33781w.f();
                }
                if (j.this.xv != null) {
                    j.this.xv.f();
                }
                try {
                    if (j.this.f33778s != null) {
                        j.this.f33778s.w();
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.a.f("ShakeUtils", "onPause error:" + th.getMessage());
                }
                j.this.f33774k.set(false);
                j.this.f33769a.set(false);
                j jVar = j.this;
                jVar.gd = com.bytedance.sdk.openadsdk.core.a.xv.c(jVar.gd, j.this.f33770c, j.this.f33777r);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c() {
                if (j.this.f33781w != null) {
                    j.this.f33781w.xv();
                    j.this.f33781w.c(j.this.fz);
                }
                if (j.this.xv != null) {
                    j.this.xv.xv();
                    j.this.xv.c(j.this.fz);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(View view2) {
                j.this.gd = System.currentTimeMillis();
                Map sr = j.this.sr();
                j.this.f33774k.set(true);
                if (!j.this.f33769a.get()) {
                    com.bytedance.sdk.openadsdk.core.a.xv.c(j.this.f33770c, j.this.f33777r, sr, j.this.f33775p);
                }
                com.bytedance.sdk.openadsdk.j.c.w.c.c cVar5 = cVar;
                if (cVar5 != null) {
                    cVar5.onAdShow(j.this.ux);
                    j.this.f33780u = System.currentTimeMillis();
                    j.this.xv();
                }
            }
        });
        xv.setNeedCheckingShow(true);
    }

    private EmptyView xv(ViewGroup viewGroup) {
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void c(int i4) {
        this.ia = i4;
    }

    private void c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        Context context = this.sr;
        com.bytedance.sdk.openadsdk.core.u.me meVar = this.f33770c;
        String str = this.f33777r;
        com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(context, meVar, str, com.bytedance.sdk.openadsdk.core.eq.wv.c(str));
        c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        cVar.c(this.bk);
        cVar.w(this.ys);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f33781w);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.ux);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.j.8
            @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
            public void c(View view, int i4) {
                if (j.this.ev != null) {
                    j.this.ev.onAdCreativeClick(view, j.this.ux);
                }
                if (j.this.fp != null) {
                    j.this.fp.onAdCreativeClick(view, j.this.ux);
                }
            }
        });
        View w3 = w(viewGroup);
        if (w3 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("tag", "shake_compat");
            hashMap.put("click_listener", cVar);
            w3.setTag(hashMap);
            this.f33773j = w3;
            return;
        }
        View view = new View(this.sr);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.j.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                try {
                    if (j.this.f33778s != null) {
                        j.this.f33778s.w();
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.a.f("ShakeUtils", "onPause error:" + th.getMessage());
                }
            }
        });
        HashMap hashMap2 = new HashMap();
        hashMap2.put("tag", "shake_compat");
        hashMap2.put("click_listener", cVar);
        view.setTag(hashMap2);
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(view);
        this.f33773j = view;
    }

    public void c(final com.bytedance.sdk.openadsdk.core.w.c.xv.sr srVar) {
        srVar.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.j.11
            @Override // com.bytedance.sdk.openadsdk.core.w.c.xv.sr.c
            public boolean c() {
                srVar.w(j.this.sr());
                srVar.c(j.this.f33777r);
                srVar.c(j.this.f33775p);
                boolean z3 = j.this.f33774k.get();
                j.this.f33769a.set(!z3);
                return z3;
            }
        });
    }

    public void c(com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
        this.fz = cVar;
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f33781w;
        if (xvVar != null) {
            xvVar.c(cVar);
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar2 = this.xv;
        if (xvVar2 != null) {
            xvVar2.c(cVar);
        }
    }

    public void c(Double d4) {
        this.f33775p = d4;
    }
}
