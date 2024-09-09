package com.bytedance.sdk.openadsdk.core.ugeno.r;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.c.c.b;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.adsdk.ugeno.w.h;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.adsdk.ugeno.w.j;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.xk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f35015a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    private Context f35016c;
    private w ev;

    /* renamed from: f  reason: collision with root package name */
    private me f35017f;
    private ev gd;

    /* renamed from: k  reason: collision with root package name */
    private xk f35018k;

    /* renamed from: p  reason: collision with root package name */
    private p f35019p;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.component.b f35020r;
    private sr sr;
    private xv ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.a.ux f35021w;
    private com.bytedance.adsdk.ugeno.component.b<View> xv;

    public f(Context context, com.bytedance.sdk.openadsdk.core.a.ux uxVar, me meVar, String str, int i4) {
        this.f35016c = context;
        this.f35021w = uxVar;
        this.f35017f = meVar;
        this.f35015a = str;
        this.bk = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject, List<com.bytedance.adsdk.ugeno.c.c.f> list, r rVar) {
        i iVar = new i(this.f35016c);
        g gVar = new g();
        gVar.b(this.f35016c);
        HashMap hashMap = new HashMap();
        hashMap.put("key_material", this.f35017f);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size() && i4 <= 2; i4++) {
            arrayList.add(list.get(i4).a());
        }
        xk xkVar = new xk(this.f35016c);
        this.f35018k = xkVar;
        xkVar.c(this.f35019p);
        this.f35018k.c(this.ev);
        this.f35018k.c(this.f35015a);
        this.f35018k.xv(this.bk);
        hashMap.put("key_data_list", arrayList);
        hashMap.put("key_js_object", this.f35018k);
        gVar.c(hashMap);
        iVar.j("aggPage", gVar);
        com.bytedance.adsdk.ugeno.component.b<View> c4 = iVar.c(jSONObject);
        this.xv = c4;
        if (c4 != null && list.size() > 0) {
            com.bytedance.adsdk.ugeno.component.b<View> w3 = this.xv.w("recycler_layout");
            this.f35020r = w3;
            if (w3 instanceof com.bytedance.adsdk.ugeno.c.c.b) {
                ((com.bytedance.adsdk.ugeno.c.c.b) w3).i(list);
                ((com.bytedance.adsdk.ugeno.c.c.b) this.f35020r).e(new b.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.f.2
                    @Override // com.bytedance.adsdk.ugeno.c.c.b.c
                    public void c() {
                        if (f.this.sr != null) {
                            f.this.sr.sr(f.this.f35020r);
                        }
                    }

                    @Override // com.bytedance.adsdk.ugeno.c.c.b.c
                    public void c(int i5, int i6) {
                        if (f.this.sr != null) {
                            f.this.sr.c(i5, i6);
                        }
                    }

                    @Override // com.bytedance.adsdk.ugeno.c.c.b.c
                    public void c(RecyclerView recyclerView, int i5) {
                        if (f.this.sr != null) {
                            f.this.sr.c(recyclerView, i5);
                        }
                    }

                    @Override // com.bytedance.adsdk.ugeno.c.c.b.c
                    public void c(int i5, View view, com.bytedance.adsdk.ugeno.c.c.f fVar) {
                        if (f.this.sr != null) {
                            f.this.sr.c(f.this.f35020r, i5, view, fVar);
                        }
                    }
                });
                ((com.bytedance.adsdk.ugeno.c.c.b) this.f35020r).g(new com.bytedance.adsdk.ugeno.c.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.f.3
                    @Override // com.bytedance.adsdk.ugeno.c.c.c
                    public void c(com.bytedance.adsdk.ugeno.component.b<View> bVar) {
                        if (f.this.sr != null) {
                            f.this.sr.ux(bVar);
                        }
                    }

                    @Override // com.bytedance.adsdk.ugeno.c.c.c
                    public void w(com.bytedance.adsdk.ugeno.component.b<View> bVar) {
                        if (f.this.sr != null) {
                            f.this.sr.f(bVar);
                        }
                    }
                });
            }
            iVar.h(new j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.f.4
                @Override // com.bytedance.adsdk.ugeno.w.j
                public void c(com.bytedance.adsdk.ugeno.component.b bVar) {
                    if (f.this.ux != null) {
                        f.this.ux.xv(bVar);
                    }
                }
            });
            iVar.g(this);
            JSONObject mo = this.f35017f.mo();
            if (list.size() > 0) {
                try {
                    mo.put("ugen_sub_meta", list.get(0).a());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            iVar.k(mo);
            this.f35021w.c(0L);
            if (rVar != null) {
                rVar.c(this.xv);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.ux uxVar = this.f35021w;
        if (uxVar != null) {
            uxVar.c(-1, "ugeno render fail");
        }
        if (rVar != null) {
            rVar.c(-1, "");
        }
    }

    public void c(sr srVar) {
        this.sr = srVar;
    }

    public void c(ev evVar) {
        this.gd = evVar;
    }

    public void c(xv xvVar) {
        this.ux = xvVar;
    }

    public void c(final JSONObject jSONObject, final List<com.bytedance.adsdk.ugeno.c.c.f> list, final r rVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            w(jSONObject, list, rVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.w(jSONObject, list, rVar);
                }
            });
        }
    }

    public void c(p pVar) {
        this.f35019p = pVar;
    }

    public void c(w wVar) {
        this.ev = wVar;
    }

    public com.bytedance.adsdk.ugeno.component.b c() {
        return this.f35020r;
    }

    @Override // com.bytedance.adsdk.ugeno.w.b
    public void c(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
        ev evVar;
        if (hVar == null) {
            return;
        }
        if (hVar.g() == 1) {
            w(hVar, (b.InterfaceC0363b) null, (b.a) null);
        } else if (hVar.g() != 10 || (evVar = this.gd) == null) {
        } else {
            evVar.w(hVar.a());
            xk xkVar = this.f35018k;
            if (xkVar != null) {
                xkVar.c("webviewVisible", (JSONObject) null);
            }
        }
    }

    private void w(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
        if (hVar == null || hVar.a() == null) {
            return;
        }
        JSONObject i4 = hVar.i();
        String optString = i4.optString("type");
        String optString2 = i4.optString("nodeId");
        optString.hashCode();
        if (optString.equals("onDismiss")) {
            com.bytedance.adsdk.ugeno.component.b<View> w3 = this.xv.w(optString2);
            if (w3 != null) {
                w3.w(8);
            }
        } else if (!optString.equals("onShow")) {
            xv xvVar = this.ux;
            if (xvVar != null) {
                xvVar.xv(hVar.a());
            }
        } else {
            com.bytedance.adsdk.ugeno.component.b<View> w4 = this.xv.w(optString2);
            if (w4 != null) {
                w4.w(0);
            }
        }
        final String optString3 = i4.optString("reportType");
        if (!TextUtils.isEmpty(optString3)) {
            a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.f.5
                @Override // com.bytedance.sdk.openadsdk.p.c.c
                public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("type", optString3);
                    return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("agg_click").w(jSONObject.toString());
                }
            }, "agg_click");
        }
        if (interfaceC0363b == null || hVar.f() == null) {
            return;
        }
        interfaceC0363b.c(hVar.f());
    }
}
