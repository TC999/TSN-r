package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.r.r;
import com.bytedance.sdk.openadsdk.core.widget.ev;
import com.bytedance.sdk.openadsdk.core.xk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements b, n.c, w {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.component.b<View> f34916c;
    private AtomicBoolean ev = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final n f34917f = new n(Looper.getMainLooper(), this);

    /* renamed from: r  reason: collision with root package name */
    private r f34918r;
    private xk sr;
    private me ux;

    /* renamed from: w  reason: collision with root package name */
    private Context f34919w;
    private ev.c xv;

    public c(Context context, me meVar) {
        this.f34919w = context;
        this.ux = meVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject, JSONObject jSONObject2, r rVar) {
        this.f34918r = rVar;
        i iVar = new i(this.f34919w);
        g gVar = new g();
        gVar.b(this.f34919w);
        HashMap hashMap = new HashMap();
        xk xkVar = new xk(this.f34919w);
        this.sr = xkVar;
        xkVar.c(this.xv);
        this.sr.c(this);
        this.sr.w(c(jSONObject2));
        String c4 = wv.c(this.ux);
        this.sr.xv(wv.c(c4));
        this.sr.c(c4);
        hashMap.put("key_js_object", this.sr);
        hashMap.put("key_material", this.ux);
        gVar.d(jSONObject2);
        gVar.c(hashMap);
        iVar.j("easy_dl_dialog", gVar);
        com.bytedance.adsdk.ugeno.component.b<View> c5 = iVar.c(jSONObject);
        this.f34916c = c5;
        if (c5 == null) {
            r rVar2 = this.f34918r;
            if (rVar2 != null) {
                rVar2.c(-1, "UGenWidget is null");
                return;
            }
            return;
        }
        iVar.g(this);
        iVar.k(jSONObject2);
        n nVar = this.f34917f;
        if (nVar != null) {
            nVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void c(ev.c cVar) {
        this.xv = cVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
        if (r2.equals("openAppFunctionDesc") == false) goto L12;
     */
    @Override // com.bytedance.adsdk.ugeno.w.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(com.bytedance.adsdk.ugeno.w.h r2, com.bytedance.adsdk.ugeno.w.b.InterfaceC0363b r3, com.bytedance.adsdk.ugeno.w.b.a r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L7f
            com.bytedance.sdk.openadsdk.core.widget.ev$c r3 = r1.xv
            if (r3 != 0) goto L8
            goto L7f
        L8:
            int r3 = r2.g()
            r4 = 1
            if (r3 != r4) goto L7f
            org.json.JSONObject r2 = r2.i()
            if (r2 != 0) goto L16
            return
        L16:
            java.lang.String r3 = "type"
            java.lang.String r2 = r2.optString(r3)
            r2.hashCode()
            r3 = -1
            int r0 = r2.hashCode()
            switch(r0) {
                case -1822902106: goto L53;
                case -459025504: goto L4a;
                case -267096736: goto L3f;
                case 7917298: goto L34;
                case 1237425033: goto L29;
                default: goto L27;
            }
        L27:
            r4 = -1
            goto L5d
        L29:
            java.lang.String r4 = "openAppPolicy"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L32
            goto L27
        L32:
            r4 = 4
            goto L5d
        L34:
            java.lang.String r4 = "downloadEvent"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L3d
            goto L27
        L3d:
            r4 = 3
            goto L5d
        L3f:
            java.lang.String r4 = "closeDialog"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L48
            goto L27
        L48:
            r4 = 2
            goto L5d
        L4a:
            java.lang.String r0 = "openAppFunctionDesc"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5d
            goto L27
        L53:
            java.lang.String r4 = "openAppPermission"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L5c
            goto L27
        L5c:
            r4 = 0
        L5d:
            r2 = 0
            switch(r4) {
                case 0: goto L7a;
                case 1: goto L74;
                case 2: goto L6e;
                case 3: goto L68;
                case 4: goto L62;
                default: goto L61;
            }
        L61:
            goto L7f
        L62:
            com.bytedance.sdk.openadsdk.core.widget.ev$c r3 = r1.xv
            r3.sr(r2)
            goto L7f
        L68:
            com.bytedance.sdk.openadsdk.core.widget.ev$c r3 = r1.xv
            r3.c(r2)
            goto L7f
        L6e:
            com.bytedance.sdk.openadsdk.core.widget.ev$c r3 = r1.xv
            r3.xv(r2)
            goto L7f
        L74:
            com.bytedance.sdk.openadsdk.core.widget.ev$c r2 = r1.xv
            r2.c()
            goto L7f
        L7a:
            com.bytedance.sdk.openadsdk.core.widget.ev$c r3 = r1.xv
            r3.w(r2)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ugeno.c.c(com.bytedance.adsdk.ugeno.w.h, com.bytedance.adsdk.ugeno.w.b$b, com.bytedance.adsdk.ugeno.w.b$a):void");
    }

    public void c(final JSONObject jSONObject, final JSONObject jSONObject2, final r rVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            w(jSONObject, jSONObject2, rVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.w(jSONObject, jSONObject2, rVar);
                }
            });
        }
    }

    private JSONObject c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("easy_dl_dialog")) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("app_name", optJSONObject.opt("app_name"));
            jSONObject2.put("app_version", optJSONObject.opt("app_version"));
            jSONObject2.put("developer_name", optJSONObject.opt("developer_name"));
            jSONObject2.put("package_name", optJSONObject.opt("package_name"));
            jSONObject2.put("score", optJSONObject.opt("score"));
            jSONObject2.put(CampaignEx.JSON_KEY_ICON_URL, optJSONObject.opt(CampaignEx.JSON_KEY_ICON_URL));
            jSONObject2.put("description", optJSONObject.opt("description"));
            jSONObject2.put("creative_tags", optJSONObject.opt("creative_tags"));
            jSONObject2.put("easy_pl_material", optJSONObject.opt("easy_pl_material"));
            jSONObject3.put("ugen_download_dialog", jSONObject2);
            return jSONObject3;
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    private void w() {
        n nVar = this.f34917f;
        if (nVar == null) {
            return;
        }
        nVar.removeMessages(1);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message == null || message.what != 1 || this.ev.get()) {
            return;
        }
        if (this.f34918r != null) {
            this.ev.set(true);
            this.f34918r.c(10, "load time out");
        }
        w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
    public void c() {
        w();
        if (this.ev.get() || this.f34918r == null) {
            return;
        }
        this.ev.set(true);
        this.f34918r.c(this.f34916c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
    public void c(int i4, String str) {
        w();
        if (this.ev.get() || this.f34918r == null) {
            return;
        }
        this.ev.set(true);
        this.f34918r.c(i4, str);
    }
}
