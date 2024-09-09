package com.bytedance.sdk.openadsdk.core.ugeno.ev;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.adsdk.ugeno.w.h;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.adsdk.ugeno.w.l;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.q.w;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.sr;
import com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView;
import com.bytedance.sdk.openadsdk.core.w.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements b, l {

    /* renamed from: c  reason: collision with root package name */
    private Context f34949c;
    private gd ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.sr.c f34950f;
    private JSONObject gd;

    /* renamed from: p  reason: collision with root package name */
    private Map<String, Object> f34951p;

    /* renamed from: r  reason: collision with root package name */
    private w f34952r;
    private me sr;
    private com.bytedance.adsdk.ugeno.component.b ux;

    /* renamed from: w  reason: collision with root package name */
    private ViewGroup f34953w;
    private com.bytedance.sdk.openadsdk.core.ugeno.f.c xv;

    public c(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar, me meVar) {
        this.f34949c = context;
        this.f34953w = viewGroup;
        this.xv = cVar;
        this.sr = meVar;
    }

    public void w() {
        PageWebView.c(this.gd);
    }

    public void c(com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar) {
        this.f34950f = cVar;
    }

    public void c(DownloadListener downloadListener) {
        PageWebView.c(this.gd, downloadListener);
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar = this.xv;
        if (cVar == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar2 = this.f34950f;
            if (cVar2 != null) {
                cVar2.c(-1);
                return;
            }
            return;
        }
        String c4 = cVar.c();
        String w3 = this.xv.w();
        this.xv.xv();
        JSONObject c5 = sr.c().c(c4, w3);
        if (c5 == null) {
            com.bytedance.sdk.openadsdk.core.q.w.c(this.xv, new w.InterfaceC0506w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ev.c.1
                @Override // com.bytedance.sdk.openadsdk.core.q.w.InterfaceC0506w
                public void c(JSONObject jSONObject) {
                    c.this.c(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.w.InterfaceC0506w
                public void c() {
                    if (c.this.f34950f != null) {
                        c.this.f34950f.c(-1);
                    }
                }
            });
        } else {
            c(c5);
        }
    }

    public void c(final JSONObject jSONObject) {
        final i iVar = new i(this.f34949c);
        final JSONObject mo = this.sr.mo();
        this.gd = mo;
        g gVar = new g();
        gVar.b(this.f34949c);
        HashMap hashMap = new HashMap();
        hashMap.put("key_reward_page", this.f34951p);
        gVar.c(hashMap);
        iVar.j("reward_page", gVar);
        iVar.g(this);
        q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ev.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.ux = iVar.c(jSONObject);
                if (c.this.ux == null) {
                    if (c.this.f34950f != null) {
                        c.this.f34950f.c(-1);
                        return;
                    }
                    return;
                }
                iVar.k(mo);
                c.this.f34953w.addView(c.this.ux.gd(), new FrameLayout.LayoutParams(c.this.ux.fp(), c.this.ux.ia()));
                if (c.this.f34950f != null) {
                    c.this.f34950f.c(c.this.ux.gd());
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.w.b
    public void c(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
        if (hVar != null && hVar.g() == 1) {
            c(hVar, hVar.i());
        }
    }

    private void c(h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("type");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        optString.hashCode();
        if (!optString.equals("clickEvent")) {
            if (optString.equals("openPolicy")) {
                f.c(this.f34949c, this.sr);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.w.w wVar = this.f34952r;
        if (wVar != null) {
            wVar.c(hVar.a().gd(), this.ev);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        this.f34952r = wVar;
    }

    @Override // com.bytedance.adsdk.ugeno.w.l
    public void c(com.bytedance.adsdk.ugeno.component.b bVar, MotionEvent motionEvent) {
        this.ev.w(motionEvent.getDeviceId());
        this.ev.c(motionEvent.getToolType(0));
        this.ev.xv(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.ev.xv(motionEvent.getRawX());
                this.ev.sr(motionEvent.getRawY());
                this.ev.w(System.currentTimeMillis());
                return;
            } else if (actionMasked != 2) {
                return;
            } else {
                this.ev.xv(motionEvent.getRawX());
                this.ev.sr(motionEvent.getRawY());
                return;
            }
        }
        this.ev.sr((int) motionEvent.getRawX());
        this.ev.ux((int) motionEvent.getRawY());
        this.ev.c(motionEvent.getRawX());
        this.ev.w(motionEvent.getRawY());
        this.ev.c(System.currentTimeMillis());
        this.ev.c(motionEvent.getToolType(0));
        this.ev.w(motionEvent.getDeviceId());
        this.ev.xv(motionEvent.getSource());
        this.ev.c(true);
        com.bytedance.sdk.openadsdk.core.eq.q.c(motionEvent);
    }

    public void c(Map<String, Object> map) {
        this.f34951p = map;
    }
}
